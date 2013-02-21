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
package org.jinstagram.entity.relationships;

import com.google.gson.annotations.SerializedName;

public class RelationshipData {
    @SerializedName("incoming_status")
    private String incomingStatus;

    @SerializedName("outgoing_status")
    private String outgoingStatus;

    /**
     * @return the outgoingStatus
     */
    public String getOutgoingStatus() {
        return outgoingStatus;
    }

    /**
     * @param outgoingStatus the outgoingStatus to set
     */
    public void setOutgoingStatus(String outgoingStatus) {
        this.outgoingStatus = outgoingStatus;
    }

    /**
     * @return the incomingStatus
     */
    public String getIncomingStatus() {
        return incomingStatus;
    }

    /**
     * @param incomingStatus the incomingStatus to set
     */
    public void setIncomingStatus(String incomingStatus) {
        this.incomingStatus = incomingStatus;
    }

    @Override
    public String toString() {
        return String.format("RelationshipData [incomingStatus=%s, outgoingStatus=%s]", incomingStatus, outgoingStatus);
    }
}
