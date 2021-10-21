import org.junit.Test;
import services.PlayerService;

import java.io.ByteArrayInputStream;


public class PlayerServiceTest {
    private final PlayerService playerService = new PlayerService();

    @Test
    public void addPlayerAndGetNext() {
        assert playerService.getNextPlayer() == null;
        playerService.addPlayers();
        System.setIn(new ByteArrayInputStream("Игрок1\nИгрок2\nИгрок3\n".getBytes()));
        assert playerService.getNextPlayer().getName().equals("Игрок1");
        assert playerService.getNextPlayer().getName().equals("Игрок2");
        assert playerService.getNextPlayer().getName().equals("Игрок3");
        assert playerService.getNextPlayer().getName().equals("Игрок1");
    }
}
