<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>挖掘机运营状况</title>
<link rel="stylesheet" href="css/bootstrap.css">
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
	<div id="container" style="width: 99%;">
		<canvas id="canvas"></canvas>
	</div>
	<script>
		var workdays = [];
		var amounts1 = [];// 大车
		var amounts2 = [];// 小车
		var amounts3 = [];// 台班
		$.ajax({
			url : "js/gross_profit.json",//json文件位置
			type : "GET",//请求方式为get
			dataType : "json", //返回数据格式为json
			success : function(data) {//请求成功完成后要执行的方法 
				//each循环 使用$.each方法遍历返回的数据date
				//var str = '';
				$.each(data, function(key, value) {
					// console.log(index + ":" + value);
					var workday = key;
					workdays.push(workday);
					var amounts = value;
					amounts1.push(amounts.A);
					amounts2.push(amounts.B);
					amounts3.push(amounts.C);
					//str += '<div>日期:' + key + ', 数量：' + value + '</div>';
				})
				//console.log(str);
				//var jsonTip2 = $("#jsonTip2");
				//jsonTip2.html(str);
			}
		});

		var color = Chart.helpers.color;
		var barChartData = {
			labels : workdays,
			datasets : [
					{
						label : '大车',
						backgroundColor : color(window.chartColors.red).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.red,
						borderWidth : 1,
						data : amounts1
					},
					{
						label : '小车',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts2
					},
					{
						label : '台班',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts3
					} ]
		};

		window.onload = function() {
			var ctx = document.getElementById("canvas").getContext("2d");
			window.myBar = new Chart(ctx, {
				type : 'bar',
				data : barChartData,
				options : {
					responsive : true,
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '营运数量统计'
					}
				}
			});
		};
	</script>
</body>
</html>