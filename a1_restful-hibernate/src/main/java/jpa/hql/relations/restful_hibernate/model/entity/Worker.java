package jpa.hql.relations.restful_hibernate.model.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="workers")
public class Worker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    //unidireccional con tabla intermedia
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tbl_workers_productionstage", joinColumns = @JoinColumn(name="worker_id"),
    inverseJoinColumns = @JoinColumn(name="productionstage_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"worker_id", "productionstage_id"}))
    private Set<ProductionStage>productionStages;

    public Worker() {
        this.productionStages = new HashSet<>();
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
    public Set<ProductionStage> getProductionStages() {
        return productionStages;
    }
    public void setProductionStages(Set<ProductionStage> productionStages) {
        this.productionStages = productionStages;
    }

    
}
