<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    <jsp:useBean id="bean" class="bean.EmployeeListBean" scope="request" />
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<title>従業員一覧</title>
  </head>
<% System.out.println("5:JSP 移動成功"); %>

  <body>
	<h1>従業員一覧</h1>

	<table border=1>
	  <tr>
	    <td>社員番号</td>
	    <td>社員名</td>
	    <td>身長</td>
	    <td>メールアドレス</td>
	    <td>体重</td>
	    <td>入社年度</td>
	    <td>誕生日</td>
	    <td>血液型</td>
	  </tr>
	  <%


	  for(bean.EmployeeBean eb : bean.getEmpList() )
	  {

	  %>

	  <tr>
	    <td><%= eb.getEmployeeID() %></td>
	    <td><%= eb.getEmployeeName() %></td>
	    <td><%= eb.getHeight() %></td>
	    <td><%= eb.geteMail() %></td>
	    <td><%= eb.getWeight() %></td>
	    <td><%= eb.getHireFiscalYear()%></td>
	    <td><%= eb.getBirthday() %></td>
	    <td><%= eb.getBloodType() %></td>
	  </tr>
	  <%} %>
	</table>


  </body>
</html>