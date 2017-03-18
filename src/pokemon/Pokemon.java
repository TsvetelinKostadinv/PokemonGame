package pokemon;

import java.util.Scanner;

public class Pokemon implements PokemonAttacks{
	private int maxHP;
	private int hp;
	private int attackDmg;
	private String name;
	private String primaryAttr;
	private String secondaryAttr;
	
	Scanner input = new Scanner(System.in);
	public Pokemon(int maxHP, int attackDmg, String primaryAttr, String secondaryAttr) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attackDmg = attackDmg;
		System.out.println("Insert a name for your Pokemon: ");
		this.name = input.nextLine();
		this.primaryAttr = primaryAttr;
		this.secondaryAttr = secondaryAttr;
	}
	

	public void printInfo()
	{
		System.out.println("The name of your pokemon is " + this.getName());
		System.out.println("The max health points for " + this.getName()+" is " + this.getMaxHP());
		System.out.println(name+" currently has "+ this.getHp());
		System.out.println("Your pokemon attacks for " + this.getAttackDmg());
		System.out.println(name+"'s attributes are "+this.getPrimaryAttr()+" and "+this.getSecondaryAttr());
	}
	
	public void takeDamage(int amount)
	{
		hp-=amount;
	}
	public void heal(int amount)
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

	public void setAttackDmg(int attackDmg) {
		this.attackDmg = attackDmg;
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

	
	
	//grass +ground/rock/water -flying/poison/bug/steel/fire/grass/dragon
	public int razorLeaf() {
		return 0;
	}
	//fire +bug/steel/grass/ice -rock/fire/water/dragon
	public int flamethrower() {
		return 0;
	}
	//water +ground/rock/fire -water/grass/dragon
	public int hidroPump() {
		return 0;
	} 
	//normal -rock/steel --ghost
	public int hyperFang() {
		return 0;
	}
	//bug +grass/psychic/dark -fighting/flying/poison/ghost/steel/fire/fairy
	public int leechLife() {
		return 0;
	}
	//electricity +flying/water -grass/electricity/dragon --ground 
	public int thunderstrike() {
		return 0;
	}
	//rock +flying/bug/fire/ice -fight/ground/steel	
	public int rockThrow() {
		return 0;
	}
	//ghost +ghost/psychic --normal
	public int shadowBall() {
		return 0;
	}
	//fighting +normal/rock/steel/ice/dark -flying/poison/bug/psychic/fairy
	public int machPunch() {
		return 0;
	}
	//flying +grass/bug/fighting -rock/steel/electric
	public int gust() {
		return 0;
	}
	
	
}