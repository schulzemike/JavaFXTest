module hellofx {
  requires javafx.controls;
  requires javafx.fxml;

  opens my.project to javafx.fxml;
  exports my.project;
}
