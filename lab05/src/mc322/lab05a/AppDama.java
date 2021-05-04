package mc322.lab05a;

public class AppDama {
    public static String[] executaJogo(String caminhoCSV) {
        CSVReader csv = new CSVReader();
	    csv.setDataSource(caminhoCSV);
	    String commands[] = csv.requestCommands();
        String saidas[] = new String[commands.length + 1];
        Tabuleiro tab = new Tabuleiro();

        int posicoesPretasI[] = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        int posicoesPretasJ[] = {1, 3, 5, 7, 0, 2, 4, 6, 1, 3, 5, 7};
        int posicoesBrancasI[] = {5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7};
        int posicoesBrancasJ[] = {0, 2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6};

        for (int i = 0; i < 12; i ++) {
            tab.inserePeao(new Peao("p", posicoesPretasI[i], posicoesPretasJ[i]));
            tab.inserePeao(new Peao("b", posicoesBrancasI[i], posicoesBrancasJ[i]));
        }

        System.out.println("Tabuleiro inicial:");
        saidas[0] = tab.mostraTabuleiro();

        for (int i = 0; i < commands.length; i ++) {
            boolean movimento = tab.executaMovimento(commands[i]);
            System.out.println("Source: " + commands[i].substring(0, 2));
            System.out.println("Target: " + commands[i].substring(3));
            if (movimento == true) {
                saidas[i + 1] = tab.mostraTabuleiro();
            } else {
                saidas[i + 1] = "* Movimento Inválido*";
            }
        }
        return saidas;
    }

    public static void main(String[] args) {
        String caminhoEntrada = args[0];

        String saidas[] = executaJogo(caminhoEntrada);
        System.out.println("--//--//--//--//--//--//--//--//--//--//--//--//--//--//--\n");
        System.out.println("Estado do tabuleiro a cada etapa do movimento: \n");
        for (int i = 0; i < saidas.length; i ++) {
            System.out.println(saidas[i]);
        }
    }
}