/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Objects;

/**
 *
 * @author User
 */

public class Subject {
  private String materia;
  private int cargaAcademica;
  private boolean inclusion;
  private String seccion;

  // Getters, setters, and constructor (omitted for brevity)

    public Subject(String materia, int cargaAcademica, boolean inclusion, String seccion) {
        this.materia = materia;
        this.cargaAcademica = cargaAcademica;
        this.inclusion = inclusion;
        this.seccion = seccion;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(int cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public boolean isInclusion() {
        return inclusion;
    }

    public void setInclusion(boolean inclusion) {
        this.inclusion = inclusion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Subject subject = (Subject) o;
    return cargaAcademica == subject.cargaAcademica &&
            inclusion == subject.inclusion &&
            Objects.equals(materia, subject.materia) &&
            Objects.equals(seccion, subject.seccion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(materia, cargaAcademica, inclusion, seccion);
  }
}
