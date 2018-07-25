<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link type="text/css" rel="stylesheet" href="js/jquery.jqGrid-4.4.3/css/ui.jqgrid.css">
<link type="text/css" rel="stylesheet" href="js/jquery.jqGrid-4.4.3/plugins/ui.multiselect.css"> -->
<link type="text/css" rel="stylesheet" href="css/ui.jqgrid.css">
<link type="text/css" rel="stylesheet" href="css/jquery-ui.min.css">
<!-- <link type="text/css" rel="stylesheet" href="css/jquery-ui.structure.min.css">
<link type="text/css" rel="stylesheet" href="css/jquery-ui-1.8.16.custom.css">
<link type="text/css" rel="stylesheet" href="css/jquery-ui.theme.min.css"> -->
<style> 
*{margin:0; padding:0;}

</style>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script> 
<script src="js/jquery-ui.min.js" type="text/javascript"></script>
<script src="js/grid.locale-cn.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="js/json2.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery.jgrid.useJSON = true;
    $(function(){ pageInit(); }); 
    
    var packageAjax={
    		ajax : function (param){
    			$.ajax({
    				url:param.url,
    				type:param.type,
    				timeout:param.timeout,
    				async:param.async,
    				cache:param.cache,
    				data:param.data,
    				dataType:param.dataType,
    				beforeSend:function(){
    					if(param.beforeSend){
    						alert("进入packageAjax 的 beforeSend");
    						param.beforeSend();
    					}
    				},
    				success:function(data){
    					alert("进入packageAjax 的 success");
    					param.success(data);
    				}
    				
    			});
    		}
    		
    };
    
    
	function pageInit() {
		
	jQuery("#list2").jqGrid({
			url : '/ChannelRoutingWeb/channelRouting/selectChannelSupplier.do',
			datatype : "json",
			jsonReader : {
				root : function(obj) {
					var data = analzRespJson(obj);
					return data.cells;
				},
				page : function(obj) {
					var data = analzRespJson(obj);
					return data.page;
				},
				total : function(obj) {
					var data = analzRespJson(obj);
					return data.totalPage;
				},
				records : function(obj) {
					var data = analzRespJson(obj);
					return data.total;
				},
				repeatitems : false
			},
			colNames : [ 'id', 'name' ],
			colModel : [ {
				name : 'id',
				index : 'id',
				width : 550,
				editable : true
			}, {
				name : 'name',
				index : 'name',
				width : 1000,
				editable : true
			} ],
			height:500,
			width:800,
			ajaxGridOptions:packageAjax,
			rownumbers: true,
			rownumWidth: 40,
			rowNum : 10,
			rowList : [ 10,20,30],
			pager : '#pager2',
			sortname : 'id',
			mtype : "post",
			viewrecords : true,
			sortorder : "desc",
			caption : "数据源供应商",
			editurl : "/ChannelRoutingWeb/channelRouting/editCS.do"
		});
	    jQuery("#list2").jqGrid('navGrid', "#pager2", {
			edit : false,
			add : false,
			del : true,
			search:false
		});
		jQuery("#list2").jqGrid('inlineNav', "#pager2");
		jQuery("#list2").jqGrid('filterToolbar',{searchOperators : true}); 
	}
	
	function analzRespJson(jsonObj){
		//var jsonObj= JSON.parse(jsonObjStr);
		if(jsonObj.code=='0000'){
			return jsonObj.respInfo;
		}else{
			alert(jsonObj.errMsg);
		}
	}
</script>

</head>
<body>
 <table id="list2"></table> 
 <div id="pager2"></div>

</body>
</html>