public class Exe3 {

	public static void main(String[] args) {
		Product p1 = new Product("Chupeta", "baby");
		Product p2 = new Product("Camisola XXXXXL", "clothes");
		Product p3 = new Product("Sande Big Tasty Mega Ultra Double Light", "fastfood");
		Product p4 = new Product("Sapato casual Tamanho 49", "shoes");
		Product p5 = new Product("Dálmata", "pets");
		Product p6 = new Product("Lenovo Yoga Classes", "computers");
		Product p7 = new Product("Nerf Elite 1", "toys");
		Product p8 = new Product("GTA VI Beta", "games");
		Product p9 = new Product("Comprimido para a tosse", "drugs");
		Product p10 = new Product("Preparado para bolo de amendoa", "bakery");
		Product p11 = new Product("Alface", "groceries");
		// um produto que não existe
		Product p12 = new Product("Nokia 3310", "mobile");
		
		Shop gaiaShopping = new BabyShop().setSucessor(new ClothesShop().setSucessor(new FastFoodShop().setSucessor(new ShoeShop().setSucessor(new PetShop().setSucessor(new ComputerShop().setSucessor(new ToyShop().setSucessor(new GamingShop().setSucessor(new MedicineShop().setSucessor(new BakeryShop().setSucessor(new GroceryShop()))))))))));

		gaiaShopping.shop(p1);
		gaiaShopping.shop(p2);
		gaiaShopping.shop(p3);
		gaiaShopping.shop(p4);
		gaiaShopping.shop(p5);
		gaiaShopping.shop(p6);
		gaiaShopping.shop(p7);
		gaiaShopping.shop(p8);
		gaiaShopping.shop(p9);
		gaiaShopping.shop(p10);
		gaiaShopping.shop(p11);
		gaiaShopping.shop(p12);
	}

}
