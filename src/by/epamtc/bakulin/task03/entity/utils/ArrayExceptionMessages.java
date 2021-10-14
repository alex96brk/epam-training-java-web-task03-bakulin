package by.epamtc.bakulin.task03.entity.utils;

public enum ArrayExceptionMessages {
    NEGATIVE_CAPACITY_MSG("Negative Capacity Is Not Allowed");

    String message;

    ArrayExceptionMessages(String message) {
        this.message = message;
    }

    public String getText() {
        return this.message;
    }
}
