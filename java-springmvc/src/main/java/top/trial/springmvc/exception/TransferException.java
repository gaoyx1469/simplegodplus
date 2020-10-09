package top.trial.springmvc.exception;

/**
 * @Author gaoyx1469
 * @Date 2020/7/31
 * @Version 1.0
 */
public class TransferException extends Exception {

    private String showMessage;

    public TransferException() {
    }

    public String getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(String showMessage) {
        this.showMessage = showMessage;
    }

    public TransferException(String showMessage) {
        this.showMessage = showMessage;
    }
}
