package briup.common.exception;

public class classsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public classsException() {
		super();
	}

	public classsException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public classsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public classsException(String arg0) {
		super(arg0);
	}

	public classsException(Throwable arg0) {
		super(arg0);
	}

}
