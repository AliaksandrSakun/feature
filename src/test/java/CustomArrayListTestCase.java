import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTestCase {

    private CustomArrayList customList;

    @BeforeEach
    public void init() {
        customList = new CustomArrayList();
    }

    @Test
    public void testNonNull() {
        Assertions.assertNotNull(customList);
    }

    @Test
    public void testNullTest() {
        Assertions.assertTrue(customList.size() == 0);
        Assertions.assertTrue(customList.isEmpty());
    }

    @Test
    public void testAddByIndex() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(i, String.valueOf(i));
        }

        Assertions.assertTrue(customList.size() == loopTimes);
    }
}
