/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul12;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author mikyqwe
 */
public class DesignPanel extends JPanel {

    public static final int W = 800, H = 600;
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }

    public void addAtRandomLocation(JComponent comp) {
        Random random = new Random();
        int x = random.nextInt(W);
        int y = random.nextInt(H);
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}
