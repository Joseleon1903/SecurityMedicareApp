<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" integrity="sha384-Uu6IeWbM+gzNVXJcM9XV3SohHtmWE+3VGi496jvgX1jyvDTXfdK+rfZc8C1Aehk5" crossorigin="anonymous">
    <link th:href="@{/css/styles.css}" rel="stylesheet">
    <link th:href="@{/css/styles_A.css}" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>

<title>JSP Page</title>
</head>
<body>
<%
out.println("<h1>welcome to app unipago</h1>");
%>

   <div class="container bg-container">

        <div class="container-fluid content">
            <div class="hero-container fluid-container">
                    <div class="hero-header-text">
                        <h1 class="hero-header-title">Welcome to Thymeleaf Spring Application</h1>
                    </div>
                    <div class="hero-header-image">
                        <img src="https://www.thymeleaf.org/images/thymeleaf.png" alt="Thymeleaf logo" style="height: 100%; width:20%;">
                    </div>
                    <h1>Go to Account page <a href="@{/accounts}" > Account Page</a></h1>

                    <h1>Go to Entidad page <a href="@{/entidad}" > Entidad Page</a></h1>
            </div>
        </div>
    </div>

</body>
</html>