/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IBulletinView;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Niveau;
import gestionEcole.model.entity.Periode;
import gestionEcole.View.CLI.impl.MainViewImpl;
import gestionEcole.View.CLI.impl.BulletinViewImpl;
import gestionEcole.Controller.CLI.I.IBulletinControllerCLI;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class BulletinControllerImpl implements IBulletinControllerCLI {

    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final IMainView mainV = new MainViewImpl();
    private static final IBulletinView bulletinV = new BulletinViewImpl();

    @Override
    public void controller() {
        boolean status = true;
        Periode periode;
        Classe classe;
        Eleve eleve;
        Cours cours;
        Niveau niveau;

        do {
            switch (mainV.showBulletin()) {
                case 1:
                    periode = consultationC.controlPeriode();
                    niveau = consultationC.controlNiveau();
                    classe = consultationC.controlClasse(niveau);
                    eleve = consultationC.controlEleve(classe);
                    bulletinV.showBulletin(periode, eleve);
                    break;
                case 2:
                    periode = consultationC.controlPeriode();
                    niveau = consultationC.controlNiveau();
                    classe = consultationC.controlClasse(niveau);
                    cours = consultationC.controlCours(classe);
                    bulletinV.showMoyenne(periode, cours);
                    break;
                case 3:
                    status = false;
                    break;
            }

        } while (status == true);
    }
}
