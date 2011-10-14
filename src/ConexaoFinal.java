public class ConexaoFinal extends Conexao {

	public static final String CONEXAO_FINAL = "Parabéns! Você encontrou a saida!\n";
	
	@Override
	public Conexao questionar(){
		System.out.print(CONEXAO_FINAL);
		setConexaoFinal(true);
		return this;
	}
}