import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class AudioPlayerDemo extends Application {

	static MediaPlayer mediaPlayer = null;
	static int itemNum = -1;	//��ǰ����������
	static int maxItem;	//������Ŀ
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage = EventHandlerDemo.getStage();
		primaryStage.setTitle("音乐播放器");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
