package desafiodioPOO.desafiodioPOO;

public class Curso extends Conteudo{
    
    private int cargaHoraria;

    @Override
    public double getXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public Curso() { }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public String toString() {
        return "Titulo:" + getTitulo() + ", descricao='" + getDescricao() + "', CargaHoraria{" + cargaHoraria + "}";
    }
}
