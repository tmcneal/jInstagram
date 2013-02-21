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
package org.jinstagram.http;

import org.jinstagram.utils.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Utils to deal with Streams.
 */
public class StreamUtils {

    /**
     * Returns the stream contents as an UTF-8 encoded string
     * 
     * @param is input stream
     * @return string contents
     */
    public static String getStreamContents(InputStream is) {
        Preconditions.checkNotNull(is, "Cannot get String from a null object");

        try {
            final char[] buffer = new char[0x10000];
            StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(is, "UTF-8");
            int read;

            do {
                read = in.read(buffer, 0, buffer.length);

                if (read > 0) {
                    out.append(buffer, 0, read);
                }
            } while (read >= 0);

            in.close();

            return out.toString();
        }
        catch (IOException ioe) {
            throw new IllegalStateException(
                    "Error while reading response body", ioe);
        }
    }
}
