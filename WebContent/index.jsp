<html>
<head>
<title>Menu Principal</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

#header {
	margin: auto;
	width: 500px;
	font-family: Arial, Helvetic, sana-serif;
}

ul, ol {
	list-style: none;
}

.nav li a {
	background-color: #000;
	color: #fff;
	text-decoration: none;
	padding: 10px 15px;
	display: block;
}

.nav li a:hover {
	background-color: #434343;
}

.nav>li {
	float: left;
}

.nav li ul {
	display: none;
	position: absolute;
	min-width: 140px;
}

.nav li:hover>ul {
	display: block;
}

.nav li ul li {
	position: relative;
}

.nav li ul li ul {
	right: -140;
	top: 0px;
}
</style>
</head>
<body>
	<div id="header">
		<ul class="nav">
			<li><a href="mantenimientoCliente">CLIENTE</a></li>
			<li><a href="mantenimientoDetalle">DETALLE</a></li>
			<li><a href="mantenimientoFactura">FACTURA</a></li>
			<li><a href="mantenimientoProducto">PRODUCTO</a></li>
		</ul>
	</div>
</body>
</html>