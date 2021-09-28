package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Predmet {
    private String imePredmeta;
    private boolean obavezan;
    private int ciklus;
    private int semestar;
    private int brojEcts;
    private Profesor profesor;
    private List<Student> studentiNaPredmetu;
    private int brojCasova;

    public Predmet(String imePredmeta, boolean obavezan, int ciklus, int semestar, int brojEcts, int brojCasova){
        this.imePredmeta=imePredmeta;
        this.obavezan=obavezan;
        this.ciklus=ciklus;
        this.semestar=semestar;
        this.brojEcts=brojEcts;
        this.brojCasova=brojCasova;
        studentiNaPredmetu=new ArrayList<>();
    }
    public void upisiStudentaNaPredmet(Student student){
        studentiNaPredmetu.add(student);
        student.upisiPredmet(this);
        if(profesor!=null) profesor.podesiNormu(this);
    }
    public boolean isObavezan() {
        return obavezan;
    }

    public int getCiklus() {
        return ciklus;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public String getImePredmeta() {
        return imePredmeta;
    }

    public Profesor getProfesor() {
        return profesor;
    }
    public int getSemestar() {
        return semestar;
    }

    public int getBrojEcts() {
        return brojEcts;
    }

    public List<Student> getStudentiNaPredmetu() {
        return studentiNaPredmetu;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return obavezan == predmet.obavezan &&
                ciklus == predmet.ciklus &&
                semestar == predmet.semestar &&
                brojEcts == predmet.brojEcts &&
                brojCasova == predmet.brojCasova &&
                Objects.equals(imePredmeta, predmet.imePredmeta) &&
                Objects.equals(profesor, predmet.profesor) &&
                Objects.equals(studentiNaPredmetu, predmet.studentiNaPredmetu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imePredmeta, obavezan, ciklus, semestar, brojEcts, profesor, studentiNaPredmetu, brojCasova);
    }

    @Override
    public String toString() {
        return imePredmeta;
    }
}
