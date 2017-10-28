package com.run.warlord.entity.item.material;

import com.run.warlord.entity.item.Item;
import com.run.warlord.entity.item.Quality;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Material extends Item {

    private static final long serialVersionUID = -562606093939805505L;

    private MaterialType type;
    private Quality quality;
}