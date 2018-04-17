package com.dish.mx.dev.config;

import com.dish.mx.dev.dao.EmpleadoDAO;
import com.dish.mx.dev.dao.impl.EmpleadoDAOImpl;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//Ruta donde buscará el archivo properties para  poder obtener los datos necesarios
//para conectarse a la base de datos.
@PropertySource("classpath:db.properties")
@ComponentScan("com.dish.mx.dev")

public class AppConfig {
    
    /**
     * 
     * @param env
     * @return 
     */
    @Bean//(destroyMethod = "close")
    //Interface para realizar la conexión a la base de datos.
    DataSource dataSource(Environment env) {
        //Creamos el objeto para poder utilizar sus métodos y conectarnos a la base de datos
        //ComboPooledDataSource ds = new ComboPooledDataSource();
        DriverManagerDataSource ds = new DriverManagerDataSource();
        try {
            //Obtiene la dependencia donde se encuentra el driver para conectarse a la base de datos MySQL
            ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        } catch (Exception ex) {
            throw new RuntimeException(
                    "error while setting the driver class name in the datasource", ex);
        }
        //Obtengo los datos de mi archivo properties
        ds.setUrl(env.getRequiredProperty("jdbc.url"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));
        
        return ds;
    }

    //Creo mis Bean para poder llamarlos desdde mi MainApp
    //Estos se cargarán al contexto de Spring para cuando requiera utilizarlos
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
//    @Bean
//    JdbcTemplate jdbcTemplate2(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean("empleadoDAOImpl2")
    EmpleadoDAO empleadoDAOImpl(JdbcTemplate jdbcTemplate){
        EmpleadoDAOImpl dao = new EmpleadoDAOImpl();
        dao.setJdbcTemplate(jdbcTemplate);
        return dao;
//        return new EmpleadoDAOImpl(jdbcTemplate);
    }
    
//    @Bean
//    CasosMenu menuEmpDao(EmpleadoDAOImpl empDAO){
//        CasosMenu cm = new CasosMenu();
//        
//        cm.setEmpDAO(empDAO);
//        
//        return cm;
//    }
}
