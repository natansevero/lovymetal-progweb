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
        <title>Resultado da Pesquisa | Lovy Metal</title>

        <!-- Stylesheets
================================================= -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/ionicons.min.css" />
        <link rel="stylesheet" href="css/font-awesome.min.css" />

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
                            <li class="dropdown"><a href="home.jsp">P�gina Inicial</a></li>
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

        <div id="page-contents">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Friend List
                        ================================================= -->
                        <div class="friend-list">
                            <div class="row">
                                <c:forEach var="usuario" items="${requestScope.resultadoPesquisa}">
                                    <div class="col-md-6 col-sm-6">
                                        <div class="friend-card">
                                            <div class="cover-user-pesquisa"></div>
                                            <div class="card-info">
                                                <img src="${usuario.foto_perfil}" alt="user" class="profile-photo-lg" />
                                                <div class="friend-info">
                                                    <!-- <a href="#" class="pull-right text-green">Adicionar+</a> -->
                                                    <h5><a href="controller?command=AcessarPerfil&id=${usuario.id}" class="profile-link">${usuario.apelido}</a></h5>
                                                    <p>${usuario.cidade}</p>
                                                    <p>${usuario.status}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                               


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
                <p>�Lovy Metal 2017. Todos os direitos reservados</p>
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
