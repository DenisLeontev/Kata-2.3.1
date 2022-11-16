<html>
<body>
<h2>Hello World!</h2>
<div th:each="person : ${user}">
    <a th:href="@{/user/{id}(id=${user.getId()})}" th:text="${person.getName()}">user</a>
</div>
</body>
</html>
