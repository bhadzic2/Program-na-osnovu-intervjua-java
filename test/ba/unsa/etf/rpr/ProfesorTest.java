package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {
    @Test
    void testKonstruktor(){
        Profesor profesor = new Profesor("Profa Profic");
        assertAll(
                () -> assertEquals("Profa Profic",profesor.getImeIPrezime(),"x"),
                () -> assertEquals(0,profesor.getNorma(),"x"),
                () -> assertTrue(profesor.getPredmetiKojeDrzi().isEmpty(),"x")
        );
    }
    @Test
    void testZaposliProfesoraNaPredmetu(){
        Profesor profesor = new Profesor("Profa Profic");
        Predmet predmet = new Predmet("Predmetic", true,1,2,10,79);
        profesor.zaposliProfesoraNaPredmetu(predmet);
        assertAll(
                () -> assertTrue(profesor.getPredmetiKojeDrzi().contains(predmet),"x"),
                () -> assertEquals(profesor,predmet.getProfesor(),"x")
        );
    }
    @Test
    void testDajBrojStudenataProfesora(){
        Profesor profesor1 = new Profesor("Profa Profic");
        Profesor profesor2 = new Profesor("Profa NePredajeNikome");
        Predmet predmet = new Predmet("Predmetic", true,1,2,10,79);
        Student student1 = new Student("Neko Neki", "17653",1,1);
        Student student2 = new Student("Svako Svaki", "17654",1,1);
        Student student3 = new Student("Niko Nikic", "17654",1,1);
        profesor1.zaposliProfesoraNaPredmetu(predmet);
        predmet.upisiStudentaNaPredmet(student1);
        predmet.upisiStudentaNaPredmet(student2);
        predmet.upisiStudentaNaPredmet(student3);

        assertAll(
                () -> assertEquals(3,profesor1.dajBrojStudenataProfesora(),"x"),
                () -> assertEquals(0,profesor2.dajBrojStudenataProfesora(),"x")
        );
    }
    @Test
    void testPodesiNormu(){
        Profesor profesor = new Profesor("Profa Profic");
        Predmet predmet = new Predmet("Predmetic", true,1,2,10,79);
        Student student = new Student("Niko Nikic", "17654",1,1);
        predmet.upisiStudentaNaPredmet(student); //prvo studenta, pa proesora da se u upisu studenta ne bi odmah postavilo
        predmet.setProfesor(profesor); //nisam preko zaposli profesora da ne bi automatski normu sabralo
        profesor.podesiNormu(predmet);
        assertEquals(79,profesor.getNorma(),"x");
    }
    @Test
    void testToString(){
        Profesor profesor1 = new Profesor("Profa Profic");
        Profesor profesor2 = new Profesor("Dobar Profa");
        Profesor profesor3 = new Profesor("Los Profa");
        assertAll(
                () -> assertEquals("Profa Profic", profesor1.toString(),"x"),
                () -> assertEquals("Dobar Profa", profesor2.toString(),"x"),
                () -> assertEquals("Los Profa", profesor3.toString(),"x")
        );
    }

}