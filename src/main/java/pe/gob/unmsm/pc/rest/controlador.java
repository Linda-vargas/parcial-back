package pe.gob.unmsm.pc.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.pc.models.Alumno;
import pe.gob.unmsm.pc.models.Curalu;
import pe.gob.unmsm.pc.models.Curso;
import pe.gob.unmsm.pc.models.data;
import pe.gob.unmsm.pc.repository.impl.alumnoRepImpl;
import pe.gob.unmsm.pc.repository.impl.cursoRepImpl;

@RestController
@RequestMapping("/pc")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controlador {
	
	@Autowired
	private alumnoRepImpl al;
	
	@Autowired
	private cursoRepImpl cur;
	
	@GetMapping("/listar_alumnos")
    public data listaralumno(@RequestParam String codalu){
		data a = new data();
		a.setAlumno(al.extraerdatos(codalu));
		a.setCurso(al.extraercurso(codalu));
		return a;
    }
	
	@GetMapping("/listarCursos")
    public List<Curso> listarCursos(){

	       return cur.listar();
	       
    }
	
	@PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Curso curso){
		 
		  Map<String, Object> response = new HashMap<String, Object>();
	 
	        	cur.agregar(curso);
	        	response.put("mensaje", "El curso ha sido insertado con éxito");
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	        
	        
    }
	@PutMapping("/actualizar")
    public ResponseEntity<?> update(@RequestBody Curso curso){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	cur.modificar(curso);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "Los datos del curso han sido actualizados con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminar(@RequestParam String id){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	cur.eliminar(id);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El curso ha sido eliminado con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/listarAlumnos")
    public List<Alumno> listarAlumnos(){

	       return al.listAll();
	       
    }
	
	@PostMapping("/agregarAlumnoCur")
    public ResponseEntity<?> agregarAC(@RequestBody Curalu curalu){
		 
		  Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	cur.agregarCurAlu(curalu);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El alumno ha sido insertado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	@PutMapping("/actualizarAlumnoCur")
    public ResponseEntity<?> actuAlumnoCur(@RequestBody Curalu curalu){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	cur.modificarCurAlu(curalu);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "Los datos del alumno han sido actualizados con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	
	@PutMapping("/eliminarcuralu")
    public ResponseEntity<?> eliminarcuralu(@RequestBody Curalu curalu){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	cur.eliminarCurAlu(curalu);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El alumno ha sido eliminado con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	
	@PostMapping("/agregarAlumno")
    public ResponseEntity<?> agregar(@RequestBody Alumno alumno){
		 
		  Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	al.insert(alumno);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El alumno ha sido insertado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	@PutMapping("/actualizarAlumno")
    public ResponseEntity<?> updateAlu(@RequestBody Alumno alumno){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	al.update(alumno);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "Los datos del alumno han sido actualizados con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/eliminarAlumno")
    public ResponseEntity<?> eliminarAlum(@RequestParam String cod){
		 
		 Map<String, Object> response = new HashMap<String, Object>();
	        try {
	        	al.delete(cod);
	        } catch(DataAccessException e) {
	            response.put("mensaje", "Error al realizar la consulta en la base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El alumno ha sido eliminado con éxito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }


}
