package mc322.lab04;

public class AppRestaUm {
    // Lê o arquivo CSV indicado e executa o jogo 
    public static String[] executaJogo(String caminhoCSV) {
        CSVReader csv = new CSVReader();
	    csv.setDataSource(caminhoCSV);
	    String commands[] = csv.requestCommands();
        String saidas[] = new String[commands.length + 1];
        Tabuleiro tab = new Tabuleiro();

        System.out.println("Tabuleiro inicial:");
        saidas[0] = tab.mostraTabuleiro();
        for (int i = 0; i < commands.length; i ++) {
            tab.executaMovimento(commands[i]);
            System.out.println("Source: " + commands[i].substring(0, 2));
            System.out.println("Target: " + commands[i].substring(3));
            saidas[i + 1] = tab.mostraTabuleiro();
        }
        return saidas;
    }
}