package UnitTest;

public class Person {

    private String name;

    public int getMySalary()
    {
        int numberOfWorkingDay  = 20;
        int salaryPerDay        = 2000;
        int payment             = numberOfWorkingDay * salaryPerDay;

        return payment;
    }

    public String getName()
    {
        return name;
    }
}
