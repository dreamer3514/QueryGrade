package javafx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; 
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application{
	
    
	 
	
	public void start(Stage primaryStage)
	{
		final TableView<Class_info> table = new TableView<>(); 
		 
		GridPane login_pane = new GridPane();
		login_pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
		login_pane.setHgap(5.5);
		login_pane.setVgap(5.5);
		
		Label l1 = new Label("学号：");
		Label l2 = new Label("密码：");
		final TextField t1 = new TextField();
		final TextField t2 = new TextField();
	
		VBox vBox =new VBox(login_pane);
		login_pane.add(l1, 0, 0);
		login_pane.add(l2, 0, 1);		
		login_pane.add(t1, 1, 0);
		login_pane.add(t2, 1, 1);
		
		
		Button btn1 = new Button("获取");
		login_pane.add(btn1, 1, 3);
		
		Pane class_pane = new Pane(table);
		
		HBox hBox = new HBox(vBox,class_pane);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				String a = t1.getText();	
				String b = t2.getText();
				Spider spider = new Spider(a,b);
				String[][] m = spider.get_class();
				ObservableList<Class_info> data = FXCollections.observableArrayList();
				for(int i=0;i<spider.getCount();i++)
				{
					Class_info c = new Class_info(m[i][0], m[i][1], m[i][2], m[i][3], m[i][4], m[i][5], m[i][6]);
					data.add(c);
				}
				table.setItems(data);
			}
		});
		
		
		
			
		TableColumn numbercColumn =new TableColumn("课程号");
		numbercColumn.setMinWidth(100);
		numbercColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
		TableColumn numcColumn =new TableColumn("课序号");
		numcColumn.setMinWidth(50);
		numcColumn.setCellValueFactory(new PropertyValueFactory<>("Num"));
		TableColumn classNamecColumn =new TableColumn("课程名称");
		classNamecColumn.setMinWidth(150);
		classNamecColumn.setCellValueFactory(new PropertyValueFactory<>("ClassName"));
		TableColumn englishNamecColumn =new TableColumn("英文名");
		englishNamecColumn.setMinWidth(200);
		englishNamecColumn.setCellValueFactory(new PropertyValueFactory<>("EnglishName"));
		TableColumn creditcColumn =new TableColumn("学分");
		creditcColumn.setMinWidth(50);
		creditcColumn.setCellValueFactory(new PropertyValueFactory<>("Credit"));
		TableColumn propertiescColumn =new TableColumn("属性");
		propertiescColumn.setMinWidth(50);
		propertiescColumn.setCellValueFactory(new PropertyValueFactory<>("Properties"));
		TableColumn scorecColumn =new TableColumn("成绩");
		scorecColumn.setMinWidth(80);   
		scorecColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
									 
		table.getColumns().addAll(numbercColumn, numcColumn, classNamecColumn,englishNamecColumn,creditcColumn,propertiescColumn,scorecColumn); 
		
		
		Scene scene = new Scene(hBox,1000,420);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	public static void main(String[] args)
	{
		
		Application.launch();
		
	}
	
	
}

