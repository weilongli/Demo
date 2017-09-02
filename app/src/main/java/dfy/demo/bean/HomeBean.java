package dfy.demo.bean;

import java.util.List;

import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/8/31.
 */

public class HomeBean extends BaseBean{
    /**
     * data : {"ads":[{"adId":76,"adFile":"http://law.east-profit.com/upload/adspic/2017-08/59941edd2a16f.png","adUrl":"#"},{"adId":75,"adFile":"http://law.east-profit.com/upload/adspic/2017-08/59941edd2a16f.png","adUrl":"#"},{"adId":73,"adFile":"http://law.east-profit.com/upload/adspic/2017-08/59941edd2a16f.png","adUrl":"#"}],"newlaws":[{"regulationId":53,"title":"适用民事诉讼法司法解释（2017年修正）","catId":21,"createTime":1503645486,"image":"http://law.east-profit.com/upload/sysconfigs/2017-08/598d57381c73f.png"},{"regulationId":52,"title":"中华人民共和国民事诉讼法","catId":21,"createTime":1503644556,"image":"http://law.east-profit.com/upload/sysconfigs/2017-08/598d57381c73f.png"},{"regulationId":50,"title":"中华人民共和国合同法","catId":21,"createTime":1503643510,"image":"http://law.east-profit.com/upload/sysconfigs/2017-08/598d57381c73f.png"},{"regulationId":49,"title":"中华人民共和国物权法","catId":21,"createTime":1503642670,"image":"http://law.east-profit.com/upload/sysconfigs/2017-08/598d57381c73f.png"},{"regulationId":5,"title":"中华人民共和国律师法（2007）","catId":2,"createTime":1501556783,"image":"http://law.east-profit.com/a.jpg"}],"rcmlaws":[{"abstractId":68,"title":"抽逃全部出资的股东对除名股东会不享有表","image":"http://law.east-profit.com/upload/shops/2017-08/599fb9b28ee66.jpg","userId":10000075,"trueName":"刘昌硕","createTime":1503640007},{"abstractId":69,"title":"房企法务必读：开发商阶段性担保的风险防控","image":"http://law.east-profit.com/upload/shops/2017-08/599fbcf90e8c4.jpg","userId":10000075,"trueName":"刘昌硕","createTime":1503640834},{"abstractId":70,"title":"房屋买受人以应收账款出质作为付款担保的相","image":"http://law.east-profit.com/upload/shops/2017-08/599fbdd237a0d.jpg","userId":10000075,"trueName":"刘昌硕","createTime":1503641045},{"abstractId":71,"title":"公司法解释（四）之实务解读","image":"http://law.east-profit.com/upload/shops/2017-08/599fbee011061.jpg","userId":10000075,"trueName":"刘昌硕","createTime":1503641318},{"abstractId":72,"title":"合同解除异议案件的审查要点","image":"http://law.east-profit.com/upload/shops/2017-08/599fbfb7ea0db.jpg","userId":10000075,"trueName":"刘昌硕","createTime":1503641534}]}
     */

    public static class DataBean {
        private List<AdsBean> ads;
        private List<NewlawsBean> newlaws;
        private List<RcmlawsBean> rcmlaws;

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<NewlawsBean> getNewlaws() {
            return newlaws;
        }

        public void setNewlaws(List<NewlawsBean> newlaws) {
            this.newlaws = newlaws;
        }

        public List<RcmlawsBean> getRcmlaws() {
            return rcmlaws;
        }

        public void setRcmlaws(List<RcmlawsBean> rcmlaws) {
            this.rcmlaws = rcmlaws;
        }

        public static class AdsBean {
            /**
             * adId : 76
             * adFile : http://law.east-profit.com/upload/adspic/2017-08/59941edd2a16f.png
             * adUrl : #
             */

            private int adId;
            private String adFile;
            private String adUrl;

            public int getAdId() {
                return adId;
            }

            public void setAdId(int adId) {
                this.adId = adId;
            }

            public String getAdFile() {
                return adFile;
            }

            public void setAdFile(String adFile) {
                this.adFile = adFile;
            }

            public String getAdUrl() {
                return adUrl;
            }

            public void setAdUrl(String adUrl) {
                this.adUrl = adUrl;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("AdsBean{");
                sb.append("adId=").append(adId);
                sb.append(", adFile='").append(adFile).append('\'');
                sb.append(", adUrl='").append(adUrl).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public static class NewlawsBean {
            /**
             * regulationId : 53
             * title : 适用民事诉讼法司法解释（2017年修正）
             * catId : 21
             * createTime : 1503645486
             * image : http://law.east-profit.com/upload/sysconfigs/2017-08/598d57381c73f.png
             */

            private int regulationId;
            private String title;
            private int catId;
            private int createTime;
            private String image;

            public int getRegulationId() {
                return regulationId;
            }

            public void setRegulationId(int regulationId) {
                this.regulationId = regulationId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCatId() {
                return catId;
            }

            public void setCatId(int catId) {
                this.catId = catId;
            }

            public int getCreateTime() {
                return createTime;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            @Override
            public String toString() {
                final StringBuffer sb = new StringBuffer("NewlawsBean{");
                sb.append("regulationId=").append(regulationId);
                sb.append(", title='").append(title).append('\'');
                sb.append(", catId=").append(catId);
                sb.append(", createTime=").append(createTime);
                sb.append(", image='").append(image).append('\'');
                sb.append('}');
                return sb.toString();
            }
        }

        public static class RcmlawsBean {
            /**
             * abstractId : 68
             * title : 抽逃全部出资的股东对除名股东会不享有表
             * image : http://law.east-profit.com/upload/shops/2017-08/599fb9b28ee66.jpg
             * userId : 10000075
             * trueName : 刘昌硕
             * createTime : 1503640007
             */

            private int abstractId;
            private String title;
            private String image;
            private int userId;
            private String trueName;
            private int createTime;

            public int getAbstractId() {
                return abstractId;
            }

            public void setAbstractId(int abstractId) {
                this.abstractId = abstractId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getTrueName() {
                return trueName;
            }

            public void setTrueName(String trueName) {
                this.trueName = trueName;
            }

            public int getCreateTime() {
                return createTime;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("DataBean{");
            sb.append("ads=").append(ads);
            sb.append(", newlaws=").append(newlaws);
            sb.append(", rcmlaws=").append(rcmlaws);
            sb.append('}');
            return sb.toString();
        }
    }


    /**
     * data : {"ads":[{"adId":39,"adFile":"http://law.east-profit.com/upload/adspic/2016-10/57f8c306ec638.jpg","adUrl":""}],"newlaws":[{"regulationId":1,"title":"1","content":"123123","image":"http://law.east-profit.com/1","dataName":"中国人大","dataId":"中国人大","createTime":1}],"rcmlaws":[{"abstractId":1,"title":"1","content":"123123","image":"http://law.east-profit.com/1","userId":1,"trueName":"lawyer","createTime":1}]}
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HomeBean{"+new DataBean.RcmlawsBean().toString()+new DataBean().toString()+new DataBean.NewlawsBean().toString());
        sb.append('}');
        return sb.toString();
    }
}
