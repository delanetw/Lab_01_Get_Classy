package ProductFile;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProductReader {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        System.out.println("Please select the Product file.");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                System.out.println(String.format("%-15s%-15s%-30s%-10s", "ID#", "Name", "Description", "Cost"));
                System.out.println("=====================================================================");
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    System.out.println(String.format("%-15s%-15s%-30s%-10s", parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File selection was canceled.");
        }

    }
}