package hello;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 4376430489656417039L;

	private String errCode;
	
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(String errCode, String message) {
		super(message);
		this.setErrCode(errCode);
	}
	public MyException(String errCode, String message, Throwable cause) {
		super(message, cause);
		this.setErrCode(errCode);
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	
}
