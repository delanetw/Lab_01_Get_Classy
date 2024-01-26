package ProductFile;

public class ProductTest {

    public static void main(String[] args) {
        Product product = new Product();
        product.name = "Te";
        product.description = "st";
        product.ID = "0001";
        product.cost = 200.20;
        System.out.println(product.toCSVDataRecord());
    }

}