package com.example.task14;

public class CardEntity {
    private int cardNumber;
    private int code;

    public CardEntity(int cardNumber, int code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
