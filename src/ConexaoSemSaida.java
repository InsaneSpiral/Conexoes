public class ConexaoSemSaida extends Conexao {

	private static final String PERGUNTA_VOLTAR = "Conexão sem saída. Deseja voltar?";
	private static final String ENCARA_PAREDE = "Você encara a parede enquanto sente seu fôlego diminuir.\n";
	private static final String SIM = "Sim";
	private static final String NAO = "Nao";
	private static final String VALOR_INVALIDO = "Valor inválido. Digite novamente.";

	public ConexaoSemSaida() {
		this.setPergunta(new PerguntaDupla(PERGUNTA_VOLTAR, SIM, NAO, 1));
	}

	@Override
	public Conexao questionar() {
		while (true) {
			getPergunta().imprimirPergunta();
			String resposta = Client.getEntrada().nextLine();
			switch (getPergunta().compararResposta(resposta)) {

				case 1:
					return null;
					
				case 2:
					System.out.print(ENCARA_PAREDE);
					break;
					
				default:
					System.out.print(VALOR_INVALIDO);

			}
		}
	}
}