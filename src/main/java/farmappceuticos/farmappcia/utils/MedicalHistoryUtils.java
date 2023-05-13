package farmappceuticos.farmappcia.utils;


import farmappceuticos.farmappcia.model.MedicalHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MedicalHistoryUtils {

    private static List<MedicalHistory> medicalHistories = new ArrayList<MedicalHistory>();

    private static final int NUM_MEDICALHISTORY = 30;
    private static final int MIN_MEDICALHISTORY_NUM = 1000;

    public static List<MedicalHistory> buildMedicalHistories() {
        if (medicalHistories.isEmpty()) {
            IntStream.range(0, NUM_MEDICALHISTORY).forEach(n -> {
                medicalHistories.add(new MedicalHistory());
            });

        }
        return medicalHistories;
    }
}
