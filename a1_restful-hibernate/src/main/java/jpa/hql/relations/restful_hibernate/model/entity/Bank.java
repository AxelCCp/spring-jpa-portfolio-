package jpa.hql.relations.restful_hibernate.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="banks")
public class Bank {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBank;
    private String name;
    
    public Long getIdBank() {
        return idBank;
    }
    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    

}
