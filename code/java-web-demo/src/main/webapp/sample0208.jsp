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
		<div class="hero-unit">
			<a href="#">line/interpolation-modes.html</a>
		</div>
		<div class="row">
			<div class="span12">
				<canvas id="canvas"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
	</div>
</body>
<script>
	var randomScalingFactor = function() {
		return Math.round(Math.random() * 100);
	};

	var datapoints = [ 0, 20, 20, 60, 60, 120, NaN, 180, 120, 125, 105, 110,
			170 ];
	var config = {
		type : 'line',
		data : {
			labels : [ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12" ],
			datasets : [ {
				label : "Cubic interpolation (monotone)",
				data : datapoints,
				borderColor : window.chartColors.red,
				backgroundColor : 'rgba(0, 0, 0, 0)',
				fill : false,
				cubicInterpolationMode : 'monotone'
			}, {
				label : "Cubic interpolation (default)",
				data : datapoints,
				borderColor : window.chartColors.blue,
				backgroundColor : 'rgba(0, 0, 0, 0)',
				fill : false,
			}, {
				label : "Linear interpolation",
				data : datapoints,
				borderColor : window.chartColors.green,
				backgroundColor : 'rgba(0, 0, 0, 0)',
				fill : false,
				lineTension : 0 // 线张力，设置为0则为折线图
			} ]
		},
		options : {
			responsive : true,
			title : {
				display : true,
				text : 'Chart.js Line Chart - Cubic interpolation mode'
			},
			tooltips : {
				mode : 'index'
			},
			scales : {
				xAxes : [ {
					display : true,
					scaleLabel : {
						display : true
					}
				} ],
				yAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : 'Value'
					},
					ticks : {
						suggestedMin : -10,
						suggestedMax : 200,
					}
				} ]
			}
		}
	};

	window.onload = function() {
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx, config);
	};

	document.getElementById('randomizeData').addEventListener(
			'click',
			function() {
				for (var i = 0, len = datapoints.length; i < len; ++i) {
					datapoints[i] = Math.random() < 0.05 ? NaN
							: randomScalingFactor();
				}
				window.myLine.update();
			});
</script>

</html>