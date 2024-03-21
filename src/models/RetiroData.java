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

/**
 *
 * @author User
 */
public class RetiroData {
    private String id_asignatura;
    private int carga_academica;
    private String id_seccion;

    public RetiroData(String id_asignatura, int carga_academica, String id_seccion) {
        this.id_asignatura = id_asignatura;
        this.carga_academica = carga_academica;
        this.id_seccion = id_seccion;
    }

    public String getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(String id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public int getCarga_academica() {
        return carga_academica;
    }

    public void setCarga_academica(int carga_academica) {
        this.carga_academica = carga_academica;
    }

    public String getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(String id_seccion) {
        this.id_seccion = id_seccion;
    }
    
    
}
