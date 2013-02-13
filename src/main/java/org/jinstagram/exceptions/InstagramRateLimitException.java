package org.jinstagram.exceptions;

import org.jinstagram.InstagramErrorResponse;

public class InstagramRateLimitException extends InstagramServiceException {
    private static final long serialVersionUID = 1L;

    /**
     * No-exception constructor. Used when there is no original exception
     *
     * @param message message explaining what went wrong
     */
    public InstagramRateLimitException(String message) {
        super(message, InstagramErrorResponse.INSTAGRAM_RATE_LIMIT);
    }

    /**
     * Default constructor
     *
     * @param message message explaining what went wrong
     * @param e original exception
     */
    public InstagramRateLimitException(String message, Exception e) {
        super(message, e, InstagramErrorResponse.INSTAGRAM_RATE_LIMIT);
    }
}
