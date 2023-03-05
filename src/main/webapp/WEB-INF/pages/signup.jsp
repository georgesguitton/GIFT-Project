<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>

<l:genericpage>
    <jsp:attribute name="title">
        Sign Up to GIFT
    </jsp:attribute>

    <jsp:attribute name="header">
        <h2 class="mt-12 text-center text-2xl text-gray-900">Register to</h2>
        <h3 class="mt-4 text-center text-3xl tracking-tight font-bold text-gray-700">Great Intern Follow-up Tool</h3>
    </jsp:attribute>
    <jsp:body>
        <div class="flex items-center justify-center px-4 pb-12 sm:px-6 lg:px-8">
            <div class="w-full max-w-md space-y-8">
                <form class="mt-8 space-y-6" method="POST" action="signup">
                    <div class="space-y-2 rounded-md shadow-sm">
                        <jsp:include page="../partials/input-text-group.jsp">
                            <jsp:param name="labelText" value="First Name"/>
                            <jsp:param name="formId" value="firstname"/>
                            <jsp:param name="formName" value="firstname"/>
                            <jsp:param name="formPlaceholder" value="Jonh"/>
                            <jsp:param name="formRequired" value="true"/>
                        </jsp:include>

                        <jsp:include page="../partials/input-text-group.jsp">
                            <jsp:param name="labelText" value="Last Name"/>
                            <jsp:param name="formId" value="lastname"/>
                            <jsp:param name="formName" value="lastname"/>
                            <jsp:param name="formPlaceholder" value="Doe"/>
                        </jsp:include>

                        <jsp:include page="../partials/input-email-group.jsp">
                            <jsp:param name="labelText" value="Email"/>
                            <jsp:param name="formId" value="email"/>
                            <jsp:param name="formName" value="email"/>
                            <jsp:param name="formPlaceholder" value="jonh.doe@gift.fr"/>
                        </jsp:include>

                        <jsp:include page="../partials/input-password-group.jsp">
                            <jsp:param name="labelText" value="Password"/>
                            <jsp:param name="formId" value="password"/>
                            <jsp:param name="formName" value="password"/>
                            <jsp:param name="formPlaceholder" value="strong password"/>
                        </jsp:include>
                    </div>

                    <div>
                        <button type="submit"
                                class="group relative flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
                            Submit
                        </button>

                        <a href="my-dashboard" class="block mt-2 text-sm text-center font-medium text-indigo-600 hover:text-indigo-500">
                            Login instead
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</l:genericpage>
