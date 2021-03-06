<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Registration Form">
	<meta name="author" content="CengizhanOzcan">
	
	<title>Registration Form</title>

	<!-- Bootstrap Core CSS -->
	<link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- MetisMenu CSS -->
	<link href="/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="/static/dist/css/sb-admin-2.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	<link href="/static/vendor/font-awesome/css/font-awesome.min.css"
		rel="stylesheet" type="text/css">
</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/home/">Uyelik Sistemi</a>
		</div>
		
		<ul class="nav navbar-top-links navbar-right">
			<c:if test="${nameSurname!='' }">
				<c:out value="${nameSurname}"/> <c:out value="${role}"></c:out>
			</c:if>
             <li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                     <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                 </a>
                 <ul class="dropdown-menu dropdown-user">
                 	<c:if test="${nameSurname=='' }">
	                 	<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-sign-in fa-fw"></i>Login</a></li>
                     </c:if>
                     <c:if test="${nameSurname!='' }">
	                 	<form name="submitProfile" action="/home/redirectUserEdit" method="POST">
							<li><a href="javascript:document.submitProfile.submit()"><i class="fa fa-user fa-fw"></i>Profil</a>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</li>	                 	
	                 	</form>

						<form name="submitLogout" action="${request.contextPath}/logout" method="POST">
		                    <li><a href="javascript:document.submitLogout.submit()"><i class="fa fa-sign-out fa-fw"></i>Logout</a>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                    </li>
				         </form>
					</c:if>
                 </ul>
             </li>
         </ul>
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li>
						<a href="${pageContext.request.contextPath}/home/"><i class="fa fa-dashboard fa-fw"></i>
							Anasayfa</a>
					</li>
					<c:if test="${role=='ADMIN'}">
						<li>
							<a href="${pageContext.request.contextPath}/user/"><i class="fa fa-users fa-fw"></i>
								Kullanici Listesi</a>
						</li>
					</c:if>
					<c:if test="${role!=''}">
					<li>
						<a href="${pageContext.request.contextPath}/user/create/"><i class="fa fa-user-plus fa-fw"></i>
							Kullanici Ekle</a>
					</li>
					</c:if>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
						<jsp:invoke fragment="header" />
					</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div id="body">
							<jsp:doBody />
						</div>
						<div id="pagefooter">
							<jsp:invoke fragment="footer" />
						</div>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

  </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/static/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/static/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/static/dist/js/sb-admin-2.js"></script>	
</body>
</html>