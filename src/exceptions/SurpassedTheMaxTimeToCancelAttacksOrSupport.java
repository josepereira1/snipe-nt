package exceptions;

public class SurpassedTheMaxTimeToCancelAttacksOrSupport extends Exception {

    public SurpassedTheMaxTimeToCancelAttacksOrSupport(Integer max) {
        super(String.format("Surpassed the max time to cancel your attack or support for snipe. The max time to cancel is %d minutes.", max));
    }
}
