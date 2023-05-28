package net.pao.temaSpringBoot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum AccountType {

    PERSONAL (0, "Personal"),
    BUSINESS (1, "Business");

    private final Integer index;
    private final String name;

}
