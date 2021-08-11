module ProjectPersonal.Thethreecarddealer {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;

    opens ProjectPersonal.Thethreecarddealer to javafx.fxml;
    exports ProjectPersonal.Thethreecarddealer;
}
