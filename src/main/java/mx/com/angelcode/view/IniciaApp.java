/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.angelcode.view;

import mx.com.angelcode.controller.ExcelController;
import mx.com.angelcode.model.ModeloExcel;

/**
 *
 * @author DELLE6430
 */
public class IniciaApp {
     public static void main(String[] args) {
        ModeloExcel modelo= new ModeloExcel();
        VistaExcel vista= new VistaExcel();
        ExcelController control= new ExcelController(vista,modelo);
        vista.show();
    }
}
