package com.run.warlord.entity.unit.neutral;

import java.util.Map;

import com.run.warlord.entity.item.Item;

public class Gnoll extends NeutralUnit {

    public Gnoll() {
        super("Gnoll");
    }

    @Override
    protected int setCoinFactor() {

        return 10;
    }

    @Override
    protected void setDropTable(Map<Item, Integer> dropTable) {

        dropTable.put(null, 5);
        dropTable.put(null, 5);
    }
}
