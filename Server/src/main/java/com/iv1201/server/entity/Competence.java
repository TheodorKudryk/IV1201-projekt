package com.iv1201.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String name;
}
