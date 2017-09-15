import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Os tr�s pilares da evolu��o do java 8 s�o:
 * Default Method
 * Lambda
 * Method Reference
 * */
public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura");
		palavras.add("meu novo");
		palavras.add("minhas notas");
		palavras.add("Caelum");
		palavras.add("Novo");
		
		/**Equivalente
		 * palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		 * */
		/**Equivalente
		* Function<String, Integer> funcao = s -> s.length();
		* Comparator<String> comparador = Comparator.comparing(funcao);
		* palavras.sort(comparador);
		*/
		/** Equivalente
		 * palavras.sort(Comparator.comparing(s -> s.length()));
		 * */
		palavras.sort(Comparator.comparing(String::length));
		
		/**Interface funcional == interface que s� tem um m�todo*/
		palavras.replaceAll(t -> 
			{
				if (t.contains("o"))
				{
					return "Substitu�do";
				}
				return t;
			}
		);
		
		/** Equivalente:
		 * Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
		*/
		/**
		 * palavras.forEach(t -> System.out.println(t));
		 * */
		palavras.forEach(System.out::println);
		/**
		 * :: � um method reference
		 * */		
		
		/**Desafio Thread*/
		new Thread(() -> System.out.println("Rodando...")).start();
		
		
	}
}