<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to GIFT</title>
</head>
<l:genericpage>
<jsp:attribute name="header">
<jsp:include page="../partials/authenticated-header.jsp">
    <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
</jsp:include>
</jsp:attribute>
<jsp:body>
<section class="mb-6">
    <h1 class="mt-2 mb-6 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
        Welcome to the tutor portal!
    </h1>

    <p class="mt-4 text-xl text-gray-500">
        GIFT is your Great Intern follow-up tool.<br>
        This platform, in continuous development, will help you to track
        the milestones of the students you follow during their internship.
    </p>
</section>

<section>
    <div class="mt-12 flex flex-col lg:flex-row lg:items-center lg:justify-between gap-4">
        <h2 class="flex-1 text-2xl font-bold tracking-tight text-gray-900">List of my students</h2>
        <div class="flex">
            <a href="new-student" class="inline-flex justify-center rounded-md bg-indigo-600 py-2 px-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">Add student</a>
        </div>
    </div>

    <ul class="mt-6 space-y-6">
        <%--@elvariable id="students" type="java.util.List<com.gift.giftproject.model.StudentEntity>"--%>
        <c:forEach items="${students}" var="student">
            <li>
                <l:card>
                    <div class="grid grid-cols-6 gap-4 divide-y sm:divide-y-0">
                        <a href="edit-student?studentId=${student.id}" class="p-2 hover:bg-slate-200 hover:rounded-md col-span-6 sm:col-span-3 md:col-span-2">
                            <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Trainee Information</h3>
                            <div class="col-span-6 sm:col-span-2">
                                <dl>
                                    <l:data-group title="ID">${student.id}</l:data-group>
                                    <l:data-group title="Last Name">${student.lastname}</l:data-group>
                                    <l:data-group title="First Name">${student.firstname}</l:data-group>
                                    <l:data-group title="Group">${student.studentGroup}</l:data-group>
                                </dl>
                            </div>
                        </a>

                        <div class="p-2 hover:bg-slate-200 hover:rounded-md col-span-6 sm:col-span-3 md:col-span-2 pt-4 md:pt-0">
                            <a href="edit-student?studentId=${student.id}">
                                <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Internship Information</h3>
                            </a>
                            <a href="edit-student?studentId=${student.id}" class="col-span-6 sm:col-span-2">
                                <dl>
                                    <l:data-group title="Company Name">${student.internshipByIdInternship.companyName}</l:data-group>
                                    <l:data-group title="Address">${student.internshipByIdInternship.companyAddress}</l:data-group>
                                    <l:data-group title="Company Tutor">${student.internshipByIdInternship.companyTutor}</l:data-group>
                                    <l:data-group title="Period">
                                        From <fmt:formatDate value="${student.internshipByIdInternship.startDate}"/>
                                        to <fmt:formatDate value="${student.internshipByIdInternship.endDate}"/>
                                    </l:data-group>
                                </dl>
                            </a>

                            <l:data-group title="Visit">
                                <span class="block sm:inline sm:pr-4">
                                    <input type="checkbox" class="rounded-sm" id="student${student.id}_visitPlanified" name="student${student.id}_visitPlanified" ${student.internshipByIdInternship.visitPlanified && "checked"}/>
                                    <label for="student${student.id}_visitPlanified">Planed</label>
                                </span>
                                <span class="block sm:inline">
                                    <input type="checkbox" class="rounded-sm" id="student${student.id}_visitDone" name="student${student.id}_visitDone" ${student.internshipByIdInternship.visitDone && "checked"}/>
                                    <label for="student${student.id}_visitDone">Done</label>
                                </span>
                            </l:data-group>
                        </div>

                        <div class="p-2 col-span-6 sm:col-span-3 md:col-span-2 pt-4 md:pt-0">
                            <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Document status</h3>
                            <div class="col-span-6 sm:col-span-2">
                                <dl>
                                    <l:data-group title="Spec">
                                        <input type="checkbox" class="rounded-sm" id="student${student.id}_specsDone" name="student${student.id}_specsDone" ${student.documentsByIdDocuments.specsDone && "checked"}/>
                                        <label for="student${student.id}_specsDone">Done</label>
                                    </l:data-group>
                                    <l:data-group title="Visit form">
                                        <input type="checkbox" class="rounded-sm" id="student${student.id}_visitFormDone" name="student${student.id}_visitFormDone" ${student.documentsByIdDocuments.visitFormDone && "checked"}/>
                                        <label for="student${student.id}_visitFormDone">Done</label>
                                    </l:data-group>
                                    <l:data-group title="Company feeling">
                                        <input type="checkbox" class="rounded-sm" id="student${student.id}_companyEvalFormDone" name="student${student.id}_companyEvalFormDone" ${student.documentsByIdDocuments.companyEvalFormDone && "checked"}/>
                                        <label for="student${student.id}_companyEvalFormDone">Done</label>
                                    </l:data-group>
                                    <l:data-group title="Web form">
                                        <input type="checkbox" class="rounded-sm" id="student${student.id}_webPollDone" name=student${student.id}_webPollDone" ${student.documentsByIdDocuments.webPollDone && "checked"}/>
                                        <label for="student${student.id}_webPollDone">Done</label>
                                    </l:data-group>
                                    <l:data-group title="Final report">
                                        <input type="checkbox" class="rounded-sm" id="student${student.id}_reportDone" name="student${student.id}_reportDone" ${student.documentsByIdDocuments.reportDone && "checked"}/>
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

</jsp:body>
</l:genericpage>
<html>
