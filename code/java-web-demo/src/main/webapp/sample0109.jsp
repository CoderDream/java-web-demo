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
<style>
body {
	/* background: #1D1F20; */
	padding: 16px;
}

canvas {
	border: 1px dotted red;
}

.chart-container {
	position: relative;
	margin: auto;
	height: 80vh;
	width: 80vw;
}
</style>
<body>
	<div class="chart-container">
		<canvas id="chart"></canvas>
	</div>
	<script>
	var data = {
			  labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"],
			  datasets: [{
			    label: "Dataset #1",
			    backgroundColor: "rgba(255,99,132,0.2)",
			    borderColor: "rgba(255,99,132,1)",
			    borderWidth: 2,
			    hoverBackgroundColor: "rgba(255,99,132,0.4)",
			    hoverBorderColor: "rgba(255,99,132,1)",
			    data: [65, 59, 20, 81, 56, 55, 40],
			  }]
			};

			var options = {
			  maintainAspectRatio: false,
			  scales: {
			    yAxes: [{
			      stacked: true,
			      gridLines: {
			        display: true,
			        color: "rgba(255,99,132,0.2)"
			      }
			    }],
			    xAxes: [{
			      gridLines: {
			        display: false
			      }
			    }]
			  }
			};

			Chart.Bar('chart', {
			  options: options,
			  data: data
			});

	</script>
</body>
</html>