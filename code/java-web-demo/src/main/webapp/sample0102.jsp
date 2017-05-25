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
    <style>
        .top-offset{
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container" style="width:75%;">
    <div class="row top-offset">
        <div>
            <canvas id="canvas"></canvas>
        </div>
    </div>
    <div class="row">
        <div>
            <button id="randomizeData">随机数据</button>
            <button id="addDataset">添加数据</button>
            <button id="removeDataset">移除数据</button>
            <button id="addData">添加科目</button>
            <button id="removeData">移除科目</button>
        </div>
    </div>
</div>
<script>
    var randomScalingFactor = function() {
        return Math.round(Math.random() * 100);
    };
    var randomColorFactor = function() {
        return Math.round(Math.random() * 255);
    };
    var randomColor = function(opacity) {
        return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
    };

    var config = {
        type: 'radar',
        data: {
            labels: ["语文", "数学", "英语", "理综", "基本能力", "体育"],
            datasets: [{
                label: "一本分数线",
                backgroundColor: "rgba(1, 191, 157,0.2)",
                pointBackgroundColor: "rgba(31, 207, 109,1)",
                data: [122, 125, 118,210,92,95]
            },{
                label: "二本分数线",
                hidden: true,
                backgroundColor: "rgba(220,220,220,0.2)",
                pointBackgroundColor: "rgba(220,220,220,1)",
                data: [115, 110, 105,180,85,86]
            }, {
                label: '三本分数线',
                hidden: true,
                data: [90, 85, 98,130,80,82],
            }, {
                label: "我的成绩",
                backgroundColor: "rgba(243,112,33,0.2)",
                pointBackgroundColor: "rgba(255,62,62,1)",
                hoverPointBackgroundColor: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: [122, 120, 128,190,90,92]
            },]
        },
        options: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: '高考成绩雷达图'
            },
            scale: {
                reverse: false,
                gridLines: {
                    color: ['black', 'red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet']
                },
                ticks: {
                    beginAtZero: true
                }
            }
        }
    };
    // 实例化雷达图
    $(function () {
        window.myRadar = new Chart($("#canvas"), config);
    })

    // 随机数据
    $('#randomizeData').click(function() {
        $.each(config.data.datasets, function(i, dataset) {
            dataset.data = dataset.data.map(function() {
                return randomScalingFactor();
            });

        });

        window.myRadar.update();
    });
    // 添加学生数据
    $('#addDataset').click(function() {
        var newDataset = {
            label: '学生 ' + config.data.datasets.length + " 成绩",
            borderColor: randomColor(0.4),
            backgroundColor: randomColor(0.5),
            pointBorderColor: randomColor(0.7),
            pointBackgroundColor: randomColor(0.5),
            pointBorderWidth: 1,
            data: [],
        };

        for (var index = 0; index < config.data.labels.length; ++index) {
            newDataset.data.push(randomScalingFactor());
        }

        config.data.datasets.push(newDataset);
        window.myRadar.update();
    });
    // 添加课程
    $('#addData').click(function() {
        if (config.data.datasets.length > 0) {
            config.data.labels.push('科目 #' + config.data.labels.length);

            $.each(config.data.datasets, function (i, dataset) {
                dataset.data.push(randomScalingFactor());
            });

            window.myRadar.update();
        }
    });
    // 移除学生数据
    $('#removeDataset').click(function() {
        // 删除 splice(数据位置,数据个数)
//        config.data.datasets.splice(0, 1);
        // pop() 最后一个元素出栈，删除并返回最后一个元素
        config.data.datasets.pop();
        window.myRadar.update();
    });
    // 移除课程数据
    $('#removeData').click(function() {
        config.data.labels.pop(); // remove the label first

        $.each(config.data.datasets, function(i, dataset) {
            dataset.data.pop();
        });

        window.myRadar.update();
    });


</script>
</body>

</html>