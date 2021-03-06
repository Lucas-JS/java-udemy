package functional.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import functional.entities.Product;

public class PredicateEx {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		Double min = 100.0;
		
		list.removeIf(p -> p.getPrice() >= min);
		
		for(Product p : list) {
			System.out.println(p);
		}
	}
}
