package com.workjam.factories;

import com.workjam.objects.User.Admin;
import com.workjam.objects.User.Employee;
import com.workjam.objects.User.Manager;
import com.workjam.objects.User.User;

public class UserFactory {

    private static char letter = 'A';

    //TODO Ajouter des paramètres à la signature
    public static User getUser(User.Permission permission) {

        //TODO Implémenter la factory
        if (permission.equals(User.Permission.EMPLOYEE)){
            return new Employee();

        }else if (permission.equals(User.Permission.MANAGER)){
            return new Manager();

        }else if (permission.equals(User.Permission.ADMIN)){
            return new Admin();

        } else{
            return null;
        }

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
