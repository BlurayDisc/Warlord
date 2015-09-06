package com.run.warlord.entity.item.inventory;

import java.util.LinkedList;
import java.util.List;

import com.run.warlord.entity.item.Item;

public class Inventory {
	
	private int capacity;
	private List<Item> inventory;
	
	public Inventory() {
		this.capacity = 25;
		this.inventory = new LinkedList<>();
	}
	
	public void increaseCapacity(int value) {
		capacity += value;
	}
	
	public void put(Item item) {
		if (inventory.size() == capacity) {
			throw new IllegalArgumentException("big!");
		}
		inventory.add(item);
	}
	
	public boolean isFull() {
		return inventory.size() == capacity;
	}
	
	public boolean take(Item item) {
		return inventory.remove(item);
	}
	
	public boolean has(Item item) {
		return inventory.contains(item);
	}
	
	public boolean has(Item item, int count) {
		int num = 0;
		for (Item i: inventory) {
			if (item.equals(i)) {
				num++;
			}
		}
		return num >= count;
	}

}
