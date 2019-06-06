<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO PRODUCTO</title>
<sb:head/>
</head>
<body>
<center>
<h3>MANTENIMIENTO PRODUCTO</h3>
<hr>
<p></p>

<s:form action="%{(edit==0)?'registrarProducto':'actualizarProducto'}">
	<s:textfield label="Id" name="producto.idproducto"/> 
	<s:textfield label="Nombres" name="producto.nombre"/>
	<s:textfield label="Precio" name="producto.precio"/>
	<s:textfield label="Stock" name="producto.stock"/>
	<s:submit value="%{(edit==0)?'Registrar':'Actualizar'}"/>
</s:form>

<p></p>
<hr>
<table border="1" cellpadding="10px" cellspacing="10px">
<thead>
<tr>
	<th>Id</th>
	<th>Nombres</th>
	<th>Precio</th>
	<th>Stock</th>
	<th colspan="2">OPC</th>
</tr>
</thead>
<tbody>
<s:iterator value="lstProducto">
	<tr>
		<td><s:property value="idproducto" /> </td>
		<td><s:property value="nombre" /> </td>
		<td><s:property value="precio" /> </td>
		<td><s:property value="stock" /> </td>
		<td>
			<s:url action="editarProducto" var="lnkeditar">
			<s:param name="producto.idproducto" value="idproducto"/>			
			</s:url>
	<s:a href="%{lnkeditar}">Editar
				<img alt="editar" src="img/editar.png">		
	</s:a>
		</td>
		<td>
			<s:url action="eliminarProducto" var="lnkeliminar">
		<s:param name="producto.idproducto" value="idproducto"/>			
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