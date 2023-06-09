package utils;

public enum Mes {
	Janeiro(1),
	Fevereiro(2),
	Março(3),
	Abril(4),
	Maio(5),
	Junho(6),
	Julho(7),
	Agosto(8),
	Setembro(9),
	Outubro(10),
	Novembro(11),
	Dezembro(12);

	private int valor;

    Mes(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Mes fromValor(int valor) {
        for (Mes tipo : Mes.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Mês inválido: " + valor);
    }
	
}
