
import Poker.Card;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class UI extends Application {

	public void setOnDragDetected(ImageView imageView) {
		imageView.setOnDragDetected(event -> {
			System.out.println((Card) imageView.getUserData());
			Dragboard db = imageView.startDragAndDrop(TransferMode.MOVE);
			ClipboardContent content = new ClipboardContent();
			content.putImage(imageView.getImage());
			db.setContent(content);
			// event.consume();
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage s2 = new Stage();
		FlowPane root2 = new FlowPane();

		root2.setOnDragDropped(event -> {
			Dragboard db = event.getDragboard();
			System.out.println("test");
			if (db.hasImage()) {
				ImageView iv = new ImageView(db.getImage());
				iv.setFitHeight(200);
				iv.setFitWidth(200);
				root2.getChildren().add(iv);
			}
		});

		Scene sc = new Scene(root2);

		s2.setScene(sc);
		s2.setTitle("Get Image");

		s2.show();

		FlowPane root = new FlowPane();
		ImageView[] images = new ImageView[52];

		for (int index = 0; index < images.length; index++) {
			Card card = Card.values()[index];
			images[index] = new ImageView("file:///C:/Users/Anonymous/Desktop/Poker/" + card.toString() + ".jpg");
			images[index].setFitHeight(300);
			images[index].setFitWidth(300);
			images[index].setUserData(card);
			this.setOnDragDetected(images[index]);
			root.getChildren().add(images[index]);
		}

		// images = new
		// ImageView("file:///C:/Users/Anonymous/Desktop/Poker/CLUB_ELEVEN.jpg");

		Scene s = new Scene(root);

		primaryStage.setTitle("test");
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
