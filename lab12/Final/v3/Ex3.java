package lab12.v3;

public class Ex3 {
	
	//Devido à escassez de tempo derivada das várias entregas que temos, não conseguimos resolver este exercício esta semana,
	//tentaremos para a próxima

public static void main(String[] args) {
	Ship s = new Ship("BelaRia", 200);
	s.setOwner(new Owner("Manuel")); 
	s.setPassageiros(new String[]()“Manuel”, “Amilcar”});
	System.out.println(PDSSerializer.fromObject(s));

}
