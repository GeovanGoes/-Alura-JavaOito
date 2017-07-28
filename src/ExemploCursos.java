import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Curso
{
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) 
	{
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public int getAlunos() 
	{
		return alunos;
	}
	
	
}

public class ExemploCursos 
{
	public static void main(String[] args) 
	{
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python",45));
		cursos.add(new Curso("Javascript",113));
		cursos.add(new Curso("Java 8",150));
		cursos.add(new Curso("C",55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		/**
		 * Stream é uma Interface e fluente
		 * 
		 * Abaixo exemplos de como filtrar uma lista
		 * */
		cursos.stream().filter(c -> c.getAlunos() >= 100);
		
		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.map(Curso::getAlunos)
		.forEach(System.out::println);
		
		/**
		 * Filtrar uma lista e executar uma ação 	
		 * */
		int sum = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.mapToInt(Curso::getAlunos)
		.sum();
		
		System.out.println(sum);
		
		/**
		 * Forma de receber a colection de volta
		 * */
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));
		
		List<Curso> listaFiltrada = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toList());
		
		listaFiltrada.forEach(c -> System.out.println(c.getNome()));
		
		/**
		 * parallelStream() é para processamento concorrente
		 * */
		cursos.parallelStream()
		.filter(c -> c.getAlunos() >= 100)
		.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()))
					.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));
	}
}
