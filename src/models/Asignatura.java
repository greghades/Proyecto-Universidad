/*
 Ernesto Contreras
28245373

Albani barragán
28268078

Luis Carrillo
27539960

Gregori Yepez 
28047103

Yaslin Vreugdenhil.
29561929
 */

package models;

import java.util.Objects;

/**
 *
 * @author 58412
 */
public class Asignatura {
    private String id;
    private String nombre;
    private int creditos;
    private String pre_requisito;
    private boolean inclusion = false;
    private String seccion;

    public Asignatura(String id, String nombre, int creditos, String pre_requisito, String seccion) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.pre_requisito = pre_requisito;
        this.seccion = seccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getPre_requisito() {
        return pre_requisito;
    }

    public void setPre_requisito(String pre_requisito) {
        this.pre_requisito = pre_requisito;
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
    Asignatura asignatura = (Asignatura) o;
    return creditos == asignatura.creditos &&
            inclusion == asignatura.inclusion &&
            Objects.equals(nombre, asignatura.nombre) &&
            Objects.equals(seccion, asignatura.seccion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, creditos, inclusion, seccion);
  }
    
}
