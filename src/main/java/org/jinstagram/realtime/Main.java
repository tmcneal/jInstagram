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

import org.jinstagram.exceptions.InstagramException;

public class Main {
    public static void main(String[] args) throws InstagramException {
        
        String clientId = "e27d086b16f94a318b1c15b83a12f09c";
        String clientSecret = "87299d31e637428bb0f78740661c554d";
         
        String callbackUrl = "http://jinstagram.appspot.com/sub-redirect";
        
        InstagramSubscription sub = new InstagramSubscription()
        .clientId(clientId)
        .clientSecret(clientSecret)
        .object(SubscriptionType.USERS)
        .callback(callbackUrl)
        .verifyToken("sampleService");
        
        
         sub.getSubscriptionList();
        /*
         
        SubscriptionResponse response = sub.createSubscription();
        
        System.out.println("Code : " + response.getMeta().getCode());
        System.out.println("\t Data " );
        System.out.println("\t\t Object  : " + response.getData().getObject() );
        System.out.println("\t\t object_id :  " + response.getData().getObjectId() );
        System.out.println("\t\t aspect :  " + response.getData().getAspect() );
        System.out.println("\t\t callback_url :  " + response.getData().getCallbackUrl() );
        System.out.println("\t\t type :  " + response.getData().getType() );
        System.out.println("\t\t id :  " + response.getData().getId() );
        */
         
        
    }
}
