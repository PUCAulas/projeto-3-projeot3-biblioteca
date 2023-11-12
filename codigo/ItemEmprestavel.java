public interface ItemEmprestavel {
    boolean emprestar();

    boolean devolver();

    int getExemplares();

    void setExemplares(int exemplares);

}