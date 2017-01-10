<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <title>个人管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/common/easyui/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/common/easyui/icon.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-layout" style="height: 100%;width: 100%;">
    <div id="divTop" data-options="region:'north'" style="height:50px; background-color: lightslategrey;">
        <img src="<%=request.getContextPath()%>/js/images/logo.png"
             style="margin: 10px 30px 0 0; float: left;">
    </div>
    <div id="divMenu" data-options="region:'west',split:true" title="菜单"
         style="width:200px;">
        <ul id="ulSysMenu" class="easyui-tree"></ul>
    </div>
    <div id="divTab" data-options="region:'center'">
        <div id="divTabs" class="easyui-tabs">
            <div id="divWelcome" title="欢迎页">
                <h1 style="font-size: 36px;text-align: center;line-height: 400px;">个人管理系统</h1>
            </div>
        </div>
    </div>
    <div id="window"></div>
</div>
</body>
</html>