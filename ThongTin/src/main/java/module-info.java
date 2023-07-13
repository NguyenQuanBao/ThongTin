module com.example.thongtin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thongtin to javafx.fxml;
    exports com.example.thongtin;
}