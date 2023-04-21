package com.nubeero.eclat.model.eclatUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {
    private String primarySkill;
    private String skillLevel;
}
