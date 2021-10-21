package services;

import entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService {
    private List<Player> playerList;
    private int playerIndex = 0;

    public Player getNextPlayer() {
        if(playerList!=null){
            Player player = playerList.get(playerIndex);
            playerIndex = (playerIndex+1)%3;
            return player;
        }
        return null;
    }

    public void addPlayers(){
        playerList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for(int i = 1; i<4; i++){
            System.out.println("Введите имя игрока №" + i);
            playerList.add(new Player(i, in.nextLine(), 0));
        }
    }

    public void outputScore(){
        if(playerList != null) {
            for (Player player : playerList) {
                System.out.println(player.getName() + " " + player.getScore());
            }
        }
    }
}
