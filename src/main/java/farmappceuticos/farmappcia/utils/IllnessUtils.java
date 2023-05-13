package farmappceuticos.farmappcia.utils;

import farmappceuticos.farmappcia.model.Illness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class IllnessUtils {

    private static List<Illness> illnesses = new ArrayList<Illness>();

    private static final int NUM_ILLNESS = 30;
    private static final int MIN_ILLNESS_NUM = 1000;

    public static List<Illness> buildIllnesses() {
        if (illnesses.isEmpty()) {
            IntStream.range(0, NUM_ILLNESS).forEach(n -> {
                illnesses.add(new Illness());
            });

        }
        return illnesses;
    }
}
