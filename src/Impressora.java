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
            System.out.println("10 - Abrir gaveta elgin");
            System.out.println("11 - Sinal sonoro (bip)");
            System.out.println("EXTRA - Avançar papel, ver status do papel");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    // Chame o método de configurar conexão aqui
                    break;
                case "2":
                    abrirConexao();
                    break;
                case "3":
                    fecharConexao();
                    break;
                case "4":
                    imprimirTexto();
                    break;
                case "5":
                    imprimirQRcode();
                    break;
                case "6":
                    imprimirCodigoDeBarras();
                    break;
                case "7":
                    imprimirXMLSAT();
                    break;
                case "8":
                    imprimirXMLcancelSAT();
                    break;
                case "9":
                    abrirGaveta();
                    break;
                case "10":
                    abrirGavetaElgin();
                    break;
                case "11":
                    sinalSonoro();
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
            if(conexaoAberta == false){
                System.out.println("Conexão fechada. Abra a conexão antes.");
            }

        } while (!opcao.equals("0"));


    }

    //Método para abrir conexão
    public void abrirConexao(){
        int tipo = 0;
        String modelo = "";
        String conexao = "";
        int parametro = 0;

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
            if (retorno == 0) {
                conexaoAberta = true;
                System.out.println("Conexão aberta com sucesso! Escolha a opção 1 para configurá-la");
            } else {
                System.out.println("Erro ao abrir. Código: " + retorno);
            }
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    //Método para fechar conexão
    public void fecharConexao(){
        int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();

        if (retorno == 0) {
            conexaoAberta = false;
            System.out.println("Conexão fechada com sucesso!");
        } else {
            System.out.println("Erro ao fechar a conexão. Código: " + retorno);
        }
    }

    //Método para imprimir um texto
    public void imprimirTexto(){
        String dados = "";
        int posicao = 0;
        int estilo = 0;
        int tamanho = 0;

        int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(dados, posicao, estilo, tamanho);

        if (retorno == 0) {
            System.out.println("Imprimindo texto!");
        } else {
            System.out.println("Erro ao imprimir texto. Código: " + retorno);
        }
    }

    //Método para imprimir um QRcode
    public void imprimirQRcode(){
        String dados = "";
        int tamanho = 0;
        int nivelCorrecao = 0;

        int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(dados, tamanho, nivelCorrecao);

        if (retorno == 0) {
            System.out.println("Imprimindo QRcode!");
        } else {
            System.out.println("Erro ao imprimir QRcode. Código: " + retorno);
        }
    }

    //Método para imprimir um Código de barras
    public void imprimirCodigoDeBarras(){
        int tipo = 0;
        String dados = "";
        int altura = 0;
        int largura = 0;
        int HRI = 0;

        int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(tipo, dados, altura, largura, HRI);

        if (retorno == 0) {
            System.out.println("Imprimindo Código de barras!");
        } else {
            System.out.println("Erro ao imprimir Código de barras. Código: " + retorno);
        }
    }

    public void imprimirXMLSAT(){
        String dados = "";
        int param = 0;

        int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(dados, param);

        if (retorno == 0) {
            System.out.println("Imprimindo XML SAT!");
        } else {
            System.out.println("Erro ao imprimir. Código: " + retorno);
        }
    }

    public void imprimirXMLcancelSAT(){
        String dados = "";
        String assQRCode = "";
        int param = 0;

        int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(dados, assQRCode, param);

        if (retorno == 0) {
            System.out.println("Imprimindo XML de cancelamento SAT!");
        } else {
            System.out.println("Erro ao imprimir. Código: " + retorno);
        }
    }

    public void abrirGaveta(){
        int pino = 0;
        int ti = 0;
        int tf = 0;

        int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(pino, ti, tf);

        if (retorno == 0) {
            System.out.println("Abrindo gaveta!");
        } else {
            System.out.println("Erro ao abrir gaveta. Código: " + retorno);
        }
    }

    public void abrirGavetaElgin(){
        int pino = 0;
        int ti = 0;
        int tf = 0;

        int retorno = ImpressoraDLL.INSTANCE.AbreGavetaElgin(pino, ti, tf);

        if (retorno == 0) {
            System.out.println("Abrindo gaveta Elgin!");
        } else {
            System.out.println("Erro ao abrir gaveta Elgin. Código: " + retorno);
        }
    }

    public void sinalSonoro(){
        int quantidade = 0;

        int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(quantidade, 50, 5);
        if (retorno == 0) {
            System.out.println("Bip!");
        } else {
            System.out.println("Erro no sinal sonoro. Código: " + retorno);
        }
    }
}
