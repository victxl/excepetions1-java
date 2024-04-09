package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Stub de método gerado automaticamente
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data do Check-in : ");
		LocalDate checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Data do Check-out : ");
		LocalDate checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		if (!checkout.isAfter(checkin)) {
			System.out.println("Erro de reserva: A data de check-out deve ser posteriar a data de check-in");

		} else {
			Reserva reserva = new Reserva(num, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			System.out.println();

			System.out.print("Digite a data para atualização:");
			System.out.print("Data do Check-in : ");
			checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Data do Check-out : ");
			checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			String error = reserva.dataUpdate(checkin, checkout);
			if (error != null) {
				System.out.println("Erro na Reserva : " + error);

			} else {
				System.out.println("Reserva atualizada: " + reserva);
			}

		}

	}

}
