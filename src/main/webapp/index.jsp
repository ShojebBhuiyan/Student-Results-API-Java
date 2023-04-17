<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h3>Add Students</h3>
    <form method="get" action="http://localhost:8080/WebArchAsssignment4-1.0-SNAPSHOT/api/student/add-student">
        <label for="id">ID: </label>
        <input type="text" value="" name="id" id="id">
        <label for="name">Name: </label>
        <input type="text" value="" name="name" id="name">
        <label for="semester">Semester: </label>
        <input type="text" value="" name="semester" id="semester">
        <label for="cgpa">CGPA: </label>
        <input type="number" value="" name="cgpa" id="cgpa">
        <input type="submit" value="Submit" name="Submit-Add">
    </form>

    <h3>Get Name</h3>
    <form method="get" action="/name">
        <label for="id-name">ID: </label>
        <input type="text" value="" name="id" id="id-name">
        <input type="submit" value="Submit" name="Submit-Get-Name">
    </form>

    <h3>Get Higher CGPA Student Info</h3>
    <form method="get" action="/compare">
        <label for="id1">ID1: </label>
        <input type="text" value="" name="id" id="id1">
        <label for="id2">ID2: </label>
        <input type="text" value="" name="id" id="id2">
        <input type="submit" value="Submit" name="Submit-Compare">
    </form>

    <h3>Update Name</h3>
    <form method="get" action="http://localhost:8080/WebArchAsssignment4-1.0-SNAPSHOT/api/student/update-name">
        <label for="id-update">ID: </label>
        <input type="text" value="" name="id" id="id-update">
        <label for="name-update">New Name: </label>
        <input type="text" value="" name="name" id="name-update">
        <input type="submit" value="Submit" name="Submit-Update-Name">
    </form>

    <h3>Show All Student Info</h3>
    <form method="get" action="/student-list">
        <input type="submit" value="Show">
    </form>

    <h3>Show Highest CGPA Student Info</h3>
    <form method="get" action="/highest-cgpa">
        <input type="submit" value="Show">
    </form>
</body>
</html>