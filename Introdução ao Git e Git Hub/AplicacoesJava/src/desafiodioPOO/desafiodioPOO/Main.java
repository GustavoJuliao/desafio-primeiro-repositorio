package desafiodioPOO.desafiodioPOO;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Curso curso = new Curso();
		Curso curso2 = new Curso();
		Mentoria mentoria = new Mentoria();

		Conteudo conteudo = new Curso();

		



		curso.setTitulo("Java");
		curso.setDescricao("Java é uma linguagem de programação");
		curso.setCargaHoraria(30);

		curso2.setTitulo("Curso JS");
		curso2.setDescricao("JS é uma linguagem de programação§Ã£o");
		curso2.setCargaHoraria(15);

		mentoria.setTitulo("Mentoria Java");
		mentoria.setDescricao("Mentoria Java é uma mentoria");
		mentoria.setData(LocalDate.now());
		
		
		/*
		System.out.println(curso);
		System.out.println(curso2);
		System.out.println(mentoria);*/

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição do Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev devGustavo = new Dev();
		devGustavo.setNome("Gustavo");
		devGustavo.inscreverBootcamp(bootcamp);
		System.out.println("Conteudo Inscritos: " + devGustavo.getConteudoInscritos());
		devGustavo.progredir();
		devGustavo.progredir();
		System.out.println("-");
		System.out.println("Conteudo Inscritos: " + devGustavo.getConteudoInscritos());
		System.out.println("Conteudo Conclusão: " + devGustavo.getConteudoConcluÃ­dos());
		System.out.println("Total de XP: " + devGustavo.calcularTotalXp());
		
		System.out.println("==============================");

		Dev devRodrigo = new Dev();
		devRodrigo.setNome("Rodrigo");
		devRodrigo.inscreverBootcamp(bootcamp);
		System.out.println("Conteudo Inscritos: " + devRodrigo.getConteudoInscritos());
		devRodrigo.progredir();
		System.out.println("-");
		System.out.println("Conteudo Inscritos: " + devRodrigo.getConteudoInscritos());
		System.out.println("Conteudo Conclusão: " + devRodrigo.getConteudoConcluÃ­dos());
		System.out.println("Total de XP: " + devRodrigo.calcularTotalXp());


	}

}
