package codigo.src;

import java.util.List;
import java.util.Scanner;

import codigo.src.ControlleItens.*;
import codigo.src.ControlleItens.FabricaItens.*;

public class App {
    public static void main(String[] args) throws Exception { 
        // menu
        Scanner entrada = new Scanner(System.in);
        int escolha;
        Biblioteca bib = Biblioteca.getInstance();
        // teste APAGAR DEPOIS
        Livro l1 = new Livro("Pedro", "Pinoquio", 2010, 4, "Fantasia");
        CD l2 = new CD("Alex", "Musica para Churrasco", 2023, 8, "Pagode");
        Livro l3 = new Livro("Fernando", "Computador no mundo", 2021, 4, "Atualidade");
        Livro l4 = new Livro("Roberto", "Ceu estrelado", 1998, 2, "Ficção");
        bib.addItem(l1);
        bib.addItem(l2);
        bib.addItem(l3);
        bib.addItem(l4);

        bib.addUsuario("Jorge", "Matematica");
        bib.addUsuario("Felipe", "Filosofia");
        bib.addEmpretimo(1, 3, "01/11/2023");
        //////////////
        System.out.println("Bem vindo a biblioteca!");
        do {
            System.out.print("\n");
            System.out.println("Escolha o numero do que deseja fazer: ");
            System.out.println("1. SubMenu Usuarios");// menu de CRUD para usuario
            System.out.println("2. SubMeunu Itens");// menu de CRUD para itens e opção de pesquisar por item conforme //
                                                    // requisito C
            System.out.println("3. SubMenu Relatorios");// menu para relatorios do requisito D
            System.out.println("0. Sair Do Sistema");

            escolha = entrada.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("Saindo do programa. Adeus!");
                    break;
                case 1:
                    subUsuario(entrada, bib);
                    break;
                case 2:
                    subItens(entrada, bib);
                    break;
                case 3:
                    subRelatorio(entrada, bib);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 0);
    }

    // menu geral de itens
    public static void subItens(Scanner entrada, Biblioteca bib) {
        int subChoice = 110;

        do {// falta crud dos itens
            System.out.print("\n");
            System.out.println("Submenu da Opção 2, Itens:");
            System.out.println("1. Pesquisar");
            System.out.println("2. Cadastrar Novo Item");
            System.out.println("3. Listar");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    subPesquisaItem(entrada, bib);
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Que Tipo De Item Deseja Cadastrar:");
                    System.out.println("1. Livros");
                    System.out.println("2. Teses");
                    System.out.println("3. CDs");
                    System.out.println("4. DVDs");
                    System.out.println("5. Revistas");
                    int tipo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Qual O Autor Do Item?");
                    String autor = entrada.nextLine();
                    System.out.println("Qual O Titulo Do Item?");
                    String titulo = entrada.nextLine();
                    System.out.println("Qual O Ano De Publicacao Do Item?");
                    int ano = entrada.nextInt();
                    System.out.println("Quantos Exemplares Serao Registrados Do Item?");
                    int exemplares = entrada.nextInt();
                    System.out.println("Qual O genero Do Item?");
                    String genero = entrada.nextLine();
                    switch (tipo) {
                        case 1:
                            Criador fabricaLivro = new FabricaLivro();
                            ItemBibli novoLivro = fabricaLivro.criarItemBibli(autor, titulo, ano, exemplares, genero);
                            bib.addItem(novoLivro);
                            break;
                        case 2:
                            Criador fabricaTese = new FabricaTese();
                            ItemBibli novoTese = fabricaTese.criarItemBibli(autor, titulo, ano, exemplares, genero);
                            bib.addItem(novoTese);
                            break;
                        case 3:
                            Criador fabricaCD = new FabricaCD();
                            ItemBibli novoCD = fabricaCD.criarItemBibli(autor, titulo, ano, exemplares, genero);
                            bib.addItem(novoCD);
                            break;
                        case 4:
                            Criador fabricaDVD = new FabricaDVD();
                            ItemBibli novoDVD = fabricaDVD.criarItemBibli(autor, titulo, ano, exemplares, genero);
                            bib.addItem(novoDVD);
                            break;
                        case 5:
                            Criador fabricaRevista = new FabricaRevista();
                            ItemBibli novoRevista = fabricaRevista.criarItemBibli(autor, titulo, ano, exemplares, genero);
                            bib.addItem(novoRevista);
                            break;
                        default:
                            System.out.println("Tipo Invalido!");
                            break;
                    }
                    break;
                case 3:
                    subListarItem(entrada, bib);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }

    // menu de listar de itens
    public static void subListarItem(Scanner entrada, Biblioteca bib) {
        int subChoice = 110;

        do {// falta crud dos itens
            System.out.print("\n");
            System.out.println("Escolha A Lista Desejada:");
            System.out.println("1. Listar Por Titulo");
            System.out.println("2. Listar Por Autor");
            System.out.println("3. Listar Por Ano");
            System.out.println("4. Listar Por Tipo");
            System.out.println("5. Listar Por Id");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando!");
                    break;
                case 1:
                    bib.listarPorTitulo();
                    break;
                case 2:
                    bib.listarPorAutor();
                    break;
                case 3:
                    bib.listarPorAno();
                    break;
                case 4:
                    bib.listarPorTipo();
                    break;
                case 5:
                    bib.listarItens();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }

    // menu de pesquisa de itens
    public static void subPesquisaItem(Scanner entrada, Biblioteca bib) {
        int subChoice = 110;

        do {// falta crud dos itens
            System.out.print("\n");
            System.out.println("Escolha A Pesquisa Desejada:");
            System.out.println("1. Pesquisar Por Titulo");
            System.out.println("2. Pesquisar Por Autor");
            System.out.println("3. Pesquisar Por Ano");
            System.out.println("4. Pesquisar Por Tipo");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    entrada.nextLine();
                    System.out.println("Digite O Titulo Para Pesquisa: ");
                    bib.pesquisarPorTitulo(entrada.nextLine());
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Digite O Autor Para Pesquisa: ");
                    bib.pesquisarPorAutor(entrada.nextLine());
                    break;
                case 3:
                    System.out.println("Digite O Ano Para Pesquisa: ");
                    bib.pesquisarPorAno(entrada.nextInt());
                    break;
                case 4:
                    System.out.println("Escolha O Tipo Para Pesquisa: ");
                    System.out.println("1. Livros");
                    System.out.println("2. Teses");
                    System.out.println("3. CDs");
                    System.out.println("4. DVDs");
                    System.out.println("5. Revistas");
                    int tipo = entrada.nextInt();
                    switch (tipo) {
                        case 1:
                            bib.pesquisarPorTipo("Livro");
                            break;
                        case 2:
                            bib.pesquisarPorTipo("Tese");
                            break;
                        case 3:
                            bib.pesquisarPorTipo("CD");
                            break;
                        case 4:
                            bib.pesquisarPorTipo("DVD");
                            break;
                        case 5:
                            bib.pesquisarPorTipo("Revista");
                            break;

                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }
    // Fim de itens
    ///////////////////////////////////////

    public static void subUsuario(Scanner entrada, Biblioteca bib) {
        int subChoice;

        do {
            System.out.print("\n");
            System.out.println("Submenu da Opção 1, Usuario:");
            System.out.println("1. Ver todos usuários");
            System.out.println("2. Adicionar novo usuário");
            System.out.println("3. Itens emprestados de um usuario");
            System.out.println("4. Pegar um item emprestado");
            System.out.println("5. Devolver um item emprestado");
            System.out.println("6. Recomendacoes");
            System.out.println("7. Adicionar novo interesse a um usuario");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    bib.imprimirUsuarios();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Digite o nome do usuario: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o curso do usuario: ");
                    String curso = entrada.nextLine();
                    bib.addUsuario(nome, curso);
                    break;
                case 3:
                    bib.imprimirUsuarios();
                    System.out.println("Digite o id do usuário: ");
                    int idUser = entrada.nextInt();
                    bib.listarEmprestimosUsuario(idUser);
                    break;
                case 4:
                    bib.imprimirUsuarios();
                    System.out.println("Digite O Id Do Usuario Desejado: ");
                    int idUsuario = entrada.nextInt();
                    bib.listarEmprestaveis();
                    System.out.println("Digite O Id Do Item Desejado: ");
                    int idItem = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite A Data Do Inicio Do Emprestimo: (dd/mm/yyyy)");
                    String data = entrada.nextLine();
                    bib.addEmpretimo(idUsuario, idItem, data);
                    break;
                case 5:
                    bib.imprimirUsuarios();
                    System.out.println("Digite O Id Do Usuario Desejado: ");
                    int idUsua = entrada.nextInt();
                    bib.listarEmprestimosUsuarioEmprestado(idUsua);
                    System.out.println("Digite O Id Do Item Desejado: ");
                    int idDevolvido = entrada.nextInt();
                    bib.devolverItem(idUsua, idDevolvido);
                    break;
                case 6:
                    bib.imprimirUsuarios();
                    System.out.println("Digite O Id Do Usuario Desejado: ");
                    int idUs = entrada.nextInt();
                    Usuario usRec = bib.getUsuarioPorId(idUs);
                    bib.recomendarItens(usRec);
                    break;
                case 7:
                    bib.imprimirUsuarios();
                    System.out.println("Digite O Id Do Usuario Desejado: ");
                    int idUsuar = entrada.nextInt();
                    entrada.nextInt();
                    System.out.println("Digite o interesse do usuario: ");
                    String interesse = entrada.nextLine();
                    Usuario usuar = bib.getUsuarioPorId(idUsuar);
                    usuar.addInteresse(interesse);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }

    public static void subRelatorio(Scanner entrada, Biblioteca bib) {
        int subChoice;

        do {
            System.out.print("\n");
            System.out.println("Submenu da Opção 3, Relatórios:");
            System.out.println("1. Quantidade de vezes que itens foram emprestados, ordenado por ano de publicação");
            System.out.println("2. Usuarios e itens que ja pegou emprestado");
            System.out.println("0. Sair");

            subChoice = entrada.nextInt();

            switch (subChoice) {
                case 0:
                    System.out.println("Voltando para o Menu Principal!");
                    break;
                case 1:
                    bib.relatorioItensEmprestimos();
                    break;
                case 2:
                    bib.relatorioUsuariosEmprestimos();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (subChoice != 0);
    }
}
