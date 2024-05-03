
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import persistence.DBConnection;
import presentation.archive.ArchiveFormController;
import presentation.archive.ArchiveFormView;
import presentation.listes.ListeFormController;
import presentation.listes.ListeFormView;
import presentation.login.LoginController;
import presentation.login.LoginFormView;
import presentation.projets.ProjetsFormController;
import presentation.projets.ProjetsFormView;
import presentation.seance.SceanceFormController;
import presentation.seance.SeanceFormView;
import presentation.taches.TachesFormController;
import presentation.taches.TachesFormView;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // ListeFormController controller = new ListeFormController();
        // ListeFormView Seance = new ListeFormView(controller);
        // Seance.start(primaryStage);

        // ProjetsFormController controller = new ProjetsFormController();
        // ProjetsFormView projets = new ProjetsFormView(controller);
        // projets.start(primaryStage);
        
        // ListeFormController controller = new ListeFormController();
        // ListeFormView projets = new ListeFormView(controller);
        // projets.start(primaryStage);

        // ArchiveFormController controller = new ArchiveFormController();
        // ArchiveFormView archive = new ArchiveFormView(controller);
        // archive.start(primaryStage);

        TachesFormController controller = new TachesFormController();
        TachesFormView taches = new TachesFormView(controller);
        taches.start(primaryStage);
    }

    public static void main(String[] args) {
        try {
            // Connexion à la base de données
            DBConnection dbConnection = DBConnection.getInstance();
            System.out.println("Connexion à la base de données réussie");

        } catch (Exception e) {
            System.out.println("Erreur de connexion à la base de données");
        }
        // Lancer l'application
        launch(args);
    }
}
