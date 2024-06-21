import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.lang.reflect.Field;


class HorseTest {
    Horse horse;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void extend_Null_In_Name_Horse() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> horse = new Horse(null, 0, 0));
        Assertions.assertEquals("Name cannot be null.", throwable.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   "})
    void extend_isBlank_In_Name_Horse(String argument) {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> horse = new Horse(argument, 0, 0));
        Assertions.assertEquals("Name cannot be blank.", throwable.getMessage());
    }

    @Test
    void extend_Negative_Speed() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> horse = new Horse("horse", -10, 0));
        Assertions.assertEquals("Speed cannot be negative.", throwable.getMessage());
    }

    @Test
    void extend_Throws_Negative_Distance() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> horse = new Horse("horse", 0, -10));
        Assertions.assertEquals("Distance cannot be negative.", throwable.getMessage());
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        horse = new Horse("n21", 10);
        Field Field = Horse.class.getDeclaredField("name");
        Field.setAccessible(true);
        String name = (String) Field.get(horse);
        Assertions.assertEquals("n21", name);
        Assertions.assertEquals(name, horse.getName());
    }

    @Test
    void getSpeed() throws NoSuchFieldException, IllegalAccessException {
        horse = new Horse("n21", 10);
        Field Field = Horse.class.getDeclaredField("speed");
        Field.setAccessible(true);
        double speed = (double) Field.get(horse);
        Assertions.assertEquals(10, speed);
        Assertions.assertEquals(speed, horse.getSpeed());
    }

    @Test
    void getDistance() throws IllegalAccessException, NoSuchFieldException {
        horse = new Horse("n21", 10, 10);
        Field Field = Horse.class.getDeclaredField("distance");
        Field.setAccessible(true);
        double distance = (double) Field.get(horse);
        Assertions.assertEquals(10, distance);
        Assertions.assertEquals(distance, horse.getDistance());
    }

    @Test
    void getDistanceNotEnterConstructor() throws IllegalAccessException, NoSuchFieldException {
        horse = new Horse("n21", 10);
        Field Field = Horse.class.getDeclaredField("distance");
        Field.setAccessible(true);
        double distance = (double) Field.get(horse);
        Assertions.assertEquals(0, distance);
        Assertions.assertEquals(distance, horse.getDistance());
    }

    @Test
    void moveGetRandom() {

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            horse = new Horse("name", 10, 5);
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));


        }
    }

    @ParameterizedTest
    @CsvSource({"1.5,10"})
    void move(double random, double dist) {

        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            horse = new Horse("name", 10, dist);
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(random);
            horse.move();
            var actual = dist + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);
            var extend = horse.getDistance();
            Assertions.assertEquals(extend, actual);

        }

    }

}