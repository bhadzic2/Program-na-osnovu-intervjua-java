package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testKonstruktor(){
        Student student = new Student("Neko Neki", "17653",1,1);
        assertAll(
                () -> assertEquals(1,student.getCiklus(),"x"),
                () -> assertEquals(1,student.getSemestar(),"x"),
                () -> assertEquals("Neko Neki", student.getImeIPrezime(),"x"),
                () -> assertEquals("17653", student.getIndeks(),"x"),
                () -> assertTrue(student.getOcjene().isEmpty(),"x")
        );
    }

    @Test
    void testUpisiPredmet(){
        Predmet predmet = new Predmet("Neki predmet", true, 1, 1, 10, 56);
        Student student = new Student("Neko Neki", "17653",1,1);
        student.upisiPredmet(predmet);
        HashMap<Predmet, Integer> rezultat=new HashMap<>();
        rezultat.put(predmet,5);
        assertAll(
                () -> assertFalse(student.getOcjene().isEmpty(),"x"),
                () -> assertEquals(rezultat, student.getOcjene(),"x")

        );
    }
    @Test
    void testOcijeniStudenta(){
        Predmet predmet = new Predmet("Neki predmet", true, 1, 1, 10, 56);
        Student student = new Student("Neko Neki", "17653",1,1);
        student.upisiPredmet(predmet);
        student.ocijeniStudenta(predmet,9);
        HashMap<Predmet, Integer> rezultat=new HashMap<>();
        rezultat.put(predmet,9);
        assertAll(
                () -> assertFalse(student.getOcjene().isEmpty(),"x"),
                () -> assertEquals(rezultat, student.getOcjene(),"x")

        );
    }

    @Test
    void dajPrepisOcjena(){
        Predmet predmet1 = new Predmet("Predmet 1", true, 1, 1, 10, 56);
        Predmet predmet2 = new Predmet("Predmet 2", true, 1, 1, 11, 78);
        Student student = new Student("Neko Neki", "17653",1,1);
        student.upisiPredmet(predmet1);
        student.upisiPredmet(predmet2);
        student.ocijeniStudenta(predmet2,9);

        String rezultat1 = "Predmet 1: Ocjena 5\nPredmet 2: Ocjena 9\n";
        String rezultat2 = "Predmet 2: Ocjena 9\nPredmet 1: Ocjena 5\n";
        List<String> moguciTacni = new ArrayList<>(List.of(rezultat1, rezultat2));

        assertTrue(moguciTacni.contains(student.dajPrepisOcjena()),"x");

    }



}