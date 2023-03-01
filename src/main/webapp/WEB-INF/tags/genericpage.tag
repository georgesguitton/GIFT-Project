<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<!-- source: https://stackoverflow.com/a/13103364 -->
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<body>
<header id="pageheader">
    <jsp:invoke fragment="header"/>
</header>
<main class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
    <jsp:doBody/>
</main>
<footer id="pagefooter">
    <jsp:invoke fragment="footer"/>
</footer>
</body>