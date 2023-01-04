package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String TIME_FORMAT = "H:mm:ss.SSSSSS";
    private static final int START_DURATION = 100;
    private static final int ZERO = 0;
    private static final int BOUND = 5;

    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int multiplier = random.nextInt(BOUND);
        int duration = multiplier == ZERO ? START_DURATION : START_DURATION * multiplier;
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT));
        return String.format("Task duration was %d ms, execution finished at %s", duration, time);
    }
}
