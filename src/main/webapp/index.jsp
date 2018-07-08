<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html>
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
<body>
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

<div style="text-align:center;font:normal 14px/24px 'MicroSoft YaHei';color:#ffffff">
    <p>快来查看数据吧!</p>
</div>
<script type="text/javascript" src="/asset/js/jquery-1.11.0.min.js"></script>
<script src="/asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/asset/js/bootsnav.js"></script>
</body>
</html>