package br.com.bitwaysystem;

/**
 * Created by fsantiago on 09/02/14.
 */
public class CookieBean {

    public int index;
    public String cookieMessage;

    public CookieBean() {
    }

    public CookieBean(int index, String cookieMessage) {
        this.index = index;
        this.cookieMessage = cookieMessage;
    }

    public CookieBean(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCookieMessage() {
        return cookieMessage;
    }

    public void setCookieMessage(String cookieMessage) {
        this.cookieMessage = cookieMessage;
    }
}
