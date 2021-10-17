package com.tech4me.primeirorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4me.primeirorest.compartilhado.VendaDto;
import com.tech4me.primeirorest.compartilhado.ProdutoDto;
import com.tech4me.primeirorest.http.ProdutosFeignClient;
import com.tech4me.primeirorest.model.Venda;
import com.tech4me.primeirorest.util.UtilData;
import com.tech4me.primeirorest.repository.VendaRepository;
import com.tech4me.primeirorest.service.VendaService;
import com.tech4me.primeirorest.service.VendaServiceImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class VendasMsApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(VendasMsApplication.class, args);

		int MAX_ELEMENTOS = 1;
        final int MAX_ERROS_CODIGO = 3;
        int opcao, qtdCadastrados = 0;
        Produto[] produtos = new Produto[MAX_ELEMENTOS];
        Venda ven = new Venda ();
        ArrayList<Venda> vendas;
        ArrayList<Produto> produtinhos;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período - detalhado");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {
                Produto pro = new Produto();
                produtinhos = new ArrayList<Produto>();
                produtinhos.add(pro);

                System.out.print("Nome do produto: ");
                pro.setNomeDoProduto(in.nextLine());

                System.out.print("Valor do produto: ");
                pro.setValorDoProduto(in.nextInt());

                System.out.print("Quantidade do produto em estoque: ");
                pro.setQuantidadeEmEstoque(in.nextInt());
                int numVezes = 0;

                do {
                    try {
                        System.out.print("Código do produto: ");
                        pro.setCodigo(in.nextLine());
                    } catch (InputMismatchException ex) {
                        System.out.println(ex.getMessage() + " Tente novamente.");
                        numVezes += 1;
                    }
                } while (pro.getCodigo() == null && numVezes < MAX_ERROS_CODIGO);

                
                if (pro.getCodigo() == null) {
                    System.out.printf("Você errou o código %d vezes. O programa será encerrado.", numVezes);
                    return;
                }

                produtos[qtdCadastrados] = pro;
                qtdCadastrados = qtdCadastrados + 1;

                System.out.println("\nProduto cadastrado com sucesso.");
                voltarMenu(in);

                } else if (opcao == 2) {
                    if (qtdCadastrados == 0) {
                        System.out.println("\nNão há produtos cadastrados para exibir.");
                        voltarMenu(in);
                        continue;
                    }
    
                    System.out.print("\nCódigo do produto a ser consultado: ");
                    String cpf = in.nextLine();
    
                    Produto proConsulta = null;
                    for (int i = 0; proConsulta == null && i < qtdCadastrados; i++) {
                        if (cpf.equals(produtos[i].getCodigo())) {
                            proConsulta = produtos[i];
                        }
                    }
    
                    if (proConsulta == null) {
                        System.out.println("Código não localizado!");
                    } else {
                        System.out.println("Código localizado:");
                        exibirProduto(proConsulta);
                    }
    
                    voltarMenu(in);

                } else if (opcao == 3) {
                    if (qtdCadastrados == 0) {
                        System.out.println("\nNão há produtos cadastrados para exibir.");
                        voltarMenu(in);
                        continue;
                    }
    
                    System.out.println("\nLISTAGEM DE PRODUTOS:");
                    System.out.println("***********************");
    
                    for (int i = 0; i < qtdCadastrados; i++) {
                        exibirProduto(produtos[i]);
                    }
    
                    voltarMenu(in);
                }else if (opcao ==4){
                   

                        System.out.println("*********************************");
                        System.out.println("****** Relatório de vendas ******");
                        System.out.println("*********************************");
                        System.out.println();
                
                        System.out.println("Gerado em: " + UtilData.converterDateParaData(new Date()));
                        System.out.println();
                
                        System.out.printf("\nNome do produto vendido: %s\n", ven.getProdutoVendido());
                        System.out.printf("Valor do produto vendido: %s\n", ven.getValorProdutoVendido());
                        System.out.printf("Quantidade de produto vendido: %s\n", ven.getQuantidadeVendida());
                        System.out.printf("Valor total: %s\n", (ven.getQuantidadeVendida() * ven.getValorProdutoVendido()));
                
                        System.out.println();
                        System.out.println("*********************************");
                        System.out.println("*********************************");
                        System.out.println("*********************************");
                        System.out.println();
            

                } else if (opcao == 5){
                    vendas = new ArrayList<Venda>();
                    Venda venda = new Venda();
                    vendas.add(venda);

                    System.out.print("Nome do produto vendido: ");
                    ven.setProdutoVendido(in.nextLine());

                    System.out.print("Quantidade vendida: ");
                    ven.setQuantidadeVendida(in.nextInt());

                    System.out.print("Valor unitário do produto vendido: ");
                    ven.setValorProdutoVendido(in.nextDouble());

                    System.out.println("Data da venda: " + UtilData.converterDateParaData(new Date()));
                    System.out.println();
                    
                    voltarMenu(in);

                } else if (opcao != 0) {
                    System.out.println("\nOpção inválida!");
                }
            } while (opcao != 0);
    
            System.out.println("Fim do programa!");
    
            in.close();
        
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
    
    private static void exibirProduto(Produto produto) {
        System.out.printf("\nNome do produto: %s\n", produto.getNomeDoProduto());
        System.out.printf("Código do produto: %s\n", produto.getCodigo());
        System.out.printf("Valor do produto: %s\n", produto.getValorDoProduto());
        System.out.printf("Valor do produto: %s\n", produto.getQuantidadeEmEstoque());
        
        double valorMaximo = 0;
        double valorMinimo = 0;
        double soma = valorMaximo + valorMinimo /2;
        if (produto.getValorDoProduto() > valorMaximo){
            valorMaximo = produto.getValorDoProduto();
        } else if (produto.getValorDoProduto() < valorMinimo){
            valorMinimo = produto.getValorDoProduto();
        }
        System.out.println("Valor máximo: " + valorMaximo);
        System.out.println();
        System.out.println("Valor mínimo: " + valorMinimo);
        System.out.println();
        System.out.println("Valor médio: " + soma);
    }
	}
}
