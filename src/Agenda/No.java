package Agenda;

public class No {
    private char letra;       // Letra associada ao nó
    private No esq;           // Referência para o nó à esquerda
    private No dir;           // Referência para o nó à direita
    private Celula primeiro;  // Referência para a primeira célula na lista encadeada
    private Celula ultimo;    // Referência para a última célula na lista encadeada

    public No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.primeiro = null;
        this.ultimo = null;
    }

    //  metodos Getters e Setters

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public Celula getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public Celula getUltimo() {
        return ultimo;
    }

    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }
}
