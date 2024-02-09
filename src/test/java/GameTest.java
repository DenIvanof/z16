import org.junit.jupiter.api.Test;
import ru.netology.zadanie.Game;
import ru.netology.zadanie.NotRegisteredException;
import ru.netology.zadanie.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest {
    @Test
    public void roundPlayer1Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1",8);
        Player player2 = new Player(2, "Player2",6);
        game.register(player1);
        game.register(player2);
        int result = game.round("Player1","Player2");
        assertEquals(1, result);
    }
    @Test
    public void roundPlayer2Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 8);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);
        int result = game.round("Player 1", "Player 2");
        assertEquals(2, result);
    }
    @Test
    public void roundDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);
        int result = game.round("Player 1", "Player 2");
        assertEquals(0, result);
    }
    @Test
    public void playerGetId() {
        Player player = new Player(1, "Player 1", 10);
        int id = player.getId();
        assertEquals(1, id);
    }
    @Test
    public void roundPlayer2NotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }
    @Test
    public void roundPlayer1NotRegisteredException() {
        Game game = new Game();
        Player player2 = new Player(1, "Player 1", 10);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }
    @Test
    public void roundPlayersNotRegisteredException() {
        Game game = new Game();
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }
}

