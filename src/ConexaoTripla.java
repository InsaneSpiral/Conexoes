public class ConexaoTripla extends Conexao {

	private static final String VALOR_INVALIDO = "Valor invalido. Digite novamente.";

	public ConexaoTripla(Conexao conexao1, Conexao conexao2, Conexao conexao3, Pergunta pergunta) {
		this.setPergunta(pergunta);
		
		this.getConexoes().add(conexao1);
		this.getConexoes().add(conexao2);
		this.getConexoes().add(conexao3);
	}

	@Override
	public Conexao questionar(){
		getPergunta().imprimirPergunta();
		while (true) {
			String resposta = Client.getEntrada().nextLine();
			switch (getPergunta().compararResposta(resposta)) {
				case 0 :
					return null;

				case 1 :
					return getConexoes().get(0);
				
				case 2 :
					return getConexoes().get(1);
				
				case 3 :
					return getConexoes().get(2);
				
				default:
						System.out.print(VALOR_INVALIDO);

			}
		}
	}
}