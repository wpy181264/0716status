<%--
  Created by IntelliJ IDEA.
  User: 文沛阳
  Date: 2020/7/8
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>\res\js\jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        function add(){
            $.post("<%=request.getContextPath()%>/user/inserts",
                $("#fm").serialize(),
                function(data){

                    if(data.code != "200"){
                        return;
                    }
                    location.href = "<%=request.getContextPath()%>/show.jsp";
                })
        }

        var i = 0;
        function adds(){
            i++;
            var html = "<div><hr /><input type='button' value='-' onclick='del(this)'/>";
            html += "性别<br/>";
            html += "男<input type='radio' name='list["+i+"].userSex' value='1'/>";
            html += "女<input type='radio' name='list["+i+"].userSex' value='2'/><br/>";
            html += "名字<input type='text' name='list["+i+"].userName'/><br />";
            html += "密码<input type='text' name='list["+i+"].userPwd'/><br />";
            html += "年龄<input type='text' name='list["+i+"].userAge'/><br />";
            html += "邮箱<input type='text' name='list["+i+"].userEmail'/><br />";
            html += "手机<input type='text' name='list["+i+"].userHobby'/><br />";
            html += "爱好<br/>";
            html += "足球<input type='radio' name='list["+i+"].userHobby' value='1'/>";
            html += "篮球<input type='radio' name='list["+i+"].userHobby' value='2'/>";
            html += "棒球<input type='radio' name='list["+i+"].userHobby' value='3'/>";
            html += "<br /></div></div>";
            $("#appendDiv").append(html);
        }
        function del(obj){
            $(obj).parent().remove();
        }
    </script>
</head>
<body>
    <input type="button" value="+" onclick="adds()"/>
    <form id = "fm">
        性别<br/>
        男<input type="radio" name = "list[0].userSex" value ="1"/>
        女<input type="radio" name = "list[0].userSex" value ="2"/><br/>
        名字<input type="text" name="list[0].userName"/><br/>
        密码<input type="text" name="list[0].userPwd"/><br/>
        年龄<input type="text" name="list[0].userAge"/><br/>
        邮箱<input type="text" name="list[0].userEmail"/><br/>
        手机<input type="text" name="list[0].userHobby"/><br/>
        爱好<br/>
        足球<input type="radio" name="list[0].userHobby" value="1">
        篮球<input type="radio" name="list[0].userHobby" value="2">
        棒球<input type="radio" name="list[0].userHobby" value="3">
        <div id="appendDiv"></div>
        <input type="button" value="增加" onclick="add()"/>
    </form>
</body>
</html>
