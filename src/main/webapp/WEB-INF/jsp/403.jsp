<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header">
		<h1>
			<spring:message code="403.header" />		
		</h1>
		<br/>
			<spring:message code="403.body" />
	</jsp:attribute>
	<jsp:body>
	
	</jsp:body>
</t:template>
