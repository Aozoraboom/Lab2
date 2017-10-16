<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>图书库与作者库</title>
<body>

    <h1>
       作者库
    </h1>
<table border="1" align="center">
<tr>
    <td align="center">编号</td>
    <td align="center">姓名</td>
    <td align="center">年龄</td>
    <td align="center">国家</td>

    <%List<String> list0 = (List<String>)session.getAttribute("list0");
    if(null == list0 || list0.size() ==0 )
    { out.print("<tr>");
    	for (int i = 0; i < 4; i++){
    		out.print("<td align=\"center\">暂无</td>");
    	}out.print("</tr>");
    }
    else{
    	for (int i = 0; i < list0.size(); i=i+4) {
    		out.print("<tr>");
            out.print("<td align=\"center\">"+list0.get(i)+"</td>");
            out.print("<td align=\"center\">"+list0.get(i+1)+"</td>");
            out.print("<td align=\"center\">"+list0.get(i+2)+"</td>");
            out.print("<td align=\"center\">"+list0.get(i+3)+"</td>");
        	out.print("</tr>");
    	}
    	} %>

</table>
<h1>图书库</h1>
<table border="1" align="center">
<tr>
    <td align="center">ISBN</td>
    <td align="center">书名</td>
    <td align="center">作者编号</td>
    <td align="center">出版社</td>
    <td align="center">出版日期</td>
    <td align="center">价格</td>
    <td align="center">修改</td>
    <td align="center">删除</td>
</tr>
    <%List<String> list = (List<String>)session.getAttribute("list");
    if(null == list || list.size() ==0)
    {
    	out.print("<tr>");
    	for (int i = 0; i < 8; i++){
    	
    	out.print("<td align=\"center\">暂无</td>");
    	
    	}out.print("</tr>");}
    else {for (int i = 0; i < list.size(); i+=6) {
    	out.print("<tr>");
  out.print("<td align=\"center\">"+list.get(i)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+1)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+2)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+3)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+4)+"</td>");
  out.print("<td align=\"center\">"+list.get(i+5)+"</td>");
  out.print("<td align=\"center\"><a href= editpage.jsp?isbn="+list.get(i)+">修改</a></td>");
  out.print("<td align=\"center\"><a href= delete?isbn="+list.get(i)+">删除</a></td>");
  out.print("</tr>");
}}%>


</table>
<br/>
<input type="button" value="返回主页" onclick="window.location='nn.jsp'">
<input type="button" value="添加图书" onclick="window.location='addbook.jsp'">
</body>
</html>