package com.maven.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Jpa_Maven_Test {

	private EntityManager entityManager;

	public Jpa_Maven_Test(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Proyecto-Maven-CibertecIII");
		EntityManager manager=factory.createEntityManager();
		
		Jpa_Maven_Test testMaven= new Jpa_Maven_Test(manager);
		EntityTransaction entityTransaction=manager.getTransaction();
		entityTransaction.begin();
		
		testMaven.createAlumno();
		 //llamamos al metodo listar alumnos....

	    //imprimimos los campos por consola....

	    System.out.println("nombre  "+" apellido "+" dni "+" sexo "+" email ");

	    //declaramos una variable de list para recuperar los valores de la BD...

	    List<Alumno> empleXcode=testMaven.ListarAlumnos();
		for (Alumno empleado : empleXcode) {
			System.out.println(empleado.getNombre()+", "+empleado.getApellido()+", "+empleado.getIdalumno()+", "+empleado.getDni()+", "+
					empleado.getEmail()+", "+empleado.getSexo());
		}
		
		testMaven.ActualizarEmpleado(1, "juan", "Gomez");
		
		testMaven.EliminarEmpleado(1);
		
		entityTransaction.commit();
	}
	public void createAlumno() {
		Alumno a= new Alumno("Carlos","Mogollon","72486509","M","admin@gmail.com");
		entityManager.persist(a);
	}
	public List<Alumno> ListarAlumnos(){
		//declaramos una variable de tipo string
		String consulta="select a from alumno a";
		//aplicamos la interfaz query...
		Query querycons=entityManager.createQuery(consulta,Alumno.class);
		//almacenamos los valores de la BD en una variable de tipo List....
		List<Alumno> listalum=querycons.getResultList();
		//retornamos los valores...
		return listalum;
	}
	
	public void ActualizarEmpleado(int idEmpleado, String nombre, String apellido) {
		String actualizar="update alumno e set e.nombre=:nomb, e.apellido=:ape where e.idalumno=:idEmple";
		Query actualizarEmpleado=entityManager.createQuery(actualizar);
		//pasamos los parametros
		actualizarEmpleado.setParameter("idEmple", idEmpleado);
		actualizarEmpleado.setParameter("nomb", nombre);
		actualizarEmpleado.setParameter("ape", apellido);
		int rpta=actualizarEmpleado.executeUpdate();
		if(rpta>0) {
			System.out.println("Actualizacion Correcta");
		}else {
			System.out.println("Actualizacion Incorrecta");
		}
		
	}
	
	
	public void EliminarEmpleado(int idEmpleado) {
		String eliminar="delete alumno where idalumno=:idEmple";
		Query eliminarEmpleado=entityManager.createQuery(eliminar).setParameter("idEmple", idEmpleado);
		int rpta=eliminarEmpleado.executeUpdate();
		if(rpta>0) {
			System.out.println("Eliminacion Correcta");
		}else {
			System.out.println("Eliminacion Incorrecta");
		}		
	}
	
	
	
	
	

}
