import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    @Mock
    Feline feline;

    @Parameterized.Parameter()
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expectedHasMane;
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        int lionKittens = lion.getKittens();
        // Проверяем, что значение kittens равно 1
        assertEquals(1, lionKittens);
    }

    @Test
    public void checkDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean lionMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, lionMane);
    }

    @Test
    public void checkEatMeat() throws Exception {
        Lion lion = new Lion(sex, feline);

        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mealList);

        List<String> lionFood = lion.getFood();
        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals(lionFood, mealList);
    }
}
