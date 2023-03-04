<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>GIFT - Add student</title>
</head>
<l:genericpage>
  <jsp:attribute name="header">
    <jsp:include page="../partials/authenticated-header.jsp">
        <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
    </jsp:include>
  </jsp:attribute>

  <jsp:body>
    <h1 class="mt-2 mb-6 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
      Add a new intern to follow-up
    </h1>

    <form name="new-student" method="post" action="new-student">
      <l:two-column-form>
        <jsp:attribute name="formTitle">
          <h3 class="text-base font-semibold leading-6 text-gray-900">Student</h3>
          <p class="mt-1 text-sm text-gray-600">
            This section is about the student who do his internship.
          </p>
        </jsp:attribute>
        <jsp:body>
          <l:form-card>
            <div class="grid grid-cols-6 gap-6">
              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-text-group.jsp">
                  <jsp:param name="labelText" value="First Name"/>
                  <jsp:param name="formId" value="firstname"/>
                  <jsp:param name="formName" value="firstname"/>
                  <jsp:param name="formPlaceholder" value="Jonh"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-text-group.jsp">
                  <jsp:param name="labelText" value="Last Name"/>
                  <jsp:param name="formId" value="lastname"/>
                  <jsp:param name="formName" value="lastname"/>
                  <jsp:param name="formPlaceholder" value="Doe"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-text-group.jsp">
                  <jsp:param name="labelText" value="Group"/>
                  <jsp:param name="formId" value="group"/>
                  <jsp:param name="formName" value="group"/>
                  <jsp:param name="formPlaceholder" value="M2"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>
            </div>
          </l:form-card>
        </jsp:body>
      </l:two-column-form>

      <div class="hidden sm:block" aria-hidden="true">
        <div class="py-5">
          <div class="border-t border-gray-200"></div>
        </div>
      </div>

      <l:two-column-form>
        <jsp:attribute name="formTitle">
          <h3 class="text-base font-semibold leading-6 text-gray-900">Company</h3>
          <p class="mt-1 text-sm text-gray-600">
            Fill out information about the company where the student will do his
            internship.
          </p>
        </jsp:attribute>
        <jsp:body>
          <l:form-card>
            <div class="grid grid-cols-6 gap-6">
              <div class="col-span-6 sm:col-span-4">
                <jsp:include page="../partials/input-text-group.jsp">
                  <jsp:param name="labelText" value="Company Name"/>
                  <jsp:param name="formId" value="companyname"/>
                  <jsp:param name="formName" value="companyname"/>
                  <jsp:param name="formPlaceholder" value="ACME"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="hidden sm:block sm:col-span-2" aria-hidden="true"></div>

              <div class="col-span-6 sm:col-span-4">
                <jsp:include page="../partials/textarea-group.jsp">
                  <jsp:param name="labelText" value="Company Address"/>
                  <jsp:param name="formId" value="companyaddress"/>
                  <jsp:param name="formName" value="companyaddress"/>
                  <jsp:param name="formPlaceholder" value="2 Boulevard Vaneau, Chelsea "/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="hidden sm:block sm:col-span-2" aria-hidden="true"></div>

              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-text-group.jsp">
                  <jsp:param name="labelText" value="Tutor Name"/>
                  <jsp:param name="formId" value="tutorname"/>
                  <jsp:param name="formName" value="tutorname"/>
                  <jsp:param name="formPlaceholder" value="Jane Smith"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>
            </div>
          </l:form-card>
        </jsp:body>
      </l:two-column-form>

      <div class="hidden sm:block" aria-hidden="true">
        <div class="py-5">
          <div class="border-t border-gray-200"></div>
        </div>
      </div>

      <l:two-column-form>
        <jsp:attribute name="formTitle">
          <h3 class="text-base font-semibold leading-6 text-gray-900">Internship</h3>
          <p class="mt-1 text-sm text-gray-600">
            What the intern will do during his internship.
          </p>
        </jsp:attribute>
        <jsp:body>
          <l:form-card>
            <div class="grid grid-cols-6 gap-6">
              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-date-group.jsp">
                  <jsp:param name="labelText" value="Start date"/>
                  <jsp:param name="formId" value="startdate"/>
                  <jsp:param name="formName" value="startdate"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <jsp:include page="../partials/input-date-group.jsp">
                  <jsp:param name="labelText" value="End date"/>
                  <jsp:param name="formId" value="enddate"/>
                  <jsp:param name="formName" value="enddate"/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>

              <div class="col-span-6">
                <jsp:include page="../partials/textarea-group.jsp">
                  <jsp:param name="labelText" value="Description of the mission"/>
                  <jsp:param name="formId" value="mission"/>
                  <jsp:param name="formName" value="mission"/>
                  <jsp:param name="formPlaceholder" value=""/>
                  <jsp:param name="formRequired" value="true"/>
                </jsp:include>
              </div>
            </div>
          </l:form-card>
        </jsp:body>
      </l:two-column-form>

      <div class="hidden sm:block" aria-hidden="true">
        <div class="py-5">
          <div class="border-t border-gray-200"></div>
        </div>
      </div>

      <div class="py-3 text-right">
        <button type="submit"
                class="inline-flex justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
          Save
        </button>
      </div>
    </form>
  </jsp:body>
</l:genericpage>
</html>
