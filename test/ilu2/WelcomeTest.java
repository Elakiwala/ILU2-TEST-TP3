package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void EX_1() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
		assertEquals("Hello, Eva", Welcome.welcome("eva"));
		assertNotEquals("Hello, eva", Welcome.welcome("eva"));
		assertNotEquals("Hello, Eva, Martha", Welcome.welcome("eva, martha"));
	}
	
	@Test
	void EX_2() {
		String result = "Hello, my friend";
		assertEquals(Welcome.welcome(null), result);
		assertEquals(result, Welcome.welcome(""));
		assertEquals(result, Welcome.welcome("   "));
		assertNotEquals(result, Welcome.welcome("bob"));
	}

	@Test
	void EX_3() {
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
	}
	
	@Test
	void EX_4() {
		assertEquals("Hello, Amy and Bob", Welcome.welcome("amy,bob"));
	}
	
	@Test
	void EX_5() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob,jerry"));
	}
	
	@Test
	void EX_6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy, BOB, Jerry"));
	}
	
	@Test
	void EX_7() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, amy, jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO AMY AND JACK !", Welcome.welcome("bob, AMY, jerry, JACK"));
	}
	
	@Test
	void EX_8() {
		//TODOassertEquals("Hello, Bob and Amy", Welcome.welcome("bob        , amy    "));
	}
	
	@Test
	void EX_9() {
		//TODO assertEquals("Hello, Bob (x3), and Amy. AND HELLO JERRY (x2)", Welcome.welcome("bob, JERRY, amy, bob, JERYY, bob"));
	}
	
	@Test
	void EX_10() {
		//TODO assertEquals("Bob, Yoda, and Amy, Hello AND HELLO JERRY"));
		//assertEquals("Hello, Bob and Amy. AND YODA (x2) AND JERRY HELLO !", Welcome.welcome("bob, YODA, amy, JERRY, YODA"));
	}
}
