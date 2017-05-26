<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图表插件</title>
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="js/Chart.bundle.js"></script>
<script type="text/javascript" src="js/utils.js"></script>
<script type="text/javascript" src="js/analyser.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
	<div class="content">
		<div class="wrapper col-2"><canvas id="chart-0"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-1"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-2"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-3"></canvas></div>

		<div class="toolbar">
			<button onclick="toggleSmooth(this)">Smooth</button>
			<button onclick="randomize(this)">Randomize</button>
		</div>
	</div>

	<script>
		var presets = window.chartColors;
		var utils = Samples.utils;
		var inputs = {
			min: -100,
			max: 100,
			count: 8,
			decimals: 2,
			continuity: 1
		};

		function generateData(config) {
			return utils.numbers(utils.merge(inputs, config || {}));
		}

		function generateLabels(config) {
			return utils.months(utils.merge({
				count: inputs.count,
				section: 3
			}, config || {}));
		}

		var options = {
			maintainAspectRatio: false,
			spanGaps: false,
			elements: {
				line: {
					tension: 0.000001
				}
			},
			plugins: {
				filler: {
					propagate: false
				}
			},
			scales: {
				xAxes: [{
					ticks: {
						autoSkip: false,
						maxRotation: 0
					}
				}]
			}
		};

		[false, 'origin', 'start', 'end'].forEach(function(boundary, index) {

			// reset the random seed to generate the same data for all charts
			utils.srand(8);

			new Chart('chart-' + index, {
				type: 'line',
				data: {
					labels: generateLabels(),
					datasets: [{
						backgroundColor: utils.transparentize(presets.red),
						borderColor: presets.red,
						data: generateData(),
						label: 'Dataset',
						fill: boundary
					}]
				},
				options: utils.merge(options, {
					title: {
						text: 'fill: ' + boundary,
						display: true
					}
				})
			});
		});


		function toggleSmooth(btn) {
			var value = btn.classList.toggle('btn-on');
			Chart.helpers.each(Chart.instances, function(chart) {
				chart.options.elements.line.tension = value? 0.4 : 0.000001;
				chart.update();
			});
		}

		function randomize() {
			var seed = utils.rand();
			Chart.helpers.each(Chart.instances, function(chart) {
				utils.srand(seed);

				chart.data.datasets.forEach(function(dataset) {
					dataset.data = generateData();
				});

				chart.update();
			});
		}
	</script>

</html>