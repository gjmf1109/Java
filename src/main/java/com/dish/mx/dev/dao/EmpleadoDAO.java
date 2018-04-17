package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.EmpleadoDTO;
import java.util.List;

/**
 * Interface que tiene algunos métodos para que se puedan implementar
 * en alguna clase a su conveniencia.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt; gerardo.martinez@dish.com.mx %gt;
 *
 * @since 0.0.1
 *
 */
public interface EmpleadoDAO {

    public List<EmpleadoDTO> encontrarTodos();

    public EmpleadoDTO encontrarPorId(int id);

    public int eliminarTodos();

    public int eliminarPorID(int id);

    public void insertarEmpleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo);

    public void insertarEmpleado(EmpleadoDTO empleado);

    public int actualizarEmpleado(EmpleadoDTO empleado);

}
