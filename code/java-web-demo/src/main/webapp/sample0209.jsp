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
			<a href="#">line-styles</a>
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
	var config = {
		type : 'line',
		data : {
			labels : [ "January", "February", "March", "April", "May", "June",
					"July" ],
			datasets : [
					{
						label : "Unfilled",
						fill : false,
						backgroundColor : window.chartColors.blue,
						borderColor : window.chartColors.blue,
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
					},
					{
						label : "Dashed",
						fill : false,
						backgroundColor : window.chartColors.green,
						borderColor : window.chartColors.green,
						borderDash : [ 5, 5 ],
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
					},
					{
						label : "Filled",
						backgroundColor : window.chartColors.red,
						borderColor : window.chartColors.red,
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
						fill : true,
					} ]
		},
		options : {
			responsive : true,
			title : {
				display : true,
				text : 'Chart.js Line Chart'
			},
			tooltips : {
				mode : 'index',
				intersect : false,
			},
			hover : {
				mode : 'nearest',
				intersect : true
			},
			scales : {
				xAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : 'Month'
					}
				} ],
				yAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : 'Value'
					}
				} ]
			}
		}
	};

	window.onload = function() {
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx, config);
	};
</script>

</html>