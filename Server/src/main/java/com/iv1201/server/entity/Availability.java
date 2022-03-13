
package com.iv1201.server.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "availability")
public class Availability implements Serializable {
    @Id
    @Column(name="availability_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    private int id;
    private int person_id;
    private Date from_date;
    private Date to_date;
}
