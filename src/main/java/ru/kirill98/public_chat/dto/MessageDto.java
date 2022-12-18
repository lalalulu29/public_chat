package ru.kirill98.public_chat.dto;

import java.util.Date;
import java.util.Objects;

public class MessageDto {
    private Long id;

    private String person;

    private String body;

    private Date date;

    public MessageDto() {
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDto that = (MessageDto) o;
        return Objects.equals(id, that.id) && Objects.equals(person, that.person) && Objects.equals(body, that.body) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, body, date);
    }

    @Override
    public String toString() {
        return "Логин: " + getPerson() + "\n" +
                "Дата: " + getDate() + "\n" +
                "Сообщение: " + getBody() + "\n" +
                "__________________" + "\n";
    }
}
