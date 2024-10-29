import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    // Instância única de AccountManager (Singleton)
    private static AccountManager instance;

    // Armazena o saldo de cada conta usando um Map (chave: contaId, valor: saldo)
    private Map<String, Double> accounts;

    // Construtor privado para impedir criação de novas instâncias
    private AccountManager() {
        accounts = new HashMap<>();
    }

    // Método público para obter a única instância de AccountManager
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    // Adiciona uma nova conta com saldo inicial de 1.0
    public void addAccount(String contaId) {
        accounts.putIfAbsent(contaId, 1.0);
    }

    // Método para depositar dinheiro na conta
    public void depositar(String contaId, double valor) {
        if (valor > 0) {
            accounts.put(contaId, accounts.getOrDefault(contaId, 0.0) + valor);
            System.out.println("Depósito de R$" + valor + " realizado na conta " + contaId);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    // Método para sacar dinheiro da conta
    public void sacar(String contaId, double valor) {
        double saldoAtual = accounts.getOrDefault(contaId, 0.0);
        if (valor > 0 && saldoAtual >= valor) {
            accounts.put(contaId, saldoAtual - valor);
            System.out.println("Saque de R$" + valor + " realizado na conta " + contaId);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido!");
        }
    }

    // Método para verificar o saldo da conta
    public double verSaldo(String contaId) {
        return accounts.getOrDefault(contaId, 0.0);
    }

    // Método para listar todas as contas ativas
    public void listarContasAtivas() {
        System.out.println("Contas Ativas:");
        for (Map.Entry<String, Double> conta : accounts.entrySet()) {
            System.out.println("Conta ID: " + conta.getKey() + " - Saldo: R$" + conta.getValue());
        }
    }
}
