package farmappceuticos.farmappcia.utils;

import farmappceuticos.farmappcia.model.Illness;
import farmappceuticos.farmappcia.model.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class QuestionsUtils {
    private static List<Questions> questions = new ArrayList<Questions>();

    private static final int NUM_QUESTIONS = 30;
    private static final int MIN_QUESTIONS_NUM = 1000;

    public static List<Questions> buildQuestions() {
        if (questions.isEmpty()) {
            IntStream.range(0, NUM_QUESTIONS).forEach(n -> {
                questions.add(new Questions());
            });

        }
        return questions;
    }

}
