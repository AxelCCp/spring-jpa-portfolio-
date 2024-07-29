package jpa.hql.relations.restful_hibernate.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ants")
public class AntHillCave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numOfCave;
    private String queenAnt;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNumOfCave() {
        return numOfCave;
    }
    public void setNumOfCave(Integer numOfCave) {
        this.numOfCave = numOfCave;
    }
    public String getQueenAnt() {
        return queenAnt;
    }
    public void setQueenAnt(String queenAnt) {
        this.queenAnt = queenAnt;
    }
    
    
}
