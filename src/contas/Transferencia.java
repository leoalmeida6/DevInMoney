package contas;

public class Transferencia extends Transacao {

    private String nomeContaOrigem;
    private String cpfContaOrigem;

    private String nomeContaDestino;
    private String cpfContaDestino;

    public String getNomeContaOrigem() {
        return nomeContaOrigem;
    }

    public void setNomeContaOrigem(String nomeContaOrigem) {
        this.nomeContaOrigem = nomeContaOrigem;
    }

    public String getCpfContaOrigem() {
        return cpfContaOrigem;
    }

    public void setCpfContaOrigem(String cpfContaOrigem) {
        this.cpfContaOrigem = cpfContaOrigem;
    }

    public String getNomeContaDestino() {
        return nomeContaDestino;
    }

    public void setNomeContaDestino(String nomeContaDestino) {
        this.nomeContaDestino = nomeContaDestino;
    }

    public String getCpfContaDestino() {
        return cpfContaDestino;
    }

    public void setCpfContaDestino(String cpfContaDestino) {
        this.cpfContaDestino = cpfContaDestino;
    }
}
