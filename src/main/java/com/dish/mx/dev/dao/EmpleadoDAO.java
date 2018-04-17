package com.dish.mx.dev.dao;

import com.dish.mx.dev.dto.EmpleadoDTO;
import java.util.List;

//Clase que tiene los métodos que implementare en EmpleadoDAOImpl
//es por eso que ninguno tiene implementación, ya que se trata de una interface
public interface EmpleadoDAO {
            
    public List<EmpleadoDTO> encontrarTodos();
    
    public EmpleadoDTO encontrarPorId(int id);
    
    public int eliminarTodos();
    
    public int eliminarPorID(int id);
    
    public void insertarEmpleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo);
    
    public void insertarEmpleado(EmpleadoDTO empleado);
    
    public int actualizarEmpleado(EmpleadoDTO empleado);
        
}
