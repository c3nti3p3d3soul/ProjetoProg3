package Modelos;

public class ConfirmacaoCompra {
	
	private int idConfirmacao;
    private int idUsuario;
    private int idProduto;
    private int quantidade;
    private Double valorTotal;
    private String metodoPagamento;
    
    
	public int getIdConfirmacao() {
		return idConfirmacao;
	}
	public void setIdConfirmacao(int idConfirmacao) {
		this.idConfirmacao = idConfirmacao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

}
