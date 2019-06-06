package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import modelo.Bean.clienteBean;
import mybatis.MyBatisUtil;
import mybatis.mapper.ClienteMapper;


public class ClienteService implements ClienteMapper {

	@Override
	public List<clienteBean> listar() {
		
		List<clienteBean> lst = new ArrayList<clienteBean>();
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ClienteMapper cm= s.getMapper(ClienteMapper.class);
			lst=cm.listar();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return lst;
	}

	@Override
	public int registrar(clienteBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ClienteMapper cm= s.getMapper(ClienteMapper.class);
			rs=cm.registrar(c);
			s.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return rs;
	}

	@Override
	public int actualizar(clienteBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ClienteMapper cm= s.getMapper(ClienteMapper.class);
			rs=cm.actualizar(c);
			s.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return rs;
	}

	@Override
	public int eliminar(int id) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ClienteMapper cm= s.getMapper(ClienteMapper.class);
			rs=cm.eliminar(id);
			s.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return rs;
	}

	@Override
	public clienteBean buscar(int id) {
		clienteBean c=null;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ClienteMapper cm= s.getMapper(ClienteMapper.class);
			c=cm.buscar(id);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
	
		return null;
	}


}
