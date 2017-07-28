import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura");
		palavras.add("meu ovo");
		palavras.add("minhas bola");
		palavras.add("Caelum");
		palavras.add("Ovo");
		
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
		
		/**Interface funcional == interface que só tem um método*/
		palavras.replaceAll(t -> 
			{
				if (t.contains("o"))
				{
					return "Substituído";
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
		 * :: é um method reference
		 * */		
		
		/**Desafio Thread*/
		new Thread(() -> System.out.println("Rodando...")).start();
		
		
	}
}