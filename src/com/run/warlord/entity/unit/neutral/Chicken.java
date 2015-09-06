package com.run.warlord.entity.unit.neutral;

import java.util.Map;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.item.consumable.Egg;
import com.run.warlord.entity.item.consumable.Feather;
import com.run.warlord.entity.item.consumable.Meat;

public class Chicken extends NeutralUnit {
	
	public Chicken() {
		super("Chicken");
	}

	@Override
	protected int setCoinFactor() {
		return 5;
	}

	@Override
	protected void setDropTable(Map<Item, Integer> dropTable) {
		dropTable.put(null, 7);
		dropTable.put(new Meat(), 1);
		dropTable.put(new Egg(), 1);
		dropTable.put(new Feather(), 1);
	}
}