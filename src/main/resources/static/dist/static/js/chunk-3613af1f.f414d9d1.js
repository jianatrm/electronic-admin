(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3613af1f"],{"163d":function(t,e,n){"use strict";var i=n("e7ad"),a=n("e042"),o=n("75c4"),r=n("1e5b"),l=n("94b3a"),c=n("238a"),u=n("2ea2").f,s=n("dcb7").f,d=n("064e").f,p=n("777a").trim,f="Number",g=i[f],m=g,h=g.prototype,b=o(n("e005")(h))==f,v="trim"in String.prototype,y=function(t){var e=l(t,!1);if("string"==typeof e&&e.length>2){e=v?e.trim():p(e,3);var n,i,a,o=e.charCodeAt(0);if(43===o||45===o){if(n=e.charCodeAt(2),88===n||120===n)return NaN}else if(48===o){switch(e.charCodeAt(1)){case 66:case 98:i=2,a=49;break;case 79:case 111:i=8,a=55;break;default:return+e}for(var r,c=e.slice(2),u=0,s=c.length;u<s;u++)if(r=c.charCodeAt(u),r<48||r>a)return NaN;return parseInt(c,i)}}return+e};if(!g(" 0o1")||!g("0b1")||g("+0x1")){g=function(t){var e=arguments.length<1?0:t,n=this;return n instanceof g&&(b?c((function(){h.valueOf.call(n)})):o(n)!=f)?r(new m(y(e)),n,g):y(e)};for(var _,S=n("149f")?u(m):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),N=0;S.length>N;N++)a(m,_=S[N])&&!a(g,_)&&d(g,_,s(m,_));g.prototype=h,h.constructor=g,n("bf16")(i,f,g)}},"333d":function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[n("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"update:page-size":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},a=[];n("163d");Math.easeInOutQuad=function(t,e,n,i){return t/=i/2,t<1?n/2*t*t+e:(t--,-n/2*(t*(t-2)-1)+e)};var o=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)}}();function r(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function c(t,e,n){var i=l(),a=t-i,c=20,u=0;e="undefined"===typeof e?500:e;var s=function t(){u+=c;var l=Math.easeInOutQuad(u,i,a,e);r(l),u<e?o(t):n&&"function"===typeof n&&n()};s()}var u={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&c(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&c(0,800)}}},s=u,d=(n("e498"),n("e90a")),p=Object(d["a"])(s,i,a,!1,null,"6af373ef",null);e["a"]=p.exports},"4b67":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("el-row",{attrs:{gutter:20}},[n("el-col",{staticStyle:{"text-align":"left"},attrs:{span:12}},[n("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"搜索文档"},model:{value:t.search,callback:function(e){t.search=e},expression:"search"}}),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.querydocList(t.search)}}},[t._v("查询")])],1),t._v(" "),n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:12}},[n("el-button",{attrs:{type:"primary"},on:{click:t.uploaddoc}},[t._v("上传文档")])],1)],1),t._v(" "),n("el-table",{staticStyle:{width:"100%","margin-top":"30px"},attrs:{data:t.docList,border:""}},[n("el-table-column",{attrs:{type:"index",align:"center",label:"序号",width:"220"}}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"文档名称"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(e.row.docName)+"\n      ")]}}])}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"修改时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(e.row.operateTime)+"\n      ")]}}])}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-download"},on:{click:function(n){return t.handleEdit(e)}}},[t._v("下载")]),t._v(" "),n("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-search"},on:{click:function(n){return t.handleEdit(e)}}},[t._v("预览")])]}}])})],1),t._v(" "),n("el-row",{attrs:{gutter:20}},[n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:24}},[n("pagination",{attrs:{total:t.total,page:t.pageNum,limit:t.pageSize},on:{"update:page":function(e){t.pageNum=e},"update:limit":function(e){t.pageSize=e},pagination:t.getList}})],1)],1),t._v(" "),n("el-dialog",{attrs:{visible:t.dialogVisible,title:"新建文档"},on:{"update:visible":function(e){t.dialogVisible=e}}},[n("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{"label-width":"100px"}},[n("el-form-item",[n("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"http://localhost:8088/electronic/file/uploadFile","on-success":t.handleAvatarSuccess,"file-list":t.fileList,multiple:""}},[n("i",{staticClass:"el-icon-upload"}),t._v(" "),n("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),n("em",[t._v("点击上传")])]),t._v(" "),n("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg/png文件，且不超过500kb")])])],1)],1),t._v(" "),n("div",{staticStyle:{"text-align":"right"}},[n("el-button",{attrs:{type:"danger"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("取消")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.submitForm()}}},[t._v("提交")])],1)],1)],1)},a=[],o=(n("cc57"),n("e475")),r=n("333d"),l={components:{Pagination:r["a"]},data:function(){return{search:"",doc:{docName:"",docCode:""},docList:[],dialogVisible:!1,dialogType:"new",checkStrictly:!1,defaultProps:{children:"children",label:"title"},fileList:[],pageNum:1,pageSize:10,total:10}},mounted:function(){this.querydocList()},methods:{querydocList:function(t){var e=this;Object(o["b"])({pageSize:this.pageSize,pageNum:this.pageNum,docName:t}).then((function(t){t.success&&(e.docList=t.result.result,e.total=t.result.count)}))},getList:function(){this.pageNum++,this.querydocList()},handleEdit:function(){this.fileList=[],this.dialogVisible=!0},uploaddoc:function(){this.dialogType="new",this.dialogVisible=!0,this.doc={}},handleAvatarSuccess:function(t,e){t.success&&this.fileList.push({name:t.result.fileName,url:t.result.fileDownloadUri})},submitForm:function(){for(var t=this,e=[],n=0;n<this.fileList.length;n++)e.push({docName:this.fileList[n].name,docUrl:this.fileList[n].url});Object(o["a"])({docList:JSON.stringify(e)}).then((function(e){e.success&&(t.$message({type:"success",message:"新增成功"}),t.fileList=[],t.this.dialogVisible=!1),t.pageNum=1,t.querydocList()}))}}},c=l,u=(n("f008"),n("e90a")),s=Object(u["a"])(c,i,a,!1,null,"47de6c5e",null);e["default"]=s.exports},"777a":function(t,e,n){var i=n("e46b"),a=n("f6b4"),o=n("238a"),r=n("9769"),l="["+r+"]",c="​",u=RegExp("^"+l+l+"*"),s=RegExp(l+l+"*$"),d=function(t,e,n){var a={},l=o((function(){return!!r[t]()||c[t]()!=c})),u=a[t]=l?e(p):r[t];n&&(a[n]=u),i(i.P+i.F*l,"String",a)},p=d.trim=function(t,e){return t=String(a(t)),1&e&&(t=t.replace(u,"")),2&e&&(t=t.replace(s,"")),t};t.exports=d},8201:function(t,e,n){},9769:function(t,e){t.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},e475:function(t,e,n){"use strict";n.d(e,"b",(function(){return a})),n.d(e,"c",(function(){return o})),n.d(e,"a",(function(){return r}));var i=n("b775");function a(t){return Object(i["a"])({url:"electronic/doc/queryDoc",method:"post",data:t})}function o(t){return Object(i["a"])({url:"electronic/doc/updateDoc",method:"post",data:t})}function r(t){return Object(i["a"])({url:"electronic/doc/addDoc",method:"post",data:t})}},e498:function(t,e,n){"use strict";var i=n("8201"),a=n.n(i);a.a},f008:function(t,e,n){"use strict";var i=n("ff52"),a=n.n(i);a.a},ff52:function(t,e,n){}}]);