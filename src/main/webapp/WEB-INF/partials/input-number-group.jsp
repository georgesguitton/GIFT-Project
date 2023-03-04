<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <label for="${param.formId}" class="block text-sm font-medium text-gray-700">${param.labelText}</label>
    <div class="relative mt-1 rounded-md shadow-sm">
        <input type="number"
               name="${param.formName}"
               id="${param.formId}"
               class="block w-full rounded-md border border-gray-300 px-3 py-2 focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
               required="${param.formRequired}"
               min="${param.formMin}"
               max="${param.formMax}"
               value="<c:out value="${param.formValue}"/>"
        >
    </div>
</div>
