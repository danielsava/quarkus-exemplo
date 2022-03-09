package microsoft.graph;


import microsoft.graph.auth.MicrosoftGraphAuth;
import microsoft.graph.config.MicrosoftAppTutorialConfig;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.InputMismatchException;
import java.util.Scanner;

@ApplicationScoped
public class MicrosoftGraphService {

    private static final Logger log = Logger.getLogger(MicrosoftGraphService.class);

    @Inject
    MicrosoftAppTutorialConfig appTutorialConfig;

    public void mostrarMenu() {

        log.info("Java Graph Tutorial");


        MicrosoftGraphAuth.graphAuth(appTutorialConfig.id(), appTutorialConfig.scopes());

        Scanner input = new Scanner(System.in);

        int choice = -1;

        while(choice != 0) {

            log.info("Please choose one of the following options:");
            log.info("0. Exit");
            log.info("1. Display access token");
            log.info("2. View this week´s calendar");
            log.info("3. Add an event");

            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                log.warn("Entrada inválida");
            }

            input.nextLine();

            // Process user choise
            switch (choice) {

                case 0:
                    // Exit the program
                    log.info("Goodbye ...");
                    break;
                case 1:
                    // Display access token
                    break;
                case 2:
                    // List the calendar
                    break;
                case 3:
                    // Create a new event
                    break;
                default:
                    log.info("Invalid Choice");

            }


            input.close();

        }




    }







}
