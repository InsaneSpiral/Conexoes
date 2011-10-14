import java.util.LinkedList;

public abstract class Conexao {

	private LinkedList<Conexao> conexoes = new LinkedList<Conexao>();
	private Pergunta pergunta;
	private boolean conexaoFinal;
	
	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public LinkedList<Conexao> getConexoes() {
		return conexoes;
	}

	public boolean isConexaoFinal() {
		return conexaoFinal;
	}

	public void setConexaoFinal(boolean conexaoFinal) {
		this.conexaoFinal = conexaoFinal;
	}

	public abstract Conexao questionar();
}