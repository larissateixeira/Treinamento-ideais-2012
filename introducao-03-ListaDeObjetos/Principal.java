import corejava.*;
public class Principal
{	public static void main (String[] args)
	{	final int TAM = Console.readInt('\n' + "Informe o tamanho da lista de empregados: ");
		ListaDeObjetos<Empregado> listaDeEmpregados = 
			new ListaDeObjetos<Empregado>(TAM);

		String nome;
		double salario;
		Empregado umEmpregado;

		boolean continua = true;
		while (continua)
		{	System.out.println('\n' + "==============================================================");
			System.out.println('\n' + "O que voc� deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um empregado");
			System.out.println("2. Alterar um empregado");
			System.out.println("3. Remover um empregado");
			System.out.println("4. Listar rela��o de empregados");
			System.out.println("5. Listar apenas N�mero e Nome dos empregados");
			System.out.println("6. Sair");
						
			int opcao = Console.readInt('\n' + "Digite um n�mero entre 1 e 6:");			
					
			switch (opcao)
			{	case 1:
					nome = Console.readLine('\n' + "Digite o nome do empregado: ");
					salario = Console.readDouble("Digite o salario do empregado: ");
					umEmpregado = new Empregado (nome, salario);
					listaDeEmpregados.adicionar(umEmpregado);
												
					System.out.println('\n' + "Empregado cadastrado com sucesso!");
					break;

				case 2:	// Alterar
				{	int resposta = Console.readInt('\n' + "Digite o n�mero do empregado que voc� deseja alterar: ");
								
					umEmpregado = listaDeEmpregados.recuperar(resposta);
									
					if (umEmpregado != null)			// Significa que achei o empregado que se deseja alterar	 
					{	System.out.println('\n' + "O que voc� deseja alterar?");
						System.out.println('\n' + "1. Nome");
						System.out.println("2. Salario");

						int opcaoAlteracao = Console.readInt('\n' + "Digite 1 ou 2:");			
					
						switch (opcaoAlteracao)
						{	case 1:
								String novoNome = Console.readLine("Digite o novo nome: ");
								umEmpregado.setNome(novoNome);
								System.out.println('\n' + "Altera��o de nome efetuada com sucesso!");						
								break;
							case 2:
								double novoSalario = Console.readDouble("Digite o novo sal�rio: ");
								umEmpregado.setSalario(novoSalario);
								System.out.println('\n' + "Altera��o de sal�rio efetuada com sucesso!");						
								break;
							default:
								System.out.println('\n' + "Op��o inv�lida!");						
								break;
						}
					}
					else
					{	System.out.println('\n' + "Empregado n�o encontrado!");
					}						
					break;
				}

				case 3:	// Remover
				{	int resposta = Console.readInt('\n' + "Digite o n�mero do empregado que voc� deseja remover: ");
					if (listaDeEmpregados.remover(resposta))
						System.out.println('\n' + "Empregado removido com sucesso!");
					else
						System.out.println('\n' + "Empregado n�o encontrado!");
					break;
				}

				case 4:	// Listar tudo
					if (listaDeEmpregados.vazia())
						System.out.println('\n' + "N�o h� empregados na lista.");
					else
					{	System.out.println("");
						umEmpregado = listaDeEmpregados.recuperarPrimeiro();
	
						while (umEmpregado != null)  
						{	umEmpregado.imprime();
							umEmpregado = listaDeEmpregados.recuperarProximo();
						}
					}
					break;

				case 5:	// Listar Numero e Nome
					if (listaDeEmpregados.vazia())
						System.out.println('\n' + "N�o h� empregados na lista.");
					else
					{	System.out.println("");
						umEmpregado = listaDeEmpregados.recuperarPrimeiro();
												
						while (umEmpregado != null)  
						{	System.out.println("N�mero = " + umEmpregado.getNumero() + "   Nome = " + umEmpregado.getNome());
							umEmpregado = listaDeEmpregados.recuperarProximo();
						}
					}
					break;

				case 6:	// Sair
					continua = false;
					break;

				default:
					System.out.println('\n' + "Op��o inv�lida!");						
			}
		}		
	}
}