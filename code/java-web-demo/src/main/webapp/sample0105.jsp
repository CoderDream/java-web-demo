<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图表插件</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="js/Chart.bundle.js"></script>
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<canvas id="myChart1"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart2" style="width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart3"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<footer></footer>
	</div>


</body>
<script>

	var config1 = {
			// The type of chart we want to create
			type : 'line',

			// The data for our dataset
			data : {
				labels : ["0:00","2:00","4:00","6:00","8:00","10:00","12:00","14:00","16:00","18:00","20:00","22:00","24:00"],
				datasets : [ {
					label : "当天运行情况",
					fillColor : "transparent",
					strokeColor : "#3399ff",
					pointColor : "#3399ff",
					pointStrokeColor : "#fff",
					data : [58,48,40,39,56,47,50,40,39,56,]
				} ]
			},

			// Configuration options go here
			options : {}
		}
		
		var config2 = {
				// The type of chart we want to create
				type : 'line',

				// The data for our dataset
				data : {
					labels : ["星期一","星期二","星期三","星期四","星期五","星期六","星期天"],
					datasets : [ {
						label : "本周运行情况",
						fillColor : "transparent",
						strokeColor : "#3399ff",
						pointColor : "#3399ff",
						pointStrokeColor : "#fff",
						data : [58,48,40,39,56,47,50]
					} ]
				},

				// Configuration options go here
				options : {}
			}
			
			var config3 = {
					// The type of chart we want to create
					type : 'line',

					// The data for our dataset
					data : {
						labels : ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"],
						datasets : [ {
							label : "本月运行情况",
							fillColor : "transparent",
							strokeColor : "#3399ff",							
							pointColor : "#3399ff",
							pointStrokeColor : "#fff",
							data : [58,48,40,39,56,47,50,48,40,39,56,47,50,48,47,50,48,40,39,56,47,50,48,40,39,56,47,50],
							
						} ]
					},
					
					scrollbar: {
					    enabled: true
					},

					// Configuration options go here
					options : {
						
						
					},
					scaleStartValue :null,     // Y 轴的起始值
				    scaleLineColor : "rgba(0,0,0,.1)",    // Y/X轴的颜色
				    scaleLineWidth : 2,        // X,Y轴的宽度
				    scaleShowLabels : true,    // 刻度是否显示标签, 即Y轴上是否显示文字   
				    scaleLabel : "abc", // Y轴上的刻度,即文字  
					scaleFontFamily : "'Arial'", // 字体  
					scaleFontSize : 12, // 文字大小 
					scaleFontStyle : "normal", // 文字样式  
					scaleFontColor : "#000", // 文字颜色  
					scaleShowGridLines : true, // 是否显示网格  
					scaleGridLineColor : "rgba(0,0,0,0)", // 网格颜色
					scaleGridLineWidth : 2, // 网格宽度  
					bezierCurve : false, // 是否使用贝塞尔曲线? 即:线条是否弯曲     
					pointDot : true, // 是否显示点数  
					pointDotRadius : 6, // 圆点的大小  
					pointDotStrokeWidth : 2, // 圆点的笔触宽度, 即:圆点外层边框大小 
					datasetStroke : true, // 数据集行程
					datasetStrokeWidth : 1, // 线条的宽度, 即:数据集
					datasetFill : false, // 是否填充数据集 
					animation : true, // 是否执行动画  
					animationSteps : 60, // 动画的时间   
					animationEasing : "easeOutQuart", // 动画的特效   
					onAnimationComplete : null	// 动画完成时的执行函数   
				}
		
			
			var defaults = {    
			    scaleStartValue :null,     // Y 轴的起始值
			    scaleLineColor : "rgba(0,0,0,.1)",    // Y/X轴的颜色
			    scaleLineWidth : 2,        // X,Y轴的宽度
			    scaleShowLabels : true,    // 刻度是否显示标签, 即Y轴上是否显示文字   
			    scaleLabel : "abc", // Y轴上的刻度,即文字  
		scaleFontFamily : "'Arial'", // 字体  
		scaleFontSize : 12, // 文字大小 
		scaleFontStyle : "normal", // 文字样式  
		scaleFontColor : "#000", // 文字颜色  
		scaleShowGridLines : true, // 是否显示网格  
		scaleGridLineColor : "rgba(0,0,0,0)", // 网格颜色
		scaleGridLineWidth : 2, // 网格宽度  
		bezierCurve : false, // 是否使用贝塞尔曲线? 即:线条是否弯曲     
		pointDot : true, // 是否显示点数  
		pointDotRadius : 6, // 圆点的大小  
		pointDotStrokeWidth : 2, // 圆点的笔触宽度, 即:圆点外层边框大小 
		datasetStroke : true, // 数据集行程
		datasetStrokeWidth : 1, // 线条的宽度, 即:数据集
		datasetFill : false, // 是否填充数据集 
		animation : true, // 是否执行动画  
		animationSteps : 60, // 动画的时间   
		animationEasing : "easeOutQuart", // 动画的特效   
		onAnimationComplete : null	// 动画完成时的执行函数   
	}

	var chartLine1 = null;
	var chartLine2 = null;
	var chartLine3 = null;
	window.onload = function() {
		var ctx1 = document.getElementById("myChart1").getContext("2d");		          
		chartLine1 = new Chart(ctx1, config1);
		var ctx2 = document.getElementById("myChart2").getContext("2d");
		chartLine2 = new Chart(ctx2, config2);
		var ctx3 = document.getElementById("myChart3").getContext("2d");
		chartLine3 = new Chart(ctx3, config3);
	}

</script>

</html>