import javax.swing.JOptionPane;

public class escada
{
	public static void main(String[] args)
	{
		int linha, altura, numero;
		int sair = 1;

		System.out.println("\nSUA ESCADA SERÁ IMPRESSA AQUI!");

		while (true)
		{
			try
			{
				numero = Integer.parseInt(JOptionPane.showInputDialog("Por favor, leia a instruções abaixo:"
						+ "\n*Digite na caixa de mensagens somente números inteiros*"
						+ "\n*Sua escada será impressa no terminal*\n\n"
						+ "Informe o tamanho da escada ou digite '0' para sair"));// Box que verifica se o número é
																					// interiro.
				// Não possibilita a entrada de número negativos
				if (numero > -1)
				{
					sair = numero;
					// Condição para não sair do programa.
					if (sair != 0)
					{
						// Serve para acrescentrar altura.
						for (altura = 1; altura <= numero; altura++)
						{
							// Faz a linha.
							for (linha = 1; linha <= numero; linha++)
							{
								// Verifica o que vai ser acrescentado. Espaço ou asterisco.
								if (linha > (numero - altura))
								{
									System.out.print("*");
								} else
								{
									System.out.print(" ");
								}
							}
							System.out.println();
						}
					} else
					{// Condição para sair do programa.
						System.out.println("\nSaindo...");
						break;
					}
				} else
				{// Caso seja inserido algum número negativo.
					System.out.println("\nPor favor, digite somente números positivos!");
				}
			} catch (NumberFormatException exception)
			{// Caso o digito inserido não seja um número inteiro é
				// retornado esse erro.
				// caso tenha sido digitado uma String a exceção é capturada
				JOptionPane.showMessageDialog(null, "Error: Por favor, informe somente números inteiros!");
			}
		}
	}
}