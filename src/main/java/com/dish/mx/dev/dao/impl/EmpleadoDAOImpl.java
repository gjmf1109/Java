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

/**
 * Clase en la que se implementan la interface EmpleadoDAO con todos los métodos
 * que ejecutan los querys para el manejo de los datos de la base.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
@Repository("empleadoDAOImpl")
public class EmpleadoDAOImpl implements EmpleadoDAO {

    private static final Logger logger = LogManager.getLogger(EmpleadoDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor vacío de la clase.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    public EmpleadoDAOImpl() {
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos
     *
     * @return Regresa una lista con los registros obtenidos por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public List<EmpleadoDTO> encontrarTodos() {
        return getJdbcTemplate().query("SELECT * FROM empleado", new EmpleadoRowMapper());
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos según el id introducido
     *
     * @param id
     * @return Regresa un objeto del tipo Empleado con los registros obtenidos
     * por el query
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     *
     * @since 0.0.1
     */
    @Override
    public EmpleadoDTO encontrarPorId(int id) {
        //Ejecuta la consulta y nos regresa un objeto del tipo indicad
        //En este caso del tipo de nuestra clase EmpleadoRowMapper
        return getJdbcTemplate().queryForObject("SELECT * FROM empleado WHERE num_empleado = ?", new Object[]{id},
                new EmpleadoRowMapper());
    }

    /**
     * El método ejecuta un query para poder eliminar todos los registros de la
     * base de datos
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarTodos() {
        return getJdbcTemplate().update("DELETE from empleado");
    }

    /**
     * El método ejecuta un query para poder obtener todos los registros de la
     * base de datos de acuerdo al id introducido.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param id
     * @return Regresa el número de filas eliminadas.
     *
     * @since 0.0.1
     */
    @Override
    public int eliminarPorID(int id) {
        return getJdbcTemplate().update("DELETE FROM empleado WHERE num_empleado = ?", id);
    }

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos de acuerdo a los datos que se le pasan en los argumentos del mismo.
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
    @Override
    public void insertarEmpleado(int num_empleado, String nombre, int antiguedad, String fecha, String activo) {
        getJdbcTemplate().update("INSERT INTO empleado (num_empleado, nombre, antiguedad, fecha_actualizacion, activo) "
                + "VALUES(?,?,?,?,?)", num_empleado, nombre, antiguedad, fecha, activo);
    }

    /**
     * El método ejecuta un query para poder actualizar todos los registros de
     * la base de datos de acuerdo a los datos que el usuario proporcione
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * @param empleado
     * @return Regresa el número de filas actualizadas.
     *
     * @since 0.0.1
     */
    @Override
    public int actualizarEmpleado(EmpleadoDTO empleado) {
        int resp = 0;

        //Un update me regresa el número de filas actualizadas, es por eso
        //que el resultado es asignado a una variable de tipo int.
        return resp = getJdbcTemplate().update("UPDATE empleado SET nombre = ?, "
                + "antiguedad = ?, fecha_actualizacion = ?, activo = ? "
                + "WHERE  num_empleado= ?", new Object[]{empleado.getNombre(), empleado.getAntiguedad(),
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

    /**
     * El método ejecuta un query para poder insertar registros en la base de
     * datos, se le pasa una variable de tipo EmpleadoDTO, para después obtener 
     * los datos de esta variable con los métodos getters y setters.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @param empleado
     *
     * @since 0.0.1
     */
    @Override
    public void insertarEmpleado(EmpleadoDTO empleado) {
        getJdbcTemplate().update("INSERT INTO empleado (num_empleado, nombre, antiguedad, fecha_actualizacion, activo) "
                + "VALUES(?,?,?,?,?)", empleado.getNumEmpleado(), empleado.getNombre(), empleado.getAntiguedad(),
                empleado.getFechaActualizacion(), empleado.getActivo());
    }

}
