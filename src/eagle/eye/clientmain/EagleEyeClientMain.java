/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle.eye.clientmain;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Tomek
 */
public class EagleEyeClientMain {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       Window mainWindow = new Window();
       mainWindow.setVisible(true);
    }
    
}
