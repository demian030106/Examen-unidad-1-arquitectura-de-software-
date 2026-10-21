/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import modelo.Curso;
import modelo.FichaPago;
import modelo.Inscripcion;
import vista.VentanaInscripcion;

/**
 *
 * @author demia
 */
public class InscripcionController {

    private final Inscripcion modelo;
    private final VentanaInscripcion vista;

    public InscripcionController(Inscripcion modelo, VentanaInscripcion vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setAccionInscribir(e -> inscribirCurso());
        this.vista.setAccionFinalizar(e -> finalizarInscripcion());
        actualizarVista();
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    public void inscribirCurso() {
        Curso curso = vista.getCursoSeleccionado();
        modelo.inscribirCurso(curso);
        actualizarVista();
    }

    public void finalizarInscripcion() {
        FichaPago ficha = modelo.generarFichaPago();
        vista.mostrarFichaPago(ficha.generarTexto());
    }

    private void actualizarVista() {
        vista.setCursosDisponibles(modelo.getCursosDisponibles());
        vista.setCursosInscritos(modelo.getCursosInscritos());
        vista.setTotal(modelo.calcularTotal());
    }
}
