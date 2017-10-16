<%@ page contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>修改图书信息</title>
<head></head>
<body>

   
    <s:form action="edit">
     <% String isbnn=request.getParameter("isbn");
     session.setAttribute("isbn",isbnn);  
 
 %>
  <h1>  ISBN:<%=request.getParameter("isbn")%> 修改信息</h1>
        <s:textfield name="name" label="作家名"/>
        <s:textfield name="publisher" label="出版社"/>
        <s:textfield name="publishdate" label="出版日期"/>
        <s:textfield name="price" label="价格"/>
        <s:submit value="修改"/>
    </s:form>

</body>
</html>