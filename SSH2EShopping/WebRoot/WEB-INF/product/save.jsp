<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    
  	 <style type="text/css">  
        form div {  
            margin:5px;  
        }  
    </style>
	
	<script type="text/javascript">
		$(function(){
			//自定义验证方法向validatebox.defaults.rules中注册新函数,对上传图片的后缀名进行判断
			$.extend($.fn.validatebox.defaults.rules,{
				//format为自定义的函数名称
				format:{
					//函数的实现
					validator:function(value,param){
						//获取当前文件的后缀名
						var ext = value.substring(value.lastIndexOf('.')+1);
						//获取支持的文件后缀名，然后进行比较
						var arr = param[0].split(",");
						for(var i = 0 ;i<arr.length; i++){
							if(ext == arr[i])
								return true;
						}
						return false;
					},
					//错误消息
					message : '文件名后缀必须为:{0}'
				
				}
				
			});
			
		
			
			//对商品类别下拉列表进行远程加载
			$("#cc").combobox({
			//将请求发送给categoryAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来  
				url:'category_query.action',
				valueField:'id',
				textField:'type', //下来列表中显示管理员的登录名
				panelHeight:'auto', //自适应高度
				panelWidth:120,
				width:120, //下拉列表是两个组件组成的，所有需要同时设置两个宽度
				editable:false, //下拉框不允许编辑 
				//combobox继承combo继承validabox，所以可以直接在这里设置验证
				required:true,
				missingMessage:'Please choose one category' 
			});
			
			//对商品名称的验证功能，必须输入
			$("input[name=name]").validatebox({ //name应对前台页面相应的name
				required: true,
				missingMessage:'Champ required'
			});
			
			
			$("input[name=price]").numberbox({ //name应对前台页面相应的name
				required: true,
				missingMessage:'Please input price',
				min:0,
				precision:2,
				prefix:'$'
			});
			
			$("input[name='fileImage.upload']").validatebox({ //name应对前台页面相应的name
				required: true,
				missingMessage:'Please upload one photo',
				//调用自定义方法
				validType:"format['gif,jpg,jpeg,png']"
			});
			
			$("textarea[name=remark]").validatebox({
				required: true,
				missingMessage:'Please input the brief introduction'
			
			});
			
			$("textarea[name=details]").validatebox({
				required: true,
				missingMessage:'Please input the details'
			
			});
			
			
			//窗体弹出默认是禁用验证，因为刚弹出的窗口，用户还没填就显示的话，太丑
			$("#ff").form("disableValidation");
			//注册button的事件。即当用户点击“添加”的时候做的事  
			$("#submit").click(function(){
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")){
					$("#ff").form('submit',{
						url:'product_save.action',  //将请求提交给productAction中的save方法处理  
						success:function(){
							//如果成功，关闭当前窗口
							parent.$("#win").window("close");
							//刷新页面，刚刚添加的就显示出来了。  获取aindex-->iframe-->datagrid
							parent.$("iframe[title='Product']").get(0).contentWindow.$("#dg").datagrid("reload"); 
						}
					
					});
				}
			
			});
			
			$("#reset").click(function(){
				$("#ff").form("disableValidation");//重置不需要表单验证
				//重置当前表单数据
				$("#ff").form("reset");
			});
			
		});
		
	</script>
  </head>
  
  <body>
    <form id="ff" method="post" enctype="multipart/form-data">
    	<div>
    		<label >Name:</label> <input type="text" name="name">
    	</div>
    	<div>
    		<label >Price:</label> <input type="text" name="price">
    	</div>
    	<div>
    		<label >Upload Img:</label> <input type="file" name="fileImage.upload">
    	</div>
    	
    	<div>
    		<label>Category:</label><input id="cc" name="category.id">
    	</div>
    	<div>
    		<label>Recommendation:</label>
    		Yes<input type="radio" name="commend" checked="checked" value="true">
    		No<input type="radio" name="commend" value="false">
    	</div>
    	<div>
    		<label>Valid:</label>
    		Yes<input type="radio" name="open" checked="checked" value="true">
    		No<input type="radio" name="open" value="false">
    	</div>
    	
    	<div>
    		<label>Brief:</label>
    		<textarea rows="4" cols="40" name="remark"></textarea>
    	</div>
    	
    	<div>
    		<label>Details:</label>
    		<textarea rows="8" cols="40" name="details"></textarea>
    	</div>
    	
    	<div>
    		<a id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add</a>
    		<a id="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">Reset</a>
    	
    	</div>
    	
    
    </form>
  </body>
</html>
