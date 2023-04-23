package com.nubeero.eclat.model.job;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TalentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String company;
    private String recruiter;
    private String jobRole;
    private String skill;
    private String location;
    private String status;

}
