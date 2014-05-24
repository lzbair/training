package path.io;

public class FourthStep implements Step {

	@Override
	public Step next() {
		return  this;
	}

	@Override
	public String draw() {
		return "....*";
	}

}
