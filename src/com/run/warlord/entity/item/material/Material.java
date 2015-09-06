package com.run.warlord.entity.item.material;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.item.Quality;

public class Material extends Item {

	private MaterialType type;
	private Quality quality;
	
	public Material() {
		
	}
	
	public Material(MaterialType type, Quality quality) {
		this.name = type.name();
		this.setType(type);
		this.quality = quality;
	}

	public Quality getQuality() {
		return quality;
	}

	public void setQuality(Quality quality) {
		this.quality = quality;
	}

	public MaterialType getType() {
		return type;
	}

	public void setType(MaterialType type) {
		this.type = type;
	}
}