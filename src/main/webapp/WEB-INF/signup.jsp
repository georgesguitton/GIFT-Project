<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
<title>Sign Up to GIFT</title>
</head>
<body class="flex min-h-full items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
<main class="w-full max-w-md space-y-8">
    <div>
        <h2 class="mt-6 text-center text-2xl font-bold tracking-tight text-gray-900">Register to</h2>
        <h3 class="mt-4 text-center text-3xl text-gray-700">Great Intern Follow-up Tool</h3>
    </div>
    <form class="mt-8 space-y-6" method="POST" action="signup">
        <div class="space-y-2 rounded-md shadow-sm">
            <jsp:include page="partials/input-text-group.jsp">
                <jsp:param name="labelText" value="First Name"/>
                <jsp:param name="formId" value="firstname"/>
                <jsp:param name="formName" value="firstname"/>
                <jsp:param name="formPlaceholder" value="Jonh"/>
                <jsp:param name="formRequired" value="true"/>
            </jsp:include>

            <jsp:include page="partials/input-text-group.jsp">
                <jsp:param name="labelText" value="Last Name"/>
                <jsp:param name="formId" value="lastname"/>
                <jsp:param name="formName" value="lastname"/>
                <jsp:param name="formPlaceholder" value="Doe"/>
            </jsp:include>

            <jsp:include page="partials/input-email-group.jsp">
                <jsp:param name="labelText" value="Email"/>
                <jsp:param name="formId" value="email"/>
                <jsp:param name="formName" value="email"/>
                <jsp:param name="formPlaceholder" value="jonh.doe@gift.fr"/>
            </jsp:include>

            <jsp:include page="partials/input-password-group.jsp">
                <jsp:param name="labelText" value="Password"/>
                <jsp:param name="formId" value="password"/>
                <jsp:param name="formName" value="password"/>
                <jsp:param name="formPlaceholder" value="strong password"/>
            </jsp:include>
        </div>

        <div class="group relative flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
            <button type="submit">Sign Up</button>
        </div>
    </form>
</main>
</body>
</html>

