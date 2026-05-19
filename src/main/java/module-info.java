module btaahaus.ahrfxglgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.almasb.fxgl.all;
    opens btaahaus.ahrfxglgame to javafx.fxml;
    exports btaahaus.ahrfxglgame;
}
