import java.util.*;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) {
        if (!voitures.contains(v)) {
            voitures.add(v);
        }
    }

    public void supprimeVoiture(Voiture v) {
        voitures.remove(v);
    }

    public Iterator<Voiture> iterateur() {
        return voitures.iterator();
    }

    public int size() {
        return voitures.size();
    }

    public void affiche() {
        voitures.forEach(System.out::println);
    }
}
