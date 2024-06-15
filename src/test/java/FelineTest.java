import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Test
    public void checkEatMeat() throws Exception {
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(mealList, food);
    }
    @Test
    public void checkGetFamily() {
        Feline feline = new Feline();
        String felineFamily = feline.getFamily();
        assertEquals("Кошачьи", felineFamily);
    }
    @Test
    public void checkGetKittens() {
        Feline feline = new Feline();
        int felineKittens = feline.getKittens();
        assertEquals(1, felineKittens);
    }
    @Test
    public void checkGetKittensWithArgument() {
        Feline feline = new Feline();
        int felineKittens = feline.getKittens(2);
        assertEquals(2, felineKittens);
    }
}
