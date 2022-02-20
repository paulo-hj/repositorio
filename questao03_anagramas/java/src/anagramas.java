import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class anagramas
{
	public static void main(String[] args)
	{
		System.out.print("Verifique o número de pares de substrings que são anagramas.");

		while (true)
		{
			ArrayList<String> listaDeAnagramas = new ArrayList();
			char[] primeiraListadeCaracteres, segundaListadeCaracteres;
			String entradaString, palavraUm, palavraDois;
			int contadorParesSubstrings = 0;
			String sair = " ";

			Scanner entrada = new Scanner(System.in);
			System.out.print("\n\n\nInforme a palavra ou digite 'S' para sair: ");
			entradaString = entrada.next();
			sair = entradaString;

			// Verificar se foi digitado o 's' de sair, ignorando a tipografia.
			if (sair.equalsIgnoreCase("s"))
			{
				System.out.println("\nSaindo...");
				entrada.close();
				break;
			} else
			{
				// Faz o anagrama.
				for (int i = 0; i < entradaString.length(); i++)
				{
					for (int j = i + 1; j <= entradaString.length(); j++)
					{
						// i e j são posições na string, onde i é a posição inicial e j é até aonde será
						// pecorrido na string.
						listaDeAnagramas.add(entradaString.substring(i, j));
					}
				}
				// Pecorre toda a lista trazendo as substring(anagrama de entrada).
				for (int i = 0; i < listaDeAnagramas.size() - 1; i++)
				{
					palavraUm = "" + listaDeAnagramas.get(i);
					// Convertendo a palavra em uma lista de caracteres.
					primeiraListadeCaracteres = palavraUm.toCharArray();
					// Ordena a lista de letras.
					Arrays.sort(primeiraListadeCaracteres);
					// Esse segunda for é para comparar a primeira palavra com a segunda e assim
					// sucessivamente.
					for (int j = i + 1; j < listaDeAnagramas.size(); j++)
					{
						palavraDois = "" + listaDeAnagramas.get(j);
						segundaListadeCaracteres = palavraDois.toCharArray();
						Arrays.sort(segundaListadeCaracteres);
						// Verifica cada caracteres de da palavra, para que assim sabermos se uma é
						// igual a outra.
						if (Arrays.equals(primeiraListadeCaracteres, segundaListadeCaracteres))
						{
							contadorParesSubstrings++;
						}
					}
				}
				// printa a quantidade anagramas iguais.
				System.out.printf(
						"\n_______________________________________________________\n"
								+ "                                                       |\n"
								+ "        '%s'tem %d pares de substrings.                \n"
								+ "_______________________________________________________|",
						entradaString, contadorParesSubstrings);
			}
		}
	}
}
