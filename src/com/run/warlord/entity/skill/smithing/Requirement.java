package com.run.warlord.entity.skill.smithing;

public class Requirement {
	
	private int ingot;
	private int log;
	private int ore;
	private int lumber;
	
	/* *********************
	 ** Getters & Setters **
	 ***********************/
	
	public int getIngot() {
		return ingot;
	}
	public void setIngot(int bar) {
		this.ingot = bar;
	}
	public int getLog() {
		return log;
	}
	public void setLog(int log) {
		this.log = log;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public int getLumber() {
		return lumber;
	}
	public void setLumber(int lumber) {
		this.lumber = lumber;
	}

}
