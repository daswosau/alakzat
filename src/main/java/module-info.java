module com.example.alakzat {
    requires javafx.controls;
    requires javafx.fxml;
    //requires org.junit.jupiter.params;
    requires junit;


    opens com.example.alakzat to javafx.fxml;
    exports com.example.alakzat;
}