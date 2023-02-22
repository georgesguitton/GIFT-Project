<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body class="flex min-h-full items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
<main class="w-full max-w-md space-y-8">
  <div>
    <h2 class="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900">Sign in to your GIFT account</h2>
    <p class="mt-2 text-center text-sm text-gray-600">ERROR: Username or password incorrect</p>
  </div>
  <form class="mt-8 space-y-6" method="POST" action="j_security_check" accept-charset="latin-1">
    <div class="-space-y-px rounded-md shadow-sm">
      <div>
        <label for="username" class="sr-only">Username</label>
        <input id="username" type="text" name="j_username" placeholder="Username" required
               class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm">
      </div>
      <div>
        <label for="password" class="sr-only">Password</label>
        <input id="password" type="password" name="j_password" placeholder="Password" required
               class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm">
      </div>
    </div>
    <div class="relative flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
      <button type="submit">Login</button>
    </div>
  </form>
</main>
</body>
</html>