<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Image</title>
</head>
<body>
<h1>Update Medical Image</h1>
<form action="updateImage" method="post">
    ID: <input type="text" name="image.id" value="${image.id}" readonly/><br/>
    Name: <input type="text" name="image.name" value="${image.name}"/><br/>
    Type: <input type="text" name="image.type" value="${image.type}"/><br/>
    URL: <input type="text" name="image.url" value="${image.url}"/><br/>
    Description: <textarea name="image.description">${image.description}</textarea><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>

