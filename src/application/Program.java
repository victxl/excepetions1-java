package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reserva;
import model.exception.DominionException;

public class Program {

	public static void main(String[] args) {
		// TODO Stub de método gerado automaticamente
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data do Check-in : ");
			LocalDate checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Data do Check-out : ");
			LocalDate checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Reserva reserva = new Reserva(num, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			System.out.println();

			System.out.print("Digite a data para atualização:");
			System.out.print("Data do Check-in : ");
			checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Data do Check-out : ");
			checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			reserva.dataUpdate(checkin, checkout);
			System.out.println("Reserva atualizada: " + reserva);
		} catch (DateTimeParseException e) {
			System.out.println("Formato data invalido");

		} catch (DominionException e) {
			System.out.println("Erro na reserva" + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Formato data invalido");
		}

		sc.close();

	}

}
