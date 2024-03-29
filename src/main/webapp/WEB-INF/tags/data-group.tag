<%@tag description="Card" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" required="true" type="java.lang.String" %>

<div class="mb-2 sm:grid sm:grid-cols-3 sm:gap-4">
  <dt class="text-sm font-medium text-gray-500"><c:out value="${title}"/></dt>
  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2 sm:mt-0">
    <jsp:doBody/>
  </dd>
</div>
