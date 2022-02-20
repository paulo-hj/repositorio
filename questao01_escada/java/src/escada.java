import javax.swing.JOptionPane;

public class escada
{
	public static void main(String[] args)
	{
		int linha, altura, numero;
		int sair = 1;

		System.out.println("\nSUA ESCADA SER� IMPRESSA AQUI!");

		while (true)
		{
			try
			{
				numero = Integer.parseInt(JOptionPane.showInputDialog("Por favor, leia a instru��es abaixo:"
						+ "\n*Digite na caixa de mensagens somente n�meros inteiros*"
						+ "\n*Sua escada ser� impressa no terminal*\n\n"
						+ "Informe o tamanho da escada ou digite '0' para sair"));// Box que verifica se o n�mero �
																					// interiro.
				// N�o possibilita a entrada de n�mero negativos
				if (numero > -1)
				{
					sair = numero;
					// Condi��o para n�o sair do programa.
					if (sair != 0)
					{
						// Serve para acrescentrar altura.
						for (altura = 1; altura <= numero; altura++)
						{
							// Faz a linha.
							for (linha = 1; linha <= numero; linha++)
							{
								// Verifica o que vai ser acrescentado. Espa�o ou asterisco.
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
					{// Condi��o para sair do programa.
						System.out.println("\nSaindo...");
						break;
					}
				} else
				{// Caso seja inserido algum n�mero negativo.
					System.out.println("\nPor favor, digite somente n�meros positivos!");
				}
			} catch (NumberFormatException exception)
			{// Caso o digito inserido n�o seja um n�mero inteiro �
				// retornado esse erro.
				// caso tenha sido digitado uma String a exce��o � capturada
				JOptionPane.showMessageDialog(null, "Error: Por favor, informe somente n�meros inteiros!");
			}
		}
	}
}