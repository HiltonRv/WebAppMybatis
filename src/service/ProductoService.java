package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import modelo.Bean.productoBean;
import mybatis.MyBatisUtil;
import mybatis.mapper.ProductoMapper;

public class ProductoService implements ProductoMapper{

	@Override
	public List<productoBean> listar() {
		List<productoBean> lst = new ArrayList<productoBean>();
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ProductoMapper cm= s.getMapper(ProductoMapper.class);
			lst=cm.listar();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return lst;
	}

	@Override
	public int registrar(productoBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ProductoMapper cm= s.getMapper(ProductoMapper.class);
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
	public int actualizar(productoBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ProductoMapper cm= s.getMapper(ProductoMapper.class);
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
			
			ProductoMapper cm= s.getMapper(ProductoMapper.class);
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
	public productoBean buscar(int id) {
		
		productoBean p=null;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			ProductoMapper cm= s.getMapper(ProductoMapper.class);
			p=cm.buscar(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return null;
	}

}
