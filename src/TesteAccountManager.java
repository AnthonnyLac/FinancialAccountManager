public class TesteAccountManager {

    public static void executarTestes(){

        // Criação de clientes
        Cliente cliente1 = new Cliente("1001", "Alice");
        Cliente cliente2 = new Cliente("1002", "Bob");

        // Operações bancárias
        cliente1.depositar(1000);
        cliente1.verSaldo();

        cliente2.depositar(500);
        cliente2.verSaldo();

        cliente1.sacar(200);
        cliente1.verSaldo();

        cliente2.sacar(700); // Deve mostrar erro de saldo insuficiente
        cliente2.verSaldo();

        // Verificar que todos compartilham a mesma instância do AccountManager
        AccountManager.getInstance().listarContasAtivas();

        // Verificar se uma nova instância alteraria o saldo das contas
        AccountManager novoGerenciador = AccountManager.getInstance();
        novoGerenciador.listarContasAtivas(); // Deve mostrar as mesmas contas e saldos
    }
}
