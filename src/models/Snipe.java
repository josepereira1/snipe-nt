package models;

import utils.Utils;

import java.time.LocalDateTime;
import java.util.Map;

public class Snipe {
    private String name;
    private LocalDateTime attackTime;
    private LocalDateTime troopsOutTime;
    private LocalDateTime troopsBackTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(LocalDateTime attackTime) {
        this.attackTime = attackTime;
    }

    public LocalDateTime getTroopsOutTime() {
        return troopsOutTime;
    }

    public void setTroopsOutTime(LocalDateTime troopsOutTime) {
        this.troopsOutTime = troopsOutTime;
    }

    public LocalDateTime getTroopsBackTime() {
        return troopsBackTime;
    }

    public void setTroopsBackTime(LocalDateTime troopsBackTime) {
        this.troopsBackTime = troopsBackTime;
    }

    public static String toString(Map<String, Snipe> snipes, Integer maxNameSize) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(Snipe snipe : snipes.values()) {
            sb.append("=> ").append(toString(snipe, maxNameSize));
            if(index < snipes.size() - 1) {
                sb.append("\n");
            }
            index++;
        }
        if(snipes.isEmpty()) {
            return "Empty";
        } else {
            return sb.toString();
        }
    }

    public static String toString(Snipe snipe, Integer maxNameSize) {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ")
                    .append((Utils.repeatChar(' ', Math.max(0, maxNameSize - snipe.getName().length()))))
                    .append(snipe.getName()).append(" || ")
                .append("attackTime: ").append(snipe.getAttackTime()).append(" || ")
                .append("troopsOutTime: ").append(snipe.getTroopsOutTime()).append(" || ")
                .append("troopsBackTime: ").append(snipe.getTroopsBackTime());
        return sb.toString();
    }
}
