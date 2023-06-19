/* Nome do Aluno: José Lucas Augusto Ribeiro
* RA: 323114228
* Nome do Programa: Exercicio 1
* Data: 19.06.2023
*/

import java.util.Scanner;

public class calculadoraprof {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o regime de pagamento (CLT, Horista ou PJ): ");
        String regime = scanner.nextLine();

        double valorReceber = 0.0;

        if (regime.equalsIgnoreCase("CLT")) {
            System.out.print("Digite o salário mensal: ");
            double salarioMensal = scanner.nextDouble();

            double salarioBase = calcularSalarioBase(salarioMensal);
            double descontoINSS = calcularDescontoINSS(salarioBase);
            double descontoIR = calcularDescontoIR(salarioBase - descontoINSS);
            double valorBeneficios = calcularValorBeneficios(salarioBase);

            valorReceber = salarioBase - descontoINSS - descontoIR + valorBeneficios;
        } else if (regime.equalsIgnoreCase("Horista")) {
            System.out.print("Digite o número de horas trabalhadas: ");
            int horasTrabalhadas = scanner.nextInt();
            System.out.print("Digite o valor da hora de trabalho: ");
            double valorHora = scanner.nextDouble();
            valorReceber = horasTrabalhadas * valorHora;
        } else if (regime.equalsIgnoreCase("PJ")) {
            System.out.print("Digite o valor do contrato: ");
            double valorContrato = scanner.nextDouble();
            valorReceber = valorContrato;
        } else {
            System.out.println("Regime de pagamento inválido.");
            System.exit(1);
        }

        System.out.println("Nome do professor: " + nome);
        System.out.println("Valor a receber: " + valorReceber);
    }

    private static double calcularSalarioBase(double salarioMensal) {
        if (salarioMensal <= 1100) {
            return salarioMensal;
        } else if (salarioMensal <= 2203.48) {
            return salarioMensal - (salarioMensal * 0.075);
        } else if (salarioMensal <= 3305.22) {
            return salarioMensal - (salarioMensal * 0.09);
        } else if (salarioMensal <= 6433.57) {
            return salarioMensal - (salarioMensal * 0.12);
        } else {
            return salarioMensal - 751.99;
        }
    }

    private static double calcularDescontoINSS(double salarioBase) {
        if (salarioBase <= 1100) {
            return salarioBase * 0.075;
        } else if (salarioBase <= 2203.48) {
            return salarioBase * 0.09;
        } else if (salarioBase <= 3305.22) {
            return salarioBase * 0.12;
        } else if (salarioBase <= 6433.57) {
            return salarioBase * 0.14;
        } else {
            return 751.99;
        }
    }

    private static double calcularDescontoIR(double salarioBaseDescontado) {
        if (salarioBaseDescontado <= 1903.98) {
            return 0.0;
        } else if (salarioBaseDescontado <= 2826.65) {
            return (salarioBaseDescontado * 0.075) - 142.80;
        } else if (salarioBaseDescontado <= 3751.05) {
            return (salarioBaseDescontado * 0.15) - 354.80;
        } else if (salarioBaseDescontado <= 4664.68) {
            return (salarioBaseDescontado * 0.225) - 636.13;
        } else {
            return (salarioBaseDescontado * 0.275) - 869.36;
        }
    }

    private static double calcularValorBeneficios(double salarioBase) {
        return salarioBase * 0.15;
    }
}


