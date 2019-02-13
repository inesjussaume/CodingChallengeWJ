package com.workjam.objects;

import com.workjam.objects.User.User.Permission;

public class Filter {

    /**
     * L'objet filtre est utilisé pour filtrer des users hors de la liste selon différents paramètres
     * Fields:
     *      active
     *          Null:   Tout les users sont retournés (no filter)
     *          True:   Seulement les users actifs sont retournés
     *          False:  Seulement les users inactifs sont retournés
     *      permission
     *          Employee:   Tous les users sont retournés (D'un point de vue 'Business case', on assume qu'un manager et un admin possède par défaut la permission plus faible)
     *          Manager:    Les admins et managers sont retournés.
     *          Admin:      Les admins sont retournés.
     */

    private final Boolean active;
    private final Permission permission;

    public Filter(Boolean active, Permission permission) {
        this.active = active;
        this.permission = permission;
    }

    public Boolean isActive() {
        return active;
    }

    public Permission getPermission() {
        return permission;
    }
}
