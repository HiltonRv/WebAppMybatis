package MantenimientoGeneral.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import modelo.Bean.clienteBean;
import modelo.Bean.detalleBean;
import modelo.Bean.facturaBean;
import modelo.Bean.productoBean;
import service.ClienteService;
import service.DetalleService;
import service.FacturaService;
import service.ProductoService;

public class GeneralAction {
	
	private List<clienteBean> lstCliente;
	private List<facturaBean> lstFactura;
	private List<detalleBean> lstDetalle;
	private List<productoBean> lstProducto;
	private clienteBean cliente;
	private facturaBean factura;
	private detalleBean detalle;
	private productoBean producto;
	private String resultado;
	private int edit;
	
	
	public clienteBean getCliente() {
		return cliente;
	}

	public void setCliente(clienteBean cliente) {
		this.cliente = cliente;
	}

	public facturaBean getFactura() {
		return factura;
	}

	public void setFactura(facturaBean factura) {
		this.factura = factura;
	}

	public detalleBean getDetalle() {
		return detalle;
	}

	public void setDetalle(detalleBean detalle) {
		this.detalle = detalle;
	}

	public productoBean getProducto() {
		return producto;
	}

	public void setProducto(productoBean producto) {
		this.producto = producto;
	}

	public List<clienteBean> getLstCliente() {
		return lstCliente;
	}

	public List<facturaBean> getLstFactura() {
		return lstFactura;
	}

	public List<detalleBean> getLstDetalle() {
		return lstDetalle;
	}

	public List<productoBean> getLstProducto() {
		return lstProducto;
	}

	public String getResultado() {
		return resultado;
	}

	public int getEdit() {
		return edit;
	}

		//LISTAR CLIENTE	
		@Action(value="mantenimientoCliente",results= {
				@Result(name="ok",location="/mantenimientoCliente.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String mantenimientoCliente() {
			try {
				lstCliente=(new ClienteService()).listar();
				cliente= new clienteBean();
				return "ok";			
			} catch (Exception e) {
				resultado="error:"+e.getMessage();
				return "error";
			}
			
		}
		
		//LISTAR FACTURA
		@Action(value="mantenimientoFactura",results= {
				@Result(name="ok",location="/MantenimientoFactura.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String mantenimientoFactura() {
			try {
				lstCliente=(new ClienteService()).listar();
				lstFactura=(new FacturaService()).listar();
				
				return "ok";			
			} catch (Exception e) {
				resultado="error:"+e.getMessage();
				return "error";
			}
			
		}
		
		//LISTAR PRODUCTO
		
		@Action(value="mantenimientoProducto",results= {
				@Result(name="ok",location="/mantenimientoProducto.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String mantenimientoProducto() {
			try {
				lstProducto=(new ProductoService()).listar();
				producto=new productoBean();
				return "ok";
			} catch (Exception e) {
				resultado="error:"+e.getMessage();
				return "error";
			}
			
		}
		
		//LISTAR DETALLE
		
		@Action(value="mantenimientoDetalle",results= {
				@Result(name="ok",location="/mantenimientoDetalle.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String mantenimientoDetalle() {
			try {
				lstDetalle=(new DetalleService()).listar();
				lstFactura=(new FacturaService()).listar();
				lstProducto=(new ProductoService()).listar();
				detalle= new detalleBean();
				return "ok";			
			} catch (Exception e) {
				resultado="error:"+e.getMessage();
				return "error";
			}
			
		}
		
		//EDITAR MANTENIMIENTO CLIENTE
			
			@Action(value="editarCliente",results= {
					@Result(name="ok",location="/mantenimientoCliente.jsp"),
					@Result(name="error",location="/error.jsp")
			})
			public String editarCliente() {
				try {
					cliente=(new ClienteService()).buscar(cliente.getIdcliente());
					lstCliente=(new ClienteService()).listar();
					edit=1;
					return "ok";
				} catch (Exception e) {
					resultado="Error: "+e.getMessage();
					return "error";
				}
				
			}
			
			//EDITAR MANTENIMIENTO FACTURA
			
			@Action(value="editarFactura",results= {
					@Result(name="ok",location="/MantenimientoFactura.jsp"),
					@Result(name="error",location="/error.jsp")
			})
			public String editarFactura() {
				try {
					System.out.println(factura.getNumfactura());
					
					factura=(new FacturaService()).buscar(factura.getNumfactura());
					lstCliente=(new ClienteService()).listar();
					lstFactura=(new FacturaService()).listar();
					edit=1;
					
					return "ok";
				} catch (Exception e) {
					resultado="Error: "+e.getMessage();
					return "error";
				}
				
			}
		//EDIATR PRODUCTO
			@Action(value="editarProducto",results= {
					@Result(name="ok",location="/mantenimientoProducto.jsp"),
					@Result(name="error",location="/error.jsp")
			})
			public String editarProducto() {
				try {
					producto=(new ProductoService()).buscar(producto.getIdproducto());
					lstProducto=(new ProductoService()).listar();
								
					edit=1;
					return "ok";
				} catch (Exception e) {
					resultado="Error: "+e.getMessage();
					return "error";
				}
				
			}
			
			//EDITAR DETALLE
			
			@Action(value="editarDetalle",results= {
					@Result(name="ok",location="/mantenimientoDetalle.jsp"),
					@Result(name="error",location="/error.jsp")
			})
			public String editarDetalle() {
				try {
					detalle=(new DetalleService()).buscar(detalle.getNumdetalle());
					lstDetalle=(new DetalleService()).listar();
					lstProducto=(new ProductoService()).listar();
					lstFactura=(new FacturaService()).listar();
					
					edit=1;
					return "ok";
				} catch (Exception e) {
					resultado="Error: "+e.getMessage();
					return "error";
				}
				
			}
		
			//REGISTRAR CLIENTE
		@Action(value="registrarCliente",results= {
				@Result(name="ok",location="/mantenimientoCliente.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String registrarCliente() {
			try {
				(new ClienteService()).registrar(cliente);
				lstCliente=(new ClienteService()).listar();
				cliente=new clienteBean();
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		//REGISTRAR FACTURA
		@Action(value="registrarFactura",results= {
				@Result(name="ok",location="/MantenimientoFactura.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String registrarFactura() {
			try {
				(new FacturaService()).registrar(factura);
				lstCliente=(new ClienteService()).listar();
				lstFactura=(new FacturaService()).listar();
				factura=new facturaBean();
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		//REGISTRAR PRODUCTO
		@Action(value="registrarProducto",results= {
				@Result(name="ok",location="/mantenimientoProducto.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String registrarProducto() {
			try {
				(new ProductoService()).registrar(producto);
				lstProducto=(new ProductoService()).listar();
				producto = new productoBean();
				
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		//REGISTRAR DETALLE
		
		@Action(value="registrarDetalle",results= {
				@Result(name="ok",location="/mantenimientoDetalle.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String registrarDetalle() {
			try {
				(new DetalleService()).registrar(detalle);
				lstDetalle=(new DetalleService()).listar();
				lstProducto=(new ProductoService()).listar();
				lstFactura=(new FacturaService()).listar();
				detalle= new detalleBean();
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		//ACTUALIZAR CLIENTE 
		@Action(value="actualizarCliente",results= {
				@Result(name="ok",location="/mantenimientoCliente.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String actualizarCliente() {
			try {
				(new ClienteService()).actualizar(cliente);
				lstCliente=(new ClienteService()).listar();
				cliente=new clienteBean();
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
		}	
		//ACTUALIZAR FACTURA
		@Action(value="actualizarFactura",results= {
				@Result(name="ok",location="/MantenimientoFactura.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String actualizarFactura() {
			try {
				(new FacturaService()).actualizar(factura);
				lstCliente=(new ClienteService()).listar();
				lstFactura=(new FacturaService()).listar();
				factura=new facturaBean();
				
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		
		//ACTUALIZAR PRODUCTO
		@Action(value="actualizarProducto",results= {
				@Result(name="ok",location="/mantenimientoProducto.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String actualizarProducto() {
			try {
				(new ProductoService()).actualizar(producto);
				lstProducto=(new ProductoService()).listar();
				producto=new productoBean();
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		
		//ACTUALIZAR DETALLE
		@Action(value="actualizarDetalle",results= {
				@Result(name="ok",location="/mantenimientoDetalle.jsp"),
				@Result(name="error",location="/error.jsp")
		})
		public String actualizarDetalle() {
			try {
				(new DetalleService()).actualizar(detalle);	
				lstDetalle=(new DetalleService()).listar();
				lstProducto=(new ProductoService()).listar();
				lstFactura=(new FacturaService()).listar();
				detalle= new detalleBean();
				
				return "ok";
			} catch (Exception e) {
				resultado="Error "+e.getMessage();
				return "error";
			}
			
		}
		
		//ELIMINAR CLIENTE
		@Action(value="eliminarCliente",results = {
				@Result(name="ok",location="/mantenimientoCliente.jsp"),
				@Result(name="error",location = "/error.jsp")
		})
		public String eliminarCliente() {
			try {
				(new ClienteService()).eliminar(cliente.getIdcliente());
				lstCliente=(new ClienteService()).listar();
				cliente=new clienteBean();
				return "ok";
			} catch (Exception e) {
				resultado = "Error: "+e.getMessage();
				return "error";
			}
		}
		
		//ELIMINAR FACTURA
		
		@Action(value="eliminarFactura",results = {
				@Result(name="ok",location="/MantenimientoFactura.jsp"),
				@Result(name="error",location = "/error.jsp")
		})
		public String eliminarFactura() {
			try {
				(new FacturaService()).eliminar(factura.getNumfactura());
				lstCliente=(new ClienteService()).listar();
				lstFactura=(new FacturaService()).listar();
				factura=new facturaBean();
				return "ok";
			} catch (Exception e) {
				resultado = "Error: "+e.getMessage();
				return "error";
			}
		}
		//ELIMINAR PRODUCTO
		
		@Action(value="eliminarProducto",results = {
				@Result(name="ok",location="/mantenimientoProducto.jsp"),
				@Result(name="error",location = "/error.jsp")
		})
		public String eliminarProducto() {
			try {
				(new ProductoService()).eliminar(producto.getIdproducto());
				lstProducto=(new ProductoService()).listar();
				producto=new productoBean();
				return "ok";
			} catch (Exception e) {
				resultado = "Error: "+e.getMessage();
				return "error";
			}
		}
		//ELIMINAR DETALLE
		
		@Action(value="eliminarDetalle",results = {
				@Result(name="ok",location="/mantenimientoDetalle.jsp"),
				@Result(name="error",location = "/error.jsp")
		})
		public String eliminarDetalle() {
			try {
				(new DetalleService()).eliminar(detalle.getNumdetalle());
				lstDetalle=(new DetalleService()).listar();
				lstProducto=(new ProductoService()).listar();
				lstFactura=(new FacturaService()).listar();
				detalle= new detalleBean();
				return "ok";
			} catch (Exception e) {
				resultado = "Error: "+e.getMessage();
				return "error";
			}
		}
	

}
