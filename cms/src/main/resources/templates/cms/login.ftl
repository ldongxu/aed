<!DOCTYPE html>
<html lang="en">
<head>
   <#include "../common/meta.ftl"/>
</head>

<body class="login-container">

<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Content area -->
            <div class="content">

                <!-- Simple login form -->
                <form id="loginForm">
                    <div class="panel panel-body login-form">
                        <div class="text-center">
                            <div class="icon-object border-slate-300 text-slate-300"><i class="icon-reading"></i></div>
                            <h5 class="content-group">登陆</h5>
                        </div>

                        <div class="form-group has-feedback has-feedback-left">
                            <input type="text" name="userName" class="form-control" placeholder="账号">
                            <div class="form-control-feedback">
                                <i class="icon-user text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group has-feedback has-feedback-left">
                            <input type="password" name="password" class="form-control" placeholder="密码">
                            <div class="form-control-feedback">
                                <i class="icon-lock2 text-muted"></i>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block">登陆 <i class="icon-circle-right2 position-right"></i></button>
                        </div>

                    </div>
                </form>
                <!-- /simple login form -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
<script type="text/javascript" src="${staticPath}/js/jquery-serializeObject.js"></script>

<script>
    $('#loginForm').submit(function () {
        $.post("/cms/dologin",$('#loginForm').serializeObject(),function (result) {
            if (result!=null && result.errcode==0){
                window.location.href='/cms/index';
            }else if(result!=null){
                alert(result.msg);
            }else {
                alert("登陆异常！");
            }
        })
    });
</script>
</html>
