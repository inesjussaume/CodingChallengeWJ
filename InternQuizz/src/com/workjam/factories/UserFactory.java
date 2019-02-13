package com.workjam.factories;

import com.workjam.objects.User.Admin;
import com.workjam.objects.User.Employee;
import com.workjam.objects.User.Manager;
import com.workjam.objects.User.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    private static char letter = 'A';

    //TODO Ajouter des paramètres à la signature
    public static User getUser(User.Permission permission) {

        //TODO Implémenter la factory
        User user;

        switch (permission) {
            case EMPLOYEE:
                user = new Employee();
                break;
            case MANAGER:
                user = new Manager();
                break;
            case ADMIN:
                user = new Admin();
                break;
            default:
                return null; //au cas où permission inattendue
        }

        user.setName(getRandomName());
        return user;
    }

    //nouvelle fonction pour créer une liste de users
    public static List<User> getUserList(User.Permission permission, int count){
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < count; i++){
            userList.add(getUser(permission));
        }

        return userList;
    }

    private static String getRandomName() {

        return new StringBuilder().append(nextLetter()).append(nextLetter()).append(nextLetter()).append(nextLetter()).toString();
    }

    private static char nextLetter() {
        if (letter >= 'Z') {
            letter = 'A';
        }
        return letter++;
    }
}
