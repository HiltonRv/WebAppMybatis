package mybatis.mapper;

import java.util.List;

import modelo.Bean.detalleBean;


public interface DetalleMapper {
	
	public List<detalleBean> listar();
	public int registrar (detalleBean c);
	public int actualizar (detalleBean c);
	public int eliminar (int id);
	public detalleBean buscar (int id);

}
