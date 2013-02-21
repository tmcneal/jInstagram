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
