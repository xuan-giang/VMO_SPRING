package UnitTest;

import static org.junit.Assert.*;

public class PersonTest {

    @org.junit.Before
    public void setUp() throws Exception {
        // connect DB
    }

    @org.junit.After
    public void tearDown() throws Exception {
        // Release connection
    }

    @org.junit.Test
    public void getMySalary() {
        // Query DB
        int expectedResult  = 40000;

        Person person = new Person();
        int actualResult    = person.getMySalary();

        assertEquals(expectedResult, actualResult);
    }
}