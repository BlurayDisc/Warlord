package com.run.warlord.entity.unit.player.warrior;

import com.run.warlord.entity.unit.player.Player;

public class Warrior extends Player {

    public Warrior() {
        super("Warrior");
        this.strength = 7;
        this.agility = 2;
        this.intelligence = 1;
    }
}