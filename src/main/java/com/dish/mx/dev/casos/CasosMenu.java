package com.dish.mx.dev.casos;

import com.dish.mx.dev.dao.impl.EmpleadoDAOImpl;
import com.dish.mx.dev.dto.EmpleadoDTO;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase en la que definimos métodos para la obtención de datos introducidos por
 * consola por el usuario.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
 *
 * @since 0.0.1
 *
 */
@Component
public class CasosMenu {

    private EmpleadoDTO empleado;
    private List<EmpleadoDTO> imprimir;
    private EmpleadoDTO imprimir2;

    @Autowired
    @Qualifier("empleadoDAOImpl")
    private EmpleadoDAOImpl empDAO;

    private Scanner leer = new Scanner(System.in);

    /**
     * Constructor vacío de la clase
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public CasosMenu() {
    }

    /**
     * Método en el que se le da al usuario la opción de consultar todos los
     * elementos de la base de datos o consultar alguno de acuerdo a un id
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void consultar() {
        //Le imprimimos al usuario las opciones
        System.out.println("Retornar todos los registros de la tabla --> 1");
        System.out.println("Buscar por número de empleado --> 2");
        //Leemos la opción que introdujó el usuario en consola
        int eleccion = getLeer().nextInt();
        if (eleccion == 1) {
            setImprimir(getEmpDAO().encontrarTodos());
            System.out.println(getImprimir());
        } else {
            System.out.print("Ingresa el número del empleado: ");
            int id = getLeer().nextInt();
            setImprimir2(getEmpDAO().encontrarPorId(id));
            System.out.println(getImprimir2());
        }
    }

    /**
     * Método en el que se le piden al usuario datos para insertar un registro
     * en la tabla
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void insertar() {
        EmpleadoDTO empleadoInsertar;
        empleadoInsertar = new EmpleadoDTO();

        System.out.print("Ingresa el número del empleado: ");
        int num = getLeer().nextInt();
        System.out.print("Ingresa el nombre del empleado: ");
        String nom = getLeer().next();
        System.out.print("Ingresa los anios de atiguedad del empleado: ");
        int anti = getLeer().nextInt();
        System.out.print("Ingresa la fecha de ingreso del empleado (aaaa-mm-dd): ");
        String fecha = getLeer().next();
        System.out.print("Ingresa el estatus del empleado: ");
        String estatus = getLeer().next();
//        getEmpDAO().insertarEmpleado(num, nom, anti, fecha, estatus);
        empleadoInsertar.setNumEmpleado(num);
        empleadoInsertar.setNombre(nom);
        empleadoInsertar.setAntiguedad(anti);
        empleadoInsertar.setFechaActualizacion(fecha);
        empleadoInsertar.setActivo(estatus);
        getEmpDAO().insertarEmpleado(empleadoInsertar);
        System.out.println("Empleado registrado!");
        setImprimir(getEmpDAO().encontrarTodos());
        System.out.println(getImprimir());
    }

    /**
     * Método en el que se le piden al usuario datos para actualizar todos o
     * algunos campos del registro.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void actualizar() {
        int numEmp;
        int resp = 0;

        System.out.print("¿Cuál es el número de empleado?: ");
        numEmp = getLeer().nextInt();
        setEmpleado(getEmpDAO().encontrarPorId(numEmp));

        System.out.print("\nNombre actual del empleado: " + getEmpleado().getNombre());
        System.out.print("\nNombre nuevo del empleado (Digite el mismo nombre si no quiere cambiarlo): ");
        getEmpleado().setNombre(getLeer().next());

        System.out.print("\nAntiguedad actual del empleado: " + getEmpleado().getAntiguedad());
        System.out.print("\nAtiguedad nueva del empleado (Digite el mismo número de antiguedad si no quiere cambiarla): ");
        getEmpleado().setAntiguedad(getLeer().nextInt());

        System.out.print("\nFecha actual del empleado: " + getEmpleado().getFechaActualizacion());
        System.out.print("\nNueva fecha de actualización del empleado (Digite la misma fecha si no quiere cambiarla): ");
        getEmpleado().setFechaActualizacion(getLeer().next());

        System.out.print("\nEstatus actual del empleado: " + getEmpleado().getActivo());
        System.out.print("\nNuevo estatus del empleado (Digite el mismo estatus si no quiere cambiarlo): ");
        getEmpleado().setActivo(getLeer().next());

        resp = getEmpDAO().actualizarEmpleado(getEmpleado());
        System.out.println("Empleado actualizado!\n Se actualizaron " + resp + " líneas");
    }

    /**
     * Método en el que se le da al usuario la opción de eliminar todos los
     * elementos de la base de datos o eliminar alguno de acuerdo a un id
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public void eliminar() {
        System.out.println("Eliminar todos los registros de la tabla --> 1");
        System.out.println("Eliminar un registro de la tabla por el número de empleado --> 2");
        //Se guarda la opción elegida por el usuario.
        int elim = getLeer().nextInt();
        if (elim == 1) {
            getEmpDAO().eliminarTodos();
            System.out.println("Todos los empleados han sido eliminados!");
            setImprimir(getEmpDAO().encontrarTodos());
            System.out.println(getImprimir());
        } else {
            System.out.print("Ingrese el número de empleado del registro a eliminar: ");
            //Lee el ID por consola para buscar el registro en la base de datos
            //y lo elimine
            int emp = getLeer().nextInt();
            getEmpDAO().eliminarPorID(emp);
            System.out.println("Empleado eliminado!");
            setImprimir(getEmpDAO().encontrarTodos());
            System.out.println(getImprimir());
        }
    }

    /**
     * @return the empleado
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * @return the imprimir
     */
    public List<EmpleadoDTO> getImprimir() {
        return imprimir;
    }

    /**
     * @return the empDAO
     */
    public EmpleadoDAOImpl getEmpDAO() {
        return empDAO;
    }

    /**
     * @return the imprimir2
     */
    public EmpleadoDTO getImprimir2() {
        return imprimir2;
    }

    /**
     * @return the leer
     */
    public Scanner getLeer() {
        return leer;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * @param imprimir the imprimir to set
     */
    public void setImprimir(List<EmpleadoDTO> imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param empDAO the empDAO to set
     */
    public void setEmpDAO(EmpleadoDAOImpl empDAO) {
        this.empDAO = empDAO;
    }

    /**
     * @param imprimir2 the imprimir2 to set
     */
    public void setImprimir2(EmpleadoDTO imprimir2) {
        this.imprimir2 = imprimir2;
    }

    /**
     * @param leer the leer to set
     */
    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

}
