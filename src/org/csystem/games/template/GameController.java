package org.csystem.games.template;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {
    private final ArrayList<AbstractGame> m_games = new ArrayList<>();

    private AbstractGame getGameByOption(int option){
        return (AbstractGame) m_games.get(option);
    }

    private void displayMenu() {
        int size = m_games.size();

        System.out.println("---Oyunlar---");

        for(int i = 0; i < size; i++){
            AbstractGame game = m_games.get(i);
            System.out.printf("%d.%s%n",i + 1,game.name);
        }

        System.out.printf("%d.Çıkış%n",size + 1);
        System.out.print("Oyun numarasını giriniz:");
    }

    public void add(AbstractGame game){
        m_games.add(game);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        for(;;){
            if(m_games.isEmpty()){
                System.out.println("Lütfen oyun yükleyiniz");
                break;
            }

            this.displayMenu();
            int option = Integer.parseInt(scan.nextLine());
            if(option < 0 || option > m_games.size() + 1){  // +1 çıkış seçeneği
                System.out.println("Geçersiz seçenek");
                continue;
            }

            if(option == m_games.size() + 1){ // çıkışa basmış demektir
                break;
            }

            AbstractGame curGame = getGameByOption(option - 1);  // çıkış için +1 eklediğimizi çıkar

            curGame.run();
        }

        System.out.println(("TEKRAR YAP"));
    }

}
