package jpa.hql.relations.restful_hibernate.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.dao.AnimalDao;
import jpa.hql.relations.restful_hibernate.model.dao.InformationDao;
import jpa.hql.relations.restful_hibernate.model.dao.LocalizationDao;
import jpa.hql.relations.restful_hibernate.model.dto.AnimalInformationLocalizationDto;
import jpa.hql.relations.restful_hibernate.model.entity.Animal;
import jpa.hql.relations.restful_hibernate.model.entity.Information;
import jpa.hql.relations.restful_hibernate.model.entity.Localization;

@RestController
@RequestMapping("/animal")
public class AnimalRest {

    @GetMapping("/list")
    public ResponseEntity<?>getPatientList() {
        return ResponseEntity.ok().body(this.animalDao.findAll());
    }


    @PostMapping("/create")
    public ResponseEntity<?>createPatient(@RequestBody AnimalInformationLocalizationDto animalInformationLocalizationDto) {

        Information information = animalInformationLocalizationDto.getInformation();
        Animal animal = animalInformationLocalizationDto.getAnimal();
        Localization localization = animalInformationLocalizationDto.getLocalization();
        
        this.localizationDao.save(localization);

        animal.setLocalization(this.localizationDao.findById(1L).orElseThrow());    //funcionará solo con un registro ... se podría usar un find by name con un unique constraint.  o bien agregar otro campo unico.
        this.animalDao.save(animal);

        information.setAnimal(animal);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.informationDao.save(information));
    }    


    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private LocalizationDao localizationDao;


}
