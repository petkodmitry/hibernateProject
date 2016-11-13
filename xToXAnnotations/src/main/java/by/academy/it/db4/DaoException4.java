package by.academy.it.db4;

public class DaoException4 extends Exception {

    private Exception exception;

    public DaoException4(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
