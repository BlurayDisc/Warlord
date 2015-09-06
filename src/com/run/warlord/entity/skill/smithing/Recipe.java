package com.run.warlord.entity.skill.smithing;

import java.util.HashMap;
import java.util.Map;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.skill.Skill;

public class Recipe {

	private Map<Item, Integer> requirements;
	private Skill requiredSkill;
	
	Recipe() {
		requirements = new HashMap<>();
	}
}
