package jpa.hql.relations.restful_hibernate.model.entity;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="clients")
public class Client  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String lastname;
    
    @Column(name="forma_pago")
    private String formaPago;
    
    //unidireccional
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)                                               
    private Set<AddressT1>addresses_t1;

    //unidireccional
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true) 
    private Set<BankAccount> bankAccounts; 

    //unidireccional
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)   //onetomany, sin tabla intermedia. La clase Email es la dueña de la relacion.
    @JoinColumn(name="client_id")                               //en la tabla de email va a crear la FK client_id.
    private Set<Email>emailsAccounts;

    //unidireccional
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)          
    @JoinTable(name="custom_tbl_client_equipos_reg", joinColumns=@JoinColumn(name="id_client"), inverseJoinColumns=@JoinColumn(name="id_equipos_reg"), uniqueConstraints=@UniqueConstraint(columnNames="id_equipos_reg"))
    private Set<EquipoRegistrado> equiposRegistrados;


    static final long serialVersionUID = 62L;

    public Client() {
        this.addresses_t1 = new HashSet<>();
        this.bankAccounts = new HashSet<>();
        this.emailsAccounts = new HashSet<>();
        this.equiposRegistrados = new HashSet<>();
    }

    public Client(String name, String lastname, String formaPago) {
        this();
        this.name = name;
        this.lastname = lastname;
        this.formaPago = formaPago;
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
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Set<AddressT1> getAddresses_t1() {
        return addresses_t1;
    }

    public void setAddresses_t1(Set<AddressT1> addresses_t1) {
        this.addresses_t1 = addresses_t1;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Set<Email> getEmailsAccounts() {
        return emailsAccounts;
    }

    public void setEmailsAccounts(Set<Email> emailsAccounts) {
        this.emailsAccounts = emailsAccounts;
    }

    public Set<EquipoRegistrado> getEquiposRegistrados() {
        return equiposRegistrados;
    }

    public void setEquiposRegistrados(Set<EquipoRegistrado> equiposRegistrados) {
        this.equiposRegistrados = equiposRegistrados;
    }

}
