package br.com.munif.oo;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Programa {

    static Scanner scanner;
    static Personagem npc;

    public static void main(String... args) {

        System.out.println("----> " + Descritivel.NOME_JOGO);
        scanner = new Scanner(System.in);
        Mapa mapa = Mapa.getInstancia();

        npc = new NPC(mapa.getLugarInicialNPC());
        setupGamer(mapa);

    }

    private static void setupGamer(Mapa mapa) {

        Personagem jogador = null;
        while (true) {
            if (jogador == null) {
                System.out.println("Informe o seu nome");
                String nome = scanner.next();
                if (nome.length() > 0) {
                    jogador = new Jogador(nome, mapa.getLugarInicialJogador());
                    iniciaGame((Jogador) jogador);
                } else {
                    setupGamer(mapa);
                }
            } else {
                iniciaGame((Jogador) jogador);
            }

        }
    }

    private static void iniciaGame(Jogador jogador) {
        Lugar lc = jogador.getLugar();
        System.out.println(jogador.getNome() + "!");
        System.out.println("Voce está no(a):"
                + lc.getDescricao() + " com " + lc.getPersonagens());

        if (lc.getPersonagens().size() > 1) {
            boolean acao = true;
            if(!npc.getAcao().equals("Ajudou voce")){
            acao = false;
            }else if( !npc.getAcao().equals("Seguiu voce")){
            acao = false;
            }
            
            System.out.println("acao jogador"+npc.getAcao()+ acao);
            if (!acao) {
                System.out.println(npc.getNome() +" "+ npc.getAcao());
                jogador.chora();
                System.out.println("\\O/ " + jogador.getNome() + " você morreu");
                System.exit(0);
            }else{
                 System.out.println(npc.getNome() + npc.getAcao());
            }
        }

        System.out.println("Mensagens:" + lc.getMensagens());

        if (lc.getLeste() != null) {
            System.out.println("1) Para leste " + lc.getLeste().getDescricao());
        }
        if (lc.getOeste() != null) {
            System.out.println("2) Para Oeste " + lc.getOeste().getDescricao());
        }
        if (lc.getNorte() != null) {
            System.out.println("3) Para Norte " + lc.getNorte().getDescricao());
        }
        if (lc.getSul() != null) {
            System.out.println("4) Para Sul " + lc.getSul().getDescricao());
        }

        System.out.println("5) Escrever");

        System.out.println("6) Sair");

        int opcao = scanner.nextInt();

        if (opcao == 1 && lc.getLeste() != null) {
            jogador.setLugar(lc.getLeste());
        } else if (opcao == 2 && lc.getOeste() != null) {
            jogador.setLugar(lc.getOeste());
        } else if (opcao == 3 && lc.getNorte() != null) {
            jogador.setLugar(lc.getNorte());
        } else if (opcao == 4 && lc.getSul() != null) {
            jogador.setLugar(lc.getSul());
        } else if (opcao == 5) {
            System.out.println("Digite a mensagem:");
            String mensagem = scanner.next();
            lc.getMensagens().add(mensagem);
        } else if (opcao == 6) {
            System.exit(0);
        } else {
            System.out.println("Opcao inválida");
        }
        System.out.println("------------------");
    }

    public static void mainVelho(String[] args) {
        try {
            System.out.println("Ola Mundo!!!");

            Liquidificador liq1 = new Liquidificador();
            mostraDescricao(liq1);

            liq1.setVelocidade(2);
            System.out.println(liq1.getVelocidade());
            System.out.println(liq1.praQue());
            liq1.setVelocidade(-3);
            System.out.println(liq1.getVelocidade());
            System.out.println(liq1.praQue());
        } catch (LiqException ex) {
            System.out.println("Problemas " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Erro na entrada de dados");
        }

    }

    public static void mostraDescricao(Descritivel des) {
        JOptionPane.showConfirmDialog(null, des.descreve());
    }

}
