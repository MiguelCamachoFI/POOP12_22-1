/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentaBancaria;

/**
 *
 * @author migue
 */
public class Cuenta extends Thread {
    private static double saldo;

    public Cuenta(String name) {
        super(name);
        saldo = 0;
    }

    @Override
    public void run() {
        if (getName().equals("Depósito 1") || getName().equals("Depósito 2")) {
            this.depositarDinero(100);
        } else {
            this.retirarDinero(50);
        }
        System.out.println("Termina el hilo "+getName());
    }
    
    public synchronized void depositarDinero(double monto) {
        saldo+=monto;
        System.out.println("Se depositaron "+monto+" pesos\nSaldo restante = "+saldo);
        notifyAll();
    }
    
    public synchronized void retirarDinero(double monto) {
        if (saldo<=0) {
            System.out.println(getName()+" no tiende saldo, \nsaldo = "+saldo);
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        saldo -= monto;
        System.out.println(getName()+" retiró "+monto+" pesos.\nSaldo restante "+saldo+" pesos");
        notifyAll();
    }
    
    public static void main(String[] args) {
        new Cuenta("Retiro 1").start();
        new Cuenta("Retiro 2").start();
        new Cuenta("Depósito 1").start();
        new Cuenta("Depósito 2").start();
        try {
            sleep(15000);
            System.out.println("Saldo final "+saldo);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
