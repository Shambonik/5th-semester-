import entities.Music;
import entities.Player;
import org.junit.Test;
import services.MusicService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicServiceTest {

    private final String musicFileName = "files/music_list.txt";

    @Test
    public void getNextMusic() throws IOException{
        File musicFile = new File(musicFileName);
        FileWriter fileWriter = new FileWriter(musicFile);
        String fileContent = "";
        fileWriter.write(fileContent);
        fileWriter.close();
        MusicService musicService = new MusicService();
        assert musicService.getNextMusic() == null;
        fileWriter = new FileWriter(musicFile);
        fileContent = "кукла_колдуна.wav -> Кукла колдуна; Кукла; Колдун";
        fileWriter.write(fileContent);
        fileWriter.close();
        musicService = new MusicService();
        assert musicService.getNextMusic().getFile().getName().equals("кукла_колдуна.wav");
        assert musicService.getNextMusic() == null;
        fileWriter = new FileWriter(musicFile);
        fileContent = "девятка.wav -> Девятка; А мой мальчик едет на девятке\n" +
                "Я_в_моменте.wav -> Я в моменте\n" +
                "кукла_колдуна.wav -> Кукла колдуна; Кукла; Колдун\n" +
                "знаешь_ли_ты.wav -> Знаешь ли ты; Вдоль ночных дорог\n" +
                "сансара.wav -> Сансара\n";
        fileWriter.write(fileContent);
        fileWriter.close();
    }

    @Test
    public void turn() {
        Player player = new Player(1, "Данил", 0);
        List<String> music_names = new ArrayList<>();
        music_names.add("Название1");
        music_names.add("Название2");
        Music music = new Music(music_names, new File("files/music/сансара.wav"));
        MusicService musicService = new MusicService();
        musicService.turn(player, music);
        System.setIn(new ByteArrayInputStream("Название1\n".getBytes()));
        assert player.getScore() == 100;
        musicService.turn(player, music);
        System.setIn(new ByteArrayInputStream("Название2\n".getBytes()));
        assert player.getScore() == 200;
        musicService.turn(player, music);
        System.setIn(new ByteArrayInputStream("Название3\n".getBytes()));
        assert player.getScore() == 200;
    }
}
