import com.unc.proyecto.maven.Main;
import com.unc.proyecto.maven.matematicas.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Calculadora calc = new Calculadora();
        System.out.println(calc.suma(8, 8));
        System.out.println("==================================");
        Main.main(null);
        System.out.println("==================================");
        System.out.println("TERMINO!!!!");
    }
}
