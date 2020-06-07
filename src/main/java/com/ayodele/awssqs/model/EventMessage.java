package com.ayodele.awssqs.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EventMessage {

    private final String name;
    private final Date date;
    private final String description;

    @JsonCreator
    public EventMessage(@JsonProperty("name") String name,
                        @JsonProperty("date") Date date,
                        @JsonProperty("description") String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventMessage eventMessage = (EventMessage) o;
        return name.equals(eventMessage.name) &&
                date.equals(eventMessage.date) &&
                description.equals(eventMessage.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, description);
    }
}
