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
import pe.gob.unmsm.pc.models.Alumno;
import pe.gob.unmsm.pc.models.Curso;
import pe.gob.unmsm.pc.repository.alumnoRepository;
@Repository
public class alumnoRepImpl extends JdbcDaoSupport implements alumnoRepository {

	@Autowired
	private ApplicationContext context;
	
	private static String conn="jdbc_sgv";
	
	@Autowired
        //metodo de conexion
	public void fuenteDatos (DataSource setDataSource) {
		setDataSource(setDataSource);
	}

	@Override
	public Alumno extraerdatos(String codalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        //consulta sql
		String sql="select * from alumno where codalu=?";
		return jdbctemplate.queryForObject(sql, new AlumnoRowMapper(),codalu);
		
	}

	@Override
	public List<Curso> extraercurso(String codalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        //consulta sql
		String sql="select c.codcur,c.nomcur,d.nota, c.credito \r\n"
				+ "from alumno a \r\n"
				+ "inner join curso_alumno d on a.codalu=d.codalu \r\n"
				+ "inner join curso c on c.codcur=d.codcur\r\n"
				+ "where a.codalu=?";
		return jdbctemplate.query(sql, new CursoRowMapper(),codalu);
	}

	@Override
	public List<Alumno> listAll() {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "select * from alumno order by codalu";
		return jdbctemplate.query(sql, new AlumnoRowMapper());
	}


	@Override
	public void insert(Alumno alumno) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "insert into alumno(codalu,nomalu,apealu) values (?,?,?)";
		jdbctemplate.update(sql,alumno.getCodalu(),alumno.getNomalu(),alumno.getApealu());

	}

	@Override
	public void update(Alumno alumno) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "update alumno set  nomalu=?, apealu=? where codalu='"+alumno.getCodalu()+"'";
		jdbctemplate.update(sql,alumno.getNomalu(),alumno.getApealu());
	}

	@Override
	public void delete(String codalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		// consulta sql
		String sql = "delete from alumno where codalu='"+codalu+"'";
		jdbctemplate.update(sql);
	}
	
	
	
}
