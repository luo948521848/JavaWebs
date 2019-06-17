<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="com.easybuy.entity.EasybuyUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    if(request.getSession().getAttribute("loginUser")!=null){
        response.sendRedirect(request.getContextPath()+"/Home?action=index");
    }
%>
<head>
    <meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/common/pre/header.jsp" %>
    <script type="text/javascript" src="${ctx}/statics/js/login/login.js"></script>
    <title>易买网</title>

    <script type="text/javascript">
        function sendtoLogin() {
            var Userid=<%=session.getAttribute("Userid")%>
            if(Userid==null)
            {
                var Userid=0;
            }
            var login = $("input[name='loginName']").val();
            var xmlhttp = new XMLHttpRequest();
            var url = "http://192.168.137.100/log.gif?UserId="+Userid+"&action=toLogin&remark="+"UserLoginName:"+login;
            xmlhttp.open("GET", url, true); //第三个参数是同步异步,主线程只能异步
            xmlhttp.send();
        }
    </script>


</head>
<body>  
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${ctx}/Home?action=index"><img src="${ctx}/statics/images/logo.png" /></a></div>
    </div>
	<div class="login">
    	<div class="log_img"><img src="${ctx}/statics/images/l_img.png" width="611" height="425" /></div>
		<div class="log_c">
        	<form>
            <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="55">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">登录</span>
                    <span class="fr">还没有商城账号，<a href="${ctx}/Register?action=toRegister" style="color:#ff4e00;">立即注册</a></span>
                </td>
              </tr>
              <tr height="70">
                <td>用户名</td>
                <td><input type="text" name="loginName" id="loginName" value="" class="l_user" /></td>
              </tr>
              <tr height="70">
                <td>密&nbsp; &nbsp; 码</td>
                <td><input type="password" name="password" id="password" value="" class="l_pwd" /></td>
              </tr>


                <tr height="70">
                    <td>验证码</td>
                    <td>
                    <input id="captcha" class="easyui-textbox" name="captcha" class="l_user" />
                    <img id="img" src="generateCaptcha" title="点击刷新" width="60px" height="50px" style="vertical-align:middle;cursor:pointer;" onclick="refreshCode()"/>
                        <span id="errorMsg" style="color:red;margin-left:10px;"></span>
                    </td>
                </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="button" value="登录" class="log_btn" onclick="login(),sendtoLogin();" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${ctx}/statics/images/b_1.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_2.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_3.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_4.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_5.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_6.gif" width="98" height="33" />
    </div>    	
</div>
<!--End Footer End -->
</body>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
