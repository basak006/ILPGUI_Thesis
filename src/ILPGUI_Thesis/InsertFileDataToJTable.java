/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ILPGUI_Thesis;

/**
 *
 * @author Priyankana
 */
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
public class InsertFileDataToJTable extends AbstractTableModel {
    Vector data;
    Vector columns;

    public InsertFileDataToJTable() {
            String line;
            data = new Vector();
            columns = new Vector();
            try {
                    FileInputStream fis = new FileInputStream("/file.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                    while (st1.hasMoreTokens())
                            columns.addElement(st1.nextToken());
                    while ((line = br.readLine()) != null) {
                            StringTokenizer st2 = new StringTokenizer(line, " ");
                            while (st2.hasMoreTokens())
                                    data.addElement(st2.nextToken());
                    }
                    br.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public int getRowCount() {
            return data.size() / getColumnCount();
    }

    public int getColumnCount() {
            return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
            return (String) data.elementAt((rowIndex * getColumnCount())
                            + columnIndex);
    }

    public static void main(String s[]) {
            InsertFileDataToJTable model = new InsertFileDataToJTable();
            JTable table = new JTable();
            table.setModel(model);
            JScrollPane scrollpane = new JScrollPane(table);
            JPanel panel = new JPanel();
            panel.add(scrollpane);
            JFrame frame = new JFrame();
            frame.add(panel, "Center");
            frame.pack();
            frame.setVisible(true);
    }
}