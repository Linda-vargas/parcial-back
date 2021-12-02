package pe.gob.unmsm.pc.models;

import java.util.List;

public class data {
	private Alumno alumno;
	private List<Curso> curso;
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<Curso> getCurso() {
		return curso;
	}
	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}
	
}
