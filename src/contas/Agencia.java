package contas;

public enum Agencia {

    FLORIANOPOLIS("FLORIANOPOLIS"),
    SAO_JOSE("SAO JOSE");

    private final String descricao;

    Agencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
