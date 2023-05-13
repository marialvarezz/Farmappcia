package farmappceuticos.farmappcia.utils;

import farmappceuticos.farmappcia.model.Medicine;
import jakarta.validation.constraints.PositiveOrZero;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MedicineUtils {

    private static List<Medicine> medicines = new ArrayList<Medicine>();

    private static final int NUM_MEDICINES = 30;
    private static final int MIN_MEDICINE_NUM = 1000;

    public static List<Medicine> buildMedicines() {
        if (medicines.isEmpty()) {
            IntStream.range(0, NUM_MEDICINES).forEach(n -> {
                medicines.add(new Medicine());
            });

        }
        return medicines;
    }
}
