<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>曲线图（Line chart）</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="js/Chart.bundle.js"></script>
<script type="text/javascript" src="js/utils.js"></script>
</head>
<body>

	<div class="canvasWrapper" style="width:65%;">
		<canvas id="canvas" height="450" width="600"></canvas>
	</div>

	<script>
		var lineChartData = {
			labels : [ "January", "February", "March", "April", "May", "June",
					"July" ],
			datasets : [ {
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				pointColor : "rgba(220,220,220,1)",
				pointStrokeColor : "#fff",
				data : [ 65, 59, 90, 81, 56, 55, 40 ]
			}, {
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,1)",
				pointColor : "rgba(151,187,205,1)",
				pointStrokeColor : "#fff",
				data : [ 28, 48, 40, 19, 96, 27, 100 ]
			} ]

		}

		var config = {
			type : 'line',
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : [ 65, 59, 90, 81, 56, 55, 40 ]
				}, {
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [ 28, 48, 40, 19, 96, 27, 100 ]
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

		var config2 = {
			type : 'line',
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [
						{
							label : "My First dataset",
							backgroundColor : window.chartColors.red,
							borderColor : window.chartColors.red,
							data : [ randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor() ],
							fill : false,
						},
						{
							label : "My Second dataset",
							fill : false,
							backgroundColor : window.chartColors.blue,
							borderColor : window.chartColors.blue,
							data : [ randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor(),
									randomScalingFactor() ],
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
			window.myLine = new Chart(ctx, config2);
		};
	</script>
</body>
</html>