package com.example.sushiyingyang.info;

import java.util.List;

/**
 * Created by Administrator on 2017-10-24.
 */

public class DuiBiInfo {

    /**
     * Code : 1
     * Message : 请求成功！
     * Result : {"left":{"id":"78","title":"小麦","about":"滋养人体 养心除烦 健脾益肾 除热止渴","content":"进食全麦可以降低血液循环中的雌激素的含量，从而达到防治乳腺癌的目的；对于更年期妇女，食用未精制的小麦还能缓解更年期综合症。","mon":"7,8","type":"4","stype":"9","status":"1","pic":"78.jpg","cal":"344","car":"73.6","pro":"11.2","fat":"1.5","fib":"2.1","vita":null,"vitb1":"0.28","vitb2":"0.08","vitb3":"4","vitb5":null,"vitb6":null,"vitb7":"10.1","vitb9":null,"vitc":null,"vitd":null,"vite":"1.8","calc":"34","pho":"325","kal":"289","nat":"6.8","mag":"4","iro":"5.1","zin":"2.33","cop":"0.43","man":"3.1","chr":null,"iod":null,"sel":"4.05"},"right":{"id":"118","title":"花椒","about":"增加食欲 降血压 驱虫 防牙痛","content":"花椒为芸香科灌木或小乔木植物青椒的干燥成熟果皮，一般在立秋前后成熟。产于四川、陕西、河南、河北、山西、云南等省，以四川产的质量好，以河北、山西产量为高。花椒是中国特有的香料，位列调料\u201c十三香\u201d之首。无论红烧、卤味、小菜、四川泡菜、鸡鸭鱼羊牛等菜肴均可用到它，也可粗磨成粉和盐拌匀为椒盐，供蘸食用。分为大椒和步椒两种，为良好的调味佐料，也可榨油，出油率在25%以上。花椒油有浓厚的香味，是一种很好的食用油。生产花椒味麻且辣，炒熟后香味才溢出。在烹调上既能单独使用，如花椒面；也能与其他原料配制成调味品，用途极广，效果甚好，如五香面、花椒盐、葱椒盐等。花椒味辛、性热，归脾、胃经；有芳香健胃，温中散寒，除湿止痛，杀虫解毒，止痒解腥之功效；主要治疗呕吐，风寒湿痹，齿痛等症。\r\n","mon":"8,9,10","type":"1","stype":"9","status":"1","pic":"580737cc6ce6e.jpg","cal":"258","car":"66.5","pro":"6.7","fat":"8.9","fib":"28.7","vita":"23","vitb1":"0.12","vitb2":"0.43","vitb3":"","vitb5":null,"vitb6":null,"vitb7":"","vitb9":null,"vitc":null,"vitd":null,"vite":"","calc":"639","pho":"69","kal":"204","nat":"47.4","mag":"111","iro":"8.4","zin":"1.9","cop":"1.02","man":"3.33","chr":null,"iod":null,"sel":"1.96"},"list":[{"key":"cal","key_name":"热量（千卡）","left_value":"344","right_value":"258","compare_res":"left"},{"key":"car","key_name":"碳水化合物（克）","left_value":"73.6","right_value":"66.5","compare_res":"left"},{"key":"pro","key_name":"蛋白质（克）","left_value":"11.2","right_value":"6.7","compare_res":"left"},{"key":"fat","key_name":"脂肪（克）","left_value":"1.5","right_value":"8.9","compare_res":"right"},{"key":"fib","key_name":"膳食纤维（克）","left_value":"2.1","right_value":"28.7","compare_res":"right"},{"key":"vita","key_name":"维生素A（微克）","left_value":"","right_value":"23","compare_res":""},{"key":"vitb1","key_name":"维生素B1（毫克）","left_value":"0.28","right_value":"0.12","compare_res":"left"},{"key":"vitb2","key_name":"维生素B2（毫克）","left_value":"0.08","right_value":"0.43","compare_res":"right"},{"key":"vitb3","key_name":"维生素B3（毫克）","left_value":"4","right_value":"","compare_res":""},{"key":"vitb7","key_name":"维生素B7（毫克）","left_value":"10.1","right_value":"","compare_res":""},{"key":"vite","key_name":"维生素E（毫克）","left_value":"1.8","right_value":"","compare_res":""},{"key":"calc","key_name":"钙（毫克）","left_value":"34","right_value":"639","compare_res":"right"},{"key":"pho","key_name":"磷（毫克）","left_value":"325","right_value":"69","compare_res":"left"},{"key":"kal","key_name":"钾（毫克）","left_value":"289","right_value":"204","compare_res":"left"},{"key":"nat","key_name":"钠（毫克）","left_value":"6.8","right_value":"47.4","compare_res":"right"},{"key":"mag","key_name":"镁（毫克）","left_value":"4","right_value":"111","compare_res":"right"},{"key":"iro","key_name":"铁（毫克）","left_value":"5.1","right_value":"8.4","compare_res":"right"},{"key":"zin","key_name":"锌（毫克）","left_value":"2.33","right_value":"1.9","compare_res":"left"},{"key":"cop","key_name":"铜（毫克）","left_value":"0.43","right_value":"1.02","compare_res":"right"},{"key":"man","key_name":"锰（毫克）","left_value":"3.1","right_value":"3.33","compare_res":"right"},{"key":"sel","key_name":"硒（微克）","left_value":"4.05","right_value":"1.96","compare_res":"left"}]}
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
         * left : {"id":"78","title":"小麦","about":"滋养人体 养心除烦 健脾益肾 除热止渴","content":"进食全麦可以降低血液循环中的雌激素的含量，从而达到防治乳腺癌的目的；对于更年期妇女，食用未精制的小麦还能缓解更年期综合症。","mon":"7,8","type":"4","stype":"9","status":"1","pic":"78.jpg","cal":"344","car":"73.6","pro":"11.2","fat":"1.5","fib":"2.1","vita":null,"vitb1":"0.28","vitb2":"0.08","vitb3":"4","vitb5":null,"vitb6":null,"vitb7":"10.1","vitb9":null,"vitc":null,"vitd":null,"vite":"1.8","calc":"34","pho":"325","kal":"289","nat":"6.8","mag":"4","iro":"5.1","zin":"2.33","cop":"0.43","man":"3.1","chr":null,"iod":null,"sel":"4.05"}
         * right : {"id":"118","title":"花椒","about":"增加食欲 降血压 驱虫 防牙痛","content":"花椒为芸香科灌木或小乔木植物青椒的干燥成熟果皮，一般在立秋前后成熟。产于四川、陕西、河南、河北、山西、云南等省，以四川产的质量好，以河北、山西产量为高。花椒是中国特有的香料，位列调料\u201c十三香\u201d之首。无论红烧、卤味、小菜、四川泡菜、鸡鸭鱼羊牛等菜肴均可用到它，也可粗磨成粉和盐拌匀为椒盐，供蘸食用。分为大椒和步椒两种，为良好的调味佐料，也可榨油，出油率在25%以上。花椒油有浓厚的香味，是一种很好的食用油。生产花椒味麻且辣，炒熟后香味才溢出。在烹调上既能单独使用，如花椒面；也能与其他原料配制成调味品，用途极广，效果甚好，如五香面、花椒盐、葱椒盐等。花椒味辛、性热，归脾、胃经；有芳香健胃，温中散寒，除湿止痛，杀虫解毒，止痒解腥之功效；主要治疗呕吐，风寒湿痹，齿痛等症。\r\n","mon":"8,9,10","type":"1","stype":"9","status":"1","pic":"580737cc6ce6e.jpg","cal":"258","car":"66.5","pro":"6.7","fat":"8.9","fib":"28.7","vita":"23","vitb1":"0.12","vitb2":"0.43","vitb3":"","vitb5":null,"vitb6":null,"vitb7":"","vitb9":null,"vitc":null,"vitd":null,"vite":"","calc":"639","pho":"69","kal":"204","nat":"47.4","mag":"111","iro":"8.4","zin":"1.9","cop":"1.02","man":"3.33","chr":null,"iod":null,"sel":"1.96"}
         * list : [{"key":"cal","key_name":"热量（千卡）","left_value":"344","right_value":"258","compare_res":"left"},{"key":"car","key_name":"碳水化合物（克）","left_value":"73.6","right_value":"66.5","compare_res":"left"},{"key":"pro","key_name":"蛋白质（克）","left_value":"11.2","right_value":"6.7","compare_res":"left"},{"key":"fat","key_name":"脂肪（克）","left_value":"1.5","right_value":"8.9","compare_res":"right"},{"key":"fib","key_name":"膳食纤维（克）","left_value":"2.1","right_value":"28.7","compare_res":"right"},{"key":"vita","key_name":"维生素A（微克）","left_value":"","right_value":"23","compare_res":""},{"key":"vitb1","key_name":"维生素B1（毫克）","left_value":"0.28","right_value":"0.12","compare_res":"left"},{"key":"vitb2","key_name":"维生素B2（毫克）","left_value":"0.08","right_value":"0.43","compare_res":"right"},{"key":"vitb3","key_name":"维生素B3（毫克）","left_value":"4","right_value":"","compare_res":""},{"key":"vitb7","key_name":"维生素B7（毫克）","left_value":"10.1","right_value":"","compare_res":""},{"key":"vite","key_name":"维生素E（毫克）","left_value":"1.8","right_value":"","compare_res":""},{"key":"calc","key_name":"钙（毫克）","left_value":"34","right_value":"639","compare_res":"right"},{"key":"pho","key_name":"磷（毫克）","left_value":"325","right_value":"69","compare_res":"left"},{"key":"kal","key_name":"钾（毫克）","left_value":"289","right_value":"204","compare_res":"left"},{"key":"nat","key_name":"钠（毫克）","left_value":"6.8","right_value":"47.4","compare_res":"right"},{"key":"mag","key_name":"镁（毫克）","left_value":"4","right_value":"111","compare_res":"right"},{"key":"iro","key_name":"铁（毫克）","left_value":"5.1","right_value":"8.4","compare_res":"right"},{"key":"zin","key_name":"锌（毫克）","left_value":"2.33","right_value":"1.9","compare_res":"left"},{"key":"cop","key_name":"铜（毫克）","left_value":"0.43","right_value":"1.02","compare_res":"right"},{"key":"man","key_name":"锰（毫克）","left_value":"3.1","right_value":"3.33","compare_res":"right"},{"key":"sel","key_name":"硒（微克）","left_value":"4.05","right_value":"1.96","compare_res":"left"}]
         */

        private LeftBean left;
        private RightBean right;
        private List<ListBean> list;

        public LeftBean getLeft() {
            return left;
        }

        public void setLeft(LeftBean left) {
            this.left = left;
        }

        public RightBean getRight() {
            return right;
        }

        public void setRight(RightBean right) {
            this.right = right;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class LeftBean {
            /**
             * id : 78
             * title : 小麦
             * about : 滋养人体 养心除烦 健脾益肾 除热止渴
             * content : 进食全麦可以降低血液循环中的雌激素的含量，从而达到防治乳腺癌的目的；对于更年期妇女，食用未精制的小麦还能缓解更年期综合症。
             * mon : 7,8
             * type : 4
             * stype : 9
             * status : 1
             * pic : 78.jpg
             * cal : 344
             * car : 73.6
             * pro : 11.2
             * fat : 1.5
             * fib : 2.1
             * vita : null
             * vitb1 : 0.28
             * vitb2 : 0.08
             * vitb3 : 4
             * vitb5 : null
             * vitb6 : null
             * vitb7 : 10.1
             * vitb9 : null
             * vitc : null
             * vitd : null
             * vite : 1.8
             * calc : 34
             * pho : 325
             * kal : 289
             * nat : 6.8
             * mag : 4
             * iro : 5.1
             * zin : 2.33
             * cop : 0.43
             * man : 3.1
             * chr : null
             * iod : null
             * sel : 4.05
             */

            private String id;
            private String title;
            private String about;
            private String content;
            private String mon;
            private String type;
            private String stype;
            private String status;
            private String pic;
            private String cal;
            private String car;
            private String pro;
            private String fat;
            private String fib;
            private Object vita;
            private String vitb1;
            private String vitb2;
            private String vitb3;
            private Object vitb5;
            private Object vitb6;
            private String vitb7;
            private Object vitb9;
            private Object vitc;
            private Object vitd;
            private String vite;
            private String calc;
            private String pho;
            private String kal;
            private String nat;
            private String mag;
            private String iro;
            private String zin;
            private String cop;
            private String man;
            private Object chr;
            private Object iod;
            private String sel;

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

            public String getAbout() {
                return about;
            }

            public void setAbout(String about) {
                this.about = about;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getMon() {
                return mon;
            }

            public void setMon(String mon) {
                this.mon = mon;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getCal() {
                return cal;
            }

            public void setCal(String cal) {
                this.cal = cal;
            }

            public String getCar() {
                return car;
            }

            public void setCar(String car) {
                this.car = car;
            }

            public String getPro() {
                return pro;
            }

            public void setPro(String pro) {
                this.pro = pro;
            }

            public String getFat() {
                return fat;
            }

            public void setFat(String fat) {
                this.fat = fat;
            }

            public String getFib() {
                return fib;
            }

            public void setFib(String fib) {
                this.fib = fib;
            }

            public Object getVita() {
                return vita;
            }

            public void setVita(Object vita) {
                this.vita = vita;
            }

            public String getVitb1() {
                return vitb1;
            }

            public void setVitb1(String vitb1) {
                this.vitb1 = vitb1;
            }

            public String getVitb2() {
                return vitb2;
            }

            public void setVitb2(String vitb2) {
                this.vitb2 = vitb2;
            }

            public String getVitb3() {
                return vitb3;
            }

            public void setVitb3(String vitb3) {
                this.vitb3 = vitb3;
            }

            public Object getVitb5() {
                return vitb5;
            }

            public void setVitb5(Object vitb5) {
                this.vitb5 = vitb5;
            }

            public Object getVitb6() {
                return vitb6;
            }

            public void setVitb6(Object vitb6) {
                this.vitb6 = vitb6;
            }

            public String getVitb7() {
                return vitb7;
            }

            public void setVitb7(String vitb7) {
                this.vitb7 = vitb7;
            }

            public Object getVitb9() {
                return vitb9;
            }

            public void setVitb9(Object vitb9) {
                this.vitb9 = vitb9;
            }

            public Object getVitc() {
                return vitc;
            }

            public void setVitc(Object vitc) {
                this.vitc = vitc;
            }

            public Object getVitd() {
                return vitd;
            }

            public void setVitd(Object vitd) {
                this.vitd = vitd;
            }

            public String getVite() {
                return vite;
            }

            public void setVite(String vite) {
                this.vite = vite;
            }

            public String getCalc() {
                return calc;
            }

            public void setCalc(String calc) {
                this.calc = calc;
            }

            public String getPho() {
                return pho;
            }

            public void setPho(String pho) {
                this.pho = pho;
            }

            public String getKal() {
                return kal;
            }

            public void setKal(String kal) {
                this.kal = kal;
            }

            public String getNat() {
                return nat;
            }

            public void setNat(String nat) {
                this.nat = nat;
            }

            public String getMag() {
                return mag;
            }

            public void setMag(String mag) {
                this.mag = mag;
            }

            public String getIro() {
                return iro;
            }

            public void setIro(String iro) {
                this.iro = iro;
            }

            public String getZin() {
                return zin;
            }

            public void setZin(String zin) {
                this.zin = zin;
            }

            public String getCop() {
                return cop;
            }

            public void setCop(String cop) {
                this.cop = cop;
            }

            public String getMan() {
                return man;
            }

            public void setMan(String man) {
                this.man = man;
            }

            public Object getChr() {
                return chr;
            }

            public void setChr(Object chr) {
                this.chr = chr;
            }

            public Object getIod() {
                return iod;
            }

            public void setIod(Object iod) {
                this.iod = iod;
            }

            public String getSel() {
                return sel;
            }

            public void setSel(String sel) {
                this.sel = sel;
            }
        }

        public static class RightBean {
            /**
             * id : 118
             * title : 花椒
             * about : 增加食欲 降血压 驱虫 防牙痛
             * content : 花椒为芸香科灌木或小乔木植物青椒的干燥成熟果皮，一般在立秋前后成熟。产于四川、陕西、河南、河北、山西、云南等省，以四川产的质量好，以河北、山西产量为高。花椒是中国特有的香料，位列调料“十三香”之首。无论红烧、卤味、小菜、四川泡菜、鸡鸭鱼羊牛等菜肴均可用到它，也可粗磨成粉和盐拌匀为椒盐，供蘸食用。分为大椒和步椒两种，为良好的调味佐料，也可榨油，出油率在25%以上。花椒油有浓厚的香味，是一种很好的食用油。生产花椒味麻且辣，炒熟后香味才溢出。在烹调上既能单独使用，如花椒面；也能与其他原料配制成调味品，用途极广，效果甚好，如五香面、花椒盐、葱椒盐等。花椒味辛、性热，归脾、胃经；有芳香健胃，温中散寒，除湿止痛，杀虫解毒，止痒解腥之功效；主要治疗呕吐，风寒湿痹，齿痛等症。

             * mon : 8,9,10
             * type : 1
             * stype : 9
             * status : 1
             * pic : 580737cc6ce6e.jpg
             * cal : 258
             * car : 66.5
             * pro : 6.7
             * fat : 8.9
             * fib : 28.7
             * vita : 23
             * vitb1 : 0.12
             * vitb2 : 0.43
             * vitb3 :
             * vitb5 : null
             * vitb6 : null
             * vitb7 :
             * vitb9 : null
             * vitc : null
             * vitd : null
             * vite :
             * calc : 639
             * pho : 69
             * kal : 204
             * nat : 47.4
             * mag : 111
             * iro : 8.4
             * zin : 1.9
             * cop : 1.02
             * man : 3.33
             * chr : null
             * iod : null
             * sel : 1.96
             */

            private String id;
            private String title;
            private String about;
            private String content;
            private String mon;
            private String type;
            private String stype;
            private String status;
            private String pic;
            private String cal;
            private String car;
            private String pro;
            private String fat;
            private String fib;
            private String vita;
            private String vitb1;
            private String vitb2;
            private String vitb3;
            private Object vitb5;
            private Object vitb6;
            private String vitb7;
            private Object vitb9;
            private Object vitc;
            private Object vitd;
            private String vite;
            private String calc;
            private String pho;
            private String kal;
            private String nat;
            private String mag;
            private String iro;
            private String zin;
            private String cop;
            private String man;
            private Object chr;
            private Object iod;
            private String sel;

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

            public String getAbout() {
                return about;
            }

            public void setAbout(String about) {
                this.about = about;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getMon() {
                return mon;
            }

            public void setMon(String mon) {
                this.mon = mon;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getCal() {
                return cal;
            }

            public void setCal(String cal) {
                this.cal = cal;
            }

            public String getCar() {
                return car;
            }

            public void setCar(String car) {
                this.car = car;
            }

            public String getPro() {
                return pro;
            }

            public void setPro(String pro) {
                this.pro = pro;
            }

            public String getFat() {
                return fat;
            }

            public void setFat(String fat) {
                this.fat = fat;
            }

            public String getFib() {
                return fib;
            }

            public void setFib(String fib) {
                this.fib = fib;
            }

            public String getVita() {
                return vita;
            }

            public void setVita(String vita) {
                this.vita = vita;
            }

            public String getVitb1() {
                return vitb1;
            }

            public void setVitb1(String vitb1) {
                this.vitb1 = vitb1;
            }

            public String getVitb2() {
                return vitb2;
            }

            public void setVitb2(String vitb2) {
                this.vitb2 = vitb2;
            }

            public String getVitb3() {
                return vitb3;
            }

            public void setVitb3(String vitb3) {
                this.vitb3 = vitb3;
            }

            public Object getVitb5() {
                return vitb5;
            }

            public void setVitb5(Object vitb5) {
                this.vitb5 = vitb5;
            }

            public Object getVitb6() {
                return vitb6;
            }

            public void setVitb6(Object vitb6) {
                this.vitb6 = vitb6;
            }

            public String getVitb7() {
                return vitb7;
            }

            public void setVitb7(String vitb7) {
                this.vitb7 = vitb7;
            }

            public Object getVitb9() {
                return vitb9;
            }

            public void setVitb9(Object vitb9) {
                this.vitb9 = vitb9;
            }

            public Object getVitc() {
                return vitc;
            }

            public void setVitc(Object vitc) {
                this.vitc = vitc;
            }

            public Object getVitd() {
                return vitd;
            }

            public void setVitd(Object vitd) {
                this.vitd = vitd;
            }

            public String getVite() {
                return vite;
            }

            public void setVite(String vite) {
                this.vite = vite;
            }

            public String getCalc() {
                return calc;
            }

            public void setCalc(String calc) {
                this.calc = calc;
            }

            public String getPho() {
                return pho;
            }

            public void setPho(String pho) {
                this.pho = pho;
            }

            public String getKal() {
                return kal;
            }

            public void setKal(String kal) {
                this.kal = kal;
            }

            public String getNat() {
                return nat;
            }

            public void setNat(String nat) {
                this.nat = nat;
            }

            public String getMag() {
                return mag;
            }

            public void setMag(String mag) {
                this.mag = mag;
            }

            public String getIro() {
                return iro;
            }

            public void setIro(String iro) {
                this.iro = iro;
            }

            public String getZin() {
                return zin;
            }

            public void setZin(String zin) {
                this.zin = zin;
            }

            public String getCop() {
                return cop;
            }

            public void setCop(String cop) {
                this.cop = cop;
            }

            public String getMan() {
                return man;
            }

            public void setMan(String man) {
                this.man = man;
            }

            public Object getChr() {
                return chr;
            }

            public void setChr(Object chr) {
                this.chr = chr;
            }

            public Object getIod() {
                return iod;
            }

            public void setIod(Object iod) {
                this.iod = iod;
            }

            public String getSel() {
                return sel;
            }

            public void setSel(String sel) {
                this.sel = sel;
            }
        }

        public static class ListBean {
            /**
             * key : cal
             * key_name : 热量（千卡）
             * left_value : 344
             * right_value : 258
             * compare_res : left
             */

            private String key;
            private String key_name;
            private String left_value;
            private String right_value;
            private String compare_res;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }

            public String getLeft_value() {
                return left_value;
            }

            public void setLeft_value(String left_value) {
                this.left_value = left_value;
            }

            public String getRight_value() {
                return right_value;
            }

            public void setRight_value(String right_value) {
                this.right_value = right_value;
            }

            public String getCompare_res() {
                return compare_res;
            }

            public void setCompare_res(String compare_res) {
                this.compare_res = compare_res;
            }
        }
    }
}
