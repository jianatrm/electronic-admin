(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25c0d85b"],{"6e05":function(e,t,i){},9406:function(e,t,i){"use strict";i.r(t);var n=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"dashboard-container"},[i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"grid-content bg-purple-dark home-title"},[e._v("\n        "+e._s(e.title)+"\n      ")])])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"grid-content bg-purple-dark home-content"},[e._v("\n        "+e._s(e.content)+"\n      ")])])],1),e._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("div",{staticClass:"grid-content bg-purple-dark home-time"},[i("p",[e._v("公司人事部")]),e._v("\n        "+e._s(e.time)+"\n      ")])])],1),e._v(" "),i("el-row",[i("div",{staticClass:"block"},[i("el-date-picker",{attrs:{type:"datetime",placeholder:"开始日期","value-format":"yyyy-MM-dd",format:"yyyy-MM-dd","picker-options":e.pickerOptionsStart},model:{value:e.startTime,callback:function(t){e.startTime=t},expression:"startTime"}}),e._v(" "),i("span",[e._v(" 至 ")]),e._v(" "),i("el-date-picker",{attrs:{type:"datetime",placeholder:"结束日期","value-format":"yyyy-MM-dd",format:"yyyy-MM-dd","picker-options":e.pickerOptionsEnd},model:{value:e.endTime,callback:function(t){e.endTime=t},expression:"endTime"}}),e._v(" "),i("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.CertificatesCount}},[e._v("搜索")])],1)]),e._v(" "),i("el-row",{staticStyle:{"text-align":"center"}},[i("div",{style:{width:"95%",height:"400px"},attrs:{id:"myChart"}})])],1)},a=[],r=i("b775");function s(e){return Object(r["a"])({url:"electronic/sys/account/CertificatesCount",method:"post",data:e})}var o={name:"Dashboard",mounted:function(){this.drawLine()},data:function(){var e=this;return{startTime:"",endTime:"",pickerOptionsStart:{disabledDate:function(t){if(e.endTime)return t.getTime()>new Date(e.endTime).getTime()}},pickerOptionsEnd:{disabledDate:function(t){if(e.startTime)return t.getTime()<new Date(e.startTime).getTime()-864e5}},title:"公司公告",content:"通知 新进公司的全体员工： 经公司领导班子研究决定，新进公司的员工，一年转正定级后，公司给统一办理缴纳社保。现在由员工自己缴纳社保，缴费收据上交到公司人事部门。为保证员工的合法权益，公司将以现金的形式给予补偿，每月每人补人民币180元，体现在个人的工资里。此规定从2010年6月1日起执行。",time:"2019-09-20"}},methods:{drawLine:function(){var e=this.$echarts.init(document.getElementById("myChart"));e.setOption({title:{text:"证照注册数量统计",x:"left",align:"right"},dataZoom:[{type:"slider",xAxisIndex:0,filterMode:"empty"},{type:"slider",yAxisIndex:0,filterMode:"empty"},{type:"inside",xAxisIndex:0,filterMode:"empty"},{type:"inside",yAxisIndex:0,filterMode:"empty"}],xAxis:{type:"category",data:["2019-08-22","2019-08-23","2019-08-24","2019-08-25","2019-08-26","2019-08-27","2019-08-28","2019-08-29","2019-08-30","2019-08-31","2019-09-01","2019-09-02","2019-09-03","2019-09-04","2019-09-05","2019-09-06","2019-09-07","2019-09-08","2019-09-09","2019-09-10","2019-09-11","2019-09-12","2019-09-13","2019-09-14","2019-09-15","2019-09-16","2019-09-17","2019-09-18","2019-09-19","2019-09-20","2019-09-21"]},yAxis:{type:"value"},series:[{data:["1","2","3","4","5","6","0","0","0","0","234","234","124","234","0","423","0","130","0","13","123","0","0","0","0","0","0","0","0","0","0"],type:"line"}]})},CertificatesCount:function(){var e={beginTime:this.startTime,endTime:this.endTime};s(e).then((function(e){console.log(e)}))}}},d=o,c=(i("e30a"),i("e90a")),l=Object(c["a"])(d,n,a,!1,null,"0d18353c",null);t["default"]=l.exports},e30a:function(e,t,i){"use strict";var n=i("6e05"),a=i.n(n);a.a}}]);