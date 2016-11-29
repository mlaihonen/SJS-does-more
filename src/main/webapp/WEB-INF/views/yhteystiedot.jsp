<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/materialize.min.css" />"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/materialize.css" />"  media="screen,projection"/>
	  <!--Import MEIDÄN OMA CSS -->
	  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/general.css" />"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"> <!-- saa IE sivut rokkaamaan -->
	  
		  
    </head>

<body>
<div class="etusivu_taustakuva filtteri">
      <ul id="dropdown1" class="dropdown-content">
      <li><a href="?lang=fi">FI</a></li>
      <li><a href="?lang=swe">SWE</a></li>
      <li><a href="?lang=en">EN</a></li>
      </ul>

  <nav>
    <div class="nav-wrapper">
      <a href="./" class="brand-logo center"><img class="responsive-img" src="<c:url value="/resources/images/logo2_s.png" />" alt="Do" id="navlogo" /></a>
      <a href="./" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="left hide-on-med-and-down">
        <li><a href="./"><spring:message code="etusivu"/></a></li>
        <li><a href="luotapahtuma"><spring:message code="luotapahtuma"/></a></li>
        <li><a href="tapahtumat"><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="yhteystiedot"><spring:message code="yhteystiedot"/></a></li>
      </ul>
       <!-- Dropdown Trigger -->
      
	  <ul class="right">
	  <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons">language</i></a></li>
	  </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="./"><span class="material-icons" id="navicon">home</span><spring:message code="etusivu"/></a></li>
        <li><a href="luotapahtuma"><span class="material-icons" id="navicon">event_note</span><spring:message code="luotapahtuma"/></a></li>
        <li><a href="tapahtumat"><span class="material-icons" id="navicon">search</span><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="yhteystiedot"><span class="material-icons" id="navicon">phone</span><spring:message code="yhteystiedot"/></a></li>
      </ul>
    </div>
  </nav>

<div class="row" >
	
<h2 class="center">Yhteystiedot</h2>

<div class="row card-panel" id="ruutu">
<div class="container center">
<div class="col l12">
<h3>Tietoa</h3>
<p class="flow-text">
Do more. on Haaga-Helian IT-Tradenomiopiskelijoiden luoma harrastuksien hakupalvelu. Do more. on luotu osana ohjelmistokehitysprojektia. Palvelun on luonut ohjelmistokehitystiimi Silver Java Slayers.
</p>

   <h4>Yhteystiedot</h4>
</div>

   <div class="row">

            <div class="col m4">
              <div class="center">
                <i class="material-icons">call</i>
                <p class="promo-caption">Puhelin</p>
                <p class="light center">040123123</p>
              </div>
            </div>
            <div class="col m4">
              <div class="center">
                <i class="material-icons">location_on</i>
                <p class="promo-caption">Osoite</p>
                <p class="light center">Ratapihantie 13</p>
              </div>
            </div>
            <div class="col m4">
              <div class="center">
                <i class="material-icons">email</i>
                <p class="promo-caption">Sähköposti</p>
                <p class="light center">silverjavaslayers@gmail.com</p>
              </div>
            </div>
          </div>

<div class="col l12">

<!-- 
<div class="col l12">
<div class="card-panel col l12">

<div class="col l6">
<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&key= AIzaSyBI7KzGmPW2guNxLKkK_6YXG3f5Adgo2gg '></script><div style='overflow:hidden;height:350px;width:350px;'><div id='gmap_canvas' style='height:350px;width:350px;'></div><style>#gmap_canvas img{max-width:none!important;background:none!important}</style></div> <a href='http://www.maps-generator.com/it'>Su www.maps-generator.com</a> <script type='text/javascript' src='https://embedmaps.com/google-maps-authorization/script.js?id=b03dfdb225c5cd5c83376a6466e2a2c3b4e75536'></script><script type='text/javascript'>function init_map(){var myOptions = {zoom:17,center:new google.maps.LatLng(60.20137250000001,24.93404069999997),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(60.20137250000001,24.93404069999997)});infowindow = new google.maps.InfoWindow({content:'<strong>Silver Java Slayers</strong><br>ratapihantie 13<br> Pasila<br>'});google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
</div>
<div class="col l6">
<ul>
  <li>Osoite:</li>
  <li>Puhelin:</li>
  <li>Sähköposti:</li>
</ul>
</div>

</div>
</div>
rikkoo jostain syystä sivun responsiivisuuden. voi liittyä siihen että liikaa col l12 sivulla    -->
<h4>Silver Java Slayers</h4>

<img class="responsive-img" src="<c:url value="/resources/images/logo_varjolla.png" />" alt="SJS" style="max-height:400px" />
<blockquote class="grey lighten-4">
<i>Silver Java Slayers - Vuosien kokemuksella</i>
</blockquote>

<div class="col l12">

<div class="col l4">
  <div class="card-panel grey lighten-5" id="jasen">
          <div class="row">
            <div class="col s12">
              <img src="<c:url value="/resources/images/nerd.png" />" alt="nörö" class="circle responsive-img">
            </div>
            <div class="col s12 center">
              <span class="flow-text">
                Mindi Laihonen
              </span>
            </div>
          </div>
        </div>
</div>


<div class="col l4">
  <div class="card-panel grey lighten-5" id="jasen">
          <div class="row">
            <div class="col s12">
              <img src="<c:url value="/resources/images/nerd.png" />" alt="nörö" class="circle responsive-img">
            </div>
            <div class="col s12 center">
              <span class="flow-text">
                Mari Perasto
              </span>
            </div>
          </div>
        </div>
</div>


<div class="col l4">
  <div class="card-panel grey lighten-5" id="jasen">
          <div class="row">
            <div class="col s12">
              <img src="<c:url value="/resources/images/nerd.png" />" alt="nörö" class="circle responsive-img">
            </div>
            <div class="col s12 center">
              <span class="flow-text">
                Suvi Laukkanen
              </span>
            </div>
          </div>
        </div>
</div>

<div class="divider"></div>

<div class="col l4">
  <div class="card-panel grey lighten-5" id="jasen">
          <div class="row">
            <div class="col s12">
              <img src="<c:url value="/resources/images/nerd.png" />" alt="nörö" class="circle responsive-img">
            </div>
            <div class="col s12 center">
              <span class="flow-text">
                Heidi Baruti
              </span>
            </div>
          </div>
        </div>
</div>



<div class="col l4">
  <div class="card-panel grey lighten-5" id="jasen">
          <div class="row">
            <div class="col s12">
              <img src="<c:url value="/resources/images/nerd.png" />" alt="nörö" class="circle responsive-img">
            </div>
            <div class="col s12 center">
              <span class="flow-text">
                Mikko Lerto
              </span>
            </div>
          </div>
        </div>
</div>
</div>

</div>
</div>
</div>

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
	
	
    </body>
  </html>