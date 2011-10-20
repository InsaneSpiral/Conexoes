public class Jogador {
	
	private static String DIFICIL_RESPIRAR = "Esta dificil de respirar...";
	private static String LIMITE = "Este e o seu limite, voce esta segurando a respiracao.";

	private int oxigenio;
	private Conexao conexao;
	private Conexao conexaoAnterior;
	private int pontos;

	public Jogador(Conexao conexaoInicial) {
		this.oxigenio = 7;
		this.conexao = conexaoInicial;
		this.conexaoAnterior = conexaoInicial;
		this.pontos = 20;
	}

	public int getOxigenio() {
		return oxigenio;
	}

	public void diminuirPontos() {
		pontos -= 2;
	}

	public void diminuirOxigenio(){
		this.oxigenio--;
		if (this.oxigenio == 1) {
			System.out.println(DIFICIL_RESPIRAR);			
		} else if (oxigenio == 0){
			System.out.println(LIMITE);
		}
	}

	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao){
		if (conexao == null) {
			this.conexao = conexaoAnterior;
		} else {
			this.conexaoAnterior = this.conexao;
			this.conexao = conexao;
		}
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos){
		this.pontos = pontos;
	}

	public void setConexaoAnterior(Conexao conexaoAnterior) {
		this.conexaoAnterior = conexaoAnterior;
	}

	public Conexao getConexaoAnterior() {
		return conexaoAnterior;
	}
}