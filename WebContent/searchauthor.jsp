<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>查询结果</title>
</head>
<body>
  <h2>
        <s:property value="name" />作品：
    </h2>
    <center>书籍名称</center>
<table border="1" align="center">
    <% List<String> list = (List<String>) session.getAttribute("list");
    if(null == list || list.size() ==0 )
    { out.print("<tr><td 暂无></td></tr>");

    }
    String name = (String)session.getAttribute("name");
    for (int i = 0; i < list.size(); i++) {
    	
    	String title= list.get(i);
    	  out.print("<tr><td align=\"center\"><a href=show?name="+name+"&title="+list.get(i)+">"+list.get(i)+"</a></td></tr>");
    } %>

</table>
<input type="button" value="返回主页" onclick="window.location='nn.jsp'">
</body>
</html>