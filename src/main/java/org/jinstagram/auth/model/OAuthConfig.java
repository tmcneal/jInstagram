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
package org.jinstagram.auth.model;

public class OAuthConfig {
    private final String apiKey;

    private final String apiSecret;

    private final String callback;

    private final String display;

    private final String scope;

    public OAuthConfig(String key, String secret) {
        this(key, secret, null, null);
    }

    public OAuthConfig(String key, String secret, String callback, String scope) {
        this(key, secret, callback, scope, null);
    }

    public OAuthConfig(String key, String secret, String callback, String scope, String display) {
        this.apiKey = key;
        this.apiSecret = secret;
        this.callback = (callback != null) ? callback : OAuthConstants.OUT_OF_BAND;
        this.scope = scope;
        this.display = display;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public String getCallback() {
        return callback;
    }

    public String getScope() {
        return scope;
    }

    public boolean hasScope() {
        return scope != null;
    }

    public String getDisplay() {
        return display;
    }
}
