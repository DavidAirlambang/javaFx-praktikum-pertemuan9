module com.pertemuan09.praktikum09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pertemuan09.praktikum09 to javafx.fxml;
    exports com.pertemuan09.praktikum09;
}