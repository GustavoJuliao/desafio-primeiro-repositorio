package desafiodioPOO.desafiodioPOO;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String name;
    private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluídos = new LinkedHashSet<>();

    public Dev() {
    }
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudoInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevInscritos().add(this);

    }
    
    public void progredir() {
        
        Optional<Conteudo> conteudo = this.conteudoInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudoConcluídos.add(conteudo.get());
            this.conteudoInscritos.remove(conteudo.get());
        }else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }

    }

    public double calcularTotalXp(){
        return this.conteudoConcluídos.stream().mapToDouble(Conteudo::getXp).sum();

    }















    public String getNome(){
        return name;
    }
    public void setNome(String name){
        this.name = name;
    }
    public Set<Conteudo> getConteudoInscritos(){
        return conteudoInscritos;
    }
    public void setConteudoInscritos(Set<Conteudo> conteudoInscritos){
        this.conteudoInscritos = conteudoInscritos;
    }
    public Set<Conteudo> getConteudoConcluídos(){
        return conteudoConcluídos;
    }
    public void setConteudoConcluídos(Set<Conteudo> conteudoConcluídos){
        this.conteudoConcluídos = conteudoConcluídos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;

        return name != null ? name.equals(dev.name) : dev.name == null;
    }

    @Override   
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }








}
