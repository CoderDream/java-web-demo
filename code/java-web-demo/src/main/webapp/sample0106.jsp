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
		<div class="hero-unit"><a href="http://www.chartjs.org/docs/latest/getting-started/usage.html">http://www.chartjs.org/docs/latest/getting-started/usage.html</a></div>		
		<div class="row">
			<div class="span12">
				<canvas id="myChart1"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart2"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart3"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
	</div>


</body>
<script>
	var config = {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [{
		            label: '# of Votes',
		            data: [12, 19, 3, 5, 2, 3],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		}

	var ctx1 = document.getElementById("myChart1");
	var myChart1 = new Chart(ctx1, config);
	
	var ctx2 = document.getElementById("myChart2");
	var myChart2 = new Chart(ctx2, config);
	
	var ctx3 = document.getElementById("myChart3");
	var myChart3 = new Chart(ctx3, config);

</script>

</html>