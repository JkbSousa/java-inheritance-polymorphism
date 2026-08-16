package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Program {

    void main() {

        List<Product> products = new ArrayList<>();

        IO.print("Enter number of products: ");
        int n = Integer.parseInt(IO.readln());
        for (int i = 1; i<=n; i++){
            IO.println("Product #" + i + " data:");
            IO.print("Common, user or imported (c/u/i)? ");
            char ch = IO.readln().charAt(0);
            IO.print("Name: ");
            String name = IO.readln();
            IO.print("Price: ");
            Double price = Double.parseDouble(IO.readln());
            if (ch == 'c') {
                products.add(new Product(name, price));
            }
            else if (ch == 'i'){
                IO.print("Customs fee: ");
                Double fee = Double.parseDouble(IO.readln());
                products.add(new ImportedProduct(name, price, fee));
            }
            else if (ch == 'u'){
                IO.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(IO.readln(), UsedProduct.formatter);
                products.add(new UsedProduct(name, price, date));
            }

            }
        IO.println();
        IO.println("PRICE TAGS:");
        for (Product items : products){
            IO.println(items.priceTag());
        }
        }

}
