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
<script type="text/javascript">
	$(function(){
		//拿到带title属性的a标签
		$("a[title]").click(function(){
			//获取当前连接的名字
			var text = $(this).text();
			console.log(text);
			var href = $(this).attr("title");
			console.log(href);
			//判断当前右边是否已有相应的tab,tabs()里第一个参数是方法名，第二个是相对应的参数
			if($("#tt").tabs("exists",text)){
				$("#tt").tabs("select",text); //如果存在，就显示
			}else{
			
				
					//如果没有则创建一个新的tab，否则切换到当前tab
					$("#tt").tabs("add",{
					title:text,
					closable:true,  //增加关闭按钮
					//后面的update和save等方法都需要回来找这个iframe,必须加上title，否则后面刷新不了页面
					
					 content:'<iframe title= ' + text + ' src='+href+ ' frameborder="0" width="100%" height="100%"/>'
				    });
				
				
			}
			
		});
	
	});

</script>

</head>
<body class="easyui-layout">
	<div
		data-options="region:'north',title:'Welcome to the back-end manage plateform',split:true"
		style="height:100px;">ddsadsadasda</div>
	<div data-options="region:'west',title:'System Opertation',split:true"
		style="width:200px;">
		<!-- 此处显示的是系统菜单 -->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="Basic Operation" data-options="iconCls:'icon-save'">
				<ul>
					<li><a href="#" title="send_category_query.action">Category</a>
				    <li><a href="#" title="send_product_query.action">Product</a>
				</ul>
				
			</div>
			<div title="Divertissements" data-options="iconCls:'icon-reload'">
				<ul>
					<li><a href="#" title="send_sale_sale.action">SalesManagement</a>
					<li><a href="#">GoodsManagement</a>
				
				</ul>
			
				
			</div>
			<div title="Title3">content3</div>
		</div>
	</div>
	<div data-options="region:'center',title:'Back-end Operation Pages'" style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="System default page" style="padding:10px;">
				lalalala
			</div>
		
		</div>
		
	</div>
	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true" />
</body>





</html>
