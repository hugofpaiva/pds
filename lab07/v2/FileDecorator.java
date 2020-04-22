package LAB7.v2;

public abstract class FileDecorator implements FileInterface{
	protected FileInterface f;
	public FileDecorator(FileInterface file) {
		this.f=file;
	}

	@Override
	public boolean hasNext() {
		return this.f.hasNext();
	}

	@Override
	public String next() {
		if(hasNext()) {
			return this.f.next();
		}
		return null;
	}

}
