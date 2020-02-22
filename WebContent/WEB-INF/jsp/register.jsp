<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>	
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="${pageContext.request.contextPath}/css/style.css"
	   type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath}/css/boot-crm.css"
	   type=text/css rel=stylesheet>
<script src=
       "${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
</script>

  </head>
  
 <body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
	background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
	<tr>
		<td height="93"></td>
		<td></td>
	</tr>
	<tr>
   <td background="${pageContext.request.contextPath}/images/rights3.jpg"
		width="420" height="330">
   </td>
   <td class="login_msg" width="400" align="center">
	 <!-- margin:0px auto; 控制当前标签居中 -->
	 <fieldset style="width: auto; margin: 0px auto;">
		  <legend>
		     <font style="font-size:25px" face="宋体" color="white">
		          注册
		     </font>
		  </legend> 
		<font color="red">
			 <%-- 提示信息--%>
			 <span id="message">${msg}</span>
		</font>
		<%-- 提交后的位置：/WEB-INF/jsp/customer.jsp--%>
		<form  name="form"  method="post" action="${pageContext.request.contextPath}/register"> 
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />
          <font color="white" size="4">账&nbsp;号：</font><input id="usercode" type="text" name="usercode" placeholder="账号"/>
          <br><br>
          <font color="white" size="4">密&nbsp;码：</font><input id="password" type="password" name="password" placeholder="密码"/>
          <br><br>
          <font color="white" size="4">名&nbsp;字：</font><input id="username" type="text" name="username" placeholder="名字"/>
          <br><br>
          <input  type="hidden" name="userstate" value="1">                  
          <div>          
          <center><button type="submit" id="submit" >注册</button>
          <button type="reset" id="reset" >重置</button>
          </center>   
          </div>       
		 </form>
	 </fieldset>
	</td>
	</tr>
</table>
</div>
</body>
</html>
