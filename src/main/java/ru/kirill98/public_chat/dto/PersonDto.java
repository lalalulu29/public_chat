package ru.kirill98.public_chat.dto;

import java.util.Date;
import java.util.Objects;

public class PersonDto {
    private String address;

    private String login;

    private Date date;

    public PersonDto() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(address, personDto.address) && Objects.equals(login, personDto.login) && Objects.equals(date, personDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, login, date);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "address='" + address + '\'' +
                ", login='" + login + '\'' +
                ", date=" + date +
                '}';
    }
}
