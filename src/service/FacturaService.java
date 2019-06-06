package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import modelo.Bean.facturaBean;
import mybatis.MyBatisUtil;
import mybatis.mapper.FacturaMapper;

public class FacturaService implements FacturaMapper {

	@Override
	public List<facturaBean> listar() {
		List<facturaBean> lst= new ArrayList<facturaBean>();
		
		try {
			SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
			FacturaMapper cm= s.getMapper(FacturaMapper.class);
			lst=cm.listar();
			s.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public int registrar(facturaBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			FacturaMapper cm= s.getMapper(FacturaMapper.class);
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
	public int actualizar(facturaBean c) {
		int rs=0;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			FacturaMapper cm= s.getMapper(FacturaMapper.class);
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
			
			FacturaMapper cm= s.getMapper(FacturaMapper.class);
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
	public facturaBean buscar(int id) {
		facturaBean f=null;
		SqlSession s=MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			
			FacturaMapper cm= s.getMapper(FacturaMapper.class);
			f=cm.buscar(id);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		return null;
	}

	
}
