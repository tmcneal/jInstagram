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

import com.google.gson.annotations.SerializedName;

public class SubscriptionResponseData {

    @SerializedName("object")
    private String object;

    @SerializedName("objectId")
    private long objectId;

    @SerializedName("aspect")
    private String aspect;

    @SerializedName("callbackUrl")
    private String callbackUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private long id;

    /**
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * @return the objectId
     */
    public long getObjectId() {
        return objectId;
    }

    /**
     * @param objectId the objectId to set
     */
    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    /**
     * @return the aspect
     */
    public String getAspect() {
        return aspect;
    }

    /**
     * @param aspect the aspect to set
     */
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    /**
     * @return the callbackUrl
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * @param callbackUrl the callbackUrl to set
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
