package PersonFile;

import java.time.Year;

public class Person
{
    String ID;
    String firstName;
    String lastName;
    String title;
    int YOB;

    public String fullName()
    {
        return firstName + " " + lastName;
    }
    public String formalName()
    {
        return title + " " + fullName();
    }
    public String getAge()
    {
        return Integer.toString(Year.now().getValue() - YOB);
    }
    public String getAge(int year)
    {
        return Integer.toString(year - YOB);
    }

    public String toCSVDataRecord()
    {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

}