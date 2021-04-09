package mc322.lab03;

public class AppLab03 {
    public static void main(String[] args) {
        String animacao = "080403MCMVM";
        Animacao umaAnimacao = new Animacao(animacao);
        String apresentacao = umaAnimacao.apresenta();
        System.out.println(apresentacao);
        for (int i = 6; i < animacao.length(); i ++) {
            umaAnimacao.passo();
            apresentacao = umaAnimacao.apresenta();
            System.out.println(apresentacao);
        }
    }
}