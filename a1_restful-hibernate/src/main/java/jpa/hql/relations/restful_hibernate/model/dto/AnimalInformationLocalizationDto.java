package jpa.hql.relations.restful_hibernate.model.dto;

import jpa.hql.relations.restful_hibernate.model.entity.Animal;
import jpa.hql.relations.restful_hibernate.model.entity.Information;
import jpa.hql.relations.restful_hibernate.model.entity.Localization;

public class AnimalInformationLocalizationDto {

    private Animal animal;
    private Information information;
    private Localization localization;

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Information getInformation() {
        return information;
    }
    public void setInformation(Information information) {
        this.information = information;
    }
    public Localization getLocalization() {
        return localization;
    }
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    
}
