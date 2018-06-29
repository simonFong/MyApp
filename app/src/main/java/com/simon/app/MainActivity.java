package com.simon.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.Converter;
import com.lzy.okrx2.adapter.ObservableBody;
import com.simon.app.activity.ComicDetailActivity;
import com.simon.app.adapter.MainAdapter;
import com.simon.app.bean.ComicBean;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.button)
    Button mButton;
    @InjectView(R.id.tv_text)
    TextView mTvText;
    @InjectView(R.id.recycleview)
    RecyclerView mRecycleview;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initRecycler();
    }

    private void initRecycler() {
        mRecycleview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        mMainAdapter = new MainAdapter(this);
        mRecycleview.setAdapter(mMainAdapter);
        mMainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ComicBean.ShowapiResBodyBean.ResultBean bean) {
                Intent intent = new Intent(MainActivity.this, ComicDetailActivity.class);
                intent.putExtra("url", bean.getUrl());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        OkGo.<ComicBean>post("http://route.showapi.com/1061-1")
                .params("showapi_appid", "68381")
                .params("showapi_sign", "0B89353FA973F81620C983F411489A17")
                .converter(new Converter<ComicBean>() {
                    @Override
                    public ComicBean convertResponse(Response response) throws Throwable {
                        ResponseBody body = response.body();
                        if (body == null)
                            return null;
                        String s = body.string().toString();
                        Gson gson = new Gson();
                        ComicBean comicBean = gson.fromJson(s, ComicBean.class);
                        return comicBean;
                    }
                }).adapt(new ObservableBody<ComicBean>())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.e("simon", disposable.toString());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("simon", d.toString());
                    }

                    @Override
                    public void onNext(ComicBean comicBean) {
                        Log.e("simon", comicBean.toString());
                        mTvText.setText(comicBean.toString());
                        mMainAdapter.updateData(comicBean.getShowapi_res_body().getResult());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("simon", e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        initData();
    }
}
