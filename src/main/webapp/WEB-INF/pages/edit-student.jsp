<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<l:genericpage>
    <jsp:attribute name="title">
        GIFT - Student
    </jsp:attribute>

    <jsp:attribute name="header">
        <jsp:include page="../partials/authenticated-header.jsp">
            <jsp:param name="username" value="${pageContext.request.remoteUser}"/>
        </jsp:include>
    </jsp:attribute>

    <jsp:body>
        <%--@elvariable id="student" type="com.gift.giftproject.model.StudentEntity"--%>
        <section class="mb-6">
            <h1 class="mt-2 mb-6 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
                Student detail of #${student.id}
            </h1>
        </section>

        <form method="POST" action="edit-student">
            <input type="hidden" name="studentId" value="${student.id}"/>
            <div class="grid grid-cols-6 sm:grid-rows-2 gap-4 divide-y sm:divide-y-0">
                <div class="col-span-6 sm:col-span-2">
                    <l:card>
                        <div class="sm:pb-[2.3em]">
                            <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Trainee Details</h3>
                            <jsp:include page="../partials/input-text-group.jsp">
                                <jsp:param name="labelText" value="First Name"/>
                                <jsp:param name="formId" value="firstname"/>
                                <jsp:param name="formName" value="firstname"/>
                                <jsp:param name="formValue" value="${student.firstname}"/>
                                <jsp:param name="formRequired" value="true"/>
                            </jsp:include>

                            <jsp:include page="../partials/input-text-group.jsp">
                                <jsp:param name="labelText" value="Last Name"/>
                                <jsp:param name="formId" value="lastname"/>
                                <jsp:param name="formName" value="lastname"/>
                                <jsp:param name="formValue" value="${student.lastname}"/>
                                <jsp:param name="formRequired" value="true"/>
                            </jsp:include>

                            <jsp:include page="../partials/input-text-group.jsp">
                                <jsp:param name="labelText" value="Group"/>
                                <jsp:param name="formId" value="group"/>
                                <jsp:param name="formName" value="group"/>
                                <jsp:param name="formValue" value="${student.studentGroup}"/>
                                <jsp:param name="formRequired" value="true"/>
                            </jsp:include>
                        </div>
                    </l:card>
                </div>

                <div class="col-span-6 sm:col-span-2">
                    <l:card>
                        <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Company Details</h3>
                        <jsp:include page="../partials/input-text-group.jsp">
                            <jsp:param name="labelText" value="Company Name"/>
                            <jsp:param name="formId" value="companyname"/>
                            <jsp:param name="formName" value="companyname"/>
                            <jsp:param name="formValue" value="${student.internshipByIdInternship.companyName}"/>
                            <jsp:param name="formRequired" value="true"/>
                        </jsp:include>

                        <jsp:include page="../partials/input-text-group.jsp">
                            <jsp:param name="labelText" value="Company Address"/>
                            <jsp:param name="formId" value="companyaddress"/>
                            <jsp:param name="formName" value="companyaddress"/>
                            <jsp:param name="formValue" value="${student.internshipByIdInternship.companyAddress}"/>
                            <jsp:param name="formRequired" value="true"/>
                        </jsp:include>

                        <jsp:include page="../partials/input-text-group.jsp">
                            <jsp:param name="labelText" value="Tutor Name"/>
                            <jsp:param name="formId" value="tutorname"/>
                            <jsp:param name="formName" value="tutorname"/>
                            <jsp:param name="formValue" value="${student.internshipByIdInternship.companyTutor}"/>
                            <jsp:param name="formRequired" value="true"/>
                        </jsp:include>

                        <div class="mt-2">
                            <l:data-group title="Visit">
                            <span class="block sm:inline sm:pr-4">
                                <input type="checkbox" class="accent-indigo-600 rounded-sm"
                                       id="visitPlanified"
                                       name="visitPlanified" ${student.internshipByIdInternship.visitPlanified ? "checked" : ""}/>
                                <label for="visitPlanified">Planed</label>
                            </span>
                                <span class="block sm:inline">
                                <input type="checkbox" class="accent-indigo-600 rounded-sm"
                                       id="visitDone"
                                       name="visitDone" ${student.internshipByIdInternship.visitDone ? "checked" : ""}/>
                                <label for="visitDone">Done</label>
                            </span>
                            </l:data-group>
                        </div>
                    </l:card>
                </div>

                <div class="col-span-6 sm:col-span-2 sm:row-span-2">
                    <l:card>
                        <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Document status</h3>
                        <div class="col-span-6 sm:col-span-2">
                            <dl>
                                <l:data-group title="Specifications">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="specDone"
                                           name="specDone" ${student.documentsByIdDocuments.specsDone ? "checked" : ""}/>
                                    <label for="specDone">Done</label>
                                </l:data-group>
                                <l:data-group title="Visit form">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="visitFormDone"
                                           name="visitFormDone" ${student.documentsByIdDocuments.visitFormDone ? "checked" : ""}/>
                                    <label for="visitFormDone">Done</label>
                                </l:data-group>
                                <l:data-group title="Company feeling">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="companyEvalFormDone"
                                           name="companyEvalFormDone" ${student.documentsByIdDocuments.companyEvalFormDone ? "checked" : ""}/>
                                    <label for="companyEvalFormDone">Done</label>
                                </l:data-group>
                                <l:data-group title="Web form">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="webPollDone"
                                           name="webPollDone" ${student.documentsByIdDocuments.webPollDone ? "checked" : ""}/>
                                    <label for="webPollDone">Done</label>
                                </l:data-group>
                                <l:data-group title="Final report">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="reportDone"
                                           name="reportDone" ${student.documentsByIdDocuments.reportDone ? "checked" : ""}/>
                                    <label for="reportDone">Done</label>
                                </l:data-group>
                            </dl>
                        </div>

                        <h3 class="pt-4 pb-2 text-base font-semibold leading-6 text-gray-900">Evaluation</h3>
                        <div class="col-span-6 sm:col-span-2">
                            <dl>
                                <div class="grid grid-cols-2 gap-4 mb-4">
                                    <div class="col-span-2 sm:col-span-1">
                                        <jsp:include page="../partials/input-number-group.jsp">
                                            <jsp:param name="labelText" value="Technical grade"/>
                                            <jsp:param name="formId" value="technicalgrade"/>
                                            <jsp:param name="formName" value="technicalgrade"/>
                                            <jsp:param name="formValue"
                                                       value="${student.evaluationsByIdEvaluations.technicalGrade}"/>
                                            <jsp:param name="formMin" value="0"/>
                                            <jsp:param name="formMax" value="20"/>
                                            <jsp:param name="formRequired" value="true"/>
                                        </jsp:include>
                                    </div>
                                    <div class="col-span-2 sm:col-span-1">
                                        <jsp:include page="../partials/input-number-group.jsp">
                                            <jsp:param name="labelText" value="Communication grade"/>
                                            <jsp:param name="formId" value="communicationgrade"/>
                                            <jsp:param name="formName" value="communicationgrade"/>
                                            <jsp:param name="formValue"
                                                       value="${student.evaluationsByIdEvaluations.communicationGrade}"/>
                                            <jsp:param name="formMin" value="0"/>
                                            <jsp:param name="formMax" value="20"/>
                                            <jsp:param name="formRequired" value="true"/>
                                        </jsp:include>
                                    </div>
                                </div>
                                <l:data-group title="Oral Presentation">
                                    <input type="checkbox" class="accent-indigo-600 rounded-sm" id="oralPresentationDone"
                                           name="oralPresentationDone" ${student.documentsByIdDocuments.visitFormDone ? "checked" : ""}/>
                                    <label for="oralPresentationDone">Done</label>
                                </l:data-group>
                                <div class="mt-[1.1rem]">
                                    <jsp:include page="../partials/textarea-group.jsp">
                                        <jsp:param name="labelText" value="Comments"/>
                                        <jsp:param name="formId" value="comments"/>
                                        <jsp:param name="formName" value="comments"/>
                                        <jsp:param name="formValue" value="${student.comments}"/>
                                        <jsp:param name="formRows" value="5"/>
                                        <jsp:param name="formRequired" value="true"/>
                                    </jsp:include>
                                </div>
                            </dl>
                        </div>
                    </l:card>
                </div>

                <div class="col-span-6 sm:col-span-4">
                    <l:card>
                        <h3 class="pb-2 text-base font-semibold leading-6 text-gray-900">Internship Details</h3>
                        <div class="grid grid-cols-2 gap-4">
                            <div class="col-span-2 sm:col-span-1">
                                <jsp:include page="../partials/input-date-group.jsp">
                                    <jsp:param name="labelText" value="Start Date"/>
                                    <jsp:param name="formId" value="startdate"/>
                                    <jsp:param name="formName" value="startdate"/>
                                    <jsp:param name="formValue" value="${startdate}"/>
                                    <jsp:param name="formRequired" value="true"/>
                                </jsp:include>
                            </div>

                            <div class="col-span-2 sm:col-span-1">
                                <jsp:include page="../partials/input-date-group.jsp">
                                    <jsp:param name="labelText" value="End date"/>
                                    <jsp:param name="formId" value="endate"/>
                                    <jsp:param name="formName" value="enddate"/>
                                    <jsp:param name="formValue" value="${enddate}"/>
                                    <jsp:param name="formRequired" value="true"/>
                                </jsp:include>
                            </div>
                        </div>

                        <jsp:include page="../partials/textarea-group.jsp">
                            <jsp:param name="labelText" value="Mission"/>
                            <jsp:param name="formId" value="mission"/>
                            <jsp:param name="formName" value="mission"/>
                            <jsp:param name="formValue" value="${student.internshipByIdInternship.mission}"/>
                            <jsp:param name="formRequired" value="true"/>
                        </jsp:include>
                    </l:card>
                </div>
            </div>

            <div class="hidden sm:block sm:-mt-8" aria-hidden="true">
                <div class="pb-5">
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
