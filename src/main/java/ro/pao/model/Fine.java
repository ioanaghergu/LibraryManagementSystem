package ro.pao.model;

import lombok.experimental.SuperBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Fine {
    private UUID id;
    private Double fineValue;
    private UUID id_member;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[Fine Value = " + fineValue + "]";
    }

}