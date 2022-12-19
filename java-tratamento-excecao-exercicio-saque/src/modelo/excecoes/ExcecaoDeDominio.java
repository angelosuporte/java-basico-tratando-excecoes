package modelo.excecoes;

public class ExcecaoDeDominio extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoDeDominio(String mensagem) {
		super(mensagem);
	}
}
