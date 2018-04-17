package com.dish.mx.dev.dao.impl;

import com.dish.mx.dev.dao.EmpleadoDAO;
import com.dish.mx.dev.dto.EmpleadoDTO;
import com.dish.mx.dev.mapper.EmpleadoRowMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empleadoDAOImpl")
public class EmpleadoDAOImpl implements EmpleadoDAO{
    private static final Logger logger = LogManager.getLogger(EmpleadoDAOImpl.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    //Constructor vacío
    public EmpleadoDAOImpl() {
    }

    //Método para poder utilizar la variable jdbcTemplate y sus métodos 
//    public EmpleadoDAOImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //Leer a la base de datos
    @Override
    public List<EmpleadoDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM empleado", new EmpleadoRowMapper());
    }

    //Leer base ingresando por ID
    @Override
    public EmpleadoDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicad
        //En este caso del tipo de nuestra clase EmpleadoRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM empleado WHERE num_empleado = ?", new Object[]{id},
                new EmpleadoRowMapper());
    }

    //Eliminar todos los registros de la tabla
    @Override
    public int eliminarTodos() {
        return getJdbcTemplate().update("DELETE from empleado");
    }

    //Eliminar registros de la tabla deacuerdo al ID
    @Override
    public int eliminarPorID(int id) {
        return getJdbcTemplate().update("DELETE FROM empleado WHERE num_empleado = ?", id);
    }

    //Insertar empleados a la tabla
    @Override
    public void insertarEmpleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo) {
        getJdbcTemplate().update("INSERT INTO empleado (num_empleado, nombre, antiguedad, fecha_actualizacion, activo) "
                + "VALUES(?,?,?,?,?)", num_empleado, nombre, antiguedad, fecha, activo);
    }
    
    

    //Actualizar datos a la tabla
    @Override
    public int actualizarEmpleado(EmpleadoDTO empleado) {
        int resp = 0;
        
        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE empleado SET nombre = ?, "
                + "antiguedad = ?, fecha_actualizacion = ?, activo = ? "
                + "WHERE  num_empleado= ?", new Object[]{empleado.getNombre(),empleado.getAntiguedad(), 
                    empleado.getFechaActualizacion(), empleado.getActivo(), empleado.getNumEmpleado()});
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertarEmpleado(EmpleadoDTO empleado) {
        getJdbcTemplate().update("INSERT INTO empleado (num_empleado, nombre, antiguedad, fecha_actualizacion, activo) "
                + "VALUES(?,?,?,?,?)", empleado.getNumEmpleado(), empleado.getNombre(), empleado.getAntiguedad(),
                empleado.getFechaActualizacion(), empleado.getActivo());
    }
   
}
