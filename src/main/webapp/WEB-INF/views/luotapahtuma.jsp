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
	 <body>
 	
      <ul id="dropdown1" class="dropdown-content">
      <li><a href="?lang=fi">FI</a></li>
      <li><a href="?lang=swe">SWE</a></li>
      <li><a href="?lang=en">EN</a></li>
      </ul>

  <nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo center"><img class="responsive-img" src="<c:url value="/resources/images/logo2_s.png" />" alt="Do" id="navlogo" /></a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul class="left hide-on-med-and-down">
        <li><a href="/.."><spring:message code="etusivu"/></a></li>
        <li><a href="luotapahtuma"><spring:message code="luotapahtuma"/></a></li>
        <li><a href="#"><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="#"><spring:message code="yhteystiedot"/></a></li>
      </ul>
       <!-- Dropdown Trigger -->
      
	  <ul class="right">
	  <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons">language</i></a></li>
	  </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="#"><span class="material-icons" id="navicon">home</span><spring:message code="etusivu"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">event_note</span><spring:message code="luotapahtuma"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">search</span><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="#"><span class="material-icons" id="navicon">phone</span><spring:message code="yhteystiedot"/></a></li>
      </ul>
    </div>
  </nav>
  
  <div class="row card-panel" id="ruutu2">
  <h2>Luo tapahtuma</h2>
	
	
	
	<form:form modelAttribute="kayttaja" action="../osallistu/${tapahtuma.id}" method="post">

	  	<fieldset>
	<blockquote class="error">
	<p><i class="tiny material-icons">report_problem</i>Tämä on VIRHETEKSTI!!!!!!!!!!</p>
		<spring:hasBindErrors name="kayttaja">
	  	
		<p class="Virheotsikko"><spring:message code="kayttaja.errors" />:</p>
		<div class="Virheblokki"><form:errors path="*"/></div>
		</spring:hasBindErrors>
	</blockquote><br>

        <div class="input-field col sm2">
          <i class="material-icons prefix">account_circle</i>
          <form:input path="etunimi" id="icon_prefix" type="text" class="validate"/><form:errors path="etunimi"/>
          <form:label path="etunimi" for="icon_prefix"><spring:message code="kayttaja.etunimi"/></form:label>
        </div>
        
        <div class="input-field col sm2">
          <i class="material-icons prefix">account_circle</i>
          <form:input path="sukunimi" id="icon_prefix" type="text" class="validate"/><form:errors path="sukunimi"/>
          <form:label path="sukunimi" for="icon_prefix"><spring:message code="kayttaja.sukunimi"/></form:label>
        </div>
        
	   <div class="input-field col md3">
	      <i class="material-icons prefix">email</i>
          <form:input path="sposti" id="email" type="email" class="validate"/><form:errors path="sposti"/>
          <form:label path="sposti" for="email"><spring:message code="kayttaja.email"/></form:label>
        </div>
        
		<div class="input-field col md3">
	      <i class="material-icons prefix">phone</i>
          <form:input path="puh" id="phone" type="tel" class="validate"/><form:errors path="puh"/>
          <form:label path="puh" for="Puhelin"><spring:message code="kayttaja.puh"/></form:label>
        </div>
        
		<div class="input-field col md3">
		<button class="btn waves-effect indigo darken-4 waves-light" type="submit" name="action"><spring:message code="osallistu"/>
		<i class="material-icons right">send</i>
		</button>
		</div>
		
		</fieldset>
		</form:form>
		
		
		
		
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
  </script>


</body>
</html>