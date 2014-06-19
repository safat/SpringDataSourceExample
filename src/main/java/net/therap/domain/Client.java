package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idclient")
    private Integer idclient;

    @Column (name = "name")
    private String name;

    @Column (name = "address")
    private String address;

    @ManyToMany(mappedBy = "clientList", fetch = FetchType.EAGER)
    private List<Company> companyList;

    @OneToMany (targetEntity = Service.class, fetch = FetchType.EAGER)
    @JoinTable (name = "client_service",
            joinColumns = @JoinColumn (name = "client_id"),
            inverseJoinColumns = @JoinColumn (name = "service_id"))
    private Set<Service> serviceList;

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
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

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }


    public Set<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Set<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
