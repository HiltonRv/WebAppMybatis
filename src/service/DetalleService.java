package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import modelo.Bean.detalleBean;
import mybatis.MyBatisUtil;
import mybatis.mapper.DetalleMapper;

public class DetalleService  implements DetalleMapper{

	@Override
	public List<detalleBean> listar() {
		List<detalleBean> lst = new ArrayList<detalleBean>();
		
		try {
			SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
			DetalleMapper cm= s.getMapper(DetalleMapper.class);
			lst=cm.listar();
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public int registrar(detalleBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			DetalleMapper cm= s.getMapper(DetalleMapper.class);
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
	public int actualizar(detalleBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			DetalleMapper cm= s.getMapper(DetalleMapper.class);
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
			
			DetalleMapper cm= s.getMapper(DetalleMapper.class);
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
	public detalleBean buscar(int id) {
		detalleBean d= null;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			DetalleMapper cm= s.getMapper(DetalleMapper.class);
			d=cm.buscar(id);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return null;
	}

}
