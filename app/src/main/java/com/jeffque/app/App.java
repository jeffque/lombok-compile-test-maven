package com.jeffque.app;

import com.jeffque.obj.Obj;

public class App {
    public static void main( String[] args ) {
        final var umaCoisa = new Obj("nome", "etc");
        System.out.println(umaCoisa.getNome());
        System.out.println(umaCoisa.getEtc());
    }
}
