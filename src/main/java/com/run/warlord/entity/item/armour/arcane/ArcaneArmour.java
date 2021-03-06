package com.run.warlord.entity.item.armour.arcane;

import com.run.warlord.entity.item.armour.Armour;
import com.run.warlord.entity.skill.smithing.Craftable;

public class ArcaneArmour extends Armour implements Craftable {

    private static final long serialVersionUID = 3046700143522788959L;
    protected int magicalDamage;
    protected int accuracy;

    @Override
    public void randomize(int factor) {

        super.randomize(factor);
        double f = 0.1 + factor / 100.0;
        this.strength = applyTo(strength, f);
        this.agility = applyTo(agility, f);
        this.intelligence = applyTo(intelligence, f);
    }

}
