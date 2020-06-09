/*  BerUTCTime.java
 *
 *  Created on Jun 4, 2006 by William Edward Woody
 */
/*
 * Copyright 2007 William Woody, All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list 
 * of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this 
 * list of conditions and the following disclaimer in the documentation and/or other 
 * materials provided with the distribution.
 * 
 * 3. Neither the name of Chaos In Motion nor the names of its contributors may be used 
 * to endorse or promote products derived from this software without specific prior 
 * written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGE.
 * 
 * Contact William Woody at woody@alumni.caltech.edu or at woody@chaosinmotion.com. 
 * Chaos In Motion is at http://www.chaosinmotion.com
 */

package MMS.Parsing.type;

import MMS.Parsing.type.base.BerNode;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.util.BytesUtil;
import sample.core.core.parse.AsnEncodingException;
import sample.core.core.parse.BerInputStream;
import sample.core.core.parse.Tag;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Represents a UTC time object.
 */
public class BerUTCTime extends BerNode {
    private static SimpleDateFormat _gFormat;
    private Date _fValue;
    //add by hxzon
    private String _origValue;

//    /**
//     * Construct a boolean from the input stream
//     * @param tag
//     * @param stream
//     * @throws IOException
//     */
//    public BerUTCTime(int tag, BerInputStream stream) throws IOException
//    {
//        super(tag);
//        
//        fDate = parseDate(new String(stream.readOctetString(0 == (tag & Tag.CONSTRUCTED)),"UTF-8"));
//    }
    public BerUTCTime() {
        super(Tag.UTCTIME);
    }

    /**
     * Write the BER element to the stream
     * @param stream
     * @throws IOException
     * @see BerNode#writeElement(org.hxzon.asn1.core.parse.BerOutputStream)
     */
    public void writeElement(BerOutputStream stream) throws IOException {
        String date = formatDate(_fValue);

        byte[] b = date.getBytes("UTF-8");
        stream.writeBerTag(getTag() | (stream.isComplexOctetString(b.length) ? Tag.CONSTRUCTED : 0));
        stream.writeOctetString(b, 0, b.length);
    }

    public Date getValue() {
        return _fValue;
    }

    private static void initFormat() {
        if (_gFormat == null) {
            _gFormat = new SimpleDateFormat("yyMMddHHmmss");
            _gFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    private static String formatDate(Date date) {
        initFormat();

        synchronized (_gFormat) {
            return _gFormat.format(date) + "Z";
        }
    }

    private static Date parseDate(String date) throws AsnEncodingException {
        initFormat();

        synchronized (_gFormat) {
            if (date.endsWith("Z")) {
                date = date.substring(0, date.length() - 1);
            }
            try {
                return _gFormat.parse(date);
            } catch (ParseException e) {
                throw new AsnEncodingException("Illegal formatted date read from input stream");
            }
        }
    }

    public String getAsn1TypeDesc() {
        return "BerUTCTime";
    }

    //add by hxzon
    protected void readValue(BerInputStream stream) {
        try {
            _origValue = BytesUtil.toUTF8String(stream.readOctetString(0 == (getTag() & Tag.CONSTRUCTED)));
            _fValue = parseDate(_origValue);
            super.setOffsetAndLen(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add by hxzon
    public String getValueAsString() {
        return formatDate(getValue());
    }
}
