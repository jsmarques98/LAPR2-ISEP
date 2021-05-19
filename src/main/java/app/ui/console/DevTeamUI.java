package app.ui.console;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {

    }
    public void run()
    {
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t João Miranda - 1200614@isep.ipp.pt \n");
        System.out.printf("\t Milene Farias - 1170878@isep.ipp.pt \n");
        System.out.printf("\t João Marques - 1192221@isep.ipp.pt \n");
        System.out.printf("\t Grigory Gil - 1191902@isep.ipp.pt \n");
        System.out.printf("\t José Silva - 1190772@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
