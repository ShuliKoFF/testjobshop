package ru.shrf.testjob.exeption;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    public static void error(String message) {
        throw new ValidationException(message);
    }

    public static void checkNotNull(Object value, String paramName) {
        if(value == null){
            error(String.format("Parameter '%s' is null", paramName));
        }
    }

    public static void checkNotEmpty(boolean isEmpty, String paramName) {
        if (isEmpty) {
            error(String.format("Parameter '%s' is empty", paramName));
        }
    }

    public static void checkMapCart(Map<UUID, Integer> value, String paramName) {
        checkNotNull(value, paramName);
        checkNotEmpty(value.isEmpty(), paramName);
        value.entrySet().stream().forEach(
                pair -> {
                    checkNotNull(pair.getKey(), paramName + " contains a UUID key which");
                    checkNotNull(pair.getValue(), paramName + "contains a value which");
                    checkNotNegative(BigDecimal.valueOf(pair.getValue()), paramName + "contains a value which");
                }
        );
    }

    public static void checkNotNegative(BigDecimal value, String paramName) {
        if(value.compareTo(BigDecimal.ZERO) < 0) {
            error(String.format("Parameter '%s' is Negative", paramName));
        }
    }

    public static void checkUUID(String value, String paramName) {
        if(!UUID_REGEX.matcher(value).matches()){
            error(String.format("Parameter '%s' is not UUID, expected '%s'", paramName, UUID_REGEX.pattern()));
        }
    }
}
