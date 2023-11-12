import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
    private int idUsuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    private int idItem;
    private int diasDeEmprestimo = 10;
    private int limiteDeEmprestimo = 3;
    private boolean emprestado = true;

    public Emprestimo(int idUsuario, int idItem, String dataEmprestimo) throws ParseException {
        this.idUsuario = idUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.idItem = idItem;
        calcularDataDevolucao();
    }

    private void calcularDataDevolucao() throws ParseException {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataEmprestimo));
        calendario.add(Calendar.DATE, diasDeEmprestimo);
        this.dataDevolucao = new SimpleDateFormat("dd/MM/yyyy").format(calendario.getTime());
    }

    public void devolver() {
        this.emprestado = false;
    }

    public boolean isEmprestado() {
        return this.emprestado;
    }

    public int getIdUser() {
        return idUsuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getItemId() {
        return idItem;
    }

    public int getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    public int getLimiteDeEmprestimo() {
        return limiteDeEmprestimo;
    }
}
