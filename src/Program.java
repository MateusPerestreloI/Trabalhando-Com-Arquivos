import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		boolean continua = true;
		String item = "";
		
		List<String> lines = new ArrayList<String>();
		
		System.out.println("Caminho do arquivo: ");
		
		//Linha usada para pegar a pasta raiz do projeto
		String strPath = System.getProperty("user.dir");
		System.out.println(strPath);
		
		strPath += "\\out";
		
		//Criação da pasta que foi passado no caminho(strPath)
		new File(strPath).mkdir();
		strPath += "\\summary.txt";
		File path = new File(strPath);
		
		//Teste para ver se o arquivo existe
		boolean teste = new File(strPath).exists();
		if(teste == true)
		{
			try(BufferedReader br = new BufferedReader(new FileReader(path)))
			{
				String line = br.readLine();
				
				while(line != null)
				{
					lines.add(line);
					line = br.readLine();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//Captação dos dados para serem gravados
		while(continua == true)
		{
			System.out.println();
			System.out.println("Entre com item, preço(no formato: 99.99) e quantidade separados por vírgula ou digite 0 para parar:");
			item = sc.nextLine();
			if(item.equalsIgnoreCase("0"))
				continua = false;
			else
			{
				String[] dados = item.split(",");
				
				lines.add(dados[0] + ", " + (Double.parseDouble(dados[1]) * Double.parseDouble(dados[2])));
			}
		}
		
		//Gravando os dados em um arquivo que irá ser criado ou alterado
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
		{
			for(String line : lines)
			{
				bw.write(line);
				bw.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
