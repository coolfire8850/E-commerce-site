<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
	<style type="text/css">
		form div{
			margin: 5px;
		}
		
	</style>
	
	<script type="text/javascript">
		$(function(){
			//iframe中的datagrid对象,parent指aindex.jsp
			var dg = parent.$("iframe[src='send_category_query.action']").get(0).contentWindow.$("#dg");
			         
			
			//对管理员下拉表进行远程加载
			$("#cc").combobox({
				//将请求发送给accountAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来  
				url:'account_query.action',
				valueField:'id',
				textField:'login', //下来列表中显示管理员的登录名
				panelHeight:'auto', //自适应高度
				panelWidth:120,
				width:120, //下拉列表是两个组件组成的，所有需要同时设置两个宽度
				editable:false //下拉框不允许编辑  
			
			});
			
			//完成数据的回显，更新时，首先拿到用户选择的那一行
			var rows = dg.datagrid("getSelections");
			//将拿到的那一行对应的数据字段加载到表单里，实现数据回显
			$("#ff").form('load',{
				id:rows[0].id,  //对应前台表单中相应name字段
				type:rows[0].type,
				hot:rows[0].hot,
				'account.id':rows[0].account.id //easyUI 不支持account.id这种点操作，所有要加引号
			
			});
			
			//回显完了数据后，设置验证功能
			$("input[name=type]").validatebox({ //name应对前台页面相应的name
				required: true,
				missingMessage:'Champ required'
			});
			//窗体弹出默认是禁用验证
			$("#ff").form("disableValidation");
			//注册button的事件。即当用户点击“添加”的时候做的事  
			$("#btn").click(function(){
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")){
					$("#ff").form('submit',{
						url:'category_update.action',  //将请求提交给categoryAction中的update方法处理  
						success:function(){
							//如果成功，关闭当前窗口
							parent.$("#win").window("close");
							//刷新页面，刚刚添加的就显示出来了。  获取aindex-->iframe-->datagrid
							dg.datagrid("reload"); 
						}
					
					});
				}
			
			});
		
		});
	
	</script>
  </head>
  
  <body>
     <form id="ff" method="post">
     	<div>
     		<label for="id">Id:</label><input type="text" name="id" readonly="readonly" width="1px" />
     	</div>
    	<div>
    		<label for="name">Product name:</label> <input type="text" name="type">
    	</div>
    	<div>
    		<label for="cc">Administator:</label><input id="cc" name="account.id">
    	</div>
    	<div>
    		<label for="hot">Hot:</label>
    		Yes<input type="radio" name="hot" value="true">
    		No<input type="radio" name="hot" value="false">
    	</div>
    	<div>
    		<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">Update</a>
    		
    	</div>
    	
    
    </form>
  </body>
</html>
