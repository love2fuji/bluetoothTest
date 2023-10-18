module com.wen.bluetoothtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires bluecove;


    opens com.wen.bluetoothtest to javafx.fxml;
    exports com.wen.bluetoothtest;
}