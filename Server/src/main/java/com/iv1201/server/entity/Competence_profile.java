package com.iv1201.server.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private int id;
    
    @NotBlank()
    @Digits(integer = 100, fraction = 0)
    private int person_id;
    
    @NotBlank()
    @Digits(integer = 100, fraction = 0)
    private int competence_id;
    
    @NotBlank()
    @Digits(integer = 3, fraction = 0)
    private BigDecimal years_of_experience;
}
