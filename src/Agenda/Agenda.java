package Agenda;

public class Agenda {

	public No raiz;
	
	public Agenda () {
		this.raiz = null;
	}
    
    public void inserir(Contato contato) {
        if (raiz == null) {
            raiz = new No(contato.getNome().charAt(0)); // Cria o nÃ³ raiz com a primeira letra do nome do contato
        }
        
        char primeiraLetra = contato.getNome().charAt(0); // ObtÃ©️m a primeira letra do nome do contato
        
        No atual = raiz;
        while (true) {
            if (primeiraLetra == atual.getLetra()) { // Encontrou a letra na Ã¡rvore
                Celula novaCelula = new Celula(contato);
                if (atual.getPrimeiro() == null) {
                    atual.setPrimeiro(novaCelula);
                    atual.setUltimo(novaCelula);
                } else {
                    atual.getUltimo().setProx(novaCelula);
                    atual.setUltimo(novaCelula);
                }
                return;
            } else if (primeiraLetra < atual.getLetra()) {
                if (atual.getEsq() == null) {
                    atual.setEsq(new No(primeiraLetra)); // Cria um novo nÃ³ Ã  esquerda
                    atual = atual.getEsq();
                } else {
                    atual = atual.getEsq(); // Desce para o nÃ³ da esquerda
                }
            } else {
                if (atual.getDir() == null) {
                    atual.setDir(new No(primeiraLetra)); // Cria um novo nÃ³ Ã  direita
                    atual = atual.getDir();
                } else {
                    atual = atual.getDir(); // Desce para o nÃ³ da direita
                }
            }
        }
    }

    
    public void remover(String nome) {
        if (raiz == null) {
            return; // Se a Ã¡rvore estiver vazia, retorna
        }
        
        char primeiraLetra = nome.charAt(0); // ObtÃ©️m a primeira letra do nome
        
        No atual = raiz;
        Celula celulaAnterior = null;
        Celula celulaAtual = null;
        
        while (atual != null) {
            if (primeiraLetra == atual.getLetra()) { // Encontrou a letra na Ã¡rvore
                celulaAtual = atual.getPrimeiro();
                
                // Percorre a lista encadeada para buscar o contato
                while (celulaAtual != null) {
                    if (celulaAtual.getContato().getNome().equals(nome)) {
                        // Remove a cÃ©️lula da lista encadeada
                        if (celulaAnterior != null) {
                            celulaAnterior.setProx(celulaAtual.getProx());
                        } else {
                            atual.setPrimeiro(celulaAtual.getProx());
                        }
                        if (celulaAtual == atual.getUltimo()) {
                            atual.setUltimo(celulaAnterior);
                        }
                        return;
                    }
                    
                    celulaAnterior = celulaAtual;
                    celulaAtual = celulaAtual.getProx();
                }
                return; // Se percorreu toda a lista e nÃ£o encontrou o contato, retorna
            } else if (primeiraLetra < atual.getLetra()) {
                atual = atual.getEsq(); // Desce para o nÃ³ da esquerda
            } else {
                atual = atual.getDir(); // Desce para o nÃ³ da direita
            }
        }
    }

    
    public Contato pesquisar(String nome) {
        if (raiz == null) {
            return null; // Se a Ã¡rvore estiver vazia, retorna null
        }
        
        char primeiraLetra = nome.charAt(0); // ObtÃ©️m a primeira letra do nome
        
        No atual = raiz;
        while (atual != null) {
            if (primeiraLetra == atual.getLetra()) { // Encontrou a letra na Ã¡rvore
                Celula celulaAtual = atual.getPrimeiro();
                while (celulaAtual != null) {
                    if (celulaAtual.getContato().getNome().equals(nome)) {
                        return celulaAtual.getContato(); // Encontrou o contato pelo nome
                    }
                    celulaAtual = celulaAtual.getProx();
                }
                return null; // Se percorreu toda a lista e nÃ£o encontrou o contato, retorna null
            } else if (primeiraLetra < atual.getLetra()) {
                atual = atual.getEsq(); // Desce para o nÃ³ da esquerda
            } else {
                atual = atual.getDir(); // Desce para o nÃ³ da direita
            }
        }
        
        return null; // Se nÃ£o encontrou a letra na Ã¡rvore, retorna null
    }
    
    public No buscarNoLetra(int cpf) {
        int primeiraDigitoCPF = Character.getNumericValue(Integer.toString(cpf).charAt(0)); // ObtÃ©️m o primeiro dÃ­gito do CPF
        
        No atual = raiz;
        while (atual != null) {
            if (primeiraDigitoCPF == Character.getNumericValue(atual.getLetra())) {
                return atual; // Retorna o nÃ³ com a letra correspondente ao primeiro dÃ­gito do CPF
            } else if (primeiraDigitoCPF < Character.getNumericValue(atual.getLetra())) {
                atual = atual.getEsq(); // Desce para o nÃ³ da esquerda
            } else {
                atual = atual.getDir(); // Desce para o nÃ³ da direita
            }
        }
        
        return null; // Se nÃ£o encontrou nenhum nÃ³ com a letra correspondente, retorna null
    }

    public Contato pesquisarcpf(int cpf) {
        // Percorre a Ã¡rvore procurando pelo no com a letra correspondente ao primeiro digito do CPF
        No noLetra = buscarNoLetra(cpf);

        // Se nao encontrar nenhum no com a letra correspondente, retorna null
        if (noLetra == null) {
            return null;
        }

        // Procura pelo contato na lista encadeada do nÃ³ com a letra correspondente
        Celula celulaAtual = noLetra.getPrimeiro();
        while (celulaAtual != null) {
            Contato contatoAtual = celulaAtual.getContato();

            if (contatoAtual.getCpf() == cpf) {
                return contatoAtual;
            }

            celulaAtual = celulaAtual.getProx();
        }

        // Se nÃ£o encontrar o contato, retorna null
        return null;
    }


    // Busca o nó correspondente a uma letra na árvore
    private No buscarNo(No no, char letra) {
        if (no == null) {
            return null;
        }

        if (letra == no.getLetra()) {
            return no;
        } else if (letra < no.getLetra()) {
            return buscarNo(no.getEsq(), letra);
        } else {
            return buscarNo(no.getDir(), letra);
        }
    }

    // Mostra todos os contatos da agenda
    public void mostrar() {
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            No no = buscarNo(raiz, letra);
            if (no != null) {
                System.out.println("Contatos com a letra " + letra + ":");
                Celula celulaAtual = no.getPrimeiro();
                while (celulaAtual != null) {
                    System.out.println(celulaAtual.getContato());
                    celulaAtual = celulaAtual.getProx();
                }
                System.out.println();
            }
        }
    }
	
}

