<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Image</title>
</head>
<body>
<h1>Add a New Medical Image</h1>
<form action="addImage" method="post">
    Name: <input type="text" name="name"/><br/>
    Type: <input type="text" name="type"/><br/>
    URL: <input type="text" name="url"/><br/>
    Description: <textarea name="description"></textarea><br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
