package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracaoDaEstadia() {
		long dif = checkOut.getTime() - checkIn.getTime(); // calcula a diferenca em milissegundos
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); //TimeUnit e tipo enum do java - aqui vai converter de millisegundos para dias
	}
	
	public String updateDatas(Date checkIn, Date checkOut) {
		Date agora = new Date(); //Vai pegar o instante atual
		if(checkIn.before(agora) || checkOut.before(agora)) {
			return "A atualizacao da reserva deve ser com data futura";
		}
		if(!checkOut.after(checkIn)) {
			return "A data do checkOut deve ser depois da data o checkIn";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //Vai retornar nulo caso não ocorra erro
	}
	
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", "
				+ duracaoDaEstadia()
				+ " noites";
	}

	
}
