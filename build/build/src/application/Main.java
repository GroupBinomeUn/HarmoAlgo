package application;
	
import application.Classes.People;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,640,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:../../resources/images/unicorn.png"));
			primaryStage.setTitle("Carnet d'adresses");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			People newPeople = new People(0,"Hulu","Berlu","0601020307","Aubusson","23210","Rue des moutons");
			newPeople.addPeople();
			newPeople = new People(0,"Mitterand","Nicolas","0601057247","Guéret","23000","Avenue perdue");
			newPeople.addPeople();
			newPeople = new People(0,"De Gaulle","François","","Mont","98919","Cur-ry");
			newPeople.addPeople();
			newPeople = new People(0,"Ellab","Ienbu","0601587241","Limoges","87000","IUT");
			newPeople.addPeople();
			newPeople = new People(0,"Java","Nais","0604572754","Mar","01987","Rue des fleurs");
			newPeople.addPeople();
			newPeople = new People(0,"Petit","Nicolas","0651255448","Guéret","23000","Avenue Leclerc");
			newPeople.addPeople();
			newPeople = new People(0,"Diex","Julia","0351458959","","","");
			newPeople.addPeople();
			newPeople = new People(0,"Maka","Ravane","0759842069","Bloque","76542","Rue des mirtilles");
			newPeople.addPeople();
			newPeople = new People(0,"Pierre","Dominique","","","","");
			newPeople.addPeople();
			newPeople = new People(0,"Colette","Colette","0848887898","Sezanne","51120","");
			newPeople.addPeople();
			newPeople = new People(0,"Yasue","Lucy","0652788434","","","");
			newPeople.addPeople();
			newPeople = new People(0,"Merguez","","0978651524","","","");
			newPeople.addPeople();
			newPeople = new People(0,"Niou","Piou","0604572754","Maisons","","Rue des fleurs");
			newPeople.addPeople();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
