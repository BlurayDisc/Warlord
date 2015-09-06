package com.run.warlord.entity.item;

public enum Quality {

	/* Physical Damage, Physical Defense, Ranged Damage, Ranged Defense, Magic Damage, Magic Defense */
	Wooden(1, 1, 2, 2), 
	Bronze(2, 0 , 0, 0), 
	Iron(3, 0 , 0, 0), 
	Steel(4, 0 , 0, 0),
	Silver(5, 0 , 0, 0), 
	Golden(7, 0 , 0, 0),
	Mithril(6, 0 , 0, 0),
	Elven(8, 0 , 0, 0),
	Dwarven(8, 0 , 0, 0),
	Orcish(9, 0 , 0, 0),
	Ebony(10, 0 , 0, 0),
	Daedric(11, 0 , 0, 0), 
	Dragon(12, 0 , 0, 0);
	
	private int pDmg;
	private int pDef;
	private int mDmg;
	private int mDef;
	
	private Quality(int pDmg, int pDef, int mDmg, int mDef) {
		this.pDmg = pDmg;
		this.pDef = pDef;
		this.mDmg = mDmg;
		this.mDef = mDef;
	}

	public int getpDmg() {
		return pDmg;
	}

	public void setpDmg(int pDmg) {
		this.pDmg = pDmg;
	}

	public int getpDef() {
		return pDef;
	}

	public void setpDef(int pDef) {
		this.pDef = pDef;
	}

	public int getmDmg() {
		return mDmg;
	}

	public void setmDmg(int mDmg) {
		this.mDmg = mDmg;
	}

	public int getmDef() {
		return mDef;
	}

	public void setmDef(int mDef) {
		this.mDef = mDef;
	}
	
	@Override
	public String toString() {
		return this.name() + " ";
	}
}