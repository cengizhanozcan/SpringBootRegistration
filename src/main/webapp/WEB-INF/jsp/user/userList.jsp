<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header">
		Kullanici Listesi
	</jsp:attribute>
	<jsp:body>
		<form:form method="post">
			<div class="panel panel-default">
			  	<div class="panel-heading"></div>
			  	<div class="panel-body">
					<table width="100%" class="table table-striped table-bordered table-hover" id="userTable">
						<thead>
							<tr>
								<th><spring:message code="user.username" /></th>
								<th><spring:message code="user.name" /></th>
								<th><spring:message code="user.surname" /></th>
								<th><spring:message code="user.email" /></th>
								<th><spring:message code="user.phoneNumber" /></th>
								<th><spring:message code="user.gender" /></th>
								<th><spring:message code="user.role" /></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${!empty users}">
								<c:forEach items="${users}" var="user">
									<tr>
										<td>${user.username}</td>
										<td>${user.name}</td>
										<td>${user.surname}</td>
										<td>${user.email}</td>
										<td>${user.phoneNumber}</td>
										<td><spring:message code="${user.gender.lbl}" /></td>
										<td>${user.role}</td>
										<td><a href="<c:url value='/user/create/${user.id}/EDIT' />" />
												<spring:message code="button.edit"/>
											<a href="<c:url value='/user/create/${user.id}/VIEW' />" />
												<spring:message code="button.view"/>
											<a href="<c:url value='/user/delete/${user.id}' />" />
												<spring:message code="button.delete"/>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>					
					</table>			  			
			  	</div>
			</div>
			 
		</form:form>
	</jsp:body>
	
</t:template>