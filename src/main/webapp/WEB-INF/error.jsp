<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- source: https://tailwindui.com/components/marketing/feedback/404-pages -->
<l:genericpage>
  <jsp:attribute name="title">
    GIFT - Error Page
  </jsp:attribute>
  <jsp:body>
    <div class="grid min-h-full place-items-center bg-white rounded-xl shadow-xl py-24 px-6 sm:py-32 lg:px-8 mt-10 h-[60vh] mt-[20vh]">
      <div class="text-center">
        <p class="text-base font-semibold text-indigo-600">ERROR ${pageContext.response.status}</p>
        <h1 class="mt-4 text-3xl font-bold tracking-tight text-gray-900 sm:text-5xl">
          <c:out value="${pageContext.exception.localizedMessage}" default="We are sorry"/>
        </h1>
        <p class="mt-6 text-base leading-7 text-gray-600">An error occur, please retry later.</p>
        <div class="mt-10 flex items-center justify-center gap-x-6">
          <a href="${pageContext.servletContext.contextPath}/"
             class="rounded-md bg-indigo-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Go
            back home</a>
        </div>
      </div>
    </div>
  </jsp:body>
</l:genericpage>
