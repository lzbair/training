package path.io;

public class SecondStep implements Step {

	@Override
	public Step next() {
		return new ThirdStep();
	}

	@Override
	public String draw() {
		return "..*";
	}

}
