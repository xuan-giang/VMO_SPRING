import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    MathUtil mathUtil = new MathUtil();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void sum() {
        assertEquals(mathUtil.sum(1,2), 3);
    }

    @Test
    void testSum() {
    }
}