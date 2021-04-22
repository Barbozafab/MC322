package mc322.lab04;

public class AppTeste {
    public static void main(String args[]) {
        String saidas[] = AppRestaUm.executaJogo("../../../src/db/arq001.csv");
        for (int i = 0; i < saidas.length; i ++) {
            System.out.println(saidas[i]);
        }
    }
}