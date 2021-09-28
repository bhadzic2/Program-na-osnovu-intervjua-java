package ba.unsa.etf.rpr;


import java.util.HashMap;
import java.util.Map;

public class Student {
    private final String imeIPrezime;
    private final String indeks;
    private int ciklus;
    private int semestar;
    private Map<Predmet, Integer> ocjene;
    public Student(String imeIPrezime, String indeks, int ciklus, int semestar){
        ocjene=new HashMap<>();
        this.ciklus=ciklus;
        this.semestar=semestar;
        this.indeks=indeks;
        this.imeIPrezime=imeIPrezime;
    }
    public String getIndeks() {
        return indeks;
    }

    public Map<Predmet, Integer> getOcjene() {
        return ocjene;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public int getCiklus() {
        return ciklus;
    }

    public int getSemestar() {
        return semestar;
    }
    public void upisiPredmet(Predmet predmet){
        ocjene.put(predmet, 5);
    }
    public void ocijeniStudenta(Predmet predmet, Integer ocjena){
        for(Map.Entry<Predmet,Integer> entry : ocjene.entrySet()){
            if(predmet.equals(entry.getKey())) entry.setValue(ocjena);
        }
    }
    public String dajPrepisOcjena(){
        StringBuilder s= new StringBuilder();
        for(Map.Entry<Predmet,Integer> entry : ocjene.entrySet()){
            s.append(entry.getKey().toString());
            s.append(": Ocjena ");
            s.append(entry.getValue());
            s.append('\n');
        }
        return s.toString();
    }
}
