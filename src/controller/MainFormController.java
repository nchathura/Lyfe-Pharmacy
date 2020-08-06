package controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

public class MainFormController {
    public AnchorPane root;
    public Label lblMainDate;
    public ImageView imgItem;
    public ImageView imgAgent;
    public ImageView imgCompany;
    public ImageView imgEmployee;
    public ImageView imgOrder;
    public Label lblMenu;
    public Label lblDescription;

    public void initialize (){
        FadeTransition ft = new FadeTransition(Duration.millis(2000), root);
        ft.setFromValue(0.0);
        ft.setToValue(2.0);
        ft.play();

        //setCurrentDate
        lblMainDate.setText(LocalDate.now()
                + " | " + LocalTime.now().getHour()+"."+ LocalTime.now().getMinute());
    }

    public void navigate(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();

            Parent root = null;

            switch(icon.getId()){
                case "imgItem":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageItemForm.fxml"));
                    break;
                case "imgAgent":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageAgentForm.fxml"));
                    break;
                case "imgCompany":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageCompanyForm.fxml"));
                    break;
                case "imgEmployee":
                    root = FXMLLoader.load(this.getClass().getResource("/view/ManageEmployeeForm.fxml"));
                    break;
                case "imgOrder":
                    root = FXMLLoader.load(this.getClass().getResource("/view/PlaceOrderForm.fxml"));
                    break;
            }

            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView){
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch(icon.getId()){
                case "imgItem":
                    lblMenu.setText("Manage Items");
                    lblDescription.setText("Click to add, edit, delete, search or view items");
                    break;
                case "imgAgent":
                    lblMenu.setText("Manage Agents");
                    lblDescription.setText("Click to add, edit, delete, search or view agents");
                    break;
                case "imgCompany":
                    lblMenu.setText("Manage Companies");
                    lblDescription.setText("Click to add, edit, delete, search or view companies");
                    break;
                case "imgEmployee":
                    lblMenu.setText("Manage Employees");
                    lblDescription.setText("Click to add, edit, delete, search or view employees");
                    break;
                case "imgOrder":
                    lblMenu.setText("Place Orders");
                    lblDescription.setText("Click if you want to place orders or manage orders");
                    break;
            }

            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }
}
