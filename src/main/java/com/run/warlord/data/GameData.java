package com.run.warlord.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.run.warlord.entity.item.weapon.Weapon;

import lombok.Builder;

@Builder
public class GameData {

    public static final String APP_NAME = "Warlord";
    public static final String APP_VERSION = "v0.0.2";

    public static void main(String[] args) throws IOException {

        GameData.builder()
                .build()
                .load();
        // data.save(data.weaponList);
    }

    private List<Weapon> weaponList = new ArrayList<>();
    private static final String[] WEAPON_NAMES = new String[] {
            "Wooden",
            "Bronze",
            "Iron",
            "Steel",
            "Silver",
            "Black",
            "Mithril",
            "Golden",
            "Admant",
            "Rune",
            "Dragon" };

    public void load2() {

        for (int i = 0; i < WEAPON_NAMES.length; i++) {

            Weapon weapon = new Weapon();
            weapon.setAccuracy(i * 3);
            weapon.setStrength(i - 1);
            weapon.setAgility(i - 2);
            weapon.setIntelligence(i - 3);
            weapon.randomize(2);
            weaponList.add(weapon);
        }
    }

    public void load() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/game.data"))) {
            for (Object obj : (List<?>) ois.readObject()) {
                weaponList.add((Weapon) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Object obj) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/game.data"))) {
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();
        for (Weapon w : weaponList)
            b.append(w).append("\n");
        return b.toString();
    }
}
