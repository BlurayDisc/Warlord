package com.run.warlord.entity.unit;

public class Unit {
	
	private final String name;
	protected int strength;
	protected int agility;
	protected int intelligence;
	
	public Unit(String name) {
		this.name = name;
		this.strength = 0;
		this.agility = 0;
		this.intelligence = 0;
	}
	
	/* *********************
	 ** Getters & Setters **
	 ***********************/
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
