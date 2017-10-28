package com.run.warlord.model;

public class Damage {

    private final int amount;

    public Damage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {

        return amount;
    }

    @Override
    public String toString() {

        return String.format("Damage [amount=%s]", amount);
    }

}
