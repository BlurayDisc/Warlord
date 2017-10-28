package com.run.warlord.entity.item.weapon;

public class PhysicalWeapon extends Weapon {

    private static final long serialVersionUID = 1L;
    protected int damage;

    public int getDamage() {

        return damage;
    }

    /**
     * Randomizes the states of this Weapon.
     * 
     * @param factor
     */
    @Override
    public void randomize(int factor) {

        double f = 0.1 + factor / 100.0;
        damage = applyTo(damage, f);
        accuracy = applyTo(accuracy, f);
        strength = applyTo(strength, f);
        agility = applyTo(agility, f);
        intelligence = applyTo(intelligence, f);
    }
}
