<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 5/23/2025
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    <label>ID</label>
    <form:input path="id"/><br>
    <label>Name</label>
    <form:input path="name"/><br>
    <label>Gender</label>
    <form:radiobutton path="gender" value="1"/>Male
    <form:radiobutton path="gender" value="0"/>Female
    <form:radiobutton path="gender" value="-1"/>LGBT<br>
    <label>Languages</label>
    <form:checkboxes path="languages" items="${languages}"/><br>
<%--    <form:select path="classCG">--%>
<%--        <form:options items="${classList}" itemValue="id" itemLabel="name"/>--%>
<%--    </form:select>--%>
    <button>Save</button>
</form:form>
<%--<form action="/students/add" method="post">--%>
<%--    <input name="id" placeholder="Enter id">--%>
<%--    <input name="name" placeholder="Enter name">--%>
<%--    <button>Save</button>--%>
<%--</form>--%>





















<%--<form:form modelAttribute="student" action="/student/create" method="post">--%>
<%--    ID--%>
<%--    <form:input path="id"/><br>--%>
<%--    Name--%>
<%--    <form:input path="name"/><br>--%>
<%--    Gender--%>
<%--    <form:select path="gender">--%>
<%--        <form:option value="1">Nam</form:option>--%>
<%--        <form:option value="0">Nữ</form:option>--%>
<%--        <form:option value="-1">LGBT</form:option>--%>
<%--    </form:select>--%>
<%--    &lt;%&ndash;    <form:radiobutton path="gender" value="1"/>Nam&ndash;%&gt;--%>
<%--    &lt;%&ndash;    <form:radiobutton path="gender" value="0"/>Nữ&ndash;%&gt;--%>
<%--    &lt;%&ndash;    <form:radiobutton path="gender" value="-1"/>LBGT&ndash;%&gt;--%>
<%--    Languages--%>
<%--    <form:checkboxes path="languages" items="${ngonNgu}"/>--%>
<%--    Class room--%>
<%--    <form:select path="classRoom">--%>
<%--        <form:options items="${classList}" itemValue="id" itemLabel="name" />--%>
<%--    </form:select>--%>
<%--    <form:button>Add</form:button>--%>
<%--</form:form>--%>
</body>
</html>
