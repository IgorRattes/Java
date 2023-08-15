package Agenda;

public class Celula {
	 private Contato contato; // Referência para o contato armazenado na célula
	    private Celula prox;     // Referência para a próxima célula na lista encadeada

	    public Celula(Contato contato) {
	        this.contato = contato;
	        this.prox = null;
	    }

	    // Getters e Setters

	    public Contato getContato() {
	        return contato;
	    }

	    public void setContato(Contato contato) {
	        this.contato = contato;
	    }

	    public Celula getProx() {
	        return prox;
	    }

	    public void setProx(Celula prox) {
	        this.prox = prox;
	    }
}
