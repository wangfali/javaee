package briup.common.exception;

public class StudentServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StudentServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public StudentServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public StudentServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
	public StudentServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

}
