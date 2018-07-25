<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="renderer" content="webkit">
	<title>tabWeek</title>
	<link rel="stylesheet" href="css/tabWeek.css">
</head>
<body>
<div class="tab-vertical">
	<div class="tab-header">
		<div class="tab-item active"><span>内容</span></div>
		<div class="tab-line"></div>
		<div class="tab-item"><span>状态</span></div>	
	</div>
	<div class="tab-body">
		<div class="week-content" id="myWeek">
			<div class="week-bar">
				<div class="week-row content"></div>
				<div class="week-row status"></div>
			</div>
		</div>
	</div>
</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/tabWeek.js"></script>
	<script type="text/javascript">
		$(function(){

			var list= [{
		         date:'2016-12-12',
		         week:'星期一',
		         contentList:[
		              {type:1,name:'现场勘查',count:10},
		              {type:2,name:'装表接电',count:11},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:0},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-13',
		         week:'星期二',
		         contentList:[
		              {type:1,name:'现场勘查',count:0},
		              {type:2,name:'装表接电',count:1},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-14',
		         week:'星期三',
		         contentList:[
		              {type:1,name:'现场勘查',count:1},
		              {type:2,name:'装表接电',count:1},
		              {type:3,name:'现场申校',count:2},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-15',
		         week:'星期四',
		         contentList:[
		              {type:1,name:'现场勘查',count:10},
		              {type:2,name:'装表接电',count:1},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:2}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-16',
		         week:'星期五',
		         contentList:[
		              {type:1,name:'现场勘查',count:10},
		              {type:2,name:'装表接电',count:11},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-17',
		         week:'星期六',
		         contentList:[
		              {type:1,name:'现场勘查',count:10},
		              {type:2,name:'装表接电',count:11},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    {
		         date:'2016-12-18',
		         week:'星期日',
		         contentList:[
		              {type:1,name:'现场勘查',count:10},
		              {type:2,name:'装表接电',count:11},
		              {type:3,name:'现场申校',count:12},
		              {type:3,name:'一岗制作业',count:12}
		          ],
		          statusList:[
		              {type:1,name:'处理中',count:10},
		              {type:2,name:'已完工',count:11},
		              {type:3,name:'已回访',count:12}
		          ]
		    },
		    ];

			$("#myWeek").tabWeek(list,function(date,type){
				if($.trim(type)!=''){
					alert("点击业务类型数字:"+date+"--"+type);
				}else{
					alert("点击当天整块:"+date);
				}
				
			});
		});
	</script>
</body>
</html>