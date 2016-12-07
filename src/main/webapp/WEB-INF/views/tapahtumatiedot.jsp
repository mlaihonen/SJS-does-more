<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

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
 	<div id="taustakuva">
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
        <li><a href="/DoMore"><spring:message code="etusivu"/></a></li>
        <li><a href="/DoMore/luotapahtuma"><spring:message code="luotapahtuma"/></a></li>
        <li><a href="/DoMore/tapahtumat"><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="DoMore/yhteystiedot"><spring:message code="yhteystiedot"/></a></li>
      </ul>
       <!-- Dropdown Trigger -->
      
	  <ul class="right">
	  <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons">language</i></a></li>
	  </ul>
      <ul class="side-nav" id="mobile-demo">
        <li><a href="/DoMore"><span class="material-icons" id="navicon">home</span><spring:message code="etusivu"/></a></li>
        <li><a href="/DoMore/luotapahtuma"><span class="material-icons" id="navicon">event_note</span><spring:message code="luotapahtuma"/></a></li>
        <li><a href="/DoMore/tapahtumat"><span class="material-icons" id="navicon">search</span><spring:message code="etsitapahtuma"/></a></li>
        <li><a href="/DoMore/yhteystiedot"><span class="material-icons" id="navicon">phone</span><spring:message code="yhteystiedot"/></a></li>
      </ul>
    </div>
  </nav>
          
	<div>
	<div class="row card-panel" id="ruutu2">
	
	<!-- osallistuminen onnistui -viesti -->
	<c:if test="${onnistui == true}">
		<div style="text-align:center">
			<h4><spring:message code="onnistui"/></h4>
		</div>
	</c:if>
	


	<div  class="container center-align" id="ruutu2body">
	<h2>${tapahtuma.nimi}</h2>

	</div>
	<div class="lapinakuvaharmaa center-align" >
	<h3><span class="material-icons isoiconi">query_builder</span><fmt:formatDate pattern="hh:mm" value="${tapahtuma.aika}"/> 
      <span class="material-icons isoiconi">today</span><fmt:formatDate pattern="dd.MM.yyyy" value="${tapahtuma.pvm}"/>
      <span class="material-icons isoiconi">place</span>${tapahtuma.paikka}</h3>
	</div>
	<div id="ruutu2body">
	
	
	<div class="col m2 card small right">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="<c:url value="/resources/images/profile.jpg" />">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-3" id="nimi"><c:out value="${tapahtuma.kayttaja.etunimi }"/> <c:out value="${tapahtuma.kayttaja.sukunimi }"/></span>    
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4"><spring:message code="tapahtuma.tietoaminusta"/><i class="material-icons right">close</i></span>
      <p><c:out value="${tapahtuma.kayttaja.kuvaus }"/></p>
    </div>
  </div>
	
	
	
	
	
	
	<div class="container">
	<h4><spring:message code="tapahtuma.lisatieto"/></h4>
	<p class="flow-text">${tapahtuma.kuvaus }</p>
	</div>
	
	<form:form modelAttribute="kayttaja" action="../tapahtumatiedot/${tapahtuma.id}" method="post" class="col l12" style="padding-bottom:2%">
		<fieldset>
		
			<blockquote class="error">
				
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
				<button class="btn waves-effect indigo darken-4 waves-light" type="submit"><spring:message code="osallistu"/>
				<i class="material-icons right">send</i>
				</button>
				</div>
			
			</fieldset>
		</form:form>
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