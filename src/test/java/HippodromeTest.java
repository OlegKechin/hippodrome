import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {
    Hippodrome hippodrome ;
    @Test
    void Null_In_Hippodrome(){

       Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,()->hippodrome = new Hippodrome(null));
       Assertions.assertEquals("Horses cannot be null.",throwable.getMessage());
    }
    @Test
    void Empty_In_Hippodrome(){
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,()->hippodrome = new Hippodrome(new ArrayList<>()));
        Assertions.assertEquals("Horses cannot be empty.",throwable.getMessage());
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}