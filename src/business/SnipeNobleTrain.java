package business;

import exceptions.SnipeNotExistsException;
import exceptions.SurpassedTheMaxTimeToCancelAttacksOrSupport;
import models.Snipe;
import utils.Utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SnipeNobleTrain {
    private static final Integer MINUTE_IN_MILLIS = 60*1000;

    private Map<String, Snipe> snipes;
    private Integer maxNameSize = 0;

    public SnipeNobleTrain() {
        this.snipes = new HashMap<>();
    }

    public void addSnipe(String snipeName, LocalDateTime troopsOutTime, LocalDateTime attackTime, Integer maxTimeToCancelYourAttackOrSupport) throws SurpassedTheMaxTimeToCancelAttacksOrSupport {
        Snipe snipe = new Snipe();
        snipe.setName(snipeName);
        snipe.setAttackTime(attackTime);
        snipe.setTroopsOutTime(troopsOutTime);
        LocalDateTime backTime = calculateTimesToSnipeNobleTrain(troopsOutTime, attackTime, maxTimeToCancelYourAttackOrSupport);
        snipe.setTroopsBackTime(backTime);
        checkMaxNameSize(snipeName);
        this.snipes.put(snipeName, snipe);
    }

    public void removeSnipe(String name) throws SnipeNotExistsException {
        if(this.snipes.containsKey(name)) {
            this.snipes.remove(name);
        } else {
            throw new SnipeNotExistsException(name);
        }
    }

    public void resetSnipes() {
        this.snipes = new HashMap<>();
    }

    public String snipesToString() {
        return Snipe.toString(snipes, maxNameSize);
    }

    public boolean snipeAlreadyExists(String name) {
        return snipes.containsKey(name);
    }

    private LocalDateTime calculateTimesToSnipeNobleTrain(LocalDateTime troopsOutTime, LocalDateTime attackTime, Integer maxTimeToCancelYourAttackOrSupport) throws SurpassedTheMaxTimeToCancelAttacksOrSupport {
        Integer h1 = troopsOutTime.getHour();
        Integer m1 = troopsOutTime.getMinute();
        Integer s1 = troopsOutTime.getSecond();
        Integer h2 = attackTime.getHour();
        Integer m2 = attackTime.getMinute();
        Integer s2 = attackTime.getSecond();
        long troopsOut = Utils.getMillis(h1, m1, s1);
        long attack = Utils.getMillis(h2, m2, s2);
        long backTroops = troopsOut + ((attack - troopsOut) / 2);
        if(backTroops - troopsOut >= ((long) maxTimeToCancelYourAttackOrSupport * MINUTE_IN_MILLIS)) {
            throw new SurpassedTheMaxTimeToCancelAttacksOrSupport(maxTimeToCancelYourAttackOrSupport);
        }
        return Utils.fromTimestampsToLocalDate(backTroops);
    }

    private void checkMaxNameSize(String newName) {
        if(newName.length() > maxNameSize) {
            maxNameSize = newName.length();
        }
    }
}
