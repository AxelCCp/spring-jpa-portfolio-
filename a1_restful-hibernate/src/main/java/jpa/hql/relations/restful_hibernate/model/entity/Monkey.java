package jpa.hql.relations.restful_hibernate.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="monkeys")
public class Monkey {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idMonkey;
    private String name;
    private String raza;
    //bidireccional
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="monkey")
    private Banana banana;  //banana es la dueña de la relacion, pero monkey es la principal ya q va a gestionar la cascada.
    
    public Monkey() {
    }

    public Monkey(String name, String raza, Banana banana) {
        this.name = name;
        this.raza = raza;
        this.banana = banana;
    }

    public Long getIdMonkey() {
        return idMonkey;
    }
    public void setIdMonkey(Long idMonkey) {
        this.idMonkey = idMonkey;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public Banana getBanana() {
        return banana;
    }
    public void setBanana(Banana banana) {
        this.banana = banana;
        banana.setMonkey(this);
    }
    
    


}
