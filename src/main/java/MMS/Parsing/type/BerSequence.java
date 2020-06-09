/*  BerSet.java
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

import MMS.Parsing.type.base.BerConstruct;
import sample.core.core.parse.Tag;

/**
 * A sequence is an ordered collection of objects in a Ber object
 */
public class BerSequence extends BerConstruct {

    /**
     * Construct a new BerSequence with the default set type
     */
    public BerSequence() {
        super(Tag.SEQUENCE);
    }

//    /**
//     * Construt a new BerSequence from the input stream
//     * @param tag The tag used to define this element
//     * @param state The current read-state we're in
//     * @param parser The parser that is being used to parse this ASN.1 stream
//     * @param stream The ASN.1 stream being parsed
//     * @throws IOException
//     */
//    public BerSequence(int tag, int state, BerParser parser, BerInputStream stream) throws IOException
//    {
//        super(tag, state, parser, stream);
//    }

    public String getAsn1TypeDesc() {
        return "BerSequence";
    }

}
