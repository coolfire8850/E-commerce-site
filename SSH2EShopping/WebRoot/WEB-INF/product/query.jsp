<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
   	<%@ include file="/public/head.jspf" %>
   <style type="text/css">  
        body {  
            margin: 1px;  
        }  
                .searchbox {  
                        margin: -3;  
                }  
    </style>  
   	
   	<script type="text/javascript">
   	
   			$(function(){
   			$("#dg").datagrid({
   				url:'product_queryJoinCategory.action',
   			    loadMsg:'Loading.....',
   			    queryParams:{name:''},  //action后面的参数类型
   			    fitColumns:true, //水平自动展开，设置此属性后，则不会有水平滚动条
   			    striped:true, //显示斑马线
   			    nowrap:true, //当数据多的时候不换行
   			    singleSelect:false, //如果为真， 只允许选择单行
   			    pagination:true, //设置分页
   			    pageSize:10, //设置每页显示的记录数，默认是10 
   			    pageList:[5,10,15,20], //设置可选的每页记录数，供用户选择，默认是10，20，30....
   			    idField:'id',  //指定id为标识字段，在删除，更新的时候有用。同时如果配置此字段，翻页时，换页不会影响选中的项
   			    
   			    /*******************添加菜单条***************************/
   			    
   			   	 toolbar:[{
   			    	iconCls: 'icon-add',
   			    	text:'Add Product',
   			    	handler:function(){
   			    	//因为<div>放在了aindex.jsp中，所以这里创建窗口要先调用parent 
   			    		parent.$("#win").window({
   			    			title:"Add Product",
   			    			width:450,
   			    			height:550,
   			    			content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%">'
   			    		});
   			    	}
   			    
   			    },'-',{
   			    	iconCls: 'icon-edit',
   			    	text:'Edit Product',
   			    	handler:function(){
   			    		var rows = $("#dg").datagrid("getSelections");
   			    		//返回被选中的行，
   			    		if(rows.length == 0 ){
   			    			$.messager.show({
   			    				title:'error information',
   			    				msg:'At least choose one record',
   			    				timeout:2000,
   			    				showType:'slide',
   			    			
   			    			});
   			    		}else if(rows.length != 1){
   			    				$.messager.show({
   			    				title:'error information',
   			    				msg:'At most choose one record to update per time',
   			    				timeout:2000,
   			    				showType:'slide',
   			    			
   			    			});
   			    			
   			    		}else{
   			    			//弹出更新的页面
   			    			parent.$("#win").window({
   			    				title:"Update Product",
   			    				width:450,
   			    				height:550,
   			    				content:'<iframe src="send_product_update.action" framborder="0" width="100%" height="100%">'
   			    			
   			    			});
   			    			
   			    		}
   			    	}
   			    
   			    },'-',{
   			    	iconCls: 'icon-remove',
   			    	text:'Delete Product',
   			    	handler:function(){
   			    		//判断是否有选中记录行，使用getSelections获取选中的所有行
   			    		var rows = $("#dg").datagrid("getSelections");
   			    		//返回被选中的行，
   			    		if(rows.length == 0 ){
   			    			$.messager.show({
   			    				title:'error information',
   			    				msg:'At least choose one record',
   			    				timeout:2000,
   			    				showType:'slide',
   			    			
   			    			});
   			    		}else{
   			    			$.messager.confirm('Delete Confirmation','Do you want to delete this record?',function(r){
   			    				if(r){
   			    					//从选中的记录中获取相应的id值，拼接id值，然后发送后台
   			    					var ids="";
   			    					for(var i = 0; i<rows.length;i++){
   			    						ids += rows[i].id+",";
   			    					}
   			    					ids = ids.substring(0, ids.lastIndexOf(","));
   			    					console.log(ids);
   			    					//发送ajax请求,第三个参数为回调参数
   			    					$.post("product_deleteByIds.action",{ids:ids},function(result){
   			    						//action返回的inputStream如果为true，表示删除成功,result就是ajax回调后的参数
   			    						if(result == "true"){
   			    							//当前页面选项都不选
   			    							$("#dg").datagrid("uncheckAll");
   			    							//刷新当前页面，reload是刷新当前页面
   			    							$("#dg").datagrid("reload");
   			    						}else{
   			    							$.messager.show({
				   			    				title:'error information',
				   			    				msg:'Delete Failure',
				   			    				timeout:2000,
				   			    				showType:'slide',
				   			    			
				   			    			});
   			    						
   			    						}
   			    					
   			    					},"text");
   			    					
   			    				}
   			    			});
   			    		  }
   			    	   }
   			    
   			     },'-',{
   			     	//查询按钮不是LinkButton,它有语法，但是也支持解析html标签
   			     	text:"<input id='ss'/>"
   			     }],
                 
           			    
   	    
   			     /*******************前台显示数据***************************/
   			    
   			        rowStyler: function(index,row){
   			    	//console.info("index"+index+","+row)
   			    	if(index % 2 == 0){
   			    	  	return 'background-color:#fff;';
   			    	}else{
   			    		return 'background-color:#c4e1e1;';
   			    	}
   			    },
   			    //同列属性，但是这些列将会冻结在左侧， 大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
   			    frozenColumns:[[
   			    	{field:'checkbox',checkbox:true},
   			    	{field:'id',title:'Product Id',width:100}
   			    
   			    ]],
   			    //配置datagrid的列字段，field：列字段名称，与json的key捆绑。title:列标题，前段显示用
   			    columns:[[
   			    
   			    	{field:'name',title:'Name',width:100},
   			    	{field:'price',title:'Price',width:70},
   			    	{field:'remark',title:'Brief',width:70},
   			    	{field:'details',title:'Details',width:100},
   			    	{field:'date',title:'Date',width:100},
   			    	{field:'commend',title:'Recommended products',width:100,
   			    		formatter:function(value,row,index){
   			    			//设置当前单元格的样式，返回的字符串直接交给style属性
   			    			if(value){
   			    				return "<input type='checkbox' checked='checked' disabled='true'";
   			    			}else{
   			    				return "<input type='checkbox' disabled='true'";
   			    			}
   			    		} 	
   			    	
   			    	},
   			    	
   			    	   			
   			    	{field:'open',title:'Valid product',width:100,
   			    		formatter:function(value,row,index){
   			    			//设置当前单元格的样式，返回的字符串直接交给style属性
   			    			if(value){
   			    				return "<input type='checkbox' checked='checked' disabled='true'";
   			    			}else{
   			    				return "<input type='checkbox' disabled='true'";
   			    			}
   			    		} 	
   			    	},
   			    	{field:'category.type',title:'Category Type',width:100,
   			    		formatter:function(value,row,index){
   			    			if(row.category != null && row.category.type != null){
   			    				return row.category.type;
   			    			}else{
   			    				return "No Category type";
   			    			}
   			    		}
   			    	
   			    	
   			    	},
   			    	{field:'category.account.login',title:'Admin',width:100,
   			    		formatter:function(value,row,index){
   			    			if(row.category.account != null && row.category.account.login != null){
   			    				return row.category.account.login;
   			    			}else{
   			    				return "No admin";
   			    			}
   			    		}
   			    	}	    	
   			    ]]
   			       			        
   			});
   			
   			$('#ss').searchbox({ 
				//触发查询事件
				searcher:function(value,name){ //value表示输入的值
					//alert(value + "," + name)
					//获取当前查询的关键字，通过DataGrid加载相应的信息，使用load加载和显示第一页的所有行。
					//如果指定了参数，它将取代'queryParams'属性。通常可以通过传递一些参数执行一次查询，通过调用这个方法会向上面url指定的action去发送请求，从服务器加载新数据。
					$('#dg').datagrid('load',{
						name: value
					});

				}, 
				prompt:'Please Input Value' 
			}); 
   			
   			
   		 			
   		});
   		
   		
    
   	
   	</script>
</script>
   	
        
  </head>
  
  <body>
    <table id="dg"></table>
  	
	
  </body>
</html>
