
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Familia> families = new ArrayList<Familia>();

	public static void main(String args[]) {
		// No caso de não ser introduzido nenhum ficheiro de comandos
		if (args.length == 0) {
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("Command: ");
				String[] command = sc.nextLine().split(" ");
				run(command);

			}
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

		} else {
			System.err.println("Entry unknown!");
			System.exit(0);
		}

	}

	private static void run(String[] command) {
		switch (command[0]) {
		case "load":
			if (command.length == 2) {
				try {
					File file = new File("./" + command[1]);
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						if (String.valueOf(line.charAt(0)).equals(">")) {
							continue;
						} else {
							String[] info = line.split("[- ]");
							if (Character.isLetter(info[0].charAt(0))) {
								// Se começar com o nome e depois a o nº de intervalo
								add(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]));
							} else {
								// Se começar com o nº de intervalo e depois o nome
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
			// code block
			break;
		case "add":
			if (command.length == 4 && Character.isDigit(command[2].charAt(0))
					&& Character.isDigit(command[3].charAt(0))) {
				add(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
			} else {
				System.err.println("Options incorrect for Add!");
				break;
			}
			break;
		case "remove":
			if (command.length == 2) {
				remove(command[1]);

			} else {
				System.err.println("Options incorrect for Add!");
				break;
			}
			break;
		case "list":
			break;
		case "lookup":
			if (command.length == 2) {
				lookup(command[1]);

			} else {
				System.err.println("Options incorrect for Add!");
				break;
			}

			break;
		case "clear":
			families.clear();
			System.gc(); // Corre o garbage colector para eliminar objetos e afins inalcançáveis
			System.out.println("Data cleaned!");
			break;
		case "quit":
			System.out.println("\nQuitting the program!");
			System.exit(0);
			break;
		default:
			System.err.println("Command unknown!");
			break;
		}

	}

	private static void add(String name, int pos_in, int pos_fin) {
		boolean new_family = true;
		Pessoa p = new Pessoa(name);
		if (families.isEmpty()) {
			Familia f = new Familia(p, pos_in, pos_fin);
			families.add(f);
			System.out.println("\n" +name + " adicionado(a) com sucesso à familia " + pos_in + "-" + pos_fin);
		} else {
			for (Familia f : families) {
				int status = f.addMembro(p, pos_in, pos_fin);
				if (status == 0) {
					// Foi adicionado com sucesso
					new_family = false;
					break;
				} else if (status == 2) {
					// O nome já existe
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
	}

	private static Boolean remove(String name) {
		boolean found = false;

		for (Familia f : families) {
			for (Pessoa p : f.getMembros()) {
				if (p.getName().equals(name)) {
					found = true;
					f.getMembros().remove(p);
					System.out.println(
							"\n"+name + " removido(a) com sucesso à familia " + f.getPos_in() + "-" + f.getPos_fin());
					return true;

				}
			}
		}

		if (!found) {
			System.err.println("\nMembro não existe!");
		}
		return false;
	}

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
}
