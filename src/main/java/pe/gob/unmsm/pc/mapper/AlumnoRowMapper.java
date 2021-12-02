package pe.gob.unmsm.pc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.pc.models.Alumno;

public class AlumnoRowMapper implements RowMapper<Alumno> {
	@Override
	public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
		Alumno us = new Alumno();
		us.setCodalu(rs.getString("codalu"));
                us.setNomalu(rs.getString("nomalu"));
                us.setApealu(rs.getString("apealu"));
		return us;
	}	
}
