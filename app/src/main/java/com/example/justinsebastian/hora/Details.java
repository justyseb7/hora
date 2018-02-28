package com.example.justinsebastian.hora;

/**
 * Created by JOYCE on 18-02-2018.
 */

public class Details {
    String source;
    String destination;
    String time;
    String name;
    String type;

    public Details() {
    }

    public Details(String source, String destination, String time, String name, String type) {
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.name = name;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
