public class PerguntaDupla extends Pergunta {

	public PerguntaDupla(String textoPergunta, String alternativa1, String alternativa2, int gabarito){
		setTextoPergunta(textoPergunta);
		setGabarito(gabarito);

		getAlternativas().add(alternativa1);
		getAlternativas().add(alternativa2);
	}

}