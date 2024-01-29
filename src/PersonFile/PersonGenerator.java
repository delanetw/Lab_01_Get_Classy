package PersonFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<Person>();

        while(true)
        {
            Person newPerson = new Person();
            newPerson.ID = SafeInput.getRegExString(in, "Enter ID (a String)", "\\d+");
            newPerson.firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            newPerson.lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            newPerson.title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Mrs., Ms., Dr., etc.)");
            newPerson.YOB = SafeInput.getRangedInt(in, "Enter Year Of Birth", 0, 2023);
            people.add((newPerson));
            System.out.println("Finished collecting input for " + newPerson.firstName + " " + newPerson.lastName);
            if(!SafeInput.getYNConfirm(in, "Would you like to add another person?"))
            {
                break;
            }
        }

        File workingDir = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDir.getPath() + "PersonTestData.txt");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(int i = 0; i < people.size(); i++)
            {
                Person person = people.get(i);
                String csvRecord = person.toCSVDataRecord();
                writer.write(csvRecord, 0, csvRecord.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}