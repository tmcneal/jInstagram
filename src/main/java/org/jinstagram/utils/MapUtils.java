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
package org.jinstagram.utils;

import org.jinstagram.http.URLUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Utils for {@link Map} manipulation
 */
public class MapUtils {

    /**
     * Sorts a Map
     *
     * @param map unsorted map
     * @return sorted map
     */
    public static final Map<String, String> sort(Map<String, String> map) {
        Preconditions.checkNotNull(map, "Cannot sort a null object.");

        Map<String, String> sorted = new LinkedHashMap<String, String>();

        for (String key : getSortedKeys(map)) {
            sorted.put(key, map.get(key));
        }

        return sorted;
    }

    private static List<String> getSortedKeys(Map<String, String> map) {
        List<String> keys = new ArrayList<String>(map.keySet());

        Collections.sort(keys);

        return keys;
    }

    /**
     * Form-urlDecodes and appends all keys from the source {@link Map} to the
     * target {@link Map}
     *
     * @param source Map from where the keys get copied and decoded
     * @param target Map where the decoded keys are copied to
     */
    public static void decodeAndAppendEntries(Map<String, String> source,
            Map<String, String> target) {
        for (Entry<String, String> entry : source.entrySet()) {
            target.put(URLUtils.percentEncode(entry.getKey()),
                    URLUtils.percentEncode(entry.getValue()));
        }
    }
}
