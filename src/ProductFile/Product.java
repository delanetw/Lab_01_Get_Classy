package ProductFile;

public class Product
{
    String name;
    String description;
    String ID;
    double cost;

    public String toCSVDataRecord()
    {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

}