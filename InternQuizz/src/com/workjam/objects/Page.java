package com.workjam.objects;

public class Page {

    /**
     * L'object page est utilisé pour limiter le nombre de users retournés dans la liste.
     * Fields:
     *      startPos
     *          La position à partir de laquelle on retourne les users
     *      size
     *          Le nombre de users à retourner
     *
     *  Ex: Si on avait une liste de 20 users, on passe startPos=10 et size=5, on retournerait les users 10-11-12-13-14
     */

    private final int startPos;
    private final int size;

    public Page(int startPos, int size) {
        if (startPos < 0 || size < 0) {
            throw new IllegalStateException("Position ou taille négative invalide pour la pagination.");
        }
        this.startPos = startPos;
        this.size = size;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getSize() {
        return size;
    }

}
