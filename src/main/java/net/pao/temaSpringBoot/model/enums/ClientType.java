package net.pao.temaSpringBoot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientType {

    NATURAL(0, "Natural"),
    LEGAL(1, "Legal");

    private final Integer index;
    private final String name;
}
