package com.run.warlord.entity.item.weapon;

import com.run.warlord.entity.item.Quality;
import com.run.warlord.entity.item.RandomizableItem;

public class Weapon extends RandomizableItem {

	private static final long serialVersionUID = -7618993635641611714L;
	protected double attackRate;
	protected Quality quality;
	protected int accuracy;
	protected int strength;
	protected int agility;
	protected int intelligence;
	protected SpecialSuffix suffix;
	
	public Weapon() { 
		this.attackRate = 2.0;
	}

	public Weapon(Builder builder) {
		this.name = builder.name;
		this.accuracy = builder.accuracy;
		this.strength = builder.strength;
		this.agility = builder.agility;
		this.intelligence = builder.intelligence;
		this.suffix = builder.suffix;
	}
	
	/**
	 * Randomizes the states of this Weapon.
	 * @param factor
	 */
	public void randomize(int factor) {
		double f = 0.1 + (double) (factor / 100.0);
		accuracy = applyTo(accuracy, f);
		strength = applyTo(strength, f);
		agility = applyTo(agility, f);
		intelligence = applyTo(intelligence, f);
	}
	
	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public int getStrength() {
		return strength;
	}

	public int getAgility() {
		return agility;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public SpecialSuffix getSuffix() {
		return suffix;
	}
	
	@Override
	public String toString() {
		return   "name: " + name +
				" accuracy: " + accuracy +
				" stength: " + strength +
				" agility: " + agility +
				" intelligence: " + intelligence;
	}
	
	public static class Builder {
		
		private String name;
		private int accuracy;
		private int strength;
		private int agility;
		private int intelligence;
		private SpecialSuffix suffix;
		
		public Builder name(String value) {
			this.name = value;
			return this;
		}
		
		public Builder accuracy(int value) {
			this.accuracy = value > 0 ? value : 0;
			return this;
		}
		
		public Builder strength(int value) {
			this.strength = value > 0 ? value : 0;
			return this;
		}
		
		public Builder agility(int value) {
			this.agility = value > 0 ? value : 0;
			return this;
		}
		
		public Builder intelligence(int value) {
			this.intelligence = value > 0 ? value : 0;
			return this;
		}
		
		public Builder suffix(SpecialSuffix value) {
			this.suffix = value;
			return this;
		}
		
		public Weapon build() {
			return new Weapon(this);
		}
	}
}
