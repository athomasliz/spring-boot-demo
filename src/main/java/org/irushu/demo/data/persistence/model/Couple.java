package org.irushu.demo.data.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name="couple")
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="husband", columnDefinition = "varchar(45)")
    private String husband;
    @Column(name="wife", columnDefinition = "varchar(45)")
    private String wife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHusband() {
        return husband;
    }

    public void setHusband(String husband) {
        this.husband = husband;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "id=" + id +
                ", husband='" + husband + '\'' +
                ", wife='" + wife + '\'' +
                '}';
    }
}
