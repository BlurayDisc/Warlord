package com.run.warlord.data;

import java.util.ArrayList;
import java.util.List;

import com.run.warlord.entity.item.weapon.Weapon;

public class GameData {

	private List<Weapon> weaponList = new ArrayList<>();
	private static final String[] WEAPON_NAMES = new String[] {"Wooden", "Bronze", "Iron", "Steel", "Silver", "Black", "Mithril", "Golden", "Admant", "Rune", "Dragon"};
	
	public void load() {
		for (int i = 0; i < WEAPON_NAMES.length; i++) {
			Weapon weapon = new Weapon.Builder()
					.name("Dagger")
					.accuracy(i * 3)
					.strength(i - 1)
					.agility(i - 2)
					.intelligence(i - 3)
					.build();
			weapon.randomize(2);
			weaponList.add(weapon);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (Weapon w: weaponList)
			b.append(w).append("\n");
		return b.toString();
	}
}
