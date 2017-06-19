/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import Controlleur.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Message;
import util.TypesMessage;

/**
 *
 * @author jacquett
 */
public class VueJeu {
    private final JFrame window;
    private static Controller controller;
    private JButton[] btnTuiles = new JButton[24];
    private Grille grille;
    private String nomJoueurCourant;
    
    public VueJeu(Controller c, Grille grille){
        setGrille(grille);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.window = new JFrame();
        window.setSize(dim.width, dim.height);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("ILE INTERDITE");
        
        controller = c;
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panelGrille = new JPanel(new GridLayout(6, 6));
        JPanel panelMenu = new JPanel(new GridLayout(4,2));
        
        window.add(mainPanel);
        mainPanel.add(panelGrille, BorderLayout.CENTER);
        mainPanel.add(panelMenu, BorderLayout.EAST);
        
        Tuile[][] grilleTab = grille.getGrille();
        
        
        Tuile tuile = null;
        Color etatCouleur = null;
        String nomTuile;
        
        for (int i=0; i<24;i++){
            btnTuiles[i] = new JButton();
            btnTuiles[i].setEnabled(false);
        }
        
        int k = 0;
        
        for (int i = 0; i<=5 ; i++){
            for (int j = 0; j<= 5; j++){
                    nomTuile = grilleTab[i][j].getNom();
                    if (grilleTab[i][j].getEtat() == Etat.assechee){
                        etatCouleur = Color.DARK_GRAY;
                    }
                    else if (grilleTab[i][j].getEtat() == Etat.inondee){
                        etatCouleur = Color.ORANGE;
                    }
                    else {
                        etatCouleur = Color.BLUE;
                    }
                    if (grilleTab[i][j].getNom().equals("null")){
                        panelGrille.add(new JPanel());
                    }
                    else{
                        btnTuiles[k].setText(nomTuile);
                        btnTuiles[k].setBackground(etatCouleur);
                        btnTuiles[k].setForeground(Color.WHITE);
                        panelGrille.add(btnTuiles[k]);
                        
                        k++;
                    }
                    
                    
            }
            
            

        }
        
        JButton btnAssechement = new JButton("Assecher");
        JButton btnDeplacement = new JButton("Deplacer");
        JButton btnDonnerCarte = new JButton("DonnerCarte");
        JButton btnFinTour = new JButton("Fin Du Tour");
        panelMenu.add(new JPanel());
        panelMenu.add(new JPanel());
        panelMenu.add(btnAssechement);
        panelMenu.add(btnDeplacement);
        panelMenu.add(btnDonnerCarte);
        panelMenu.add(btnFinTour);
        panelMenu.add(new JPanel());
        panelMenu.add(new JPanel());
        
        
        
        btnAssechement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(TypesMessage.ACTION_Assecher);
                c.traiterMessage(msg);
            }
        });
        
        btnDeplacement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(TypesMessage.ACTION_Deplacer);
                c.traiterMessage(msg);
            }
        });
        
        btnDonnerCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(TypesMessage.ACTION_DonnerCarte);
                c.traiterMessage(msg);
            }
        });
        
        btnFinTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message msg = new Message(TypesMessage.ACTION_Fin);
                c.traiterMessage(msg);
            }
        });
       

        }
     public void afficher(){
        window.setVisible(true);
    }
    
    public void fermer() {
        window.dispose();
    }
    
    public void setGrille(Grille grille){
        this.grille = grille;
    }
    
    public void setNom(String nom){
        this.nomJoueurCourant = nom;
    }
    
    }

