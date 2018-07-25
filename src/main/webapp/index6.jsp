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
    
	function pageInit() {
		
	jQuery("#list2").jqGrid({
			url : '/ChannelRoutingWeb/channelRouting/selectDataSource.do',
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
			colNames : [ 'id', 'name','url','state','supplierId','hbaseState','hbaseTable','hbaseResult','keyNames','encryptTime','cacheState','noCacheResu'],
			colModel : [ {
				name : 'id',
				index : 'id',
				width : 50,
				editable : true
			} , {
				name : 'name',
				index : 'name',
				width : 100,
				editable : true
			} , {
				name : 'url',
				index : 'url',
				width : 200,
				editable : true
			} , {
				name : 'state',
				index : 'state',
				width : 100,
				editable : true
			} , {
				name : 'supplierId',
				index : 'supplierId',
				width : 100,
				editable : true
			} , {
				name : 'hbaseState',
				index : 'hbaseState',
				width : 100,
				editable : true
			} , {
				name : 'hbaseTable',
				index : 'hbaseTable',
				width : 100,
				editable : true
			} , {
				name : 'hbaseResult',
				index : 'hbaseResult',
				width : 100,
				editable : true
			} , {
				name : 'keyNames',
				index : 'keyNames',
				width : 100,
				editable : true
			} , {
				name : 'encryptTime',
				index : 'encryptTime',
				width : 100,
				editable : true
			} , {
				name : 'cacheState',
				index : 'cacheState',
				width : 100,
				editable : true
			} , {
				name : 'noCacheResu',
				index : 'noCacheResu',
				width : 100,
				editable : true
			}
			],
			rownumbers: true, 
			rownumWidth: 40,
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : '#pager2',
			sortname : 'id',
			mtype : "post",
			viewrecords : true,
			sortorder : "desc",
			caption : "数据源信息",
			editurl : "/ChannelRoutingWeb/channelRouting/editDS.do"
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

	function analzRespJson(jsonObj) {
		//var jsonObj= JSON.parse(jsonObjStr);
		if (jsonObj.code == '0000') {
			return jsonObj.respInfo;
		} else {
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