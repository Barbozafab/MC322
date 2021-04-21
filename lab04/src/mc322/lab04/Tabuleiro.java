package mc322.lab04;

public class Tabuleiro {
    // Atributos
    Peca tab[][];
    
    // Construtor
    public Tabuleiro() {
        tab = new Peca[7][7];
        
        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < 2; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = " ";
            }
        }
        for (int i = 5; i < 7; i ++) {
            for (int j = 5; j < 7; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = " ";
            }
        }
        for (int i = 0; i < 2; i ++) {
            for (int j = 5; j < 7; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = " ";
            }
        }
        for (int i = 5; i < 7; i ++) {
            for (int j = 0; j < 2; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = " ";
            }
        }
        for (int i = 0; i < 2; i ++) {
            for (int j = 2; j < 5; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = "P";
            }
        }
        for (int i = 2; i < 5; i ++) {
            for (int j = 0; j < 7; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = "P";
            }
        }
        for (int i = 5; i < 7; i ++) {
            for (int j = 2; j < 5; j ++) {
                tab[i][j] = new Peca();
                tab[i][j].tipoPeca = "P";
            }
        }
        tab[3][3].tipoPeca = "-";
    }

    // Executa o próximo movimento
    public void executaMovimento(String comando) {
        char origemJ = comando.charAt(0);
        char origemI = comando.charAt(1);
        char destinoJ = comando.charAt(3);
        char destinoI = comando.charAt(4);
        
        int intOrigemJ = origemJ - 97;
        int intOrigemI = Math.abs(origemI - 55);
        int intDestinoJ = destinoJ - 97;
        int intDestinoI = Math.abs(destinoI - 55);

        tab[intOrigemI][intOrigemJ].tipoPeca = "-";
        tab[intDestinoI][intDestinoJ].tipoPeca = "P";
        if (intDestinoJ == intOrigemJ + 2) { // Movimento para a direita
            tab[intOrigemI][intOrigemJ + 1].tipoPeca = "-";
        } else if (intDestinoJ == intOrigemJ - 2) { // Movimento para a esquerda
            tab[intOrigemI][intOrigemJ - 1].tipoPeca = "-";
        } else if (intDestinoI == intOrigemI + 2) { // Movimento para baixo
            tab[intOrigemI + 1][intOrigemJ].tipoPeca = "-";
        } else { // Movimento para cima
            tab[intOrigemI - 1][intOrigemJ].tipoPeca = "-";
        }
    }

    // Imprime o tabuleiro e retorna uma String contendo o estado atual do tabuleiro
    public String mostraTabuleiro() {
        int n = 7;
        String saida = "";
        for (int i = 0; i < 7; i ++) {
            System.out.print(n);
            for (int j = 0; j < 7; j ++) {
                System.out.print(" " + tab[i][j].tipoPeca);
                saida += tab[i][j].tipoPeca;
            }
            System.out.println();
            saida += "\n";
            n --;
        }
        System.out.println("  a b c d e f g");
        System.out.println();
        return saida;
    }
}