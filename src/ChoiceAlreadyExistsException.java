public class ChoiceAlreadyExistsException extends Exception {
    private int rowNumber, columnNumber;

    public ChoiceAlreadyExistsException (int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    @Override
    public String toString() {
        return ("Η ΘΕΣΗ " + rowNumber + " , " + columnNumber + " ΕΧΕΙ ΗΔΗ ΧΡΗΣΙΜΟΠΟΙΗΘΕΊ!\nΕΙΣΑΓΕΤΕ ΣΥΝΤΕΤΑΓΜΕΝΕΣ ΜΙΑΣ ΕΓΚΥΡΗΣ - ΚΕΝΗΣ ΘΕΣΗΣ");
    }
}
