


package models;

public class NotaEstudiante {
	
	private float calificacion;
	private PeriodoAcademico periodoAcademico;
	private Asignatura asignatura;

	
	public NotaEstudiante(float calificacion,PeriodoAcademico periodoAcademico,
			Asignatura asignatura) {
		this.calificacion = calificacion;
		this.periodoAcademico= periodoAcademico;
		this.asignatura= asignatura;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public PeriodoAcademico getPeriodoAcademico() {
		return periodoAcademico;
	}
	public Asignatura asignatura() {
		return asignatura;
	}
}
