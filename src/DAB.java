import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chawki on 07/10/16.
 */

public class DAB {

    private List<Client> clients = new ArrayList<>();
    private int nbClients = 0;
    private Scanner clavier;

    public void menuDAB() {
        boolean fin = false;
        while (!fin) {
            System.out.println("\nBienvenu au DAB de chawki ");
            System.out.println("Que voulez vous faire ?\n");
            System.out.println("1) afficher le bilant de la banque  ");
            System.out.println("2) creer un nouveau client ");
            System.out.println("3) faire des operation sur un client");
            System.out.println("4) quitter la banque ");

            System.out.print("\nvotre choix : ");
            clavier = new Scanner(System.in);
            int choix = clavier.nextInt();


            switch (choix) {
                case 1:
                    if (nbClients == 0) {
                        System.out.println("aucun client dans la banque");
                    } else {
                        for (int i = 0; i < clients.size(); i++) {
                            System.out.println("\nLe client " + clients.get(i).getNom() + " possede : " + clients.get(i).getNombreCompte() + " compte(s)");
                            clients.get(i).infoCompte();

                        }
                    }

                    break;
                case 2:
                    System.out.print("\nDonner le nom du client : ");
                    clavier = new Scanner(System.in);
                    String nom = clavier.nextLine();
                    clients.add(new Client(nom));
                    nbClients += 1;
                    System.out.println("le clien " + nom + " est creer\n");
                    break;

                case 3:
                    afficherNomClient();
                    System.out.println("sur quelle  client ?");
                    clavier = new Scanner(System.in);
                    choix = clavier.nextInt();
                    clients.get(choix-1).menuClient();

                    break;

                case 4:
                    System.out.println("by by a la prochaine ! ");
                    fin = true;
                    break;


            }

        }
    }

    private void afficherNomClient() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + "- " + clients.get(i).getNom());
        }
    }
}
