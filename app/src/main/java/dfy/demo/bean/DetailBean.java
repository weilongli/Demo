package dfy.demo.bean;

import java.util.List;

import dfy.networklibrary.net.BaseBean;

/**
 * Created by Admin on 2017/8/31.
 */

public class DetailBean extends BaseBean<List<DetailBean.DataBean>>{

    private PagerBean pager;
    private List<DataBean> data;

    public PagerBean getPager() {
        return pager;
    }

    public void setPager(PagerBean pager) {
        this.pager = pager;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagerBean {
        /**
         * curpage : 1
         * pagecount : 2
         */

        private int curpage;
        private int pagecount;

        public int getCurpage() {
            return curpage;
        }

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public int getPagecount() {
            return pagecount;
        }

        public void setPagecount(int pagecount) {
            this.pagecount = pagecount;
        }
    }

    public static class DataBean {
        /**
         * header : http://law.east-profit.com/upload/sysconfigs/2017-08/599eb5849e55b.png
         * role : 律师
         * trueName : 刘昌硕
         * workyears : null
         * office : null
         * uid : 10000075
         * casenum : 0
         */

        private String header;
        private String role;
        private String trueName;
        private Object workyears;
        private Object office;
        private int uid;
        private int casenum;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getTrueName() {
            return trueName;
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }

        public Object getWorkyears() {
            return workyears;
        }

        public void setWorkyears(Object workyears) {
            this.workyears = workyears;
        }

        public Object getOffice() {
            return office;
        }

        public void setOffice(Object office) {
            this.office = office;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getCasenum() {
            return casenum;
        }

        public void setCasenum(int casenum) {
            this.casenum = casenum;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("DataBean{");
            sb.append("header='").append(header).append('\'');
            sb.append(", role='").append(role).append('\'');
            sb.append(", trueName='").append(trueName).append('\'');
            sb.append(", workyears=").append(workyears);
            sb.append(", office=").append(office);
            sb.append(", uid=").append(uid);
            sb.append(", casenum=").append(casenum);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DetailBean{");
        sb.append("pager=").append(pager);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
