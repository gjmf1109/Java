package com.dish.mx.dev.mapper;

import com.dish.mx.dev.dto.EmpleadoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmpleadoRowMapper implements RowMapper<EmpleadoDTO> {

    @Override
    public EmpleadoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmpleadoDTO(rs.getInt("num_empleado"), rs.getString("nombre"), rs.getInt("antiguedad"),
                rs.getString("fecha_actualizacion"), rs.getString("activo"));
    }
}
