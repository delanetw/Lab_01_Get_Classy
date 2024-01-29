package PersonFile;

public class PersonTest
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.ID = "0001";
        person.firstName = "Te";
        person.lastName = "st";
        person.title = "Mr.";
        person.YOB = 2000;
        System.out.println(person.fullName());
        System.out.println(person.formalName());
        System.out.println(person.getAge());
        System.out.println(person.getAge(1999));
        System.out.println(person.toCSVDataRecord());
    }
}
