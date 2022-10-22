package org.dng.inetconnectionrequests.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientinfo_tbl", schema = "inet_connection_db")
public class ClientInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "clientFIO")
    private String clientFio;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic
    @Column(name = "address")
    private String address;

    public ClientInfoEntity() {

    }
    public ClientInfoEntity(String clientFio, String email, String phoneNumber, String address) {
        this.clientFio = clientFio;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ClientInfoEntity(int id, String clientFio, String email, String phoneNumber, String address) {
        this.id = id;
        this.clientFio = clientFio;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientInfoEntity that = (ClientInfoEntity) o;

        if (id != that.id) return false;
        if (clientFio != null ? !clientFio.equals(that.clientFio) : that.clientFio != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientFio != null ? clientFio.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientInfoEntity{" +
                "id=" + id +
                ", clientFio='" + clientFio + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + address + '\'' +
                '}';
    }
}
