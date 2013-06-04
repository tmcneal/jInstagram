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
package org.jinstagram.realtime;

import java.io.IOException;

import org.jinstagram.auth.model.OAuthConstants;
import org.jinstagram.auth.model.OAuthRequest;
import org.jinstagram.exceptions.InstagramException;
import org.jinstagram.http.Response;
import org.jinstagram.http.Verbs;
import org.jinstagram.utils.Preconditions;

import com.google.gson.Gson;

public class InstagramSubscription {
    private String aspect;

    private String callback;

    private String clientId;

    private String clientSecret;

    private SubscriptionType subscriptionType;
    
    private String objectId;

    private String verifyToken;

    /**
     * Default constructor
     */
    public InstagramSubscription() {
        this.callback = OAuthConstants.OUT_OF_BAND;
    }

    /**
     * Configures the callback url
     *
     * @param callback The callback for your application
     * @return the {@link InstagramSubscription} instance for method chaining
     */
    public InstagramSubscription callback(String callback) {
        Preconditions.checkValidUrl(callback, "Invalid Callback Url");

        this.callback = callback;

        return this;
    }

    /**
     * Configures the clientId
     *
     * @param clientId The clientId for your application
     * @return the {@link InstagramSubscription} instance for method chaining
     */
    public InstagramSubscription clientId(String clientId) {
        Preconditions.checkEmptyString(clientId, "Invalid 'clientId' key");

        this.clientId = clientId;

        return this;
    }

    public InstagramSubscription clientSecret(String clientSecret) {
        Preconditions.checkEmptyString(clientSecret, "Invalid 'clientSecret' key");

        this.clientSecret = clientSecret;

        return this;
    }

    public InstagramSubscription object(SubscriptionType type) {

        this.subscriptionType = type;

        return this;
    }
    
    public InstagramSubscription objectId(String objectId) {
        
        this.objectId = objectId;
        
        return this;
    }

    public InstagramSubscription verifyToken(String verifyToken) {
        Preconditions.checkEmptyString(verifyToken, "Invalid 'verifyToken' key");

        this.verifyToken = verifyToken;

        return this;
    }

    public InstagramSubscription aspect(String aspect) {
        Preconditions.checkEmptyString(aspect, "Invalid 'aspect' key");

        this.aspect = aspect;

        return this;
    }

    public SubscriptionResponse createSubscription() throws InstagramException {

        Preconditions.checkEmptyString(clientId, "You must provide a clientId key");
        Preconditions.checkEmptyString(clientSecret, "You must provide a clientSecret");
        Preconditions.checkEmptyString(clientSecret, "You must provide a clientSecret");

        OAuthRequest request = new OAuthRequest(Verbs.POST, Constants.SUBSCRIPTION_ENDPOINT);

        // Add the oauth parameter in the body
        request.addBodyParameter(Constants.CLIENT_ID, this.clientId);
        request.addBodyParameter(Constants.CLIENT_SECRET, this.clientSecret);
        request.addBodyParameter(Constants.SUBSCRIPTION_TYPE, subscriptionType.toString());
        request.addBodyParameter(Constants.ASPECT, "media");
        request.addBodyParameter(Constants.VERIFY_TOKEN, this.verifyToken);
        request.addBodyParameter(Constants.CALLBACK_URL, callback);
        request.addBodyParameter(Constants.OBJECT_ID, objectId);

        Response response;
        try {
            response = request.send();
        } catch (IOException e) {
            throw new InstagramException("Failed to create subscription", e);
        }

        SubscriptionResponse subscriptionResponse = getSubscriptionResponse(response.getBody());
        return subscriptionResponse;

    }

      private SubscriptionResponse getSubscriptionResponse(String jsonBody) throws InstagramException {
            Gson gson = new Gson();
            SubscriptionResponse response = null;

            try {
                response = gson.fromJson(jsonBody, SubscriptionResponse.class);
            } catch (Exception e) {
                throw new InstagramException("Error parsing json to object type ");
            }

            return response;
        }



    public SubscriptionResponse deleteAllSubscription() throws InstagramException {

        OAuthRequest request = new OAuthRequest(Verbs.DELETE, Constants.SUBSCRIPTION_ENDPOINT);

        // Add the oauth parameter in the body
        request.addQuerystringParameter(Constants.CLIENT_ID, this.clientId);
        request.addQuerystringParameter(Constants.CLIENT_SECRET, this.clientSecret);
        request.addQuerystringParameter("object", "all");

        Response response;
        try {
            response = request.send();
            SubscriptionResponse subscriptionResponse = getSubscriptionResponse(response.getBody());
            return subscriptionResponse;
        } catch (IOException e) {
            throw new InstagramException("Failed to delete all subscriptions", e);
        }
    }
    
    public SubscriptionResponse deleteSubscription(String subscriptionId) throws InstagramException {

        OAuthRequest request = new OAuthRequest(Verbs.DELETE, Constants.SUBSCRIPTION_ENDPOINT);

        // Add the oauth parameter in the body
        request.addQuerystringParameter(Constants.CLIENT_ID, this.clientId);
        request.addQuerystringParameter(Constants.CLIENT_SECRET, this.clientSecret);
        request.addQuerystringParameter("id", subscriptionId);

        Response response;
        try {
            response = request.send();
        } catch (IOException e) {
            throw new InstagramException("Failed to delete subscription ID: " + subscriptionId, e);
        }

        SubscriptionResponse subscriptionResponse = getSubscriptionResponse(response.getBody());
        return subscriptionResponse;
    }

    public void getSubscriptionList() throws InstagramException {
        OAuthRequest request = new OAuthRequest(Verbs.GET, Constants.SUBSCRIPTION_ENDPOINT);

        // Add the oauth parameter in the body
        request.addQuerystringParameter(Constants.CLIENT_ID, this.clientId);
        request.addQuerystringParameter(Constants.CLIENT_SECRET, this.clientSecret);

        Response response;
        try {
            response = request.send();
            System.out.println(response.getBody());
        } catch (IOException e) {
            throw new InstagramException("Failed to get subscription list", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InstagramSubscription [");
        if (aspect != null)
            builder.append("aspect=").append(aspect).append(", ");
        if (callback != null)
            builder.append("callback=").append(callback).append(", ");
        if (clientId != null)
            builder.append("clientId=").append(clientId).append(", ");
        if (clientSecret != null)
            builder.append("clientSecret=").append(clientSecret).append(", ");
        if (subscriptionType != null)
            builder.append("subscriptionType=").append(subscriptionType).append(", ");
        if (verifyToken != null)
            builder.append("verifyToken=").append(verifyToken);
        builder.append("]");
        return builder.toString();
    }
}
