<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/style2.css" />
	<link href='https://fonts.googleapis.com/css?family=Electrolize' rel='stylesheet' type='text/css' />
	<link type="text/css" rel="stylesheet" href="css/ui.jqgrid.css">
	<link type="text/css" rel="stylesheet" href="css/jquery-ui.min.css">
	
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
		$(function() {
			pageInitCS();
			pageInitDS();
			pageInitCR();
			pageInitIpWhiteList();
			pageInitModelConfigList();
		});
	
		function pageInitCR() {
			
			jQuery("#list2CR").jqGrid({
					url : '/ChannelRoutingWeb/channelRouting/selectChannelRouting.do',
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
					colNames : [ 'id','功能码funcode', '商户号merID','运营商类型','数据源id','排序','权重','未查得是否使用下一个通道'],
					colModel : [ {
						name : 'id',
						index : 'id',
						hidden : true,
					} , {
						name : 'productSuitesCode',
						index : 'productSuitesCode',
						width : 50,
						editable : true
					} , {
						name : 'merCode',
						index : 'merCode',
						width : 100,
						editable : true
					} , {
						name : 'operatorType',
						index : 'operatorType',
						width : 200,
						editable : true,
						edittype:"select",
						formatter:'select',
						stype:'select',
						editoptions:{value:"-9999:所有;-1:请求无运营商;0:未识别的运营商;1:移动运营商;2:联通运营商;3:电信运营商;4:MD5手机号"}
					} , {
						name : 'dsId',
						index : 'dsId',
						width : 100,
						editable : true
					} , {
						name : 'sort',
						index : 'sort',
						width : 100,
						editable : true
					} , {
						name : 'weight',
						index : 'weight',
						width : 100,
						editable : true
					} , {
						name : 'useNext',
						index : 'useNext',
						width : 100,
						editable : true,
						edittype:"select",
						formatter:'select',
						stype:'select',
						editoptions:{value:"-9999:所有;2:使用;4:不使用"}
					}],
					rownumbers: true, 
					rownumWidth: 40,
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#pager2CR',
					sortname : 'productSuitesCode',
					mtype : "post",
					viewrecords : true,
					sortorder : "desc",
					caption : "通道路由信息",
					editurl : "/ChannelRoutingWeb/channelRouting/editCR.do",
					height:450,
					width:1200
				});
			
				jQuery("#list2CR").jqGrid('navGrid', "#pager2CR", {
						edit : false,
						add : false,
						del : true,
						search:false
					});
				jQuery("#list2CR").jqGrid('inlineNav', "#pager2CR");
				jQuery("#list2CR").jqGrid('filterToolbar',{searchOperators : true});
			}
		
		function pageInitDS() {
			
			jQuery("#list2DS").jqGrid({
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
						editable : true,
						edittype:"select",
						formatter:'select',
						stype:'select',
						editoptions:{value:"-9999:所有;2:可用;4:不可用"}
					} , {
						name : 'supplierId',
						index : 'supplierId',
						width : 100,
						editable : true
					} , {
						name : 'hbaseState',
						index : 'hbaseState',
						width : 100,
						editable : true,
						edittype:"select",
						formatter:'select',
						stype:'select',
						editoptions:{value:"-9999:所有;2:可用;4:不可用"}
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
						editable : true,
						edittype:"select",
						formatter:'select',
						stype:'select',
						editoptions:{value:"-9999:所有;2:可用;4:不可用"}
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
					pager : '#pager2DS',
					sortname : 'id',
					mtype : "post",
					viewrecords : true,
					sortorder : "desc",
					caption : "数据源信息",
					editurl : "/ChannelRoutingWeb/channelRouting/editDS.do",
					height:450,
					width:1200
				});


			    jQuery("#list2DS").jqGrid('navGrid', "#pager2DS", {
					edit : false,
					add : false,
					del : true,
					search:false
				});
				jQuery("#list2DS").jqGrid('inlineNav', "#pager2DS");
				jQuery("#list2DS").jqGrid('filterToolbar',{searchOperators : true});
			}
		
		function pageInitCS() {
			jQuery("#list2CS").jqGrid({
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
					width : 650,
					editable : true
				} ],
				rownumbers : true,
				rownumWidth : 40,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : '#pager2CS',
				sortname : 'id',
				mtype : "post",
				viewrecords : true,
				sortorder : "desc",
				caption : "数据源供应商",
				editurl : "/ChannelRoutingWeb/channelRouting/editCS.do",
				height:450,
				width:1200
			});
			jQuery("#list2CS").jqGrid('navGrid', "#pager2CS", {
				edit : false,
				add : false,
				del : true,
				search : false
			});
			jQuery("#list2CS").jqGrid('inlineNav', "#pager2CS");
			jQuery("#list2CS").jqGrid('filterToolbar', {
				searchOperators : true
			});
		}
		
		//TODO
		  function pageInitIpWhiteList() {
	            jQuery("#list2IpWhiteList").jqGrid({
	                url : '/ChannelRoutingWeb/ipWhiteList/selectIpWhiteList.do',
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
	                colNames : [ 'id','ip', '备注' ],
	                colModel : [ {
                        name : 'id',
                        index : 'id',
                        hidden : true,
                    } ,{
	                    name : 'ip',
	                    index : 'ip',
	                    width : 550,
	                    editable : true
	                }, {
	                    name : 'remark',
	                    index : 'remark',
	                    width : 650,
	                    editable : true
	                } ],
	                rownumbers : true,
	                rownumWidth : 40,
	                rowNum : 10,
	                rowList : [ 10, 20, 30 ],
	                pager : '#pager2IpWhiteList',
	                sortname : 'ip',
	                mtype : "post",
	                viewrecords : true,
	                sortorder : "desc",
	                caption : "ip白名单",
	                editurl : "/ChannelRoutingWeb/ipWhiteList/editIpWhiteList.do",
	                height:450,
	                width:1200
	            });
	            jQuery("#list2IpWhiteList").jqGrid('navGrid', "#pager2IpWhiteList", {
	                edit : false,
	                add : false,
	                del : true,
	                search : false
	            });
	            jQuery("#list2IpWhiteList").jqGrid('inlineNav', "#pager2IpWhiteList");
	            jQuery("#list2IpWhiteList").jqGrid('filterToolbar', {
	                searchOperators : true
	            });
	        }
		
		
		
		  function pageInitModelConfigList() {
	            jQuery("#list2modelConfigList").jqGrid({
	                url : '/ChannelRoutingWeb/modelConfigList/selectModelConfigList.do',
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
	                colNames : [ 'funcode','model_name','request_url','model_class','model_config','isvalid' ],
	                colModel : [ {
                      name : 'funcode',
                      index : 'funcode',
                      editable : true,
                  } ,{
	                    name : 'model_name',
	                    index : 'model_name',
	                    width : 550,
	                    editable : true
	                }, {
	                    name : 'request_url',
	                    index : 'request_url',
	                    width : 650,
	                    editable : true
	                }, {
	                    name : 'model_class',
	                    index : 'model_class',
	                    width : 650,
	                    editable : true
	                } , {
	                    name : 'model_config',
	                    index : 'model_config',
	                    width : 650,
	                    editable : true
	                } , {
	                    name : 'isvalid',
	                    index : 'isvalid',
	                    width : 650,
	                    editable : true,
	                    editoptions:{value:"-9999:所有;1:可用;-1:不可用"}
	                }  
	                ],
	                rownumbers : true,
	                rownumWidth : 40,
	                rowNum : 10,
	                rowList : [ 10, 20, 30 ],
	                pager : '#pager2modelConfigList',
	                sortname : 'funcode',
	                mtype : "post",
	                viewrecords : true,
	                sortorder : "desc",
	                caption : "模型配置",
	                editurl : "/ChannelRoutingWeb/modelConfigList/editModelConfigList.do",
	                height:450,
	                width:1200
	            });
	            jQuery("#list2modelConfigList").jqGrid('navGrid', "#pager2modelConfigList", {
	                edit : false,
	                add : false,
	                del : true,
	                search : false
	            });
	            jQuery("#list2modelConfigList").jqGrid('inlineNav', "#pager2modelConfigList");
	            jQuery("#list2modelConfigList").jqGrid('filterToolbar', {
	                searchOperators : true
	            });
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
				
		<!-- Home -->
		<div id="home" class="content">
			<h2>Home</h2>
			<p>So you want a single page website, uh? Well, if you follow this tutorial you will be able to create a very nifty one-pager. Check out the rest of the sections on this page so you can see for yourself what am I talking about.</p>
			<p>This page consists of different panels that will slide or appear when clicking on the respective link.</p>
			<p>With the general sibling selector we can change the color of the "selected" panel link.</p>
		</div>
		<!-- /Home -->
		
		<!-- Portfolio -->
		<div id="portfolio" class="panel">
			<div class="content">
				 <table id="list2CS"></table> 
 				 <div id="pager2CS"></div>
			</div>
		</div>
		<!-- /Portfolio -->
		
		<!-- About -->
		<div id="about" class="panel">
			<div class="content">
				 <table id="list2DS"></table> 
 				 <div id="pager2DS"></div>
			</div>
		</div>
		<!-- /About -->
		
		<!-- Contact -->
		<div id="contact" class="panel">
			<div class="content">
				 <table id="list2CR"></table> 
 				 <div id="pager2CR"></div>
			</div>
		</div>
		<!-- /Contact -->
		
		<!-- ipWhiteList -->
        <div id="ipWhiteList" class="panel">
            <div class="content">
                 <table id="list2IpWhiteList"></table> 
                 <div id="pager2IpWhiteList"></div>
            </div>
        </div>
        <!-- /WhiteList -->
        
		<!-- modelConfigList -->
        <div id="modelConfigList" class="panel">
            <div class="content">
                 <table id="list2modelConfigList"></table> 
                 <div id="pager2modelConfigList"></div>
            </div>
        </div>
        <!-- /modelConfigList -->
		
		<!-- Header with Navigation -->
		<div id="header">
			<h1>通道路由配置页面</h1>
			<ul id="navigation">
				<li><a id="link-home" href="#home">Home</a></li>
				<li><a id="link-portfolio" href="#portfolio">数据源供应商</a></li>
				<li><a id="link-about" href="#about">数据源</a></li>
				<li><a id="link-contact" href="#contact">通道路由</a></li>
				<li><a id="link-ipWhiteList" href="#ipWhiteList">ip白名单</a></li>
				<li><a id="link-ipWhiteList" href="#ipWhiteList">ip白名单</a></li>
			</ul>
			<!-- Demo Nav
			<nav id="codrops-demos">
				<a class="current-demo" href="#home">Demo 1</a>
				<a href="index2.jsp#home">Demo 2</a>
				<a href="index3.jsp#home">Demo 3</a>
			</nav> -->
		</div>

	</body>
</html>
