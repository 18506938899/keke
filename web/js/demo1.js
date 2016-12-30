var successMgr = function () {
    var me = this;
    me.init = function (param) {
        $("#upLoadFile").click(me.uploadFile);
    };

    me.uploadFile = function () {
        alert("开始上传文件");
        var url = $("#path").val() + "/uploadFile.shtml";
        $("#formImportFile").attr("action", url);
        $("#formImportFile").submit();
    };
    return me;
};