package programacionFuncional.Exercise2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise2 {

	public static void main(String[] args) {
		
		List<Product> shoppingCart = List.of(
				new Product("Clothes",15.90, Tax.NORMAL),
				new Product("Bread", 1.5, Tax.SUPERREDUCED),
				new Product("meat", 13.99, Tax.REDUCED),
				new Product("Cheese", 3.59, Tax.SUPERREDUCED),
				new Product("Coke", 1.89, Tax.REDUCED),
				new Product("Whiskey", 19.90, Tax.NORMAL)
				);
		
		Optional<Double> amount = shoppingCart.stream().map(product -> product.price).reduce((x, y) -> x + y);
		
		System.out.println("Shopping cart final amount without taxes: " + amount);
		
		Optional<Double> amountWithTaxes = shoppingCart.stream().map(product -> product.price + (product.price *product.tax.percent /100)).reduce((x, y) -> x + y);
		
		
		System.out.println("Shopping cart final amount with taxes: " + amountWithTaxes);
		
		String list = shoppingCart.stream().filter(producto -> producto.name.startsWith("C")).sorted((x, y) -> x.name.compareToIgnoreCase(y.name)).map(x -> x.name).collect(Collectors.joining(",","Products starts with C are","."));

		System.out.println(list);
	}

}

class Product{
	public String name;
	public Double price;
	public Tax tax;
	
	Product(String name, Double price, Tax tax){
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
}

enum Tax{
	SUPERREDUCED(4), REDUCED(10), NORMAL(21);
	
	public int percent;
	
	private Tax(int percent) {
		this.percent = percent;
	}
	
	public int getpercent() {
		return percent;
	}
}
