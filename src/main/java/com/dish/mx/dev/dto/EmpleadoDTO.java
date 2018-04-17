package com.dish.mx.dev.dto;

/**
 * Clase en la que definimos los atributos de la tabla a manipular en la base de
 * datos.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
public class EmpleadoDTO {

    private int numEmpleado;
    private String nombre;
    private int antiguedad;
    private String fechaActualizacion;
    private String activo;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public EmpleadoDTO() {

    }

    /**
     * Constructor de la clase con argumentos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param num_empleado
     * @param nombre
     * @param antiguedad
     * @param fecha
     * @param activo
     *
     * @since 0.0.1
     */
    public EmpleadoDTO(int num_empleado, String nombre, int antiguedad, String fecha, String activo) {
        this.numEmpleado = num_empleado;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.fechaActualizacion = fecha;
        this.activo = activo;
    }

    /**
     * @return the numEmpleado
     */
    public int getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the antiguedad
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * @return the fechaActualizacion
     */
    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @return the activo
     */
    public String getActivo() {
        return activo;
    }

    /**
     * @param numEmpleado the numEmpleado to set
     */
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param antiguedad the antiguedad to set
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(String activo) {
        this.activo = activo;
    }

    //Método con la estructura para imprimir mis resultados
    @Override
    public String toString() {
        return "numEmpleado=" + numEmpleado + "\tnombre=" + nombre + "\tantiguedad=" + antiguedad + "\tfechaActualizacion=" + fechaActualizacion + "\tactivo=" + activo + "\n";
    }
}
