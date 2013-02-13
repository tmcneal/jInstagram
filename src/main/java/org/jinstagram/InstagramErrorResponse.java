package org.jinstagram;

import org.jinstagram.exceptions.InstagramBadRequestException;
import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.exceptions.InstagramRateLimitException;

import com.google.gson.annotations.SerializedName;
import org.jinstagram.exceptions.InstagramServiceException;

public class InstagramErrorResponse {
    public static final int INSTAGRAM_BAD_REQUEST = 400;
    public static final int INSTAGRAM_RATE_LIMIT = 420;

    private int code;

    @SerializedName("error_type")
    private String errorType;

    @SerializedName("error_message")
    private String errorMessage;

    public void throwException() throws InstagramException {
        String joinedMessage = errorType + ": " + errorMessage;
        switch (code) {
        case INSTAGRAM_BAD_REQUEST:
            throw new InstagramBadRequestException(joinedMessage);
        case INSTAGRAM_RATE_LIMIT:
            throw new InstagramRateLimitException(joinedMessage);
        }

        throw new InstagramServiceException(joinedMessage, code);
    }
}
