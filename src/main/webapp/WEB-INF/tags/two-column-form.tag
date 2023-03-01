<%@tag description="Two-column cards form layout" pageEncoding="UTF-8" %>
<!-- source: https://tailwindui.com/components/application-ui/forms/form-layouts -->
<%@attribute name="formTitle" fragment="true" %>

<div>
    <div class="md:grid md:grid-cols-3 md:gap-6">
        <div class="md:col-span-1">
            <div class="px-4 sm:px-0">
                <jsp:invoke fragment="formTitle"/>
            </div>
        </div>
        <div class="mt-5 md:col-span-2 md:mt-0">
            <jsp:doBody/>
        </div>
    </div>
</div>
