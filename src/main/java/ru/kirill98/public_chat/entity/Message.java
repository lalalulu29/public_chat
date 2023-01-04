package ru.kirill98.public_chat.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    private String body;

    private Date date;


    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) && personId.equals(message.personId) && body.equals(message.body) && date.equals(message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, body, date);
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", personId=" + personId +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
