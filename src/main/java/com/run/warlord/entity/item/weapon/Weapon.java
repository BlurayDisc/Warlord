package com.run.warlord.entity.item.weapon;

import com.run.warlord.entity.item.Quality;
import com.run.warlord.entity.item.StatesItem;

public class Weapon extends StatesItem {

    private static final long serialVersionUID = 1L;
    protected Quality quality;
    protected int accuracy;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected SpecialSuffix suffix;

    /**
     * Randomizes the states of this Weapon.
     *
     * @param factor
     */
    @Override
    public void randomize(int factor) {

        double f = 0.1 + factor / 100.0;
        accuracy = applyTo(accuracy, f);
        strength = applyTo(strength, f);
        agility = applyTo(agility, f);
        intelligence = applyTo(intelligence, f);
    }

    @Override
    public Quality getQuality() {

        return quality;
    }

    @Override
    public void setQuality(Quality quality) {

        this.quality = quality;
    }

    public int getAccuracy() {

        return accuracy;
    }

    public void setAccuracy(int accuracy) {

        this.accuracy = accuracy;
    }

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

    public SpecialSuffix getSuffix() {

        return suffix;
    }

    public void setSuffix(SpecialSuffix suffix) {

        this.suffix = suffix;
    }

    @Override
    public String toString() {

        return String.format("Weapon [name=%s quality=%s, accuracy=%s, strength=%s, agility=%s, intelligence=%s, suffix=%s]", name,
                quality, accuracy, strength, agility, intelligence, suffix);
    }
}
