<%--
  Created by IntelliJ IDEA.
  User: sk
  Date: 2016/12/6
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>联系Demo(上传文件)</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/demo1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-3.1.1.js"></script>
</head>
<body>
<div>
    <form id="formImportFile" method="post" enctype="multipart/form-data">
        <input type="hidden" value="<%=request.getContextPath()%>" id="path"/>
        <input type="file" id="fileImport" name="fileImport" style="width:200px"/>
        <input type="submit" value="上传" id="upLoadFile"/>
        <c:if test="${not empty finishMsg}">
        <span style="color: red">
                ${finishMsg}
        </span>
        </c:if>
    </form>
</div>
<script>
    var successMgr = new successMgr();
    $(document).ready(successMgr.init);
</script>
</body>
</html>
