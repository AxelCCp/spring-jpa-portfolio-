package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.dto.MonkeyBananaDto;
import jpa.hql.relations.restful_hibernate.model.entity.Monkey;

public interface MonkeyService {

    List<Monkey>monkeyList();
    Optional<Monkey>getByMonkeyId(Long id);
    Optional<Monkey> saveMonkey(MonkeyBananaDto monkeyBanana);
    Optional<Monkey> deleteMonkey(Long id);

}
