package com.run.warlord.entity.unit.neutral;

import java.util.Map;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.item.consumable.Meat;
import com.run.warlord.entity.item.material.Fur;
import com.run.warlord.entity.item.material.Leather;

public class Pig extends NeutralUnit {

    public Pig() {
        super("Pig");
    }

    @Override
    protected int setCoinFactor() {

        return 10;
    }

    @Override
    protected void setDropTable(Map<Item, Integer> dropTable) {

        dropTable.put(null, 5);
        dropTable.put(new Leather(), 2);
        dropTable.put(new Fur(), 2);
        dropTable.put(new Meat(), 1);
    }
}
