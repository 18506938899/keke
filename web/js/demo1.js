var successMgr = function () {
    var me = this;
    me.init = function (param) {
        $("#upLoadFile").click(me.uploadFile);
    };

    me.uploadFile = function () {

        var file1 = document.getElementById("fileImport").files[0];
        if (file1 == null) {
            alert("请选择需要上传的文件");
            return;
        } else {
            var url = $("#path").val() + "/uploadFile.shtml";
            $("#formImportFile").attr("action", url);
            $("#formImportFile").submit();
        }
    };
    return me;
};