import java.util.Scanner;
import java.util.InputMismatchException;

public class Usuario {
    String usuario = "GrupoVictor";
    String senha = "12345";

    public void login(Scanner ler) {
        int limiteTentativas = 3;

        for (int tentativa = 1; tentativa <= limiteTentativas; tentativa++) {

                System.out.println("Digite o usuário: ");
                String usuarioDigitado = ler.nextLine();
                System.out.println("Digite a senha: ");
                String senhaDigitada = ler.nextLine();

            if (usuarioDigitado.equals(usuario) && senhaDigitada.equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return;
            } else {
                int restantes = limiteTentativas - tentativa;
                if (restantes > 0) {
                    System.out.println("Usuário ou senha incorretos! Tentativas restantes: " + restantes);
                } else {
                    System.out.println("Número máximo de tentativas atingido. Programa encerrado.");
                    System.exit(0);
                }
            }
        }
    }
}
