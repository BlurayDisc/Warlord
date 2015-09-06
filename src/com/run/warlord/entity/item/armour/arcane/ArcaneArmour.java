package com.run.warlord.entity.item.armour.arcane;

import com.run.warlord.entity.item.armour.Armour;
import com.run.warlord.entity.skill.smithing.Craftable;

public class ArcaneArmour extends Armour implements Craftable {
	
	protected int magicalDamage;
	protected int accuracy;

	@Override
	public void randomize(int factor) {
		super.randomize(factor);
		double f = 0.1 + (double) (factor / 100.0);
		this.strength = applyTo(strength, f);
		this.agility = applyTo(agility, f);
		this.intelligence = applyTo(intelligence, f);
	}
	
}
