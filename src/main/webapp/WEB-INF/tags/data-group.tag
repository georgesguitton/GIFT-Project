<%@tag description="Card" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" type="java.lang.String" %>

<div class="bg-white sm:grid sm:grid-cols-3 sm:gap-4">
  <dt class="text-sm font-medium text-gray-500">${title}</dt>
  <dd class="mt-1 text-sm text-gray-900 sm:col-span-2 sm:mt-0">
    <jsp:doBody/>
  </dd>
</div>
