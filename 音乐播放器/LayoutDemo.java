
import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class LayoutDemo {
	static MenuItem openSongFiles = new MenuItem("打开歌曲文件");
	static MenuItem openDirectory = new MenuItem("打开目录");
	static MenuItem closeSoftware = new MenuItem("关闭软件");
	static Button play = new Button("播放");
	static Button last = new Button("上一曲");
	static Button next = new Button("下一曲");
	static Button loop = new Button("单曲循环");
	static Button stop = new Button("停止");
	static Slider slider = new Slider();
	static Slider volumeSlider = new Slider();
	static Label timeLabel = new Label();
	static Label volumeLabel = new Label("音量");
	static BorderPane bp = new BorderPane();
	static ListView<Label> lv = new ListView<Label>();
	static Scene sc = new Scene(LayoutDemo.getBorderPane(), 700, 700);
	static MediaView mediaView = null;
	static TextFlow tf = new TextFlow();

	// ��ʾ�����¼�
	static public void doParse() {
		File path = UtilDemo.listFiles.get(AudioPlayerDemo.itemNum);
		String str = "正在播放：\n";
		str += path.getName();
		Text text = new Text(str);
		text.setFill(Color.MEDIUMVIOLETRED);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		tf.getChildren().clear();
		tf.getChildren().add(text);
		bp.setCenter(tf);
	}

	// �˵�
	static public MenuBar getMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("文件(_F)");
		fileMenu.setMnemonicParsing(true);
		menuBar.getMenus().add(fileMenu);
		fileMenu.getItems().addAll(openSongFiles, openDirectory, closeSoftware);
		return menuBar;
	}

	// �������ļ�����
	static public void bindSlider() {
		slider.setMaxWidth(Region.USE_PREF_SIZE);
		slider.setShowTickMarks(true);
		volumeSlider.setMaxWidth(Region.USE_PREF_SIZE);
		volumeSlider.setValue(50);
		volumeSlider.minWidth(30);
		volumeSlider.setShowTickMarks(true);
		volumeSlider.setShowTickLabels(true);

		if (AudioPlayerDemo.mediaPlayer != null) {
			AudioPlayerDemo.mediaPlayer.currentTimeProperty().addListener(e -> {
				// ��Ƶ�������������
				if (AudioPlayerDemo.mediaPlayer.getCurrentTime().equals(AudioPlayerDemo.mediaPlayer.getStopTime())) {
					if (AudioPlayerDemo.itemNum != -1) {
						LayoutDemo.lv.getItems().get(AudioPlayerDemo.itemNum % AudioPlayerDemo.maxItem)
								.setTextFill(Color.BLACK);
					}
					AudioPlayerDemo.itemNum++;
					File path1 = UtilDemo.listFiles.get(AudioPlayerDemo.itemNum % AudioPlayerDemo.maxItem);
					String source1 = path1.toURI().toString();
					Media media1 = new Media(source1);
					AudioPlayerDemo.mediaPlayer.dispose();
					AudioPlayerDemo.mediaPlayer = new MediaPlayer(media1);
					LayoutDemo.lv.getItems().get(AudioPlayerDemo.itemNum).setTextFill(Color.BROWN);
					LayoutDemo.bindSlider();
					AudioPlayerDemo.mediaPlayer.play();
				}

				timeLabel.setText(Seconds2Str(AudioPlayerDemo.mediaPlayer.getCurrentTime().toSeconds()));
				slider.setValue(AudioPlayerDemo.mediaPlayer.getCurrentTime().toMillis()
						/ AudioPlayerDemo.mediaPlayer.getStopTime().toMillis() * 100);
			});

			slider.valueProperty().addListener(e -> {
				if (slider.isValueChanging()) {
					AudioPlayerDemo.mediaPlayer.seek(new Duration(
							AudioPlayerDemo.mediaPlayer.getStopTime().multiply(slider.getValue() / 100).toMillis()));
				}
			});
		}
	}

	static public FlowPane getHbox() {
		FlowPane fp = new FlowPane(5, 5);
		fp.getChildren().addAll(volumeLabel, volumeSlider, timeLabel, slider, play, last, next, loop, stop);
		fp.setPadding(new Insets(10, 10, 10, 10));
		fp.setAlignment(Pos.CENTER);
		return fp;
	}

	static public BorderPane getBorderPane() {
		bp.setBottom(getHbox());
		bp.setTop(getMenuBar());
		bp.setCenter(tf);
		if (UtilDemo.initDate() != null)
			bp.setRight(UtilDemo.initDate());
		return bp;
	}

	static String Seconds2Str(Double seconds) {
		Integer count = seconds.intValue();
		count = count % 3600;
		Integer Minutes = count / 60;
		count = count % 60;
		String str = Minutes.toString() + ":" + count.toString();
		return str;
	}
}
