package com.simon.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simon.app.R;
import com.simon.app.bean.ComicBean;

import java.util.List;

/**
 * Created by fengzimin  on  2018/06/29.
 * interface by
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private  List<ComicBean.ShowapiResBodyBean.ResultBean> mDatas;
    private  Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public MainAdapter(Context context) {
        mContext = context;
    }

    public void updateData(List<ComicBean.ShowapiResBodyBean.ResultBean> data) {
        this.mDatas = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .item_main_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ComicBean.ShowapiResBodyBean.ResultBean bean = mDatas.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(position,bean);
            }
        });


        Glide.with(mContext).load(bean.getCover()).into(holder.mPicIv);
        holder.mTitleTv.setText(bean.getTitle());
        holder.mContentTv.setText(bean.getContent());
    }


    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView mTitleTv;
        private  TextView mContentTv;
        private  ImageView mPicIv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.tv_title);
            mContentTv = itemView.findViewById(R.id.tv_content);
            mPicIv = itemView.findViewById(R.id.iv_pic);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, ComicBean.ShowapiResBodyBean.ResultBean bean);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
