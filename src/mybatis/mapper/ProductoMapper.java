package mybatis.mapper;

import java.util.List;

import modelo.Bean.productoBean;


public interface ProductoMapper {

	public List<productoBean> listar();
	public int registrar (productoBean c);
	public int actualizar (productoBean c);
	public int eliminar (int id);
	public productoBean buscar (int id);
}
