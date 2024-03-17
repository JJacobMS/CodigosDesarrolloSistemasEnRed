namespace AppConHilosATM;
class Program
{
    static int accountBalance = 1000; 
    static Random random = new Random();
    static void PerformTransaction(object? threadId)
    {
        for (int i = 0; i < 5; i++)
        {
            int amountToWithdraw = random.Next(10,101);
            Thread.Sleep(1000);
            lock(typeof(Program))
            {
                if(accountBalance >= amountToWithdraw)
                {
                    accountBalance -= amountToWithdraw;
                    Console.WriteLine($"Thread {threadId}: Se retiraron ${amountToWithdraw} pesos. Quedan ${accountBalance} pesos");
                }
                else
                {
                    Console.WriteLine($"Thread {threadId}: Fondos insuficientes. Se requieren: ${amountToWithdraw} pesos.");
                }
            }
        }
    }
    static void Main(string[] args)
    {
        Console.WriteLine("Bienvenido al cajero automatico");
        Console.WriteLine($"Cuentas con {accountBalance} pesos");
        Console.WriteLine("Presione Enter para iniciar transacciones...");
        Console.ReadLine();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.Length; i++)
        {
            threads[i] = new Thread(PerformTransaction);
            threads[i].Start(i+1);
        }
        foreach (Thread thread in threads)
        {
            thread.Join();
        }
        Console.WriteLine("Todas las transacciones completas");
        Console.WriteLine($"Saldo final de la cuenta ${accountBalance} pesos");
    }   
}