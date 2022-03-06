package com.iv1201.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author theok
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competence_profile")
public class Competence_profile implements Serializable {
    @Id
    @Column(name="competence_profile_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    private int id;
    
   
    private int person_id;
    
    
    private int competence_id;
    
    private BigDecimal years_of_experience;
}
