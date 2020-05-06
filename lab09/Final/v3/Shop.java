public abstract class Shop {
	private Shop successor = null;
	public void shop(Product p) {
		if(successor!=null) {
			successor.shop(p);
		}else {
			System.out.println("Não há lojas para o produto " + p.getName());
		}
	}
	
	protected boolean canSellProduct(Product p, String category) {
		return (p != null) && (p.getCategory()==category);
	}
	
	public Shop setSucessor(Shop successor) {
		this.successor=successor;
		return this;
	}
}
class BabyShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "baby")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Chico, onde há um bebé!");
		}else {
			super.shop(p);
		}
	}
}

class ClothesShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "clothes")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Zara, latest trends in clothing for women!");
		}else {
			super.shop(p);
		}
	}
}

class ShoeShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "shoes")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Calçado Guimarães, onde ficas a caminhar nas núvens!");
		}else {
			super.shop(p);
		}
	}
}

class ComputerShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "computers")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Worten, worten sempre!");
		}else {
			super.shop(p);
		}
	}
}

class GamingShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "games")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Gaming Replay, a tua loja de jogos!");
		}else {
			super.shop(p);
		}
	}
}

class BakeryShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "bakery")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Pasgelpan, tudo para a confeção!");
		}else {
			super.shop(p);
		}
	}
}
class FastFoodShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "fastfood")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pelo McDonalds, lovin'it!");
		}else {
			super.shop(p);
		}
	}
}
class PetShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "pets")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Cães e Companhia, veja encontrar a sua!");
		}else {
			super.shop(p);
		}
	}
}
class ToyShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "toys")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Toys R Us, cujo slogan não existe!");
		}else {
			super.shop(p);
		}
	}
}
class MedicineShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "drugs")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pela Farmácia das Antas, cujo slogan é ocultado por violar as regras de dopping do estádio das antas!");
		}else {
			super.shop(p);
		}
	}
}
class GroceryShop extends Shop{
	@Override
	public void shop(Product p) {
		if(canSellProduct(p, "groceries")) {
			System.out.println("O produto '"+p.getName()+"' foi vendido pelo Pingo Doce, venha cá!");
		}else {
			super.shop(p);
		}
	}
}
