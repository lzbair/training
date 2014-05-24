package path.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class CatTest {

	 @Test
	    public void test() {
	        Cat cat = new Cat();
	        assertEquals("*", cat.path());
	        cat.leap();
	        assertEquals("*.*", cat.path());
	        cat.leap();
	        assertEquals("*.*..*", cat.path());
	        cat.leap();
	        assertEquals("*.*..*...*", cat.path());
	        cat.leap();
	        assertEquals("*.*..*...*....*", cat.path());
	        cat.leap();
	        assertEquals("*.*..*...*....*....*", cat.path());
	        cat.leap();
	        cat.leap();
	        assertEquals("*.*..*...*....*....*....*....*", cat.path());
	    }

}
