package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FakultetTest {
    @Test
     void testUpisiStudentaNaFakultet() {
        Fakultet fakultet = new Fakultet();
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Predmet predmet = new Predmet("Predmetic", true, 1, 1, 32, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(predmet);
        try {
            fakultet.dodajPredmet(predmet);
            fakultet.upisiStudentaNaFakultet(student, izborni);
            assertTrue(fakultet.getStudenti().contains(student), "x");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void testNedovoljanBrojEctsException() {
        Fakultet fakultet = new Fakultet();
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 2, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(predmet);
        try {
            fakultet.dodajPredmet(predmet);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        NedovoljanBrojEctsException thrown = assertThrows(
                NedovoljanBrojEctsException.class,
                () -> fakultet.upisiStudentaNaFakultet(student, izborni),
                "Trebao biti bacen izuzetak, a nije"
        );

        assertTrue(thrown.getMessage().contains("Odabran je nedovoljan broj ECTS bodova"),"x");
    }

    @Test
    void testNepostojeciPredmetException() {
        Fakultet fakultet = new Fakultet();
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 256, 79);
        Predmet pogresanPredmet = new Predmet("PredmeticPogresni", false, 1, 1, 92, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(pogresanPredmet);
        try {
            fakultet.dodajPredmet(predmet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        NepostojeciPredmetException thrown = assertThrows(
                NepostojeciPredmetException.class,
                () -> fakultet.upisiStudentaNaFakultet(student, izborni),
                "Trebao biti bacen izuzetak, a nije"
        );
        assertTrue(thrown.getMessage().contains("Odabran je nepostojeci izborni predmet"),"x");
    }

    @Test
    void testStudentVecPostojiException() {
        Fakultet fakultet = new Fakultet();
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 256, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(predmet);
        try {
            fakultet.dodajPredmet(predmet);
            fakultet.upisiStudentaNaFakultet(student, izborni);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        StudentVecPostojiException thrown = assertThrows(
                StudentVecPostojiException.class,
                () -> fakultet.upisiStudentaNaFakultet(student, izborni),
                "Trebao biti bacen izuzetak, a nije"
        );
        assertTrue(thrown.getMessage().contains("Student je vec upisan na fakultet"),"x");
    }
    @Test
    void testPredmetVecPostojiException() {//
        Fakultet fakultet = new Fakultet();
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 256, 79);
        try {
            fakultet.dodajPredmet(predmet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        PredmetVecPostojiException thrown = assertThrows(
                PredmetVecPostojiException.class,
                () -> fakultet.dodajPredmet(predmet),
                "Trebao biti bacen izuzetak, a nije"
        );
        assertTrue(thrown.getMessage().contains("Predmet vec postoji na fakultetu"),"x");
    }
    @Test
    void testProfesorVecPostojiException() {//
        Fakultet fakultet = new Fakultet();
        Profesor profesor = new Profesor("Profesor Profesic");
        try {
            fakultet.dodajProfesora(profesor);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        ProfesorVecPostojiException thrown = assertThrows(
                ProfesorVecPostojiException.class,
                () -> fakultet.dodajProfesora(profesor),
                "Trebao biti bacen izuzetak, a nije"
        );
        assertTrue(thrown.getMessage().contains("Profesor vec postoji na fakultetu"),"x");
    }

    @Test
    void testDodajPredmet() {
        Predmet predmet1 = new Predmet("Predmetic", true, 1, 1, 2, 79);
        Predmet predmet2 = new Predmet("PredmeticLijepi", true, 1, 5, 45, 9);
        Fakultet fakultet = new Fakultet();
        try {
            fakultet.dodajPredmet(predmet1);
            fakultet.dodajPredmet(predmet2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertAll(
                () -> assertTrue(fakultet.getPredmeti().contains(predmet1), "x"),
                () -> assertTrue(fakultet.getPredmeti().contains(predmet2),"x")
        );
    }

    @Test
    void testDodajProfesora() {
        Fakultet fakultet = new Fakultet();
        Profesor profesor1 = new Profesor("Profesor Profesic");
        Profesor profesor2 = new Profesor("Profesorica Profesoricic");
        try {


            fakultet.dodajProfesora(profesor1);
            fakultet.dodajProfesora(profesor2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertAll(
                () -> assertTrue(fakultet.getProfesori().contains(profesor1),"x"),
                () -> assertTrue(fakultet.getProfesori().contains(profesor2),"x")
        );
    }

    @Test
    void testDajStudentaPoIndeksu() {
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Fakultet fakultet = new Fakultet();
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 256, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(predmet);
        try {
            fakultet.dodajPredmet(predmet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            fakultet.upisiStudentaNaFakultet(student, izborni);
            assertEquals(student, fakultet.dajStudentaPoIndeksu("17653"),"x");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Test
    void testPogresanIndeksException() {
        Fakultet fakultet = new Fakultet();
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Predmet predmet = new Predmet("Predmetic", false, 1, 1, 256, 79);
        Predmet predmet2 = new Predmet("Predmetic2", true, 1, 1, 256, 79);
        ArrayList<Predmet> izborni = new ArrayList<>();
        izborni.add(predmet);
        try {

            fakultet.dodajPredmet(predmet);
            fakultet.dodajPredmet(predmet2);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        PogresanIndeksException thrown = assertThrows(
                PogresanIndeksException.class,
                () -> {
                    fakultet.upisiStudentaNaFakultet(student, izborni);
                    fakultet.dajStudentaPoIndeksu("111");
                },
                "Trebao biti bacen izuzetak, a nije"
        );
        assertTrue(thrown.getMessage().contains("Nema studenta sa tim indeksom"),"x");
    }
    @Test
    void testGetStudenti(){
        Fakultet fakultet=new Fakultet();
        List<Student> st=new ArrayList<>();
        assertEquals(st,fakultet.getStudenti(),"x");
    }
    @Test
    void testDajProfesoraBezIliPrekoNorme() {
        Fakultet fakultet = new Fakultet();
        Profesor profesor1 = new Profesor("Profa BezNorme");
        Profesor profesor2 = new Profesor("Profa PunoNorme");
        Profesor profesor3 = new Profesor("Profa Normalni");
        Predmet predmet1 = new Predmet("Predmetic", true, 1, 1, 256, 700);
        Predmet predmet2 = new Predmet("Predmetic", true, 1, 1, 256, 130);
        try {
            fakultet.dodajProfesora(profesor1);
            fakultet.dodajProfesora(profesor2);
            fakultet.dodajProfesora(profesor3);
            fakultet.dodajPredmet(predmet1);
            fakultet.dodajPredmet(predmet2);
            profesor2.zaposliProfesoraNaPredmetu(predmet1);
            profesor3.zaposliProfesoraNaPredmetu(predmet2);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        assertEquals("Profa BezNorme\nProfa PunoNorme\nProfa Normalni\n", fakultet.dajProfesoreBezIliPrekoNorme(),"x"); //jer nema studenata iako postoje predmeti
        Student student = new Student("Neko Neki", "17653", 1, 1);
        predmet2.upisiStudentaNaPredmet(student);
        predmet1.upisiStudentaNaPredmet(student);
        assertEquals("Profa BezNorme\nProfa PunoNorme\n", fakultet.dajProfesoreBezIliPrekoNorme(),"x");

    }

    @Test
    void testDajProfesoreSortiranePoNormi() {
        Fakultet fakultet = new Fakultet();
        Profesor profesor1 = new Profesor("Profa BezNorme");
        Profesor profesor2 = new Profesor("Profa PunoNorme");
        Profesor profesor3 = new Profesor("Profa Normalni");
        Predmet predmet1 = new Predmet("Predmetic", true, 1, 1, 256, 700);
        Predmet predmet2 = new Predmet("Predmetic", true, 1, 1, 256, 130);
        try {
            fakultet.dodajProfesora(profesor1);
            fakultet.dodajProfesora(profesor2);
            fakultet.dodajProfesora(profesor3);
            fakultet.dodajPredmet(predmet1);
            fakultet.dodajPredmet(predmet2);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        profesor2.zaposliProfesoraNaPredmetu(predmet1);
        profesor3.zaposliProfesoraNaPredmetu(predmet2);
        Student student = new Student("Neko Neki", "17653", 1, 1);
        predmet2.upisiStudentaNaPredmet(student);
        predmet1.upisiStudentaNaPredmet(student);
        assertEquals("Profa BezNorme\nProfa Normalni\nProfa PunoNorme\n", fakultet.dajProfesoreSortiranePoNormi(),"x");
    }

    @Test
    void testDajProfesoreSortiranePoBrojuStudenata() {
        Fakultet fakultet = new Fakultet();
        Profesor profesor1 = new Profesor("Profa BezNorme");
        Profesor profesor2 = new Profesor("Profa PunoNorme");
        Profesor profesor3 = new Profesor("Profa Normalni");
        Predmet predmet1 = new Predmet("Predmetic", true, 1, 1, 256, 700);
        Predmet predmet2 = new Predmet("Predmetic", true, 1, 1, 256, 130);
        try {

            fakultet.dodajProfesora(profesor1);
            fakultet.dodajProfesora(profesor2);
            fakultet.dodajProfesora(profesor3);
            fakultet.dodajPredmet(predmet1);
            fakultet.dodajPredmet(predmet2);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        profesor2.zaposliProfesoraNaPredmetu(predmet1);
        profesor3.zaposliProfesoraNaPredmetu(predmet2);
        Student student = new Student("Neko Neki", "17653", 1, 1);
        Student student2 = new Student("Neko Neki2", "176535", 1, 1);
        predmet2.upisiStudentaNaPredmet(student);
        predmet1.upisiStudentaNaPredmet(student2);
        predmet1.upisiStudentaNaPredmet(student);
        assertEquals("Profa BezNorme\nProfa Normalni\nProfa PunoNorme\n", fakultet.dajProfesoreSortiranePoBrojuStudenata(),"x");
    }
}