/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionEcole.schoolManager.CLI.Main;

import gestionEcole.Controller.CLI.impl.MainControllerImpl;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.View.CLI.impl.MainViewImpl;
import gestionEcole.jpa.dao.I.IPeriodeDao;
import gestionEcole.jpa.dao.impl.PeriodeDaoImpl;
import gestionEcole.Controller.CLI.I.IMainControllerCLI;


/**
 Author : BIRREGAH Dibamaka Maguewaba Crédo
Goal : School Management Project
Last update : 27/05/2022.
 */

public class ProgrammeGestionnaire {         
    /**
     * @param args the command line arguments
     */
    
    
    private static final IPeriodeDao periodeDao = new PeriodeDaoImpl();
    private static final IMainControllerCLI mainC = new MainControllerImpl();
    private static final IMainView mainV = new MainViewImpl();
    
    public static void main(String[] args) {
        //on force un chargement dès le début pour activer la connexion avec hibernate
        periodeDao.lister();
        mainV.welcomeMsg();
        mainC.controller();
        
 }
    
    
}