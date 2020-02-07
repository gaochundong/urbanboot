package ai.sangmado.urbanboot.urban.traffic.management.contract;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum TrafficLightColor {
    Unknown(0, "未知"),
    Red(1, "红"),
    Yellow(2, "黄"),
    Green(3, "绿");

    @JsonValue
    private Integer value;

    private String description;

    TrafficLightColor(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Integer, TrafficLightColor> mapping = new HashMap<>();

    static {
        for (TrafficLightColor level : values()) {
            mapping.put(level.getValue(), level);
        }
    }

    @JsonCreator
    public static TrafficLightColor cast(int i) {
        TrafficLightColor level = mapping.get(i);
        if (level == null) {
            throw new IllegalArgumentException("Cannot cast integer to enum.");
        }
        return level;
    }

    public static TrafficLightColor parse(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (TrafficLightColor level : values()) {
            if (level.name().equalsIgnoreCase(s)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Cannot parse string to enum.");
    }
}