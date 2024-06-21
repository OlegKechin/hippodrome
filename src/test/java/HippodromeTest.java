import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {
    Hippodrome hippodrome;

    @Test
    void Null_In_Hippodrome() {

        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> hippodrome = new Hippodrome(null));
        Assertions.assertEquals("Horses cannot be null.", throwable.getMessage());
    }

    @Test
    void Empty_In_Hippodrome() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> hippodrome = new Hippodrome(new ArrayList<>()));
        Assertions.assertEquals("Horses cannot be empty.", throwable.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("name" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        Assertions.assertEquals(horses, hippodrome.getHorses());

    }

    @Test
    void move() {
        List<Horse> list = new ArrayList<>();
        Horse horse = Mockito.mock(Horse.class);
        for (int i = 0; i < 50; i++) {

            list.add(horse);
        }

        Hippodrome hippodrome1 = new Hippodrome(list);
        hippodrome1.move();

        Mockito.verify(horse, Mockito.times(50)).move();
    }

    @Test
    void getWinner() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horses.add(new Horse("name" + i, i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        Assertions.assertEquals(horses.get(9), hippodrome.getWinner());

    }
}