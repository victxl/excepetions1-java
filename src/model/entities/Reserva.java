package model.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Reserva {
    private Integer numeroQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public long duracao() {
        Duration diferenca = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        return diferenca.toDays();
    }

    public String dataUpdate(LocalDate checkIn, LocalDate checkOut) {
    	if (!checkIn.isAfter(LocalDate.now()) || !checkOut.isAfter(LocalDate.now())) {
		    return"Erro na reserva: A data de reserva para atualização deve ser no futuro!";
		}
    	if (!checkOut.isAfter(checkIn)) {
    		return"Erro de reserva: A data de check-out deve ser posterior à data de check-in";
		}
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroQuarto +
                ", checkIn: " +
                checkIn +
                ", checkOut: " +
                checkOut +
                ", " +
                duracao() +
                " Noites";
    }
}
