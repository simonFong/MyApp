package com.simon.app.bean;

import java.util.List;

/**
 * Created by fengzimin  on  2018/06/29.
 * interface by
 */
public class ComicBean {

    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "ret_code=" + ret_code +
                    ", result=" + result +
                    '}';
        }

        private int ret_code;
        private List<ResultBean> result;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean{
            /**
             * content : 漫威继金刚狼之后，超人气角色团体“神奇四侠”复活回归，漫威公开了重启版《神奇四侠》角色封面，性感的霹雳火、骚气的神奇先生、妩媚的隐形女，以及硬朗的石头人悉数登场。
             * cover : https://imgs.gamersky.com/upimg/2018/201806282133241852.jpg
             * title : 《神奇四侠》复活造型大变！性感男神大胸超吸睛
             * time : 2018-06-28 20:45:39
             * url : http://acg.gamersky.com/news/201806/1066751.shtml
             */

            private String content;
            private String cover;
            private String title;
            private String time;
            private String url;

            @Override
            public String toString() {
                return "ResultBean{" +
                        "content='" + content + '\'' +
                        ", cover='" + cover + '\'' +
                        ", title='" + title + '\'' +
                        ", time='" + time + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    @Override
    public String toString() {
        return "ComicBean{" +
                "showapi_res_error='" + showapi_res_error + '\'' +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_body=" + showapi_res_body +
                '}';
    }
}
