<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image List</title>
</head>
<body>
<h1>List of Medical Images</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>URL</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="image" items="${images}">
        <tr>
            <td>${image.id}</td>
            <td>${image.name}</td>
            <td>${image.type}</td>
            <td>${image.url}</td>
            <td>${image.description}</td>
            <td>
                <a href="updateImage?id=${image.id}">Edit</a> |
                <a href="deleteImage?id=${image.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
