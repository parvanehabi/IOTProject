<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="beans.ParcelEntity,services.DatabaseService,java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<title>صندوق پستی هوشمند</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="slick-1.8.0/slick/slick.css" />
<link rel="stylesheet" href="slick-1.8.0/slick/slick-theme.css" />
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/select2.min.css" rel="stylesheet" >
<link rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
<div class="container-fluid">
<header id="mainHeader" class="row">
  <nav class="navbar w90">
    <div class="container-fluid"> 
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="#"><img src="images/brand.png"></a> </div>
      
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse rtl" id="bs-example-navbar-collapse-1">
        <div id="userLogin" class="overHide pad10">
          <div class="pull-right"> <a href="/Logout"> <span class="glyphicon glyphicon-log-out"></span> خروج </a> </div>
   
          
          <!--<div class="pull-left"> <input class="input btn-yellow" type="button" value="ثبت آگهی رایگان"> </div>--> 
        </div>
        <div id="top-menu">
          <ul class="nav navbar-nav">
            <li><a href="/index1.jsp">صفحه اصلی</a></li>

          </ul>
        </div>
      </div>
      <!-- /.navbar-collapse --> 
    </div>
    <!-- /.container-fluid --> 
  </nav>
</header>
</div>
<!--********************************************************************-->
<div id="main">

  <div id="content" class="rtl w90 overHide"> 
    <!---------------------------------------------------->
    <!---------------------------------------------------->

    <!---------------------------------------------------->

    <!------------------------------------------------------>
    <div class="row">
      <div class="main_section main_result announces col-lg-9 col-md-9 col-sm-12 col-xs-12">
        <div id="result-announces" class="result-announces">
          <div class="items row">
            <div class="main_box  single_announce  clearfix w-100 list-view" itemscope itemtype="http://schema.org/SingleFamilyResidence">
              <!------------------------------------------------------------>
              <%! List<Object> list = null;%>
              <%  try {
                list = DatabaseService.selectAll("ParcelEntity",null,null,null,"");
              } catch (Exception e) {
                System.out.println("DB Connection Error! box!");
              }
              %>
              <% if(list!=null)
                 for( int j=0 ;j<list.size(); j++) { %>
              <div class="this-have-border clearfix sale-class">
                <div class="announce_images  no-padding border-top-left-0 border-bottom-right-1 float-right">
                  
                  <div class="slider h-100"> <a href="#"> <img src="images/home/1.jpg" alt="فروش آپارتمان مسکونی 315" title="فروش آپارتمان مسکونی 315 متری زعفرانیه" /> </a>
                    <div class="image-count"> <span></span> <!--<i class="sh-camera"></i>--><span> </span> <!--<img class="vr-icon" src="img/360-white.png" />--> </div>
                  </div>
                </div>
                <div class="announce_info px-2 px-sm-3 border-top-right-0 border-bottom-right-0 float-right">
                  <div class="announce_price pt-sm-2 pt-md-3 pb-sm-2 pt-2 pb-1"> <a href="#"> <span class="rent " itemprop="offers" itemscope itemtype="" itemid="#offer">
                    <meta content="IRR" itemprop="priceCurrency">
                    <meta content="-1" itemprop="price">
                    بسته ی شماره <%=j+1 %></span> </a> </div>
                  <div class="announce-title clearfix pb-sm-2 pb-0"> <a href="#" itemprop="url">
                    <div class="title pb-sm-2 pb-1" itemprop="address" itemscope itemtype="">
                      <meta content="IR" itemprop="addressCountry">
                      <meta content="تهران" itemprop="addressRegion">
                      <meta content="زعفرانیه" itemprop="addressLocality">
                      <h4><span></span> </h4>
                    </div>
                    </a> <span class="announce-desc hidden-xs-down"> بارکد بسته : <%=((ParcelEntity)list.get(j)).getBarcode() %></span> </div>
                  <div class="announce_attrs py-1">
                    <%if(((ParcelEntity)list.get(j)).getRecievedate()!=null){%>
                    <div class="w-100 info-info ">
                      <ul class="clearfix">
                        <li> 
                          تاریخ ثبت بارکد : <%=((ParcelEntity)list.get(j)).getRecorddate() %> </li>
                        <li>
                          تاریخ دریافت بسته : <%=((ParcelEntity)list.get(j)).getRecievedate() %> </li>

                      </ul>
                      <div class="grid-publish pt-3"> <span> <i class="sh-time float-right pl-1"></i> </span> </div>
                      <div class="text-right contacts fl clearfix float-right w-100 pt-sm-3 pt-1">
                      </div>
                      <div class="announce-title clearfix pb-sm-2 pb-0"> <a href="#" itemprop="url">
                        <div class="title pb-sm-2 pb-1" itemprop="address" itemscope itemtype="">
                          <meta content="IR" itemprop="addressCountry">
                          <meta content="تهران" itemprop="addressRegion">
                          <meta content="زعفرانیه" itemprop="addressLocality">
                          <h4><span></span> </h4>
                        </div>
                      </a> <span class="announce-desc hidden-xs-down"> وضعیت بسته : دریافت شده </span> </div>
                    </div>
                    <% } else {%>
                    <div class="w-100 info-info ">
                      <ul class="clearfix">
                        <li>
                          تاریخ ثبت بارکد : <%=((ParcelEntity)list.get(j)).getRecorddate() %> </li>

                      </ul>
                      <div class="grid-publish pt-3"> <span> <i class="sh-time float-right pl-1"></i> </span> </div>
                      <div class="text-right contacts fl clearfix float-right w-100 pt-sm-3 pt-1">
                      </div>
                      <div class="announce-title clearfix pb-sm-2 pb-0"> <a href="#" itemprop="url">
                        <div class="title pb-sm-2 pb-1" itemprop="address" itemscope itemtype="">
                          <meta content="IR" itemprop="addressCountry">
                          <meta content="تهران" itemprop="addressRegion">
                          <meta content="زعفرانیه" itemprop="addressLocality">
                          <h4><span></span> </h4>
                        </div>
                      </a> <span class="announce-desc hidden-xs-down"> وضعیت بسته : در انتظار دریافت </span> </div>
                    </div>
                    <% } %>
                  </div>

                </div>
              </div>
              <% } %>
              <!------------------------------------------------------------>

              <!------------------------------------------------------------>
              <div class="w-100">
                <div class="col-12">
                  <div class="pages">
                    <%--<ul class="pagination">--%>
                      <%--<li class="page-text pull-right"> <a href="#" aria-label="Previous" class="disabled"> <span aria-hidden="true">صفحه قبل</span> </a> </li>--%>
                      <%--<li class="active pull-right"> <a href="#"> 1 </a> </li>--%>
                      <%--<li class=" pull-right"> <a href="#"> 2 </a> </li>--%>
                      <%--<li class=" pull-right"> <a href="#"> 3 </a> </li>--%>
                      <%--<li class=" hidden-sm-down pull-right"> <a href="#"> 4 </a> </li>--%>
                      <%--<li class=" hidden-sm-down pull-right"> <a href="#"> 5 </a> </li>--%>
                      <%--<li class="page-text pull-right"> <a href="#" aria-label="Next" class=""> <span aria-hidden="true">صفحه بعد</span> </a> </li>--%>
                    <%--</ul>--%>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-------------------------------sidebar------------------------------------------------------>
</div>
    
    <!----------------------------------------------------------------------------> 
 
  <!--Register--> 
</div>
<!--*************************************************Begin foote***************************************************-->
<footer class="row" id="mainfooter">
<div class="w90 rtl overHide">
  <div class="footer-content">
    <div class="footer-holder">
      <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-6 col-xs-6 pt-3 pull-right">
          <ul class="clearfix footer-nav py-3 pull-right">
            <li class="footer-list"> <a href="about.html"> درباره ما </a> </li>
            <li class="footer-list"> <a href="contact.html"> تماس با ما </a> </li>
            <li class="footer-list"> <a href="#"> سوالات متداول </a> </li>
            <li class="footer-list"> <a href="ghavanin.html"> ضوابط و قوانین </a> </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- begin:copyleft -->
    <div class="row">
      <div class="col-md-12 copyleft">
        
        <a href="#top" class="btn btn-primary scroltop"><i class="fa fa-angle-up"></i></a>
        <ul class="list-inline social-links">
          <li><a href="#" class="icon-twitter" rel="tooltip" title="Twitter" data-placement="bottom" data-original-title="Twitter"><i class="fa fa-twitter"></i></a></li>
          <li><a href="#" class="icon-facebook" rel="tooltip" title="Facebook" data-placement="bottom" data-original-title="Facebook"><i class="fa fa-facebook"></i></a></li>
          <li><a href="#" class="icon-gplus" rel="tooltip" title="Gplus" data-placement="bottom" data-original-title="Gplus"><i class="fa fa-google-plus"></i></a></li>
          <li><a href="#" class="icon-linkedin" rel="tooltip" title="linkedin" data-placement="bottom" data-original-title="linkedin"><i class="fa fa-linkedin"></i></a></li>
          <li><a href="#" class="icon-instagram" rel="tooltip" title="instagram" data-placement="bottom" data-original-title="instagram"><i class="fa fa-instagram"></i></a></li>
        </ul>
      </div>
    </div>
    <!-- end:copyleft --> 
  </div>
</div>
  </footer>
  <!----------------------------------------ENDFOOTER----------------------------------------------> 
</div>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/select2.min.js"></script>
<script>
$(document).ready(function() {
	$(".multiselect").select2({
    tags: true,
    tokenSeparators: [',', ' '],
    allowClear: true
})
});
</script>
</body>
</html>
