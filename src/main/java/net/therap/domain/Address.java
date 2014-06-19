package net.therap.domain;

import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String gip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGip() {
        return gip;
    }

    public void setGip(String gip) {
        this.gip = gip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", gip='" + gip + '\'' +
                '}';
    }
}
