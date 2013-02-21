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
package org.jinstagram.entity.common;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

public class Pagination {
    @SerializedName("deprecation_warning")
    private String depreciationWarning;

    @SerializedName("min_tag_id")
    private String minTagId;

    @SerializedName("next_max_id")
    private String nextMaxId;

    @SerializedName("next_max_tag_id")
    private String nextMaxTagId;

    @SerializedName("next_min_id")
    private String nextMinId;

    @SerializedName("next_url")
    private String nextUrl;

    /**
     * @return the nextUrl
     */
    public String getNextUrl() {
        return nextUrl;
    }

    /**
     * @param nextUrl the nextUrl to set
     */
    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    /**
     * @return the nextMaxId
     */
    public String getNextMaxId() {
        return nextMaxId;
    }

    /**
     * @param nextMaxId the nextMaxId to set
     */
    public void setNextMaxId(String nextMaxId) {
        this.nextMaxId = nextMaxId;
    }

    /**
     * @return the nextMinId
     */
    public String getNextMinId() {
        return nextMinId;
    }

    /**
     * @param nextMinId the nextMinId to set
     */
    public void setNextMinId(String nextMinId) {
        this.nextMinId = nextMinId;
    }

    /**
     * @return the minTagId
     */
    public String getMinTagId() {
        return minTagId;
    }

    /**
     * @param minTagId the minTagId to set
     */
    public void setMinTagId(String minTagId) {
        this.minTagId = minTagId;
    }

    /**
     * @return the nextMaxTagId
     */
    public String getNextMaxTagId() {
        return nextMaxTagId;
    }

    /**
     * @param nextMaxTagId the nextMaxTagId to set
     */
    public void setNextMaxTagId(String nextMaxTagId) {
        this.nextMaxTagId = nextMaxTagId;
    }

    /**
     * @return the depreciationWarning
     */
    public String getDepreciationWarning() {
        return depreciationWarning;
    }

    public boolean hasNextPage() {
        return !StringUtils.isBlank(nextUrl);
    }

    /**
     * @param depreciationWarning the depreciationWarning to set
     */
    public void setDepreciationWarning(String depreciationWarning) {
        this.depreciationWarning = depreciationWarning;
    }

    @Override
    public String toString() {
        return String.format("Pagination [depreciationWarning=%s, minTagId=%s, nextMaxId=%s, nextMaxTagId=%s, nextMinId=%s, nextUrl=%s]",
                        depreciationWarning, minTagId, nextMaxId, nextMaxTagId, nextMinId, nextUrl);
    }
}
