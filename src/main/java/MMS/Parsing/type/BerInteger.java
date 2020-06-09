/*  BerBoolean.java
 *
 *  Created on Jun 2, 2006 by William Edward Woody
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

import MMS.Parsing.BerOutputStream;
import MMS.Parsing.type.base.BerNode;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.core.core.parse.BerInputStream;
import sample.core.core.parse.Tag;

import java.io.IOException;

/**
 * Represents an integer in the BER stream
 */
public class BerInteger extends BerNode {
    private static final Logger logger = LoggerFactory.getLogger(BerInteger.class);
    private long _fValue;

//    /**
//     * Construct a boolean from the input stream
//     * @param tag
//     * @param stream
//     * @throws IOException
//     */
//    public BerInteger(int tag, BerInputStream stream) throws IOException
//    {
//        super(tag);
//        
//        fValue = stream.readInteger();
//    }
    public BerInteger() {
        super(Tag.INTEGER);
    }

    /**
     * Write this BER element to the output stream
     * Comment
     * @param stream
     * @throws IOException
     * @see BerNode#writeElement(org.hxzon.asn1.core.parse.BerOutputStream)
     */
    public void writeElement(BerOutputStream stream) throws IOException {
        stream.writeBerTag(getTag());
        stream.writeInteger(_fValue);
    }

    /**
     * Return the value of this boolean object
     * @return
     */
    public long getValue() {
        return _fValue;
    }

    public void setValue(long value) {
        if (_unsigned && value < 0) {
            value = value + 2 ^ 64;
        }
        this._fValue = value;
    }

    public String getAsn1TypeDesc() {
        return "BerInteger";
    }

    private boolean _unsigned = false;
    private int _bitLen = 64;

    public BerInteger limitBitLength(int bitLen, boolean unsigned) {
        this._bitLen = bitLen;
        this._unsigned = unsigned;
        if (bitLen < 32) {
            logger.debug("bitLen:" + bitLen);
        }
        return this;
    }

    public BerInteger limitBitLength(int bitLen) {
        return limitBitLength(bitLen, false);
    }

    //add by hxzon
    protected void readValue(BerInputStream stream) {
        try {
            setValue(stream.readInteger());
            super.setOffsetAndLen(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add by hxzon
    public String getValueAsString() {
        return String.valueOf(getValue()) + "[len=" + _bitLen + (_unsigned ? ",unsigned]" : ",signed]");
    }
}
