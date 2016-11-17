<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
<body>
	<div class="wrapper">
		<s:include value="head.jsp"></s:include>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		 <div class="navigation_container">
        <!---->
         <div class="nav">
            <ul class="primary_nav">
                <li class="active highlight"><a href="#"><s:text name="women"/></a></li>
                <li><a href="#"><s:text name="man"/></a></li>
                <li><a href="#"><s:text name="children"/></a></li>
                <li><a href="#"><s:text name="fashion"/></a></li>
                <li><a href="#"><s:text name="deco"/> </a></li>
            </ul>
        </div>
        </div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="dd" class="action_buttonbar" style="text-align:center;">
				<form method="post" action="${shop}/user_login.action">
					<div>
						<label for="login"><s:text name="account"/>:&nbsp;</label> 
						<input type="text" name="login" />
					</div>
					<div>
						<label for="pass"><s:text name="password"/>:&nbsp;</label> 
						<input type="text" name="pass" />
					</div>
					<div>
						${sessionScope.error}  
					</div>
					<div>
						<input type="submit" value="<s:text name="login"/>" style="width:60px;height:30px" />
						<input type="button" value="<s:text name="register"/>" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" />
					</div>
			   </form>
			   <div style="clear:both"></div>
			</div>
		</div>
			<!-- 导航栏结束 -->
			<s:include value="foot.jsp"></s:include>
		</div>
</body>
</html>
