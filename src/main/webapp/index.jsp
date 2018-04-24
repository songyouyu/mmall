<%@page language="java" contentType="text/html; UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>

springmvc上传文件
<form name="form1" action="/product/manage/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc上传文件">
</form>

富文本图片上传
<form name="form2" action="/product/manage/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="富文本上传文件">
</form>

</body>
</html>
