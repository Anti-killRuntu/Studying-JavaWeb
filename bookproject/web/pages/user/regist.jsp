<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--   静态包含base标签，css样式，jQuery文件  --%>
    <%@ include file="/pages/common/head.jsp"%>
    <script>
        $(function () {
            //给验证码绑定单击事件
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });
            //注册的单击事件
            $("#sub_btn").click(function () {
                //验证用户名是否合法
                let usernametext = $("#username").val();
                let usernamepatt = /^\w{5,12}$/;
                if (!usernamepatt.test(usernametext)) {
                    $("span.errorMsg").text("用户名不合法");
                    return false;
                }
                ;
                //验证密码是否合法
                let passswordtext = $("#password").val();
                let passswordpatt = /^\w{5,12}$/;
                if (!passswordpatt.test(passswordtext)) {
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }
                ;
                let repwdtext = $("#repwd").val();
                let repwdpatt = /^\w{5,12}$/;
                if (!repwdpatt.test(repwdtext)) {
                    $("span.errorMsg").text("确认密码不一致！");
                    return false;
                }
                ;
                let emailtext = $("#email").val();
                let emailpatt = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                if (!emailpatt.test(emailtext)) {
                    $("span.errorMsg").text("邮箱不合法！");
                    return false;
                }
                ;
                let codetext = $("#code").val().trim();

                if (codetext == null || codetext == "") {
                    $("span.errorMsg").text("验证码不合法！");
                    return false;
                }
                ;
                $("span.errorMsg").text("");


            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        ${ requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
							   value="wzg168"
                               autocomplete="off" tabindex="1" name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
							   value="123456"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
							   value="123456"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
							   value="wzg168@qq.com"
                               autocomplete="off" tabindex="1" name="email" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 128px;" id="code" value="asd"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right;margin-right: 40px;width: 88px;height: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--	静态包含页脚--%>
<%@include file="/pages/common/footer.jsp"%>
</div>
</body>
</html>