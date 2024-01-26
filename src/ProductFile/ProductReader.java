package ProductFile;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        try
        {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);

                ArrayList<Product> products = new ArrayList<Product>();

                while (inFile.hasNextLine())
                {
                    Product parsed = ParseProductData(inFile.nextLine());
                    if(parsed == null)
                    {
                        System.out.println("Cannot continue parsing");
                        break;
                    }
                    products.add(parsed);
                }

                PrintProducts(products);

                inFile.close();
            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

    public static Product ParseProductData(String line)
    {
        Product product = new Product();
        String[] arr = line.split(",");
        if(arr.length != 4)
        {
            System.out.println("Invalid line, cannot parse data for person");
            return null;
        }
        product.ID = arr[0];
        product.name = arr[1];
        product.description = arr[2];
        product.cost = Double.parseDouble(arr[3]);
        return product;
    }

    public static void PrintProducts(ArrayList<Product> arrayList)
    {
        System.out.println(String.format("%s %12s %25s %5s", "#ID", "Name", "Description", "Cost"));
        System.out.println(String.format("%0" + 40 + "d", 0).replace("0", "="));
        System.out.println();
        for(int i = 0; i < arrayList.size(); i++)
        {
            Product p = arrayList.get(i);
            System.out.println(String.format("%s %9s %25s %5f", p.ID, p.name, p.description, p.cost));
        }
    }
}