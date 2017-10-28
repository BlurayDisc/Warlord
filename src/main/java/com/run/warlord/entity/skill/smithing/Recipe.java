package com.run.warlord.entity.skill.smithing;

import java.util.HashMap;
import java.util.Map;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.skill.Skill;

public class Recipe {

    private Map<Item, Integer> requirements;
    private Skill requiredSkill;

    public Recipe() {
        this.setRequirements(new HashMap<>());
    }

    public Map<Item, Integer> getRequirements() {

        return requirements;
    }

    public void setRequirements(Map<Item, Integer> requirements) {

        this.requirements = requirements;
    }

    public Skill getRequiredSkill() {

        return requiredSkill;
    }

    public void setRequiredSkill(Skill requiredSkill) {

        this.requiredSkill = requiredSkill;
    }
}
