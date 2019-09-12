package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product2;
import entities.UsedProduct;

public class Product2App {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		List<Product2> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (type == 'c') {
				list.add(new Product2(name, price));

			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				Date date = sdf.parse(sc.nextLine());

				list.add(new UsedProduct(name, price, date));
			} else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));

			}

		}

		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product2 p : list) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

}
