<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>

<l:genericpage>
    <jsp:attribute name="title">
        Welcome to GIFT
    </jsp:attribute>

    <jsp:attribute name="header">
        <jsp:include page="../partials/authenticated-header.jsp">
            <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
        </jsp:include>
    </jsp:attribute>

    <jsp:body>
        <section class="mb-6">
            <c:choose>
                <%--@elvariable id="query" type="java.lang.String"--%>
                <c:when test="${empty query}">
                    <h1 class="mt-2 mb-6 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
                        Welcome to the tutor portal!
                    </h1>
                    <p class="mt-4 text-xl text-gray-500">
                        GIFT is your Great Intern follow-up tool.<br>
                        This platform, in continuous development, will help you to track
                        the milestones of the students you follow during their internship.
                    </p>
                </c:when>
                <c:otherwise>
                    <h1 class="mt-2 mb-6 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
                        Search result for: "<c:out value="${query}"/>"
                    </h1>
                </c:otherwise>
            </c:choose>
        </section>

        <section>
            <div class="mt-12 flex flex-col lg:flex-row lg:items-center lg:justify-between gap-4">
                <h2 class="flex-1 text-2xl font-bold tracking-tight text-gray-900">List of my students</h2>
                <div class="block sm:flex gap-4">
                    <form class="flex mb-2 sm:mb-0">
                        <label for=search" class="sr-only">Search student by keywords, names, company...</label>
                        <input id=search" type="search" name="searchQuery"
                               class="w-full rounded-l-lg border border-gray-300 px-3 py-2 focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
                               placeholder="Search student by keywords, names, company...">
                        <button type="submit"
                                class="rounded-r-lg bg-indigo-600 py-2 px-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">
                            Search
                        </button>
                    </form>
                    <a href="new-student"
                       class="block rounded-md text-center bg-indigo-600 py-2 px-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">
                        Add student
                    </a>
                </div>
            </div>

            <ul class="mt-6 space-y-6">
                    <%--@elvariable id="students" type="java.util.List<com.gift.giftproject.model.StudentEntity>"--%>
                <c:forEach items="${students}" var="student">
                    <li>
                        <input type="hidden" name="studentIds" value="${student.id}">
                        <l:card>
                            <div class="grid grid-cols-6 gap-4 divide-y sm:divide-y-0">
                                <a href="edit-student?studentId=${student.id}"
                                   class="p-2 hover:bg-slate-200 hover:rounded-md col-span-6 sm:col-span-3 md:col-span-2">
                                    <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Trainee Information</h3>
                                    <div class="col-span-6 sm:col-span-2">
                                        <dl>
                                            <l:data-group title="ID">${student.id}</l:data-group>
                                            <l:data-group title="Name">${student.firstname} ${student.lastname}</l:data-group>
                                            <l:data-group title="Group">${student.studentGroup}</l:data-group>
                                            <l:data-group title="Grades">
                                                Tech: ${student.evaluationsByIdEvaluations.technicalGrade},
                                                Comm: ${student.evaluationsByIdEvaluations.communicationGrade}
                                            </l:data-group>
                                            <l:data-group title="Soutenance">
                                                ${student.evaluationsByIdEvaluations.oralPresentation  ? "Done" : "To do"}
                                            </l:data-group>
                                        </dl>
                                    </div>
                                </a>

                                <div class="p-2 hover:bg-slate-200 hover:rounded-md col-span-6 sm:col-span-3 md:col-span-2 pt-4 md:pt-0">
                                    <a href="edit-student?studentId=${student.id}">
                                        <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Internship
                                            Information</h3>
                                    </a>
                                    <a href="edit-student?studentId=${student.id}" class="col-span-6 sm:col-span-2">
                                        <dl>
                                            <l:data-group title="Company Name">
                                                <c:out value="${student.internshipByIdInternship.companyName}"/>
                                            </l:data-group>
                                            <l:data-group title="Address">
                                                <c:out value="${student.internshipByIdInternship.companyAddress}"/>
                                            </l:data-group>
                                            <l:data-group title="Company Tutor">
                                                <c:out value="${student.internshipByIdInternship.companyTutor}"/>
                                            </l:data-group>
                                            <l:data-group title="Period">
                                                From <fmt:formatDate value="${student.internshipByIdInternship.startDate}"/>
                                                to <fmt:formatDate value="${student.internshipByIdInternship.endDate}"/>
                                            </l:data-group>
                                            <l:data-group title="Mission">
                                                <c:out value="${student.internshipByIdInternship.mission}"/>
                                            </l:data-group>
                                        </dl>
                                    </a>

                                    <l:data-group title="Visit">
                                        <span class="block sm:inline sm:pr-4">
                                            <input type="checkbox" class="accent-indigo-600 rounded-sm" id="student${student.id}_visitPlanified"
                                                   name="student${student.id}_visitPlanified" ${student.internshipByIdInternship.visitPlanified ? "checked" : ""}/>
                                            <label for="student${student.id}_visitPlanified">Planed</label>
                                        </span>
                                            <span class="block sm:inline">
                                            <input type="checkbox" class="accent-indigo-600 rounded-sm" id="student${student.id}_visitDone"
                                                   name="student${student.id}_visitDone" ${student.internshipByIdInternship.visitDone ? "checked" : ""}
                                                   form="bulk-update"/>
                                            <label for="student${student.id}_visitDone">Done</label>
                                        </span>
                                        </l:data-group>
                                    </div>

                                    <div class="p-2 hover:bg-slate-200 col-span-6 sm:col-span-3 md:col-span-2 pt-4 md:pt-0">
                                        <a href="edit-student?studentId=${student.id}">
                                            <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Document status</h3>
                                        </a>
                                        <div class="col-span-6 sm:col-span-2">
                                            <dl>
                                                <l:data-group title="Spec">
                                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="student${student.id}_specsDone"
                                                           name="student${student.id}_specsDone" ${student.documentsByIdDocuments.specsDone ? "checked" : ""}
                                                           form="bulk-update"/>
                                                    <label for="student${student.id}_specsDone">Done</label>
                                                </l:data-group>
                                                <l:data-group title="Visit form">
                                                    <input type="checkbox" class="accent-indigo-600 rounded-sm"
                                                           id="student${student.id}_visitFormDone"
                                                           name="student${student.id}_visitFormDone" ${student.documentsByIdDocuments.visitFormDone ? "checked" : ""}
                                                           form="bulk-update"/>
                                                    <label for="student${student.id}_visitFormDone">Done</label>
                                                </l:data-group>
                                                <l:data-group title="Company feeling">
                                                    <input type="checkbox" class="accent-indigo-600 rounded-sm"
                                                           id="student${student.id}_companyEvalFormDone"
                                                           name="student${student.id}_companyEvalFormDone" ${student.documentsByIdDocuments.companyEvalFormDone ? "checked" : ""}
                                                           form="bulk-update"/>
                                                    <label for="student${student.id}_companyEvalFormDone">Done</label>
                                                </l:data-group>
                                                <l:data-group title="Web form">
                                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="student${student.id}_webPollDone"
                                                           name=student${student.id}_webPollDone" ${student.documentsByIdDocuments.webPollDone ? "checked" : ""}
                                                           form="bulk-update"/>
                                                    <label for="student${student.id}_webPollDone">Done</label>
                                                </l:data-group>
                                                <l:data-group title="Final report">
                                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="student${student.id}_reportDone"
                                                           name="student${student.id}_reportDone" ${student.documentsByIdDocuments.reportDone ? "checked" : ""}
                                                           form="bulk-update"/>
                                                    <label for="student${student.id}_reportDone">Done</label>
                                                </l:data-group>
                                            </dl>
                                        </div>
                                    </div>
                                </div>

                                <form method="POST" action="destroy-student" class="mb-0">
                                    <input type="hidden" name="studentId" value="${student.id}" />
                                    <div class="mt-6 text-left sm:text-right">
                                        <button type="submit" class="inline-flex justify-center rounded-md bg-indigo-600 py-2 px-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">Delete</button>
                                    </div>
                                </form>
                            </l:card>
                        </li>
                    </c:forEach>
            </ul>
        </section>

        <section class="mt-12">
            <div class="hidden sm:block" aria-hidden="true">
                <div class="pb-5">
                    <div class="border-t border-gray-200"></div>
                </div>
            </div>

            <div class="py-3 text-right">
                <button type="submit"
                        class="inline-flex justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
                        form="bulk-update">
                    Save
                </button>
            </div>
        </section>

        <form id="bulk-update" method="POST" action="bulk-update"></form>
    </jsp:body>
</l:genericpage>
