public class Cliente {

    private String clienteId;
    private String nome;

    // Construtor para criar um novo cliente
    public Cliente(String clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;

        // Adiciona uma nova conta para o cliente no AccountManager
        AccountManager.getInstance().addAccount(clienteId);
    }

    // Método para realizar depósito usando o AccountManager
    public void depositar(double valor) {
        AccountManager.getInstance().depositar(clienteId, valor);
    }

    // Método para realizar saque usando o AccountManager
    public void sacar(double valor) {
        AccountManager.getInstance().sacar(clienteId, valor);
    }

    // Método para verificar o saldo da conta do cliente
    public void verSaldo() {
        double saldo = AccountManager.getInstance().verSaldo(clienteId);
        System.out.println("Saldo da conta " + clienteId + ": R$" + saldo);
    }
}
