import java.util.LinkedList;

public abstract class Pergunta {

//	private static final String VOLTAR = "Voltar";
	private static final String RESPOSTAS_POSSIVEIS = "Respostas possiveis:";
	private static final String ACERTOU = "Voce sente que esta no caminho certo.\n";
	private static final String ERROU = "Hmm...\n";

	
	private String textoPergunta;
	private LinkedList<String> alternativas = new LinkedList<String>();
	private int gabarito;


	public void setGabarito(int gabarito) {
		this.gabarito = gabarito;
	}

	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta+"\n";
	}

	public LinkedList<String> getAlternativas() {
		return alternativas;
	}
	
	public void imprimirPergunta() {
		System.out.println(textoPergunta+ RESPOSTAS_POSSIVEIS);
		for (String textoAlternativa : alternativas) {
			System.out.println(textoAlternativa);
		}
//		System.out.println(VOLTAR);
	}
	
	public int compararResposta(String resposta){
		int alternativaEscolhida = -1;
//		if (resposta.toUpperCase().equals(VOLTAR.toUpperCase())){
//			alternativaEscolhida = 0;
//		}
		for (String alternativa : alternativas) {
			if(resposta.toUpperCase().equals(alternativa.toUpperCase())){
				alternativaEscolhida = alternativas.indexOf(alternativa) + 1;
				System.out.print(alternativaEscolhida == gabarito ? ACERTOU : ERROU);
			}
		}
		
		return alternativaEscolhida;
	}
}