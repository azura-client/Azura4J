import best.azura.azura4j.Azura;
import best.azura.azura4j.entities.AzuraApplicationStats;

public class Main {

    public static void main(String[] args) throws Exception {
        Azura azura = new Azura("fdbd22cb-66fd-4b9b-bbe4-e677f724c57d");
        AzuraApplicationStats azuraApplicationStats = azura.fetchApplicationStats();
    }

}
