package com.run.warlord.entity.unit;

import com.run.warlord.entity.item.Item;

public interface Lootable {

	public Item dropItem();
	
	public int dropCoin();
}
