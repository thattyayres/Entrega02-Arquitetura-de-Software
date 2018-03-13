<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Chamados</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="Menu.jsp" />
		<div id="main" class="container">
			<h3 class="page-header"><c:out value="${fila.nome}"></c:out></h3>
			<table border="1" class="table table-striped">
				<thead>
					<tr>
						<th>Número</th>
						<th>Descrição</th>
						<th>Abertura</th>
						<th>Fechamento</th>
						<th>Status</th>
						<th>Tempo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="chamado" items="${Chamado}">
						<tr>
							<td align="right">${chamado.idChamado}</td>
							<td align="left">${chamado.descricao}</td>
							<td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${chamado.dtAbertura}"/></td>
							<td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${chamado.dtFechamento}"/></td>
							<td align="center">${chamado.status}</td>
							<c:set var="abertura" value="${chamado.dtAbertura.getTime()}"></c:set>
							<c:set var="fechamento" value="${chamado.dtFechamento.getTime()}"></c:set>
							<fmt:formatNumber var="tempo" value="${(fechamento - abertura)/(24 * 60 * 60 * 1000)}" type="number" pattern="#"></fmt:formatNumber>
							<c:if test="${tempo lt 0}"><c:set var="tempo" value="0"></c:set></c:if>
							<td align="center"><c:out value="${tempo}"/></td>
							

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.min.js"></script>
	</body>
</html>