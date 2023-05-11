package farmappceuticos.farmappcia.utils;

import farmappceuticos.farmappcia.model.Medicine;
import farmappceuticos.farmappcia.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserUtils {

    private static List<User> userList = new ArrayList<User>();

    private static final int NUM_USERS = 30;
    private static final int MIN_USER_NUM = 1000;

    public static List<User> buildUsers() {
        if (userList.isEmpty()) {
            IntStream.range(0, NUM_USERS).forEach(n -> {
                userList.add(new User());
            });

        }
        return userList;
    }
}
