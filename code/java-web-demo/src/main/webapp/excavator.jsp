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
.row div {
	
}
</style>
</head>
<body>
	<div id="container1" style="width: 99%;">
		<canvas id="canvas1"></canvas>
	</div>
	<div id="container21" style="width: 99%;">
		<canvas id="canvas21"></canvas>
	</div>
	
	<div id="container22" style="width: 99%;">
		<canvas id="canvas22"></canvas>
	</div>
	<div id="container23" style="width: 99%;">
		<canvas id="canvas23"></canvas>
	</div>
	<script>
		var color = Chart.helpers.color;
		
		var months = [ "2017-03", "2017-04", "2017-05", "2017-06", "2017-07",
			"2017-08"];//, "2017-09", "2017-10", "2017-11", "2017-12" ];
		var workday_amounts = [];// 大车
		var amounts2 = ["31","30","31","30","31","31"];//,"30"];// 小车
		$.ajax({
			url : "js/workdays_count.json",//json文件位置
			type : "GET",//请求方式为get
			dataType : "json", //返回数据格式为json
			success : function(data) {//请求成功完成后要执行的方法 
				//each循环 使用$.each方法遍历返回的数据date
				//var str = '';
				$.each(data, function(key, value) {
					// console.log(index + ":" + value);
					var amounts = value;
					workday_amounts.push(amounts);
					//str += '<div>日期:' + key + ', 数量：' + value + '</div>';
				})
				//console.log(str);
				//var jsonTip2 = $("#jsonTip2");
				//jsonTip2.html(str);
			}
		});

		var barChartData1 = {
			labels : months,
			datasets : [
					{
						label : '工作天数',
						backgroundColor : color(window.chartColors.yellow).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : workday_amounts
					},
					{
						label : '自然日',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts2
					} ]
		};
		
		var workdays21 = [];//工作日
		var amounts211 = [];// 大车
		var amounts212 = [];// 小车
		var amounts213 = [];// 台班
		$.ajax({
			url : "js/gross_profit_1.json",//json文件位置
			type : "GET",//请求方式为get
			dataType : "json", //返回数据格式为json
			success : function(data) {//请求成功完成后要执行的方法 
				//each循环 使用$.each方法遍历返回的数据date
				//var str = '';
				$.each(data, function(key, value) {
					// console.log(index + ":" + value);
					var workday = key;
					workdays21.push(workday);
					var amounts = value;
					amounts211.push(amounts.A);
					amounts212.push(amounts.B);
					amounts213.push(amounts.C);
					//str += '<div>日期:' + key + ', 数量：' + value + '</div>';
				})
				//console.log(str);
				//var jsonTip2 = $("#jsonTip2");
				//jsonTip2.html(str);
			}
		});

		var barChartData21 = {
			labels : workdays21,
			datasets : [
					{
						label : '大车',
						backgroundColor : color(window.chartColors.red).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.red,
						borderWidth : 1,
						data : amounts211
					},
					{
						label : '小车',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts212
					},
					{
						label : '台班',
						backgroundColor : color(window.chartColors.yellow).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.yellow,
						borderWidth : 1,
						data : amounts213
					} ]
		};
		
		var workdays22 = [];//工作日
		var amounts221 = [];// 大车
		var amounts222 = [];// 小车
		var amounts223 = [];// 台班
		$.ajax({
			url : "js/gross_profit_2.json",//json文件位置
			type : "GET",//请求方式为get
			dataType : "json", //返回数据格式为json
			success : function(data) {//请求成功完成后要执行的方法 
				//each循环 使用$.each方法遍历返回的数据date
				//var str = '';
				$.each(data, function(key, value) {
					// console.log(index + ":" + value);
					var workday = key;
					workdays22.push(workday);
					var amounts = value;
					amounts221.push(amounts.A);
					amounts222.push(amounts.B);
					amounts223.push(amounts.C);
					//str += '<div>日期:' + key + ', 数量：' + value + '</div>';
				})
				//console.log(str);
				//var jsonTip2 = $("#jsonTip2");
				//jsonTip2.html(str);
			}
		});

		var barChartData22 = {
			labels : workdays22,
			datasets : [
					{
						label : '大车',
						backgroundColor : color(window.chartColors.red).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.red,
						borderWidth : 1,
						data : amounts221
					},
					{
						label : '小车',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts222
					},
					{
						label : '台班',
						backgroundColor : color(window.chartColors.yellow).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.yellow,
						borderWidth : 1,
						data : amounts223
					} ]
		};
		
		var workdays23 = [];//工作日
		var amounts231 = [];// 大车
		var amounts232 = [];// 小车
		var amounts233 = [];// 台班
		$.ajax({
			url : "js/gross_profit_3.json",//json文件位置
			type : "GET",//请求方式为get
			dataType : "json", //返回数据格式为json
			success : function(data) {//请求成功完成后要执行的方法 
				//each循环 使用$.each方法遍历返回的数据date
				//var str = '';
				$.each(data, function(key, value) {
					// console.log(index + ":" + value);
					var workday = key;
					workdays23.push(workday);
					var amounts = value;
					amounts231.push(amounts.A);
					amounts232.push(amounts.B);
					amounts233.push(amounts.C);
					//str += '<div>日期:' + key + ', 数量：' + value + '</div>';
				})
				//console.log(str);
				//var jsonTip2 = $("#jsonTip2");
				//jsonTip2.html(str);
			}
		});

		var barChartData23 = {
			labels : workdays23,
			datasets : [
					{
						label : '大车',
						backgroundColor : color(window.chartColors.red).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.red,
						borderWidth : 1,
						data : amounts231
					},
					{
						label : '小车',
						backgroundColor : color(window.chartColors.blue).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.blue,
						borderWidth : 1,
						data : amounts232
					},
					{
						label : '台班',
						backgroundColor : color(window.chartColors.yellow).alpha(
								0.5).rgbString(),
						borderColor : window.chartColors.yellow,
						borderWidth : 1,
						data : amounts233
					} ]
		};

		window.onload = function() {
			var ctx1 = document.getElementById("canvas1").getContext("2d");
			window.myBar = new Chart(ctx1, {
				type : 'bar',
				data : barChartData1,
				options : {
					responsive : true,
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '营运数量统计-每月开工天数'
					}
				}
			});
			
			var ctx21 = document.getElementById("canvas21").getContext("2d");
			window.myBar = new Chart(ctx21, {
				type : 'bar',
				data : barChartData21,
				options : {
					responsive : true,
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '营运数量统计-四化建'
					}
				}
			});
			
			var ctx22 = document.getElementById("canvas22").getContext("2d");
			window.myBar = new Chart(ctx22, {
				type : 'bar',
				data : barChartData22,
				options : {
					responsive : true,
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '营运数量统计-步行街'
					}
				}
			});
			
			var ctx23 = document.getElementById("canvas23").getContext("2d");
			window.myBar = new Chart(ctx23, {
				type : 'bar',
				data : barChartData23,
				options : {
					responsive : true,
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '营运数量统计-南湖公园'
					}
				}
			});
		};
	</script>
</body>
</html>