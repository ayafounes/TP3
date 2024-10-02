import java.util.Scanner ;
public class MaDate {
    private int jours;
    private int mois;
    private int annee;

    public int getJour() {
        return this.jours;
    }

    public void setJour(int j) {
        this.jours = j;
    }

    public int getMois() {
        return this.mois;
    }

    public void setMois(int m) {
        this.mois = m;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int a) {
        this.annee = a;
    }

    public MaDate(int j, int m, int a) {
        this.jours = j;
        this.mois = m;
        this.annee = a;
    }

    public MaDate(int j) {
        this(j, 12, 2024);
    }

    public void ajouterUnJour(int j) {
        int nb = this.jours + j;
        if (this.mois == 2 && nb > 28) {
            this.mois = 3;
            this.jours = nb - 28;
        } else if ((this.mois == 4 || this.mois == 6 || this.mois == 9 || this.mois == 11) && nb > 30) {
            this.mois += 1;
            this.jours = nb - 30;
        } else if ((this.mois == 1 || this.mois == 3 || this.mois == 5 || this.mois == 7 || this.mois == 8 || this.mois == 10 || this.mois == 12) && nb > 31) {
            if (this.mois == 12) {
                this.mois = 1;
                this.annee += 1;
            } else {
                this.mois += 1;
            }
            this.jours = nb - 31;
        } else {
            this.jours = nb;
        }
    }

    public void ajouterUnMois() {
        if (this.mois == 12) {
            this.mois = 1;
            this.annee += 1;
        } else {
            this.mois += 1;
        }
    }

    public void ajouterAnnee() {
        this.annee += 1;
    }

    public String toString() {
        return this.jours + "/" + this.mois + "/" + this.annee;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le jour de la date : ");
        int jour = scanner.nextInt();
        System.out.println("Saisir le mois de la date : ");
        int mois = scanner.nextInt();
        System.out.println("Saisir l'année de la date : ");
        int annee = scanner.nextInt();

        MaDate date = new MaDate(jour, mois, annee);

        while (true) {
            System.out.println("\nDate actuelle : " + date);
            System.out.println("Choisir une opération à effectuer :");
            System.out.println("1. Ajouter un jour");
            System.out.println("2. Ajouter plusieurs jours");
            System.out.println("3. Ajouter un mois");
            System.out.println("4. Ajouter une année");
            System.out.println("5. Quitter");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    date.ajouterUnJour(1);
                    break;
                case 2:
                    System.out.println("Saisir le nombre de jours à ajouter : ");
                    int nbJours = scanner.nextInt();
                    date.ajouterUnJour(nbJours);
                    break;
                case 3:
                    date.ajouterUnMois();
                    break;
                case 4:
                    date.ajouterAnnee();
                    break;
                case 5:
                    System.out.println("Fin du programme.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
}

      
