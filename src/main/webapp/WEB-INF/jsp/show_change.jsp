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
        var stage = "${stage}";
        var text, url, color;
        if (stage == 1) {
            text = '2014-2015年度';
            url = '/physical/data/change/stage1';
            color='#bf160c';
        } else if (stage == 2) {
            text = '2015-2016年度';
            url = '/physical/data/change/stage2';
            color='#3398DB';
        } else if (stage == 3) {
            text = '2016-2017年度';
            url = '/physical/data/change/stage3';
            color='#dba00d';
        }
        var symbolSize = 2.5;
        var options = {
            color: [color],
            title: {
                text: '2013级学生三年来身高、体重、体能的变化',
                subtext: text,
                left: 'center'
            },
            grid3D: {},
            xAxis3D: {
                name: '身高(cm)',
                type: 'category'
            },
            yAxis3D: {
                name: '体重(kg)'
            },
            zAxis3D: {
                name: '体能(%)'
            },
            dataset: {
                dimensions: ['身高', '体重', '体能'],
                source: []
            },
            series: [
                {
                    type: 'scatter3D',
                    symbolSize: symbolSize,
                    encode: {
                        x: '身高',
                        y: '体重',
                        z: '体能'
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

                    $.each(result.series, function (i, p) {

                        options.dataset.source[i] = result.series[i].data;
                    });

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