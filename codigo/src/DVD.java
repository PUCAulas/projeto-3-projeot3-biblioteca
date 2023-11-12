public class DVD extends ItemBibli implements ItemEmprestavel{
    // Construtor que chama o construtor da classe mãe
    public DVD(String autor, String titulo, int ano, int exemplares) {
        super(autor, titulo, ano, exemplares);
    }
    @Override
    public boolean emprestar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emprestar'");
    }

    @Override
    public boolean devolver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolver'");
    }
    
}
