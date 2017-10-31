/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
enum EnumConst {
    MIN_PORT_NETWORK(0),
    MAX_PORT_NETWORK(65535);
    
    private int value;

    private EnumConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    
}
