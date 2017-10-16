<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>作者添加成功</title>
</head>
<body>
<h1 align="center">作者添加成功</h1>
   <% String isbnn = (String)session.getAttribute("isbn");
   String author = (String)session.getAttribute("name");

  out.print("<a href= editpage.jsp?isbn="+isbnn+">继续修改图书信息</a>");


 %>
</body>
<br/>
<br/>
<a href= addbook.jsp>继续添加图书</a>
</html>