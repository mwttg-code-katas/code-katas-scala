package org.fizz.fuzz.boom;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class JavaFizzFuzzBuzz {
    public static void main(String[] args) {
        final JavaFizzFuzzBuzz app = new JavaFizzFuzzBuzz(100);
        app.run();
    }

    private final Map<Function<Integer, Boolean>, String> divisors;
    private final Integer max;

    JavaFizzFuzzBuzz(Integer max) {
        this.max = max;

        divisors = new LinkedHashMap<>();
        divisors.put(mod3AndMod5(), "boom");
        divisors.put(mod3(), "fizz");
        divisors.put(mod5(), "fuzz");
    }


    private void run() {
        for (int i = 1; i < max; i++) {
            String result = "";
            for (HashMap.Entry<Function<Integer, Boolean>, String> entry : divisors.entrySet()) {
                if (entry.getKey().apply(i)) {
                    result = entry.getValue();
                    break;
                }
            }
            System.out.println(i + "--" + result);
        }
    }

    private Function<Integer, Boolean> mod3() {
        return x -> x % 3 == 0;
    }

    private Function<Integer, Boolean> mod5() {
        return x -> x % 5 == 0;
    }

    private Function<Integer, Boolean> mod3AndMod5() {
        return x -> (x % 3 == 0) && (x % 5 == 0);
    }
}
