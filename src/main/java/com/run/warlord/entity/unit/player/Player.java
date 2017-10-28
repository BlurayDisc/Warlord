package com.run.warlord.entity.unit.player;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.item.StatesItem;
import com.run.warlord.entity.item.inventory.Inventory;
import com.run.warlord.entity.skill.Skill;
import com.run.warlord.entity.skill.smithing.Craftable;
import com.run.warlord.entity.skill.smithing.Forgable;
import com.run.warlord.entity.unit.Unit;

public abstract class Player extends Unit {

    private String playerName;

    private Skill level;
    private Skill mining;
    private Skill smithing;
    private Skill woodCutting;
    private Skill crafting;
    private Skill arcaneCrafting;
    private Skill alchemy;
    private Skill fishing;
    private Skill cooking;

    private Inventory inventory;

    public Player(String name) {
        super(name);
        this.level = new Skill("level");
        this.mining = new Skill("Mining");
        this.smithing = new Skill("Smithing");
        this.woodCutting = new Skill("Woodcutting");
        this.crafting = new Skill("Crafting");
        this.arcaneCrafting = new Skill("Arcanecrafting");
        this.fishing = new Skill("Fishing");
        this.cooking = new Skill("Cooking");
        this.alchemy = new Skill("Alchemy");
        this.inventory = new Inventory();
    }

    public void acquire(Item item) {

        if (item instanceof StatesItem) {
            this.randomize((StatesItem) item);
        }
        inventory.put(item);
    }

    /**
     * When the player acquires an item from smithing or crafting, the item's
     * attributes
     * are calculated based on the level of the player's smithing or crafting
     * skills,
     * with random factor taking place.
     *
     * @param item
     */
    private void randomize(StatesItem item) {

        if (item instanceof Forgable) {
            item.randomize(smithing.getLevel());
        } else if (item instanceof Craftable) {
            item.randomize(crafting.getLevel());
        }
    }

    /*
     * *********************
     ** Getters & Setters **
     ***********************/

    public String getPlayerName() {

        return playerName;
    }

    public void setPlayerName(String playerName) {

        this.playerName = playerName;
    }

    public Skill getMining() {

        return mining;
    }

    public Skill getSmithing() {

        return smithing;
    }

    public Skill getWoodCutting() {

        return woodCutting;
    }

    public Skill getCrafting() {

        return crafting;
    }

    public Skill getFishing() {

        return fishing;
    }

    public Skill getCooking() {

        return cooking;
    }

    public Skill getArcaneCrafting() {

        return arcaneCrafting;
    }

    public Skill getAlchemy() {

        return alchemy;
    }

    public Skill getLevel() {

        return level;
    }
}