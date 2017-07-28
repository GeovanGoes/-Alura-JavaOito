import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Datas {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadas = LocalDate.of(2018, Month.JUNE, 5);
		
		Period period = Period.between(hoje, olimpiadas);
		
		System.out.println(period.getDays());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String format = olimpiadas.format(formatter);
		
		System.out.println(format);		
		
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		
	}
}
