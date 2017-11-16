package com.ict.mutd.leader.model;

import java.util.List;

/**
 * Created by ZZL on 2017/11/15.
 * Email:gdongxie@gmail.com
 */

public class UseRepairBean {

    /**
     * ResultInfoList : [{"SDeptId":"048","SDeptName":"沈阳南运用所","SMtid":null,"SMaterialcode":null,"SMaterialname":null,"SManmaterialcode":null,"SMaterialSpec":null,"SUnit":null,"IPrice":null,"INumber":null,"IAmount":"13249.58","SStartDate":"2017/11/14 8:00:00","SEndDate":"2017/11/15 8:00:00","SMonth":null},{"SDeptId":"0050900241","SDeptName":"验收室","SMtid":null,"SMaterialcode":null,"SMaterialname":null,"SManmaterialcode":null,"SMaterialSpec":null,"SUnit":null,"IPrice":null,"INumber":null,"IAmount":"1903544.85","SStartDate":"2017/11/14 8:00:00","SEndDate":"2017/11/15 8:00:00","SMonth":null},{"SDeptId":"0050900159","SDeptName":"检修车间","SMtid":null,"SMaterialcode":null,"SMaterialname":null,"SManmaterialcode":null,"SMaterialSpec":null,"SUnit":null,"IPrice":null,"INumber":null,"IAmount":"403643.92","SStartDate":"2017/11/14 8:00:00","SEndDate":"2017/11/15 8:00:00","SMonth":null},{"SDeptId":"0050900160","SDeptName":"转向架车间","SMtid":null,"SMaterialcode":null,"SMaterialname":null,"SManmaterialcode":null,"SMaterialSpec":null,"SUnit":null,"IPrice":null,"INumber":null,"IAmount":"190748.12","SStartDate":"2017/11/14 8:00:00","SEndDate":"2017/11/15 8:00:00","SMonth":null},{"SDeptId":"0050900270","SDeptName":"材料配送中心","SMtid":null,"SMaterialcode":null,"SMaterialname":null,"SManmaterialcode":null,"SMaterialSpec":null,"SUnit":null,"IPrice":null,"INumber":null,"IAmount":"128176.36","SStartDate":"2017/11/14 8:00:00","SEndDate":"2017/11/15 8:00:00","SMonth":null}]
     * Type : 1
     * Desc : null
     */

    private int Type;
    private String Desc;
    private List<ResultInfoListBean> ResultInfoList;

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public List<ResultInfoListBean> getResultInfoList() {
        return ResultInfoList;
    }

    public void setResultInfoList(List<ResultInfoListBean> ResultInfoList) {
        this.ResultInfoList = ResultInfoList;
    }

    public static class ResultInfoListBean {
        /**
         * SDeptId : 048
         * SDeptName : 沈阳南运用所
         * SMtid : null
         * SMaterialcode : null
         * SMaterialname : null
         * SManmaterialcode : null
         * SMaterialSpec : null
         * SUnit : null
         * IPrice : null
         * INumber : null
         * IAmount : 13249.58
         * SStartDate : 2017/11/14 8:00:00
         * SEndDate : 2017/11/15 8:00:00
         * SMonth : null
         */

        private String SDeptId;
        private String SDeptName;
        private String SMtid;
        private String SMaterialcode;
        private String SMaterialname;
        private String SManmaterialcode;
        private String SMaterialSpec;
        private String SUnit;
        private String IPrice;
        private String INumber;
        private String IAmount;
        private String SStartDate;
        private String SEndDate;
        private String SMonth;

        public String getSDeptId() {
            return SDeptId;
        }

        public void setSDeptId(String SDeptId) {
            this.SDeptId = SDeptId;
        }

        public String getSDeptName() {
            return SDeptName;
        }

        public void setSDeptName(String SDeptName) {
            this.SDeptName = SDeptName;
        }

        public String getSMtid() {
            return SMtid;
        }

        public void setSMtid(String SMtid) {
            this.SMtid = SMtid;
        }

        public String getSMaterialcode() {
            return SMaterialcode;
        }

        public void setSMaterialcode(String SMaterialcode) {
            this.SMaterialcode = SMaterialcode;
        }

        public String getSMaterialname() {
            return SMaterialname;
        }

        public void setSMaterialname(String SMaterialname) {
            this.SMaterialname = SMaterialname;
        }

        public String getSManmaterialcode() {
            return SManmaterialcode;
        }

        public void setSManmaterialcode(String SManmaterialcode) {
            this.SManmaterialcode = SManmaterialcode;
        }

        public String getSMaterialSpec() {
            return SMaterialSpec;
        }

        public void setSMaterialSpec(String SMaterialSpec) {
            this.SMaterialSpec = SMaterialSpec;
        }

        public String getSUnit() {
            return SUnit;
        }

        public void setSUnit(String SUnit) {
            this.SUnit = SUnit;
        }

        public String getIPrice() {
            return IPrice;
        }

        public void setIPrice(String IPrice) {
            this.IPrice = IPrice;
        }

        public String getINumber() {
            return INumber;
        }

        public void setINumber(String INumber) {
            this.INumber = INumber;
        }

        public String getIAmount() {
            return IAmount;
        }

        public void setIAmount(String IAmount) {
            this.IAmount = IAmount;
        }

        public String getSStartDate() {
            return SStartDate;
        }

        public void setSStartDate(String SStartDate) {
            this.SStartDate = SStartDate;
        }

        public String getSEndDate() {
            return SEndDate;
        }

        public void setSEndDate(String SEndDate) {
            this.SEndDate = SEndDate;
        }

        public String getSMonth() {
            return SMonth;
        }

        public void setSMonth(String SMonth) {
            this.SMonth = SMonth;
        }
    }
}
