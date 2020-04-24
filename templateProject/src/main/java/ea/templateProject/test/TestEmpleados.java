package ea.templateProject.test;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ea.templateProject.model.Empleado;

public class TestEmpleados {
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		
	

		//Insert 
		Empleado e = new Empleado(10L, "ApellidoCliente", "NombreCliente", new GregorianCalendar(1979, 6, 7).getTime());
		manager.getTransaction();
		manager.persist(e);
		manager.getTransaction().commit();
		
		imprimirTodo();
		
	}
	
	private static void imprimirTodo() {
		List <Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("In this database there are "+ empleados.size() +" empleados");
		for(Empleado emp : empleados) {
			System.out.println(emp.toString());
			
		}
		
		
	}

}
