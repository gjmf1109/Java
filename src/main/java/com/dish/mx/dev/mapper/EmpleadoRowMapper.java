package com.dish.mx.dev.mapper;

import com.dish.mx.dev.dto.EmpleadoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Clase en la que se obtienen los datos de la clase Empleado y los retorna para
 * poder utilizarlos en donde sean requeridos.
 *
 * @version 0.0.1
 *
 * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx%gt;
 *
 * @since 0.0.1
 *
 */
public class EmpleadoRowMapper implements RowMapper<EmpleadoDTO> {

    /**
     * El método recibe una variable del tipo ResultSet y un int, con estos 
     * argumentos recorre la tabla dela base de datos y va recogiendo los datos.
     *
     * @param rs
     * @param rowNum
     * 
     * @return Regresa un objeto del tipo EmpleadoDTO con los registros obtenidos
     * de la base de datos.
     *
     * @author Gerardo Martinez &lt;gerardo.martinez@dish.com.mx&gt;
     * 
     * @throws java.sql.SQLException
     *
     * @since 0.0.1
     */
    @Override
    public EmpleadoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmpleadoDTO(rs.getInt("num_empleado"), rs.getString("nombre"), rs.getInt("antiguedad"),
                rs.getString("fecha_actualizacion"), rs.getString("activo"));
    }
}
