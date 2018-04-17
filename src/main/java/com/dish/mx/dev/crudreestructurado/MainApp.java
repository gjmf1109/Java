package com.dish.mx.dev.crudreestructurado;

import com.dish.mx.dev.casos.CasosMenu;
import com.dish.mx.dev.config.AppConfig;
import com.dish.mx.dev.dao.impl.EmpleadoDAOImpl;
import com.dish.mx.dev.dto.EmpleadoDTO;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String args[]) {
        EmpleadoDTO empleado;
        EmpleadoDAOImpl empDAO;
        CasosMenu casos;
        List<EmpleadoDTO> imprimir;
        EmpleadoDTO imprimir2;
        int a = 1;
        
        //Muestro el menú alusuario con las opciones que puede realizar en la base de datos.
        do {
            System.out.println("¿Que quieres realizar en la base de datos?");
            System.out.println("1.- Consultar a la base");
            System.out.println("2.- Insertar un empleado a la base");
            System.out.println("3.- Actualizar los datos de un empleado");
            System.out.println("4.- Eliminar un empleado de la base");
            System.out.println("5.- Salir");

            //Instanciamos el contexto de spring
            ApplicationContext ctx
                    = new AnnotationConfigApplicationContext(AppConfig.class);
            
            //Obtenemos los bean que vamos a utilizar 
//            empDAO = ctx.getBean(EmpleadoDAOImpl.class);
//            empDAO = (EmpleadoDAOImpl)ctx.getBean("empleadoDAOImpl");
            
            empDAO = ctx.getBean("empleadoDAOImpl2", EmpleadoDAOImpl.class);
            
            casos = ctx.getBean(CasosMenu.class);
//            casos = new CasosMenu();
//            casos.setEmpDAO(empDAO);

            //leemos la opción que eligió el usuario del menú
            Scanner leer = new Scanner(System.in);
            int opcion = leer.nextInt();
            //Con el switch definimos los casos según la opción que elija el usuario.
            switch (opcion) {
                case 1:
                    casos.consultar();
                    a = 1;
                    break;
                case 2:
                    casos.insertar();
                    a = 1;
                    break;
                case 3:
                    casos.actualizar();
                    imprimir = empDAO.encontrarTodos();
                    System.out.println(imprimir);
                    a = 1;
                    break;
                case 4:
                    casos.eliminar();
                    a = 1;
                    break;
                case 5:
                    System.out.println("Saliendo del programa... \n");
                    a = 2;
                    break;
                default:
                    System.out.println("La opción elegida es incorrecta");
                    a = 1;
                    break;
            }

        } while (a == 1);
    }
}
