<%@page contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>Solicitações | Lovy Metal</title>

    <!-- Stylesheets
    ================================================= -->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/ionicons.min.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link href="css/emoji.css" rel="stylesheet">
    
    <!--Favicon-->
    <link rel="shortcut icon" type="image/png" href="images/fav.png"/>
	</head>
  <body>

    <!-- Header
    ================================================= -->
    <header id="header">
      <nav class="navbar navbar-default navbar-fixed-top menu">
        <div class="container">

          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <img class="navbar-brand" src="images/logo1.png" alt="logo" />
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right main-menu">
              <li class="dropdown"><a href="home.jsp">Página Inicial</a></li>  
              <!-- Botï¿½o de configuraï¿½ï¿½es -> Edita Conta e Excluir Conta -->
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Configurações <span><img src="images/down-arrow.png" alt="" /></span></a>
                  <ul class="dropdown-menu newsfeed-home">
                    <li class="dropdown"><a href="editar.jsp">Editar Conta</a></li>
                    <li class="dropdown"><a href="excluir.jsp">Excluir Conta</a></li>
                  </ul>
              </li>
              <li class="dropdown"><a href="controller?command=LogoutUsuario">Sair</a></li>   
            </ul>
              <form class="navbar-form navbar-right hidden-sm" action="controller?command=PesquisarUsuario" method="post">
                <div class="form-group">
                  <i class="search"></i>
                  <input type="text" class="form-control" name="pesquisar" placeholder="Pesquisar por amigos">
                </div>
                <input class="search-button" type="submit" value="Pesquisar" />    
            </form>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
      </nav>
    </header>
    <!--Header End-->

    <div id="page-contents">
      <div class="container">
        <div class="row">

          <!-- Newsfeed Common Side Bar Left
          ================================================= -->
          <div class="col-md-3 static">
            <div class="profile-card">
                <img src="${sessionScope.fullUsuario.foto_perfil}" alt="user" class="profile-photo" />
                <h5><a href="timeline.html" class="text-white">${sessionScope.fullUsuario.apelido}</a></h5>
            	<!--<a href="#" class="text-white"><i class="ion ion-android-person-add"></i> 1,299 followers</a>-->
            </div><!--profile card ends-->
            <ul class="nav-news-feed">
              <li><i class="icon ion-ios-paper"></i><div><a href="controller?command=ListarSolicitacao">Solicitações</a></div></li>
              <li><i class="icon ion-ios-people-outline"></i><div><a href="newsfeed-friends.html">Amigos</a></div></li>
              <li><i class="icon ion-chatboxes"></i><div><a href="messages.jsp">Mensagens</a></div></li>
              <li><i class="icon ion-images"></i><div><a href="newsfeed-images.html">Galeria</a></div></li>
            </ul><!--news-feed links ends-->
          </div>
          
          <div class="col-md-7">
            <!-- Post Create Box
            ================================================= -->
            <div class="create-post">
               <div class="row">
                   <h1 style="color: #9e0b0f">
                       Minha Galeria
                   </h1>
                   <br>
               </div>
            </div><!-- Post Create Box End-->
              
            <c:forEach var="foto" items="${requestScope.listaGaleria}">
                <div class="post-content">
                  <div class="post-container">
                    
                  </div>  

                  <!-- Image Post -->  
                  <img src="${foto}" alt="post-image" style="height: 400px" class="img-responsive post-image" />
                  <div class="line-divider"></div>
                </div>
            </c:forEach>
          
            </div>
    	</div>
    </div>

    <!-- Footer
    ================================================= -->
    <footer id="footer">
      
      <div class="copyright">
        <p>©Lovy Metal 2017. Todos os direitos reservados</p>
      </div>
    </footer>
    
    <!--preloader-->
    <div id="spinner-wrapper">
      <div class="spinner"></div>
    </div>
    
    <!-- Scripts
    ================================================= -->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.sticky-kit.min.js"></script>
    <script src="js/jquery.scrollbar.min.js"></script>
    <script src="js/script.js"></script>
  </body>
</html>
