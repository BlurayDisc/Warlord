package com.run.warlord.entity.unit.neutral;

import java.util.HashMap;
import java.util.Map;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.unit.Lootable;
import com.run.warlord.entity.unit.Unit;

public abstract class NeutralUnit extends Unit implements Lootable {

    private final int coinFactor;
    private final Map<Item, Integer> dropTable;

    public NeutralUnit(String name) {
        super(name);
        this.dropTable = new HashMap<>();
        this.coinFactor = setCoinFactor();
        this.setDropTable(dropTable);
    }

    protected abstract int setCoinFactor();

    protected abstract void setDropTable(Map<Item, Integer> dropTable);

    @Override
    public int dropCoin() {

        double rate = 1.0 + 0.5 * Math.random();
        return (int) (coinFactor * rate);
    }

    @Override
    public Item dropItem() {

        int rate = generateDropRate();
        System.out.println("Random number generated: " + rate);
        for (Item item : dropTable.keySet()) {
            int base = dropTable.get(item);
            if (rate > base) {
                rate -= base;
            } else {
                return item;
            }
        }
        return null;
    }

    private int generateDropRate() {

        int total = 0;
        for (Item item : dropTable.keySet()) {
            int p = dropTable.get(item);
            total += p;
            System.out.println("Probability of dropping: " + item + " = " + p);
        }
        System.out.println("Total probability : " + total);
        int rate = (int) Math.round(total * Math.random());
        return rate;
    }
}