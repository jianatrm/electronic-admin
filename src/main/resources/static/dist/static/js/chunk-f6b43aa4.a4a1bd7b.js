(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f6b43aa4"],{"163d":function(e,t,r){"use strict";var a=r("e7ad"),n=r("e042"),s=r("75c4"),i=r("1e5b"),l=r("94b3a"),u=r("238a"),o=r("2ea2").f,c=r("dcb7").f,p=r("064e").f,d=r("777a").trim,f="Number",g=a[f],m=g,h=g.prototype,b=s(r("e005")(h))==f,v="trim"in String.prototype,y=function(e){var t=l(e,!1);if("string"==typeof t&&t.length>2){t=v?t.trim():d(t,3);var r,a,n,s=t.charCodeAt(0);if(43===s||45===s){if(r=t.charCodeAt(2),88===r||120===r)return NaN}else if(48===s){switch(t.charCodeAt(1)){case 66:case 98:a=2,n=49;break;case 79:case 111:a=8,n=55;break;default:return+t}for(var i,u=t.slice(2),o=0,c=u.length;o<c;o++)if(i=u.charCodeAt(o),i<48||i>n)return NaN;return parseInt(u,a)}}return+t};if(!g(" 0o1")||!g("0b1")||g("+0x1")){g=function(e){var t=arguments.length<1?0:e,r=this;return r instanceof g&&(b?u((function(){h.valueOf.call(r)})):s(r)!=f)?i(new m(y(t)),r,g):y(t)};for(var _,w=r("149f")?o(m):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),k=0;w.length>k;k++)n(m,_=w[k])&&!n(g,_)&&p(g,_,c(m,_));g.prototype=h,h.constructor=g,r("bf16")(a,f,g)}},"2c91":function(e,t,r){},"333d":function(e,t,r){"use strict";var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"pagination-container",class:{hidden:e.hidden}},[r("el-pagination",e._b({attrs:{background:e.background,"current-page":e.currentPage,"page-size":e.pageSize,layout:e.layout,"page-sizes":e.pageSizes,total:e.total},on:{"update:currentPage":function(t){e.currentPage=t},"update:current-page":function(t){e.currentPage=t},"update:pageSize":function(t){e.pageSize=t},"update:page-size":function(t){e.pageSize=t},"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}},"el-pagination",e.$attrs,!1))],1)},n=[];r("163d");Math.easeInOutQuad=function(e,t,r,a){return e/=a/2,e<1?r/2*e*e+t:(e--,-r/2*(e*(e-2)-1)+t)};var s=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}();function i(e){document.documentElement.scrollTop=e,document.body.parentNode.scrollTop=e,document.body.scrollTop=e}function l(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function u(e,t,r){var a=l(),n=e-a,u=20,o=0;t="undefined"===typeof t?500:t;var c=function e(){o+=u;var l=Math.easeInOutQuad(o,a,n,t);i(l),o<t?s(e):r&&"function"===typeof r&&r()};c()}var o={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:20},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(e){this.$emit("update:page",e)}},pageSize:{get:function(){return this.limit},set:function(e){this.$emit("update:limit",e)}}},methods:{handleSizeChange:function(e){this.$emit("pagination",{page:this.currentPage,limit:e}),this.autoScroll&&u(0,800)},handleCurrentChange:function(e){this.$emit("pagination",{page:e,limit:this.pageSize}),this.autoScroll&&u(0,800)}}},c=o,p=(r("e498"),r("e90a")),d=Object(p["a"])(c,a,n,!1,null,"6af373ef",null);t["a"]=d.exports},"777a":function(e,t,r){var a=r("e46b"),n=r("f6b4"),s=r("238a"),i=r("9769"),l="["+i+"]",u="​",o=RegExp("^"+l+l+"*"),c=RegExp(l+l+"*$"),p=function(e,t,r){var n={},l=s((function(){return!!i[e]()||u[e]()!=u})),o=n[e]=l?t(d):i[e];r&&(n[r]=o),a(a.P+a.F*l,"String",n)},d=p.trim=function(e,t){return e=String(n(e)),1&t&&(e=e.replace(o,"")),2&t&&(e=e.replace(c,"")),e};e.exports=p},"7b08":function(e,t,r){"use strict";var a=r("2c91"),n=r.n(a);n.a},8201:function(e,t,r){},9769:function(e,t){e.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},e382:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"app-container"},[r("el-row",{attrs:{gutter:20}},[r("el-col",{staticStyle:{"text-align":"left"},attrs:{span:12}},[r("el-input",{staticStyle:{width:"30%"},attrs:{placeholder:"根据用户名搜索"},model:{value:e.search,callback:function(t){e.search=t},expression:"search"}}),e._v(" "),r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.queryUserList(e.search)}}},[e._v("查询")])],1),e._v(" "),r("el-col",{staticStyle:{"text-align":"right"},attrs:{span:12}},[r("el-button",{attrs:{type:"primary"},on:{click:e.handleAddUser}},[e._v("新建人员")])],1)],1),e._v(" "),r("el-table",{staticStyle:{width:"100%","margin-top":"30px"},attrs:{data:e.userList,border:""}},[r("el-table-column",{attrs:{align:"center",label:"人员ID",width:"220"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.userId)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"用户名",width:"220"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.userName)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"邮箱"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.userEmail)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"手机号"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.userPhone)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"部门"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.description)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"管理员"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.level)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.status)+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"primary",size:"small"},on:{click:function(r){return e.handleEdit(t)}}},[e._v("编辑")]),e._v(" "),r("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(r){return e.handleDelete(t)}}},[e._v("删除")])]}}])})],1),e._v(" "),r("el-row",{attrs:{gutter:20}},[r("el-col",{staticStyle:{"text-align":"right"},attrs:{span:24}},[r("pagination",{attrs:{total:e.total,page:e.pageNum,limit:e.pageSize},on:{"update:page":function(t){e.pageNum=t},"update:limit":function(t){e.pageSize=t},pagination:e.getList}})],1)],1),e._v(" "),r("el-dialog",{attrs:{visible:e.dialogVisible,title:"edit"===e.dialogType?"编辑人员":"新建人员"},on:{"update:visible":function(t){e.dialogVisible=t}}},[r("el-form",{ref:"user",attrs:{model:e.user,"label-width":"80px",inline:!0,rules:e.rules}},[r("el-form-item",{attrs:{label:"用户名",prop:"userName"}},[r("el-input",{attrs:{placeholder:"姓名"},model:{value:e.user.userName,callback:function(t){e.$set(e.user,"userName",t)},expression:"user.userName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"昵称",prop:"nickName"}},[r("el-input",{attrs:{placeholder:"昵称"},model:{value:e.user.nickName,callback:function(t){e.$set(e.user,"nickName",t)},expression:"user.nickName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"真实姓名",prop:"staffName"}},[r("el-input",{attrs:{placeholder:"真实姓名"},model:{value:e.user.staffName,callback:function(t){e.$set(e.user,"staffName",t)},expression:"user.staffName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"性别"}},[r("el-select",{attrs:{placeholder:"请选择"},model:{value:e.user.sex,callback:function(t){e.$set(e.user,"sex",t)},expression:"user.sex"}},[r("el-option",{attrs:{label:"男",value:"1"}}),e._v(" "),r("el-option",{attrs:{label:"女",value:"2"}})],1)],1),e._v(" "),r("el-form-item",{attrs:{label:"邮箱",prop:"userEmail"}},[r("el-input",{attrs:{placeholder:"邮箱"},model:{value:e.user.userEmail,callback:function(t){e.$set(e.user,"userEmail",t)},expression:"user.userEmail"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"手机号",prop:"userPhone"}},[r("el-input",{attrs:{placeholder:"请输入手机号"},model:{value:e.user.userPhone,callback:function(t){e.$set(e.user,"userPhone",t)},expression:"user.userPhone"}})],1),e._v(" "),"new"==e.dialogType?r("el-form-item",{attrs:{label:"密码",prop:"password"}},[r("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}})],1):e._e(),e._v(" "),"new"==e.dialogType?r("el-form-item",{attrs:{label:"确认密码",prop:"checkPass"}},[r("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.user.checkPass,callback:function(t){e.$set(e.user,"checkPass",t)},expression:"user.checkPass"}})],1):e._e(),e._v(" "),r("el-form-item",{attrs:{label:"归属部门",prop:"deptId"}},[r("el-select",{attrs:{placeholder:"请选择部门"},model:{value:e.user.deptId,callback:function(t){e.$set(e.user,"deptId",t)},expression:"user.deptId"}},e._l(e.deptList,(function(e,t){return r("el-option",{key:t,attrs:{label:e.deptName,value:e.deptId}})})),1)],1),e._v(" "),r("el-form-item",{staticStyle:{"margin-left":"-15px"},attrs:{label:"管理员"}},[r("el-select",{attrs:{placeholder:"请选择"},model:{value:e.user.level,callback:function(t){e.$set(e.user,"level",t)},expression:"user.level"}},[r("el-option",{attrs:{label:"是",value:"1"}}),e._v(" "),r("el-option",{attrs:{label:"否",value:"2"}})],1)],1)],1),e._v(" "),r("div",{staticStyle:{"text-align":"right"}},[r("el-button",{attrs:{type:"danger"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取消")]),e._v(" "),r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("user")}}},[e._v("提交")])],1)],1)],1)},n=[],s=(r("b449"),r("17d6")),i=r("c24f"),l=r("333d"),u=r("fe05"),o={components:{Pagination:l["a"]},data:function(){var e=this,t=function(t,r,a){""===r?a(new Error("请输入密码")):(""!==e.user.checkPass&&e.$refs.user.validateField("checkPass"),a())},r=function(t,r,a){""===r?a(new Error("请再次输入密码")):r!==e.user.password?a(new Error("两次输入密码不一致!")):a()};return{rules:{userName:[{required:!0,message:"请输入账户",trigger:"blur"},{min:3,max:10,message:"长度在 3 到 10 个字符",trigger:"blur"}],userEmail:[{required:!0,message:"请输入邮箱地址",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:["blur","change"]}],userPhone:[{required:!0,message:"请输入手机号",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{validator:t,trigger:"blur"}],checkPass:[{required:!0,message:"请再次输入密码",trigger:"blur"},{validator:r,trigger:"blur"}],deptId:[{required:!0,message:"请选择部门",trigger:"change"}]},search:"",user:{userName:"",userEmail:"",userPhone:"",password:"",checkPass:"",deptId:""},deptList:[],userList:[],dialogVisible:!1,dialogType:"new",checkStrictly:!1,defaultProps:{children:"children",label:"title"},pageNum:1,pageSize:10,total:10}},mounted:function(){this.queryUserList()},methods:{queryUserList:function(e){var t=this;Object(i["f"])({pageSize:this.pageSize,pageNum:this.pageNum,userName:e}).then((function(e){t.$loading().close(),e.success&&(t.userList=e.result.result,t.total=e.result.count)}))},queryDeptList:function(){var e=this;Object(u["c"])({pageNum:1,pageSize:1e3}).then((function(t){e.$loading().close(),t.success&&(e.deptList=t.result.result)}))},getList:function(){this.pageNum++,this.queryUserList()},handleEdit:function(e){this.dialogType="edit",this.dialogVisible=!0,this.user=e.row,this.user.checkPass=e.row.password},handleDelete:function(e){var t=this,r=e.$index,a=e.row;this.$confirm("确定删除该用户吗?","Warning",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(s["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.deleteRole(a.userId,r);case 2:case"end":return e.stop()}}),e)})))).catch((function(e){console.error(e)}))},handleAddUser:function(){this.dialogType="new",this.dialogVisible=!0,this.user={},this.queryDeptList()},deleteRole:function(e,t){var r=this;Object(i["h"])({status:0,userId:e}).then((function(e){r.$loading().close(),e.success&&(r.$message({type:"success",message:"删除成功"}),r.pageNum=1,r.queryUserList())}))},submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return console.log("error submit!!"),!1;"new"==t.dialogType?Object(i["a"])(t.user).then((function(e){t.$loading().close(),e.success&&(t.$message({type:"success",message:"新增成功"}),t.dialogVisible=!1)})):Object(i["h"])(t.user).then((function(e){t.$loading().close(),e.success&&(t.$message({type:"success",message:"修改成功"}),t.dialogVisible=!1)})),t.pageNum=1,t.queryUserList()}))}}},c=o,p=(r("7b08"),r("e90a")),d=Object(p["a"])(c,a,n,!1,null,"1ad8e272",null);t["default"]=d.exports},e498:function(e,t,r){"use strict";var a=r("8201"),n=r.n(a);n.a},fe05:function(e,t,r){"use strict";r.d(t,"c",(function(){return n})),r.d(t,"d",(function(){return s})),r.d(t,"a",(function(){return i})),r.d(t,"b",(function(){return l}));var a=r("b775");function n(e){return Object(a["a"])({url:"/electronic/dept/queryDept",method:"post",data:e})}function s(e){return Object(a["a"])({url:"/electronic/dept/updateDept",method:"post",data:e})}function i(e){return Object(a["a"])({url:"/electronic/dept/addDept",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/electronic/deptElectronicDoc/queryDeptElectronicDoc",method:"post",data:e})}}}]);