<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/materialize.min.css" />"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="<c:url value="/resouces/styles/css/materialize.css" />"  media="screen,projection"/>
	  <!--Import MEIDÄN OMA CSS -->
	  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/general.css" />"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	  
	
	  
    </head>

    <body>


  <nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo center"><img class="responsive-img" src="/resources/images/logo2_s.png" alt="logo" id="navlogo" /></a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="left hide-on-med-and-down">
        <li><a href="#">Etusivu</a></li>
        <li><a href="#">Luo tapahtuma</a></li>
        <li><a href="#">Etsi tapahtuma</a></li>
        <li><a href="#">Yhteystiedot</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="#"><span class="material-icons" id="navicon">home</span> Etusivu</a></li>
        <li><a href="#"><span class="material-icons" id="navicon">event_note</span> Luo tapahtuma</a></li>
        <li><a href="#"><span class="material-icons" id="navicon">search</span> Etsi tapahtuma</a></li>
        <li><a href="#"><span class="material-icons" id="navicon">phone</span> Yhteystiedot</a></li>
      </ul>
    </div>
  </nav>
          
	
	<div class="row" id="ruutu">
	
	<div  class="container center-align">
	
	
	
	<h2>Rokkaavia harrastuksia <i class="material-icons">keyboard_arrow_down</i></h2>
	</div>
	
	 <ul class="collapsible" data-collapsible="accordion">
	 <c:forEach items="${tapahtumat}" var="tapahtuma">
    <li class="collection-item avatar">
      <img src="/resources/images/yuna.jpg" alt="" class="circle">
	  <div class="collapsible-header hoverable">
      <span class="title">${tapahtuma.tNimi}</span>
      <p><span class="material-icons">query_builder</span>Aika: ${tapahtuma.tAika}<span class="material-icons">place</span>Paikka: ${tapahtuma.tPaikka}</p>
	  </div>
	  <div class="collapsible-body">
	  
	  		   <div class="card small right">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="/resources/images/profile.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">Ei-Ella Esiintyjä<i class="material-icons right">more_vert</i></span>
      <p><a href="#">Profiiliin</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Tietoa minusta<i class="material-icons right">close</i></span>
      <p>Hei! Olen Ella ja opiskelen Teatterikorkeakoulussa esiintymistä. 
      Minulla on 15 vuoden kokemus näyttelijänä ja ensimmäinen esitykseni oli 6-vuotiaana.</p>
    </div>
  </div>
	  
	  <p class="title">Lisätietoa</p>
  
      <div class="row">
	  
	  	<div class="col l3">
	  <p>${tapahtuma.tKuvaus } </p>
	</div>
	

	  
	  <div class="col l12">
        <div class="input-field col md3">
          <i class="material-icons prefix">account_circle</i>
          <input id="icon_prefix" type="text" class="validate">
          <label for="icon_prefix">Nimi</label>
        </div>
	   <div class="input-field col md3">
	      <i class="material-icons prefix">email</i>
          <input id="email" type="email" class="validate">
          <label for="email">Email</label>
        </div>
		<div class="input-field col md3">
	      <i class="material-icons prefix">phone</i>
          <input id="phone" type="tel" class="validate">
          <label for="Puhelin">Puhelin</label>
        </div>

			   <button class="btn waves-effect indigo darken-4 waves-light" type="submit" name="action">Osallistu
		<i class="material-icons right">send</i>
		</button>
	  </div>
	  </div>
	  
	  <div class="divider"></div>
	  </div>
    </li>
    
    </c:forEach>
    
    
  </ul>
	
	
	
	
	
	
	</div>
	  </div>
      <!--Import jQuery before materialize.js AINA LOPPUUN!!!!!!!!!!!-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js" />"></script>
	  	<script type="text/javascript" src="<c:url value="/resources/js/materialize.js" />"></script>
		<script>
		
  $('.button-collapse').sideNav({
  // Initialize collapse button
      closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    }
  );
    // Initialize collapsible (uncomment the line below if you use the dropdown variation)
  //$('.collapsible').collapsible();
	</script>
	
	<script>
function postContactToGoogle() {
var tapahtuma=$('#tapahtuma').val();
var nimi=$('#nimi').val();
var email=$('#email').val();
var puhelin=$('#puhelin').val();

$.ajax({
url:"https://docs.google.com/forms/d/e/1FAIpQLSeAgHpQGSmmrLcBY5uJMVF0ybkeHfO2Yo7dD9Oyl-HrewztEw/formResponse",data:{"entry_1660283078":tapahtuma,"entry_1007105817":nimi,"entry_946893283":email,"entry_536095548":puhelin},type:"POST",dataType:"xml",statusCode: {0:function() {window.location.replace("kiitos.html");},200;function(){window.location.replace("kiitos.html");}}
});
}

	</script>
	
    </body>
  </html>