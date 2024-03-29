    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html lang="zh-CN">
        <%@include file="/WEB-INF/include-head.jsp"%>
        <link rel="stylesheet" href="ztree/zTreeStyle.css"/>
        <script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
        <script type="text/javascript">

        $(function(){

        // 1.创建JSON对象用于存储对zTree所做的设置
        var setting = {};

        // 2.准备生成树形结构的JSON数据
        var zNodes =[
        { name:"父节点1 - 展开", open:true,
        children: [
        { name:"父节点11 - 折叠",
        children: [
        { name:"叶子节点111"},
        { name:"叶子节点112"},
        { name:"叶子节点113"},
        { name:"叶子节点114"}
        ]},
        { name:"父节点12 - 折叠",
        children: [
        { name:"叶子节点121"},
        { name:"叶子节点122"},
        { name:"叶子节点123"},
        { name:"叶子节点124"}
        ]},
        { name:"父节点13 - 没有子节点", isParent:true}
        ]},
        { name:"父节点2 - 折叠",
        children: [
        { name:"父节点21 - 展开", open:true,
        children: [
        { name:"叶子节点211"},
        { name:"叶子节点212"},
        { name:"叶子节点213"},
        { name:"叶子节点214"}
        ]},
        { name:"父节点22 - 折叠",
        children: [
        { name:"叶子节点221"},
        { name:"叶子节点222"},
        { name:"叶子节点223"},
        { name:"叶子节点224"}
        ]},
        { name:"父节点23 - 折叠",
        children: [
        { name:"叶子节点231"},
        { name:"叶子节点232"},
        { name:"叶子节点233"},
        { name:"叶子节点234"}
        ]}
        ]},
        { name:"父节点3 - 没有子节点", isParent:true}

        ];

        // 3.初始化树形结构
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);

        });

        </script>
        <body>

        <%@ include file="/WEB-INF/include-nav.jsp"%>
        <div class="container-fluid">
        <div class="row">
        <%@ include file="/WEB-INF/include-sidebar.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

        <div class="panel panel-default">
        <div class="panel-heading">
        <i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
        <div style="float: right; cursor: pointer;" data-toggle="modal"
        data-target="#myModal">
        <i class="glyphicon glyphicon-question-sign"></i>
        </div>
        </div>
        <div class="panel-body">
        <!-- 这个ul标签是zTree动态生成的节点所依附的静态节点 -->
        <ul id="treeDemo" class="ztree"></ul>
        </div>
        </div>
        </div>
        </div>
        </div>
        </body>
        </html>