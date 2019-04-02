package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        // TODO code application logic here
        RegistrationForm createNew = new RegistrationForm();
        createNew .setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        createNew .setSize( 900, 450 ); // set frame size
        createNew .setVisible( true ); // display frame
        createNew.setResizable(false);
        /*  try {
    		createNew.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/register/background_full.jpg")))));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	createNew.pack();*/

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - createNew.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - createNew.getHeight()) / 2);
        createNew.setLocation(x, y);
    }


    public static void main(String[] args) {

        launch(args);
    }
}
