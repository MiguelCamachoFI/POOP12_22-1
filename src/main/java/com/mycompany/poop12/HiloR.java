/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poop12;

/**
 *
 * @author migue
 */
public class HiloR implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            System.out.println("Iteración "+i+" del "+Thread.currentThread().getName());
        }
        System.out.println("Termina el "+Thread.currentThread().getName());
    }
    
}
