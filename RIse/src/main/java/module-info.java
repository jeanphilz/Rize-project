module org.example.jp.imou.rise {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.jp.imou.rise to javafx.fxml;
    exports org.example.jp.imou.rise;
    exports org.example.jp.imou.rise.controller;
    opens org.example.jp.imou.rise.controller to javafx.fxml;
}