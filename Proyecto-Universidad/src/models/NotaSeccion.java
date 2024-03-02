package models;

public class NotaSeccion {

	private Seccion seccion;
	private NotaEstudiante notaEstudiante;
	
	public NotaSeccion(Seccion seccion ,NotaEstudiante notaEstudiante) {
		this.seccion=  seccion;
		this.notaEstudiante= notaEstudiante;
	}
	
	public Seccion getSeccion(){
		return seccion;
	}
	
	public NotaEstudiante getNotaEstudiante() {
		return notaEstudiante;
	}
	
}
