import Services.*;
import Repository.*;
import models.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService(new PessoaRepositoryList());
        TurmaService turmaService = new TurmaService(new TurmaRepositoryList());
        DisciplinaService disciplinaService = new DisciplinaService(new DisciplinaRepositoryList());
        TurmaDisciplinaService tdService = new TurmaDisciplinaService(new TurmaDisciplinaRepositoryList());

        boolean sair = false;

        while(!sair) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Turma");
            System.out.println("4 - Cadastrar Disciplina");
            System.out.println("5 - Cadastrar TurmaDisciplina");
            System.out.println("6 - Listar todos");
            System.out.println("7 - Buscar");
            System.out.println("8 - Atualizar");
            System.out.println("9 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            // ----------- CADASTRAR ALUNO -----------
            if(opcao == 1) {
                System.out.println("--- CADASTRAR ALUNO ---");
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Data Nascimento (YYYY-MM-DD): ");
                LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();

                // Escolher Turma
                List<Turma> turmas = turmaService.buscarTodos();
                Turma turma = null;
                if(!turmas.isEmpty()) {
                    System.out.println("Escolha uma Turma pelo ID:");
                    for(Turma t : turmas) System.out.println(t.getIdTurma() + " - " + t.getSemestre());
                    System.out.print("ID da Turma: ");
                    long idTurma = sc.nextLong();
                    sc.nextLine();
                    turma = turmaService.buscar(idTurma);
                }

                Alunos aluno = new Alunos(nome, cpf, dataNascimento, turma, matricula);
                pessoaService.cadastrar(aluno);
                System.out.println("Aluno cadastrado!");
            }

            // ----------- CADASTRAR PROFESSOR -----------
            else if(opcao == 2) {
                System.out.println("--- CADASTRAR PROFESSOR ---");
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Data Nascimento (YYYY-MM-DD): ");
                LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
                System.out.print("Formação: ");
                String formacao = sc.nextLine();
                System.out.print("Status (TEMPORARIO, EFETIVO, APOSENTADO): ");
                Status status = Status.valueOf(sc.nextLine().toUpperCase());
                System.out.print("Titulação (PROFESSOR, MESTRE, DOUTOR, MESTRE_CIENCIAS): ");
                Titulacao titulacao = Titulacao.valueOf(sc.nextLine().toUpperCase());

                Professor prof = new Professor(nome, cpf, dataNascimento, formacao, status, titulacao);
                pessoaService.cadastrar(prof);
                System.out.println("Professor cadastrado!");
            }

            // ----------- CADASTRAR TURMA -----------
            else if(opcao == 3) {
                System.out.println("--- CADASTRAR TURMA ---");
                System.out.print("ID da Turma: ");
                long idTurma = sc.nextLong();
                sc.nextLine();
                System.out.print("Semestre: ");
                String semestre = sc.nextLine();

                Turma turma = new Turma(idTurma, semestre);
                turmaService.cadastrar(turma);
                System.out.println("Turma cadastrada!");
            }

            // ----------- CADASTRAR DISCIPLINA -----------
            else if(opcao == 4) {
                System.out.println("--- CADASTRAR DISCIPLINA ---");
                System.out.print("Nome da Disciplina: ");
                String nomeDisc = sc.nextLine();
                System.out.print("Código da Disciplina: ");
                long codDisc = sc.nextLong();
                sc.nextLine();
                System.out.print("Nota mínima: ");
                double notaMin = sc.nextDouble();
                sc.nextLine();

                // Escolher Professor
                List<Pessoa> pessoas = pessoaService.buscarTodos();
                Professor professor = null;
                if(!pessoas.isEmpty()) {
                    System.out.println("Escolha Professor pelo CPF:");
                    for(Pessoa p : pessoas) {
                        if(p instanceof Professor)
                            System.out.println(p.getCpf() + " - " + p.getNome());
                    }
                    System.out.print("CPF do Professor: ");
                    String cpfProf = sc.nextLine();
                    professor = (Professor) pessoaService.buscar(cpfProf);
                }

                Disciplina disciplina = new Disciplina(nomeDisc, codDisc, notaMin);
                disciplina.setProfessor(professor);
                disciplinaService.cadastrar(disciplina);
                System.out.println("Disciplina cadastrada!");
            }

            // ----------- CADASTRAR TURMA/DISCIPLINA -----------
            else if(opcao == 5) {
                System.out.println("--- CADASTRAR TURMA/DISCIPLINA ---");

                // Escolher a Turma
                List<Turma> turmas = turmaService.buscarTodos();
                Turma turma = null;
                if(!turmas.isEmpty()) {
                    System.out.println("Escolha Turma pelo ID:");
                    for(Turma t : turmas) System.out.println(t.getIdTurma() + " - " + t.getSemestre());
                    System.out.print("ID da Turma: ");
                    long idT = sc.nextLong();
                    sc.nextLine();
                    turma = turmaService.buscar(idT);
                }

                // Escolher a Disciplina
                List<Disciplina> disciplinas = disciplinaService.buscarTodos();
                Disciplina disciplina = null;
                if(!disciplinas.isEmpty()) {
                    System.out.println("Escolha Disciplina pelo Código:");
                    for(Disciplina d : disciplinas) System.out.println(d.getCodDisciplina() + " - " + d.getNomeDisciplina());
                    System.out.print("Código da Disciplina: ");
                    long codD = sc.nextLong();
                    sc.nextLine();
                    disciplina = disciplinaService.buscar(codD);
                }

                if(disciplina != null && turma != null) {
                    TurmaDisciplina td = new TurmaDisciplina(disciplina, turma, disciplina.getProfessor());
                    tdService.cadastrar(td);
                    System.out.println("TurmaDisciplina cadastrada!");
                } else {
                    System.out.println("Cadastro cancelado: Turma ou Disciplina inválida.");
                }
            }

            // ----------- LISTAR TODOS -----------
            else if(opcao == 6) {
                System.out.println("--- LISTAR TODOS ---");
                System.out.println("Pessoas:");
                for(Pessoa p : pessoaService.buscarTodos()) System.out.println(p);
                System.out.println("\nTurmas:");
                for(Turma t : turmaService.buscarTodos()) System.out.println(t);
                System.out.println("\nDisciplinas:");
                for(Disciplina d : disciplinaService.buscarTodos()) System.out.println(d);
                System.out.println("\nTurmaDisciplina:");
                for(TurmaDisciplina td : tdService.buscarTodos()) System.out.println(td);
            }

            // ----------- BUSCAR -----------
            else if(opcao == 7) {
                System.out.println("--- BUSCAR ---");
                System.out.println("Escolha tipo: 1-Pessoa 2-Turma 3-Disciplina");
                int tipo = sc.nextInt();
                sc.nextLine();

                if(tipo == 1) {
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    Pessoa p = pessoaService.buscar(cpf);
                    if(p != null) System.out.println(p);
                    else System.out.println("Pessoa não encontrada!");
                }
                else if(tipo == 2) {
                    System.out.print("ID da Turma: ");
                    long id = sc.nextLong();
                    sc.nextLine();
                    Turma t = turmaService.buscar(id);
                    if(t != null) System.out.println(t);
                    else System.out.println("Turma não encontrada!");
                }
                else if(tipo == 3) {
                    System.out.print("Código da Disciplina: ");
                    long cod = sc.nextLong();
                    sc.nextLine();
                    Disciplina d = disciplinaService.buscar(cod);
                    if(d != null) System.out.println(d);
                    else System.out.println("Disciplina não encontrada!");
                }
            }

            // ----------- ATUALIZAR -----------
            else if(opcao == 8) {
                System.out.println("--- ATUALIZAR ---");
                System.out.println("Escolha tipo: 1-Pessoa 2-Turma 3-Disciplina");
                int tipo = sc.nextInt();
                sc.nextLine();

                if(tipo == 1) {
                    System.out.print("CPF da Pessoa: ");
                    String cpf = sc.nextLine();
                    Pessoa p = pessoaService.buscar(cpf);
                    if(p != null) {
                        System.out.print("Novo nome: ");
                        p.setNome(sc.nextLine());
                        pessoaService.atualizar(cpf, p);
                        System.out.println("Pessoa atualizada!");
                    } else System.out.println("Pessoa não encontrada!");
                }
                else if(tipo == 2) {
                    System.out.print("ID da Turma: ");
                    long id = sc.nextLong();
                    sc.nextLine();
                    Turma t = turmaService.buscar(id);
                    if(t != null) {
                        System.out.print("Novo semestre: ");
                        t.setSemestre(sc.nextLine());
                        turmaService.atualizar(id, t);
                        System.out.println("Turma atualizada!");
                    } else System.out.println("Turma não encontrada!");
                }
                else if(tipo == 3) {
                    System.out.print("Código da Disciplina: ");
                    long cod = sc.nextLong();
                    sc.nextLine();
                    Disciplina d = disciplinaService.buscar(cod);
                    if(d != null) {
                        System.out.print("Novo nome: ");
                        d.setNomeDisciplina(sc.nextLine());
                        disciplinaService.atualizar(cod, d);
                        System.out.println("Disciplina atualizada!");
                    } else System.out.println("Disciplina não encontrada!");
                }
            }

            // ----------- DELETAR -----------
            else if(opcao == 9) {
                System.out.println("--- DELETAR ---");
                System.out.println("Escolha tipo: 1-Pessoa 2-Turma 3-Disciplina");
                int tipo = sc.nextInt();
                sc.nextLine();

                if(tipo == 1) {
                    System.out.print("CPF da Pessoa: ");
                    String cpf = sc.nextLine();
                    pessoaService.deletar(cpf);
                    System.out.println("Pessoa deletada (se existia)!");
                }
                else if(tipo == 2) {
                    System.out.print("ID da Turma: ");
                    long id = sc.nextLong();
                    sc.nextLine();
                    turmaService.deletar(id);
                    System.out.println("Turma deletada (se existia)!");
                }
                else if(tipo == 3) {
                    System.out.print("Código da Disciplina: ");
                    long cod = sc.nextLong();
                    sc.nextLine();
                    disciplinaService.deletar(cod);
                    System.out.println("Disciplina deletada (se existia)!");
                }
            }

            // ----------- SAIR -----------
            else if(opcao == 0) {
                sair = true;
                System.out.println("Saindo...");
            }

            else {
                System.out.println("Opção inválida!");
            }

        }

        sc.close();
    }
}
