package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.EmployeeBean;
import bean.EmployeeListBean;
import dao.Dao;
import dao.EmployeesDao;

public class EmployeeService
{
	public EmployeeListBean selectAll()
	{
		System.out.println("2:Service 接続成功");

		EmployeeListBean elb = new EmployeeListBean();

		//オートクローズ
		try( Connection con= Dao.getConnection() )
		{
			EmployeesDao dao = new EmployeesDao(con);

			List<EmployeeBean> eList = dao.selectAll();

			elb.setEmpList(eList);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return elb;
	}

}
