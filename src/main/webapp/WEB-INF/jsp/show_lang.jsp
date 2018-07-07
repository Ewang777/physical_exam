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
        var factor = "${factor}";
        var text,url;
        if (factor == 'body') {
            text='身高体重等级相对肺活量的影响';
            url = '/physical/data/lang/body';
        } else if (factor == 'sport') {
            text='运动能力相对肺活量的影响';
            url = '/physical/data/lang/sport';
        }
        var options = {
            color : [ '#3398DB' ],
            title: {
                text: text,
                subtext: '2016-2017年度/全校学生',
                left: 'center'
            },
            tooltip : {
                trigger : 'axis'
            },
            toolbox : {
                show : true,
                feature : {
                    mark : false
                }
            },
            calculable : true,
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {
                type: 'value',
                splitArea : {
                    show : true
                }
            },
            series: [{
                data: [],
                type: 'bar'
            }]
        };

        $.ajax({
            type: "post",
            async: false, //同步执行
            url: url,
            dataType: "json", //返回数据形式为json
            success: function (result) {
                if (result) {
                    options.xAxis.data = result.category;
                    options.series[0].data = result.series[0].data;

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