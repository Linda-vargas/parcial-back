package pe.gob.unmsm.pc.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.unmsm.pc.mapper.AlumnoRowMapper;
import pe.gob.unmsm.pc.mapper.CursoRowMapper;
import pe.gob.unmsm.pc.mapper.curso_alumnos;
import pe.gob.unmsm.pc.mapper.cursosRowMapper;
import pe.gob.unmsm.pc.models.Curalu;
import pe.gob.unmsm.pc.models.Curso;
import pe.gob.unmsm.pc.repository.cursoRepository;


@Repository
public class cursoRepImpl extends JdbcDaoSupport implements cursoRepository {
	
	@Autowired
	private ApplicationContext context;

	private static String conn = "jdbc_sgv";

	@Autowired
	// metodo de conexion
	public void fuenteDatos(DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	@Override
	public List<Curso> listar() {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "select * from curso order by codcur";
		return  jdbctemplate.query(sql, new cursosRowMapper());
		
	}

	@Override
	public void agregar(Curso curso) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "insert into curso(codcur,nomcur,credito) values (?,?,?)";
		jdbctemplate.update(sql,curso.getCodcur(),curso.getNomcur(),curso.getCredito());
		
	}

	@Override
	public void modificar(Curso curso) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "update curso set codcur=? , nomcur=?, credito=? where codcur='"+curso.getCodcur()+"'";
		jdbctemplate.update(sql,curso.getCodcur(),curso.getNomcur(),curso.getCredito());
		
	}

	@Override
	public void eliminar(String id) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "delete from curso where codcur='"+id+"'";
		jdbctemplate.update(sql);
		
	}
	
	//Agregar curso al alumno
	@Override
	public void agregarCurAlu(Curalu curalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "insert into curso_alumno(codcur,codalu,nota) values (?,?,?)";
		jdbctemplate.update(sql,curalu.getCodcur(),curalu.getCodalu(),curalu.getNota());
		
	}

	@Override
	public void modificarCurAlu(Curalu curalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "update curso_alumno set nota=? where codcur='"+curalu.getCodcur()+"' and codalu='"+curalu.getCodalu()+"'";
		jdbctemplate.update(sql,curalu.getNota());
		
	}

	@Override
	public void eliminarCurAlu(Curalu curalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "delete from curso_alumno where codcur='"+curalu.getCodcur()+"' and codalu='"+curalu.getCodalu()+"'";
		jdbctemplate.update(sql);
		
	}

}
