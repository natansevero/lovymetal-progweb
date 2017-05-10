<%@page contentType="text/html" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="This is social network html5 template available in themeforest......" />
		<meta name="keywords" content="Social Network, Social Media, Make Friends, Newsfeed, Profile Page" />
		<meta name="robots" content="index, follow" />
		<title>Editar Conta | Lovy Metal</title>

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
            <a class="navbar-brand" href="index-register.html"><img src="images/logo1.png" alt="logo" /></a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right main-menu">
              <li class="dropdown"><a href="contact.html">Página Inicial</a></li>
            </ul>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
      </nav>
    </header>
    <!--Header End-->

    <div class="google-maps">
      <div class="map contact-map"></div>
    </div>
    <div id="page-contents">
    	<div class="container">
            <div class="row">
    		<div class="col-md-10 col-md-offset-1">
            <div class="contact-us">
            	<div class="row">
            	
                  <h4 class="grey">Edite sua conta!</h4>
                  <form class="contact-form" action="controller?command=EditarUsuario" method="post" enctype="multipart/form-data">
                    <div class="col-md-6 col-sm-6">   
                      
                        <div class="form-group">
                            <input id="nome_completo" type="text" name="nome_completo" class="form-control" placeholder="Nome Completo" value="${sessionScope.fullUsuario.nome_completo}" required="required" data-error="Name is required.">
                        </div>

                        <div class="form-group">
                          <input id="apelido" type="text" name="apelido" class="form-control" placeholder="Apelido" required="required" value="${sessionScope.fullUsuario.apelido}" data-error="Name is required.">
                        </div>

                        <div class="form-group">
                          <input id="email" type="email" name="email" class="form-control" placeholder="E-mail" required="required" value="${sessionScope.fullUsuario.email}" data-error="Name is required.">
                        </div>

                        <div class="form-group">
                          <input id="senha" type="password" name="senha" class="form-control" placeholder="Senha" required="required" value="${sessionScope.fullUsuario.senha}" data-error="Name is required.">
                        </div>

                        <div class="form-group">
                            <label class="radio-inline">
                              <input type="radio" name="sexo" value="m" checked>Masculino
                            </label>
                            <label class="radio-inline">
                              <input type="radio" name="sexo" value="f">Feminino
                            </label>
                              <label class="radio-inline">
                              <input type="radio" name="sexo" value="o">Outro
                            </label>
                        </div>

                        <div class="form-group">
                          <label for="data_nasc">Data de Nascimento: </label>
                            <input id="data_nasc" class="form-control input-group-lg" type="date" name="data_nasc" required="required" value="${sessionScope.fullUsuario.data_nasc}" data-error="Name is required."/>
                        </div>

                        <div class="form-group">
                          <input id="cidade" type="text" name="cidade" class="form-control" placeholder="Cidade" required="required" value="${sessionScope.fullUsuario.cidade}" data-error="Name is required.">
                        </div>
                       
                    
                     
                        <div class="form-group">
                          <input id="profissao" type="text" name="profissao" class="form-control" placeholder="Profissão" required="required" value="${sessionScope.fullUsuario.profissao}" data-error="Name is required.">
                        </div>
                        
                    </div>
                      
                    <div class="col-md-6 col-sm-6">
                        
                        <div class="form-group">
                            <textarea name="descricao" class="form-control" rows="5" placeholder="Descrição">${sessionScope.fullUsuario.descricao}</textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="status" class="">Status: </label>
                            <select name="status" class="form-control">
                                <option value="Solteiro(a)">Solteiro(a)</option>
                                <option value="Divorciado(a)">Divorciado(a)</option>
                                <option value="Viúvo(a)">Viúvo(a)</option>
                            </select>
                        </div>


                        <div class="form-group">
                            <input id="altura" class="form-control input-group-lg" type="number" name="altura" placeholder="Altura" required="required" value="${sessionScope.fullUsuario.altura}" data-error="Name is required."/>
                        </div>


                        <div class="form-group">
                            <input id="peso" class="form-control input-group-lg" type="number" name="peso" placeholder="Peso" required="required" value="${sessionScope.fullUsuario.peso}" data-error="Name is required."/>
                        </div>

                        <div class="form-group">
                           <input id="cor_cabelo" class="form-control input-group-lg" type="text" name="cor_cabelo" placeholder="Cor do Cabelo" required="required" value="${sessionScope.fullUsuario.cor_cabelo}" data-error="Name is required."/> 
                        </div>  

                        <div class="form-group">
                            <label for="foto_perfil">Foto de Perfil: </label>
                            <input id="foto_perfil" class="form-control input-group-lg" type="file" name="foto_perfil"/>
                        </div> 
      
                      </div>
                      
                     
                      <input type="submit" class="btn-primary col-md-12 col-sm-12" value="Salvar Alterações" />
                  </form>
                
<!--            		<div class="col-md-4 col-sm-5">
                  <h4 class="grey">Reach Us</h4>
                  <div class="reach"><span class="phone-icon"><i class="icon ion-android-call"></i></span><p>+1 (234) 222 0754</p></div>
                  <div class="reach"><span class="phone-icon"><i class="icon ion-email"></i></span><p>info@thunder-team.com</p></div>
                  <div class="reach"><span class="phone-icon"><i class="icon ion-ios-location"></i></span><p>228 Park Ave S NY, USA</p></div>
                  <ul class="list-inline social-icons">
                    <li><a href="#"><i class="icon ion-social-facebook"></i></a></li>
                    <li><a href="#"><i class="icon ion-social-twitter"></i></a></li>
                    <li><a href="#"><i class="icon ion-social-googleplus"></i></a></li>
                    <li><a href="#"><i class="icon ion-social-pinterest"></i></a></li>
                    <li><a href="#"><i class="icon ion-social-linkedin"></i></a></li>
                  </ul>
                </div>-->
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
        <p>Lovy Metal ï¿½ 2017. Todos os direitos reservados</p>
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
    <script src="js/script.js"></script>
  </body>
</html>
