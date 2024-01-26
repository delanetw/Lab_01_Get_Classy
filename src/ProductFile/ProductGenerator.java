package ProductFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();

        while(true)
        {
            Product newProduct = new Product();
            newProduct.name = SafeInput.getRegExString(in, "Please Enter a product name", "[a-zA-Z]+");
            newProduct.description = SafeInput.getRegExString(in, "Please Enter a product description", "[a-zA-Z ’]+");
            newProduct.ID = SafeInput.getRegExString(in, "Please Enter a product ID", "[0-9]+");
            newProduct.cost = SafeInput.getDouble(in, "Please Enter the product cost");
            products.add((newProduct));
            System.out.println("Finished collecting input for " + newProduct.name);
            if(!SafeInput.getYNConfirm(in, "Would you like to add another product?"))
            {
                break;
            }
        }

        File workingDir = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDir.getPath() + "ProductTestData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(int i = 0; i < products.size(); i++)
            {
                Product product = products.get(i);
                String csvEntry = product.toCSVDataRecord();
                writer.write(csvEntry, 0, csvEntry.length());
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