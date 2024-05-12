import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class HorseTest {
    Horse horse;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void extend_Throws_Null_In_Name_Horse(){
        Assertions.assertThrows(IllegalArgumentException.class,()->horse = new Horse(null,0,0));
        Assertions.assertEquals("Name cannot be null.",horse = new Horse(null,0,0));
    }
    @Test
    void extend_Throws_Negative_Speed(){
        Assertions.assertThrows(IllegalArgumentException.class,()->horse = new Horse("horse",-10,0));
    }
    @Test
    void extend_Throws_Negative_Distance(){
        Assertions.assertThrows(IllegalArgumentException.class,()->horse = new Horse("horse",0,-10));
    }
    @Test
    void getName() {
    }

    @Test
    void getSpeed() {
    }

    @Test
    void getDistance() {
    }

    @Test
    void move() {
    }

    @Test
    void getRandomDouble() {
    }
}