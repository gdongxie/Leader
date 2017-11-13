package com.ict.mutd.leader.model;

import java.util.List;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 */

public class LoginResultInfo extends ResultInfo {
    public UserInfo UserInfo;
    public List<RoleInfoList> RoleInfoList;
    public List<DeptInfo> DeptInfoList;
    public List<RoleModuleInfoList> RoleModuleInfoList;
    public DeptInfo DepotInfo;
    public DeptInfo DepartmentDept;
    public DeptInfo DepartmentWL;
    public String SysTime;
}
