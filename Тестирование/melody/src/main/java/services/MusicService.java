package services;

import entities.Music;
import entities.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MusicService {
    private List<Music> musicList;
    private final String musicListFile = "files/music_list.txt";
    private final String musicFilesDirectory = "files/music/";

    public MusicService() {
        fillMusicList();
    }

    private void fillMusicList() {
        File file = new File(musicListFile);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            musicList = new ArrayList<>();
            while (line != null) {
                String[] musicInfo = line.split("->");
                File musicFile = new File(musicFilesDirectory + musicInfo[0].replace(" ", ""));
                if (musicFile.exists()) {
                    musicInfo = musicInfo[1].split(";");
                    ArrayList<String> names = new ArrayList<>(Arrays.asList(musicInfo));
                    musicList.add(new Music(names, musicFile));
                }
                line = reader.readLine();
            }
            Collections.shuffle(musicList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Music getNextMusic() {
        if (!musicList.isEmpty()) {
            return musicList.remove(0);
        }
        return null;
    }

    public void turn(Player player, Music music) {
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        boolean isCorrect = false;
        for (String name : music.getNames()) {
            if (name.toLowerCase().replace(" ", "")
                    .equals(answer.toLowerCase().replace(" ", ""))) {
                isCorrect = true;
                break;
            }
        }
        if (isCorrect) {
            System.out.println("Ответ верный");
            System.out.println(player.getName() + " +100 очков");
            player.setScore(player.getScore() + 100);
        } else {
            System.out.println("Ответ неверный");
        }
    }

}
