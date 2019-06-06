package mybatis.mapper;

import java.util.List;

import modelo.Bean.facturaBean;


public interface FacturaMapper {

	public List<facturaBean> listar();
	public int registrar (facturaBean c);
	public int actualizar (facturaBean c);
	public int eliminar (int id);
	public facturaBean buscar (int id);
}
