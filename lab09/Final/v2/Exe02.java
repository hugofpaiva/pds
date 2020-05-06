import java.util.ArrayList;

import LAB9.v2.CollectionCommand.AddCommand;
import LAB9.v2.CollectionCommand.RemoveCommand;

public class Exe02 {
	public static void main(String[] args) {
		ArrayList<String> c = new ArrayList<>();
		AddCommand addCommand = new AddCommand(c);
        RemoveCommand removeCommand = new RemoveCommand(c);

        addCommand.execute("André");
        addCommand.execute("Hugo");
        addCommand.execute("O hugo é feio");

        System.out.println("Depois de 3 addComands a collection tem "+c.size() + " elementos");
        if(c.size()>1){
            System.out.println("c[0]: " + c.get(0));
            System.out.println("c[1]: " + c.get(1));
            System.out.println("c[2]: " + c.get(2));
        }

        addCommand.undo();
        System.out.println("enganei-me, afinal o hugo não é feio : " + c);

        removeCommand.execute("André");
        System.out.println("e o andré é demasiado bom para estar nesta lista: " + c);

        removeCommand.undo();
        System.out.println("Afinal o hugo precisa do andré nesta lista: " + c);
	}

}
