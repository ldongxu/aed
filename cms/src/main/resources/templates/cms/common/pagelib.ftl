<#assign pagesBaseDir = request.contextPath+'/static' />
<#function url uri>
    <#return request.contextPath+uri/>
</#function>
<#macro meta title="同游户外" csses=[]>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black"/>
<meta name="format-detection" content="telephone=no"/>
<meta name="format-detection" content="address=no">
<meta name="format-detection" content="date=no">
<meta name="format-detection" content="email=no">
<meta name="description" content="户外活动" />
<meta name="keywords" content="户外 旅游">
<title>${title}</title>

	<!-- Global stylesheets -->
	<#--<link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">-->
	<link href="${pagesBaseDir}/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
	<link href="${pagesBaseDir}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${pagesBaseDir}/assets/css/core.css" rel="stylesheet" type="text/css">
	<link href="${pagesBaseDir}/assets/css/components.css" rel="stylesheet" type="text/css">
	<link href="${pagesBaseDir}/assets/css/colors.css" rel="stylesheet" type="text/css">
	<!-- /global stylesheets -->
    <#list csses as css>
    <link rel="stylesheet" href="${pagesBaseDir}/css/${css}"/>
    </#list>
	<!-- Core JS files -->
	<script type="text/javascript" src="${pagesBaseDir}/assets/js/plugins/loaders/pace.min.js"></script>
	<script type="text/javascript" src="${pagesBaseDir}/assets/js/core/libraries/jquery.min.js"></script>
	<script type="text/javascript" src="${pagesBaseDir}/assets/js/core/libraries/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pagesBaseDir}/assets/js/plugins/loaders/blockui.min.js"></script>
	<!-- /core JS files -->

	<!-- Theme JS files -->
	<script type="text/javascript" src="${pagesBaseDir}/assets/js/plugins/forms/styling/uniform.min.js"></script>

	<script type="text/javascript" src="${pagesBaseDir}/assets/js/core/app.js"></script>
	<!-- /theme JS files -->

</#macro>

<#macro header>
<!-- 导航 -->
<header id="header">
    <nav class="container header-nav">
        <div class="header-menu">
            <button class="btn btn-secondary" id="linktal">LinkTal</button>
            <div class="header-menu-items">
                <h2>开发者分时雇佣第一品牌</h2>

                <div class="row">
                    <div class="col-xs-6">
                        <ul>
                            <li><label>解决方案</label></li>
                            <li><a href="${url('/#service')}">服务流程</a></li>
                            <li><a href="${url('/#advantage')}">平台优势</a></li>
                            <li><a href="${url('/pages/developer')}">开发者</a></li>
                        </ul>
                    </div>
                    <div class="col-xs-6">
                        <ul>
                            <li><label>公司信息</label></li>
                            <li><a href="${url('/pages/FAQ')}">常见问题</a></li>
                            <li><a href="${url('/pages/about')}">关于我们</a></li>
                            <#--<li><a target="_blank" href="http://blog.mvp01.com">官方博客</a></li>-->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <a href="${url('/')}" class="logo">
            <img src="${pagesBaseDir}/img/linktal-v.png" alt="logo" class="logo-v">
            <img src="${pagesBaseDir}/img/logo.png" alt="logo" class="logo-fix">
            <img src="${pagesBaseDir}/img/logo.png" alt="logo" class="logo-mobile">
        </a>

        <div class="log-in">
            <a href="${url('/register')}">注册</a>
            <i>/</i>
            <a href="${url('/login')}">登录</a>
        </div>
    </nav>
</header>
</#macro>

<#macro footer>
<footer class="layout-footer">
    <div class="container">
        <div class="our-links">
            <a href="${url('/pages/about')}">关于我们</a>
            <span class="web-space">--</span>
            <span class="mobile-space">|</span>
            <a href="${url('/pages/agreement')}">隐私协议</a>
            <span class="web-space">--</span>
            <span class="mobile-space">|</span>
            <a href="${url('/pages/FAQ')}">常见问题</a>
            <#--<span class="web-space">--</span>-->
            <#--<span class="mobile-space">|</span>-->
            <#--<a target="_blank" href="http://blog.mvp01.com">官方博客</a>-->
            <#--<span class="web-space">--</span>-->
            <#--<span class="mobile-space">|</span>-->
            <#--<a href="${url('/pages/vi')}">Logo素材</a>-->
        </div>
        <div class="our-copy">&copy;2018gwego&nbsp;</div>
    </div>
</footer>
</#macro>

<#macro html title="同游户外" csses=[] scripts=[]>
<!DOCTYPE html>
<html lang="en">
<head>
    <@meta title=title csses=csses />
</head>
<body>
    <#--<@header/>-->
   <#nested >
   <#--<@footer/>-->
</body>
 <#list scripts as script>
    <script type="application/javascript" src="${pagesBaseDir}/js/${script}"></script>
 </#list>
</html>
</#macro>