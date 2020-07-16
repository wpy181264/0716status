<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/7
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        function add(){
            $.post("<%=request.getContextPath()%>/user/insert",
                $("#fm").serialize(),
                function(data){

                    if(data.code != "200"){
                        return;
                    }
                   location.href = "<%=request.getContextPath()%>/show.jsp";
                })
        }
    </script>
</head>
<body>
<form id = "fm">
    性别<br/>
    男<input type="radio" name = "userSex" value ="1"/>
    女<input type="radio" name = "userSex" value ="2"/><br/>
    名字<input type="text" name="userName"/><br/>
    密码<input type="text" name="userPwd"/><br/>
    性别<input type="text" name="userAge"/><br/>
    邮箱<input type="text" name="userEmail"/><br/>
    手机<input type="text" name="userHobby"/><br/>
    爱好<br/>
    足球<input type="radio" name="userHobby" value="1">
    篮球<input type="radio" name="userHobby" value="2">
    棒球<input type="radio" name="userHobby" value="3">
    <input type="button" value="增加" onclick="add()"/>
</form>
</body>
</html>
