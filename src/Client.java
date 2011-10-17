import java.util.LinkedList;
import java.util.Scanner;

public class Client {

	private static Scanner entrada = new Scanner(System.in);
		
	static final String FIM_JOGO = "Fim de jogo.";
	static final String POR_POUCO = "Essa foi por pouco!";
	static final String ESTUDE_MAIS = "Estude mais da proxima vez!";

	static LinkedList<Pergunta> perguntas = new LinkedList<Pergunta>();
	static LinkedList<Conexao> conexoes = new LinkedList<Conexao>();

	public static void main(String[] args) {

		montarJogo();
		
		Jogador jogador = new Jogador(conexoes.get(14));
		while (!jogador.getConexao().isConexaoFinal() && jogador.getOxigenio() > 0) {
			jogador.diminuirOxigenio();
			jogador.setConexao(jogador.getConexao().questionar());
		}
		
		System.out.println(FIM_JOGO);
		if (jogador.getOxigenio() == 0) {
			System.out.println(ESTUDE_MAIS);
		} else if (jogador.getOxigenio() < 2){
			System.out.println(POR_POUCO);			
		}
	}

	public static void montarJogo() {
		//0
		perguntas
				.add(new PerguntaDupla(
						"Complete a frase: O modificador de " +
						"acesso protected utilizado em um metodo indica que " +
						"apenas classes do mesmo _________ podem acessa-lo.",
						"Pacote", "Projeto", 1));
		//1
		perguntas
				.add(new PerguntaDupla(
					"O a definicao de metodo \"public int obterQuantidade()\" " +
					"indica que o tipo de retorno deste metodo e:", "Nulo", "Inteiro", 2));
		//2
		perguntas
				.add(new PerguntaDupla(
					"Recipiente rec = new Recipiente();\n" +
					"rec = new Recipiente();\nQuantos objetos foram criados no codigo acima?",
					"Um", "Dois", 2));
		//3
		perguntas
				.add(new PerguntaDupla(
					"O mesmo objeto pode ser referenciado por mais de uma variavel?",
					"Verdadeiro", "Falso", 1));
		//4
		perguntas
				.add(new PerguntaTripla(
					"Em uma classe public, temos uma variavel com os modificadores public e static.\n" +
					"Em quais locais esta variavel poderia ser acessada?",
					"Classe", "Projeto", "Pacote", 2));
		//5
		perguntas
				.add(new PerguntaTripla(
					"Qual e palavra chave do Java para definir heranca?",
					"inherits", "implements", "extends", 3));
		//6
		perguntas
				.add(new PerguntaTripla(
					"Os metodos de acesso (get/set) fazem parte de um padrao de design que " + 
					"utiliza conceitos de:",
					"Enclausuramento", "Encapsulamento", "Protecao", 2));
		
		conexoes.add(new ConexaoFinal());//0
		conexoes.add(new ConexaoSemSaida());//1
		conexoes.add(new ConexaoDupla(conexoes.get(0), conexoes.get(1), perguntas.get(0)));//2

		conexoes.add(new ConexaoSemSaida());//3
		conexoes.add(new ConexaoDupla(conexoes.get(3), conexoes.get(2), perguntas.get(1)));//4
				
		conexoes.add(new ConexaoSemSaida());//5
		conexoes.add(new ConexaoTripla(conexoes.get(4), conexoes.get(0), conexoes.get(5), perguntas.get(4)));//6
		
		conexoes.add(new ConexaoSemSaida());//7
		conexoes.add(new ConexaoDupla(conexoes.get(7), conexoes.get(6), perguntas.get(2)));//8

		conexoes.add(new ConexaoSemSaida());//9
		conexoes.add(new ConexaoTripla(conexoes.get(9), conexoes.get(8), conexoes.get(4), perguntas.get(5)));//10
		
		conexoes.add(new ConexaoSemSaida());//11
		conexoes.add(new ConexaoSemSaida());//12
		conexoes.add(new ConexaoTripla(conexoes.get(12), conexoes.get(8), conexoes.get(11), perguntas.get(6)));//13

		conexoes.add(new ConexaoDupla(conexoes.get(10), conexoes.get(13), perguntas.get(3)));//14
	}

	public static Scanner getEntrada() {
		return entrada;
	}

}