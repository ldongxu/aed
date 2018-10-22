<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
     <#include "meta.ftl"/>
<style>
    form label.error {
        color: #c00;
        font-size: 100%;
        font-weight: bold;
        font-variant: small-caps;
    }
</style>
</head>
<body class="login-container  pace-done">
<!-- Default navbar -->
<div class="navbar navbar-default">

    <!-- Navbar header -->
    <div class="navbar-header">
        <a class="navbar-brand" href="#">
            <img src="${staticPath}/assets/images/logo_dark.png" alt="">
        </a>
    </div>
    <!-- /navbar header -->

</div>
<!-- /default navbar -->

<div class="page-container" style="min-height:325px">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Content area -->
            <div class="content">

                <!-- Registration form -->
                <form id="form-register">
                    <div class="row">
                        <div class="col-lg-4 col-lg-offset-4">
                            <div class="panel registration-form">
                                <div class="panel-body">
                                    <div class="text-center">
                                        <div class="icon-object border-success text-success"><i class="icon-plus3"></i>
                                        </div>
                                        <h5 class="content-group-lg">注册账号
                                            <small class="display-block">以下均为必填项</small>
                                        </h5>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback">
                                                    <i class="icon-mobile text-muted"></i>
                                                </div>
                                                <input type="tel" id="mobile" name="mobile" class="form-control" placeholder="手机号" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <input type="text" name="validCode" class="form-control" placeholder="验证码">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <button type="button" class="btn bg-teal-400 form-control">
                                                    获取验证码
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback">
                                                    <i class="icon-user-lock text-muted"></i>
                                                </div>
                                                <input type="password" name="pwd" class="form-control"
                                                       placeholder="设置密码" required>
                                            </div>
                                        </div>


                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback">
                                                    <i class="icon-user-lock text-muted"></i>
                                                </div>
                                                <input type="password" name="pwdRepeat" class="form-control"
                                                       placeholder="重复密码" required>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback">
                                                    <i class="icon-newspaper text-muted"></i>
                                                </div>
                                                <input type="text" name="company" class="form-control" placeholder="企业名称" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback"><i class="icon-people text-muted"></i></div>
                                                <input type="text" name="name" class="form-control" placeholder="联系人" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback">
                                                    <i class="icon-mention text-muted"></i>
                                                </div>
                                                <input type="email" name="email" class="form-control"
                                                       placeholder="邮箱" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group has-feedback">
                                                <div class="form-control-feedback"><i class="icon-location4 text-muted"></i></div>
                                                <input type="text" name="address" class="form-control" placeholder="联系地址" required>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="text-right">
                                        <a href="${baseUrl}/app/login" class="btn btn-link"><i
                                                class="icon-arrow-left13 position-left"></i> 已有账号立刻登陆
                                        </a>
                                        <button id="btn-register" type="button"
                                                class="btn bg-teal-400 btn-labeled btn-labeled-right ml-10"><b><i
                                                class="icon-plus3"></i></b> 立即免费注册
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- /registration form -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
</body>
<script type="text/javascript" src="${staticPath}/js/jquery-validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-validate/localization/messages_zh.js"></script>
<script type="text/javascript" src="${staticPath}/js/jquery-serializeObject.js"></script>

<script>
 $(function () {
     $("#form-register").validate({
         debug: true,
         errorClass: "error"
     });

     $('#btn-register').click(function () {
         $("#form-register").valid();
         var obj = $("#form-register").serializeObject();
         $.post('${baseUrl}/app/doRegister',obj,function (result) {
             console.log(result);
         })
     });
 })
    
</script>
</html>