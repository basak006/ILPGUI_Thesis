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

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
 

public class ThesisApp1 extends JPanel implements ActionListener {
    
    JFileChooser fc;
    JMenuItem jmiOpen,jmiClose,jmiSave,jmiExit;
    JTextArea log;
    
  ThesisApp1() {
      
    super(new BorderLayout());
     
    JFrame f = new JFrame("Thesis Application");
    f.setSize(600, 600);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar jmb = new JMenuBar();

    log = new JTextArea(5,20);
    log.setMargin(new Insets(5,5,5,5));
    log.setEditable(false);
    JScrollPane logScrollPane = new JScrollPane(log);
        
    JMenu jmFile = new JMenu("File");
    jmiOpen = new JMenuItem("Open");
    jmiClose = new JMenuItem("Close");
    jmiSave = new JMenuItem("Save");
    jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    JMenu jmOptions = new JMenu("Options");
    JMenu a = new JMenu("A");
    JMenuItem b = new JMenuItem("B");
    JMenuItem c = new JMenuItem("C");
    JMenuItem d = new JMenuItem("D");
    a.add(b);
    a.add(c);
    a.add(d);
    jmOptions.add(a);

    JMenu e = new JMenu("E");
    e.add(new JMenuItem("F"));
    e.add(new JMenuItem("G"));
    jmOptions.add(e);

    jmb.add(jmOptions);

    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiAbout = new JMenuItem("About");
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);

    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
    b.addActionListener(this);
    c.addActionListener(this);
    d.addActionListener(this);
    jmiAbout.addActionListener(this);

    f.setJMenuBar(jmb);
    f.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
 
        //Handle open button action.
        if (e.getSource() == jmiOpen) {
            int returnVal = fc.showOpenDialog(ThesisApp1.this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                log.append("Opening: " + file.getName() + "." );
            } else {
                log.append("Open command cancelled by user." );
            }
            log.setCaretPosition(log.getDocument().getLength());
 
        //Handle save button action.
        } else if (e.getSource() == jmiSave) {
            int returnVal = fc.showSaveDialog(ThesisApp1.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." );
            } else {
                log.append("Save command cancelled by user." );
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
  public static void main(String args[]) {
    new ThesisApp1();
  }
}
