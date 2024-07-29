package jpa.hql.relations.restful_hibernate.model.entity;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ants")
public class Ant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    //unidireccional
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<AntHillCave>antHillCaveList;

    public Ant() {
        this.antHillCaveList = new HashSet<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Set<AntHillCave> getAntHillCaveList() {
        return antHillCaveList;
    }
    public void setAntHillCaveList(Set<AntHillCave> antHillCaveList) {
        this.antHillCaveList = antHillCaveList;
    } 

    

}
