<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MANTENIMIENTO FACTURA</title>
<sb:head/>
<body>
<center>
<h3>MANTENIMIENTO FACTURA</h3>
<hr>
<p></p>

<s:form action="%{(edit==0)?'registrarFactura':'actualizarFactura'}">
	<s:textfield label="Numero" name="factura.numfactura" />
	<s:select list="lstCliente" listKey="idcliente" listValue="idcliente"
		headerKey="-1" headerValue="[--Seleccione--]" name="factura.idcliente"
		label="Cliente" />
	<s:textfield label="Fecha" name="factura.fecha" />
	<s:submit value="%{(edit==0)?'Registrar':'Actualizar'}"/>
</s:form>

<p></p>
<hr>
<table border="1" cellpadding="10px" cellspacing="10px">
<thead>
<tr>
<th>NUMERO</th>
<th>ID CLIENTE</th>
<th>FECHA</th>
<th colspan="2">OPC</th>
</tr>
</thead>
<tbody>
<s:iterator value="lstFactura">
<tr>
<td> <s:property value="numfactura"/></td>
<td> <s:property value="idcliente"/></td>
<td> <s:property value="fecha"/></td>
<td>
		<s:url action="editarFactura" var="lnkeditar">
		<s:param name="factura.numfactura" value="numfactura"/>			
			</s:url>
	<s:a href="%{lnkeditar}">Editar
				<img alt="editar" src="img/editar.png">		
	</s:a>
</td>
<td>
		<s:url action="eliminarFactura" var="lnkeliminar">
		<s:param name="factura.numfactura" value="numfactura"/>			
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