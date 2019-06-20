package asteroids;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
	public List<Integer> pontuacao = new ArrayList<>();
	public List<String> nome = new ArrayList<>();
	
	public void leitor(String path) throws IOException, FileNotFoundException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        String aux[] = new String[2];
        while (linha != null) {
            linha = buffRead.readLine();
            aux = linha.split(" ");
            pontuacao.add(Integer.parseInt(aux[0]));
            nome.add(aux[1]);
        }
        buffRead.close();
    }
 
    public void escritor(String nome, int pontuacao) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Ranking.txt"));
        buffWrite.append(pontuacao +" " + nome + "\n");
        buffWrite.close();
    }
}
