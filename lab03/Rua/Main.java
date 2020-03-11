
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static ArrayList<Familia> families = new ArrayList<Familia>(); // LISTA COM TODAS AS FAMÍLIAS

	public static void main(String args[]) {
		// NO CASO DE NÃO SER INTRODUZIDO NENHUM FICHEIRO DE COMANDOS COMO ARGUMENTO
		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Command: ");
				String[] command = sc.nextLine().split(" ");
				run(command);
			}
			// NO CASO DE HAVER UM ARGUMENTO (FICHEIRO DE COMANDOS)
		} else if (args.length == 1) {
			try {
				File file = new File("./" + args[0]);
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					run(sc.nextLine().split(" "));
				}
				sc.close();
			} catch (IOException e) {
				System.err.println("File does not exist!");
				System.exit(0);
			}
			// NO CASO DE HAVEREM MAIS DE 1 ARGUMENTO (CHAMADA INVÁLIDA)
		} else {
			System.err.println("Entry unknown!");
			System.exit(0);
		}
	}

	private static void run(String[] command) {
		// PROCESSAMENTO DE COMANDOS
		switch (command[0].toLowerCase()) {
			case "load":
				// VERIFICA SE O COMANDO É VÁLIDO
				if (command.length == 2) {
					try {
						File file = new File("./" + command[1]);
						Scanner sc = new Scanner(file);
						while (sc.hasNextLine()) {
							String line = sc.nextLine();
							if (String.valueOf(line.charAt(0)).equals(">")) {
								continue;
							} else {
								String[] info = line.split("[- ]"); // SEPARA A LINHA POR (-) OU (ESPAÇO)
								// VERIFICA SE COMEÇA PELO INTERVALO OU PELO NOME DA PESSOA
								if (Character.isLetter(info[0].charAt(0))) {
									add(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));
								} else if (Character.isDigit(info[0].charAt(0))) {
									add(info[2], Integer.parseInt(info[0]), Integer.parseInt(info[1]));
								}
							}
						}
						sc.close();
					} catch (IOException e) {
						System.err.println("File does not exist!");
						break;
					}
				} else {
					System.err.println("Load option needs a file!");
					break;
				}
				break;
			case "map":
				map();
				break;
			case "add":
				// VERIFICA SE O COMANDO É CHAMADO CORRETAMENTE
				if (command.length == 4 && Character.isDigit(command[2].charAt(0))
						&& Character.isDigit(command[3].charAt(0))) {
					add(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
				} else {
					System.err.println("Options incorrect for add!");
					break;
				}
				break;
			case "remove":
				// VERIFICA SE O COMANDO É CHAMADO CORRETAMENTE
				if (command.length == 2) {
					remove(command[1]);
				} else {
					System.err.println("Options incorrect for remove!");
					break;
				}
				break;
			case "list":
				list();
				break;
			case "lookup":
				// VERIFICA SE O COMANDO É CHAMADO CORRETAMENTE
				if (command.length == 2) {
					lookup(command[1]);
				} else {
					System.err.println("Options incorrect for lookup!");
					break;
				}
				break;
			case "clear":
				families.clear();
				System.gc(); // CORRE O GARBAGE COLECTOR PARA ELIMINAR OBJETOSE AFINS INALCANÇAVEIS
				System.out.println("Data cleaned!");
				break;
			case "quit":
				System.out.println("\nQuitting the program!");
				System.exit(0);
				break;
			default: // CHAMADO SE O COMANDO NÃO EXISTE
				System.err.println("Command unknown!");
				break;
		}
	}

	// ADICIONA A PESSA PESSOA A UMA FAMILIA (EXISTENTE OU NOVA)
	private static void add(String name, int pos_in, int pos_fin) {
		boolean new_family = true; // VARIAVEL QUE CONTROLA SE É NECESSÁRIO CRIAR UMA FAMÍLIA NOVA PARA ESTA PESSOA
		Pessoa p = new Pessoa(name);
		if (pos_fin >= pos_in && pos_in > 0) {
			if (families.isEmpty()) {
				Familia f = new Familia(p, pos_in, pos_fin);
				families.add(f);
				System.out.println("\n" + name + " adicionado(a) com sucesso à familia " + pos_in + "-" + pos_fin);
			} else {
				for (Familia f : families) {
					int status = f.addMembro(p, pos_in, pos_fin);
					// VERIFICA SE A PESSOA FOI ADICIONADA COM SUCESSO
					if (status == 0) {
						new_family = false;
						break;
					} else if (status == 2) { // VERIFICA SE O NOME JÁ EXISTE
						new_family = false;
						break;
					}
				}

				if (new_family) {
					Familia f = new Familia(p, pos_in, pos_fin);
					families.add(f);
					System.out.println("\n" + name + " adicionado(a) com sucesso à familia " + pos_in + "-" + pos_fin);

				}
			}
		} else {
			System.err.println("\nSecond number is lower than the first or the first number is equal or lower than zero!");
		}
	}

	// FUNÇÃO DE REMOÇÃO DE UMA PESSOA
	private static Boolean remove(String name) {
		boolean found = false;

		for (Familia f : families) {
			for (Pessoa p : f.getMembros()) {
				if (p.getName().equals(name)) {
					found = true;
					f.getMembros().remove(p);
					// REMOVE A FAMÍLIA SE NÃO EXISTIR NINGUEM
					if (f.getMembros().isEmpty()) {
						families.remove(f);
					}
				}
				System.out.println(
						"\n" + name + " removido(a) com sucesso à familia " + f.getPos_in() + "-" + f.getPos_fin());
				return true;

			}
		}

		if (!found) {
			System.err.println("\nMembro não existe!");
		}
		return false;
	}

	// FUNÇAO QUE APRESENTA AS POSIÇÕES DOS TERRENOS DE UMA FAMÍLIA, BEM COMO OS
	// SEUS MEMBROS, PROCURANDO PELO NOME DE UMA PESSOA
	private static void lookup(String name) {
		System.out.println("\nLookup do membro " + name);
		boolean found = false;
		for (Familia f : families) {
			for (Pessoa p : f.getMembros()) {
				if (p.getName().equals(name)) {
					found = true;
					System.out.print(f.getPos_in() + " " + f.getPos_fin() + " : ");
					for (Pessoa person : f.getMembros()) {
						System.out.print(person.getName() + " ");
					}
					System.out.println("\n");
				}
			}
		}
		if (!found) {
			System.err.println("Membro não existe!");
		}
	}

	private static void list() {
		if (!families.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			for (Familia f : families) {
				for (Pessoa p : f.getMembros()) {
					list.add(p.getName() + " " + f.getPos_in() + " " + f.getPos_fin());
				}
			}
			java.util.Collections.sort(list);
			System.out.println();
			for (String member : list) {
				System.out.println(member);
			}
			System.out.println();

		} else {
			System.err.println("No members!");
		}
	}

	private static void map() {
		if (!families.isEmpty()) {
			int counter = 0; // VARIÁVEL QUE CONTA O NUMERO DE FAMÍLIAS
			int[] values = maxNamePos();
			System.out.printf("%6s%" + (values[0] + 1) + "s", "FAMILY", "NAME");
			for (int i = values[1]; i <= values[2]; i++) {
				System.out.printf("%4d", i);
			}
			System.out.printf("\n");

			Collections.sort(families, Collections.reverseOrder());

			for (Familia f : families) {
				counter++;
				int countMembros = 0; // VARIÁVEL QUE CONTA O NUMERO DE MEMBROS DE UMA FAMÍLIA
				for (Pessoa p : f.getMembros()) {
					countMembros++;
					System.out.printf("%6d%" + (values[0] + 1) + "s", counter, p.getName());
					for (int i = values[1]; i <= values[2]; i++) {
						if (i >= f.getPos_in() && i <= f.getPos_fin()) {
							System.out.printf("%4s", "X");
						} else {
							System.out.printf("%4s", "");
						}
					}

					// IMPEDIR QUE SEJAM COLOCADAS LINHAS (EM BRANCO) A MAIS
					if (countMembros != f.countMembros()) {
						System.out.printf("\n");
					}
				}
				System.out.printf("\n");
			}

		} else {
			System.err.println("No members!");
		}
	}

	// FUNÇÃO QUE RETORNA O MAIOR TAMANHO ENCONTRADO NO NOME DE UMA PESSOA
	private static int[] maxNamePos() {
		int[] values = new int[3];
		values[0] = 0; // TAMANHO MAXIMO DE UM NOME
		values[1] = Integer.MAX_VALUE; // POSIÇÃO INICIAL
		values[2] = 0; // POSIÇÃO FINAL
		for (Familia f : families) {
			if (f.getPos_in() < values[1]) {
				values[1] = f.getPos_in();
			}
			if (f.getPos_fin() > values[2]) {
				values[2] = f.getPos_fin();
			}
			for (Pessoa p : f.getMembros()) {
				if (values[0] < p.getName().length()) {
					values[0] = p.getName().length();
				}

			}
		}
		return values;

	}

}
