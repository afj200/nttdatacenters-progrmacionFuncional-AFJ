package programacionFuncional.Exercise2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Exercise2WithBigDecimal {

	public static void main(String[] args) {
		
		List<ProductBD> shoppingCart = List.of(
				new ProductBD("Clothes",new BigDecimal("15.90"), Tax.NORMAL),
				new ProductBD("Bread",new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new ProductBD("meat", new BigDecimal("13.99"), Tax.REDUCED),
				new ProductBD("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new ProductBD("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new ProductBD("Whiskey", new BigDecimal("19.90"), Tax.NORMAL)
				);
		
		BigDecimal compare = new BigDecimal(10);
		BigDecimal amount = shoppingCart.stream().filter(p -> p.price.compareTo(new BigDecimal(10)) > 0).map(x -> x.price.add(x.price.multiply(new BigDecimal(x.tax.percent)).divide(new BigDecimal(100))))
				.reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.CEILING);
		
		System.out.println("Shopping cart final amount with taxes and only products that cost more than 10: " + amount);
	}
}

class ProductBD{
	public String name;
	public BigDecimal price;
	public Tax tax;
	
	ProductBD(String name, BigDecimal price, Tax tax){
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
}


