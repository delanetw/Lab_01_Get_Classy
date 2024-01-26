package PersonFile;

import java.time.Year;

public class Person
{
    String id;
    String firstName;
    String lastName;
    String title;
    int yearOfBirth;

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
        return Integer.toString(Year.now().getValue() - yearOfBirth);
    }
    public String getAge(int year)
    {
        return Integer.toString(year - yearOfBirth);
    }

    public String toCSVDataRecord()
    {
        return id + "," + firstName + "," + lastName + "," + title + "," + Integer.toString(yearOfBirth);
    }

}