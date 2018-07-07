<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
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
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        myChart.showLoading();
        var level = "${level}";
        var text, url;
        if (level == 'A') {
            text = '肥胖人数占院系比重';
            url = '/physical/data/body/A';
        } else if (level == 'B') {
            text = '超重人数占院系比重';
            url = '/physical/data/body/B';
        } else if (level == 'C') {
            text = '体重正常人数占院系比重';
            url = '/physical/data/body/C';
        } else if (level == 'D') {
            text = '低体重人数占院系比重';
            url = '/physical/data/body/D';
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
</body>
</html>