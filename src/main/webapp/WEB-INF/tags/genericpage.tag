<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- source: https://stackoverflow.com/a/13103364 -->
<%@attribute name="title" type="java.lang.String" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title><c:out value="${title}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/output.css">
</head>
<body class="bg-gray-100">
<header class="mb-4" id="pageheader">
    <jsp:invoke fragment="header"/>
</header>
<main class="mx-auto mb-8 max-w-7xl px-2 sm:px-6 lg:px-8">
    <jsp:doBody/>
</main>
<footer id="pagefooter">
    <jsp:invoke fragment="footer"/>
</footer>
</body>