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
package org.jinstagram.model;

public enum Scope {

    /**
     * A field to denote the scope 'basic'
     *
     * basic - Be able to read all data related to a user: Following/Followed-By
     * Lists, Photos, etc. (granted by default)
     */
    BASIC,

    /**
     * A field to denote the scope 'comments'
     *
     * comments - Be able to create or delete comments on a user's behalf
     */
    COMMENTS,

    /**
     * A field to denote the scope 'likes'
     *
     * likes - Be able to like and unlike items on a user's behalf
     */
    LIKES,

    /**
     * A field to denote the scope 'relationships'
     *
     * relationships - Be able to follow and unfollow users on a user's behalf
     */
    RELATIONSHIPS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
