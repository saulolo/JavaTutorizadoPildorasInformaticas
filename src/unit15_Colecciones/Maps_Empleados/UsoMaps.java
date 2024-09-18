package unit15_Colecciones.Maps_Empleados;

import java.util.HashMap;
import java.util.Map;

public class UsoMaps {

    public static void main(String[] args) {

        HashMap<String, EmpleadosMaps> listaEmpleados = new HashMap<>();
        listaEmpleados.put("1", new EmpleadosMaps("Saul"));
        listaEmpleados.put("2", new EmpleadosMaps("Eliany"));
        listaEmpleados.put("3", new EmpleadosMaps("Felipe"));
        listaEmpleados.put("4", new EmpleadosMaps("Alejandra"));

        System.out.println(listaEmpleados);

        //Eliminar objeto con remove
        listaEmpleados.remove("1");

        //Sobreescribir un Objeto
        listaEmpleados.put("4", new EmpleadosMaps("Leidy"));

        System.out.println(listaEmpleados);

        //EntrySet
        for (Map.Entry<String, EmpleadosMaps> personaEmpleado : listaEmpleados.entrySet()) {
            String clave = personaEmpleado.getKey();
            EmpleadosMaps valor = personaEmpleado.getValue();
            System.out.println("Clave: " + clave + " Valor: " + valor);
        }
    }
}
