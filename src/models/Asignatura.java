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
    private int cargaAcademica;
    private boolean esRetirada;

    public Asignatura(String id, String nombre, int carga, boolean esRetirada) {
        this.id = id;
        this.nombre = nombre;
        this.cargaAcademica = carga;
        this.esRetirada = esRetirada;
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

    public boolean esRetirada() {
        return esRetirada;
    }

    public void setInclusion(boolean estado) {
        this.esRetirada = estado;
    }

    public int getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(int cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }
    
      @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Asignatura asignatura = (Asignatura) o;
          return Objects.equals(id, asignatura.id)
                  && Objects.equals(nombre, asignatura.nombre)
                  && esRetirada == asignatura.esRetirada;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, esRetirada);
  }
    
}
