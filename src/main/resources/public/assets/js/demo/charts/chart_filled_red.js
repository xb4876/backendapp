/*
 * charts/chart_filled_red.js
 *
 * Demo JavaScript used on charts-page for "Vertical Bars".
 */

"use strict";

$(document).ready(function(){

    refreshChart();

    <!-- 刷新图表 -->
    function refreshChart() {
        var putUrl = '/admin/appuse/question3';
        $.ajax({
            url: putUrl, //请求地址
            type: "POST",  //提交类似
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (response) {
                if(response) {
                    var dataValue = []; //y轴数据
                    var ticks = []; //x轴数据
                    for (var i = 0; i < response.length; i ++){
                        dataValue.push([i,response[i].viewnum])
                        ticks.push([i,response[i].title])
					}

                    var dataset = [{
                        data: dataValue,
                        color: "#d8e5ca"
                    }];

                    var options = {
                        series: {
                            bars: {
                                show: true
                            }
                        },
                        bars: {
                            align: "center",
                            barWidth: 0.5
                        },
                        xaxis: {
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 10,
                            ticks: ticks

                        },
                        yaxis: {
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Verdana, Arial',
                            axisLabelPadding: 3
                        },
                        legend: {
                            noColumns: 0,
                            labelBoxBorderColor: "#000000",
                            position: "nw"
                        },
                        grid: {
                            hoverable: true,
                            borderWidth: 2,
                            backgroundColor: {
                                colors: ["#ffffff", "#EDF5FF"]
                            }
                        }
                    };

					$.plot($("#chart_filled_red"), dataset, options);
                }
            },
            error: function (response) {
                alert('refresh failed!!!');
            }
        })
    }




});