package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player p1 = new Player(1, "Jim", 50);
    Player p2 = new Player(2, "Jack", 28);
    Player p3 = new Player(3, "Johnnie", 38);
    Player p4 = new Player(4, "Willie", 50);

    @BeforeEach
    public void setup() {
        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
    }

    @Test
    public void shouldReturnWinPlayer1() {
        int expected = 1;
        int actual = game.round("Jim", "Jack");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWinPlayer2() {
        int expected = -1;
        int actual = game.round("Jack", "Johnnie");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfStrengthEqual() {
        int expected = 0;
        int actual = game.round("Jim", "Willie");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTrowExceptionIfPlayer1NotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Winnie", "Willie");
        });
    }

    @Test
    public void shouldTrowExceptionIfPlayer2NotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jack", "Rabbit");
        });
    }

    @Test
    public void shouldTrowExceptionIfBothPlayersNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Winnie", "Rabbit");
        });
    }
}
