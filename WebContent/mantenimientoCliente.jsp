<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO CLIENTE</title>
<sb:head/>
<body>
<center>
<h3>MANTENIMIENTO CLIENTE</h3>
<hr>
<p></p>

	<s:form action="%{(edit==0)?'registrarCliente':'actualizarCliente'}">
	<s:textfield label="ID" name="cliente.idcliente" />
	<s:textfield label="NOMBRE" name="cliente.nombre" />
	<s:textfield label="APELLIDO" name="cliente.apellido" />
	<s:textfield label="DIRECCION" name="cliente.direccion" />
	<s:textfield label="FECHA NACIMIENTO" name="cliente.fechanacimiento" />
	<s:textfield label="TELEFONO" name="cliente.telefono" />
	<s:textfield label="EMAIL" name="cliente.email" />
	<s:textfield label="CATEGORIA" name="cliente.categoria" />
	<s:submit value="%{(edit==0)?'Registrar':'Actualizar'}"/>
	</s:form>

<p></p>
<hr>
<table border="1" cellpadding="10px" cellspacing="10px">
<thead>
<tr>
<th>ID</th>
<th>NOMBRE</th>
<th>APELLIDO</th>
<th>DIRECCION</th>
<th>FECHA NACIMIENTO</th>
<th>TELEFONO</th>
<th>EMAIL</th>
<th>CATEGORIA</th>
<th colspan="2">OPC</th>
</tr>
</thead>
<tbody>
<s:iterator value="lstCliente">
<tr>
<td> <s:property value="idcliente"/></td>
<td> <s:property value="nombre"/></td>
<td> <s:property value="apellido"/></td>
<td> <s:property value="direccion"/></td>
<td> <s:property value="fechanacimiento"/></td>
<td> <s:property value="telefono"/></td>
<td> <s:property value="email"/></td>
<td> <s:property value="categoria"/></td>
<td>
	<s:url action="editarCliente" var="lnkeditar">
		<s:param name="cliente.idcliente" value="idcliente"/>			
			</s:url>
	<s:a href="%{lnkeditar}">Editar
				<img alt="editar" src="img/editar.png">		
	</s:a>
</td>
<td>
	<s:url action="eliminarCliente" var="lnkeliminar">
		<s:param name="cliente.idcliente" value="idcliente"/>			
	</s:url>
	<s:a href="%{lnkeliminar}">Eliminar
		<img alt="eliminar" src="img/eliminar.png">		
	</s:a>	
</td>
</tr>
</s:iterator>
</tbody>
</table>
<p></p>
	<p>
	<a class="btn btn-primary" href="index.jsp"> Menu Principal </a>
	</p>
</center>
</body>
</html>