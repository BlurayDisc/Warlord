package com.run.warlord.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.run.warlord.entity.item.weapon.Weapon;

@SuppressWarnings("unused")
public class GameData {

	public static void main(String[] args) {
		GameData data = new GameData();
		data.load();
		System.out.println(data);
//		data.save(data.weaponList);
	}

	private List<Weapon> weaponList = new ArrayList<>();
	private static final String[] WEAPON_NAMES = new String[] {"Wooden", "Bronze", "Iron", "Steel", "Silver", "Black", "Mithril", "Golden", "Admant", "Rune", "Dragon"};
	
//	public void load() {
//		for (int i = 0; i < WEAPON_NAMES.length; i++) {
//			Weapon weapon = new Weapon.Builder()
//					.name("Dagger")
//					.accuracy(i * 3)
//					.strength(i - 1)
//					.agility(i - 2)
//					.intelligence(i - 3)
//					.build();
//			weapon.randomize(2);
//			weaponList.add(weapon);
//		}
//	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		String path = "resources/game.data";
		try (
			ObjectInputStream ois = new ObjectInputStream(
									new FileInputStream(
									new File(path)));
		) {
			Object rawObj = ois.readObject();
			this.weaponList = (ArrayList<Weapon>) rawObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(Object obj) {
		String path = "resources/game.data";
		try (
			ObjectOutputStream oos = new ObjectOutputStream(
									 new FileOutputStream(
									 new File(path))) 
		) {
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
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
