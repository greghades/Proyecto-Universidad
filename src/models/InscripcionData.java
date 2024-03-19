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

public class InscripcionData {

    private String id_estudiante;
    private String id_asignatura;
    private String id_periodo;
    private String id_seccion;

    public InscripcionData(String id_estudiante, String id_asignatura, String id_periodo, String id_seccion) {
        this.id_estudiante = id_estudiante;
        this.id_asignatura = id_asignatura;
        this.id_periodo = id_periodo;
        this.id_seccion = id_seccion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InscripcionData other = (InscripcionData) obj;
        return Objects.equals(id_estudiante, other.id_estudiante)
                && Objects.equals(id_asignatura, other.id_asignatura)
                && Objects.equals(id_periodo, other.id_periodo)
                && Objects.equals(id_seccion, other.id_seccion);
    }

    public String getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(String id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(String id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(String id_seccion) {
        this.id_seccion = id_seccion;
    }
}
