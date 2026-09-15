package application;

import model.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990, 5, 12),  new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961, 5, 2),   new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel",  LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995, 1, 5),   new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 9),  new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993, 3, 17),  new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994, 7, 8),   new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24),  new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena",  LocalDate.of(1996, 9, 2),   new BigDecimal("2799.93"), "Gerente"));

        
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        FuncionarioService service = new FuncionarioService();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

       
        System.out.println("Lista de funcionários:");
        funcionarios.forEach(f -> {
            System.out.println(
                    f.getNome() + " | " +
                    f.getFuncao() + " | " +
                    formatter.format(f.getDataNascimento()) + " | " +
                    nf.format(f.getSalario())
            );
        });

      
        service.aplicarAumento(funcionarios);

        
        Map<String, List<Funcionario>> agrupados = service.agruparPorFuncao(funcionarios);

        
        agrupados.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.println(f.getNome()));
        });

      
        System.out.println("\nAniversariantes (Outubro e Dezembro):");
        service.aniversariantesMes(funcionarios, 10, 12)
                .forEach(f -> System.out.println(f.getNome()));

       
        Funcionario maisVelho = service.maisVelho(funcionarios);
        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\nMais velho: " + maisVelho.getNome() + " - " + idade + " anos");
        }

        
        System.out.println("\nFuncionários em ordem alfabética:");
        service.ordenarPorNome(funcionarios)
                .forEach(f -> System.out.println(f.getNome()));

      
        BigDecimal total = service.totalSalarios(funcionarios);
        System.out.println("\nTotal dos salários: " + nf.format(total));

        
        BigDecimal salarioMinimo = new BigDecimal("1212");
        System.out.println("\nQuantidade de salários mínimos por funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + ": " + qtd + " salários mínimos");
        });
    }
}