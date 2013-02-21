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
package org.jinstagram.auth;

import org.jinstagram.auth.model.OAuthConfig;
import org.jinstagram.auth.model.OAuthConstants;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.auth.oauth.OAuthService;
import org.jinstagram.utils.Preconditions;

public class InstagramAuthService {
    private String apiKey;

    private String apiSecret;

    private String callback;

    private String display;

    private String scope;

    /**
     * Default constructor
     */
    public InstagramAuthService() {
        this.callback = OAuthConstants.OUT_OF_BAND;
    }

    /**
     * Adds an OAuth callback url
     * 
     * @param callback callback url. Must be a valid url or 'oob' for out of
     * band OAuth
     * @return the {@link InstagramAuthService} instance for method chaining
     */
    public InstagramAuthService callback(String callback) {
        Preconditions.checkValidOAuthCallback(callback,
                "Callback must be a valid URL or 'oob'");

        this.callback = callback;

        return this;
    }

    /**
     * Configures the api key
     * 
     * @param apiKey The api key for your application
     * @return the {@link InstagramAuthService} instance for method chaining
     */
    public InstagramAuthService apiKey(String apiKey) {
        Preconditions.checkEmptyString(apiKey, "Invalid Api key");

        this.apiKey = apiKey;

        return this;
    }

    /**
     * Configures the api secret
     * 
     * @param apiSecret The api secret for your application
     * @return the {@link InstagramAuthService} instance for method chaining
     */
    public InstagramAuthService apiSecret(String apiSecret) {
        Preconditions.checkEmptyString(apiSecret, "Invalid Api secret");

        this.apiSecret = apiSecret;

        return this;
    }

    /**
     * Configures the OAuth scope. This is only necessary in some APIs (like
     * Google's).
     * 
     * @param scope The OAuth scope
     * @return the {@link InstagramAuthService} instance for method chaining
     */
    public InstagramAuthService scope(String scope) {
        Preconditions.checkEmptyString(scope, "Invalid OAuth scope");

        this.scope = scope;

        return this;
    }

    /**
     * Configures the Display parameter ; if you want a mobile-optimized
     * authorization screen
     * 
     * @param display The Display parameter for mobile devices
     * @return the {@link InstagramAuthService} instance for method chaining
     */
    public InstagramAuthService display(String display) {
        Preconditions.checkEmptyString(display, "Invalid Display scope");

        this.display = display;

        return this;
    }

    /**
     * Returns the fully configured {@link OAuthService}
     * 
     * @return fully configured {@link OAuthService}
     */
    public InstagramService build() {
        InstagramApi api = new InstagramApi();

        Preconditions.checkEmptyString(apiKey, "You must provide an api key");
        Preconditions.checkEmptyString(apiSecret,
                "You must provide an api secret");

        return api.createService(new OAuthConfig(apiKey, apiSecret, callback,
                scope, display));
    }
}
