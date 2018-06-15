// Generated from Timbuk.g4 by ANTLR 4.5.3
package parser.TimbukParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TimbukParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WS=11, SYMBOL=12, INTEGER=13;
	public static final int
		RULE_file = 0, RULE_label_list = 1, RULE_label_decl = 2, RULE_automaton = 3, 
		RULE_state_list = 4, RULE_state = 5, RULE_transition_list = 6, RULE_transition = 7;
	public static final String[] ruleNames = {
		"file", "label_list", "label_decl", "automaton", "state_list", "state", 
		"transition_list", "transition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Ops'", "':'", "'Automaton'", "'States'", "'Final States'", "'Transitions'", 
		"'('", "','", "')'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WS", 
		"SYMBOL", "INTEGER"
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

	@Override
	public String getGrammarFileName() { return "Timbuk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TimbukParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public Label_listContext label_list() {
			return getRuleContext(Label_listContext.class,0);
		}
		public AutomatonContext automaton() {
			return getRuleContext(AutomatonContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			label_list();
			setState(18);
			automaton();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Label_listContext extends ParserRuleContext {
		public List<Label_declContext> label_decl() {
			return getRuleContexts(Label_declContext.class);
		}
		public Label_declContext label_decl(int i) {
			return getRuleContext(Label_declContext.class,i);
		}
		public Label_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitLabel_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Label_listContext label_list() throws RecognitionException {
		Label_listContext _localctx = new Label_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_label_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(20);
				label_decl();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Label_declContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(TimbukParser.SYMBOL, 0); }
		public TerminalNode INTEGER() { return getToken(TimbukParser.INTEGER, 0); }
		public Label_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitLabel_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Label_declContext label_decl() throws RecognitionException {
		Label_declContext _localctx = new Label_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_label_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(SYMBOL);
			setState(27);
			match(T__1);
			setState(28);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AutomatonContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(TimbukParser.SYMBOL, 0); }
		public List<State_listContext> state_list() {
			return getRuleContexts(State_listContext.class);
		}
		public State_listContext state_list(int i) {
			return getRuleContext(State_listContext.class,i);
		}
		public Transition_listContext transition_list() {
			return getRuleContext(Transition_listContext.class,0);
		}
		public AutomatonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_automaton; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitAutomaton(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutomatonContext automaton() throws RecognitionException {
		AutomatonContext _localctx = new AutomatonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_automaton);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__2);
			setState(31);
			match(SYMBOL);
			setState(32);
			match(T__3);
			setState(33);
			state_list();
			setState(34);
			match(T__4);
			setState(35);
			state_list();
			setState(36);
			match(T__5);
			setState(37);
			transition_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_listContext extends ParserRuleContext {
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public State_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitState_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_listContext state_list() throws RecognitionException {
		State_listContext _localctx = new State_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_state_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(39);
				state();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(TimbukParser.SYMBOL, 0); }
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Transition_listContext extends ParserRuleContext {
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public Transition_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitTransition_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Transition_listContext transition_list() throws RecognitionException {
		Transition_listContext _localctx = new Transition_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_transition_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL) {
				{
				{
				setState(47);
				transition();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(TimbukParser.SYMBOL, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TimbukVisitor ) return ((TimbukVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_transition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(SYMBOL);
			setState(65);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(54);
				match(T__6);
				setState(55);
				state();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(56);
					match(T__7);
					setState(57);
					state();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(T__8);
				}
			}

			setState(67);
			match(T__9);
			setState(68);
			state();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\3"+
		"\7\3\30\n\3\f\3\16\3\33\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\7\6+\n\6\f\6\16\6.\13\6\3\7\3\7\3\b\7\b\63\n\b\f\b\16\b"+
		"\66\13\b\3\t\3\t\3\t\3\t\3\t\7\t=\n\t\f\t\16\t@\13\t\3\t\3\t\5\tD\n\t"+
		"\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2E\2\22\3\2\2\2\4\31\3\2\2"+
		"\2\6\34\3\2\2\2\b \3\2\2\2\n,\3\2\2\2\f/\3\2\2\2\16\64\3\2\2\2\20\67\3"+
		"\2\2\2\22\23\7\3\2\2\23\24\5\4\3\2\24\25\5\b\5\2\25\3\3\2\2\2\26\30\5"+
		"\6\4\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\5\3"+
		"\2\2\2\33\31\3\2\2\2\34\35\7\16\2\2\35\36\7\4\2\2\36\37\7\17\2\2\37\7"+
		"\3\2\2\2 !\7\5\2\2!\"\7\16\2\2\"#\7\6\2\2#$\5\n\6\2$%\7\7\2\2%&\5\n\6"+
		"\2&\'\7\b\2\2\'(\5\16\b\2(\t\3\2\2\2)+\5\f\7\2*)\3\2\2\2+.\3\2\2\2,*\3"+
		"\2\2\2,-\3\2\2\2-\13\3\2\2\2.,\3\2\2\2/\60\7\16\2\2\60\r\3\2\2\2\61\63"+
		"\5\20\t\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\17"+
		"\3\2\2\2\66\64\3\2\2\2\67C\7\16\2\289\7\t\2\29>\5\f\7\2:;\7\n\2\2;=\5"+
		"\f\7\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7"+
		"\13\2\2BD\3\2\2\2C8\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\f\2\2FG\5\f\7\2G\21"+
		"\3\2\2\2\7\31,\64>C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}