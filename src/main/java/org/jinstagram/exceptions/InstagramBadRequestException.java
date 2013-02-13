package org.jinstagram.exceptions;

public class InstagramBadRequestException extends InstagramServiceException {
	private static final long serialVersionUID = 1L;

	/**
	 * No-exception constructor. Used when there is no original exception
	 *
	 * @param message message explaining what went wrong
	 */
	public InstagramBadRequestException(String message) {
		super(message, null, 400);
	}

	/**
	 * Default constructor
	 *
	 * @param message message explaining what went wrong
	 * @param e original exception
	 */
	public InstagramBadRequestException(String message, Exception e) {
		super(message, e, 400);
	}
}
