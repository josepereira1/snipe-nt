package utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Utils {

    public static final String PREFIX = ">> ";
    private static final String TIMEZONE = "UTC";
    private static final LocalDateTime CUURRENT_TIME = LocalDateTime.now();

    private Utils() {

    }

    public static LocalDateTime convertToLocalDateTime(Integer h, Integer m, Integer s) {
        return LocalDateTime.of(CUURRENT_TIME.getYear(), CUURRENT_TIME.getMonth(), CUURRENT_TIME.getDayOfMonth(), h, m, s);
    }

    public static long getMillis(Integer h, Integer m, Integer s) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime attack = LocalDateTime.of(currentTime.getYear(), currentTime.getMonth(), currentTime.getDayOfMonth(), h, m, s, 0);
        ZonedDateTime zdt = attack.atZone(ZoneId.of(TIMEZONE));
        return zdt.toInstant().toEpochMilli();
    }

    public static LocalDateTime fromTimestampsToLocalDate(long timestamps) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamps), ZoneId.of(TIMEZONE));
    }

    public static void displayPrefix() {
        System.out.print(Utils.PREFIX);
    }

    public static String repeatChar(Character character, Integer repeat) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++) {
            sb.append(character);
        }
        return sb.toString();
    }
}
