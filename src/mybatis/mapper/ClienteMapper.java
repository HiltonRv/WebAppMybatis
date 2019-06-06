package mybatis.mapper;

import java.util.List;

import modelo.Bean.clienteBean;

public interface ClienteMapper {
	
	public List<clienteBean> listar();
	public int registrar (clienteBean c);
	public int actualizar (clienteBean c);
	public int eliminar (int id);
	public clienteBean buscar (int id);

}
