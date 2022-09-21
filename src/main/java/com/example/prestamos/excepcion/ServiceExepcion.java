package com.example.prestamos.excepcion;

import java.util.function.Supplier;

public class ServiceExepcion extends RuntimeException {

    public ServiceExepcion(String mensaje){
        super (mensaje);
    }
}
