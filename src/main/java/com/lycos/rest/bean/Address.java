package com.lycos.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: Address
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Lycos
 * @date 2014年9月3日 下午9:36:46
 */
@XmlRootElement
public class Address {
    private String city;
    private String street;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
