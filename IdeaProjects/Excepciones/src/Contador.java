public class Contador {
    private int valor;
    private boolean inicializado;

    public Contador() {
        this.valor = 0;
        this.inicializado = false;
    }

    public void inicializar() {
        this.inicializado = true;
    }

    public void incrementar() {
        if (!inicializado) {
            throw new IllegalStateException("El contador no ha sido inicializado");
        }
        valor++;
    }

    public int obtenerValor() {
        return valor;
    }
}