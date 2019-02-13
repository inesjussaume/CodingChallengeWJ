package com.workjam;

import com.workjam.objects.Filter;
import com.workjam.objects.Page;
import com.workjam.objects.User.Employee;
import com.workjam.objects.User.User;
import com.workjam.objects.User.User.Permission;

import com.workjam.factories.UserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static boolean sort = false;
    static Page page = new Page(0, 125);
    static Filter filter = new Filter(null, Permission.EMPLOYEE);

    /**
     * Vous devrez rédiger un programme en 2 étapes:
     * 1. Créer une liste de User en utilisant le patron de conception 'Factory'
     *      La factory devrait pouvoir générer un user de n'importe quel type selon des paramètres que vous définirez.
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

        List<User> userList = new ArrayList<>();

        userList.addAll(UserFactory.getUserList(Permission.EMPLOYEE, 100));
        userList.addAll(UserFactory.getUserList(Permission.MANAGER, 20));
        userList.addAll(UserFactory.getUserList(Permission.ADMIN, 5));

        for (int i = 0; i < userList.size(); i++) { //disons que 1 utilisateur sur 3 est actif
            if (i % 3 == 0){
                userList.get(i).setActive(true);
            }
        }

        //TODO Filtrer la liste

        List<User> filteredList = new ArrayList<>();
        for (User user : userList) {
            if (filter.isActive() != null && user.isActive() != filter.isActive()){
                continue;
            }
            /*
            * les permissions auraient pu être modélisées en classe plutôt qu'en une énum. Ainsi l'héritage aurait
            * simplifié le code.
            * Employee aurait hérité de manager qui aurait hérité de Admin. De là on aurait pu vérifier le type de chaque user
            */

            switch (filter.getPermission()) {

                case EMPLOYEE: //tous les users sont ajoutés
                    break;
                case MANAGER: //les EMPLOYEE sont ignorés
                    if (user.getPermission() == Permission.EMPLOYEE) {
                        continue;
                    }
                    break;
                case ADMIN: //seuls les admins sont ajoutés
                    if (user.getPermission() == Permission.EMPLOYEE || user.getPermission() == Permission.MANAGER){
                        continue;
                    }
                    break;
                default:
                    continue; //permission inconnue
            }
            filteredList.add(user);
        }

        //TODO Ordonner la liste

        if (sort){
            filteredList.sort(Comparator.comparing(User::getName));
        }

        //TODO Paginer la liste

        List<User> listePaginee = new ArrayList<>();
        for (int i = page.getStartPos(); i< page.getSize() || i < filteredList.size(); i++){
            listePaginee.add(filteredList.get(i));
        }

        //TODO Imprimer la liste dans la console

        printUsers(listePaginee);

    }

    private static void printUsers(List<User> users) {
        int userNb = 1;
        for (User user: users) {
            System.out.println(userNb++ + ". " + user);
        }
    }
}
