package com.run.warlord.entity.unit.npc;

public class ShopKeeper {

	private static final String[] FIRST_NAMES = new String[] {
		"Chris",
		"Run",
	};
	
	private static final String[] LAST_NAMES = new String[] {
		"Davis",
		"Yan",
	};
	
	public String generateName() {
		String firstname = random(FIRST_NAMES);
		String lastname = random(LAST_NAMES);
		return firstname + lastname;
	}
	
	public String random(String[] args) {
		return args[0];
	}
}
