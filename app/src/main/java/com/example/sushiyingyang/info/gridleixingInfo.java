package com.example.sushiyingyang.info;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */

public class gridleixingInfo {

    /**
     * Code : 1
     * Message : 请求成功！
     * Result : {"list":[{"id":"78","title":"小麦","pic":"78.jpg","type":"4","img_url":"Uploads/Vege/78.jpg"},{"id":"33","title":"豆腐","pic":"33.jpg","type":"4","img_url":"Uploads/Vege/33.jpg"},{"id":"30","title":"大米","pic":"30.jpg","type":"4","img_url":"Uploads/Vege/30.jpg"},{"id":"29","title":"荞麦","pic":"29.jpg","type":"4","img_url":"Uploads/Vege/29.jpg"},{"id":"28","title":"玉米","pic":"28.jpg","type":"4","img_url":"Uploads/Vege/28.jpg"},{"id":"27","title":"糯米","pic":"27.jpg","type":"4","img_url":"Uploads/Vege/27.jpg"},{"id":"25","title":"薏米","pic":"25.jpg","type":"4","img_url":"Uploads/Vege/25.jpg"},{"id":"23","title":"黑米","pic":"23.jpg","type":"4","img_url":"Uploads/Vege/23.jpg"},{"id":"20","title":"红豆","pic":"20.jpg","type":"4","img_url":"Uploads/Vege/20.jpg"},{"id":"15","title":"芝麻","pic":"15.jpg","type":"4","img_url":"Uploads/Vege/15.jpg"},{"id":"13","title":"绿豆","pic":"13.jpg","type":"4","img_url":"Uploads/Vege/13.jpg"},{"id":"12","title":"燕麦","pic":"12.jpg","type":"4","img_url":"Uploads/Vege/12.jpg"},{"id":"10","title":"小米","pic":"10.jpg","type":"4","img_url":"Uploads/Vege/10.jpg"},{"id":"7","title":"黄豆","pic":"7.jpg","type":"4","img_url":"Uploads/Vege/7.jpg"},{"id":"3","title":"黑豆","pic":"3.jpg","type":"4","img_url":"Uploads/Vege/3.jpg"}],"total":"15","totalpage":"0","nowpage":"1"}
     */

    private int Code;
    private String Message;
    private ResultBean Result;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * list : [{"id":"78","title":"小麦","pic":"78.jpg","type":"4","img_url":"Uploads/Vege/78.jpg"},{"id":"33","title":"豆腐","pic":"33.jpg","type":"4","img_url":"Uploads/Vege/33.jpg"},{"id":"30","title":"大米","pic":"30.jpg","type":"4","img_url":"Uploads/Vege/30.jpg"},{"id":"29","title":"荞麦","pic":"29.jpg","type":"4","img_url":"Uploads/Vege/29.jpg"},{"id":"28","title":"玉米","pic":"28.jpg","type":"4","img_url":"Uploads/Vege/28.jpg"},{"id":"27","title":"糯米","pic":"27.jpg","type":"4","img_url":"Uploads/Vege/27.jpg"},{"id":"25","title":"薏米","pic":"25.jpg","type":"4","img_url":"Uploads/Vege/25.jpg"},{"id":"23","title":"黑米","pic":"23.jpg","type":"4","img_url":"Uploads/Vege/23.jpg"},{"id":"20","title":"红豆","pic":"20.jpg","type":"4","img_url":"Uploads/Vege/20.jpg"},{"id":"15","title":"芝麻","pic":"15.jpg","type":"4","img_url":"Uploads/Vege/15.jpg"},{"id":"13","title":"绿豆","pic":"13.jpg","type":"4","img_url":"Uploads/Vege/13.jpg"},{"id":"12","title":"燕麦","pic":"12.jpg","type":"4","img_url":"Uploads/Vege/12.jpg"},{"id":"10","title":"小米","pic":"10.jpg","type":"4","img_url":"Uploads/Vege/10.jpg"},{"id":"7","title":"黄豆","pic":"7.jpg","type":"4","img_url":"Uploads/Vege/7.jpg"},{"id":"3","title":"黑豆","pic":"3.jpg","type":"4","img_url":"Uploads/Vege/3.jpg"}]
         * total : 15
         * totalpage : 0
         * nowpage : 1
         */

        private String total;
        private String totalpage;
        private String nowpage;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(String totalpage) {
            this.totalpage = totalpage;
        }

        public String getNowpage() {
            return nowpage;
        }

        public void setNowpage(String nowpage) {
            this.nowpage = nowpage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 78
             * title : 小麦
             * pic : 78.jpg
             * type : 4
             * img_url : Uploads/Vege/78.jpg
             */

            private String id;
            private String title;
            private String pic;
            private String type;
            private String img_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
