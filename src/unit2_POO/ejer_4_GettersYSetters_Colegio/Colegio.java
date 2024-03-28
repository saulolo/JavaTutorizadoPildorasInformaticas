package unit2_POO.ejer_4_GettersYSetters_Colegio;
/**
 * @author Sualolo
 * @Ejercicio:
 * Construir un 2 objetos que pidan el nombre del colegio, cantidad de alumnos del colegio
 * cada uno.
 * - Declarar un método para incluir alumnos en dichos colegios, el cual va a recibir
 * dos parametros: el nombre del alumno y su nota, me debe permitir llenar la totalidad
 * de alumnos o los que quiera ingresar.
 * - Crear un métddo que pueda mostrar la totalidad de alumnos inscritos en el colegio.
 * - Crear un métddo que pueda mostrar los datos de un alumno en concreto, que reciba por
 * parametro el nombre del alumno.
 * - Crear un método que le asigne un numero consecutivo a cada alumno
 * - Crear un método que me permita expulsar un alumno de un colegio pasandole su nombre
 * como parámetro.
 * - Crear un método que me permita cambiar la nota media de un alumno, pasandole por
 * parámetro el nombre del alumno y la nueva nota media.
 * Me deve de mostar en consola un mensaje como:
 * - Nombre alumno: Juan
 * - Colegio: San Javier
 * - Nro Alumno: 1
 * - Nota media: 8.5
 */
public class Colegio {

    //Atributos
    private String nombre; //Nombre del colegio
    private Alumno arrayAlumnos[]; //Para almacenar muchos datos lo hago en un array
    private int posiciómArray = 0; //Para almacenar la variable en la posición cero


    //Constructor
    public Colegio(String nombre, int numAlumnos) {
        this.nombre = nombre; //Pongo el this porque la variable tiene el mismo nombre que el parámetro.
        arrayAlumnos = new Alumno[numAlumnos]; //no pongo this porque la variable no tiene el mismo nombre que el parámetro.
    }

    //Getter and Setter
    public String getNombreColegio() {
        return nombre;
    }


    private Alumno getAlumno(int nAlumno) { //nAlumno posición del array de un alumno
        return arrayAlumnos[nAlumno]; //Al pasarle la posicisión me devolvera los datos del alumno
    }

    //Construye le nuevo alumno
    public void nuevoAlumno(String nombreAlumno, double notaAlumno) {
        Alumno nuevoAlumno = new Alumno(nombreAlumno, this.getNombreColegio(), notaAlumno);
        arrayAlumnos[posiciómArray] = nuevoAlumno;
        posiciómArray++; //La incremento de poscición para que valga uno
    }

    public void expulsaAlumno(String nombreAlumno) {
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (this.getAlumno(i) != null) {//En caso de que el alumno exixta en esa posición...
                if (arrayAlumnos[i].getNombreAlumno().equals(nombreAlumno)) {//..llamo al metodo obtener nombre y si es igual al que le paso por parametro...
                    arrayAlumnos[i] = null;//.. igualandolo a null lo elimino
                }
            }
        }
    }

    public void setNotaMedia(String nombreAlumno, double nuevaNotaMedia) {
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (this.getAlumno(i) != null) {
                if (arrayAlumnos[i].getNombreAlumno().equals(nombreAlumno)) {
                    arrayAlumnos[i].setNotaMedia(nuevaNotaMedia); //utilizo el método setnotamedia para establecer una nota media nueva.
                }
            }
        }
    }

    //Metodo que imprime a cada vuelta del bucle los datos de todos los alumnos
    public void getTodosAlumnos() {
        for (int i = 0; i < arrayAlumnos.length; i++) {
            if (this.getAlumno(i) != null) {
                System.out.println(this.getAlumno(i));
                System.out.println();
            }
        }
    }

    //Metodo que imprime a cada vuelta del bucle los datos de un alumno
    public void getDatosAlumnos(String nombreAlumno) {
        for (int i = 0; i <arrayAlumnos.length; i++) {
            if (this.getAlumno(i) != null) {
                if (arrayAlumnos[i].getNombreAlumno().equals(nombreAlumno)) {
                    System.out.println(this.getAlumno(i));
                    System.out.println();
                }
            }
        }
    }

}
