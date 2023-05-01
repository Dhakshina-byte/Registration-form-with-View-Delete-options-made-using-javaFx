import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InputData {
    StringProperty DataName = new SimpleStringProperty();
    StringProperty DataAge = new SimpleStringProperty();
    StringProperty DataPhoneNumber = new SimpleStringProperty();
    StringProperty Dataemail = new SimpleStringProperty();

    public final StringProperty DataNameProperty() {
        return this.DataName;
    }

    public final java.lang.String getDataName() {
        return this.DataNameProperty().get();
    }

    public final void setDataName(final java.lang.String DataName) {
        this.DataNameProperty().set(DataName);
    }

    public final StringProperty DataAgeProperty() {
        return this.DataAge;
    }

    public final java.lang.String getDataAge() {
        return this.DataAgeProperty().get();
    }

    public final void setDataAge(final java.lang.String DataAge) {
        this.DataAgeProperty().set(DataAge);
    }

    public final StringProperty DataPhoneNumberProperty() {
        return this.DataPhoneNumber;
    }

    public final java.lang.String getDataPhoneNumber() {
        return this.DataPhoneNumberProperty().get();
    }

    public final void setDataPhoneNumber(final java.lang.String DataPhoneNumber) {
        this.DataPhoneNumberProperty().set(DataPhoneNumber);
    }

    public final StringProperty DataemailProperty() {
        return this.Dataemail;
    }

    public final java.lang.String getDataemail() {
        return this.DataemailProperty().get();
    }

    public final void setDataemail(final java.lang.String Dataemail) {
        this.DataemailProperty().set(Dataemail);
    }

}
