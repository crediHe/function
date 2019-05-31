<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <button type="submit"> 提交</button>
    </form>
</body>
</html>
