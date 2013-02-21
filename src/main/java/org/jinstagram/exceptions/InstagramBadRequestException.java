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
package org.jinstagram.exceptions;

import org.jinstagram.InstagramErrorResponse;

public class InstagramBadRequestException extends InstagramServiceException {
    private static final long serialVersionUID = 1L;

    /**
     * No-exception constructor. Used when there is no original exception
     *
     * @param message message explaining what went wrong
     */
    public InstagramBadRequestException(String message) {
        super(message, null, InstagramErrorResponse.INSTAGRAM_BAD_REQUEST);
    }

    /**
     * Default constructor
     *
     * @param message message explaining what went wrong
     * @param e original exception
     */
    public InstagramBadRequestException(String message, Exception e) {
        super(message, e, InstagramErrorResponse.INSTAGRAM_BAD_REQUEST);
    }
}
