<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>体测数据分析</title>
    <link href="/asset/css/bootstrap.min.css" rel="stylesheet">
    <link href="/asset/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/asset/css/demo.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/bootsnav.css">
    <link rel="stylesheet" href="/asset/css/nav_bar.css" type="text/css">
</head>
<body style="height: 100%; margin: 0">
<h1 style="text-align: center">体测数据分析</h1>
<div class="demo" style="padding: 2em 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-default navbar-mobile bootsnav">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">体重占院系比重</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/physical/body/A">肥胖</a></li>
                                    <li><a href="/physical/body/B">超重</a></li>
                                    <li><a href="/physical/body/C">正常</a></li>
                                    <li><a href="/physical/body/D">低体重</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">总成绩占院系比重</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/physical/score/A">优秀</a></li>
                                    <li><a href="/physical/score/B">良好</a></li>
                                    <li><a href="/physical/score/C">及格</a></li>
                                    <li><a href="/physical/score/D">不及格</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">肺活量</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/physical/lang/body">身高体重与平均肺活量</a></li>
                                    <li><a href="/physical/lang/sport">运动能力与平均肺活量</a></li>
                                </ul>
                            </li>
                            <li><a href="/physical/HAndW">院系平均身高体重</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">2013级身高体重变化</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/physical/change/stage1">State1</a></li>
                                    <li><a href="/physical/change/stage2">State2</a></li>
                                    <li><a href="/physical/change/stage3">State3</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>
<div id="container_data"
     style="height:600%;text-align:center; "></div>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
<script type="text/javascript" src="/asset/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $().ready(function () {
        var dom = document.getElementById("container_data");
        var myChart = echarts.init(dom);
        myChart.showLoading();
        var level = "${level}";
        var text, url;
        if (level == 'A') {
            text = '优秀人数占院系比重';
            url = '/physical/data/score/A';
        } else if (level == 'B') {
            text = '良好人数占院系比重';
            url = '/physical/data/score/B';
        } else if (level == 'C') {
            text = '及格人数占院系比重';
            url = '/physical/data/score/C';
        } else if (level == 'D') {
            text = '不及格人数占院系比重';
            url = '/physical/data/score/D';
        }
        var options = {
            title: {
                text: text,
                subtext: '2016-2017年度/全校学生',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                bottom: 10,
                left: 'center',
                data: []
            },
            series: [
                {
                    name: text,
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '45%'],
                    selectedMode: 'single',
                    data: [],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        $.ajax({
            type: "post",
            async: false, //同步执行
            url: url,
            dataType: "json", //返回数据形式为json
            success: function (result) {
                if (result) {
                    options.legend.data = result.legend;

                    //将返回的category和series对象赋值给options对象内的category和series
                    //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                    options.series[0].name = result.series[0].name;
                    options.series[0].type = result.series[0].type;
                    var seriesdata = result.series[0].data;

                    //jquery遍历
                    var value = [];
                    $.each(seriesdata, function (i, p) {
                        value[i] = {
                            'name': p['name'],
                            'value': p['value']
                        };
                    });
                    options.series[0]['data'] = value;

                    myChart.hideLoading();
                    myChart.setOption(options);
                }
            },
            error: function (errorMsg) {
                alert("图表请求数据失败啦!");
            }
        });

    });
</script>
<script type="text/javascript" src="/asset/js/jquery-1.11.0.min.js"></script>
<script src="/asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/asset/js/bootsnav.js"></script>
</body>
</html>