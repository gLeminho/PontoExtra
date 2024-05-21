
package meuapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TesteArquivos {
    private static String linha="";
    public static void main(String[] args) {
        String path = "teste.txt";
        try {
            escritor(path);
            leitor(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));

        System.out.println("Escreva algo: ");
        linha =new Scanner(System.in).nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();

    }

    private static void leitor(String path) throws IOException {
        File arquivo = new File(path);
        if (arquivo.exists()) {

            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha = "";
            while (true) {
                linha = buffRead.readLine();
                if (linha != null) {
                    System.out.println(linha);

                } else
                    break;

            }
            buffRead.close();
        } else {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }

}
