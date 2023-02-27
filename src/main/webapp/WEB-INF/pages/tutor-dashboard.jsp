<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Welcome to GIFT</title>
</head>
<body>
<jsp:include page="../partials/authenticated-header.jsp">
    <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
</jsp:include>
<main class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
    Hello world!
</main>
</body>
</html>
