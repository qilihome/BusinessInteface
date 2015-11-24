package com.weichat.boss.service;

import java.util.Date;
import java.util.List;

import com.weichat.boss.data.pojo.Admin;
import com.weichat.boss.data.pojo.BusinessInfo;
import com.weichat.boss.data.pojo.BusinessType;
import com.weichat.boss.data.pojo.Department;
import com.weichat.boss.data.pojo.WorkFlow;

/**
 * 服务接口
 * 
 * @author liqi phone 18771970972 qq 197399622
 */
public interface BusinessService
{
	boolean login(String userName, String password);

	/* 待处理业务列表 */
	List<BusinessInfo> queryToBusinesses();

	/* 业务相关 */
	List<BusinessInfo> queryBusinesses(BusinessInfo businessinfo);

	void saveBusiness(BusinessInfo businessinfo);

	void updateBusiness(BusinessInfo businessinfo);

	void delBusiness(int businessInfoId);
	
	/*业务看板列表*/
	List<BusinessInfo> queryBusinesses(int businessID, int businessTypeID,
			String businessContent, Date startCreateTime, Date endCreateTime,
			int status);

	/* 部门列表 */
	List<Department> departList();

	/* 受理人列表 */
	List<Admin> adminList(int departId);

	/* 业务类别列表 */
	List<BusinessType> businessTypeList();
	
	/*节点*/
	/*注销*/
	void overWorkFlow(int workFlowID);
	
	void saveWorkFlow(WorkFlow workFlow);
	
	WorkFlow updateWorkFlow(WorkFlow workFlow);
	
	/*立户*/
	void queryCustomerList(String customerNo);
}
