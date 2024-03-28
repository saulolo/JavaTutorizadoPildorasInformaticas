package unit2_POO.ejer_4_GettersYSetters_Colegio;
/**
 * @author Saulolo
 */
public class UsoColegio {

    public static void main(String[] args) {

        Colegio colegio1 = new Colegio("Inem", 1000);
        Colegio colegio2 = new Colegio("Loma Linda", 230);

        colegio1.nuevoAlumno("Saul", 4.5);
        colegio1.nuevoAlumno("Alejandra", 2.8);

        colegio2.nuevoAlumno("Ana", 3.8);
        colegio2.nuevoAlumno("Leidy", 4.3);
        colegio2.nuevoAlumno("Diegp", 4.1);
        colegio2.nuevoAlumno("Pablo", 1.5);
        colegio2.nuevoAlumno("Jenny", 1.0);

        colegio2.getTodosAlumnos();

    }
}
