/*
 * charts/chart_filled_blue.js
 *
 * Demo JavaScript used on charts-page for "Filled Chart (Blue)".
 */

"use strict";
$(document).ready(function(){
    refreshChart();
    <!-- 刷新图表 -->
    function refreshChart() {
        var putUrl = '/admin/appuse/devCount';
        $.ajax({
            url: putUrl, //请求地址
            type: "POST",  //提交类似
            dataType: "json",
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (response) {
                var dataValue = []; //y轴数据
                var ticks = []; //x轴数据
                $(response).each(function (index, value) {
                    dataValue.push([index+1,response[index].devCount]);
                    ticks.push([index+1,response[index].dev_model]);
                });
                if(response){
                    var DataSet = [
                        { label: "装机量", data: dataValue, color: App.getLayoutColorCode('blue') }
                    ];

                    $.plot("#chart_filled_blue", DataSet, $.extend(true, {}, Plugins.getFlotDefaults(), {
                        xaxis: {
                            ticks: ticks,//x轴自定义刻度数据
                        },
                        series: {
                            lines: {
                                fill: false,
                                lineWidth: 1.5
                            },
                            points: {
                                show: true,
                                radius: 2.5,
                                lineWidth: 1.1
                            },
                            grow: { active: true, growings:[ { stepMode: "maximum" } ] }
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

// $(document).ready(function(){
//
// 	// Sample Data
// 	var d1 = [[1262304000000, 0], [1264982400000, 500], [1267401600000, 700], [1270080000000, 1300], [1272672000000, 2600], [1275350400000, 1300], [1277942400000, 1700], [1280620800000, 1300], [1283299200000, 1500], [1285891200000, 2000], [1288569600000, 1500], [1291161600000, 1200]];
//
// 	var data1 = [
// 		{ label: "全部点击", data: d1, color: App.getLayoutColorCode('blue') }
// 	];
//
// 	$.plot("#chart_filled_blue", data1, $.extend(true, {}, Plugins.getFlotDefaults(), {
// 		xaxis: {
// 			min: (new Date(2009, 12, 1)).getTime(),
// 			max: (new Date(2010, 11, 2)).getTime(),
// 			mode: "time",
// 			tickSize: [1, "month"],
// 			monthNames: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
// 			tickLength: 0
// 		},
// 		series: {
// 			lines: {
// 				fill: false,
// 				lineWidth: 1.5
// 			},
// 			points: {
// 				show: true,
// 				radius: 2.5,
// 				lineWidth: 1.1
// 			},
// 			grow: { active: true, growings:[ { stepMode: "maximum" } ] }
// 		},
// 		grid: {
// 			hoverable: true,
// 			clickable: true
// 		},
// 		tooltip: true,
// 		tooltipOpts: {
// 			content: '%s: %y'
// 		}
// 	}));
//
//
// });