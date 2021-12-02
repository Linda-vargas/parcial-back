package pe.gob.unmsm.pc.repository;

import java.util.List;

import pe.gob.unmsm.pc.models.Curalu;
import pe.gob.unmsm.pc.models.Curso;

public interface cursoRepository {
	public List<Curso> listar();
	public void agregar(Curso curso);
	public void modificar(Curso curso);
	public void eliminar(String id);
	
	public void agregarCurAlu(Curalu curalu);
	public void modificarCurAlu(Curalu curalu);
	public void eliminarCurAlu(Curalu curalu);
}
