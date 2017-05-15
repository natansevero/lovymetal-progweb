<%@page contentType="text/html"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>Mensagens | Envie e Receba mensagens</title>

    <!-- Stylesheets
    ================================================= -->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/jquery.scrollbar.css" />
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
              <!-- Botão de configurações -> Edita Conta e Excluir Conta -->
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
            </div><!--profile card ends-->
            <ul class="nav-news-feed">
              <li><i class="icon ion-ios-paper"></i><div><a href="controller?command=ListarSolicitacao">Solicitações</a></div></li>
              <li><i class="icon ion-ios-people-outline"></i><div><a href="newsfeed-friends.html">Amigos</a></div></li>
              <li><i class="icon ion-chatboxes"></i><div><a href="messages.jsp">Mensagens</a></div></li>
              <li><i class="icon ion-images"></i><div><a href="newsfeed-images.html">Galeria</a></div></li>
            </ul><!--news-feed links ends-->
            
            <div id="chat-block">
            </div><!--chat block ends-->
          </div>
    	
        <div class="col-md-7">

            <!-- Chat Room
            ================================================= -->
            <div class="chat-room">
              <div  class="row">
                <div class="col-md-5">

                  <!-- Contact List in Left-->
                  <ul class="nav nav-tabs contact-list scrollbar-wrapper scrollbar-outer">
                      <li class="active">
                      <c:forEach var="usuario" items="${requestScope.ListarMensagens}">
                      <a href="#contact-1" data-toggle="tab">
                        <div class="contact">
                        	<img src="${sessionScope.usuario.foto_perfil}" alt="" class="profile-photo-sm pull-left"/>
                        	<div class="msg-preview">
                        		<h6>${sessionScope.usuario.apelido}</h6>
                        		<p class="text-muted">${sessionScope.usuario.mensagem}</p>
                        	</div>
                        </div>
                      </a>
                      </c:forEach>
                    </li>
                    
                  </ul><!--Contact List in Left End-->
                  
                </div>
                <div class="col-md-7">

                  <!--Chat Messages in Right-->
                  <div class="tab-content scrollbar-wrapper wrapper scrollbar-outer">
                      <div class="tab-pane active" id="contact-1">
                      <div class="chat-body">
                      	<ul class="chat-message">
                            <!-- Mostra mensagens de um remetente com o destinatário o próprio usuário -->
                            <c:forEach var="usuario" items="${requestScope.MensagensRemetente}">
                      		<li class="left">
                      			<img src="${sessionScope.usuario.foto_perfil}" alt="" class="profile-photo-sm pull-left" />
                      			<div class="chat-item">
                              <div class="chat-item-header">
                              	<h5>${sessionScope.usuario.apelido}</h5>
                              </div>
                              <p>${sessionScope.usuario.mensagem}</p>
                            </div>
                      		</li>
                            </c:foreach>
                        <!-- Mostra mensagens com o remetente o próprio usuário e um destinatário -->
                        <c:forEach var="usuario" items="${requestScope.MensagensRemetente}">
                        <li class="right">
                      			<img src="${sessionScope.fullUsuario.foto_perfil}" alt="" class="profile-photo-sm pull-right" />
                      			<div class="chat-item">
                              <div class="chat-item-header">
                              	<h5>${sessionScope.fullUsuario.apelido}</h5>
                              </div>
                              <p>${sessionScope.fullUsuario.mensagem}</p>
                            </div>
                        </li>
                        </c:foreach>
                      </ul>
                      </div>
                    </div>
                  </div><!--Chat Messages in Right End-->

                  <div class="send-message">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Type your message">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Send</button>
                      </span>
                    </div>
                  </div>
                </div>
                <div class="clearfix"></div>
              </div>
            </div>
          </div>

    	<!-- Newsfeed Common Side Bar Right
          ================================================= -->
    			<div class="col-md-2 static">
            <div class="suggestions" id="sticky-sidebar">
              <h4 class="grey">Recomendações</h4>
              <div class="follow-user">
                <img src="images/users/user-11.jpg" alt="" class="profile-photo-sm pull-left" />
                <div>
                  <h5><a href="timeline.html">Diana Amber</a></h5>
                  <a href="#" class="text-green">Add friend</a>
                </div>
              </div>
              <div class="follow-user">
                <img src="images/users/user-12.jpg" alt="" class="profile-photo-sm pull-left" />
                <div>
                  <h5><a href="timeline.html">Cris Haris</a></h5>
                  <a href="#" class="text-green">Add friend</a>
                </div>
              </div>
              <div class="follow-user">
                <img src="images/users/user-13.jpg" alt="" class="profile-photo-sm pull-left" />
                <div>
                  <h5><a href="timeline.html">Brian Walton</a></h5>
                  <a href="#" class="text-green">Add friend</a>
                </div>
              </div>
              <div class="follow-user">
                <img src="images/users/user-14.jpg" alt="" class="profile-photo-sm pull-left" />
                <div>
                  <h5><a href="timeline.html">Olivia Steward</a></h5>
                  <a href="#" class="text-green">Add friend</a>
                </div>
              </div>
              <div class="follow-user">
                <img src="images/users/user-15.jpg" alt="" class="profile-photo-sm pull-left" />
                <div>
                  <h5><a href="timeline.html">Sophia Page</a></h5>
                  <a href="#" class="text-green">Add friend</a>
                </div>
              </div>
            </div>
          </div>
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
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.sticky-kit.min.js"></script>
    <script src="js/jquery.scrollbar.min.js"></script>
    <script src="js/script.js"></script>

  </body>
</html>