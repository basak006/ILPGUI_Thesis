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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

public class AddRows {
    public static void main(String[] args) {
        final String[] columns = { "Name", "Age" , "Weight" , "Insulin Level" };
        final String[][] data = {};
        final DefaultTableModel model = new DefaultTableModel(data, columns);
        final JTable jt = new JTable(model);
        final JFrame frame = new JFrame();
        final JScrollPane jps = new JScrollPane(jt);
        final JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        JButton b1 = new JButton("Start");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
     
        panel.add(b1, c);
        
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(jps, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.addRow(new String[] { "Name", "Age", "Weight", "Insulin"});
            }
        };
        b1.addActionListener(actionListener);

        frame.pack();
        frame.setVisible(true);
    }
}