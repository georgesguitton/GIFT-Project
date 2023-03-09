<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- source: https://tailwindui.com/components/application-ui/navigation/navbars -->

<nav class="bg-gray-800">
    <div class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
        <div class="relative flex h-16 items-center justify-between">
            <div class="flex flex-1 items-stretch justify-start">
                <div class="flex flex-shrink-0 items-center">
                    <h2 class="text-white text-center text-3xl font-bold tracking-tight">
                        <a href="my-dashboard">GIFT</a>
                    </h2>
                </div>
            </div>
            <div class="right-0 flex items-center static inset-auto ml-6 pr-0">
                <p class="text-gray-300 rounded-md py-2.5 px-4 text-sm font-medium">
                    <c:out value="${param.username}"/>
                </p>

                <a href="logout"
                   class="inline-flex justify-center rounded-lg text-sm font-semibold py-2.5 px-4 bg-slate-900 text-white hover:bg-slate-700 -my-2.5">
                    <span>Log Out <span aria-hidden="true">&#8594;</span></span>
                </a>
            </div>
        </div>
    </div>
</nav>
