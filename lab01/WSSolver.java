import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class WSSolver {
	private static LinkedHashMap<String, LinkedList<String>> palavras = new LinkedHashMap<String, LinkedList<String>>();
	private static char[][] sopa = new char[50][50];// ver esta merda depois
	private static int l = 0;
	private static int c = 0;
	private static boolean timing = false;

	enum Move {
		initial, left, right, up, down, upleft, downleft, downright, upright
	}

	public static void main(final String[] args) {
		double startTime = 0;
		if (args.length == 2) {
			if (args[0].equals("-timing")) {
				timing = true;
				startTime = System.currentTimeMillis();
				// long estimatedTime = System.currentTimeMillis() - startTime;
				if (args[1].substring(args[1].length() - 3).equals("txt")) {
					readfile(args[1]);
				} else {
					System.err.println("Ficheiro não suportado!");
					System.exit(0);
				}
			}
		} else if (args.length == 1) {
			if (args[0].substring(args[0].length() - 3).equals("txt")) {
				readfile(args[0]);
			} else {
				System.err.println("Ficheiro não suportado!");
				System.exit(0);
			}
		} else {
			System.err.println("Opções incorretas!");
			System.exit(0);
		}

		for (final String search : palavras.keySet()) {
			search_word(sopa, "", 0, 0, Move.initial, search, -1, -1);
		}

		print(startTime);

	}

	private static void print(final double startTime) {
		if (timing) {
			final double estimatedTime = (System.currentTimeMillis() - startTime) / 1000;
			System.out.format("Elapsed time (secs): %-1.3f\n", estimatedTime);
		}
		final int max_word_size = maxSize(palavras.keySet());
		for (final String palavra : palavras.keySet()) {
			if (palavras.get(palavra).size() == 0) {
				System.err.println("Palavra " + palavra + " não encontrada!");
			} else if (palavras.get(palavra).size() > 4) {
				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(1),
						palavras.get(palavra).get(2), palavras.get(palavra).get(3));
				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(5),
						palavras.get(palavra).get(6), palavras.get(palavra).get(7));
			} else {
				System.out.format("%-" + max_word_size + "s\t%-2s\t%-5s\t%-8s\n", palavra, palavras.get(palavra).get(1),
						palavras.get(palavra).get(2), palavras.get(palavra).get(3));
			}

		}

	}

	private static void readfile(final String filename) {
		try {
			final File file = new File(filename);
			final Scanner sc = new Scanner(file);
			int lastc = 0;
			while (sc.hasNextLine()) {
				final String line = sc.nextLine().trim();

				if (l == 0) {
					lastc = line.length();
				}
				// verificar se não é maior que 50x50
				if (line.length() > 50 || l > 50) {
					System.err.println("Maior que 50x50");
					System.exit(0);
				}

				final boolean hasLowercase = !line.equals(line.toUpperCase());
				if (hasLowercase) {
					// Palavras que procuramos
					final String[] lista = line.toUpperCase().split("[,; ]");

					for (final String word : lista) {
						// Verificar se as palavras são maiores que 4
						if (word.length() < 4) {
							System.err.println("Palavras menores que 4!");
							System.exit(0);
						}
						// Verificar se as palavras são alfanuméricas
						else if (!word.matches("[a-zA-Z0-9]+")) {
							System.err.println("Palavras não alfanuméricas!");
							System.exit(0);
						}
					}

					for (final String palavra : lista) {
						for (final String palavra2 : lista) {
							if (palavra.contains(palavra2) && !palavra.equals(palavra2)) {
								System.err.println(
										"A lista de palavras contém palavras duplicadas ou frases redundantes!");
								System.exit(0);
							}
						}
						final LinkedList<String> details = new LinkedList<String>();
						palavras.put(palavra, details);
					}

				} else {
					// criação de matrix
					c = 0;
					for (final char caracter : line.toCharArray()) {
						sopa[l][c] = caracter;
						c++;
					}
					l++;
				}
				if (lastc != c) {
					System.err.println("Não é quadrado!");
					System.exit(0);
				}

			}
			if (lastc != c) {
				System.err.println("Não é quadrado!");
				System.exit(0);
			}
			sc.close();
		} catch (final IOException e) {
			e.printStackTrace();
			System.err.println("Erro a abrir o ficheiro!");
		}
	}

	private static void search_word(final char[][] m, final String word, final int x, final int y, final Move move,
			final String search, final int initial_x, final int initial_y) {
		String w_temp;
		final int w_size = word.length();

		if (move == Move.initial) {
			for (int k = y; k < l; k++) {
				for (int i = x; i < c; i++) {
					if (m[k][i] == search.charAt(w_size)) {
						w_temp = word + String.valueOf(m[k][i]);
						int w_temp_size = w_temp.length();
						if (i - (search.length() - w_temp_size) >= 0) {
							search_word(m, w_temp, i - 1, k, Move.left, search, i + 1, k + 1);
						}

						if (i + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, i + 1, k, Move.right, search, i + 1, k + 1);
						}

						if (k - (search.length() - w_temp_size) >= 0) {
							search_word(m, w_temp, i, k - 1, Move.up, search, i + 1, k + 1);
						}

						if (k + (search.length() - w_temp_size) <= l) {
							search_word(m, w_temp, i, k + 1, Move.down, search, i + 1, k + 1);
						}

						if (i - (search.length() - w_temp_size) >= 0 && k - (search.length() - w_temp_size) >= 0) {
							search_word(m, w_temp, i - 1, k - 1, Move.upleft, search, i + 1, k + 1);
						}

						if (i - (search.length() - w_temp_size) >= 0 && k + (search.length() - w_temp_size) <= l) {
							search_word(m, w_temp, i - 1, k + 1, Move.downleft, search, i + 1, k + 1);
						}

						if (k + (search.length() - w_temp_size) <= l && i + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, i + 1, k + 1, Move.downright, search, i + 1, k + 1);
						}

						if (k - (search.length() - w_temp_size) >= 0 && i + (search.length() - w_temp_size) <= c) {
							search_word(m, w_temp, i + 1, k - 1, Move.upright, search, i + 1, k + 1);
						}
					}
				}
			}

		} else {
			if (m[y][x] == search.charAt(w_size)) {
				w_temp = word + String.valueOf(m[y][x]);
				if (w_temp.equals(search)) {
					palavras.get(search).add(search);
					palavras.get(search).add(String.valueOf(search.length()));
					palavras.get(search).add((String.valueOf(initial_y) + "," + String.valueOf(initial_x)));
					palavras.get(search).add(String.valueOf(move));
					return;

				}
				int w_temp_size = w_temp.length();

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
		return;
	}

	private static int maxSize(final Set<String> lista) {
		int max = 0;
		for (final String x : lista) {
			if (x.length() > max) {
				max = x.length();
			}
		}
		return max;
	}
}
