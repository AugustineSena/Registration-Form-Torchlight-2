package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // TODO code application logic here
        RegistrationForm createNew = new RegistrationForm();
        createNew.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        createNew .setSize( 900, 450 ); // set frame size
        createNew .setVisible( true ); // display frame
        createNew.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - createNew.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - createNew.getHeight()) / 2);
        createNew.setLocation(x, y);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
