import java.util.Random;

public class TP3 {

    public TP3() {
        testerEstEnOrdreCroissant();
        testerEstVoyelle();
        testerCompterVoyelles();
        testerTronquer();
        testerCreerTableau2DAleatoire();
    }

    private boolean tousinferieursAuSuivant(int t1[]) {

        for (int i = 0; i < t1.length - 1; i++) {
            if (t1[i] > t1[i+1])
                return false;
        }

        return true;
    }

    private void testerEstEnOrdreCroissant() {
        int tVide[] = {};
        int t1[] = {1};
        int t2[] = {1, 2, 3, 4, 5};
        int t3[] = {1, 2, 3, 5, 4};
        int t4[] = {1, 2};
        int t5[] = {2, 1};
        int t6[] = {1, 2, 3, 4, 5, 6, 7, 9, 8};

        System.out.println("testerEstEnOrdreCroissant()");
        System.out.println(estEnOrdreCroissant(tVide) == true);
        System.out.println(estEnOrdreCroissant(t1) == true);
        System.out.println(estEnOrdreCroissant(t2) == true);
        System.out.println(estEnOrdreCroissant(t3) == false);
        System.out.println(estEnOrdreCroissant(t4) == true);
        System.out.println(estEnOrdreCroissant(t5) == false);
        System.out.println(estEnOrdreCroissant(t6) == false);
    }

    private boolean estEnOrdreCroissant(int t1[]) {
        boolean valRetour;

        if (t1.length == 0 || t1.length == 1 || tousinferieursAuSuivant(t1) == true)
            valRetour = true;
        else
            valRetour = false;

        return valRetour;
    }

    private void testerEstVoyelle() {
        System.out.println("testerEstVoyelle()");
        System.out.println(estVoyelle('a') == true);
        System.out.println(estVoyelle('A') == true);
        System.out.println(estVoyelle('b') == false);
        System.out.println(estVoyelle('B') == false);
        System.out.println(estVoyelle('e') == true);
        System.out.println(estVoyelle('E') == true);
        System.out.println(estVoyelle('m') == false);
        System.out.println(estVoyelle('M') == false);
        System.out.println(estVoyelle('y') == true);
        System.out.println(estVoyelle('Y') == true);
    }

    private boolean estVoyelle(char c) {
        char tVoyelles[] = {'a', 'e', 'i', 'o', 'u', 'y'};

        for (int i = 0; i < tVoyelles.length; i++) {
            if (c == tVoyelles[i] || c == Character.toUpperCase(tVoyelles[i]))
                return true;
        }

        return false;
    }

    private void testerCompterVoyelles() {
        System.out.println("testerCompterVoyelles()");
        System.out.println(compterVoyelles("") == 0);
        System.out.println(compterVoyelles("abcdefghijklmnopqrstuvwxyz 1234567890!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~") == 6);
        System.out.println(compterVoyelles("AEIOUY") == 6);
        System.out.println(compterVoyelles("Bonjour") == 3);
    }

    private int compterVoyelles (String chDeCar) {
        int compteur;

        compteur = 0;

        for (int i = 0; i < chDeCar.length(); i++) {
            if (estVoyelle(chDeCar.charAt(i)) == true)
                compteur++;
        }

        return compteur;
    }

    private boolean sontDesTableauxEgaux(int tE1[], int tE2[]) {

        if (tE1.length == tE2.length) {
            for (int i = 0; i < tE1.length; i++) {
                if (tE1[i] != tE2[i])
                    return false;
            }
        } else
            return false;

        return true;
    }

    private void testerTronquer() {
        int[] tVide = {};
        int[] tab1 = {1, 2, 3, 4, 5};
        int[] tab2 = {1, 2, 3};
        int[] tRep;

        System.out.println("testerTronquer()");
        tRep = tronquerTableau(tVide, 0);
        System.out.println(sontDesTableauxEgaux(tRep, tVide));
        tRep = tronquerTableau(tab1, 5);
        System.out.println(sontDesTableauxEgaux(tRep, tab1));
        tRep = tronquerTableau(tab1, 3);
        System.out.println(sontDesTableauxEgaux(tRep, tab2));
        tRep = tronquerTableau(tab1, 0);
        System.out.println(sontDesTableauxEgaux(tRep, tVide));
    }

    private int[] tronquerTableau(int tE[], int quantite) {
        int tS[];
        tS = new int[quantite];

        for (int i = 0; i < quantite; i++) {
            tS[i] = tE[i];
        }

        return tS;
    }

    //getNombreAleatoireEntreBorne(5, 10) génère un entier aléatoire entre 5 et 10 (inclusivement).
    public int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit être plus grand que min");
        }

        Random r = new Random(); //Instaciation de la classe Random
        return r.nextInt((max - min) + 1) + min;
    }

    private int[][] creerTableau2DAleatoire (int nL, int nC, int min, int max) {
        int tS[][];

        tS = new int [nL][nC];

        for (int x = 0; x < nL; x++) {
            for (int y = 0; y < nC; y++) {
                tS[x][y] = getNombreAleatoireEntreBorne(min, max);
            }
        }

        return tS;
    }

    private void afficherTableau2D(int [][] tx) {
        System.out.print("[ ");

        for (int x = 0; x < tx.length; x++) {
            System.out.print("[");
            for (int y = 0; y < tx[x].length; y++) {
                System.out.print(tx[x][y]);

                if (y < tx[x].length - 1)
                    System.out.print(", ");
            }
            System.out.print("]");

            if (x < tx.length - 1)
                System.out.print(", ");
        }

        System.out.println(" ]");
    }

    private void testerCreerTableau2DAleatoire() {
        System.out.println("testerCreerTableau2DAleatoire()");
        afficherTableau2D(creerTableau2DAleatoire(0, 0, 100, 120));
        afficherTableau2D(creerTableau2DAleatoire(2, 5, 100, 120));
        afficherTableau2D(creerTableau2DAleatoire(4, 7, 100, 120));
    }

    public static void main(String[] args) {
        new TP3();
    }
}
