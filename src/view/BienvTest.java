/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ile_interdite.Controller;
import ile_interdite.Message;
import ile_interdite.Observateur;



/**
 *
 * @author reyneu
 */
public class BienvTest implements Observateur  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controller c = new Controller();
        VueParamJeu bienvenue = new VueParamJeu(c);
        bienvenue.afficher();
        
    }

    @Override
    public void traiterMessage(Message msg) {
        System.out.println("slt");
    }

    @Override
    public void getDonnees(int nbJoueurs, String nomJ1, String nomJ2, String nomJ3, String nomJ4, int difficulte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
