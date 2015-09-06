package com.run.warlord.entity.item.armour.ranged;

import com.run.warlord.entity.item.armour.Armour;
import com.run.warlord.entity.skill.smithing.Craftable;

public class RangedArmour extends Armour implements Craftable {
	
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
