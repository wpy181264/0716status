<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/11
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#upload").click(function () {
                var formData = new FormData($('#uploadForm')[0]);
                $.ajax({
                    type: 'post',
                    url: "<%=request.getContextPath()%>/users/upload",
                    data: formData,
                    cache: false,
                    processData: false,
                    contentType: false,
                }).success(function (data) {
                    alert(data);
                }).error(function () {
                    alert("上传失败");
                });
            });
        });
    </script>


</head>
<body>
<form id="uploadForm" enctype="multipart/form-data">
    文件:<input id="file" type="file" name="file"/>
</form>
<button id="upload">上传文件</button>
</body>
</html>
