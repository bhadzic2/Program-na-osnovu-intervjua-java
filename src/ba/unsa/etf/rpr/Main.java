package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
        try{
        //unos sistema
        Fakultet fakultetIzgubljenihGodina = unesiSistem();
        //dijalog
        Scanner ulaz1 = new Scanner(System.in);
        label:
        for (; ; ) {
            System.out.println("""
                    Koji spisak želite?
                    Unesite 1 za spisak profesora koji nemaju normu ili rade preko norme
                    Unesite 2 za spisak profesora po normi
                    Unesite 3 za spisak profesora po ukupnom broju studenata
                    Unesite 4 za prepis ocjena studenta
                    Unesite x za izlaz
                    """);
            String odabir = ulaz1.nextLine();
            switch (odabir) {
                case "x":
                    break label;
                case "1":
                    assert fakultetIzgubljenihGodina != null;
                    System.out.println(fakultetIzgubljenihGodina.dajProfesoreBezIliPrekoNorme());
                    break;
                case "2":
                    assert fakultetIzgubljenihGodina != null;
                    System.out.println(fakultetIzgubljenihGodina.dajProfesoreSortiranePoNormi());
                    break;
                case "3":
                    assert fakultetIzgubljenihGodina != null;
                    System.out.println(fakultetIzgubljenihGodina.dajProfesoreSortiranePoBrojuStudenata());
                    break;
                case "4":
                    System.out.println("Unesite indeks studenta ciji prepis ocjena zelite\n");
                    String indeks = ulaz1.nextLine();
                    assert fakultetIzgubljenihGodina != null;
                    System.out.println(fakultetIzgubljenihGodina.dajStudentaPoIndeksu(indeks).dajPrepisOcjena());
                    break;
                default:
                    System.out.println("Unijeli ste pogresan odabir\n");
                    break;
            }
        }}catch (Exception ex){
          System.out.println(ex.getMessage());
      }
    }

    private static Fakultet unesiSistem() {
        try {
            Fakultet fakultetIzgubljenihGodina = new Fakultet();
            Student s1 = new Student("Tuzni Tuzic", "17653", 1, 1);
            Student s2 = new Student("Streber Zesci", "617-Ab", 1, 1);
            Student s3 = new Student("Sveznalica Sveznalic", "57298", 1, 1);
            Student s4 = new Student("Student Studentic", "19999", 1, 1);
            Student s5 = new Student("Prodana Dusa", "12399", 1, 2);
            Student s6 = new Student("Tuzni Tuzic", "618-Ac", 1, 2);
            Student s7 = new Student("Sebicnjak Sebicni", "19913", 1, 2);
            Student s8 = new Student("Smjesko Smjesic", "12299", 1, 2);
            Profesor p1 = new Profesor("Gospodin Strogi");
            Profesor p2 = new Profesor("Gospodin Fini");
            Profesor p3 = new Profesor("Gospodin Onako");
            Predmet pr1 = new Predmet("Lagani", true, 1, 1, 10, 36);
            Predmet pr2 = new Predmet("Teski", true, 1, 1, 14, 70);
            Predmet pr3 = new Predmet("Zanimljivi", true, 1, 1, 10, 23);
            Predmet pr4 = new Predmet("Uzasni", false, 1, 1, 7, 100);
            Predmet pr5 = new Predmet("Osrednji", false, 1, 1, 19, 36);
            Predmet pr6 = new Predmet("Dosadni", false, 1, 1, 17, 20);
            Predmet pr7 = new Predmet("Najbolji", true, 1, 2, 15, 60);
            Predmet pr8 = new Predmet("Onako", false, 1, 2, 28, 43);
            Predmet pr9 = new Predmet("Naucni", false, 1, 2, 5, 67);
            Predmet pr10 = new Predmet("OvajNeceNikoUpisati", false, 1, 2, 28, 67);
            p1.zaposliProfesoraNaPredmetu(pr1);
            p1.zaposliProfesoraNaPredmetu(pr2);
            p1.zaposliProfesoraNaPredmetu(pr3);
            p1.zaposliProfesoraNaPredmetu(pr4);
            p1.zaposliProfesoraNaPredmetu(pr6);
            p2.zaposliProfesoraNaPredmetu(pr5);
            p2.zaposliProfesoraNaPredmetu(pr7);
            p3.zaposliProfesoraNaPredmetu(pr8);
            p3.zaposliProfesoraNaPredmetu(pr9);
            p3.zaposliProfesoraNaPredmetu(pr10);
            fakultetIzgubljenihGodina.dodajProfesora(p1);
            fakultetIzgubljenihGodina.dodajProfesora(p2);
            fakultetIzgubljenihGodina.dodajProfesora(p3);
            fakultetIzgubljenihGodina.dodajPredmet(pr1);
            fakultetIzgubljenihGodina.dodajPredmet(pr2);
            fakultetIzgubljenihGodina.dodajPredmet(pr3);
            fakultetIzgubljenihGodina.dodajPredmet(pr4);
            fakultetIzgubljenihGodina.dodajPredmet(pr5);
            fakultetIzgubljenihGodina.dodajPredmet(pr6);
            fakultetIzgubljenihGodina.dodajPredmet(pr7);
            fakultetIzgubljenihGodina.dodajPredmet(pr8);
            fakultetIzgubljenihGodina.dodajPredmet(pr9);
            fakultetIzgubljenihGodina.dodajPredmet(pr10);
            ArrayList<Predmet> izborni1 = new ArrayList<>();
            izborni1.add(pr4);
            izborni1.add(pr6);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s1, izborni1);
            izborni1.add(pr5);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s2, izborni1);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s3, izborni1);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s4, izborni1);
            ArrayList<Predmet> izborni2 = new ArrayList<>();
            izborni2.add(pr8);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s5, izborni2);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s6, izborni2);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s7, izborni2);
            izborni2.add(pr9);
            fakultetIzgubljenihGodina.upisiStudentaNaFakultet(s8, izborni2);
            s1.ocijeniStudenta(pr1, 9);
            s1.ocijeniStudenta(pr3, 7);
            s1.ocijeniStudenta(pr6, 6);
            return fakultetIzgubljenihGodina;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        return null;
    }
}
