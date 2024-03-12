﻿namespace AppConHilos3;
class Program
{
    static void Main(string[] args)
    {
        int workers, ports;
        ThreadPool.GetMaxThreads(out workers,out ports);
        Console.WriteLine("Maximos hilos trabajando: "+workers);
        Console.WriteLine("Maximos puertos para hilos: "+ports);
        ThreadPool.GetMinThreads(out workers,out ports);
        Console.WriteLine("Minimos hilos trabajando: "+workers);
        Console.WriteLine("Minimos puertos (completion port) para hilos: "+ports);
        ThreadPool.GetAvailableThreads(out workers,out ports);
        Console.WriteLine("Hilos de trabajo disponibles: "+workers);
        Console.WriteLine("Hilos de puerto (completion port) disponibles: "+ports);
        int processCount = Environment.ProcessorCount;
        Console.WriteLine($"No. de procesadores disponibles en el sistema: {processCount}");
        Console.WriteLine($"---------------------------------");
        ThreadPool.QueueUserWorkItem(TareaDeFondo);
        ThreadPool.GetAvailableThreads(out workers, out ports);
        Console.WriteLine($"Hilos de trabajo disponibles después del hilo 1: {workers} ");
        Persona p = new Persona("Guillermo Vera", 44, "Hombre");
        ThreadPool.QueueUserWorkItem(TareaDeFondoConParametro, p);
        ThreadPool.GetAvailableThreads(out workers, out ports);
        Console.WriteLine($"Hilos de trabajo disponibles después del hilo 2: {workers} ");
        Thread.Sleep(2000);
        ThreadPool.GetAvailableThreads(out workers, out ports);
        Console.WriteLine($"Hilos de trabajo disponibles al final: {workers} ");
        Console.ReadKey();
    }
    static void TareaDeFondo(Object? stateInfo){
        Console.WriteLine("Hilo 1: Hola soy un hilo sin uso parametros desde ThreadPool");
        Thread.Sleep(1000);
    }
    static void TareaDeFondoConParametro(Object? stateInfo){
        if(stateInfo==null)
            return;
        Persona data = (Persona)stateInfo;
        Console.WriteLine($"Hilo 2 {data.Nombre}, tu edad es de {data.Edad}");
        Thread.Sleep(500);
    }
}

public class Persona{
    public string Nombre {get;set;}
    public int Edad {get;set;}
    public string Sexo {get;set;}
    public Persona(string nombre, int edad, string sexo){
        this.Nombre = nombre;
        this.Edad = edad;
        this.Sexo = sexo;
    }
}