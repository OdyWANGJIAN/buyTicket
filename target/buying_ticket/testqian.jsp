<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">
<%--
Created by IntelliJ IDEA.
User: wanghao
Date: 2018/4/9
Time: 20:10
To change this template use File | Settings | File Templates.
--%>
<!--[if IE 8]>
<html class="ie8"><![endif]-->
<!--[if IE 9]>
<html class="ie9"><![endif]-->
<!--[if gt IE 9]><!-->
<html><!--<![endif]-->
<head>
    <title>选座 - 流星购票网 - 一网打尽好电影</title>

    <link rel="dns-prefetch" href="//p0.meituan.net"/>
    <link rel="dns-prefetch" href="//p1.meituan.net"/>
    <link rel="dns-prefetch" href="//ms0.meituan.net"/>
    <link rel="dns-prefetch" href="//ms1.meituan.net"/>
    <link rel="dns-prefetch" href="//analytics.meituan.com"/>
    <link rel="dns-prefetch" href="//report.meituan.com"/>
    <link rel="dns-prefetch" href="//frep.meituan.com"/>
    <link href="css/self-define.css" rel="stylesheet"/>
    <script src="js/self-define.js" type="text/javascript"></script>

    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="cleartype" content="yes"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="renderer" content="webkit"/>

    <meta name="HandheldFriendly" content="true"/>
    <meta name="format-detection" content="email=no"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <script>
        cid = "c_2yzd0xp5";
        ci = 57;
        window.system = {
            "seatsPrice": {
                "1": {"expression": "28X1", "price": "28"},
                "2": {"expression": "28X2", "price": "56"},
                "3": {"expression": "28X3", "price": "84"},
                "4": {"expression": "28X4", "price": "112"},
                "5": {"expression": "28X5", "price": "140"},
                "6": {"expression": "28X6", "price": "168"}
            },
            "remind": "",
            "uuid": "1A6E888B4A4B29B16FBA1299108DBE9C0D6DFFE4F46E2C5C35AAB50DBCF05D06",
            "cinemaId": 9753
        };

        window.openPlatform = '';

    </script>
    <link rel="stylesheet" href="//ms0.meituan.net/mywww/common.4b838ec3.css"/>
    <link rel="stylesheet" href="//ms0.meituan.net/mywww/cinemas-seat.d66e64ba.css"/>
    <script src="//ms0.meituan.net/mywww/stat.583e6097.js"></script>
    <script>if (window.devicePixelRatio >= 2) {
        document.write('<link rel="stylesheet" href="//ms0.meituan.net/mywww/image-2x.8ba7074d.css"/>')
    }</script>
    <style>
        @font-face {
            font-family: stonefont;
            src: url('//vfile.meituan.net/colorstone/4b3a911617c4966546ee11e8f3a214a33168.eot');
            src: url('//vfile.meituan.net/colorstone/4b3a911617c4966546ee11e8f3a214a33168.eot?#iefix') format('embedded-opentype'),
            url('//vfile.meituan.net/colorstone/01b4601975d4597febf324e4efbdc8fa2092.woff') format('woff');
        }

        .stonefont {
            font-family: stonefont;
        }
    </style>
</head>
<body>
<div id="win"
     style="display:none; POSITION:absolute; width:300px; height:200px; margin-left:540px; margin-top:670px; border:1px solid #888; background-color:#edf; text-align:center">
    <div style="margin-left: 220px">
        <button onclick="closeLogin();">x</button>
    </div>
    <div style="margin-top: 40px">
        <div style="width: 300px;">
            <span>用户名称：</span><span><input type="text" name="userName" id="userName"/></span></div>
        <div style="width: 300px;margin-top: 20px;">
            <span>用户密码：</span><span><input type="password" name="passWord" id="passWord"/></span></div>
    </div>
    <div style="margin-top: 20px">
        <button  onclick="login()">登录</button>
        <button onclick="openregister();">注册账号</button>
    </div>
</div>
<div class="header">
    <div class="header-inner">
        <a href="/" class="logo" data-act="icon-click"></a>
        <div class="city-container" data-val="{currentcityid:57 }">
            <div class="city-selected">
                <div class="city-name">
                    武汉
                    <span class="caret"></span>
                </div>
            </div>
            <div class="city-list" data-val="{ localcityid: 57 }">
                <div class="city-list-header">定位城市：<a class="js-geo-city">武汉</a></div>

            </div>
        </div>


        <div class="nav">
            <ul class="navbar">
                <li><a href="/" data-act="home-click">首页</a></li>
                <li><a href="/films" data-act="movies-click">电影</a></li>
                <li><a href="/cinemas" data-act="cinemas-click">影院</a></li>

                <li><a href="/board" data-act="board-click">榜单</a></li>
                <li><a href="/news" data-act="hotNews-click">热点</a></li>
            </ul>
        </div>

        <div class="user-info">
            <div class="user-avatar J-login">
                <span class="caret"></span>
                <ul class="user-menu">
                        <!--shiro:principal当前登录人的用户名-->
                        欢迎<shiro:principal/>
                </ul>
            </div>
        </div>

        <form action="/query" target="_blank" class="search-form" data-actform="search-click">
            <input name="kw" class="search" type="search" maxlength="32" placeholder="找影视剧、影人、影院" autocomplete="off">
            <input class="submit" type="submit" value="">
        </form>

        <div class="app-download">
            <a href="/app" target="_blank">
                <span class="iphone-icon"></span>
                <span class="apptext">APP下载</span>
                <span class="caret"></span>
                <div class="download-icon">
                    <p class="down-title">扫码下载APP</p>
                    <p class='down-content'>选座更优惠</p>
                </div>
            </a>
        </div>
    </div>
</div>
<div class="header-placeholder"></div>


<div class="container" id="app" class="page-cinemas/seat">
    <div class="order-progress-bar">
        <div class="step first done">
            <span class="step-num">1</span>
            <div class="bar"></div>
            <span class="step-text">选择影片场次</span>
        </div>
        <div class="step done">
            <span class="step-num">2</span>
            <div class="bar"></div>
            <span class="step-text">选择座位</span>
        </div>
        <div class="step ">
            <span class="step-num">3</span>
            <div class="bar"></div>
            <span class="step-text">14分钟内付款</span>
        </div>
        <div class="step last ">
            <span class="step-num">4</span>
            <div class="bar"></div>
            <span class="step-text">影院取票观影</span>
        </div>
    </div>


    <div class="main clearfix">
        <div class="hall">
            <div class="seat-example">
                <div class="selectable-example example">
                    <span>可选座位</span>
                </div>
                <div class="sold-example example">
                    <span>已售座位</span>
                </div>
                <div class="selected-example example">
                    <span>已选座位</span>
                </div>
                <div class="couple-example example">
                    <span>情侣座位</span>
                </div>
            </div>


            <div class="seats-block" data-cols="11" data-section-id="264" data-section-name="默认场区"
                 data-seq-no="201804090213801">
                <div class="row-id-container">
                    <span class="row-id">1</span>
                    <span class="row-id">2</span>
                    <span class="row-id">3</span>
                    <span class="row-id">4</span>
                    <span class="row-id">5</span>
                    <span class="row-id">6</span>

                </div>

                <div class="seats-container">
                    <div class="screen-container">
                        <div class="screen">银幕中央</div>
                        <div class="c-screen-line"></div>
                    </div>
                    <div class="seats-wrapper">
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="1"
                  data-no="000000000264-1-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="1"
                  data-no="000000000264-1-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="1"
                  data-no="000000000264-1-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="1"
                  data-no="000000000264-1-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="1"
                  data-no="000000000264-1-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="1"
                  data-no="000000000264-1-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="1"
                  data-no="000000000264-1-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="1"
                  data-no="000000000264-1-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="1"
                  data-no="000000000264-1-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="1"
                  data-no="00000000264-1-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat empty"
                  data-column-id=""
                  data-row-id="1"
                  data-no=""
                  data-st="E"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="2"
                  data-no="000000000264-2-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="2"
                  data-no="000000000264-2-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="2"
                  data-no="000000000264-2-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="2"
                  data-no="000000000264-2-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="2"
                  data-no="000000000264-2-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="2"
                  data-no="000000000264-2-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="2"
                  data-no="000000000264-2-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="2"
                  data-no="000000000264-2-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="2"
                  data-no="000000000264-2-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="2"
                  data-no="00000000264-2-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="11"
                  data-row-id="2"
                  data-no="00000000264-2-11"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="3"
                  data-no="000000000264-3-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="3"
                  data-no="000000000264-3-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="3"
                  data-no="000000000264-3-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="3"
                  data-no="000000000264-3-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="3"
                  data-no="000000000264-3-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="3"
                  data-no="000000000264-3-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="3"
                  data-no="000000000264-3-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="3"
                  data-no="000000000264-3-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="3"
                  data-no="000000000264-3-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="3"
                  data-no="00000000264-3-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat empty"
                  data-column-id=""
                  data-row-id="3"
                  data-no=""
                  data-st="E"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="4"
                  data-no="000000000264-4-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="4"
                  data-no="000000000264-4-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="4"
                  data-no="000000000264-4-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="4"
                  data-no="000000000264-4-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="4"
                  data-no="000000000264-4-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="4"
                  data-no="000000000264-4-6"
                  data-st="LK"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="4"
                  data-no="000000000264-4-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="4"
                  data-no="000000000264-4-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="4"
                  data-no="000000000264-4-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="4"
                  data-no="00000000264-4-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat empty"
                  data-column-id=""
                  data-row-id="4"
                  data-no=""
                  data-st="E"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="5"
                  data-no="000000000264-5-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="5"
                  data-no="000000000264-5-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="5"
                  data-no="000000000264-5-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="5"
                  data-no="000000000264-5-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="5"
                  data-no="000000000264-5-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="5"
                  data-no="000000000264-5-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="5"
                  data-no="000000000264-5-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="5"
                  data-no="000000000264-5-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="5"
                  data-no="000000000264-5-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="5"
                  data-no="00000000264-5-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat empty"
                  data-column-id=""
                  data-row-id="5"
                  data-no=""
                  data-st="E"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="6"
                  data-no="000000000264-6-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="6"
                  data-no="000000000264-6-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="6"
                  data-no="000000000264-6-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="6"
                  data-no="000000000264-6-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="6"
                  data-no="000000000264-6-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="6"
                  data-no="000000000264-6-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="6"
                  data-no="000000000264-6-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="6"
                  data-no="000000000264-6-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="6"
                  data-no="000000000264-6-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="6"
                  data-no="00000000264-6-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat empty"
                  data-column-id=""
                  data-row-id="6"
                  data-no=""
                  data-st="E"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                        <div class="row">
            <span class="seat selectable"
                  data-column-id="1"
                  data-row-id="7"
                  data-no="000000000264-7-1"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="2"
                  data-row-id="7"
                  data-no="000000000264-7-2"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="3"
                  data-row-id="7"
                  data-no="000000000264-7-3"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="4"
                  data-row-id="7"
                  data-no="000000000264-7-4"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="5"
                  data-row-id="7"
                  data-no="000000000264-7-5"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="6"
                  data-row-id="7"
                  data-no="000000000264-7-6"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="7"
                  data-row-id="7"
                  data-no="000000000264-7-7"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="8"
                  data-row-id="7"
                  data-no="000000000264-7-8"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="9"
                  data-row-id="7"
                  data-no="000000000264-7-9"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="10"
                  data-row-id="7"
                  data-no="00000000264-7-10"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
            <span class="seat selectable"
                  data-column-id="11"
                  data-row-id="7"
                  data-no="00000000264-7-11"
                  data-st="N"
                  data-act="seat-click"
                  data-bid="b_s7eiiijf"
            ></span>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div id="temple" style="width: 380px;height: 900px;float: right">
            <div class="side">
                <div class="movie-info clearfix">
                    <div class="poster">
                        <img src="http://p0.meituan.net/movie/a547dd7f6851d7ced67ec1b6c8b7f3b2447754.jpg@115w_158h_1e_1c">
                    </div>
                    <div class="content">
                        <p class="name text-ellipsis" id="filmName">红海行动</p>
                        <div class="info-item">
                            <span>类型 :</span>
                            <span class="value">动作,冒险,科幻</span>
                        </div>
                        <div class="info-item">
                            <span>时长 :</span>
                            <span class="value">140分钟</span>
                        </div>
                    </div>
                </div>

                <div class="show-info">
                    <div class="info-item">
                        <span>影院 :</span>
                        <span class="value text-ellipsis" id="theaterName">江夏高德影院</span>
                    </div>
                    <div class="info-item">
                        <span>影厅 :</span>
                        <span class="value text-ellipsis" id="hallName">一号厅</span>
                    </div>
                    <div class="info-item">
                        <span>版本 :</span>
                        <span class="value text-ellipsis">原版3D</span>
                    </div>
                    <div class="info-item">
                        <span>场次 :</span>
                        <span class="value text-ellipsis screen" id="watchingTime">今天 4月9 21:30</span>
                    </div>
                    <div class="info-item">
                        <span>票价 :</span>
                        <span class="value text-ellipsis" style="width: 20px">￥</span><span class="value text-ellipsis"
                                                                                            style="width: 20px">28</span><span
                            class="value text-ellipsis" style="width: 50px">/张</span>
                    </div>
                </div>

                <div class="ticket-info">
                    <div class="no-ticket">
                        <p class="buy-limit">座位：一次最多选6个座位</p>
                        <p class="no-selected">请<span>点击左侧</span>座位图选择座位</p>
                    </div>
                    <div class="has-ticket" style="display:none">
                        <span class="text">座位：</span>
                        <div class="ticket-container" data-limit="6" id="selectSets"></div>
                    </div>

                    <div class="total-price">
                        <span>总价 :</span>
                        <span class="price" id="sumPrice">0</span>
                    </div>
                </div>

                <!--<div class="confirm-order">
                    <form class="login-form">
                        <input type="text" class="input-phone" id="telephone" placeholder="输入手机号"></td>
                        <div class="captcha" style="display:none">
                            <input type="text" class="input-captcha" placeholder="验证码">
                            <img class="captcha-pic"
                                 src="http://www.meituan.com/account/appcaptcha?uuid=1A6E888B4A4B29B16FBA1299108DBE9C0D6DFFE4F46E2C5C35AAB50DBCF05D06&captchaHash=1523274893830">
                            <span class="change-captcha">看不清楚？换一张</span>
                        </div>
                        <div class="code-inputer">
                            <input type="text" class="input-code" placeholder="填写验证码">
                            <span class="send-code disable">获取验证码</span>
                        </div>
                    </form>
                    <div class="confirm-btn disable" data-act="confirm-click">确认选座</div>
                </div>-->
            </div>
            <div id="ticketsubmit" style="width: 380px;font-size: large;margin-top: 5px;">
                <form>
                    <div>
                        <div style="font-size: 15px;">
                            <span style="color: #4cae4c">手机号：</span><input type="text" class="input" name="telephone"
                                                                           id="telephone" placeholder="输入手机号"
                                                                           onfocus="acquireFocus()"
                                                                           onblur="checkTele()"/>
                            <input type="button" id="toRegister" name="toRegister" value="登录" onclick="openLogin()"
                            />
                            <span id="teleSpan" style="font-size: small"></span>
                        </div>

                        <div style="font-size: 15px;margin-top: 3px">
                            <div>
                                <span style="font-size: 15px;color: #4cae4c">验证码：<input type="text" class="input"
                                                                                        placeholder="输入验证码"
                                                                                        name="inputCode"
                                                                                        id="inputCode"/>
                                </span>
                                <input type="button" id="codeButton" name="getCode" value="获取验证码" onclick="getcode()"
                                       disabled="disabled"/>
                            </div>
                        </div>
                        <div style="font-size: 15px;margin: 20px auto;text-align: center">
                            <input type="button" value="提交订单" onclick="codeLogin()"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal-container" style="display:none">
        <div class="modal">
            <span class="icon"></span>

            <p class="tip"></p>

            <div class="ok-btn btn">我知道了</div>
        </div>
    </div>
</div>
<div class="footer">
    <p class="friendly-links">
        友情链接 :
        <a href="http://www.meituan.com" data-query="utm_source=wwwmaoyan" target="_blank">美团网</a>
        <span></span>
        <a href="http://i.meituan.com/client" data-query="utm_source=wwwmaoyan" target="_blank">美团下载</a>
    </p>
    <p>
        &copy;2016
        猫眼电影 maoyan.com
        <a href="https://tsm.miit.gov.cn/pages/EnterpriseSearchList_Portal.aspx?type=0&keyword=京ICP证160733号&pageNo=1"
           target="_blank">京ICP证160733号</a>
        <a href="http://www.miibeian.gov.cn" target="_blank">京ICP备16022489号-1</a>
        京公网安备 11010502030881号
        <a href="/about/licence" target="_blank">网络文化经营许可证</a>
        <a href="http://www.meituan.com/about/rules" target="_blank">电子公告服务规则</a>
    </p>
    <p>北京猫眼文化传媒有限公司</p>
</div>

<!--[if IE 8]>
<script src="//ms0.meituan.net/mywww/es5-shim.bbad933f.js"></script><![endif]-->
<!--[if IE 8]>
<script src="//ms0.meituan.net/mywww/es5-sham.d6ea26f4.js"></script><![endif]-->
<script src="//ms0.meituan.net/mywww/common.dc33ab40.js"></script>
<script src="//ms0.meituan.net/mywww/cinemas-seat.f35e64e9.js"></script>

<script type="text/javascript">
    function openLogin() {
        document.getElementById("win").style.display = "";
    }
    function closeLogin() {
        document.getElementById("win").style.display = "none";
    }
    function login() {
        var usernameStr=$("#userName").val();
        alert(usernameStr)
        var passwordStr=$("#passWord").val();
        alert(passwordStr)
        var errArrays = new Array();
        errArrays[0] = '账号输入错误，请重新输入';
        errArrays[1] = '登录成功';
        errArrays[2] = '密码错误，请重新输入';
        $.post(
                "/user/login",
                {
                    userName: usernameStr, passWord: passwordStr
                }, function (data) {
                    var jsonObj = JSON.parse(data)
                    var index = jsonObj.code;
                    if (jsonObj.code == 1) {
                        alert(errArrays[index])
                        closeLogin();
                    } else {
                        alert(errArrays[index]);
                    }
                });
    }

    function openregister() {
        window.open("qian_register.html")
    }
</script>
</body>
</html>

