package com.iv1201.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@Table(name = "competence")
public class Competence implements Serializable {
    @Id
    @Column(name="competence_id")
    @GeneratedValue
    private int id;
    
    @NotBlank
    @Size(min = 2, max = 100, message = "name is either to long or too short")
    private String name;
}
