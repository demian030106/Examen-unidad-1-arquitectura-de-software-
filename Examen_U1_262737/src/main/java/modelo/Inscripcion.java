/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author demia
 */
public class Inscripcion {

    private final List<Curso> cursosDisponibles = new ArrayList<>();
    private final List<Curso> cursosInscritos = new ArrayList<>();

    public Inscripcion() {
        cursosDisponibles.add(new Curso("Programacion Orientada a Objetos", 1500.00));
        cursosDisponibles.add(new Curso("Bases de Datos", 1800.00));
        cursosDisponibles.add(new Curso("Diseno de Software", 2000.00));
        cursosDisponibles.add(new Curso("Estructuras de Datos", 1700.00));
        cursosDisponibles.add(new Curso("Redes de Computadoras", 1600.00));
    }

    public List<Curso> getCursosDisponibles() {
        return Collections.unmodifiableList(cursosDisponibles);
    }

    public List<Curso> getCursosInscritos() {
        return Collections.unmodifiableList(cursosInscritos);
    }

    /** Quita el curso de la lista de disponibles y lo agrega a los inscritos. */
    public boolean inscribirCurso(Curso curso) {
        if (curso != null && cursosDisponibles.remove(curso)) {
            cursosInscritos.add(curso);
            return true;
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0;
        for (Curso c : cursosInscritos) {
            total += c.getCosto();
        }
        return total;
    }

    public FichaPago generarFichaPago() {
        return new FichaPago(cursosInscritos, calcularTotal());
    }
}
