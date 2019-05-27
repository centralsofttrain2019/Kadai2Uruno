package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeListBean;
import service.EmployeeService;


@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public EmployeeListServlet()
    {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	System.out.println("1:Servlet 接続成功");

    	//サービス情報を取得
    	EmployeeService service = new EmployeeService();
   		EmployeeListBean elb = service.selectAll();

   		request.setAttribute("bean", elb);

    	//JSPに遷移する
    	RequestDispatcher disp = request.getRequestDispatcher("/employeeList.jsp");
   		disp.forward(request, response);

	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
