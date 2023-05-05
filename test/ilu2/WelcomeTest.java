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
		assertNotEquals("Hello, ", Welcome.welcome(" "));
		assertNotEquals("Hello, ", Welcome.welcome(null));
		assertNotEquals(" ", Welcome.welcome(" "));
	}

	@Test
	void EX_3() {
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
		assertNotEquals("Hello, JERRY", Welcome.welcome("JERRY"));
		assertNotEquals("Hello, Jerry", Welcome.welcome("JERRY"));
		assertNotEquals("HELLO, Jerry !", Welcome.welcome("JERRY"));
		assertNotEquals("HELLO, Jerry", Welcome.welcome("JERRY"));
	}
	
	@Test
	void EX_4() {
		assertEquals("Hello, Amy and Bob", Welcome.welcome("amy,bob"));
		assertEquals("Hello, Amy and Bob", Welcome.welcome("amy, bob"));
		assertNotEquals("Hello, amy, bob", Welcome.welcome("amy,bob"));
		assertNotEquals("Hello, amy and bob", Welcome.welcome("amy, bob"));
		assertNotEquals("HELLO, AMY AND BOB !", Welcome.welcome("amy, bob"));
	}
	
	@Test
	void EX_5() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob,jerry"));
		assertNotEquals("Hello, Amy, bob, jerry", Welcome.welcome("Amy, bob, jerry"));
		assertNotEquals("Hello, Amy, Bob, Jerrr", Welcome.welcome("Ay, bob, jerry"));
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy, Bob, Jerry"));
		assertNotEquals("HELLO, AMY, BOB AND JERRY !", Welcome.welcome("Amy, bob, jerry"));
	}
	
	@Test
	void EX_6() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy, BOB, Jerry"));
		assertNotEquals("Hello, Amy, BOB and Jerry", Welcome.welcome("Amy, BOB, Jerry"));
		assertNotEquals("Hello, BOB. AND HELLO Amy AND Jerry !", Welcome.welcome("Amy, BOB, Jerry"));
	}
	
	@Test
	void EX_7() {
		System.out.println("EX7\n"); 
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, amy, jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO AMY AND JACK !", Welcome.welcome("bob, AMY, jerry, JACK"));
		assertNotEquals("Hello, Bob, AMY, Jerry and Jack", Welcome.welcome("bob, AMY, jerry, JACK"));
		
	}
	
	@Test
	void EX_8() {
		System.out.println("EX8\n");
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob        , amy    "));
		assertEquals("Hello, Bob and Amy", Welcome.welcome("      bob,        amy"));
		assertEquals("Hello, Bob and Amy", Welcome.welcome("    bob   ,      amy      "));
		assertNotEquals("Hello,      Bob and      Amy", Welcome.welcome("     bob,     amy"));
	}
}
