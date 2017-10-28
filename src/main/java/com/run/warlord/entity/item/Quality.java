package com.run.warlord.entity.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Quality {

    /* Physical Damage, Physical Defense, Ranged Damage, Ranged Defense, Magic Damage, Magic Defense */
    Wooden(1, 1, 2, 2),
    Bronze(2, 0, 0, 0),
    Iron(3, 0, 0, 0),
    Steel(4, 0, 0, 0),
    Silver(5, 0, 0, 0),
    Golden(7, 0, 0, 0),
    Mithril(6, 0, 0, 0),
    Elven(8, 0, 0, 0),
    Dwarven(8, 0, 0, 0),
    Orcish(9, 0, 0, 0),
    Ebony(10, 0, 0, 0),
    Daedric(11, 0, 0, 0),
    Dragon(12, 0, 0, 0);

    @Getter
    @Setter
    private int pDmg;

    @Getter
    @Setter
    private int pDef;

    @Getter
    @Setter
    private int mDmg;

    @Getter
    @Setter
    private int mDef;
}