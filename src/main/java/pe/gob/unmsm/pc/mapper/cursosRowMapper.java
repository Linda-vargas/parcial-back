package pe.gob.unmsm.pc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.pc.models.Curso;

public class cursosRowMapper implements RowMapper<Curso> {
	@Override
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso us = new Curso();
		us.setCodcur(rs.getString("codcur"));
                us.setNomcur(rs.getString("nomcur"));
                us.setCredito(rs.getInt("credito"));
		return us;
	}	
}