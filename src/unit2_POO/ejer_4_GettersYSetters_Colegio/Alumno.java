package unit2_POO.ejer_4_GettersYSetters_Colegio;
/**
 * @author Saulolo
 */
public class Alumno {

    private String nombreAlumno;
    private String nombreColegio;
    private double notaMedia;
    private int nAlumno;
    private static int numeroAlumno = 1;


    //Constructor
    public Alumno(String nombreAlumno, String nombreColegio, double notaMedia) {
        this.nombreAlumno = nombreAlumno;
        this.nombreColegio = nombreColegio;
        this.notaMedia = notaMedia;
        nAlumno = numeroAlumno;
        numeroAlumno++;
    }

    //Getters and Setters
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    private String getNombreColegioAlumno() {
        return this.nombreColegio;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }


    //toString
    public String toString() {
        return "Nombre alumno: " + nombreAlumno + "\n" +
                "Colegio: '" + this.getNombreColegioAlumno() + "\n" +
                "Nota media: " + notaMedia + "\n" +
                "Nro ALumno: " + nAlumno;
    }

}
