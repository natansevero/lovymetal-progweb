<%@page contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>Acessar Perfil | Lovy Metal</title>

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
              <li class="dropdown"><a href="controller?command=LogoutUsuario">Sair</a></li>   
            </ul>
              <form class="navbar-form navbar-right hidden-sm" action="controller?command=PesquisarUsuario" method="post">
                <div class="form-group">
                  <i class="icon ion-android-search"></i>
                  <input type="text" class="form-control" name="pesquisar" placeholder="Pesquisar por amigos">
                </div>
                <input class="search-button" type="submit" value="Pesquisar" />    
            </form>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
      </nav>
    </header>
    <!--Header End-->

    <div class="container">

      <!-- Timeline
      ================================================= -->
      <div class="timeline">
        <div class="timeline-cover">

          <!--Timeline Menu for Large Screens-->
          <div class="timeline-nav-bar hidden-sm hidden-xs">
            <div class="row">
              <div class="col-md-3">
                <div class="profile-info">
                    <img src="${requestScope.acessoPerfil.foto_perfil}" alt="" class="img-responsive profile-photo" />
                  <h3>${requestScope.acessoPerfil.nome_completo}</h3>
                  <p class="text-muted">${requestScope.acessoPerfil.apelido}</p>
                </div>
              </div>
              <div class="col-md-9">
                <ul class="list-inline profile-menu">
                  <li><a href="timeline.html" class="active">Linha do Tempo</a></li>
                  <li><a href="timeline-about.html">Amigos</a></li>
                  <li><a href="timeline-album.html">Galeria</a></li>
                  <li><a href="timeline-friends.html">Enviar Mensagem</a></li>
                </ul>
                <ul class="follow-me list-inline">
                    <c:choose>
                        <c:when test="${requestScope.statusSolicitacao eq 1}">
                            <li><span class="btn-primary">Solicitação Enviada</span></li>
                        </c:when>
                        <c:when test="${requestScope.statusSolicitacao eq 2}">
                            <li><span class="btn-primary">Amigos</span></li>
                        </c:when>
                        <c:otherwise>
                            <li><a class="btn-primary" href="controller?command=SolicitarAmizade&id_solicitante=${requestScope.acessoPerfil.id}">Enviar Solicitação</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
              </div>
            </div>
          </div><!--Timeline Menu for Large Screens End-->

          <!--Timeline Menu for Small Screens-->
          <div class="navbar-mobile hidden-lg hidden-md">
            <div class="profile-info">
              <img src="${requestScope.acessoPerfil.foto_perfil}" alt="" class="img-responsive profile-photo" />
              <h4>${requestScope.acessoPerfil.nome_completo}</h4>
              <p class="text-muted">${requestScope.acessoPerfil.apelido}</p>
            </div>
            <div class="mobile-menu">
              <ul class="list-inline">
                <li><a href="timline.html" class="active">Linha do Tempo</a></li>
                <li><a href="timeline-about.html">Amigos</a></li>
                <li><a href="timeline-album.html">Galeria</a></li>
                <li><a href="timeline-friends.html">Enviar Mensagem</a></li>
              </ul>
              <c:choose>
                        <c:when test="${requestScope.statusSolicitacao eq 1}">
                           <span class="btn-primary">Solicitação Enviada</span>
                        </c:when>
                        <c:when test="${requestScope.statusSolicitacao eq 2}">
                            <span class="btn-primary">Amigos</span>
                        </c:when>
                        <c:otherwise>
                            <a class="btn-primary" href="controller?command=SolicitarAmizade&id_solicitante=${requestScope.acessoPerfil.id}">Enviar Solicitação</a>
                        </c:otherwise>
              </c:choose>
            </div>
          </div><!--Timeline Menu for Small Screens End-->
        </div>

        <div id="page-contents">
          <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-10">

              <!-- Post Create Box
              ================================================= -->
              <div class="create-post" style="font-size: 16px">
                <div class="row">
                  <div class="col-md-offset-1 col-md-4 col-sm-offset-1 col-sm-4">
                    <b>Data de Nascimento: </b> ${requestScope.acessoPerfil.data_nasc} <br>  
                    <b>Cidade: </b> ${requestScope.acessoPerfil.cidade} <br>  
                    <b>Profissão: </b> ${requestScope.acessoPerfil.profissao} <br>
                    <b>Sexo: </b>
                    <c:choose>
                        <c:when test="${requestScope.acessoPerfil.sexo eq 'm'}">
                            Masculino
                        </c:when>
                        <c:when test="${requestScope.acessoPerfil.sexo eq 'f'}">
                            Feminino
                        </c:when>
                        <c:otherwise>Outro</c:otherwise>
                    </c:choose>   
                  </div>
                  <div class="col-md-7 col-sm-7">
                    <b>Altura: </b> ${requestScope.acessoPerfil.altura} <br>  
                    <b>Peso: </b> ${requestScope.acessoPerfil.peso} <br>  
                    <b>Cor do Cabelo: </b> ${requestScope.acessoPerfil.cor_cabelo} <br>   
                    <b>Descrição: </b> ${requestScope.acessoPerfil.descricao}
                  </div>
                </div>
              </div><!-- Post Create Box End-->




              <!-- Post Content
              ================================================= -->
              <div class="post-content">
                <!--Post Date-->
                <div class="post-date hidden-xs hidden-sm">
                  <h5>${requestScope.acessoPerfil.apelido}</h5>
                  <p class="text-grey">Data do post</p>
                </div><!--Post Date End-->

								<div class="post-container">
                  <img src="images/users/user-1.jpg" alt="user" class="profile-photo-md pull-left" />
                  <div class="post-detail">
                    <div class="user-info">
                      <h5><a href="timeline.html" class="profile-link">ZÃ© Pequeno</a></h5>
                    </div>
                    <div class="line-divider"></div>
                    <div class="post-text">
                      <p>DescriÃ§Ã£o do Post. Lorem sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <i class="em em-anguished"></i> <i class="em em-anguished"></i> <i class="em em-anguished"></i></p>
                    </div>
                  </div>
                </div>
                <img src="images/users/user-3.jpg" alt="post-image" class="img-responsive post-image" />
              </div> <!-- Fim post -->




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
