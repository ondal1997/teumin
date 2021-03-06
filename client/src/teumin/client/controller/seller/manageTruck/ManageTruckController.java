package teumin.client.controller.seller.manageTruck;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import teumin.client.Client;
import teumin.entity.Truck;
import teumin.network.Data;

import java.util.ArrayList;

public class ManageTruckController extends Client {
    @FXML
    private VBox vBox;

    ArrayList<HBox> hBoxes = new ArrayList<>();

    String targetTruckName;

    @FXML
    void initialize() throws Exception {
        Data data = new Data();
        data.add("InquiryOwnedTrucks");
        network.write(data);
        data = network.read();
        ArrayList<Truck> trucks = data.get(0);

        for (int i = 0; i < trucks.size(); i++) {
            HBox hBox = new HBox();
            hBox.setPadding(new Insets(10));
            hBox.setAlignment(Pos.CENTER_LEFT);
            Text text = new Text(trucks.get(i).getName());
            hBox.getChildren().addAll(text);
            hBoxes.add(hBox);
            hBox.setOnMouseClicked(e -> {
                for (HBox unit : hBoxes) {
                    unit.setStyle("-fx-background-color: transparent");
                }
                hBox.setStyle("-fx-background-color: white");
                targetTruckName = text.getText();
            });
            vBox.getChildren().add(hBox);
        }
    }

    @FXML
    void click_manage(MouseEvent event) throws Exception {
        if (targetTruckName == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("알림");
            alert.setHeaderText(null);
            alert.setContentText("항목을 선택해주세요.");
            alert.showAndWait();

            return;
        }

        Data data = new Data();
        data.add("InquiryTruckByNameToManage");
        data.add(targetTruckName);
        network.write(data);

        Stage stage = (Stage)vBox.getScene().getWindow();
        stage.close();

        stage.setScene(new Scene(loadFxml("seller/manageTruck/ManageListView.fxml")));
        stage.show();
    }

    @FXML
    void click_back(MouseEvent event) {
        Stage stage = (Stage) vBox.getScene().getWindow();
        stage.close();

        stage.setScene(new Scene(loadFxml("seller/MainView.fxml")));
        stage.show();
    }

}
