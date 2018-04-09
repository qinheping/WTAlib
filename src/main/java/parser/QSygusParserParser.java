// Generated from QSygusParser.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QSygusParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, WS=33, INTCONST=34, BVCONST=35, REALCONST=36, SYMBOL=37, QUOTEDLIT=38;
	public static final int
		RULE_start = 0, RULE_prog = 1, RULE_setLogicCmd = 2, RULE_logicPlus = 3, 
		RULE_logic = 4, RULE_setWeightCmd = 5, RULE_cmdPlus = 6, RULE_cmd = 7, 
		RULE_weightOptimizationCmd = 8, RULE_weightPair = 9, RULE_weightConstraintCmd = 10, 
		RULE_varDeclCmd = 11, RULE_sortDefCmd = 12, RULE_sortExpr = 13, RULE_boolConst = 14, 
		RULE_enumConst = 15, RULE_ecList = 16, RULE_symbolPlus = 17, RULE_setOptsCmd = 18, 
		RULE_optList = 19, RULE_symbolPairPlus = 20, RULE_symbolPair = 21, RULE_funDefCmd = 22, 
		RULE_funDeclCmd = 23, RULE_sortStar = 24, RULE_argList = 25, RULE_symbolSortPairStar = 26, 
		RULE_symbolSortPair = 27, RULE_term = 28, RULE_letTerm = 29, RULE_letBindingTermPlus = 30, 
		RULE_letBindingTerm = 31, RULE_termStar = 32, RULE_literal = 33, RULE_ntDefPlus = 34, 
		RULE_ntDef = 35, RULE_gTermPlus = 36, RULE_checkSynthCmd = 37, RULE_constraintCmd = 38, 
		RULE_synthFunCmd = 39, RULE_gTermWeighted = 40, RULE_literalPlus = 41, 
		RULE_gTerm = 42, RULE_letGTerm = 43, RULE_letBindingGTermPlus = 44, RULE_letBindingGTerm = 45, 
		RULE_gTermStar = 46;
	public static final String[] ruleNames = {
		"start", "prog", "setLogicCmd", "logicPlus", "logic", "setWeightCmd", 
		"cmdPlus", "cmd", "weightOptimizationCmd", "weightPair", "weightConstraintCmd", 
		"varDeclCmd", "sortDefCmd", "sortExpr", "boolConst", "enumConst", "ecList", 
		"symbolPlus", "setOptsCmd", "optList", "symbolPairPlus", "symbolPair", 
		"funDefCmd", "funDeclCmd", "sortStar", "argList", "symbolSortPairStar", 
		"symbolSortPair", "term", "letTerm", "letBindingTermPlus", "letBindingTerm", 
		"termStar", "literal", "ntDefPlus", "ntDef", "gTermPlus", "checkSynthCmd", 
		"constraintCmd", "synthFunCmd", "gTermWeighted", "literalPlus", "gTerm", 
		"letGTerm", "letBindingGTermPlus", "letBindingGTerm", "gTermStar"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'set-logic'", "')'", "'TROP'", "'PROB'", "'BOOL'", "'set-weight'", 
		"'optimize'", "'weight-constraint'", "'declare-var'", "'define-sort'", 
		"'BitVec'", "'Bool'", "'Int'", "'Real'", "'Enum'", "'Array'", "'true'", 
		"'false'", "'::'", "'set-options'", "'define-fun'", "'declare-fun'", "'let'", 
		"'check-synth'", "'constraint'", "'synth-fun'", "':'", "'Constant'", "'Vairiable'", 
		"'InputVariable'", "'LocalVariable'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "WS", "INTCONST", 
		"BVCONST", "REALCONST", "SYMBOL", "QUOTEDLIT"
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
	public String getGrammarFileName() { return "QSygusParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QSygusParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			prog();
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

	public static class ProgContext extends ParserRuleContext {
		public SetWeightCmdContext setWeightCmd() {
			return getRuleContext(SetWeightCmdContext.class,0);
		}
		public CmdPlusContext cmdPlus() {
			return getRuleContext(CmdPlusContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			setWeightCmd();
			setState(97);
			cmdPlus(0);
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

	public static class SetLogicCmdContext extends ParserRuleContext {
		public LogicPlusContext logicPlus() {
			return getRuleContext(LogicPlusContext.class,0);
		}
		public SetLogicCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setLogicCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSetLogicCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetLogicCmdContext setLogicCmd() throws RecognitionException {
		SetLogicCmdContext _localctx = new SetLogicCmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setLogicCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__0);
			setState(100);
			match(T__1);
			setState(101);
			logicPlus(0);
			setState(102);
			match(T__2);
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

	public static class LogicPlusContext extends ParserRuleContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public LogicPlusContext logicPlus() {
			return getRuleContext(LogicPlusContext.class,0);
		}
		public LogicPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLogicPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicPlusContext logicPlus() throws RecognitionException {
		return logicPlus(0);
	}

	private LogicPlusContext logicPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicPlusContext _localctx = new LogicPlusContext(_ctx, _parentState);
		LogicPlusContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_logicPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(105);
			match(T__0);
			setState(106);
			logic();
			setState(107);
			match(T__2);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicPlus);
					setState(109);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(110);
					match(T__0);
					setState(111);
					logic();
					setState(112);
					match(T__2);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicContext extends ParserRuleContext {
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		LogicContext _localctx = new LogicContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class SetWeightCmdContext extends ParserRuleContext {
		public SymbolPlusContext symbolPlus() {
			return getRuleContext(SymbolPlusContext.class,0);
		}
		public SetWeightCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setWeightCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSetWeightCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetWeightCmdContext setWeightCmd() throws RecognitionException {
		SetWeightCmdContext _localctx = new SetWeightCmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_setWeightCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__0);
			setState(122);
			match(T__6);
			setState(123);
			symbolPlus(0);
			setState(124);
			match(T__2);
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

	public static class CmdPlusContext extends ParserRuleContext {
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public CmdPlusContext cmdPlus() {
			return getRuleContext(CmdPlusContext.class,0);
		}
		public CmdPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitCmdPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdPlusContext cmdPlus() throws RecognitionException {
		return cmdPlus(0);
	}

	private CmdPlusContext cmdPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CmdPlusContext _localctx = new CmdPlusContext(_ctx, _parentState);
		CmdPlusContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_cmdPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(127);
			cmd();
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CmdPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cmdPlus);
					setState(129);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(130);
					cmd();
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public SetLogicCmdContext setLogicCmd() {
			return getRuleContext(SetLogicCmdContext.class,0);
		}
		public FunDefCmdContext funDefCmd() {
			return getRuleContext(FunDefCmdContext.class,0);
		}
		public FunDeclCmdContext funDeclCmd() {
			return getRuleContext(FunDeclCmdContext.class,0);
		}
		public SynthFunCmdContext synthFunCmd() {
			return getRuleContext(SynthFunCmdContext.class,0);
		}
		public CheckSynthCmdContext checkSynthCmd() {
			return getRuleContext(CheckSynthCmdContext.class,0);
		}
		public ConstraintCmdContext constraintCmd() {
			return getRuleContext(ConstraintCmdContext.class,0);
		}
		public SortDefCmdContext sortDefCmd() {
			return getRuleContext(SortDefCmdContext.class,0);
		}
		public SetOptsCmdContext setOptsCmd() {
			return getRuleContext(SetOptsCmdContext.class,0);
		}
		public WeightConstraintCmdContext weightConstraintCmd() {
			return getRuleContext(WeightConstraintCmdContext.class,0);
		}
		public WeightOptimizationCmdContext weightOptimizationCmd() {
			return getRuleContext(WeightOptimizationCmdContext.class,0);
		}
		public VarDeclCmdContext varDeclCmd() {
			return getRuleContext(VarDeclCmdContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmd);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				setLogicCmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				funDefCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				funDeclCmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				synthFunCmd();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				checkSynthCmd();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				constraintCmd();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				sortDefCmd();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(143);
				setOptsCmd();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(144);
				weightConstraintCmd();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(145);
				weightOptimizationCmd();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(146);
				varDeclCmd();
				}
				break;
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

	public static class WeightOptimizationCmdContext extends ParserRuleContext {
		public WeightPairContext weightPair() {
			return getRuleContext(WeightPairContext.class,0);
		}
		public WeightOptimizationCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightOptimizationCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitWeightOptimizationCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightOptimizationCmdContext weightOptimizationCmd() throws RecognitionException {
		WeightOptimizationCmdContext _localctx = new WeightOptimizationCmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_weightOptimizationCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__0);
			setState(150);
			match(T__7);
			setState(151);
			weightPair();
			setState(152);
			match(T__2);
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

	public static class WeightPairContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SymbolPlusContext symbolPlus() {
			return getRuleContext(SymbolPlusContext.class,0);
		}
		public WeightPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitWeightPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightPairContext weightPair() throws RecognitionException {
		WeightPairContext _localctx = new WeightPairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_weightPair);
		try {
			setState(160);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(T__0);
				setState(155);
				match(SYMBOL);
				setState(156);
				symbolPlus(0);
				setState(157);
				match(T__2);
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class WeightConstraintCmdContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public WeightConstraintCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightConstraintCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitWeightConstraintCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightConstraintCmdContext weightConstraintCmd() throws RecognitionException {
		WeightConstraintCmdContext _localctx = new WeightConstraintCmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_weightConstraintCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(T__0);
			setState(163);
			match(T__8);
			setState(164);
			term();
			setState(165);
			match(T__2);
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

	public static class VarDeclCmdContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public VarDeclCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitVarDeclCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclCmdContext varDeclCmd() throws RecognitionException {
		VarDeclCmdContext _localctx = new VarDeclCmdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDeclCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__0);
			setState(168);
			match(T__9);
			setState(169);
			match(SYMBOL);
			setState(170);
			sortExpr();
			setState(171);
			match(T__2);
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

	public static class SortDefCmdContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public SortDefCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortDefCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSortDefCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortDefCmdContext sortDefCmd() throws RecognitionException {
		SortDefCmdContext _localctx = new SortDefCmdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sortDefCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__0);
			setState(174);
			match(T__10);
			setState(175);
			match(SYMBOL);
			setState(176);
			sortExpr();
			setState(177);
			match(T__2);
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

	public static class SortExprContext extends ParserRuleContext {
		public TerminalNode INTCONST() { return getToken(QSygusParserParser.INTCONST, 0); }
		public EcListContext ecList() {
			return getRuleContext(EcListContext.class,0);
		}
		public List<SortExprContext> sortExpr() {
			return getRuleContexts(SortExprContext.class);
		}
		public SortExprContext sortExpr(int i) {
			return getRuleContext(SortExprContext.class,i);
		}
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSortExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortExprContext sortExpr() throws RecognitionException {
		SortExprContext _localctx = new SortExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sortExpr);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__0);
				setState(180);
				match(T__11);
				setState(181);
				match(INTCONST);
				setState(182);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(T__12);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(T__13);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(T__14);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				match(T__0);
				setState(187);
				match(T__15);
				setState(188);
				ecList();
				setState(189);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(191);
				match(T__0);
				setState(192);
				match(T__16);
				setState(193);
				sortExpr();
				setState(194);
				sortExpr();
				setState(195);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(197);
				match(SYMBOL);
				}
				break;
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

	public static class BoolConstContext extends ParserRuleContext {
		public BoolConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolConst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitBoolConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolConstContext boolConst() throws RecognitionException {
		BoolConstContext _localctx = new BoolConstContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_boolConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class EnumConstContext extends ParserRuleContext {
		public List<TerminalNode> SYMBOL() { return getTokens(QSygusParserParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(QSygusParserParser.SYMBOL, i);
		}
		public EnumConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitEnumConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstContext enumConst() throws RecognitionException {
		EnumConstContext _localctx = new EnumConstContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enumConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(SYMBOL);
			setState(203);
			match(T__19);
			setState(204);
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

	public static class EcListContext extends ParserRuleContext {
		public SymbolPlusContext symbolPlus() {
			return getRuleContext(SymbolPlusContext.class,0);
		}
		public EcListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ecList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitEcList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EcListContext ecList() throws RecognitionException {
		EcListContext _localctx = new EcListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ecList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__0);
			setState(207);
			symbolPlus(0);
			setState(208);
			match(T__2);
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

	public static class SymbolPlusContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SymbolPlusContext symbolPlus() {
			return getRuleContext(SymbolPlusContext.class,0);
		}
		public SymbolPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSymbolPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolPlusContext symbolPlus() throws RecognitionException {
		return symbolPlus(0);
	}

	private SymbolPlusContext symbolPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SymbolPlusContext _localctx = new SymbolPlusContext(_ctx, _parentState);
		SymbolPlusContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_symbolPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(211);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolPlus);
					setState(213);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(214);
					match(SYMBOL);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SetOptsCmdContext extends ParserRuleContext {
		public OptListContext optList() {
			return getRuleContext(OptListContext.class,0);
		}
		public SetOptsCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setOptsCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSetOptsCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetOptsCmdContext setOptsCmd() throws RecognitionException {
		SetOptsCmdContext _localctx = new SetOptsCmdContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_setOptsCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__0);
			setState(221);
			match(T__20);
			setState(222);
			optList();
			setState(223);
			match(T__2);
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

	public static class OptListContext extends ParserRuleContext {
		public SymbolPairPlusContext symbolPairPlus() {
			return getRuleContext(SymbolPairPlusContext.class,0);
		}
		public OptListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitOptList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptListContext optList() throws RecognitionException {
		OptListContext _localctx = new OptListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_optList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__0);
			setState(226);
			symbolPairPlus(0);
			setState(227);
			match(T__2);
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

	public static class SymbolPairPlusContext extends ParserRuleContext {
		public SymbolPairContext symbolPair() {
			return getRuleContext(SymbolPairContext.class,0);
		}
		public SymbolPairPlusContext symbolPairPlus() {
			return getRuleContext(SymbolPairPlusContext.class,0);
		}
		public SymbolPairPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolPairPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSymbolPairPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolPairPlusContext symbolPairPlus() throws RecognitionException {
		return symbolPairPlus(0);
	}

	private SymbolPairPlusContext symbolPairPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SymbolPairPlusContext _localctx = new SymbolPairPlusContext(_ctx, _parentState);
		SymbolPairPlusContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_symbolPairPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(230);
			symbolPair();
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolPairPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolPairPlus);
					setState(232);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(233);
					symbolPair();
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SymbolPairContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public TerminalNode QUOTEDLIT() { return getToken(QSygusParserParser.QUOTEDLIT, 0); }
		public SymbolPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSymbolPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolPairContext symbolPair() throws RecognitionException {
		SymbolPairContext _localctx = new SymbolPairContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_symbolPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__0);
			setState(240);
			match(SYMBOL);
			setState(241);
			match(QUOTEDLIT);
			setState(242);
			match(T__2);
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

	public static class FunDefCmdContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FunDefCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDefCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitFunDefCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDefCmdContext funDefCmd() throws RecognitionException {
		FunDefCmdContext _localctx = new FunDefCmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_funDefCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__0);
			setState(245);
			match(T__21);
			setState(246);
			match(SYMBOL);
			setState(247);
			argList();
			setState(248);
			sortExpr();
			setState(249);
			term();
			setState(250);
			match(T__2);
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

	public static class FunDeclCmdContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortStarContext sortStar() {
			return getRuleContext(SortStarContext.class,0);
		}
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public FunDeclCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDeclCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitFunDeclCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDeclCmdContext funDeclCmd() throws RecognitionException {
		FunDeclCmdContext _localctx = new FunDeclCmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funDeclCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__0);
			setState(253);
			match(T__22);
			setState(254);
			match(SYMBOL);
			setState(255);
			match(T__0);
			setState(256);
			sortStar(0);
			setState(257);
			match(T__2);
			setState(258);
			sortExpr();
			setState(259);
			match(T__2);
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

	public static class SortStarContext extends ParserRuleContext {
		public SortStarContext sortStar() {
			return getRuleContext(SortStarContext.class,0);
		}
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public SortStarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortStar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSortStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortStarContext sortStar() throws RecognitionException {
		return sortStar(0);
	}

	private SortStarContext sortStar(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SortStarContext _localctx = new SortStarContext(_ctx, _parentState);
		SortStarContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_sortStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(266);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SortStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sortStar);
					setState(262);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(263);
					sortExpr();
					}
					} 
				}
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public SymbolSortPairStarContext symbolSortPairStar() {
			return getRuleContext(SymbolSortPairStarContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_argList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__0);
			setState(270);
			symbolSortPairStar(0);
			setState(271);
			match(T__2);
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

	public static class SymbolSortPairStarContext extends ParserRuleContext {
		public SymbolSortPairStarContext symbolSortPairStar() {
			return getRuleContext(SymbolSortPairStarContext.class,0);
		}
		public SymbolSortPairContext symbolSortPair() {
			return getRuleContext(SymbolSortPairContext.class,0);
		}
		public SymbolSortPairStarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolSortPairStar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSymbolSortPairStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolSortPairStarContext symbolSortPairStar() throws RecognitionException {
		return symbolSortPairStar(0);
	}

	private SymbolSortPairStarContext symbolSortPairStar(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SymbolSortPairStarContext _localctx = new SymbolSortPairStarContext(_ctx, _parentState);
		SymbolSortPairStarContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_symbolSortPairStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolSortPairStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolSortPairStar);
					setState(274);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(275);
					symbolSortPair();
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SymbolSortPairContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public SymbolSortPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolSortPair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSymbolSortPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolSortPairContext symbolSortPair() throws RecognitionException {
		SymbolSortPairContext _localctx = new SymbolSortPairContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_symbolSortPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(T__0);
			setState(282);
			match(SYMBOL);
			setState(283);
			sortExpr();
			setState(284);
			match(T__2);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public TermStarContext termStar() {
			return getRuleContext(TermStarContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LetTermContext letTerm() {
			return getRuleContext(LetTermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_term);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(T__0);
				setState(287);
				match(SYMBOL);
				setState(288);
				termStar(0);
				setState(289);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
				match(SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(293);
				letTerm();
				}
				break;
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

	public static class LetTermContext extends ParserRuleContext {
		public LetBindingTermPlusContext letBindingTermPlus() {
			return getRuleContext(LetBindingTermPlusContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public LetTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetTermContext letTerm() throws RecognitionException {
		LetTermContext _localctx = new LetTermContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_letTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__0);
			setState(297);
			match(T__23);
			setState(298);
			match(T__0);
			setState(299);
			letBindingTermPlus(0);
			setState(300);
			match(T__2);
			setState(301);
			term();
			setState(302);
			match(T__2);
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

	public static class LetBindingTermPlusContext extends ParserRuleContext {
		public LetBindingTermContext letBindingTerm() {
			return getRuleContext(LetBindingTermContext.class,0);
		}
		public LetBindingTermPlusContext letBindingTermPlus() {
			return getRuleContext(LetBindingTermPlusContext.class,0);
		}
		public LetBindingTermPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letBindingTermPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetBindingTermPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetBindingTermPlusContext letBindingTermPlus() throws RecognitionException {
		return letBindingTermPlus(0);
	}

	private LetBindingTermPlusContext letBindingTermPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LetBindingTermPlusContext _localctx = new LetBindingTermPlusContext(_ctx, _parentState);
		LetBindingTermPlusContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_letBindingTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(305);
			letBindingTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetBindingTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letBindingTermPlus);
					setState(307);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(308);
					letBindingTerm();
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LetBindingTermContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public LetBindingTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letBindingTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetBindingTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetBindingTermContext letBindingTerm() throws RecognitionException {
		LetBindingTermContext _localctx = new LetBindingTermContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_letBindingTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__0);
			setState(315);
			match(SYMBOL);
			setState(316);
			sortExpr();
			setState(317);
			term();
			setState(318);
			match(T__2);
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

	public static class TermStarContext extends ParserRuleContext {
		public TermStarContext termStar() {
			return getRuleContext(TermStarContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermStarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termStar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitTermStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermStarContext termStar() throws RecognitionException {
		return termStar(0);
	}

	private TermStarContext termStar(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermStarContext _localctx = new TermStarContext(_ctx, _parentState);
		TermStarContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_termStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termStar);
					setState(321);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(322);
					term();
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTCONST() { return getToken(QSygusParserParser.INTCONST, 0); }
		public BoolConstContext boolConst() {
			return getRuleContext(BoolConstContext.class,0);
		}
		public TerminalNode BVCONST() { return getToken(QSygusParserParser.BVCONST, 0); }
		public EnumConstContext enumConst() {
			return getRuleContext(EnumConstContext.class,0);
		}
		public TerminalNode REALCONST() { return getToken(QSygusParserParser.REALCONST, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		try {
			setState(333);
			switch (_input.LA(1)) {
			case INTCONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(INTCONST);
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				boolConst();
				}
				break;
			case BVCONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				match(BVCONST);
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				enumConst();
				}
				break;
			case REALCONST:
				enterOuterAlt(_localctx, 5);
				{
				setState(332);
				match(REALCONST);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NtDefPlusContext extends ParserRuleContext {
		public NtDefContext ntDef() {
			return getRuleContext(NtDefContext.class,0);
		}
		public NtDefPlusContext ntDefPlus() {
			return getRuleContext(NtDefPlusContext.class,0);
		}
		public NtDefPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntDefPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitNtDefPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NtDefPlusContext ntDefPlus() throws RecognitionException {
		return ntDefPlus(0);
	}

	private NtDefPlusContext ntDefPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NtDefPlusContext _localctx = new NtDefPlusContext(_ctx, _parentState);
		NtDefPlusContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_ntDefPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(336);
			ntDef();
			}
			_ctx.stop = _input.LT(-1);
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NtDefPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ntDefPlus);
					setState(338);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(339);
					ntDef();
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NtDefContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public GTermPlusContext gTermPlus() {
			return getRuleContext(GTermPlusContext.class,0);
		}
		public NtDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitNtDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NtDefContext ntDef() throws RecognitionException {
		NtDefContext _localctx = new NtDefContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ntDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__0);
			setState(346);
			match(SYMBOL);
			setState(347);
			sortExpr();
			setState(348);
			match(T__0);
			setState(349);
			gTermPlus(0);
			setState(350);
			match(T__2);
			setState(351);
			match(T__2);
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

	public static class GTermPlusContext extends ParserRuleContext {
		public GTermWeightedContext gTermWeighted() {
			return getRuleContext(GTermWeightedContext.class,0);
		}
		public GTermPlusContext gTermPlus() {
			return getRuleContext(GTermPlusContext.class,0);
		}
		public GTermPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gTermPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitGTermPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GTermPlusContext gTermPlus() throws RecognitionException {
		return gTermPlus(0);
	}

	private GTermPlusContext gTermPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GTermPlusContext _localctx = new GTermPlusContext(_ctx, _parentState);
		GTermPlusContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_gTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(354);
			gTermWeighted();
			}
			_ctx.stop = _input.LT(-1);
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gTermPlus);
					setState(356);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(357);
					gTermWeighted();
					}
					} 
				}
				setState(362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CheckSynthCmdContext extends ParserRuleContext {
		public CheckSynthCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkSynthCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitCheckSynthCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckSynthCmdContext checkSynthCmd() throws RecognitionException {
		CheckSynthCmdContext _localctx = new CheckSynthCmdContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_checkSynthCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(T__0);
			setState(364);
			match(T__24);
			setState(365);
			match(T__2);
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

	public static class ConstraintCmdContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ConstraintCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitConstraintCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintCmdContext constraintCmd() throws RecognitionException {
		ConstraintCmdContext _localctx = new ConstraintCmdContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_constraintCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__0);
			setState(368);
			match(T__25);
			setState(369);
			term();
			setState(370);
			match(T__2);
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

	public static class SynthFunCmdContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public NtDefPlusContext ntDefPlus() {
			return getRuleContext(NtDefPlusContext.class,0);
		}
		public SynthFunCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthFunCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitSynthFunCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynthFunCmdContext synthFunCmd() throws RecognitionException {
		SynthFunCmdContext _localctx = new SynthFunCmdContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_synthFunCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__0);
			setState(373);
			match(T__26);
			setState(374);
			match(SYMBOL);
			setState(375);
			argList();
			setState(376);
			sortExpr();
			setState(377);
			match(T__0);
			setState(378);
			ntDefPlus(0);
			setState(379);
			match(T__2);
			setState(380);
			match(T__2);
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

	public static class GTermWeightedContext extends ParserRuleContext {
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
		}
		public LiteralPlusContext literalPlus() {
			return getRuleContext(LiteralPlusContext.class,0);
		}
		public GTermWeightedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gTermWeighted; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitGTermWeighted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GTermWeightedContext gTermWeighted() throws RecognitionException {
		GTermWeightedContext _localctx = new GTermWeightedContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_gTermWeighted);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(T__0);
				setState(383);
				gTerm();
				setState(384);
				match(T__27);
				setState(385);
				literalPlus(0);
				setState(386);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				gTerm();
				}
				break;
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

	public static class LiteralPlusContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPlusContext literalPlus() {
			return getRuleContext(LiteralPlusContext.class,0);
		}
		public LiteralPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLiteralPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralPlusContext literalPlus() throws RecognitionException {
		return literalPlus(0);
	}

	private LiteralPlusContext literalPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LiteralPlusContext _localctx = new LiteralPlusContext(_ctx, _parentState);
		LiteralPlusContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_literalPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(392);
			literal();
			}
			_ctx.stop = _input.LT(-1);
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LiteralPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_literalPlus);
					setState(394);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(395);
					literal();
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GTermContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public GTermStarContext gTermStar() {
			return getRuleContext(GTermStarContext.class,0);
		}
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public LetGTermContext letGTerm() {
			return getRuleContext(LetGTermContext.class,0);
		}
		public GTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitGTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GTermContext gTerm() throws RecognitionException {
		GTermContext _localctx = new GTermContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_gTerm);
		try {
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(T__0);
				setState(404);
				match(SYMBOL);
				setState(405);
				gTermStar(0);
				setState(406);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(408);
				match(T__0);
				setState(409);
				match(T__28);
				setState(410);
				sortExpr();
				setState(411);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(413);
				match(T__0);
				setState(414);
				match(T__29);
				setState(415);
				sortExpr();
				setState(416);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(418);
				match(T__0);
				setState(419);
				match(T__30);
				setState(420);
				sortExpr();
				setState(421);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(423);
				match(T__0);
				setState(424);
				match(T__31);
				setState(425);
				sortExpr();
				setState(426);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(428);
				letGTerm();
				}
				break;
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

	public static class LetGTermContext extends ParserRuleContext {
		public LetBindingGTermPlusContext letBindingGTermPlus() {
			return getRuleContext(LetBindingGTermPlusContext.class,0);
		}
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
		}
		public LetGTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letGTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetGTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetGTermContext letGTerm() throws RecognitionException {
		LetGTermContext _localctx = new LetGTermContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_letGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(T__0);
			setState(432);
			match(T__23);
			setState(433);
			match(T__0);
			setState(434);
			letBindingGTermPlus(0);
			setState(435);
			match(T__2);
			setState(436);
			gTerm();
			setState(437);
			match(T__2);
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

	public static class LetBindingGTermPlusContext extends ParserRuleContext {
		public LetBindingGTermContext letBindingGTerm() {
			return getRuleContext(LetBindingGTermContext.class,0);
		}
		public LetBindingGTermPlusContext letBindingGTermPlus() {
			return getRuleContext(LetBindingGTermPlusContext.class,0);
		}
		public LetBindingGTermPlusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letBindingGTermPlus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetBindingGTermPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetBindingGTermPlusContext letBindingGTermPlus() throws RecognitionException {
		return letBindingGTermPlus(0);
	}

	private LetBindingGTermPlusContext letBindingGTermPlus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LetBindingGTermPlusContext _localctx = new LetBindingGTermPlusContext(_ctx, _parentState);
		LetBindingGTermPlusContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_letBindingGTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(440);
			letBindingGTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(446);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetBindingGTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letBindingGTermPlus);
					setState(442);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(443);
					letBindingGTerm();
					}
					} 
				}
				setState(448);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LetBindingGTermContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
		public SortExprContext sortExpr() {
			return getRuleContext(SortExprContext.class,0);
		}
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
		}
		public LetBindingGTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letBindingGTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitLetBindingGTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetBindingGTermContext letBindingGTerm() throws RecognitionException {
		LetBindingGTermContext _localctx = new LetBindingGTermContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_letBindingGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(T__0);
			setState(450);
			match(SYMBOL);
			setState(451);
			sortExpr();
			setState(452);
			gTerm();
			setState(453);
			match(T__2);
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

	public static class GTermStarContext extends ParserRuleContext {
		public GTermStarContext gTermStar() {
			return getRuleContext(GTermStarContext.class,0);
		}
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
		}
		public GTermStarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gTermStar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QSygusParserVisitor ) return ((QSygusParserVisitor<? extends T>)visitor).visitGTermStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GTermStarContext gTermStar() throws RecognitionException {
		return gTermStar(0);
	}

	private GTermStarContext gTermStar(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GTermStarContext _localctx = new GTermStarContext(_ctx, _parentState);
		GTermStarContext _prevctx = _localctx;
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_gTermStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GTermStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gTermStar);
					setState(456);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(457);
					gTerm();
					}
					} 
				}
				setState(462);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return logicPlus_sempred((LogicPlusContext)_localctx, predIndex);
		case 6:
			return cmdPlus_sempred((CmdPlusContext)_localctx, predIndex);
		case 17:
			return symbolPlus_sempred((SymbolPlusContext)_localctx, predIndex);
		case 20:
			return symbolPairPlus_sempred((SymbolPairPlusContext)_localctx, predIndex);
		case 24:
			return sortStar_sempred((SortStarContext)_localctx, predIndex);
		case 26:
			return symbolSortPairStar_sempred((SymbolSortPairStarContext)_localctx, predIndex);
		case 30:
			return letBindingTermPlus_sempred((LetBindingTermPlusContext)_localctx, predIndex);
		case 32:
			return termStar_sempred((TermStarContext)_localctx, predIndex);
		case 34:
			return ntDefPlus_sempred((NtDefPlusContext)_localctx, predIndex);
		case 36:
			return gTermPlus_sempred((GTermPlusContext)_localctx, predIndex);
		case 41:
			return literalPlus_sempred((LiteralPlusContext)_localctx, predIndex);
		case 44:
			return letBindingGTermPlus_sempred((LetBindingGTermPlusContext)_localctx, predIndex);
		case 46:
			return gTermStar_sempred((GTermStarContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicPlus_sempred(LogicPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean cmdPlus_sempred(CmdPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolPlus_sempred(SymbolPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolPairPlus_sempred(SymbolPairPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean sortStar_sempred(SortStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolSortPairStar_sempred(SymbolSortPairStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean letBindingTermPlus_sempred(LetBindingTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termStar_sempred(TermStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean ntDefPlus_sempred(NtDefPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gTermPlus_sempred(GTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean literalPlus_sempred(LiteralPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean letBindingGTermPlus_sempred(LetBindingGTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gTermStar_sempred(GTermStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u01d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5u\n\5\f\5\16\5x\13\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u0086\n\b\f\b\16\b\u0089"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0096\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a3\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00c9\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u00da\n\23\f\23\16\23\u00dd"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u00ed\n\26\f\26\16\26\u00f0\13\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u010b\n\32\f\32\16\32\u010e\13\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0117\n\34\f\34\16\34\u011a\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u0129\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 "+
		"\7 \u0138\n \f \16 \u013b\13 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\7\"\u0146"+
		"\n\"\f\"\16\"\u0149\13\"\3#\3#\3#\3#\3#\5#\u0150\n#\3$\3$\3$\3$\3$\7$"+
		"\u0157\n$\f$\16$\u015a\13$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\7&\u0169"+
		"\n&\f&\16&\u016c\13&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\5*\u0188\n*\3+\3+\3+\3+\3+\7+\u018f"+
		"\n+\f+\16+\u0192\13+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01b0\n,\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3.\3.\3.\3.\3.\7.\u01bf\n.\f.\16.\u01c2\13.\3/\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\60\7\60\u01cd\n\60\f\60\16\60\u01d0\13\60\3\60\2\17\b\16$*\62\66"+
		">BFJTZ^\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^\2\4\3\2\6\b\3\2\24\25\u01cf\2`\3\2\2\2\4b\3\2\2"+
		"\2\6e\3\2\2\2\bj\3\2\2\2\ny\3\2\2\2\f{\3\2\2\2\16\u0080\3\2\2\2\20\u0095"+
		"\3\2\2\2\22\u0097\3\2\2\2\24\u00a2\3\2\2\2\26\u00a4\3\2\2\2\30\u00a9\3"+
		"\2\2\2\32\u00af\3\2\2\2\34\u00c8\3\2\2\2\36\u00ca\3\2\2\2 \u00cc\3\2\2"+
		"\2\"\u00d0\3\2\2\2$\u00d4\3\2\2\2&\u00de\3\2\2\2(\u00e3\3\2\2\2*\u00e7"+
		"\3\2\2\2,\u00f1\3\2\2\2.\u00f6\3\2\2\2\60\u00fe\3\2\2\2\62\u0107\3\2\2"+
		"\2\64\u010f\3\2\2\2\66\u0113\3\2\2\28\u011b\3\2\2\2:\u0128\3\2\2\2<\u012a"+
		"\3\2\2\2>\u0132\3\2\2\2@\u013c\3\2\2\2B\u0142\3\2\2\2D\u014f\3\2\2\2F"+
		"\u0151\3\2\2\2H\u015b\3\2\2\2J\u0163\3\2\2\2L\u016d\3\2\2\2N\u0171\3\2"+
		"\2\2P\u0176\3\2\2\2R\u0187\3\2\2\2T\u0189\3\2\2\2V\u01af\3\2\2\2X\u01b1"+
		"\3\2\2\2Z\u01b9\3\2\2\2\\\u01c3\3\2\2\2^\u01c9\3\2\2\2`a\5\4\3\2a\3\3"+
		"\2\2\2bc\5\f\7\2cd\5\16\b\2d\5\3\2\2\2ef\7\3\2\2fg\7\4\2\2gh\5\b\5\2h"+
		"i\7\5\2\2i\7\3\2\2\2jk\b\5\1\2kl\7\3\2\2lm\5\n\6\2mn\7\5\2\2nv\3\2\2\2"+
		"op\f\4\2\2pq\7\3\2\2qr\5\n\6\2rs\7\5\2\2su\3\2\2\2to\3\2\2\2ux\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2w\t\3\2\2\2xv\3\2\2\2yz\t\2\2\2z\13\3\2\2\2{|\7\3"+
		"\2\2|}\7\t\2\2}~\5$\23\2~\177\7\5\2\2\177\r\3\2\2\2\u0080\u0081\b\b\1"+
		"\2\u0081\u0082\5\20\t\2\u0082\u0087\3\2\2\2\u0083\u0084\f\4\2\2\u0084"+
		"\u0086\5\20\t\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u0096\5\6\4\2\u008b\u0096\5.\30\2\u008c\u0096\5\60\31\2\u008d\u0096\5"+
		"P)\2\u008e\u0096\5L\'\2\u008f\u0096\5N(\2\u0090\u0096\5\32\16\2\u0091"+
		"\u0096\5&\24\2\u0092\u0096\5\26\f\2\u0093\u0096\5\22\n\2\u0094\u0096\5"+
		"\30\r\2\u0095\u008a\3\2\2\2\u0095\u008b\3\2\2\2\u0095\u008c\3\2\2\2\u0095"+
		"\u008d\3\2\2\2\u0095\u008e\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0090\3\2"+
		"\2\2\u0095\u0091\3\2\2\2\u0095\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\21\3\2\2\2\u0097\u0098\7\3\2\2\u0098\u0099\7\n\2"+
		"\2\u0099\u009a\5\24\13\2\u009a\u009b\7\5\2\2\u009b\23\3\2\2\2\u009c\u009d"+
		"\7\3\2\2\u009d\u009e\7\'\2\2\u009e\u009f\5$\23\2\u009f\u00a0\7\5\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u00a3\7\'\2\2\u00a2\u009c\3\2\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\25\3\2\2\2\u00a4\u00a5\7\3\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7"+
		"\5:\36\2\u00a7\u00a8\7\5\2\2\u00a8\27\3\2\2\2\u00a9\u00aa\7\3\2\2\u00aa"+
		"\u00ab\7\f\2\2\u00ab\u00ac\7\'\2\2\u00ac\u00ad\5\34\17\2\u00ad\u00ae\7"+
		"\5\2\2\u00ae\31\3\2\2\2\u00af\u00b0\7\3\2\2\u00b0\u00b1\7\r\2\2\u00b1"+
		"\u00b2\7\'\2\2\u00b2\u00b3\5\34\17\2\u00b3\u00b4\7\5\2\2\u00b4\33\3\2"+
		"\2\2\u00b5\u00b6\7\3\2\2\u00b6\u00b7\7\16\2\2\u00b7\u00b8\7$\2\2\u00b8"+
		"\u00c9\7\5\2\2\u00b9\u00c9\7\17\2\2\u00ba\u00c9\7\20\2\2\u00bb\u00c9\7"+
		"\21\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\5\"\22\2"+
		"\u00bf\u00c0\7\5\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\7\3\2\2\u00c2\u00c3"+
		"\7\23\2\2\u00c3\u00c4\5\34\17\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\7\5"+
		"\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c9\7\'\2\2\u00c8\u00b5\3\2\2\2\u00c8"+
		"\u00b9\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c8\u00bb\3\2\2\2\u00c8\u00bc\3\2"+
		"\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\35\3\2\2\2\u00ca\u00cb"+
		"\t\3\2\2\u00cb\37\3\2\2\2\u00cc\u00cd\7\'\2\2\u00cd\u00ce\7\26\2\2\u00ce"+
		"\u00cf\7\'\2\2\u00cf!\3\2\2\2\u00d0\u00d1\7\3\2\2\u00d1\u00d2\5$\23\2"+
		"\u00d2\u00d3\7\5\2\2\u00d3#\3\2\2\2\u00d4\u00d5\b\23\1\2\u00d5\u00d6\7"+
		"\'\2\2\u00d6\u00db\3\2\2\2\u00d7\u00d8\f\4\2\2\u00d8\u00da\7\'\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc%\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\3\2\2\u00df\u00e0"+
		"\7\27\2\2\u00e0\u00e1\5(\25\2\u00e1\u00e2\7\5\2\2\u00e2\'\3\2\2\2\u00e3"+
		"\u00e4\7\3\2\2\u00e4\u00e5\5*\26\2\u00e5\u00e6\7\5\2\2\u00e6)\3\2\2\2"+
		"\u00e7\u00e8\b\26\1\2\u00e8\u00e9\5,\27\2\u00e9\u00ee\3\2\2\2\u00ea\u00eb"+
		"\f\4\2\2\u00eb\u00ed\5,\27\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef+\3\2\2\2\u00f0\u00ee\3\2\2\2"+
		"\u00f1\u00f2\7\3\2\2\u00f2\u00f3\7\'\2\2\u00f3\u00f4\7(\2\2\u00f4\u00f5"+
		"\7\5\2\2\u00f5-\3\2\2\2\u00f6\u00f7\7\3\2\2\u00f7\u00f8\7\30\2\2\u00f8"+
		"\u00f9\7\'\2\2\u00f9\u00fa\5\64\33\2\u00fa\u00fb\5\34\17\2\u00fb\u00fc"+
		"\5:\36\2\u00fc\u00fd\7\5\2\2\u00fd/\3\2\2\2\u00fe\u00ff\7\3\2\2\u00ff"+
		"\u0100\7\31\2\2\u0100\u0101\7\'\2\2\u0101\u0102\7\3\2\2\u0102\u0103\5"+
		"\62\32\2\u0103\u0104\7\5\2\2\u0104\u0105\5\34\17\2\u0105\u0106\7\5\2\2"+
		"\u0106\61\3\2\2\2\u0107\u010c\b\32\1\2\u0108\u0109\f\4\2\2\u0109\u010b"+
		"\5\34\17\2\u010a\u0108\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\63\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110"+
		"\7\3\2\2\u0110\u0111\5\66\34\2\u0111\u0112\7\5\2\2\u0112\65\3\2\2\2\u0113"+
		"\u0118\b\34\1\2\u0114\u0115\f\4\2\2\u0115\u0117\58\35\2\u0116\u0114\3"+
		"\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\67\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7\3\2\2\u011c\u011d\7\'\2"+
		"\2\u011d\u011e\5\34\17\2\u011e\u011f\7\5\2\2\u011f9\3\2\2\2\u0120\u0121"+
		"\7\3\2\2\u0121\u0122\7\'\2\2\u0122\u0123\5B\"\2\u0123\u0124\7\5\2\2\u0124"+
		"\u0129\3\2\2\2\u0125\u0129\5D#\2\u0126\u0129\7\'\2\2\u0127\u0129\5<\37"+
		"\2\u0128\u0120\3\2\2\2\u0128\u0125\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0127"+
		"\3\2\2\2\u0129;\3\2\2\2\u012a\u012b\7\3\2\2\u012b\u012c\7\32\2\2\u012c"+
		"\u012d\7\3\2\2\u012d\u012e\5> \2\u012e\u012f\7\5\2\2\u012f\u0130\5:\36"+
		"\2\u0130\u0131\7\5\2\2\u0131=\3\2\2\2\u0132\u0133\b \1\2\u0133\u0134\5"+
		"@!\2\u0134\u0139\3\2\2\2\u0135\u0136\f\4\2\2\u0136\u0138\5@!\2\u0137\u0135"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"?\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7\3\2\2\u013d\u013e\7\'\2\2"+
		"\u013e\u013f\5\34\17\2\u013f\u0140\5:\36\2\u0140\u0141\7\5\2\2\u0141A"+
		"\3\2\2\2\u0142\u0147\b\"\1\2\u0143\u0144\f\4\2\2\u0144\u0146\5:\36\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148C\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u0150\7$\2\2\u014b\u0150"+
		"\5\36\20\2\u014c\u0150\7%\2\2\u014d\u0150\5 \21\2\u014e\u0150\7&\2\2\u014f"+
		"\u014a\3\2\2\2\u014f\u014b\3\2\2\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u014e\3\2\2\2\u0150E\3\2\2\2\u0151\u0152\b$\1\2\u0152\u0153"+
		"\5H%\2\u0153\u0158\3\2\2\2\u0154\u0155\f\4\2\2\u0155\u0157\5H%\2\u0156"+
		"\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159G\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\7\3\2\2\u015c\u015d"+
		"\7\'\2\2\u015d\u015e\5\34\17\2\u015e\u015f\7\3\2\2\u015f\u0160\5J&\2\u0160"+
		"\u0161\7\5\2\2\u0161\u0162\7\5\2\2\u0162I\3\2\2\2\u0163\u0164\b&\1\2\u0164"+
		"\u0165\5R*\2\u0165\u016a\3\2\2\2\u0166\u0167\f\4\2\2\u0167\u0169\5R*\2"+
		"\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016bK\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\7\3\2\2\u016e"+
		"\u016f\7\33\2\2\u016f\u0170\7\5\2\2\u0170M\3\2\2\2\u0171\u0172\7\3\2\2"+
		"\u0172\u0173\7\34\2\2\u0173\u0174\5:\36\2\u0174\u0175\7\5\2\2\u0175O\3"+
		"\2\2\2\u0176\u0177\7\3\2\2\u0177\u0178\7\35\2\2\u0178\u0179\7\'\2\2\u0179"+
		"\u017a\5\64\33\2\u017a\u017b\5\34\17\2\u017b\u017c\7\3\2\2\u017c\u017d"+
		"\5F$\2\u017d\u017e\7\5\2\2\u017e\u017f\7\5\2\2\u017fQ\3\2\2\2\u0180\u0181"+
		"\7\3\2\2\u0181\u0182\5V,\2\u0182\u0183\7\36\2\2\u0183\u0184\5T+\2\u0184"+
		"\u0185\7\5\2\2\u0185\u0188\3\2\2\2\u0186\u0188\5V,\2\u0187\u0180\3\2\2"+
		"\2\u0187\u0186\3\2\2\2\u0188S\3\2\2\2\u0189\u018a\b+\1\2\u018a\u018b\5"+
		"D#\2\u018b\u0190\3\2\2\2\u018c\u018d\f\4\2\2\u018d\u018f\5D#\2\u018e\u018c"+
		"\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"U\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u01b0\7\'\2\2\u0194\u01b0\5D#\2\u0195"+
		"\u0196\7\3\2\2\u0196\u0197\7\'\2\2\u0197\u0198\5^\60\2\u0198\u0199\7\5"+
		"\2\2\u0199\u01b0\3\2\2\2\u019a\u019b\7\3\2\2\u019b\u019c\7\37\2\2\u019c"+
		"\u019d\5\34\17\2\u019d\u019e\7\5\2\2\u019e\u01b0\3\2\2\2\u019f\u01a0\7"+
		"\3\2\2\u01a0\u01a1\7 \2\2\u01a1\u01a2\5\34\17\2\u01a2\u01a3\7\5\2\2\u01a3"+
		"\u01b0\3\2\2\2\u01a4\u01a5\7\3\2\2\u01a5\u01a6\7!\2\2\u01a6\u01a7\5\34"+
		"\17\2\u01a7\u01a8\7\5\2\2\u01a8\u01b0\3\2\2\2\u01a9\u01aa\7\3\2\2\u01aa"+
		"\u01ab\7\"\2\2\u01ab\u01ac\5\34\17\2\u01ac\u01ad\7\5\2\2\u01ad\u01b0\3"+
		"\2\2\2\u01ae\u01b0\5X-\2\u01af\u0193\3\2\2\2\u01af\u0194\3\2\2\2\u01af"+
		"\u0195\3\2\2\2\u01af\u019a\3\2\2\2\u01af\u019f\3\2\2\2\u01af\u01a4\3\2"+
		"\2\2\u01af\u01a9\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0W\3\2\2\2\u01b1\u01b2"+
		"\7\3\2\2\u01b2\u01b3\7\32\2\2\u01b3\u01b4\7\3\2\2\u01b4\u01b5\5Z.\2\u01b5"+
		"\u01b6\7\5\2\2\u01b6\u01b7\5V,\2\u01b7\u01b8\7\5\2\2\u01b8Y\3\2\2\2\u01b9"+
		"\u01ba\b.\1\2\u01ba\u01bb\5\\/\2\u01bb\u01c0\3\2\2\2\u01bc\u01bd\f\4\2"+
		"\2\u01bd\u01bf\5\\/\2\u01be\u01bc\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1[\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3"+
		"\u01c4\7\3\2\2\u01c4\u01c5\7\'\2\2\u01c5\u01c6\5\34\17\2\u01c6\u01c7\5"+
		"V,\2\u01c7\u01c8\7\5\2\2\u01c8]\3\2\2\2\u01c9\u01ce\b\60\1\2\u01ca\u01cb"+
		"\f\4\2\2\u01cb\u01cd\5V,\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf_\3\2\2\2\u01d0\u01ce\3\2\2\2"+
		"\26v\u0087\u0095\u00a2\u00c8\u00db\u00ee\u010c\u0118\u0128\u0139\u0147"+
		"\u014f\u0158\u016a\u0187\u0190\u01af\u01c0\u01ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}