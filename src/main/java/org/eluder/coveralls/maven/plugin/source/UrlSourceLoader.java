/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 - 2023, Tapio Rautonen
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
package org.eluder.coveralls.maven.plugin.source;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eluder.coveralls.maven.plugin.util.UrlUtils;

public class UrlSourceLoader extends AbstractSourceLoader {

    private final URL sourceUrl;

    public UrlSourceLoader(final URL base, final URL sourceUrl, final String sourceEncoding) {
        super(UrlUtils.toUri(base), UrlUtils.toUri(sourceUrl), sourceEncoding);
        this.sourceUrl = sourceUrl;
    }
    
    @Override
    protected InputStream locate(final String sourceFile) throws IOException {
        URL url = new URL(sourceUrl, sourceFile);
        // Checkstyle OFF: EmptyBlock
        try {
            return url.openStream();
        } catch (IOException ex) {
            // not found from url
        }
        // Checkstyle ON: EmptyBlock
        return null;
    }
}
