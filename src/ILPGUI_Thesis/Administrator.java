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

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class Administrator extends JFrame {

        private String col []= {"Account No.","PinCode","First Name",
        "Last Name", "MI","BirthDate","Sex","E-mail","Address"};
        private JScrollPane scroll;
        private JTable table;
        private DefaultTableModel model;

     public Administrator(){
        //ImageIcon bcr = new ImageIcon(getClass().getResource("/images/bcr.jpg"));
        final JButton back = new JButton("back");
        back.setLocation(20,480);
        back.setSize(70,30);
        back.setPreferredSize(new Dimension(90,30));
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            dispose();
            }
        }
        );
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("file.txt"))));

            String line = "";

            int width = 0, height = 0;

            while((line = br.readLine())!=null){

            if(width == 0){

            String data[] = line.split("-");
            width = data.length;

            }
            height++;

            String matrix[][] = new String[height][width];
            model = new DefaultTableModel(matrix, col);
            table = new JTable(model){
            public boolean isCellEditable(int row, int column){
            return false;
                }
            };
        }
        }
        catch (IOException ex){
        ex.printStackTrace();
        }

        DefaultTableCellRenderer cent = new DefaultTableCellRenderer();
        cent.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer(cent);
        table.getColumnModel().getColumn(1).setCellRenderer(cent);
        table.getColumnModel().getColumn(2).setCellRenderer(cent);
        table.getColumnModel().getColumn(3).setCellRenderer(cent);
        table.getColumnModel().getColumn(4).setCellRenderer(cent);
        table.getColumnModel().getColumn(5).setCellRenderer(cent);
        table.getColumnModel().getColumn(6).setCellRenderer(cent);
        table.getColumnModel().getColumn(7).setCellRenderer(cent);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.getColumnModel().getColumn(7).setPreferredWidth(120);

        scroll = new JScrollPane(table);
        scroll.setLocation(20, 320);
        scroll.setSize(750,150);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.add(back);
        pane.add(scroll);

        /*setIconImage(new ImageIcon("/images/icon.jpg").getImage());
        setLayout(new BorderLayout());
        JLabel www = new JLabel(new ImageIcon(getClass().getResource("/images/admin.jpg")));
        add(www);*/
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Account Profile");
        setSize(800,550);
        setResizable(false);
        setVisible(true);
        setLocation(110, 30);
     }
     public static void main(String[]args){
        new Administrator();
     }
}