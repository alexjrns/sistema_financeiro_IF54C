/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Alex
 */
public class Utilitario {
    private static final String key = "51Lv1*";

    public Utilitario() {
	super();
    }
    
    /* Converte uma string em MD5 concatenado com a key definida */
    public static String md5(String valor){
        try {
            valor += key;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(valor.getBytes());

            return new BigInteger(1, digest.digest()).toString(16).trim();
        }catch(Exception e) {
            throw new RuntimeException("Erro ao calcular MD5 de " + valor, e);
        }
    }    
}
