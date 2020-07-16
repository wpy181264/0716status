<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/7
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        function upd(){
            $.post("<%=request.getContextPath()%>/user/update",
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
</head>
<body>
<form id = "fm">
    <input type="hidden" name="id" value="${user.id}"/>
    性别<br/>
    男<input type="radio" name = "userSex" <c:if test="${user.userSex==1 }">checked="checked"</c:if> value ="1"/>
    女<input type="radio" name = "userSex" <c:if test="${user.userSex==2 }">checked="checked"</c:if> value ="2"/><br/>
    名字<input type="text" name="userName" value="${user.userName}"/><br/>
    密码<input type="text" name="userPwd" value="${user.userPwd}"/><br/>
    年龄<input type="text" name="userAge" value="${user.userAge}"/><br/>
    邮箱<input type="text" name="userEmail" value="${user.userEmail}"/><br/>
    手机<input type="text" name="userHobby" value="${user.userHobby}"/><br/>
    爱好<br/>
    足球<input type="radio" name="userHobby" <c:if test="${user.userHobby==1 }">checked="checked"</c:if> value="1">
    篮球<input type="radio" name="userHobby" <c:if test="${user.userHobby==2 }">checked="checked"</c:if> value="2">
    棒球<input type="radio" name="userHobby" <c:if test="${user.userHobby==3 }">checked="checked"</c:if> value="3">
    <input type="button" value="修改" onclick="upd()"/>
</form>
</body>
</html>
