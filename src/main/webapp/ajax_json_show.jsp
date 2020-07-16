<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/13
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            show();
        })
        function show() {
            $.post("<%=request.getContextPath()%>/user/urlShow",
                {"url":"http://localhost:8081/users/1"},
                function(data){
                alert(data.data.code)
                    var html = "";
                    var pageHtml = "";
                    for (var i=0;i<data.data.length;i++) {
                        var u = data.data[i];
                        html +="<tr>"
                        html +="<td>"+u.id+"</td>"
                        html +="<td>"+u.userName+"</td>"
                        html +="<td>"+u.userPwd+"</td>"
                        html +="<td>"+u.userAge+"</td>"
                        if( u.userSex == 1){
                            html += "<td>男</td>";
                        } else {
                            html += "<td>女</td>";
                        }
                        html +="<td>"+u.userPho+"</td>"
                        html +="<td>"+u.userEmail+"</td>"
                        if (u.userHobby == 1) {
                            html +="<td>足球</td>"
                        } else if (u.userHobby ==2) {
                            html +="<td>篮球</td>"
                        } else {
                            html +="<td>棒球</td>"
                        }
                        html +="</tr>"
                    }
                    $("#tbd").html(html);
                });
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>性别</th>
        <th>手机号</th>
        <th>邮箱</th>
        <th>爱好</th>
        <th>操作</th>
    </tr>
    <tbody id = "tbd">

    </tbody>
</table>
</body>
</html>
