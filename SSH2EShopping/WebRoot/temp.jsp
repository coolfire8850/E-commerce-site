<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
   <%@ include file="/public/head.jspf"%>
   <style type="text/css">
   	#menu {
   		width: 200px;
   	}
   	#menu ul {
   		list-style: none;
   		padding: 0px;
   		margin: 0px;
   	}
    #menu ul li {
    	border-bottom: 1px solid #fff;
    }
    #menu ul li a {
    	/*先将a标签转换为块级元素，才能设置宽和内间距*/
    	display: block;
    	background-color: #00a6ac;
    	color: #fff;
    	padding: 5px;
    	text-decoration: none;
    }
    #menu ul li a:hover {
    
    	background-color: #008792;
    }
   
   
   </style>

  </head>
  
  <body>
     <div id="menu">
     	<ul>
     		<li><a href="#">Category Management</a>
     		<li><a href="#">Goods Management</a>
     	</ul>
     	
     </div>
  </body>
</html>
