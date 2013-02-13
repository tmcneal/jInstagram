package org.jinstagram.exceptions;

public class InstagramServiceException extends InstagramException {
	private static final long serialVersionUID = 1L;
    private final int code;

	/**
	 * Default constructor.
	 *
	 * @param message message explaining what went wrong
     * @param code status code from request to Instagram
	 */
	public InstagramServiceException(String message, int code) {
		super(message, null);
        this.code = code;
	}

    /**
     * Constructor for backwards compatability.
     *
     * @param message message explaining what went wrong
     * @param e original exception
     * @param code status code from request to Instagram
     */
    public InstagramServiceException(String message, Exception e, int code) {
        super(message, e);
        this.code = code;
    }

    /**
     * Get status code from request to Instagram.
     *
     * @return status code from request to Instagram
     */
    public int getCode() {
        return code;
    }
}
