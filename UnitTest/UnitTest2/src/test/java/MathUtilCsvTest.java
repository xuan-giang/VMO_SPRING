import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilCsvTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Data.csv", numLinesToSkip = 1)
    void test(int a, int b, int result){
        MathUtil math = new MathUtil();
        assertEquals(math.sum(a,b),result);
    }
}