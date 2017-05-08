<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="save">
	<s:textfield label="Nombre" name="name" ></s:textfield>
	<s:textfield label="Edad" name="age"></s:textfield>
	<s:radio label="Genero" name="gender"
		list="#{'Femenino':'Femenino','Masculino':'Masculino'}" />
	<s:submit label="Cargar"></s:submit>
	<s:actionerror/>
</s:form>

<table>
	<tr>
		<th>ID</th>
		<th>NOMBRE</th>
		<th>EDAD</th>
		<th>GENERO</th>
	</tr>
<s:iterator value="personas" var="p" status="status">
	<tr>
		<!-- 
		<td><s:property value="#p.id"/>(<s:property value="%{#status.index}" />)</td>
		-->
		<td><s:property value="#p.id"/></td>
		<td><s:property value="#p.name"/></td>
		<td><s:property value="#p.age"/></td>
		<td><s:property value="#p.gender"/></td>
		<!-- 
		<td><a href="modificar?id=<s:property value="#p.id"/>">Modificar</a></td>
		<td><a href="eliminar?id=<s:property value="#p.id"/>">Eliminar</a></td>
		-->
		<td><s:a action="Eliminar" ><s:param name="id" value="#p.id"></s:param>Eliminar</s:a> 
		<td><s:a action="Modificar"><s:param name="id" value="#p.id"></s:param>Modificar</s:a>
	</tr>
</s:iterator>
</table>

</body>
</html>