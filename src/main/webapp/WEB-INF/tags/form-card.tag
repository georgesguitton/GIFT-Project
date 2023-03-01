<%@tag description="Form card" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- source: https://tailwindui.com/components/application-ui/forms/form-layouts -->
<%@attribute name="footer" fragment="true" %>

<div class="shadow sm:overflow-hidden sm:rounded-md">
    <div class="space-y-6 bg-white px-4 py-5 sm:p-6">
        <jsp:doBody/>
    </div>
    <c:choose>
        <c:when test="${not empty footer}">
            <div class="bg-gray-50 px-4 py-3 text-right sm:px-6">
                <jsp:invoke fragment="footer"/>
            </div>
        </c:when>
    </c:choose>
</div>
