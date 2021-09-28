package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {
    @Test
    void testKonstruktor(){
        Predmet predmet = new Predmet("Predmetic", true,1,2,10,79);
        assertAll(
                () -> assertEquals("Predmetic", predmet.getImePredmeta(),"x"),
                () -> assertTrue(predmet.isObavezan(),"x"),
                () -> assertEquals(1, predmet.getCiklus(),"x"),
                () -> assertEquals(2, predmet.getSemestar(),"x"),
                () -> assertEquals(10, predmet.getBrojEcts(),"x"),
                () -> assertEquals(79, predmet.getBrojCasova(),"x"),
                () -> assertTrue(predmet.getStudentiNaPredmetu().isEmpty(),"x"),
                () -> assertEquals(null, predmet.getProfesor(),"x")
        );
    }

    @Test
    void testUpisiStudentaNaPredmet(){
        Predmet predmet = new Predmet("Neki predmet", true, 1, 1, 10, 56);
        Student student = new Student("Neko Neki", "17653",1,1);
        Profesor profesor=new Profesor("Profesor Profesic");
        predmet.setProfesor(profesor);
        predmet.upisiStudentaNaPredmet(student);
        assertAll(
                () -> assertTrue(predmet.getStudentiNaPredmetu().contains(student),"x")
        );
    }

    @Test
    void testEquals(){
        Predmet predmet1 = new Predmet("Predmet 1", true, 1, 1, 10, 56);
        Predmet predmet2 = new Predmet("Predmet 1", true, 1, 1, 10, 56);
        Predmet predmet3 = new Predmet("Predmet 1", false, 1, 1, 10, 56);
        Predmet predmet4 = new Predmet("Predmet 1", true, 1, 1, 10, 56);
        Profesor profesor=new Profesor("Profesor Profesic");
        predmet4.setProfesor(profesor);
        assertAll(
                () -> assertEquals(predmet2, predmet1,"x"),
                () -> assertNotEquals(predmet3, predmet1,"x"),
                () -> assertNotEquals(predmet4, predmet1,"x")
        );
    }

    @Test
    void testToString(){
        Predmet predmet1 = new Predmet("Predmet 1", true, 1, 1, 10, 56);
        Predmet predmet2 = new Predmet("Predmet 2", true, 1, 1, 10, 56);
        assertAll(
                () -> assertEquals("Predmet 1", predmet1.toString(),"x"),
                () -> assertEquals("Predmet 2", predmet2.toString(),"x")
        );
    }
}