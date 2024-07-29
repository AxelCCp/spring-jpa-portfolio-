package jpa.hql.relations.restful_hibernate.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bananas")
public class Banana {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBanana;
    private String color;
    private String place;
    //bidireccional - banana es dueña de la relacion.
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="id_banana")
    private Monkey monkey;              

    public Long getIdBanana() {
        return idBanana;
    }
    public void setIdBanana(Long idBanana) {
        this.idBanana = idBanana;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public Monkey getMonkey() {
        return monkey;
    }
    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }

}
