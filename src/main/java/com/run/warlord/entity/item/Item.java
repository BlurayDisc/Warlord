package com.run.warlord.entity.item;

/**
 * An Item is an entity in the warlord project. It can be obtained or dropped by
 * a unit as it's specified by the Obtainable interface.
 *
 * @author RuN
 *
 */
public class Item implements Obtainable {

    private static final long serialVersionUID = 1L;
    protected String name;
    protected Quality quality;

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
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((quality == null) ? 0 : quality.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (quality != other.quality)
            return false;
        return true;
    }

    @Override
    public String toString() {

        return "Item [name=" + name + ", quality=" + quality + "]";
    }
}