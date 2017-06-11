package br.com.munif.ooweb;

import java.util.Random;

public class NPC extends Personagem {

   static private Random r = new Random();

    static private String[] possiveisNomes = {"Gandalf", "Darth Vader", "Spock", "Batman", "Wolwerine","Eliot"};
    static private String[] acoesNpc = {"Matou voce", "Atirou em voce", "Seguiu voce", "Ajudou voce", "Massacrou voce"};

    public NPC(Lugar lugar) {
     
        super(possiveisNomes[r.nextInt(possiveisNomes.length)],
                lugar,acoesNpc[r.nextInt(acoesNpc.length)]);
    }

    @Override
    public void chora() {
        System.out.println("ChuaChuaCHua");
    }

    public static String[] getAcoesNpc() {
        return acoesNpc;
    }
    
}
