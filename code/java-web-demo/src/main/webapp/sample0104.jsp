<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图表插件</title>
<link rel="stylesheet" href="css/bootstrap.css" >
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="js/Chart.bundle.js"></script>
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<style>
.top-offset {
	margin: 5px 0;
}
</style>
<style type="text/css">
.row div { 
	

}
</style>
</head>
<body>
	<div class="container">
		<div class="hero-unit"></div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart1"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="hero-unit"></div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart2"
					style="width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<div class="hero-unit"></div>
		<div class="row">
			<div class="span12">
				<canvas id="myChart3"
					style="display: block; width: 478px; height: 178px;"></canvas>
			</div>
		</div>
		<footer></footer>
	</div>


	<script>
		var ctx = document.getElementById('myChart1').getContext('2d');
		var chart = new Chart(ctx, {
			// The type of chart we want to create
			type : 'line',

			// The data for our dataset
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					label : "My First dataset",
					backgroundColor : 'rgb(255, 99, 132)',
					borderColor : 'rgb(255, 99, 132)',
					data : [ 0, 10, 5, 2, 20, 30, 45 ],
				} ]
			},

			// Configuration options go here
			options : {}
		});

		var ctx2 = document.getElementById('myChart2').getContext('2d');
		var chart2 = new Chart(ctx2, {
			// The type of chart we want to create
			type : 'line',

			// The data for our dataset
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					label : "My First dataset",
					backgroundColor : 'rgb(255, 99, 132)',
					borderColor : 'rgb(255, 99, 132)',
					data : [ 0, 10, 5, 2, 20, 30, 45 ],
				} ]
			},

			// Configuration options go here
			options : {}
		});

		var ctx3 = document.getElementById('myChart3').getContext('2d');
		var chart3 = new Chart(ctx3, {
			// The type of chart we want to create
			type : 'line',

			// The data for our dataset
			data : {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July" ],
				datasets : [ {
					label : "My First dataset",
					backgroundColor : 'rgb(255, 99, 132)',
					borderColor : 'rgb(255, 99, 132)',
					data : [ 0, 10, 5, 2, 20, 30, 45 ],
				} ]
			},

			// Configuration options go here
			options : {}
		});
	</script>

</body>

</html>