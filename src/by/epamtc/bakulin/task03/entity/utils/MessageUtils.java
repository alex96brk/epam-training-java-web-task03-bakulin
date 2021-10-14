package by.epamtc.bakulin.task03.entity.utils;

public class MessageUtils {

    public static String generateMessage(String message, int reasonArgument) {
        return String.format("%s: %d", message, reasonArgument);
    }
    public static String generateMessage(String message) {
        return message;
    }

}
