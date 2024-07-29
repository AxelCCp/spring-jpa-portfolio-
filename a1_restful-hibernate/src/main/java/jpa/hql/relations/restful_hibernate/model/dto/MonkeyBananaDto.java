package jpa.hql.relations.restful_hibernate.model.dto;

import jpa.hql.relations.restful_hibernate.model.entity.Banana;
import jpa.hql.relations.restful_hibernate.model.entity.Monkey;

public class MonkeyBananaDto {

    private Monkey monkey;
    private Banana banana;
    
    public Monkey getMonkey() {
        return monkey;
    }
    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
    public Banana getBanana() {
        return banana;
    }
    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    

}
