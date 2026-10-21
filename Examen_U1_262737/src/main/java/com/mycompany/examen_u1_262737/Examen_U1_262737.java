/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_u1_262737;

import controller.InscripcionController;
import javax.swing.SwingUtilities;
import modelo.Inscripcion;
import vista.VentanaInscripcion;

/**
 *
 * @author demia
 */
public class Examen_U1_262737 {

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Inscripcion modelo = new Inscripcion();
            VentanaInscripcion vista = new VentanaInscripcion();
            InscripcionController controlador = new InscripcionController(modelo, vista);
            controlador.iniciar();
        });
    }
}
