package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void EX_1() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
	}
	
	@Test
	void EX_2() {
		String result = "Hello, my friend";
		assertEquals(Welcome.welcome(null), result);
		assertEquals(result, Welcome.welcome(""));
		assertEquals(result, Welcome.welcome("   "));
	}

	@Test
	void EX_3() {
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
	}
	
	@Test
	void EX_4() {
		//TODO
	}
	
	@Test
	void EX_5() {
		//TODO
	}
	
	@Test
	void EX_6() {
		//TODO
	}
	
	@Test
	void EX_7() {
		//TODO
	}
	
	@Test
	void EX_8() {
		//TODO
	}
	
	@Test
	void EX_9() {
		//TODO
	}
	
	@Test
	void EX_10() {
		//TODO
	}
}
