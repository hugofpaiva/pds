import java.util.ArrayList;

public class Bloco extends Figure {
	private ArrayList<Figure> children = new ArrayList<Figure>();
	private String property;

	public Bloco(String property) {
		this.property = property;
	}
	
	// Adicionar um bloco ou qualquer uma das outras figuras ao array
	public void add(Figure geofig) {
		children.add(geofig);
	}

	// Imprimir todos os itens no bloco em questão. Se existir blocos nos filhos, 
	//estes imprimem os seus filhos com 2 espaços no inicio.
	public void draw() {
		System.out.println(indent.toString() + print());
		indent.append("  ");
		for (Figure fig:children) {
			if (fig instanceof Bloco) {
				((Bloco) fig).draw();
			}else {
				System.out.println(indent.toString() + fig.print());
			}
		}
		indent.setLength(indent.length() - 2);
	}
	
	//Impressão da propriedade
	public String print() {
		return "Window " + property;

	}

}
