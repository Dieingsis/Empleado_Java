package poo;   
import java.util.*;
public class uso_Empleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006,11,14);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		
	Empleado[]misEmpleados=new Empleado[6];
	
	misEmpleados[0]=new Empleado("Paco Gomez", 85000, 1990, 12, 17);
	misEmpleados[1]=new Empleado("Ana Lopez" , 95000, 1995, 06, 02);
	misEmpleados[2]=new Empleado("Maria Martin", 105000, 2002, 03, 15);
	misEmpleados[3]=new Empleado("Antonio Fernandez ");
	misEmpleados[4]=jefe_RRHH;//polimorfismo en acción. Principio de sustitución.
	misEmpleados[5]=new Jefatura("Maria",95000,1999,5,26);
	Jefatura jefa_finanzas=(Jefatura)misEmpleados[5];
	jefa_finanzas.estableceIncentivo(5000);
	
	System.out.println(jefa_finanzas.tomar_decisiones("Dar mas días de vacaciones a los empleados"));
	
	/* Esto lo puse a prueba para crear mis propias clases. Empleado director_comercial=new Jefatura("Sandra", 85000, 2012, 05, 05);
	
	
	 * Comparable ejemplo=new Empleado("Elisabeth, 95000, 2011, 06, 07");
	
	if(director_comercial instanceof Empleado) {
		System.out.println("Es de tipo Jefatura ");
	}

	if(ejemplo instanceof Comparable) {
		System.out.println("Implementa la interfaz comparable");	
	}*/
	
	//Este programa imprime todo lo dentro de este array.
	for(Empleado e: misEmpleados) {
		
		e.sube_sueldo(5);
	}
	Arrays.sort(misEmpleados);
	
	for(Empleado e: misEmpleados) {
		System.out.println("Nombre "+ e.dameNombre()
				+ " Sueldo: "+ e.dame_sueldo()
				+" Fecha de alta: "+ e.dame_fecha_contrato());
	}
	}
}

class Empleado implements Comparable{
	
	public Empleado(String nom, double sue, int año, int mes, int dia) {
		
	nombre=nom;
	sueldo=sue;
	
	GregorianCalendar calendario= new GregorianCalendar(año,mes-1,dia);
	
	altaContrato=calendario.getTime();
	
	
	
	++IdSiguiente;
	
	  Id=IdSiguiente;
	
	
	}
	
	public Empleado(String nom) {
		
		this(nom,30000,2000,01,01);
	}
	
	public String dameNombre() {//getter
		
		return nombre + " Id: "+ Id;
	
	}
	
	public double dame_sueldo(){
		
		return sueldo;
	}
	
	public Date dame_fecha_contrato() {//getter
		
		return altaContrato;
	}
	
	public void sube_sueldo(double porcentaje) {//setter 
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado= (Empleado) miObjeto;
		
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		
				if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
}

class Jefatura extends Empleado implements Jefes{
	public Jefatura(String nom, double sue, int año, int mes, int dia) {
		
		super(nom, sue, año, mes, dia);
	}
	
	public String tomar_decisiones(String decision) {
		return "Un miembro de la dirección ha tomado la decisión de: " + decision;
	}
		
	
	
		public void estableceIncentivo(double b){
			
			incentivo=b;
		}
		
		public double dameSueldo() {
			
			double sueldoJefe=super.dame_sueldo();
			
			return sueldoJefe + incentivo;
		}
		
		private double incentivo;
		
		
	}


class Director extends Jefatura{
	
	public Director(String nom, double sue, int año, int mes, int dia) {
		
		super(nom,sue,año,mes,dia);
	}
		
}

