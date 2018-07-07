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

        var options = {
            title: {
                text: '各院系平均身高体重',
                subtext: '2016-2017年度/以2013级学生为例',
                left: 'center'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                top: '5%',
                left: 'right',
                data: ['身高', '体重']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: []
                }
            ],
            yAxis: [
                {
                    name: '身高(cm)/体重(kg)',
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '身高',
                    type: 'bar',
                    data: [],
                    markLine: {
                        lineStyle: {
                            normal: {
                                type: 'dashed'
                            }
                        },
                        data: [
                            [{type: 'min'}, {type: 'max'}]
                        ]
                    }
                },
                {
                    name: '体重',
                    type: 'bar',
                    data: [],
                    markLine: {
                        lineStyle: {
                            normal: {
                                type: 'dashed'
                            }
                        },
                        data: [
                            [{type: 'min'}, {type: 'max'}]
                        ]
                    }
                }
            ]
        };

        $.ajax({
            type: "post",
            async: false, //同步执行
            url: "/physical/data/HAndW",
            dataType: "json", //返回数据形式为json
            success: function (result) {
                if (result) {
                    options.xAxis[0].data = result.category;
                    options.series[0].data = result.series[0].data;
                    options.series[1].data = result.series[1].data;

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