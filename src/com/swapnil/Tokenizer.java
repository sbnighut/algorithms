package com.swapnil;

import java.io.*;
import java.util.*;

public class Tokenizer {
    String tokenString;
    public Tokenizer(String s){
        this.tokenString = s;
    }

    public void GenTokens(){
        String s = tokenString;
        List<String> tokens = new LinkedList<String>();
        String token = "";
        for(int j=0;j<s.length();j++){
            char ch = Character.toUpperCase(s.charAt(j)) ;
            int i = (int)(ch) - 65;
            if(i > -1 && i<26){
                token = token + ch;
                continue;
            }
            else if (token != ""){
                tokens.add(token);
                token = "";
            }
        }

        if (token != "")
            tokens.add(token);

        System.out.println(tokens.size());
        for(String t : tokens){
            System.out.println(t);
        }

    }
}
