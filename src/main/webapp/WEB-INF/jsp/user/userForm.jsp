<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header">
		Kullanici Kayit		
	</jsp:attribute>
	<jsp:body>
		<c:url var="createUser" value="/user/create" />
		<form:form action="${createUser}" method="post" modelAttribute="user">
			<div class="panel panel-default">
			  	<div class="panel-heading"></div>
			  	<div class="panel-body">
					<div class="col-lg-6">
						<div class="form-group">
			                <form:label for="usernameTxt" path="username" ><spring:message code="user.username" /></form:label>
			                <form:input id="usernameTxt" path="username" class="form-control" readonly="${readonly}"/>
			            </div>
						<div class="form-group">
							<form:label for="nameTxt" path="name"><spring:message code="user.name" /></form:label>
							<form:input id="nameTxt" path="name" class="form-control" readonly="${readonly}" />
						</div>
						<div class="form-group">
							<form:label for="surnameTxt" path="surname"><spring:message code="user.surname"/> </form:label>
							<form:input id="surnameTxt" path="surname" class="form-control" readonly="${readonly}" />
						</div>
						<div class="form-group">
							<form:label for="passwordTxt" path="password"><spring:message code="user.password"/></form:label>
							<form:password id="passwordTxt" path="password" class="form-control" readonly="${readonly}" />
						</div>
						<div class="form-group">
							<form:label for="emailTxt" path="email"><spring:message code="user.email"/></form:label>
							<form:input id="emailTxt" path="email" class="form-control" readonly="${readonly}" />
						</div>
						<div class="form-group">
							<form:label for="phoneNumberTxt" path="phoneNumber"><spring:message code="user.phoneNumber"/> </form:label>
							<form:input id="phoneNumberTxt" path="phoneNumber" class="form-control" readonly="${readonly}" />
						</div>
						<div class="form-group">
							<form:label path="gender"><spring:message code="user.gender"/></form:label>
							<label class="radio-inline"><form:radiobutton path="gender" value="M" readonly="${readonly}" />
								<spring:message code="user.male"/></label>
							<label class="radio-inline"><form:radiobutton path="gender" value="F" readonly="${readonly}" />
								<spring:message code="user.female"/></label>
						</div>
						<div class="form-group">
							<form:label path="role"><spring:message code="user.role"/></form:label>
							<label class="radio-inline"><form:radiobutton path="role" value="ADMIN" readonly="${readonly}" />
								<spring:message code="role.admin"/></label>
							<label class="radio-inline"><form:radiobutton path="role" value="USER" readonly="${readonly}" />
								<spring:message code="role.user"/></label>
						</div>
						
						<button type="submit" class="btn btn-primary" disabled="${readonly}"><spring:message code="button.save"/></button>
				  	</div>
				</div>
			</div>
		</form:form>
	</jsp:body>
</t:template>