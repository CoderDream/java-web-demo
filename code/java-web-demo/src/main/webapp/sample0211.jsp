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
			<a href="#">point-sizes</a>
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
	var MONTHS = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];
	var config = {
		type : 'line',
		data : {
			labels : [ "January", "February", "March", "April", "May", "June",
					"July" ],
			datasets : [
					{
						label : "dataset - big points",
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
						backgroundColor : window.chartColors.red,
						borderColor : window.chartColors.red,
						fill : false,
						borderDash : [ 5, 5 ],
						pointRadius : 15,
						pointHoverRadius : 10,
					},
					{
						label : "dataset - individual point sizes",
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
						backgroundColor : window.chartColors.blue,
						borderColor : window.chartColors.blue,
						fill : false,
						borderDash : [ 5, 5 ],
						pointRadius : [ 2, 4, 6, 18, 0, 12, 20 ],
					},
					{
						label : "dataset - large pointHoverRadius",
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
						backgroundColor : window.chartColors.green,
						borderColor : window.chartColors.green,
						fill : false,
						pointHoverRadius : 30,
					},
					{
						label : "dataset - large pointHitRadius",
						data : [ randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor(), randomScalingFactor(),
								randomScalingFactor() ],
						backgroundColor : window.chartColors.yellow,
						borderColor : window.chartColors.yellow,
						fill : false,
						pointHitRadius : 20,
					} ]
		},
		options : {
			responsive : true,
			legend : {
				position : 'bottom',
			},
			hover : {
				mode : 'index'
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
			},
			title : {
				display : true,
				text : 'Chart.js Line Chart - Different point sizes'
			}
		}
	};

	window.onload = function() {
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx, config);
	};
</script>

</html>