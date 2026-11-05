import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //Cria um objeto Usuario
        Usuario usuario1 = new Usuario();

        //Chama a função de login presente na classe Usuario
        usuario1.login(ler);

        //Cria um objeto Impressora
        Impressora impressora1 = new Impressora();

        //Apresenta o menu através de uma função da classe Impressora
        impressora1.mostrarMenu(ler);

    }
}
