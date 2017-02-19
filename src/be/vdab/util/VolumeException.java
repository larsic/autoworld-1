package be.vdab.util;

public class VolumeException extends IllegalArgumentException {

    public VolumeException() {
    }

    public VolumeException(String message) {
        super(message);
    }

    public VolumeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VolumeException(Throwable cause) {
        super(cause);
    }

}
