<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO DETALLE</title>
<sb:head/>
</head>
<body>
<center>
<h3>MANTENIMIENTO DETALLE</h3>
<hr>
<p></p>

	<s:form action="%{(edit==0)?'registrarDetalle':'actualizarDetalle'}">
		<s:textfield label="Numero" name="detalle.numdetalle" />
		<s:select list="lstFactura" listKey="numfactura" listValue="numfactura"
		headerKey="-1" headerValue="[--Seleccione--]" name="detalle.numfactura"
		label="Id Factura" />
		<s:select list="lstProducto" listKey="idproducto" listValue="idproducto"
		headerKey="-1" headerValue="[--Seleccione--]" name="detalle.idproducto"
		label="Id Producto" />
		<s:textfield label="cantidad" name="detalle.cantidad" />
		<s:textfield label="precio" name="detalle.precio"/>
		<s:submit value="%{(edit==0)?'Registrar':'Actualizar'}" />
	</s:form>

<p></p>
<hr>
<table border="1" cellpadding="10px" cellspacing="10px">
<thead>
<tr>
	<th>Numero</th>
	<th>Id Factura</th>
	<th>Id Producto</th>
	<th>Cantidad</th>
	<th>Precio </th>
	<th colspan="2">OPC</th>
</tr>
</thead>
<tbody>
	<s:iterator value="lstDetalle">
	<tr>
		<td><s:property value="numdetalle"/> </td>
		<td><s:property value="numfactura"/> </td>
		<td><s:property value="idproducto"/> </td>
		<td><s:property value="cantidad"/> </td>
		<td><s:property value="precio"/> </td>
		<td>
		<s:url action="editarDetalle" var="lnkeditar">
		<s:param name="detalle.numdetalle" value="numdetalle"/>			
			</s:url>
	<s:a href="%{lnkeditar}">Editar
				<img alt="editar" src="img/editar.png">		
	</s:a>
		</td>
		<td>
		<s:url action="eliminarDetalle" var="lnkeliminar">
		<s:param name="detalle.numdetalle" value="numdetalle"/>			
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