package unit2_POO.ejer_5_GettersCastingConstructor_Contrasenias;

/**
 * @author Sualolo
 * @ejercicio:
 * En este ejercicio debemos crear una clase que genere contraseñas aleatorias compuestas
 * por letras mayúsculas, minúsculas y números. Dichas contraseñas serán de la longitud que
 * quiera el usuario y dicha longitud se le pedirá por teclado desde una ventana JOptionPane.
 * Las contraseñas se almacenarán en un Array cuyo tamaño también se le pedirá al usuario por
 * teclado a través de una ventana JOptionPane.
 * Recapitulando, al ejecutar el programa este pedirá al usuario el tamaño del Array
 * (imaginemos que el usuario introduce 4) y la longitud de las contraseñas (imaginemos
 * que el usuario introduce 7). El programa deberá generar entonces 4 contraseñas de 7
 * caracteres cada una.
 * El programa imprimirá en consola todas las contraseñas generadas, el nº de caracteres de
 * cada una de ellas y si la contraseña es segura o débil en función de la siguiente condición:
 * - Se considerará contraseña segura aquella que esté formada por más de cinco números,
 * tenga más de una letra minúscula y más de dos letras mayúsculas.
 * Como siempre, hay infinitas formas de hacer esta aplicación, pero en este caso se pide
 * que el programa tenga:
 * - Una clase que construya las contraseñas y una clase principal
 * - La clase que construya las contraseñas deberá tener:
 * - Un constructor (diferente del constructor por defecto)
 * - Dos métodos getters. Uno devolverá la contraseña generada y el otro la longitud de la misma.
 * - Un método encargado de generar (construir) la contraseña.
 * - Un método que evalúe y devuelva si la contraseña es segura o débil en función de las
 * condiciones antes descritas.
 * PARA REALIZAR ESTE EJERCICIO VAS A TENER QUE CONSULTAR LOS CÓDIGOS ASCII DE LAS LETRAS
 * DEL ABACEDARIO Y NÚMEROS DEL 1 AL 9. PUEDES ENCONTRARLOS AQUÍ:
 * @url: http://www.elcodigoascii.com.ar/codigos-ascii/letra-a-mayuscula-codigo-ascii-65.html
 */

public class CreaPassword {


    //Atributos
    private int longitud;
    private String password;


    //Constructor
    public CreaPassword(int longitud ) {
        this.longitud = longitud;
        password = generaPassword();
    };


    //Getter and Setters
    public int getLongitud() {
        return longitud;
    }


    public String getPassword() {
        return password;
    }


    //Métodos
    public String generaPassword() {

        String password = "";

        for (int i = 0; i < longitud; i++) {
            //Generamos un número aleatorio de 1 -3 inclusives y en función del mismo, genera mayusculas, minusculas o número.
            int mayusMinus = (int) (Math.random() * 3 + 1);

            if (mayusMinus == 1) {
                char minusculas = (char) ((int) (Math.random() * (123 - 97) + 97));
                password = password + minusculas;
            }
            else if (mayusMinus == 2) {
                char mayusculas = (char) ((int) (Math.random() * (91 - 965) + 65));
                password+= mayusculas;
            }
            else {
                char numeros = (char) ((int) (Math.random() * (58 - 48) + 48));
                password = password + numeros;
            }
        }
        return password;
    }

    public String esSegura() {
        int numeros = 0;
        int minusculas = 0;
        int mayusculas = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
             minusculas = minusculas + 1;
            }
            else if (Character.isUpperCase(password.charAt(i))) {
                mayusculas = mayusculas + 1;
            }
            else {
                numeros = numeros + 1;
            }
        }

        if (numeros > 5 && minusculas >= 1 && mayusculas >= 2) {
            return "Contraseña segura";
        } else {
            return "Contraseña debil";
        }

    }


}
