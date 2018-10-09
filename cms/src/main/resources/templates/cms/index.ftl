<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
       <#include "../common/meta.ftl"/>
    <link href="${staticPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- Main navbar -->
<div class="navbar navbar-inverse">
    <div class="navbar-header">
        <a class="navbar-brand" href="${baseUrl}/cms/index"><img src="${staticPath}/assets/images/logo_light.png"
                                                                 alt=""></a>
    </div>

    <div class="navbar-collapse collapse" id="navbar-mobile">

        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="${baseUrl}/cms/logout" class="dropdown-toggle">
                        <i class="glyphicon glyphicon-log-out"></i>
                        <span class="position-right">退出</span>
                    </a>
                </li>


            </ul>
        </div>
    </div>
</div>
<!-- /main navbar -->


<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main sidebar -->
        <div class="sidebar sidebar-main">
            <div class="sidebar-content">
                <ul class="navigation navigation-main navigation-accordion">
                    <!-- Main -->
                    <li class="navigation-header"><span>Main</span> <i class="icon-menu" title="Main pages"></i></li>
                    <li><a href="index.html"><i class="glyphicon glyphicon-user"></i> <span>用户信息</span></a></li>
                    <li><a href="index.html"><i class="glyphicon glyphicon-list"></i> <span>已处理订单</span></a></li>
                    <li><a href="index.html"><i class="glyphicon glyphicon-folder-open"></i> <span>批量生成激活码</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /main sidebar -->

        <!-- Main content -->
        <div class="content-wrapper">
            <div class="fixed-table-toolbar"><div class="pull-left search"><input class="form-control" type="text" placeholder="搜索"></div></div>
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

    function queryParams(params) {
        var param = {
            // mobile: $.trim($("#mobile").val()),
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
    })
</script>
</html>