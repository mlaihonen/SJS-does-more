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
      <link type="text/css" rel="stylesheet" href="<c:url value="/resouces/styles/css/materialize.css" />"  media="screen,projection"/>
	  <!--Import MEIDÄN OMA CSS -->
	  <link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/css/general.css" />"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	  
		  
    </head>

    <body>
 	<div id="taustakuva">
      <ul id="dropdown1" class="dropdown-content">
      <li><a href="#">FI</li>
      <li><a href="#">EN</li>
      </ul>

  <nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo center"><img class="responsive-img" src="<c:url value="/resources/images/logo2_s.png" />" alt="Do" id="navlogo" /></a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="left hide-on-med-and-down">
        <li><a href="#"><spring:message code="etusivu"/></a></li>
        <li><a href="#"><spring:message code="luotapahtuma"/></a></li>
        <li><a href="#"><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="#"><spring:message code="yhteystiedot"/></a></li>
      </ul>
       <!-- Dropdown Trigger -->
      
	  <ul class="right">
	  <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons">language</i><i class="material-icons right">arrow_drop_down</i></a></li>
	  </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="#"><span class="material-icons" id="navicon">home</span><spring:message code="etusivu"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">event_note</span><spring:message code="luotapahtuma"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">search</span><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">phone</span><spring:message code="yhteystiedot"/></a></li>
      </ul>
    </div>
  </nav>
          
	<div>
	<div class="row card-panel" id="ruutu2">
	
	<div  class="container center-align" id="ruutu2body">
	<h2>Nokkahuilutunti</h2>
	</div>
	<div class="grey lighten-3 center-align" >
	<h3><span class="material-icons">query_builder</span><spring:message code="tapahtuma.aika"/><fmt:formatDate pattern="hh:mm" value="${tapahtuma.aika}"/> 
      <span class="material-icons">today</span><spring:message code="tapahtuma.pvm"/><fmt:formatDate pattern="dd.MM.yyyy" value="${tapahtuma.pvm}"/>
      <span class="material-icons">place</span><spring:message code="tapahtuma.paikka"/> ${tapahtuma.paikka}</h3>
	</div>
	<div id="ruutu2body">
	<p>
	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis aliquam erat in ante malesuada, facilisis semper nulla semper. Phasellus sapien neque, faucibus in malesuada quis, lacinia et libero. Sed sed turpis tellus. Etiam ac aliquam tortor, eleifend rhoncus metus. Ut turpis massa, sollicitudin sit amet molestie a, posuere sit amet nisl. Mauris tincidunt cursus posuere. Nam commodo libero quis lacus sodales, nec feugiat ante posuere. Donec pulvinar auctor commodo. Donec egestas diam ut mi adipiscing, quis lacinia mauris condimentum. Quisque quis odio venenatis, venenatis nisi a, vehicula ipsum. Etiam at nisl eu felis vulputate porta.
	</p>
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