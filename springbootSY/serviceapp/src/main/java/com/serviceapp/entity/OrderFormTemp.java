package com.serviceapp.entity;



import java.io.Serializable;

/**
 * (OrderFormTemp)实体类
 *
 * @author makejava
 * @since 2022-03-30 14:56:25
 */

public class OrderFormTemp extends BaseOrderForm implements Serializable {
    private static final long serialVersionUID = -58249184566576940L;

    public String getOpIdentifier() {
        return opIdentifier;
    }

    /**
     * 操作批次标识
     */
    private String opIdentifier;
    public void setOpIdentifier(String opIdentifier) {
        this.opIdentifier = opIdentifier;
    }

}

