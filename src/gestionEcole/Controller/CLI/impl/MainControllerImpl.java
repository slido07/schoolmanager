/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.View.CLI.impl.MainViewImpl;
import gestionEcole.Controller.CLI.I.IAjoutControllerCLI;
import gestionEcole.Controller.CLI.I.IBulletinControllerCLI;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;
import gestionEcole.Controller.CLI.I.IMainControllerCLI;
import gestionEcole.Controller.CLI.I.IModificationControllerCLI;
import gestionEcole.Controller.CLI.I.ISuppressionControllerCLI;
/**
 *
 * @author HP
 */
public class MainControllerImpl implements IMainControllerCLI{
    private static final IBulletinControllerCLI bulletinC = new BulletinControllerImpl();
    private static final IModificationControllerCLI modificationC = new ModificationControllerImpl();
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final ISuppressionControllerCLI suppressionC = new SuppressionControllerImpl();
    private static final IAjoutControllerCLI ajoutC = new AjoutControllerImpl();
    private static final IMainView mainV = new MainViewImpl();
    
    @Override
    public void controller() {
        boolean status = true;
        do {
            switch (mainV.showMenu()) {
                case 1:
                    ajoutC.controller();
                    break;
                case 2:
                    suppressionC.controller();
                    break;
                case 3:
                    consultationC.controller();
                    break;
                case 4:
                    modificationC.controller();
                    break;
                case 5:
                    bulletinC.controller();
                    break;
                case 6:
                    status = false;
                    break;
            }
        } while (status == true);
    }

}
