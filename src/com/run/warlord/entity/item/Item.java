package com.run.warlord.entity.item;

/**
 * An Item is an entity in the warlord project. It can be obtained or dropped by 
 * a unit as it's specified by the Obtainable interface.
 * @author RuN
 *
 */
public class Item implements Obtainable {
	
	protected String name;
	protected Quality quality;
	
	public Item() {
		this.name = null;
		this.quality = null;
	}
	
	/* *********************
	 ** Getters & Setters **
	 ***********************/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		else if (o == null) return false;
		else if (!(o instanceof Item)) return false;
		else {
			Item item = (Item) o;
			return this.name.equals(item.name);
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}