package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;

public class EmployeesDao {

    private static final String SELECT_SQL =
            "SELECT * "
            + "FROM EMPLOYEES ";

    private Connection con = null;

    public EmployeesDao(Connection con)
    {
        super();
		this.con = con;
    }


    public List<EmployeeBean> selectAll() throws SQLException
    {
    	PreparedStatement stmt = con.prepareStatement( SELECT_SQL );

    	System.out.println("3:EmpDao 接続成功");

         try
         {
        	ResultSet rs = stmt.executeQuery();

	    	List<EmployeeBean> eList = new ArrayList<EmployeeBean>();
	    	//レコードがない場合はExceptionで戻る
	    	while(rs.next())
	    	{
	    		EmployeeBean eb = new EmployeeBean();

	    		eb.setEmployeeID(rs.getInt("EmployeeID"));
		    	eb.setEmployeeName(rs.getString("EmployeeName"));
		    	eb.setHeight(rs.getBigDecimal("Height"));
		    	eb.seteMail(rs.getString("EMail"));
		    	eb.setWeight(rs.getBigDecimal("Weight"));
		    	eb.setHireFiscalYear(rs.getInt("HireFiscalYear"));
		    	eb.setBirthday(rs.getDate("Birthday").toLocalDate());
		    	eb.setBloodType(rs.getString("BloodType"));

		    	eList.add(eb);
	    	}
	    	System.out.println("4:EmpDao レコード取得");
	    	return eList;
         }
 		finally
 		{
 			if( stmt != null )
 				stmt.close();
 		}
    }

}