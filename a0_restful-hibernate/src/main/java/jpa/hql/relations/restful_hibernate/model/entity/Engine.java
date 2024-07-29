package jpa.hql.relations.restful_hibernate.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Engine {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="engine_code", unique=true)
    private String engineCode;
    private String brand;
    @Column(name="year_production")
    private Integer yearProduction;
    
    public Engine() {
    }

    public Engine(Long id, String engineCode, String brand, Integer yearProduction) {
        this.id = id;
        this.engineCode = engineCode;
        this.brand = brand;
        this.yearProduction = yearProduction;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEngineCode() {
        return engineCode;
    }
    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Integer getYearProduction() {
        return yearProduction;
    }
    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    


}
