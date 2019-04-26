package java_study;

import java.util.UUID;

public class generateUUID {
    public String generateUU() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
