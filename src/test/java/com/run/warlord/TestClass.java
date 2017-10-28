package com.run.warlord;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.skill.Skill;
import com.run.warlord.entity.skill.smithing.Smithing;
import com.run.warlord.entity.unit.neutral.Chicken;
import com.run.warlord.entity.unit.neutral.NeutralUnit;

public class TestClass {

	public static void main(String[] args) {
		
//		itemDrop();
		levelSystem();
	}
	
	static void levelSystem() {
		
		Skill skill = new Smithing();
		for (int i = 0; i < 50; i++) {
			System.out.println(skill);
			skill.levelUp();
		}
	}

	static void itemDrop() {
		NeutralUnit neutral = new Chicken();
		System.out.println("Creature: " + neutral);
		Item item = neutral.dropItem();
		int coins = neutral.dropCoin();
		System.out.println("Item dropped: " + item);
		System.out.println("Coins dropped: " + coins);
	}
}