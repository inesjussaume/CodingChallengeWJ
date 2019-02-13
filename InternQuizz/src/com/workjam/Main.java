package com.workjam;

import com.workjam.objects.Filter;
import com.workjam.objects.Page;
import com.workjam.objects.User.Employee;
import com.workjam.objects.User.User;
import com.workjam.objects.User.User.Permission;

import com.workjam.factories.UserFactory;

import java.util.Arrays;
import java.util.List;

public class Main {

    static boolean sort = false;
    static Page page = new Page(0, 125);
    static Filter filter = new Filter(null, Permission.EMPLOYEE);

    /**
     * Vous devrez rédiger un programme en 2 étapes:
     * 1. Créer une liste de User en utilisant le patron de conception 'Factory'
     *      La factory devrait pouvoir générer un user de n'importe quel type selon des paramètres que vous définirez.
     *      //todo générer avec user.permission, va créer un user du type choisi
     *
     *      Vous utiliserez cette factory afin de générer une liste de Users d'au moins 100 employees, 20 managers et 5 admins.
     *      Vous devez générer un nom aléatoire pour chaque User.
     *      Il est important d'avoir des Users actifs/inactifs pour chaque type.
     *
     * 2. Traiter la liste à l'aide d'un filtre, d'un ordonnencement et d'une pagination
     *      Filtrer -> Filter.java
     *      Ordonner -> Ordonner les utilisateurs par ordre alphabétique de leur nom selon la valeur du champ 'sort'
     *      Paginer -> Page.java
     *
     *  Vous pouvez ajouter autant de fonctions/fichiers que vous voulez.
     *  Vous serez évalués sur la qualité/clarté de votre code ainsi que sur le bon fonctionnement de celui-ci.
     *  Les commentaires sont non-nécéssaires.
     *  Vous ne devriez pas avoir besoin de modifier les classes dans le package com.workjam.objects.
     *
     *  N'hésitez pas à me contacter en cas de doute.
     */
    public static void main(String[] args) {
        //TODO Générer la liste de users en utilisant la factory
        //List<User> userList = new List<User>();
        UserFactory userFactory = new UserFactory();
        User user = null;
        user = userFactory.getUser(Permission.EMPLOYEE);



        //TODO Filtrer la liste

        //TODO Ordonner la liste

        //TODO Paginer la liste

        //TODO Imprimer la liste dans la console

        printUsers();
    }

    private static void printUsers(List<User> users) {
        int userNb = 1;
        for (User user: users) {
            System.out.println(userNb++ + ". " + user);
        }
    }
}
