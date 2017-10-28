package com.run.warlord.entity.skill;

public class Skill {

    private static final int BASE_XP = 100;
    private static final double FACTOR = 1.8;

    protected String name;
    private int level;
    private long exp;
    private long expToLevelUp;

    public Skill(String name) {
        this.name = name;
        this.level = 1;
        this.exp = 0;
        this.expToLevelUp = 100;
    }

    public String getName() {

        return name;
    }

    public int getLevel() {

        return level;
    }

    public void gain(int experience) {

        this.exp += experience;
        if (exp >= expToLevelUp) {
            levelUp();
        }
    }

    public void levelUp() {

        level++;
        expToLevelUp = genNextLevelExp();
    }

    private long genNextLevelExp() {

        return BASE_XP * (long) Math.pow(level, FACTOR);
    }

    @Override
    public String toString() {

        return "name: " + name + " " +
                "level: " + level + " " +
                "exp to level up: " + expToLevelUp;
    }
}