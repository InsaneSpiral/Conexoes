public class PerguntaTripla extends Pergunta {

	public PerguntaTripla(String textoPergunta, String alternativa1,
		String alternativa2, String alternativa3, int gabarito) {

		setTextoPergunta(textoPergunta);
		setGabarito(gabarito);

		getAlternativas().add(alternativa1);
		getAlternativas().add(alternativa2);
		getAlternativas().add(alternativa3);
	}

}