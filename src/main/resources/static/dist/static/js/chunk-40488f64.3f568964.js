(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-40488f64"],{"163d":function(e,t,n){"use strict";var a=n("e7ad"),o=n("e042"),i=n("75c4"),r=n("1e5b"),c=n("94b3a"),s=n("238a"),u=n("2ea2").f,l=n("dcb7").f,d=n("064e").f,p=n("777a").trim,f="Number",g=a[f],h=g,m=g.prototype,b=i(n("e005")(m))==f,y="trim"in String.prototype,v=function(e){var t=c(e,!1);if("string"==typeof t&&t.length>2){t=y?t.trim():p(t,3);var n,a,o,i=t.charCodeAt(0);if(43===i||45===i){if(n=t.charCodeAt(2),88===n||120===n)return NaN}else if(48===i){switch(t.charCodeAt(1)){case 66:case 98:a=2,o=49;break;case 79:case 111:a=8,o=55;break;default:return+t}for(var r,s=t.slice(2),u=0,l=s.length;u<l;u++)if(r=s.charCodeAt(u),r<48||r>o)return NaN;return parseInt(s,a)}}return+t};if(!g(" 0o1")||!g("0b1")||g("+0x1")){g=function(e){var t=arguments.length<1?0:e,n=this;return n instanceof g&&(b?s((function(){m.valueOf.call(n)})):i(n)!=f)?r(new h(v(t)),n,g):v(t)};for(var w,N=n("149f")?u(h):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),x=0;N.length>x;x++)o(h,w=N[x])&&!o(g,w)&&d(g,w,l(h,w));g.prototype=m,m.constructor=g,n("bf16")(a,f,g)}},"2aed":function(e,t,n){},"333d":function(e,t,n){"use strict";var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"pagination-container",class:{hidden:e.hidden}},[n("el-pagination",e._b({attrs:{background:e.background,"current-page":e.currentPage,"page-size":e.pageSize,layout:e.layout,"page-sizes":e.pageSizes,total:e.total},on:{"update:currentPage":function(t){e.currentPage=t},"update:current-page":function(t){e.currentPage=t},"update:pageSize":function(t){e.pageSize=t},"update:page-size":function(t){e.pageSize=t},"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}},"el-pagination",e.$attrs,!1))],1)},o=[];n("163d");Math.easeInOutQuad=function(e,t,n,a){return e/=a/2,e<1?n/2*e*e+t:(e--,-n/2*(e*(e-2)-1)+t)};var i=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}();function r(e){document.documentElement.scrollTop=e,document.body.parentNode.scrollTop=e,document.body.scrollTop=e}function c(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function s(e,t,n){var a=c(),o=e-a,s=20,u=0;t="undefined"===typeof t?500:t;var l=function e(){u+=s;var c=Math.easeInOutQuad(u,a,o,t);r(c),u<t?i(e):n&&"function"===typeof n&&n()};l()}var u={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(e){this.$emit("update:page",e)}},pageSize:{get:function(){return this.limit},set:function(e){this.$emit("update:limit",e)}}},methods:{handleSizeChange:function(e){this.$emit("pagination",{page:this.currentPage,limit:e}),this.autoScroll&&s(0,800)},handleCurrentChange:function(e){this.$emit("pagination",{page:e,limit:this.pageSize}),this.autoScroll&&s(0,800)}}},l=u,d=(n("e498"),n("e90a")),p=Object(d["a"])(l,a,o,!1,null,"6af373ef",null);t["a"]=p.exports},"777a":function(e,t,n){var a=n("e46b"),o=n("f6b4"),i=n("238a"),r=n("9769"),c="["+r+"]",s="​",u=RegExp("^"+c+c+"*"),l=RegExp(c+c+"*$"),d=function(e,t,n){var o={},c=i((function(){return!!r[e]()||s[e]()!=s})),u=o[e]=c?t(p):r[e];n&&(o[n]=u),a(a.P+a.F*c,"String",o)},p=d.trim=function(e,t){return e=String(o(e)),1&t&&(e=e.replace(u,"")),2&t&&(e=e.replace(l,"")),e};e.exports=d},8201:function(e,t,n){},9769:function(e,t){e.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},bd13:function(e,t,n){"use strict";var a=n("2aed"),o=n.n(a);o.a},e498:function(e,t,n){"use strict";var a=n("8201"),o=n.n(a);o.a},fe05:function(e,t,n){"use strict";n.d(t,"c",(function(){return o})),n.d(t,"d",(function(){return i})),n.d(t,"a",(function(){return r})),n.d(t,"b",(function(){return c}));var a=n("b775");function o(e){return Object(a["a"])({url:"/electronic/dept/queryDept",method:"post",data:e})}function i(e){return Object(a["a"])({url:"/electronic/dept/updateDept",method:"post",data:e})}function r(e){return Object(a["a"])({url:"/electronic/dept/addDept",method:"post",data:e})}function c(e){return Object(a["a"])({url:"/electronic/deptElectronicDoc/queryDeptElectronicDoc",method:"post",data:e})}},ff08:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container"},[n("el-row",{attrs:{gutter:20}},[n("el-col",{staticStyle:{"text-align":"left"},attrs:{span:12}},[n("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"文档搜索"},model:{value:e.search,callback:function(t){e.search=t},expression:"search"}}),e._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.querydocList(e.search)}}},[e._v("查询")])],1)],1),e._v(" "),n("el-table",{staticStyle:{width:"100%","margin-top":"30px"},attrs:{data:e.docList,border:""}},[n("el-table-column",{attrs:{type:"index",align:"center",label:"序号",width:"220"}}),e._v(" "),n("el-table-column",{attrs:{align:"center",label:"文档名称",width:"220"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.docName)+"\n      ")]}}])}),e._v(" "),n("el-table-column",{attrs:{align:"center",label:"修改时间"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.operateTime)+"\n      ")]}}])}),e._v(" "),n("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-download"},on:{click:function(n){return e.handleEdit(t)}}},[e._v("下载")]),e._v(" "),n("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:function(n){return e.handlePreview(t)}}},[e._v("预览")])]}}])})],1),e._v(" "),n("el-row",{attrs:{gutter:20}},[n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:24}},[n("pagination",{attrs:{total:e.total,page:e.pageNum,limit:e.pageSize},on:{"update:page":function(t){e.pageNum=t},"update:limit":function(t){e.pageSize=t},pagination:e.getList}})],1)],1)],1)},o=[],i=(n("b449"),n("17d6")),r=n("fe05"),c=n("333d"),s={components:{Pagination:c["a"]},data:function(){return{rules:{docName:[{required:!0,message:"请输入账户",trigger:"blur"},{min:3,max:10,message:"长度在 3 到 10 个字符",trigger:"blur"}]},search:"",doc:{docName:"",docCode:""},docList:[],dialogVisible:!1,dialogType:"new",checkStrictly:!1,defaultProps:{children:"children",label:"title"},pageNum:1,pageSize:10,total:0}},mounted:function(){this.querydocList()},methods:{querydocList:function(e){var t=this;Object(r["b"])({pageSize:this.pageSize,pageNum:this.pageNum,docName:e}).then((function(e){t.$loading().close(),e.success&&(t.docList=e.result.result,t.total=e.result.count)}))},getList:function(){this.pageNum++,this.querydocList()},handleEdit:function(e){this.dialogType="edit",this.dialogVisible=!0,this.doc=e.row,this.doc.checkPass=e.row.password},handleDelete:function(e){var t=this,n=e.$index,a=e.row;this.$confirm("确定删除该用户吗?","Warning",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(i["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.deleteRole(a.docId,n);case 2:case"end":return e.stop()}}),e)})))).catch((function(e){console.error(e)}))},handleAdddoc:function(){this.dialogType="new",this.dialogVisible=!0,this.doc={}},deleteRole:function(e,t){var n=this;updatedoc({status:0,docId:e}).then((function(e){n.$loading().close(),e.success&&(n.$message({type:"success",message:"删除成功"}),n.pageNum=1,n.querydocList())}))},submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return console.log("error submit!!"),!1;"new"==t.dialogType?adddoc(t.doc).then((function(e){t.$loading().close(),e.success&&t.$message({type:"success",message:"新增成功"})})):updatedoc(t.doc).then((function(e){t.$loading().close(),e.success&&t.$message({type:"success",message:"修改成功"})})),t.pageNum=1,t.querydocList()}))},handlePreview:function(e){var t=decodeURI(e.row.docUrl).lastIndexOf("."),n=decodeURI(e.row.docUrl).substring(t+1),a="pdf swf html ott fodt  sxw doc docx rtf  wpd  txt  ods  ots  fods sxc  xls xlsx  csv  tsv  odp  otp fodp  sxi  ppt pptx  odg  otg fodg  svg  png jpg  tif  gif bmp";if(-1!=a.indexOf(n)){var o=decodeURI(e.row.docUrl).substring(e.row.docUrl.lastIndexOf("/")+1);-1=="xls xlsx".indexOf("this.filetype")&&window.open("http://localhost:8001/electronic/pdf/documentConverterToPdf/".concat(o));var i=this.$router.resolve({path:"/pdfPreview",query:{filename:o,filetype:n}}),r=i.href;window.open(r,"_blank")}else this.$message({showClose:!0,message:"该文件不支持预览，请下载后查看",type:"warning"})}}},u=s,l=(n("bd13"),n("e90a")),d=Object(l["a"])(u,a,o,!1,null,"d348f5e0",null);t["default"]=d.exports}}]);