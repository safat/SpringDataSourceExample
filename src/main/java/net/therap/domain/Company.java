package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idcompany")
    private int idCompany;

    @Column (name = "name")
    private String name;

    @Column (name = "address")
    private String address;

    @OneToMany (targetEntity = Client.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name = "company_client",
            joinColumns = @JoinColumn (name = "company_idcompany"),
            inverseJoinColumns = @JoinColumn (name = "client_idclient"))
    private List<Client> clientList;


    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
