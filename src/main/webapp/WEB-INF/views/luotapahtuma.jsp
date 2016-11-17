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
      <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"> <!-- saa IE sivut rokkaamaan -->
	  
    </head>
    
<body>
 	
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
  <div class="center-align col l10">
  
  <h2><spring:message code="tapahtuma.luo.otsikko"/></h2>
  </div>
  <div class="row card-panel" id="ruutu2"><br><br>

	   <div class="row container">
      <form:form modelAttribute="tapahtuma" action="tallennatapahtuma" method="post" >
      
      <h5 class="center-align"><spring:message code="tapahtuma.luo.legend"/></h5>
      
      <blockquote class="error">
		<spring:hasBindErrors name="tapahtuma">
		<p class="Virheotsikko"><i class="material-icons">error</i> <spring:message code="tapahtuma.errors" />:</p>
			<div class="Virheblokki"><form:errors path="*"/></div>
		</spring:hasBindErrors>
	  </blockquote><br>
	  
        <div class="row">
          <div class="input-field col s12">
            <form:input path="nimi" id="input_text" type="text" length="20"/>
            <form:label path="nimi" for="input_text"><spring:message code="tapahtuma.luo.nimi" /></form:label>
            <form:errors path="nimi"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <form:textarea path="kuvaus" id="tapahtumakuvaus" class="materialize-textarea" length="500"></form:textarea>
            <form:label path="kuvaus" for="tapahtumakuvaus"><spring:message code="tapahtuma.luo.kuvaus" /></form:label>
            <form:errors path="kuvaus"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
	          <form:input path="pvm" type="date" class="datepicker validate" id="pvm"/>
	          <form:label path="pvm" class="active" for="pvm"><spring:message code="tapahtuma.luo.pvm" /></form:label>
	          <form:errors path="pvm"/>
          </div>
          <div class="input-field col s6">
		      <form:input path="aika" id="tapahtuma-aika" type="text" value="12:00" class="validate" length="5"/>
		      <form:label path="aika" class="active" for="tapahtuma-aika" style="width:auto"><spring:message code="tapahtuma.luo.aika" /></form:label>
		      <form:errors path="aika"/>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <form:input path="paikka" id="tapahtumapaikka" type="text" length="20"/>
            <form:label path="paikka" for="tapahtumapaikka"><spring:message code="tapahtuma.luo.paikka" /></form:label>
            <form:errors path="paikka"/>
          </div>
         </div>
           <div class="row">
	          <div class="input-field col s12">
	          	<p class="range-field">
		          <form:input path="maxOsallistujaLkm" type="range" id="maxosallistujat" min="1" max="50"/>
		        <p>
		          <form:label path="maxOsallistujaLkm" class="active" for="maxosallistujat"><spring:message code="tapahtuma.luo.maxosallistujat" /></form:label>
		      
	          </div>
          </div>
          <div class="row">
          <div class="col m12">
          <ul class="collapsible" data-collapsible="expandable">
          <li>
      <div class="collapsible-header"><i class="material-icons">assignment_ind</i>Omat tietosi</div>
      <div class="collapsible-body">
      <div class="container">
      <div class="row">    
      <div class="center-align col m12">
      <img class="responsive-img" id="myImg" src="#" alt="*Kuvasi tulee tähän*"/>
      </div>
       <div class="file-field input-field col m12">
      <div class="btn">
        <span><i class="material-icons">add_a_photo</i> Lisää itsestäsi kuva</span>
        <input type="file">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>
	  </div>
	  <div class="row">
        <div class="input-field col m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="jarjestaja_etunimi" type="text" class="validate">
          <label for="jarjestaja_etunimi">Etunimi</label>
        </div>
                <div class="input-field col m6">
          <i class="material-icons prefix">account_circle</i>
          <input id="jarjestaja_sukunimi" type="text" class="validate">
          <label for="jarjestaja_sukunimi">Sukunimi</label>
        </div>
        <div class="input-field col m6">
          <i class="material-icons prefix">phone</i>
          <input id="jarjestaja_puhelin" type="tel" class="validate" pattern="\+?[0-9 () \-]+">
          <label for="jarjestaja_puhelin">Puhelin</label>
        </div>
        <div class="input-field col m6">
          <i class="material-icons prefix">email</i>
          <input id="jarjestaja_email" type="email" class="validate">
          <label for="jarjestaja_email" data-error="wrong" data-success="right">Sähköposti</label>
        </div>
          <div class="input-field col m12">
            <textarea path="kuvaus" id="jarjestaja_kuvaus" class="materialize-textarea" length="500"></textarea>
            <label for="jarjestaja_kuvaus">Kirjoita itsestäsi kuvaus</label>
          </div>
		</div>
      </div>
      </div>
      </li>
      </ul>
         
          </div>
          </div>       
		  <div class="input-field center-align">
			<button class="btn waves-effect indigo darken-4 waves-light" type="submit">Luo
				<i class="material-icons right">send</i>
			</button>
		  </div>
      </form:form> 
      
    	</div>
	
		
	</div>	
		

  <!--Import jQuery before materialize.js AINA LOPPUUN!!!!!!!!!!!-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js" />"></script>
	  	<script type="text/javascript" src="<c:url value="/resources/js/materialize.js" />"></script>
	  	<script type="text/javascript" src="<c:url value="/resources/js/imageupload.js" />"></script>

	<script>

  $('.button-collapse').sideNav({
  // Initialize collapse button
      closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    }
  );
  </script>
 <script> 
 $('.datepicker').pickadate({
	    selectMonths: true, // Creates a dropdown to control month
	    selectYears: 2, // Creates a dropdown of 15 years to control year
	    format: 'dd.mm.yyyy' });
  </script>
  <script>
  $('.collapsible').collapsible({
      accordion: false, // A setting that changes the collapsible behavior to expandable instead of the default accordion style
      onOpen: function(el) { alert('Open'); }, // Callback for Collapsible open
      onClose: function(el) { alert('Closed'); } // Callback for Collapsible close
    }
  );
  </script>


</body>
</html>