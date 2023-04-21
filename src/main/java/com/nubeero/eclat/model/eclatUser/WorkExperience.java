package com.nubeero.eclat.model.eclatUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String primarySkill;
    private String skillLevel;
}
