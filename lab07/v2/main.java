public class main {

	public static void main(String[] args) {
		String filename="";
		if(args.length<1) {
			System.err.println("Um argumento de entrada deve ser o nome do ficheiro");
			System.exit(1);
		}else {
			filename=args[0];
		}
		
		FileInterface reader = new TextReader(filename);
        System.out.println(reader.next());

        reader = new CoderFilter(new TextReader(filename));
        System.out.println(reader.next());

        reader = new ReverseFilter(new TermFilter(new TextReader(filename)));
        reader.next();
        System.out.println(reader.next());
        
	}

}
