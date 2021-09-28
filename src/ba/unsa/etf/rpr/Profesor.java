package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private final String imeIPrezime;
    private List<Predmet> predmetiKojeDrzi;
    private int norma;
    public Profesor(String imeIPrezime){
        norma=0;
        this.imeIPrezime=imeIPrezime;
        predmetiKojeDrzi=new ArrayList<>();
    }
    public void zaposliProfesoraNaPredmetu(Predmet predmet){
        predmet.setProfesor(this);
        predmetiKojeDrzi.add(predmet);
        if(!predmet.getStudentiNaPredmetu().isEmpty()) norma+=predmet.getBrojEcts();
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public List<Predmet> getPredmetiKojeDrzi() {
        return predmetiKojeDrzi;
    }

    public int getNorma() {
        return norma;
    }
    public int dajBrojStudenataProfesora(){
        int n=0;
        for(Predmet predmet:predmetiKojeDrzi){
            n+=predmet.getStudentiNaPredmetu().size();
        }
        return n;
    }
    public void podesiNormu(Predmet predmet) {
        if(predmet.getStudentiNaPredmetu().size()==1) norma=norma+predmet.getBrojCasova();
    }

    @Override
    public String toString() {
        return imeIPrezime;
    }
}
