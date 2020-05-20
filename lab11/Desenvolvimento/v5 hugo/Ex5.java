package lab11.v5;

public class Ex5 {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Required argumetns not passed!");
			System.out.println(
					"\nUsage(after compilation):\n	java Ex5 [-option] path\n	Option:\n		-r: Includes the size of the directories inside the one passed");
			System.exit(0);
		}

		if (args.length == 1) {
			new FileWalker().Walker(args[0], false);

		} else if (args.length == 2) {
			if (args[0].equals("-r")) {
				new FileWalker().Walker(args[1], true);
			} else {
				usage();
			}

		} else {
			usage();
		}

	}

	private static void usage() {
		System.err.println("Error!");
		System.out.println(
				"\nUsage(after compilation):\n	java Ex5 [-option] path\n	Option:\n		-r: Includes the size of the directories inside the one passed");
		System.exit(0);
	}

}
