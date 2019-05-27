package bean;

import java.util.List;

public class EmployeeListBean
{
	private List<EmployeeBean> eList;
	private String message;


	public List<EmployeeBean> getEmpList() {
		return eList;
	}
	public void setEmpList(List<EmployeeBean> empList) {
		this.eList = empList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
