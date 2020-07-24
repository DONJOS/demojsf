/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 *
 * @author Administrador
 */
public class Registro {

    private int id;
    public String nombres;
    private String apellidos;
    private String tipoDocumento;
    private int numeroDocumento;

    public Registro() {
        this.id = 0;
    }

    public Registro(int id, String nombres, String apellidos, String tipoDocumento, int numeroDocumento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }
}
