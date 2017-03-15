package pokemon;

public class Pokemon implements PokemonAttacks{
	private int maxHP;
	private int hp;
	private int attackDmg;
	private String name;
	private String primaryAttr;
	private String secondaryAttr;
	
	public Pokemon(int maxHP, int attackDmg, String name, String primaryAttr, String secondaryAttr) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attackDmg = attackDmg;
		this.name = name;
		this.primaryAttr = primaryAttr;
		this.secondaryAttr = secondaryAttr;
	}
	
	void takeDamage(int amount)
	{
		hp-=amount;
	}
	void heal(int amount)
	{
		hp+=amount;
	}

	public int getMaxHP() {
		return maxHP;
	}
	
	public int getHp() {
		return hp;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryAttr() {
		return primaryAttr;
	}
	
	public String getSecondaryAttr() {
		return secondaryAttr;
	}

	
	
	@Override
	public int razorLeaf() {
		return 0;
	}
	
	
}
