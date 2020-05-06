import java.util.ArrayList;
import java.util.Collection;

abstract class CollectionCommand<T> {
	protected ArrayList<T> stack;
    protected Collection<T> collection;
    
	CollectionCommand(Collection<T> c) {
		this.collection = c;
        this.stack = new ArrayList<>();
	}
	static public class AddCommand<T> extends CollectionCommand<T>{
		public AddCommand(Collection<T> c){
			super(c);
	    } 

	    public boolean execute(T e){
	        if(collection.add(e)) {
	        	stack.add(e);
	        }else {
	        	return false;
	        }
	        return true;
	    }

	    public boolean undo(){
	        if(collection.remove(stack.get(stack.size()-1))) {
	        	stack.remove(stack.size()-1);
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	}
	
	static public class RemoveCommand<T> extends CollectionCommand<T>{
		public RemoveCommand(Collection<T> c){
			super(c);
	    } 

	    public boolean execute(T e){
	        if(collection.remove(e)) {
	        	stack.add(e);
	        }else {
	        	return false;
	        }
	        return true;
	    }

	    public boolean undo(){
	        if(collection.add(stack.get(stack.size()-1))) {
	        	stack.remove(stack.size()-1);
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	}
}
