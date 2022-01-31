package contas;

import java.util.Date;


public class Transacao {

    private Double valor;
    private Date dataTransacao;
    private TipoTransacao tipoTransacao;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "valor=" + valor +
                ", dataTransacao=" + dataTransacao +
                ", tipoTransacao=" + tipoTransacao +
                '}';
    }
}
