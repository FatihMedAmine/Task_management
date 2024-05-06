package presentation.listes;

import metier.GestionnaireListe;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.NewList.AddListView;

public class ListeFormController {
    private GestionnaireListe gestionnaireListe;
    private ListeFormView listView;
    private modeleList modeleList;

    public ListeFormController(ListeFormView listeFormView) {
        this.gestionnaireListe = new GestionnaireListe();
        this.listView = listeFormView;
        this.modeleList = new modeleList();
    }

    // Affiche le formulaire d'ajout de liste
    public void handleAjouterButtonAction() {
        AddListView newListFormulaire = new AddListView(this);
        Stage stage = new Stage();
        newListFormulaire.start(stage);
    }


    // Affiche les listes triées
    public void handleOrdonnerButton() {
        System.out.println("Left button clicked");
        List<String> listes = gestionnaireListe.sortedLists(this.modeleList.getListes());
        afficheListesEnGrid(listes);

    }


    // Affiche les listes dans la vue
    public void afficheListes() {
        List<Document> listes = gestionnaireListe.obtenirToutesLesListes();
        this.modeleList.setListes(ConvertDocumentListToStringList(listes));
        afficheListesEnGrid(this.modeleList.getListes());
    }

    // Convertit une liste de documents en une liste de chaînes de caractères
    private List<String> ConvertDocumentListToStringList(List<Document> list) {
        List<String> stringList = new ArrayList<String>();
        for (Document doc : list) {
            stringList.add(doc.getString("titre"));
        }
        return stringList;
    }


    // Affiche les listes dans la vue
    private void afficheListesEnGrid(List<String> listes) {
        this.listView.ZoneListes.getChildren().clear();
        for (String liste : listes) {
            Button newListButton = createListButton(liste);
            int colIndex = this.listView.ZoneListes.getChildren().size() % 5; // Calculating column index
            int rowIndex = this.listView.ZoneListes.getChildren().size() / 5; // Calculating row index
            this.listView.ZoneListes.add(newListButton, colIndex, rowIndex);
        }
    }


    // Crée un bouton pour une liste
    private Button createListButton(String title) {
        Button newListButton = new Button(title);
        newListButton.setStyle("-fx-background-color: #112D4E; " +
                "-fx-background-radius: 10px; " +
                "-fx-min-width: 170px; " +
                "-fx-min-height: 60px;" +
                "-fx-text-fill: #ffffff;" +
                "-fx-font-size: 18px;");

        try {
            Image listIcon = new Image("file:./Pictures/to-do.png");
            ImageView listIconView = new ImageView(listIcon);
            listIconView.setFitWidth(15);
            listIconView.setFitHeight(15);
            newListButton.setGraphic(listIconView);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de l'icône de la liste : " + e.getMessage());
        }
        return newListButton;
    }
}
