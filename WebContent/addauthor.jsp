<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>添加作者</title>
</head>
<body>
    <h1>添加作者</h1>

    <s:form action="addauthor">
        <s:textfield name="isbn" label="ISBN" readonly="true"/>
        <s:textfield name="authorid" label="编号" readonly="true"/>
        <s:textfield name="name" label="作家名" readonly="true"/>
        <s:textfield name="age" label="年龄"/>
        <s:textfield name="country" label="国籍"/>
        <s:submit value="添加"/>
    </s:form>
</body>
</html>