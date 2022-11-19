package controller;

import model.BlType;
import model.Gender;
import model.Role;
import model.User;

public class UserController {
    public boolean login(String userName, String password) {
        var user = Data.users.stream()
                .filter(u -> u.getUserName() == userName)
                .findAny();
        if (user.isEmpty()) {
            System.out.println("username is not exist");
            return false;
        }
        if (!user.get().getPassword().equals(password)) {
            System.out.println("Your password is wrong");
            return false;
        }
        return true;
    }

    public boolean signUp(String firstName, String lastName, String userName, String password, String dob,
            Gender gender, Role role, BlType bloodType) {
        var isExist = Data.users.stream().filter(user -> user.getUserName().equals(userName)).findAny();
        if (isExist.isEmpty()) {
            System.out.println("The username exist");
            return false;
        }

        var user = new User(firstName, lastName, userName, password, dob, gender, role, bloodType);
        Data.users.add(user);
        return Data.saveUser();
    }
}