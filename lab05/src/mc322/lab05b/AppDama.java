package mc322.lab05b;

public class AppDama {
    public static String[] executaJogo(String caminhoEntrada, String caminhoSaida) {
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminhoEntrada);
        
        String comandos[] = csv.requestCommands();
        String saidas[] = new String[comandos.length + 1];
        
        Tabuleiro tab = new Tabuleiro();

        int posicoesBrancasI[] = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        int posicoesBrancasJ[] = {1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7};
        int posicoesPretasI[] = {5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7};
        int posicoesPretasJ[] = {0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6};
        
        for (int i = 0; i < 12; i ++) {
            tab.inserePeca(new Peao("b", posicoesBrancasI[i], posicoesBrancasJ[i]));
            tab.inserePeca(new Peao("p", posicoesPretasI[i], posicoesPretasJ[i]));
        }

        System.out.println("Tabuleiro inicial:");
        saidas[0] = tab.imprimirTabuleiro();
        
        for (int i = 0; i < comandos.length; i ++) {
            boolean movimento = tab.solicitaMovimento(comandos[i]);
            if (movimento == true) {
                System.out.println("Source: " + comandos[i].substring(0, 2));
                System.out.println("Target: " + comandos[i].substring(3));
                saidas[i + 1] = tab.imprimirTabuleiro();
            } else {
                System.out.println("Movimento Inválido!\n");
                saidas[i + 1] = "erro";
            }
        }

        tab.exportarArquivo(caminhoSaida);
        return saidas;
    }

    public static void main(String[] args) {
        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];

        String saidas[] = executaJogo(caminhoEntrada, caminhoSaida);
        System.out.println("--//--//--//--//--//--//--//--//--//--//--//--//--//--//--\n");
        System.out.println("Estado do tabuleiro a cada etapa do movimento: \n");
        for (int i = 0; i < saidas.length; i ++) {
            System.out.println(saidas[i]);
        }
    }
}