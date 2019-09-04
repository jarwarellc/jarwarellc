package Tasks.Task1.models;

import java.security.InvalidAlgorithmParameterException;
import java.security.Signature;

public class Message {

    private String msg;

    public Message(){

    }

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte[] signMsg()throws InvalidAlgorithmParameterException, Exception {
        KeyGen keyGen = new KeyGen(1024);
        keyGen.createKeys();
        Signature sign = Signature.getInstance("SHA1withRSA");
        sign.initSign(keyGen.getPrivateKey());
        sign.update(msg.getBytes());
        return sign.sign();
    }
}
