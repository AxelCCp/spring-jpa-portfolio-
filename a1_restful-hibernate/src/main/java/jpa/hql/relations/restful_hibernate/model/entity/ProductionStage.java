package jpa.hql.relations.restful_hibernate.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="production_stages")
public class ProductionStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numOfStage;
    private String descripcion;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNumOfStage() {
        return numOfStage;
    }
    public void setNumOfStage(Integer numOfStage) {
        this.numOfStage = numOfStage;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //uso hashcode & equals,  para poder desasignar una etapa de produccion a un trabajador, comparando el obj a eliminar a través de las tres variables de esta clase.
    //si no se sobreescriben estos metodos en esta clase,  va a eliminar comparando la instancia, lo q no está del todo correcto.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((numOfStage == null) ? 0 : numOfStage.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductionStage other = (ProductionStage) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numOfStage == null) {
            if (other.numOfStage != null)
                return false;
        } else if (!numOfStage.equals(other.numOfStage))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        return true;
    }

    

    

}
