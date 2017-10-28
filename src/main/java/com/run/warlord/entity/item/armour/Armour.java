package com.run.warlord.entity.item.armour;

import com.run.warlord.entity.item.StatesItem;
import com.run.warlord.entity.item.weapon.SpecialSuffix;

public class Armour extends StatesItem {

    private static final long serialVersionUID = 1L;
    protected int defence;
    protected int magicalDefence;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected SpecialSuffix suffix;

    @Override
    public void randomize(int factor) {

        double f = 0.1 + factor / 100.0;
        strength = applyTo(strength, f);
        agility = applyTo(agility, f);
        intelligence = applyTo(intelligence, f);
    }

    public SpecialSuffix getSuffix() {

        return suffix;
    }

    public void setSuffix(SpecialSuffix suffix) {

        this.suffix = suffix;
    }
}
