package br.edu.ifmt.cba.alphalab.gui.javafx;

public enum Horario {
	
	M1(" 7:00 -  7:50"),
	M2(" 7:55 -  8:40"),
	M3(" 8:50 -  9:40"),
	M4("10:00 - 10:50"),
	M5("10:55 - 11:45"),
	M6("11:50 - 12:40"),
	V1("13:00 - 13:50"),
	V2("13:55 - 14:45"),
	V3("14:50 - 15:40"),
	V4("16:00 - 16:50"),
	V5("16:55 - 17:45"),
	V6("17:50 - 18:40"),
	N1("18:50 - 19:40"),
	N2("19:40 - 20:30"),
	N3("20:45 - 21:35"),
	N4("21:35 - 22:25");
	
	private String estampa;
	
	private Horario(String estampa) {
		this.estampa = estampa;
	}
	
	public String getEstampa() {
		return this.estampa;
	}
}
