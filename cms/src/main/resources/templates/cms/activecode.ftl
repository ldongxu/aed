<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
       <#include "common/meta.ftl"/>
    <link href="${staticPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<#include "common/navbar.ftl"/>

<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

       <#include "common/sidebar.ftl"/>

        <!-- Main content -->
        <div class="content-wrapper">
            <div class="fixed-table-toolbar">
                <div class="col-lg-3 search">
                    <input type="text" id="input-mobile" class="form-control" placeholder="输入用户账户">
                </div>
                <div class="col-lg-2 search">
                    <input type="number" id="input-num" class="form-control" placeholder="生成数量">
                </div>
                <div class="pull-left search"><button id="btn-generate" type="button" class="btn btn-primary">批量生成</button></div>
            </div>
            <table id="table"></table>
        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
<script type="text/javascript" src="${staticPath}/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/bootstrap-table-zh-CN.min.js"></script>
<script>

    var $table = $('#table');

    function initTable() {
        $table.bootstrapTable({
            cache: false,
            // search: true,
            pagination: true,
            uniqueId: 'id',
            queryParams: queryParams,
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 20, 50],
            sidePagination:'server',
            dataType : 'json',
            url: '/cms/getCode',
            responseHandler:function (res) {
                if (res!=null && res.errcode!=0) {
                    alert(res.msg)
                }
                return res.data;
            },
            columns: [{
                field: 'account',
                title: '账号'
            }, {
                field: 'code',
                title: '激活码'
            }, {
                field: 'extMap.createTimeStr',
                title: '生成时间'
            }, {
                field: 'status',
                title: '激活状态',
                formatter : function (value,row,index) {
                    if (value==0){
                        return "<span style='color: #FF5722'>未激活</span>";
                    }
                    if (value==1){
                        return "<span style='color: #4CAF50'>已激活</span>";
                    }
                }
            }
            ]
        });
    }

    function queryParams() {
        var param = {
            mobile: $.trim($("#input-mobile").val()),
            page: this.pageNumber,
            size: this.pageSize
        };
        return param;
    }

    $(function () {
        $("#btn-generate").click(function () {
            var account = $('#input-mobile').val();
            var num = $('#input-num').val();
            $.post('/cms/generateCode',{"mobile":account,"num":num},function (result) {
                if (result!=null && result.errcode!=0){
                    alert(result.msg);
                }
                $table.bootstrapTable('destroy');
                initTable();
            })
        });


    })
</script>
</html>