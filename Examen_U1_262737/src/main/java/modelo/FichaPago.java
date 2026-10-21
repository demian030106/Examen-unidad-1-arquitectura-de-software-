/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FichaPago {

    private final List<Curso> cursos;
    private final double total;

    public FichaPago(List<Curso> cursosInscritos, double total) {
        this.cursos = new ArrayList<>(cursosInscritos);
        this.total = total;
    }

    public List<Curso> getCursos() {
        return Collections.unmodifiableList(cursos);
    }

    public double getTotal() {
        return total;
    }

    public String generarTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("FICHA DE PAGO\n");
        for (Curso c : cursos) {
            sb.append(String.format("%-25s $%8.2f%n", c.getNombre(), c.getCosto()));
        }
        sb.append(String.format("%-25s $%8.2f%n", "TOTAL", total));
        return sb.toString();
    }
}
