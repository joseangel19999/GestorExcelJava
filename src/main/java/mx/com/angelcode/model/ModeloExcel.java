/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.angelcode.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 *
 * @author DELLE6430
 */
public class ModeloExcel {
     ///Workbook wb;
    Workbook wb;
    
   public String importar(File file, JTable tablaD) {
        String respuesta = "No se pudo realizar la peticion";
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        try {
            wb = WorkbookFactory.create(new FileInputStream(file));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.iterator();
            int indiceFila = -1;
            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[10];
                int indiceColumna = -1;
                while (columnaIterator.hasNext()) {
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                       System.out.println("Data celda1: "+celda);
                       if(celda.equals("Detalles")){
                           System.out.println("Entro detalles");
                       } if(celda.equals("Descuentos")){
                           System.out.println("Entro detalles");
                       }
                    /*if (indiceFila == 0) {
                        modeloT.addColumn(celda.getStringCellValue());
                    } else {
                        if (celda != null) {

                         
                           switch (celda.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna] = (int) Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna] = celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna] = celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna] = celda.getDateCellValue();
                                    break;
                            }
                        }
                    }*/
                }
                if (indiceFila != 0) {
                    modeloT.addRow(listaColumna);
                }
            }
            respuesta = "Importacion Exitosa";
        } catch (Exception ex) {

        }
        return "";
    }
   
     public String Exportar(File archiv, JTable tablaD) {
        String respuesta = "No se realizo con exito la exportacion";
        int numFila = tablaD.getRowCount(), numColumna = tablaD.getColumnCount();
        
        if (archiv.getName().endsWith("xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new HSSFWorkbook();
            
        }
        Sheet hoja = wb.createSheet("Pruebita");
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if (i == -1) {
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    } else {
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archiv));
                }
            }
            respuesta = "Exportacion Exitosa";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }

}
