(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d2143ce"],{afa4:function(e,n,t){"use strict";t.r(n);var a=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{staticStyle:{"background-color":"rgba(0,0,0,0.65)","text-align":"center"}},e._l(e.numPages,(function(n){return t("pdf",{key:n,attrs:{src:e.pdfUrl,page:n}})})),1)},r=[],c=t("5165"),o={components:{pdf:c["a"]},name:"pdfPreview",data:function(){return{pdfUrl:"",filename:"",numPages:""}},created:function(){this.filename=this.$route.query.filename,this.pdfUrl=c["a"].createLoadingTask("http://localhost:8001/electronic/pdf/documentConverterToPdf/".concat(this.filename))},mounted:function(){var e=this;this.pdfUrl.then((function(n){e.numPages=n.numPages}))},methods:{change:function(){alert(1)}}},i=o,u=t("e90a"),f=Object(u["a"])(i,a,r,!1,null,"ddbefe66",null);n["default"]=f.exports}}]);