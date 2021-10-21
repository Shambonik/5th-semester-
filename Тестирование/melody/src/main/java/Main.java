import entities.Music;
import entities.Player;
import services.MusicService;
import services.PlayerService;

import java.util.Scanner;

public class Main {
    private static PlayerService playerService;
    private static MusicService musicService;

    public static void main(String[] args) {
        playerService = new PlayerService();
        musicService = new MusicService();
        game();
    }

    private static void game(){
        Scanner in = new Scanner(System.in);
        playerService.addPlayers();
        Music music = musicService.getNextMusic();
        while(music!=null){
            Player player = playerService.getNextPlayer();
            System.out.println("Угадывает игрок " + player.getName());
            System.out.println("Нажмите Enter для продолжения");
            in.nextLine();
            musicService.turn(player, music);
            playerService.outputScore();
            music = musicService.getNextMusic();
        }
        System.out.println("Закончились песни");
    }

}
