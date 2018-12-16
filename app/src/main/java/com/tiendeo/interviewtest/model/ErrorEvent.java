package com.tiendeo.interviewtest.model;

/**
 * Entity to manage application errors.
 */
public class ErrorEvent {

    private int type;
    private String info;
    private String description;

    public ErrorEvent() {
    }

    public ErrorEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorEvent{" +
            "type='" + type + '\'' +
            ", info='" + info + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
