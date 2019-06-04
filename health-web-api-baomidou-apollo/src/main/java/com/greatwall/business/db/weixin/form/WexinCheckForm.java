/**
 * Created by NieQing on 2017/2/18.
 */

package com.greatwall.business.db.weixin.form;



public class WexinCheckForm {
    
    String signature;
    String timestamp;
    String nonce;
    String echostr;
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }


}
