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

    public void dataUpdate(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
