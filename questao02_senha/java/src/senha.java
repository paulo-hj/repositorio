import java.util.Scanner;

public class senha
{

	public static void main(String[] args)
	{
		// Declaração de variaveis
		char caracteresEspeciais[] =
		{ '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' };
		String nome = " ";
		String senha;
		String sair = "SAIR";
		String s = "S";

		System.out.println("######################Leia-me#########################"
				+ "\nDigite o seu nome;                                   #"
				+ "\nDigite uma senha forte, com o seguintes critérios:   #"
				+ "\n6 caracteres;                                        #"
				+ "\n1 digito númerico;                                   #"
				+ "\n1 letra maiúscula;                                   #"
				+ "\n1 letra minúscula;                                   #"
				+ "\n1 caractere especial-> '!@#$%^&*()-+*'.              #\n"
				+ "                                                     #"
				+ "\nPara sair do programa digite 'sair' ou 's' em senha. #"
				+ "\n######################################################\n");

		while (true)
		{
			boolean maiuscula, minuscula, digito;
			int faltaCaracteres, contadorRelativo;
			int contadorCaractere = 0;
			int contadorEspeciais = 0;
			int contadorMaiuscula = 0;
			int contadorMinuscula = 0;
			int contadorDigito = 0;
			int contadorPreRequisitos = 0;

			Scanner entrada = new Scanner(System.in);
			if (nome.length() < 2)
			{
				System.out.print("\n\nInforme seu nome:");
				nome = entrada.nextLine();
			}
			System.out.print("Informe sua nova senha:");
			senha = entrada.nextLine();
			/*
			 * É deixado a string de senha maiúscula para que não tenha problema de
			 * tipografia, e é verificado se foi digitado 'sair' ou 's'.
			 */
			if (sair.equals(senha.toUpperCase()) || s.equals(senha.toUpperCase()))
			{
				System.out.println("\nSaindo...");
				// Fecha o scanner aberto.
				entrada.close();
				// Finaliza o programa pois foi solicitado.
				break;
			} else
			{
				// Pecorre todos os caracteres da string de senha
				for (int i = 0; i < senha.length(); i++)
				{
					char caractere = senha.charAt(i);
					// Verifica se na string de senha tem letras maiusculas, minuculas e digitos
					maiuscula = Character.isUpperCase(caractere);
					minuscula = Character.isLowerCase(caractere);
					digito = Character.isDigit(caractere);
					if (maiuscula)
					{
						contadorMaiuscula++;
					} else if (minuscula)
					{
						contadorMinuscula++;
					} else if (digito)
					{
						contadorDigito++;
					}
					// Conta quantos caracteres tem a string
					contadorCaractere++;
					// Pecorre toda lista de caracteres especiais
					for (int j = 0; j < caracteresEspeciais.length; j++)
					{
						// Copara os caracteres especiais a cada caracrete da string de senha
						if (caracteresEspeciais[j] == caractere)
						{
							contadorEspeciais++;
						}
					}
				}
				// Verifica se foi informado o nome;
				if (nome.length() < 2)
				{
					System.out.println("\nÉ necessário preencher o campo nome!");
				} else
				{
					// if para utilizar print informando que a senha é fraca.
					if (contadorMaiuscula == 0 || contadorMinuscula == 0 || contadorEspeciais == 0
							|| contadorDigito == 0 || contadorCaractere < 6)
					{
						System.out.println("\n___________________________________________________");
						System.out.println("Senha fraca!\nEstá faltando:");
						// Verificar se a senha atende ao pré-requisito de pelo menos 1 letra maiuscula
						// a senha.
						if (contadorMaiuscula == 0)
						{
							System.out.println("1 letra maiusculas");
							// Informa que +1 um pré-requisito não foi cumprido.
							contadorPreRequisitos++;
						}
						// Verificar se a senha atende ao pré-requisito de pelo menos 1 letra minuscula
						// a senha.
						if (contadorMinuscula == 0)
						{
							System.out.println("1 letra minúscula");
							// Informa que +1 um pré-requisito não foi cumprido.
							contadorPreRequisitos++;
						}
						// Verificar se a senha atende ao pré-requisito de pelo menos 1 caractere
						// especial a senha.
						if (contadorEspeciais == 0)
						{
							System.out.println("1 caractere especial");
							// Informa que +1 um pré-requisito não foi cumprido.
							contadorPreRequisitos++;
						}
						// Verificar se a senha atende ao pré-requisito de pelo menos 1 número a senha.
						if (contadorDigito == 0)
						{
							System.out.println("1 dígito");
							// Informa que +1 um pré-requisito não foi cumprido.
							contadorPreRequisitos++;
						}
						// Verifica quantos caracteres está faltando para o mínimo.
						contadorRelativo = 6 - contadorCaractere;
						/*
						 * Verifica se o contador de pré-requisitos é menor que a diferença de
						 * caracteres da string senha para 6 (Pois 6 é o número de caracteres mínimo
						 * para a senha), então adicionando a quantidade de caracteres faltantes,
						 * conseguimos corrigir os pré-requisitos de senha. Mas no caso se o contador
						 * pré-requisito for maior que a diferença de caracteres da string senha para 6,
						 * será impresso a quantidade de pré-requisitos, pois precisamos tonar a senha
						 * forte independente da quantidade de caracteres.
						 */
						if (contadorPreRequisitos <= contadorRelativo)
						{
							faltaCaracteres = contadorRelativo;
						} else
						{
							faltaCaracteres = contadorPreRequisitos;
						}
						System.out.println(faltaCaracteres + " caracteres");
						System.out.println("___________________________________________________");
					}
					// Verifica se não tem nenhum critério faltando.
					if (contadorPreRequisitos == 0 && contadorCaractere >= 6)
					{
						System.out.println("\nSenha forte!\nSua conta foi criada com sucesso!");
						// Fecha o scanner aberto.
						entrada.close();
						// Finaliza o programa pois foi criado uma senha forte.
						break;
					}
				}
			}
		}
		System.out.println("\n___________________________________________________");
	}
}
