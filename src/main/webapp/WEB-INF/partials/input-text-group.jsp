<div>
    <label for="${param.formId}" class="block text-sm font-medium text-gray-700">${param.labelText}</label>
    <div class="relative mt-1 rounded-md shadow-sm">
        <input type="text" name="${param.formName}" id="${param.formId}" class="block w-full rounded-md border border-gray-300 px-3 py-2 focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm" value="${param.formValue}" placeholder="${param.formPlaceholder}" required="${param.formRequired}">
    </div>
</div>
