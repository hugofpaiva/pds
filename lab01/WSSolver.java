import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class WSSolver {
	private static LinkedHashMap<String, LinkedList<String>> palavras = new LinkedHashMap<String, LinkedList<String>>(); // ESTRUTURA DE DADOS QUE GUARDA  PALAVRA A SE PROCURADA E OS RESPETIVOS DETALHES RELATIVOS À SOPE ADE LETRAS
	private static char[][] matrix_soup = new char[50][50]; // ATRIZ ONDE VAI SER GUARDADA A SOPA DE LETRAS
	private static int l = 0; // NÚMERO DE LINHAS DA MATRIZ (SOPA DE LETRAS)
	private static int c = 0; // NÚMERO DE COLUNAS DA MATRIZ (SOPA DE LETRAS)
	private static boolean timing = false; // FLAG PARA VERIFICAR SE É NECESSÁRIO TER EM CONTA O TEMPO DE EXECUÇÃO
	private static double startTime = 0; // HORA A QUE O PROGRAMA FOI INICIADO 

	enum Move {
		initial, left, right, up, down, upleft, downleft, downright, upright
	}

	public static void main(String[] args) {
		// VERIFICAÇÃO DAS OPÇÕES DE ENTRADA
		if (args.length == 2) {
			if (args[0].equals("-timing")) {
				// SE É INTRODUZIDA A OPÇÃO DE VISUALIZAÇÃO DE TEMPO
				timing = true;
				startTime = System.currentTimeMillis();
				if (args[1].substring(args[1].length() - 3).equals("txt")) { // VERIFICAÇÃO SE É UM FICHEIRO .TXT
					readfile(args[1]);
				} else {
					System.err.println("Ficheiro não suportado!");
					System.exit(0);
				}
			}
		} else if (args.length == 1) {
			// SE É APENAS INTRODUZIDO O FICHEIRO DE TEXTO
			if (args[0].substring(args[0].length() - 3).equals("txt")) { // VERIFICAÇÃO SE É UM FICHEIRO .TXT
				readfile(args[0]);
			} else {
				System.err.println("Ficheiro não suportado!");
				System.exit(0);
			}
		} else {
			System.err.println("Opções incorretas!");
			System.exit(0);
		}

		// PROCURA RECURSIVA POR CADA UMA DAS PALAVRAS PRETENDIDAS
		for (String search : palavras.keySet()) {
			search_word(matrix_soup, "", 0, 0, Move.initial, search, -1, -1);
		}

		// IMPRESSÃO DOS RESULTADOS
		print();

	}

	private static void print() {
		// SE A OPÇÃO DE MOSTRAR O TEMPO FOI INTRODUZIDA
		if (timing) {
			double estimatedTime = (System.currentTimeMillis() - startTime) / 1000;
			System.out.format("Elapsed time (secs): %-1.3f\n", estimatedTime);
		}

		int max_word_size = maxSize(palavras.keySet()); // TAMANHO MÁXIMO DE UMA PALAVRA DO CONJUNTO DE PALAVRAS A SER PROCURADO PARA UMA IMPRESSÃO DOS RESULTADOS CORRETA

		for (String palavra : palavras.keySet()) {
			if (palavras.get(palavra).size() == 0) {
				System.err.println("Palavra " + palavra + " não encontrada!");

			} else if (palavras.get(palavra).size() > 3) {
				// PARA O CASO DE PALAVRAS CAPICUAS
				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(0),
						palavras.get(palavra).get(1), palavras.get(palavra).get(2));

				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(3),
						palavras.get(palavra).get(4), palavras.get(palavra).get(5));

			} else {

				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(0),
						palavras.get(palavra).get(1), palavras.get(palavra).get(2));
			}

		}

	}

	private static void readfile(String filename) {
		try {
			// LEITURA DO FICHEIRO
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			int lastc = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();

				if (l == 0) {
					lastc = line.length(); // TAMANHO DA LINHA ANTERIOR
				}
				// VERIFICAR SE NÃO É MAIOR QUE 50X50
				if (line.length() > 50 || l > 50) {
					System.err.println("Maior que 50x50");
					System.exit(0);
				}

				boolean hasLowercase = !line.equals(line.toUpperCase()); // VERIFICAÇÃO SE AS LETRAS SÃO MINÚSCULAS
				if (hasLowercase) {
					// PALAVRAS QUE PROCURAMOS
					String[] lista = line.toUpperCase().split("[,; ]");

					for (String palavra : lista) {
						// VERIFICAR SE AS PALAVRAS SÃO MAIORES QUE 4
						if (palavra.length() < 4) {
							System.err.println("Palavras menores que 4!");
							System.exit(0);
						}
						// VERIFICAR SE AS PALAVRAS SÃO ALFANUMÉRICAS
						else if (!palavra.matches("[a-zA-Z0-9]+")) {
							System.err.println("Palavras não alfanuméricas!");
							System.exit(0);
						}
						// VERIFICAR SE AS PALAVRAS CONTÉM PALAVRAS DUPLICADAS OU REDUNDANTES
						for (String palavra2 : lista) {
							if (palavra.contains(palavra2) && !palavra.equals(palavra2)) {
								System.err.println(
										"A lista de palavras contém palavras duplicadas ou frases redundantes!");
								System.exit(0);
							}
						}
						// CRIAÇÃO DA ESTRUTURA DE DADOS PARA GUARDAR INFORMAÇÕES DE CADA PALAVRAS
						LinkedList<String> details = new LinkedList<String>();
						palavras.put(palavra, details);
					}
				} else {
					// CRIAÇÃO DA MATRIX (QUANDO AS LETRAS SÃO MAIÚSCULAS)
					c = 0;
					for (char caracter : line.toCharArray()) {
						matrix_soup[l][c] = caracter;
						c++;
					}
					l++;
				}
				if (lastc != c) { // VERIFICAÇÃO SE O TAMANHO DA LINHA ANTERIOR É O MESMO QUE O DESTA LINHA, NECESSÁRIO PARA A MATRIZ SER QUADRADA
					System.err.println("Não é quadrado!");
					System.exit(0);
				}

			}
			if (lastc != c) {
				System.err.println("Não é quadrado!");
				System.exit(0);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Erro a abrir o ficheiro!");
		}
	}

	private static int maxSize(Set<String> lista) {
		int max = 0;
		for (String x : lista) {
			if (x.length() > max) {
				max = x.length();
			}
		}
		return max;
	}

	private static void search_word(char[][] m, String word, int x, int y, Move move, String search, int initial_x,
			int initial_y) {
		String w_temp; // PALAVRA A SER ENVIADA PARA O PRÓXIMO CICLO DA RECURSIVIDADE SE NENHUMA VERIFICAÇÃO FALHAR

		int w_size = word.length(); // TAMANHO ATUAL DA PALAVRA QUE ESTÁ A SER CONSTRUÍDA RECURSIVAMENTE

		if (move == Move.initial) { // QUANDO A FUNÇÃO É EXECUTADA A PRIMEIRA VEZ E NÃO EXISTE DIREÇÃO DE MOVIMENTO DEFINIDO

			// PERCORRER A MATRIZ DURANTE A PRIMEIRA EXECUÇÃO DA FUNÇÃO
			for (int yy = y; yy < l; yy++) {

				for (int xx = x; xx < c; xx++) {

					if (m[yy][xx] == search.charAt(w_size)) { // SE A LETRA DA POSIÇÃO ATUAL DA MATRIZ FOR IGUAL À LETRA DA PALAVRA QUE ESTÁ À PROCURA, NA POSIÇÃO DO TAMANHO ATUAL DA PALAVRA QUE ESTÁ A SER CONSTRUÍDA RECURSIVAMENTE
						w_temp = word + String.valueOf(m[yy][xx]); 
						int w_temp_size = w_temp.length();

						// VERIFICAÇÕES, CONSOANTE O TAMANHO DA PALAVRA QUE ESTÁ A SER PROCURADA, SE ESTA PODE ESTAR NA SOPA DE LETRAS NA DIREÇÃO DE MOVIMENTO EM QUESTÃO, TENDO EM CONTA O TAMANHO DA SOPA DE LETRAS
						if (xx - (search.length() - w_temp_size) >= 0) { // NESTE CASO, COMO VAI PARA A ESQUERDA, É SUBSTRAIDO AO X ATUAL O RESTO DO TAMANHO DA PALAVRA QUE ESTAMOS À PROCURA, PARA VERIFICAR SE ESTA CABE NA MATRIZ
							search_word(m, w_temp, xx - 1, yy, Move.left, search, xx + 1, yy + 1);
						}

						if (xx + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, xx + 1, yy, Move.right, search, xx + 1, yy + 1);
						}

						if (yy - (search.length() - w_temp_size) >= 0) {
							search_word(m, w_temp, xx, yy - 1, Move.up, search, xx + 1, yy + 1);
						}

						if (yy + (search.length() - w_temp_size) <= l) {
							search_word(m, w_temp, xx, yy + 1, Move.down, search, xx + 1, yy + 1);
						}

						if (xx - (search.length() - w_temp_size) >= 0 && yy - (search.length() - w_temp_size) >= 0) {
							search_word(m, w_temp, xx - 1, yy - 1, Move.upleft, search, xx + 1, yy + 1);
						}

						if (xx - (search.length() - w_temp_size) >= 0 && yy + (search.length() - w_temp_size) <= l) {
							search_word(m, w_temp, xx - 1, yy + 1, Move.downleft, search, xx + 1, yy + 1);
						}

						if (yy + (search.length() - w_temp_size) <= l && xx + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, xx + 1, yy + 1, Move.downright, search, xx + 1, yy + 1);
						}

						if (yy - (search.length() - w_temp_size) >= 0 && xx + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, xx + 1, yy - 1, Move.upright, search, xx + 1, yy + 1);
						}
					}
				}
			}

		} else {
			if (m[y][x] == search.charAt(w_size)) { // SE A LETRA DA POSIÇÃO ATUAL DA MATRIZ FOR IGUAL À LETRA DA PALAVRA QUE ESTÁ À PROCURA, NA POSIÇÃO DO TAMANHO ATUAL DA PALAVRA QUE ESTÁ A SER CONSTRUÍDA RECURSIVAMENTE
				w_temp = word + String.valueOf(m[y][x]);

				// VERIFICAÇÃO SE A PALAVRA CONSTRUIDA ATÉ AQUI É A PALAVRA DESEJADA
				if (w_temp.equals(search)) {
					// AO SE VERIFICAR, ADIÇÃO DOS DETALHES NA ESTRUTURA DE DADOS E TÉRMINO DO CICLO
					palavras.get(search).add(String.valueOf(search.length()));
					palavras.get(search).add((String.valueOf(initial_y) + "," + String.valueOf(initial_x)));
					palavras.get(search).add(String.valueOf(move));
					return;

				}
				int w_temp_size = w_temp.length();

				// VERIFICAÇÕES, CONSOANTE O TAMANHO DA PALAVRA QUE ESTÁ A SER PROCURADA, SE ESTA PODE ESTAR NA SOPA DE LETRAS NA DIREÇÃO DE MOVIMENTO EM QUESTÃO, TENDO EM CONTA O TAMANHO DA SOPA DE LETRAS
				// A PESQUISA SÓ SEGUE A DIREÇÃO DE MOVIMENTO DEFINIDA ANTERIORMENTE
				if (x - (search.length() - w_temp_size) >= 0 && move == Move.left) {
					search_word(m, w_temp, x - 1, y, Move.left, search, initial_x, initial_y);
				}

				else if (x + (search.length() - w_temp_size) <= c && move == Move.right) {
					search_word(m, w_temp, x + 1, y, Move.right, search, initial_x, initial_y);
				}

				else if (y - (search.length() - w_temp_size) >= 0 && move == Move.up) {
					search_word(m, w_temp, x, y - 1, Move.up, search, initial_x, initial_y);
				}

				else if (y + (search.length() - w_temp_size) <= l && move == Move.down) {
					search_word(m, w_temp, x, y + 1, Move.down, search, initial_x, initial_y);
				}

				else if (x - (search.length() - w_temp_size) >= 0 && y - (search.length() - w_temp_size) >= 0
						&& move == Move.upleft) {
					search_word(m, w_temp, x - 1, y - 1, Move.upleft, search, initial_x, initial_y);
				}

				else if (x - (search.length() - w_temp_size) >= 0 && y + (search.length() - w_temp_size) <= l
						&& move == Move.downleft) {
					search_word(m, w_temp, x - 1, y + 1, Move.downleft, search, initial_x, initial_y);
				}

				else if (y + (search.length() - w_temp_size) <= l && x + (search.length() - w_temp_size) <= c
						&& move == Move.downright) {
					search_word(m, w_temp, x + 1, y + 1, Move.downright, search, initial_x, initial_y);
				}

				else if (y - (search.length() - w_temp_size) >= 0 && x + (search.length() - w_temp_size) <= c
						&& move == Move.upright) {
					search_word(m, w_temp, x + 1, y - 1, Move.upright, search, initial_x, initial_y);
				}
			}
		}
	}
}
