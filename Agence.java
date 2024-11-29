import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures parking;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.parking = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) {
        parking.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) {
        parking.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) {
        if (!clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.put(cl, new ListVoitures());
        }
        clientVoitureLoue.get(cl).ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) {
        if (clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.get(cl).supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : parking.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        clientVoitureLoue.forEach((client, voitures) -> {
            System.out.println(client);
            voitures.affiche();
        });
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        return new TreeMap<>(clientVoitureLoue);
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        return new TreeMap<>(Comparator.comparing(Client::getNom));
    }
}
