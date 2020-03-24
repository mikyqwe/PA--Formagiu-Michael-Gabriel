/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laborator6;

import static com.miky.laborator6.DrawingPanel.H;
import static com.miky.laborator6.DrawingPanel.W;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mikyqwe
 */
public class ControlPanel extends JPanel {
 final MainFrame frame;
 JButton saveBtn = new JButton("Save");
 //create all buttons (Load, Reset, Exit)
JButton loadBtn = new JButton ("Load");
JButton resetBtn = new JButton ("Reset");
JButton exitBtn = new JButton ("Exit");

 public ControlPanel(MainFrame frame) {
 this.frame = frame; init();
 }
 private void init() {
 //change the default layout manager (just for fun)
 setLayout(new GridLayout(1, 4));
add(saveBtn);
add(loadBtn);
add(resetBtn);
add(exitBtn);
 //configure listeners for all buttons
 saveBtn.addActionListener(this::save);
loadBtn.addActionListener(this::load);
resetBtn.addActionListener(this::reset);
exitBtn.addActionListener(this::exit);
 }
 private void save(ActionEvent e) {
 try {
 ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
 } catch (IOException ex) { System.err.println(ex); }
 }

    private void load(ActionEvent e) {
     try {
         frame.canvas.image = ImageIO.read(new File("d://test.png"));
     } catch (IOException ex) {
         Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
     }
        frame.canvas.image.createGraphics();
        frame.canvas.repaint();
    }

    private void reset(ActionEvent e) {
      frame.canvas.image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, W, H);
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

