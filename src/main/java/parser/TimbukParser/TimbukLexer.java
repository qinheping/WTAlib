// Generated from Timbuk.g4 by ANTLR 4.5.3
package parser.TimbukParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TimbukLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WS=11, SYMBOL=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "WS", "DIGIT", "INTEGER", "SYMBOLCC", "SYMBOL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Ops'", "':'", "'Automaton'", "'States'", "'Final States'", "'Transitions'", 
		"'('", "','", "')'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"SYMBOL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TimbukLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Timbuk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\6\f\\\n\f\r\f\16\f]\3\f\3\f\3\r\3\r\3\16\5\16e\n\16\3\16\6\16h\n"+
		"\16\r\16\16\16i\3\17\5\17m\n\17\3\20\3\20\6\20q\n\20\r\20\16\20r\2\2\21"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\2\37"+
		"\16\3\2\5\5\2\13\f\16\17\"\"\3\2\62;\f\2##&(,-/\61>AC]_ac|~~\u0080\u0080"+
		"u\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\37\3\2\2\2\3!\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t\61\3\2\2\2\138\3\2\2"+
		"\2\rE\3\2\2\2\17Q\3\2\2\2\21S\3\2\2\2\23U\3\2\2\2\25W\3\2\2\2\27[\3\2"+
		"\2\2\31a\3\2\2\2\33d\3\2\2\2\35l\3\2\2\2\37p\3\2\2\2!\"\7Q\2\2\"#\7r\2"+
		"\2#$\7u\2\2$\4\3\2\2\2%&\7<\2\2&\6\3\2\2\2\'(\7C\2\2()\7w\2\2)*\7v\2\2"+
		"*+\7q\2\2+,\7o\2\2,-\7c\2\2-.\7v\2\2./\7q\2\2/\60\7p\2\2\60\b\3\2\2\2"+
		"\61\62\7U\2\2\62\63\7v\2\2\63\64\7c\2\2\64\65\7v\2\2\65\66\7g\2\2\66\67"+
		"\7u\2\2\67\n\3\2\2\289\7H\2\29:\7k\2\2:;\7p\2\2;<\7c\2\2<=\7n\2\2=>\7"+
		"\"\2\2>?\7U\2\2?@\7v\2\2@A\7c\2\2AB\7v\2\2BC\7g\2\2CD\7u\2\2D\f\3\2\2"+
		"\2EF\7V\2\2FG\7t\2\2GH\7c\2\2HI\7p\2\2IJ\7u\2\2JK\7k\2\2KL\7v\2\2LM\7"+
		"k\2\2MN\7q\2\2NO\7p\2\2OP\7u\2\2P\16\3\2\2\2QR\7*\2\2R\20\3\2\2\2ST\7"+
		".\2\2T\22\3\2\2\2UV\7+\2\2V\24\3\2\2\2WX\7/\2\2XY\7@\2\2Y\26\3\2\2\2Z"+
		"\\\t\2\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\f\2"+
		"\2`\30\3\2\2\2ab\t\3\2\2b\32\3\2\2\2ce\7/\2\2dc\3\2\2\2de\3\2\2\2eg\3"+
		"\2\2\2fh\5\31\r\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\34\3\2\2\2"+
		"km\t\4\2\2lk\3\2\2\2m\36\3\2\2\2nq\5\35\17\2oq\5\31\r\2pn\3\2\2\2po\3"+
		"\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s \3\2\2\2\t\2]dilpr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}