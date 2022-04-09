package br.com.joaofzm15.yugiohstats.backEnd.entitites.enums;

public enum OppDeck {
	
	ALL_DECKS (1000),
	Unknown(1),
	Zoodiac_tri_brigade(2),
	Drytron(3),
	Adamancipator(4),
	Virtual_world(5),
	Sky_striker(7),
	Eldlich(6),
	Numeron(8),
	Altergeist(9),
	Code_talker(10),
	Cyber_dragon(11),
	Dragonmaid(12),
	Dinos(13),
	DDD(14),
	Dragon_link(15),
	Endymion(16),
	Fluffal(17),
	Heros(18),
	Ignister(19),
	Invoked_dogmatika_shaddoll(20),
	Livetwin(21),
	Lyrilusc(22),
	Lyrilusc_tri_brigade(23),
	Phantom_knights(24),
	Prank_kids(25),
	Thunder_dragon(26),
	Traptrix(27),
	True_draco(28),
	Tri_brigade(29),
	FAKE_DECK(30);	
	
	private int code;

	private OppDeck(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OppDeck returnOppDeckThatCorespondsToTheParameterInteger(int code) {
		for (OppDeck value : OppDeck.values()) {
			if (value.code == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OppDeck code");
	}

}
