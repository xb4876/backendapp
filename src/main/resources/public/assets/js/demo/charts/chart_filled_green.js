/*
 * charts/chart_filled_green.js
 *
 * Demo JavaScript used on charts-page for "Filled Chart (Green)".
 */

"use strict";

$(document).ready(function(){
    refreshChart();
    <!-- 刷新图表 -->
    function refreshChart() {
        var putUrl = '/admin/appuse/weekActive';
        $.ajax({
            url: putUrl, //请求地址
            type: "POST",  //提交类似
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (response) {
                var dataValue = []; //y轴数据
                var ticks = []; //x轴数据
                $(response).each(function (index, value) {
                    dataValue.push([index+1,response[index].activeCount]);
                    ticks.push([index+1,response[index].dateTime]);
                });
                if(response){
                    // Sample Data
                    //var d1 = [[1262304000000, 17], [1264982400000, 600], [1267401600000, 1200], [1270080000000, 1000], [1272672000000, 2000], [1275350400000, 2300], [1277942400000, 2700], [1280620800000, 2000], [1283299200000, 1300], [1285891200000, 1000], [1288569600000, 2300], [1291161600000, 2000]];

                    var DataSet = [
                        { label: "日活跃量", data: dataValue, color: App.getLayoutColorCode('green') }
                    ];

                    $.plot("#chart_filled_green", DataSet, $.extend(true, {}, Plugins.getFlotDefaults(), {
                        xaxis: {
                            ticks: ticks,//x轴自定义刻度数据
                        },
                    	series: {
                            lines: {
                                fill: true,
                                lineWidth: 1.5
                            },
                            points: {
                                show: true,
                                radius: 2.5,
                                lineWidth: 1.1
                            }
                        },
                        grid: {
                            hoverable: true,
                            clickable: true
                        },
                        tooltip: true,
                        tooltipOpts: {
                            content: '%s: %y'
                        }
                    }));

                }

            },
            error: function (response) {
                alert('refresh failed!!!');
            }
        })
    }
});