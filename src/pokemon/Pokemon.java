package pokemon;

import java.util.Scanner;

public class Pokemon{
	protected int maxHP;
	private int hp;
	protected int attackDmg;
	private String name;
	private String primaryAttr;
	private String secondaryAttr;
	
	Scanner input = new Scanner(System.in);
	
	public Pokemon(int maxHP, int attackDmg, String primaryAttr, String secondaryAttr, String name) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attackDmg = attackDmg;
		//commented because we don't want the opponents to name their pokemon
		//System.out.println("Insert a name for your Pokemon: ");
		//this.name = input.nextLine();
		this.name = name;
		this.primaryAttr = primaryAttr;
		this.secondaryAttr = secondaryAttr;
	}
	
	public Pokemon(int maxHP, int attackDmg, String primaryAttr, String secondaryAttr) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attackDmg = attackDmg;
		//commented because we don't want the opponents to name their pokemon
		//System.out.println("Insert a name for your Pokemon: ");
		//this.name = input.nextLine();
		this.primaryAttr = primaryAttr;
		this.secondaryAttr = secondaryAttr;
	}

	public void printInfo()
	{
		System.out.println("The name of your pokemon is " + this.getName());
		System.out.println("The max health points for " + this.getName()+" is " + this.getMaxHP());
		System.out.println(name+" currently has "+ this.getHp());
		System.out.println("Your pokemon attacks for " + this.getAttackDmg());
		System.out.println(this.getName()+"'s attributes are "+this.getPrimaryAttr()
		+" and "+this.getSecondaryAttr());
	}
	
	public void takeDamage(int amount)
	{
		hp-=amount;
	}
	public void heal(int amount)
	{
		if (hp + amount >= maxHP) {
			hp = maxHP;
		} else {
			hp+=amount;
		}
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

	public void printAbilities() {
		System.out.println("Here go the abilities");
	}
}
