package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fakultet {
    private List<Predmet> predmeti = new ArrayList<>();
    private List<Student> studenti = new ArrayList<>();
    private List<Profesor> profesori = new ArrayList<>();
    public void upisiStudentaNaFakultet(Student student, List<Predmet> izborni) throws StudentVecPostojiException,NedovoljanBrojEctsException,NepostojeciPredmetException {
        int s = 0;
        if(studenti.contains(student)) throw new StudentVecPostojiException("Student je vec upisan na fakultet");
        for(Predmet izbor:izborni) if(!predmeti.contains(izbor) || izbor.isObavezan()) throw new NepostojeciPredmetException("Odabran je nepostojeci izborni predmet");
        for (Predmet predmet : predmeti) {
            if (predmet.isObavezan() && predmet.getSemestar() == student.getSemestar() && predmet.getCiklus() == student.getCiklus())
                s += predmet.getBrojEcts();
            if (izborni.contains(predmet)) s += predmet.getBrojEcts();
        }
        if (s < 30) throw new NedovoljanBrojEctsException("Odabran je nedovoljan broj ECTS bodova");
        upisiJerJeZadovoljioUslove(student,izborni);
    }
    private void upisiJerJeZadovoljioUslove(Student student, List<Predmet> izborni){
        studenti.add(student);
        for (Predmet predmet : predmeti) {
            if (predmet.isObavezan() && predmet.getSemestar() == student.getSemestar() && predmet.getCiklus() == student.getCiklus())
                predmet.upisiStudentaNaPredmet(student);
            if (izborni.contains(predmet)) predmet.upisiStudentaNaPredmet(student);
        }

    }
    public void dodajPredmet(Predmet predmet)throws PredmetVecPostojiException {
        if(predmeti.contains(predmet)) throw new PredmetVecPostojiException("Predmet vec postoji na fakultetu");
        predmeti.add(predmet);
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void dodajProfesora(Profesor profesor) throws ProfesorVecPostojiException {
        if(profesori.contains(profesor)) throw new ProfesorVecPostojiException("Profesor vec postoji na fakultetu");
        profesori.add(profesor);
    }
    public Student dajStudentaPoIndeksu(String indeks) throws PogresanIndeksException{//promijeniti exc
        for (Student student : studenti) {
            if (indeks.equals(student.getIndeks())) return student;
        }
        throw new PogresanIndeksException("Nema studenta sa tim indeksom");
    }
    public String dajProfesoreBezIliPrekoNorme() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().filter(profesor -> profesor.getNorma() < 120 || profesor.getNorma() > 150).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
    public String dajProfesoreSortiranePoNormi() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().sorted(Comparator.comparing(Profesor::getNorma)).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
    public String dajProfesoreSortiranePoBrojuStudenata() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().sorted(Comparator.comparing(Profesor::dajBrojStudenataProfesora)).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
}
