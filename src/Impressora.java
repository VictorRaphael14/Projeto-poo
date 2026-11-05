import java.util.Scanner;
import java.util.InputMismatchException;

public class Impressora {
    boolean conexaoAberta = false;

    public void mostrarMenu(Scanner ler){
        String opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Configurar conexão");
            System.out.println("2 - Abrir conexão");
            System.out.println("3 - Fechar conexão");
            System.out.println("4 - Imprimir texto");
            System.out.println("5 - Imprimir QR Code");
            System.out.println("6 - Imprimir código de barras");
            System.out.println("7 - Imprimir XML SAT");
            System.out.println("8 - Imprimir XML de cancelamento SAT");
            System.out.println("9 - Abrir gaveta");
            System.out.println("10 - Sinal sonoro (bip)");
            System.out.println("EXTRA - Avançar papel, ver status do papel");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    // Chame o método de configurar conexão aqui
                    break;
                case "2":
                    // Chame o método de abrir conexão aqui
                    break;
                case "3":
                    // Chame o método de fechar conexão aqui
                    break;
                case "4":
                    // Chame o método de imprimir texto aqui
                    break;
                case "5":
                    // Chame o método de imprimir QR Code aqui
                    break;
                case "6":
                    // Chame o método de imprimir código de barras aqui
                    break;
                case "7":
                    // Chame o método de imprimir XML SAT aqui
                    break;
                case "8":
                    // Chame o método de imprimir XML de cancelamento SAT aqui
                    break;
                case "9":
                    // Chame o método de abrir gaveta aqui
                    break;
                case "10":
                    // Chame o método de sinal sonoro aqui
                    break;
                case "EXTRA":
                    // Chame o método de sinal sonoro aqui
                    break;
                case "0":
                    System.out.println("Saíndo do programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            if (conexaoAberta == false) {
                System.out.println("Conexão fechada. Abra a conexão antes.");
            }

        } while (!opcao.equals("0"));


    }
}
