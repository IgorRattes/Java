package Agenda;

public class ClassePrin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Agenda agenda = new Agenda();

	        // Criação de alguns contatos para testar a agenda
	        Contato contato1 = new Contato("Igor Rattes", "993369075", "julia@gmail.com", 123456789);
	        Contato contato2 = new Contato("Guilherme Olimpio", "992329075", "Eduardo@gmail.com", 987654321);
	        Contato contato3 = new Contato("Daniela Gomes", "123456789", "Daniela@gmail.com", 987654321);

	        // Inserção dos contatos na agenda
	        agenda.inserir(contato1);
	        agenda.inserir(contato2);
	        agenda.inserir(contato3);

	        // Pesquisa de um contato pelo nome
	        System.out.println("Pesquisando um contato pelo nome:");
	        System.out.println("Nome pesquisado: " + contato2.getNome());
	        System.out.println(agenda.pesquisar("Eduardo"));
	        System.out.println("____________________");
	        System.out.println(""); //Espaço
	        // Pesquisa de um contato pelo CPF
	        System.out.println("Pesquisando um contato pelo CPF:");
	        System.out.println("CPF pesquisado: " + contato1.getCpf());
	        System.out.println(agenda.pesquisarcpf(123456789));
	        System.out.println("____________________");
	        System.out.println(""); //Espaço
	        // Mostrando todos os contatos da agenda, separados por letra
	        System.out.println("Todos os contatos:");
	        System.out.println("");//Espaço
	        agenda.mostrar();
	        System.out.println("____________________");
	        System.out.println(""); //Espaço
	        
	        // Remove um contato da agenda
	        System.out.println("Contato removido: " + contato1.getNome());
	        agenda.remover("Igor Rattes");
	        System.out.println("____________________");
	        System.out.println(""); //Espaço

	        // Mostra todos os contatos da agenda, após a exclusão do contato 2
	        System.out.println("Agenda Atualizada: ");
	        System.out.println(""); //Espaço
	        agenda.mostrar();
	        System.out.println("____________________");
	        System.out.println(""); //Espaço
	}

}
