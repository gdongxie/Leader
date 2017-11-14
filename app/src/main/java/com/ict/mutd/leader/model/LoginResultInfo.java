package com.ict.mutd.leader.model;

import java.util.List;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 */

public class LoginResultInfo extends ResultInfo {

    /**
     * LoginInfo : {"UserInfo":{"UserName":"guanpengfei","PassWord":"1","StuffId":"00509003588","StuffName":"关鹏飞"},"RoleInfoList":[{"RoleCode":"115","RoleName":"系统管理员(物流)"},{"RoleCode":"s","RoleName":"管库员"},{"RoleCode":"121","RoleName":"检修车间调度员"},{"RoleCode":"V","RoleName":"转向架车间调度员"},{"RoleCode":"Ar","RoleName":"分库管库员"},{"RoleCode":"q","RoleName":"材料科科长"},{"RoleCode":"t","RoleName":"采购员"},{"RoleCode":"r","RoleName":"计划员"},{"RoleCode":"A4","RoleName":"配送员"},{"RoleCode":"u","RoleName":"车间核算员(材料员)"},{"RoleCode":"116","RoleName":"物流信息查询人员"},{"RoleCode":"117","RoleName":"工具管理员"}],"DeptInfoList":[{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"2"},{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"}],"DepotInfo":{"DeptName":"沈阳动车段","DeptCode":"00509","DeptType":"0"},"DepartmentDept":{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"},"DepartmentDeptWL":{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"},"oleModuleInfoList":[{"RoleCode":null,"ModuleCode":"M006","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M012","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M015","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M022","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M021","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M019","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M038","PermCode":[null]}],"SysTime":"2017-11-14 08:48:03"}
     */

    private LoginInfoBean LoginInfo;

    public LoginInfoBean getLoginInfo() {
        return LoginInfo;
    }

    public void setLoginInfo(LoginInfoBean LoginInfo) {
        this.LoginInfo = LoginInfo;
    }

    public static class LoginInfoBean {
        /**
         * UserInfo : {"UserName":"guanpengfei","PassWord":"1","StuffId":"00509003588","StuffName":"关鹏飞"}
         * RoleInfoList : [{"RoleCode":"115","RoleName":"系统管理员(物流)"},{"RoleCode":"s","RoleName":"管库员"},{"RoleCode":"121","RoleName":"检修车间调度员"},{"RoleCode":"V","RoleName":"转向架车间调度员"},{"RoleCode":"Ar","RoleName":"分库管库员"},{"RoleCode":"q","RoleName":"材料科科长"},{"RoleCode":"t","RoleName":"采购员"},{"RoleCode":"r","RoleName":"计划员"},{"RoleCode":"A4","RoleName":"配送员"},{"RoleCode":"u","RoleName":"车间核算员(材料员)"},{"RoleCode":"116","RoleName":"物流信息查询人员"},{"RoleCode":"117","RoleName":"工具管理员"}]
         * DeptInfoList : [{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"2"},{"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"}]
         * DepotInfo : {"DeptName":"沈阳动车段","DeptCode":"00509","DeptType":"0"}
         * DepartmentDept : {"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"}
         * DepartmentDeptWL : {"DeptName":"材料配送中心","DeptCode":"0050900270","DeptType":"0"}
         * RoleModuleInfoList : [{"RoleCode":null,"ModuleCode":"M006","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M012","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M015","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M022","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M021","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M019","PermCode":[null]},{"RoleCode":null,"ModuleCode":"M038","PermCode":[null]}]
         * SysTime : 2017-11-14 08:48:03
         */

        private UserInfoBean UserInfo;
        private DepotInfoBean DepotInfo;
        private DepartmentDeptBean DepartmentDept;
        private DepartmentDeptWLBean DepartmentDeptWL;
        private String SysTime;
        private List<RoleInfoListBean> RoleInfoList;
        private List<DeptInfoListBean> DeptInfoList;
        private List<RoleModuleInfoListBean> RoleModuleInfoList;

        public UserInfoBean getUserInfo() {
            return UserInfo;
        }

        public void setUserInfo(UserInfoBean UserInfo) {
            this.UserInfo = UserInfo;
        }

        public DepotInfoBean getDepotInfo() {
            return DepotInfo;
        }

        public void setDepotInfo(DepotInfoBean DepotInfo) {
            this.DepotInfo = DepotInfo;
        }

        public DepartmentDeptBean getDepartmentDept() {
            return DepartmentDept;
        }

        public void setDepartmentDept(DepartmentDeptBean DepartmentDept) {
            this.DepartmentDept = DepartmentDept;
        }

        public DepartmentDeptWLBean getDepartmentDeptWL() {
            return DepartmentDeptWL;
        }

        public void setDepartmentDeptWL(DepartmentDeptWLBean DepartmentDeptWL) {
            this.DepartmentDeptWL = DepartmentDeptWL;
        }

        public String getSysTime() {
            return SysTime;
        }

        public void setSysTime(String SysTime) {
            this.SysTime = SysTime;
        }

        public List<RoleInfoListBean> getRoleInfoList() {
            return RoleInfoList;
        }

        public void setRoleInfoList(List<RoleInfoListBean> RoleInfoList) {
            this.RoleInfoList = RoleInfoList;
        }

        public List<DeptInfoListBean> getDeptInfoList() {
            return DeptInfoList;
        }

        public void setDeptInfoList(List<DeptInfoListBean> DeptInfoList) {
            this.DeptInfoList = DeptInfoList;
        }

        public List<RoleModuleInfoListBean> getRoleModuleInfoList() {
            return RoleModuleInfoList;
        }

        public void setRoleModuleInfoList(List<RoleModuleInfoListBean> RoleModuleInfoList) {
            this.RoleModuleInfoList = RoleModuleInfoList;
        }

        public static class UserInfoBean {
            /**
             * UserName : guanpengfei
             * PassWord : 1
             * StuffId : 00509003588
             * StuffName : 关鹏飞
             */

            private String UserName;
            private String PassWord;
            private String StuffId;
            private String StuffName;

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getPassWord() {
                return PassWord;
            }

            public void setPassWord(String PassWord) {
                this.PassWord = PassWord;
            }

            public String getStuffId() {
                return StuffId;
            }

            public void setStuffId(String StuffId) {
                this.StuffId = StuffId;
            }

            public String getStuffName() {
                return StuffName;
            }

            public void setStuffName(String StuffName) {
                this.StuffName = StuffName;
            }
        }

        public static class DepotInfoBean {
            /**
             * DeptName : 沈阳动车段
             * DeptCode : 00509
             * DeptType : 0
             */

            private String DeptName;
            private String DeptCode;
            private String DeptType;

            public String getDeptName() {
                return DeptName;
            }

            public void setDeptName(String DeptName) {
                this.DeptName = DeptName;
            }

            public String getDeptCode() {
                return DeptCode;
            }

            public void setDeptCode(String DeptCode) {
                this.DeptCode = DeptCode;
            }

            public String getDeptType() {
                return DeptType;
            }

            public void setDeptType(String DeptType) {
                this.DeptType = DeptType;
            }
        }

        public static class DepartmentDeptBean {
            /**
             * DeptName : 材料配送中心
             * DeptCode : 0050900270
             * DeptType : 0
             */

            private String DeptName;
            private String DeptCode;
            private String DeptType;

            public String getDeptName() {
                return DeptName;
            }

            public void setDeptName(String DeptName) {
                this.DeptName = DeptName;
            }

            public String getDeptCode() {
                return DeptCode;
            }

            public void setDeptCode(String DeptCode) {
                this.DeptCode = DeptCode;
            }

            public String getDeptType() {
                return DeptType;
            }

            public void setDeptType(String DeptType) {
                this.DeptType = DeptType;
            }
        }

        public static class DepartmentDeptWLBean {
            /**
             * DeptName : 材料配送中心
             * DeptCode : 0050900270
             * DeptType : 0
             */

            private String DeptName;
            private String DeptCode;
            private String DeptType;

            public String getDeptName() {
                return DeptName;
            }

            public void setDeptName(String DeptName) {
                this.DeptName = DeptName;
            }

            public String getDeptCode() {
                return DeptCode;
            }

            public void setDeptCode(String DeptCode) {
                this.DeptCode = DeptCode;
            }

            public String getDeptType() {
                return DeptType;
            }

            public void setDeptType(String DeptType) {
                this.DeptType = DeptType;
            }
        }

        public static class RoleInfoListBean {
            /**
             * RoleCode : 115
             * RoleName : 系统管理员(物流)
             */

            private String RoleCode;
            private String RoleName;

            public String getRoleCode() {
                return RoleCode;
            }

            public void setRoleCode(String RoleCode) {
                this.RoleCode = RoleCode;
            }

            public String getRoleName() {
                return RoleName;
            }

            public void setRoleName(String RoleName) {
                this.RoleName = RoleName;
            }
        }

        public static class DeptInfoListBean {
            /**
             * DeptName : 材料配送中心
             * DeptCode : 0050900270
             * DeptType : 2
             */

            private String DeptName;
            private String DeptCode;
            private String DeptType;

            public String getDeptName() {
                return DeptName;
            }

            public void setDeptName(String DeptName) {
                this.DeptName = DeptName;
            }

            public String getDeptCode() {
                return DeptCode;
            }

            public void setDeptCode(String DeptCode) {
                this.DeptCode = DeptCode;
            }

            public String getDeptType() {
                return DeptType;
            }

            public void setDeptType(String DeptType) {
                this.DeptType = DeptType;
            }
        }

        public static class RoleModuleInfoListBean {
            /**
             * RoleCode : null
             * ModuleCode : M006
             * PermCode : [null]
             */

            private Object RoleCode;
            private String ModuleCode;
            private List<String> PermCode;

            public Object getRoleCode() {
                return RoleCode;
            }

            public void setRoleCode(Object RoleCode) {
                this.RoleCode = RoleCode;
            }

            public String getModuleCode() {
                return ModuleCode;
            }

            public void setModuleCode(String ModuleCode) {
                this.ModuleCode = ModuleCode;
            }

            public List<String> getPermCode() {
                return PermCode;
            }

            public void setPermCode(List<String> PermCode) {
                this.PermCode = PermCode;
            }
        }
    }
}
