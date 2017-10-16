<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>图书作者查询</title>
    </head>
    <body>
     <h1 align="center">图书作者查询：</h1>
        <s:form action="searchauthor">
                     作者：<s:textfield name="name" />
            <s:submit value="查询" />	
        </s:form>
    <br/>
    <input type="button" value="返回主页" onclick="window.location='nn.jsp'">
    
    </body>
    
</html>