<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/11
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        function test() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users/",
                dataType:"json",
                type:"post",
                data: {
                    "_method": "PUT", "id": 2,"userName":"kkkk",
                },
                success: function (data) {
                    alert(data);
                }

            });
        }

        function testadd() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users/",
                dataType:"json",
                type:"post",
                data: {
                    "_method": "POST", "id": 2,"userName":"kkkk",
                },
                success: function (data) {
                    alert(data);
                }

            });
        }

        function test1(){

                    location.href="<%=request.getContextPath()%>/ajax_json_show.jsp";

        }


    </script>
</head>
<body>
    <button type="button" onclick="test()">修改</button>
    <button type="button" onclick="testadd()">增加</button><br/><br/><br/><br/><br/><br/>

    <button type="button" onclick="test1()">正向代理</button>


</body>
</html>
