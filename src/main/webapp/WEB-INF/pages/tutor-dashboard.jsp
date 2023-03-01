<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to GIFT</title>
</head>
<l:genericpage>
<jsp:attribute name="header">
<jsp:include page="../partials/authenticated-header.jsp">
    <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
</jsp:include>
</jsp:attribute>
<jsp:body>
Hello world!
</jsp:body>
</l:genericpage>
<html>
