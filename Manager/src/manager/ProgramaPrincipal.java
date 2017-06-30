/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import managerGUI.Principal;
import static manager.ProgramaPrincipal.manager;

/**
 *
 * @author Alvaro
 */
public class ProgramaPrincipal {

    public static Manager manager;

    public static void main(String[] args) {
        manager = new Manager();
        manager.recuperarDatos();
        Principal vista = new Principal();
        vista.setVisible(true);

    }

}
