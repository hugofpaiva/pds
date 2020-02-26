import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class WSSolver {
	private static LinkedHashMap<String, LinkedList<String>> palavras = new LinkedHashMap<String, LinkedList<String>>(); // Estrutura de dados que guarda a palavra a ser procurada e os respetivos detalhes relativos à sopa de letras
	private static char[][] matrix_soup = new char[50][50]; // Matriz onde vai ser guardada a sopa de letras
	private static int l = 0; // Número de linhas da matriz (sopa de letras)
	private static int c = 0; // Número de colunas da matriz (sopa de letras)
	private static boolean timing = false; // Flag para verificar se é necessário ter em conta o tempo de execução
	private static double startTime = 0; // Hora a que o programa foi iniciado 

	enum Move {
		initial, left, right, up, down, upleft, downleft, downright, upright
	}

	public static void main(String[] args) {
		// Verificação das opções de entrada
		if (args.length == 2) {
			if (args[0].equals("-timing")) {
				// Se é introduzida a opção de visualização de tempo
				timing = true;
				startTime = System.currentTimeMillis();
				if (args[1].substring(args[1].length() - 3).equals("txt")) { // Verificação se é um ficheiro .txt
					readfile(args[1]);
				} else {
					System.err.println("Ficheiro não suportado!");
					System.exit(0);
				}
			}
		} else if (args.length == 1) {
			// Se é apenas introduzido o ficheiro de texto
			if (args[0].substring(args[0].length() - 3).equals("txt")) { // Verificação se é um ficheiro .txt
				readfile(args[0]);
			} else {
				System.err.println("Ficheiro não suportado!");
				System.exit(0);
			}
		} else {
			System.err.println("Opções incorretas!");
			System.exit(0);
		}

		// Procura recursiva por cada uma das palavras pretendidas
		for (String search : palavras.keySet()) {
			search_word(matrix_soup, "", 0, 0, Move.initial, search, -1, -1);
		}

		// Impressão dos resultados
		print();

	}

	private static void print() {
		// Se a opção de mostrar o tempo foi introduzida
		if (timing) {
			double estimatedTime = (System.currentTimeMillis() - startTime) / 1000;
			System.out.format("Elapsed time (secs): %-1.3f\n", estimatedTime);
		}

		int max_word_size = maxSize(palavras.keySet()); // Tamanho máximo de uma palavra do conjunto de palavras a ser procurado para uma impressão dos resultados correta

		for (String palavra : palavras.keySet()) {
			if (palavras.get(palavra).size() == 0) {
				System.err.println("Palavra " + palavra + " não encontrada!");

			} else if (palavras.get(palavra).size() > 3) {
				// Para o caso de palavras capicuas
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
			// Leitura do Ficheiro
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			int lastc = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();

				if (l == 0) {
					lastc = line.length(); // Tamanho da linha anterior
				}
				// Verificar se não é maior que 50x50
				if (line.length() > 50 || l > 50) {
					System.err.println("Maior que 50x50");
					System.exit(0);
				}

				boolean hasLowercase = !line.equals(line.toUpperCase()); // Verificação se as letras são minúsculas
				if (hasLowercase) {
					// Palavras que procuramos
					String[] lista = line.toUpperCase().split("[,; ]");

					for (String palavra : lista) {
						// Verificar se as palavras são maiores que 4
						if (palavra.length() < 4) {
							System.err.println("Palavras menores que 4!");
							System.exit(0);
						}
						// Verificar se as palavras são alfanuméricas
						else if (!palavra.matches("[a-zA-Z0-9]+")) {
							System.err.println("Palavras não alfanuméricas!");
							System.exit(0);
						}
						// Verificar se as palavras contém palavras duplicadas ou redundantes
						for (String palavra2 : lista) {
							if (palavra.contains(palavra2) && !palavra.equals(palavra2)) {
								System.err.println(
										"A lista de palavras contém palavras duplicadas ou frases redundantes!");
								System.exit(0);
							}
						}
						// Criação da estrutura de dados para guardar informações de cada palavras
						LinkedList<String> details = new LinkedList<String>();
						palavras.put(palavra, details);
					}
				} else {
					// Criação da matrix (quando as letras são maiúsculas)
					c = 0;
					for (char caracter : line.toCharArray()) {
						matrix_soup[l][c] = caracter;
						c++;
					}
					l++;
				}
				if (lastc != c) { // Verificação se o tamanho da linha anterior é o mesmo que o desta linha, necessário para a matriz ser quadrada
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
		String w_temp; // Palavra a ser enviada para o próximo ciclo da recursividade se nenhuma verificação falhar

		int w_size = word.length(); // Tamanho atual da palavra que está a ser construída recursivamente

		if (move == Move.initial) { // Quando a função é executada a primeira vez e não existe direção de movimento definido

			// Percorrer a matriz durante a primeira execução da função
			for (int yy = y; yy < l; yy++) {

				for (int xx = x; xx < c; xx++) {

					if (m[yy][xx] == search.charAt(w_size)) { // Se a letra da posição atual da matriz for igual à letra da palavra que está à procura, na posição do tamanho atual da palavra que está a ser construída recursivamente
						w_temp = word + String.valueOf(m[yy][xx]); 
						int w_temp_size = w_temp.length();

						// Verificações, consoante o tamanho da palavra que está a ser procurada, se esta pode estar na sopa de letras na direção de movimento em questão, tendo em conta o tamanho da sopa de letras
						if (xx - (search.length() - w_temp_size) >= 0) {
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
			if (m[y][x] == search.charAt(w_size)) { // Se a letra da posição atual da matriz for igual à letra da palavra que está à procura, na posição do tamanho atual da palavra que está a ser construída recursivamente
				w_temp = word + String.valueOf(m[y][x]);

				// Verificação se a palavra construida até aqui é a palavra desejada
				if (w_temp.equals(search)) {
					// Ao se verificar, adição dos detalhes na estrutura de dados e término do ciclo
					palavras.get(search).add(String.valueOf(search.length()));
					palavras.get(search).add((String.valueOf(initial_y) + "," + String.valueOf(initial_x)));
					palavras.get(search).add(String.valueOf(move));
					return;

				}
				int w_temp_size = w_temp.length();

				// Verificações, consoante o tamanho da palavra que está a ser procurada, se esta pode estar na sopa de letras na direção de movimento em questão, tendo em conta o tamanho da sopa de letras
				// A pesquisa só segue a direção de movimento definida anteriormente
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
