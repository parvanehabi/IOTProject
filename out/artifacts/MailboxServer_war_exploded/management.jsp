<%@ page import="services.DatabaseService" %>
<%@ page import="beans.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.DeviceEntity" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<title>صندوق پستی هوشمند/مدیریت</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="slick-1.8.0/slick/slick.css" />
<link rel="stylesheet" href="slick-1.8.0/slick/slick-theme.css" />
<!--<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet" />-->
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

        <div id="top-menu">
          <ul class="nav navbar-nav">
          
            <li><a href="/Logout">خروج</a></li>
          </ul>
        </div>
      </div>
      <!-- /.navbar-collapse --> 
    </div>
    <!-- /.container-fluid --> 
  </nav>
</header>
<!--**************************************************************************************************************************************-->
    <div id="main">
        <div id="box" class="w90 col-xs-12 col-lg-6">
            <ul id="ul1" type="none" class="rtl">
                <li  class="rtl pad30"><input type="text" placeholder="جستجو"></li>
                <li class="rtl">
                    <div class="white"  class="text-center">
                        <table  border="1">
                            <thead>
                            <tr>
                                <td> ردیف </td>
                                <td> نام کاربر </td>
                                <td>شماره صندوق </td>
                                <td> ایمیل </td>
                            </tr>
                            </thead>
                            <tbody>
                            <% List<Object> users = DatabaseService.selectAllWithJoin("UsersEntity",null,null,null,"deviceByIddevice");
                                if(users!=null){
                                for( int j=0 ;j<users.size(); j++) { %>
                            <tr>
                                <td><%=j+1 %></td>
                                <td><%= ((UsersEntity)users.get(j)).getUsername() %></td>
                                <td><%= ((UsersEntity)users.get(j)).getDeviceByIddevice().getIddevice() %></td>
                                <td><%= ((UsersEntity)users.get(j)).getEmail() %></td>
                            </tr>
                            <% } }%>
                            </tbody>
                        </table>
                    </div>
                </li>

            </ul>
        </div>
    <div class="text-center col-xs-12 col-lg-6">
        <ul id="ul2" type="none" class="rtl">
            <li class="rtl">
                <input type="button" id="insert2" onClick="show2()" value="ثبت جعبه جدید">
            </li>
            <li class="rtl">
                <br>
                <div id="insert-this-2">

                </div>
            </li>
        </ul>
        <ul id="ul3" type="none" class="rtl">
            <li class="rtl">
                <input type="button" id="insert" onClick="show()" value="ثبت بارکد جدید">
            </li>
            <li class="rtl">
                <br>
                <div id="insert-this">

                </div>
            </li>
        </ul>
    </div>


<%--<div class="text-center col-xs-12 col-lg-6">
<ul id="ul3" type="none" class="rtl">
<li class="rtl">
<input type="button" id="insert" onClick="show()" value="ثبت بارکد جدید">
</li>
<li class="rtl">
    <br>
<div id="insert-this">

</div>
</li>
</ul>
</div>--%>
</div>
</div><!--main-->
	
       
<script>
function show(){
	 var out=document.getElementById('insert-this');
	out.innerHTML='<form action="/RecordBarcode" method="post"><ul type="none"><li><input type="text" name="box-number" placeholder="box-number"></li><li><input type="text" name="barcode" placeholder="barcode"></li><br><li><input type="submit" value="ذخیره"></li></ul></form>';
	}
</script>

<script>
    function show2(){
        var out=document.getElementById('insert-this-2');
        out.innerHTML='<form action="/RecordDevice" method="post"><ul type="none"><li><input type="text" name="devicename" placeholder="device-name"></li><li><input type="text" name="idgateway" placeholder="gateway-id"></li><li><input type="text" name="iddevice" placeholder="device-id"></li><br><li><input type="submit" value="ذخیره"></li></ul></form>';
    }
</script>



<!--*************************************************Begin foote***************************************************-->
<script type="text/javascript" src="js/jquery-1.11.3.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
<script type="text/javascript" src="js/script.js"></script> 
</div>
</body>
</html>
