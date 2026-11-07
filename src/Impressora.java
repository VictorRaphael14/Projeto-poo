import java.util.Scanner;
import java.util.InputMismatchException;

public class Impressora {
    boolean conexaoAberta = false;

    public void mostrarMenu(Scanner ler){
        String opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Abrir conexão");
            System.out.println("2 - Fechar conexão");
            System.out.println("3 - Imprimir texto");
            System.out.println("4 - Imprimir QR Code");
            System.out.println("5 - Imprimir código de barras");
            System.out.println("6 - Imprimir XML SAT");
            System.out.println("7 - Imprimir XML de cancelamento SAT");
            System.out.println("8 - Abrir gaveta");
            System.out.println("9 - Abrir gaveta elgin");
            System.out.println("10 - Sinal sonoro (bip)");
            System.out.println("EXTRA - Avançar papel, ver status do papel");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    abrirConexao();
                    break;
                case "2":
                    fecharConexao();
                    break;
                case "3":
                    imprimirTexto(ler);
                    break;
                case "4":
                    imprimirQRcode(ler);
                    break;
                case "5":
                    imprimirCodigoDeBarras();
                    break;
                case "6":
                    imprimirXMLSAT();
                    break;
                case "7":
                    imprimirXMLcancelSAT();
                    break;
                case "8":
                    abrirGaveta();
                    break;
                case "9":
                    abrirGavetaElgin();
                    break;
                case "10":
                    sinalSonoro();
                    break;
                case "EXTRA":
                    avancarPapel(ler);
                    verStatus(ler);
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
        int param = 0;

        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, param);
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
    public void imprimirTexto(Scanner ler){
        String dados;
        int posicao;
        int estilo;
        int tamanho;

        try{
            System.out.println("Digite o texto que deseja imprimir: ");
            dados = ler.nextLine();
            System.out.println("Digite a posição (0 - esquerda, 1 - centro, 2 - direita): ");
            posicao = ler.nextInt();
            System.out.println("Digite o estilo do texto (0 - fonte A, 1 - fonte B, 2 - sublinhado, 4 - invertido, 8 - negrito): ");
            estilo = ler.nextInt();
            System.out.println("Digite o tamanho do texto (0 - normal, 1 a 7 - altura maior): ");
            tamanho = ler.nextInt();
            ler.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Tipo de dado inválido!");
            return;
        }
        int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(dados, posicao, estilo, tamanho);

        if (retorno == 0) {
            System.out.println("Imprimindo texto!");
        } else {
            System.out.println("Erro ao imprimir texto. Código: " + retorno);
        }
    }

    //Método para imprimir um QRcode
    public void imprimirQRcode(Scanner ler){
        String dados;
        int tamanho;
        int nivelCorrecao;

        try{
            System.out.println("Digite o conteúdo do QRCode: ");
            dados = ler.nextLine();
            System.out.println("Digite o tamanho (1 a 6): ");
            tamanho = ler.nextInt();
            System.out.println("Digite o nível de correção (1 a 4 - quanto maior, mais resistente a falhas): ");
            nivelCorrecao = ler.nextInt();
            ler.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Tipo de dado inválido!");
            return;
        }

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

    public void avancarPapel(Scanner ler){
        int linhas;

        try{
            System.out.println("Quantas linhas deseja avançar: ");
            linhas = ler.nextInt();
            ler.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Tipo de dado inválido!");
            return;
        }

        int retorno = ImpressoraDLL.INSTANCE.AvancaPapel(linhas);

        if (retorno == 0) {
            System.out.println("Avançando papel!");
        } else {
            System.out.println("Erro ao avançar o papel. Código: " + retorno);
        }
    }
    public void verStatus(Scanner ler){
        int param;

        try{
            System.out.println("Escolha um parâmetro (1 - Gaveta, 2 - Tampa, 3 - Papel, 5 - Geral. Para o param 3: 5 - Tem papel, 6 - Acabando, 7 - Sem papel): ");
            param = ler.nextInt();
            ler.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Tipo de dado inválido!");
            return;
        }

        int retorno = ImpressoraDLL.INSTANCE.StatusImpressora(param);

        if (retorno == 0) {
            System.out.println("Status da impressora!");
        } else {
            System.out.println("Erro ao ver status da impressora. Código: " + retorno);
        }
    }
}
