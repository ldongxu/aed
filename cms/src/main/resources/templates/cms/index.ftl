<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
       <#include "../common/meta.ftl"/>
    <link href="${staticPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<#include "../common/navbar.ftl"/>

<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

       <#include "../common/sidebar.ftl"/>

        <!-- Main content -->
        <div class="content-wrapper">
            <div class="fixed-table-toolbar">
                <div class="pull-left search"><input id="search-input" class="form-control" type="text" placeholder="输入账号搜索"></div>
                <div class="pull-left search"><button id="search" type="button" class="btn btn-primary">搜索</button></div>
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
            // responseHandler:responseHandler,
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 20, 50],
            sidePagination:'server',
            dataType : 'json',
            url: '/cms/userList',
            responseHandler:function (res) {
                return res.data;
            },
            columns: [{
                field: 'mobile',
                title: '账号'
            }, {
                field: 'name',
                title: '姓名'
            }, {
                field: 'company',
                title: '公司'
            }, {
                field: 'email',
                title: '邮箱'
            }, {
                field: 'address',
                title: '地址'
            }
            ]
        });
    }

    function queryParams() {
        var param = {
            mobile: $.trim($("#search-input").val()),
            page: this.pageNumber,
            size: this.pageSize
        };
        return param;
    }
    function responseHandler(result) {
        if (result) {
            var res=result;
            return {
                "rows" : res.rows,
                "total" : res.total,
            };
        } else {
            return {
                "rows" : [],
                "total" : 0
            };
        }
    }
    $(function () {
        initTable();
        $('#search').click(function () {
            $table.bootstrapTable(('refresh'));
        });
    })
</script>
</html>