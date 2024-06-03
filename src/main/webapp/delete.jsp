<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Image</title>
</head>
<body>
<h1>Delete Medical Image</h1>
<p>Are you sure you want to delete the image?</p>
<form action="deleteImage" method="post">
    ID: <input type="text" name="image.id" value="${image.id}" readonly/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
