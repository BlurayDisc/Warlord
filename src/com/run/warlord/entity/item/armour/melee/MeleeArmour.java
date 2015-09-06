package com.run.warlord.entity.item.armour.melee;

import com.run.warlord.entity.item.armour.Armour;

public class MeleeArmour extends Armour {
	
	protected int accuracy;
	protected int damage;
	
	@Override
	public void randomize(int factor) {
		double f = 0.1 + (double) (factor / 100.0);
		damage = applyTo(damage, f);
		accuracy = applyTo(accuracy, f);
		strength = applyTo(strength, f);
		agility = applyTo(agility, f);
		intelligence = applyTo(intelligence, f);
	}
}