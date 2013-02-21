/**
 * Copyright (C) 2011 by Sachin Handiekar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
