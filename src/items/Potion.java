package items;

import pokemon.Pokemon;

public class Potion {
	public static final int potionTypesCount = 3;
	protected int quantity;
	private int sellsFor;
	private String description;
	private String name;
	
	public Potion(String name, String description, int sellsFor, int quantity) {
		super();
		this.quantity = quantity;
		this.sellsFor = sellsFor;
		this.description = description;
		this.name = name;
	}

	public void activate()
	{
		this.quantity-=1;
	}

	public void activate(Pokemon pokemon) {
		System.out.println("You used a " + this.getName() + " potion on a pokemon");
		
	}
	public int getSellsFor() {
		return sellsFor;
	}

	public void setSellsFor(int sellsFor) {
		this.sellsFor = sellsFor;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
