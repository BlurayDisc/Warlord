package com.run.warlord.entity.item;

public abstract class StatesItem extends Item {

    private static final long serialVersionUID = 1L;

    /**
     * Randomizes the states of this Item.
     * <p>
     * Sub classes of this object must implement this method which applies the
     * randomization for it's item category.
     *
     * @param factor
     */
    public abstract void randomize(int factor);

    /**
     * Applies the randomization for the passed in value.
     *
     * @param value
     *            The value to be applied to.
     * @param factor
     *            the factor where factor = base + f / 100, f must be > 0 and
     *            base value is 0.1.
     * @return the new value, with randomization applied.
     */
    protected int applyTo(int value, double factor) {

        // random number between -0.2 and 0.8.
        double rand = 0.8 - Math.random();
        return (int) Math.round(value + value * factor * rand);
    }
}