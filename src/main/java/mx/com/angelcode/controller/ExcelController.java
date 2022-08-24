/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.angelcode.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mx.com.angelcode.model.ModeloExcel;
import mx.com.angelcode.view.VistaExcel;

/**
 *
 * @author DELLE6430
 */
public class ExcelController implements ActionListener {

    ModeloExcel modeloExcel=new ModeloExcel();
    VistaExcel visExcel= new VistaExcel();
    JFileChooser selecAtchivo = new JFileChooser();
    File Archivo;
    int contAccion=0;
    
      public ExcelController(VistaExcel vistaE,ModeloExcel modeloE ){
        this.visExcel=vistaE;
        this.modeloExcel=modeloE;
        this.visExcel.btnImportar.addActionListener(this);
        this.visExcel.btnExportar.addActionListener(this);
        System.out.println("Cargo controller");
    }
      public void AgregarFiltro(){
        selecAtchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)","xls"));
         selecAtchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)","xlsx"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       contAccion++;
            if(contAccion==1)AgregarFiltro();
            if(e.getSource()==visExcel.btnImportar){
                if(selecAtchivo.showDialog(null, "Seleccionar archivo")==JFileChooser.APPROVE_OPTION){
                    Archivo=selecAtchivo.getSelectedFile();
                    if(Archivo.getName().endsWith("xls") || Archivo.getName().endsWith("xlsx")){
                       JOptionPane.showMessageDialog(null, modeloExcel.importar(Archivo, visExcel.JTdatos));
                    }else{
                        JOptionPane.showMessageDialog(null, "Elija un formato valido");
                    }
                }
            }
             if(e.getSource()==visExcel.btnExportar){
                if(selecAtchivo.showDialog(null, "Exportar")==JFileChooser.APPROVE_OPTION){
                    Archivo=selecAtchivo.getSelectedFile();
                    if(Archivo.getName().endsWith("xls") || Archivo.getName().endsWith("xlsx")){
                        JOptionPane.showMessageDialog(null, modeloExcel.Exportar(Archivo, visExcel.JTdatos));
                    }else{
                        JOptionPane.showMessageDialog(null, "Elija un formato valido");
                    }
                }
            }
            
    }
    
}
