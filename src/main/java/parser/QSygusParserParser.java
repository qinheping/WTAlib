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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, WS=30, INTCONST=31, 
		BVCONST=32, REALCONST=33, SYMBOL=34, QUOTEDLIT=35;
	public static final int
		RULE_start = 0, RULE_prog = 1, RULE_setLogicCmd = 2, RULE_setWeightCmd = 3, 
		RULE_cmdPlus = 4, RULE_cmd = 5, RULE_weightOptimizationCmd = 6, RULE_weightConstraintCmd = 7, 
		RULE_varDeclCmd = 8, RULE_sortDefCmd = 9, RULE_sortExpr = 10, RULE_boolConst = 11, 
		RULE_enumConst = 12, RULE_ecList = 13, RULE_symbolPlus = 14, RULE_setOptsCmd = 15, 
		RULE_optList = 16, RULE_symbolPairPlus = 17, RULE_symbolPair = 18, RULE_funDefCmd = 19, 
		RULE_funDeclCmd = 20, RULE_sortStar = 21, RULE_argList = 22, RULE_symbolSortPairStar = 23, 
		RULE_symbolSortPair = 24, RULE_term = 25, RULE_letTerm = 26, RULE_letBindingTermPlus = 27, 
		RULE_letBindingTerm = 28, RULE_termStar = 29, RULE_literal = 30, RULE_ntDefPlus = 31, 
		RULE_ntDef = 32, RULE_gTermPlus = 33, RULE_checkSynthCmd = 34, RULE_constraintCmd = 35, 
		RULE_synthFunCmd = 36, RULE_gTermWeighted = 37, RULE_literalPlus = 38, 
		RULE_gTerm = 39, RULE_letGTerm = 40, RULE_letBindingGTermPlus = 41, RULE_letBindingGTerm = 42, 
		RULE_gTermStar = 43;
	public static final String[] ruleNames = {
		"start", "prog", "setLogicCmd", "setWeightCmd", "cmdPlus", "cmd", "weightOptimizationCmd", 
		"weightConstraintCmd", "varDeclCmd", "sortDefCmd", "sortExpr", "boolConst", 
		"enumConst", "ecList", "symbolPlus", "setOptsCmd", "optList", "symbolPairPlus", 
		"symbolPair", "funDefCmd", "funDeclCmd", "sortStar", "argList", "symbolSortPairStar", 
		"symbolSortPair", "term", "letTerm", "letBindingTermPlus", "letBindingTerm", 
		"termStar", "literal", "ntDefPlus", "ntDef", "gTermPlus", "checkSynthCmd", 
		"constraintCmd", "synthFunCmd", "gTermWeighted", "literalPlus", "gTerm", 
		"letGTerm", "letBindingGTermPlus", "letBindingGTerm", "gTermStar"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'set-logic'", "')'", "'set-weight'", "'Optimization'", "'weight-constraint'", 
		"'declare-var'", "'define-sort'", "'BitVec'", "'Bool'", "'Int'", "'Real'", 
		"'Enum'", "'Array'", "'true'", "'false'", "'::'", "'set-options'", "'define-fun'", 
		"'declare-fun'", "'let'", "'check-synth'", "'constraint'", "'synth-fun'", 
		"':'", "'Constant'", "'Vairiable'", "'InputVariable'", "'LocalVariable'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "WS", "INTCONST", "BVCONST", "REALCONST", 
		"SYMBOL", "QUOTEDLIT"
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
			setState(88);
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
			setState(90);
			setWeightCmd();
			setState(91);
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
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
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
			setState(93);
			match(T__0);
			setState(94);
			match(T__1);
			setState(95);
			match(SYMBOL);
			setState(96);
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
		enterRule(_localctx, 6, RULE_setWeightCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__0);
			setState(99);
			match(T__3);
			setState(100);
			symbolPlus(0);
			setState(101);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_cmdPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(104);
			cmd();
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CmdPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cmdPlus);
					setState(106);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(107);
					cmd();
					}
					} 
				}
				setState(112);
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
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				setLogicCmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				funDefCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				funDeclCmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				synthFunCmd();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				checkSynthCmd();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(118);
				constraintCmd();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(119);
				sortDefCmd();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(120);
				setOptsCmd();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(121);
				weightConstraintCmd();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(122);
				weightOptimizationCmd();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(123);
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
		public SymbolPlusContext symbolPlus() {
			return getRuleContext(SymbolPlusContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
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
		enterRule(_localctx, 12, RULE_weightOptimizationCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__0);
			setState(127);
			match(T__4);
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(128);
				match(SYMBOL);
				}
				break;
			}
			setState(131);
			symbolPlus(0);
			setState(132);
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
		enterRule(_localctx, 14, RULE_weightConstraintCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__0);
			setState(135);
			match(T__5);
			setState(136);
			term();
			setState(137);
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
		enterRule(_localctx, 16, RULE_varDeclCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__0);
			setState(140);
			match(T__6);
			setState(141);
			match(SYMBOL);
			setState(142);
			sortExpr();
			setState(143);
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
		enterRule(_localctx, 18, RULE_sortDefCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__0);
			setState(146);
			match(T__7);
			setState(147);
			match(SYMBOL);
			setState(148);
			sortExpr();
			setState(149);
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
		enterRule(_localctx, 20, RULE_sortExpr);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(T__0);
				setState(152);
				match(T__8);
				setState(153);
				match(INTCONST);
				setState(154);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				match(T__10);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(T__11);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				match(T__0);
				setState(159);
				match(T__12);
				setState(160);
				ecList();
				setState(161);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(163);
				match(T__0);
				setState(164);
				match(T__13);
				setState(165);
				sortExpr();
				setState(166);
				sortExpr();
				setState(167);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(169);
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
		enterRule(_localctx, 22, RULE_boolConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
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
		enterRule(_localctx, 24, RULE_enumConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(SYMBOL);
			setState(175);
			match(T__16);
			setState(176);
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
		enterRule(_localctx, 26, RULE_ecList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__0);
			setState(179);
			symbolPlus(0);
			setState(180);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_symbolPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(183);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolPlus);
					setState(185);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(186);
					match(SYMBOL);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		enterRule(_localctx, 30, RULE_setOptsCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__0);
			setState(193);
			match(T__17);
			setState(194);
			optList();
			setState(195);
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
		enterRule(_localctx, 32, RULE_optList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__0);
			setState(198);
			symbolPairPlus(0);
			setState(199);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_symbolPairPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(202);
			symbolPair();
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolPairPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolPairPlus);
					setState(204);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(205);
					symbolPair();
					}
					} 
				}
				setState(210);
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
		enterRule(_localctx, 36, RULE_symbolPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__0);
			setState(212);
			match(SYMBOL);
			setState(213);
			match(QUOTEDLIT);
			setState(214);
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
		enterRule(_localctx, 38, RULE_funDefCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__0);
			setState(217);
			match(T__18);
			setState(218);
			match(SYMBOL);
			setState(219);
			argList();
			setState(220);
			sortExpr();
			setState(221);
			term();
			setState(222);
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
		enterRule(_localctx, 40, RULE_funDeclCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__0);
			setState(225);
			match(T__19);
			setState(226);
			match(SYMBOL);
			setState(227);
			match(T__0);
			setState(228);
			sortStar(0);
			setState(229);
			match(T__2);
			setState(230);
			sortExpr();
			setState(231);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_sortStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SortStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sortStar);
					setState(234);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(235);
					sortExpr();
					}
					} 
				}
				setState(240);
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
		enterRule(_localctx, 44, RULE_argList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__0);
			setState(242);
			symbolSortPairStar(0);
			setState(243);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_symbolSortPairStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SymbolSortPairStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_symbolSortPairStar);
					setState(246);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(247);
					symbolSortPair();
					}
					} 
				}
				setState(252);
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
		enterRule(_localctx, 48, RULE_symbolSortPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__0);
			setState(254);
			match(SYMBOL);
			setState(255);
			sortExpr();
			setState(256);
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
		enterRule(_localctx, 50, RULE_term);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(T__0);
				setState(259);
				match(SYMBOL);
				setState(260);
				termStar(0);
				setState(261);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				match(SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
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
		enterRule(_localctx, 52, RULE_letTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__0);
			setState(269);
			match(T__20);
			setState(270);
			match(T__0);
			setState(271);
			letBindingTermPlus(0);
			setState(272);
			match(T__2);
			setState(273);
			term();
			setState(274);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_letBindingTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(277);
			letBindingTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetBindingTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letBindingTermPlus);
					setState(279);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(280);
					letBindingTerm();
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 56, RULE_letBindingTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__0);
			setState(287);
			match(SYMBOL);
			setState(288);
			sortExpr();
			setState(289);
			term();
			setState(290);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_termStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termStar);
					setState(293);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(294);
					term();
					}
					} 
				}
				setState(299);
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
		enterRule(_localctx, 60, RULE_literal);
		try {
			setState(305);
			switch (_input.LA(1)) {
			case INTCONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(INTCONST);
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				boolConst();
				}
				break;
			case BVCONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				match(BVCONST);
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				enumConst();
				}
				break;
			case REALCONST:
				enterOuterAlt(_localctx, 5);
				{
				setState(304);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_ntDefPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(308);
			ntDef();
			}
			_ctx.stop = _input.LT(-1);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NtDefPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ntDefPlus);
					setState(310);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(311);
					ntDef();
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 64, RULE_ntDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(T__0);
			setState(318);
			match(SYMBOL);
			setState(319);
			sortExpr();
			setState(320);
			match(T__0);
			setState(321);
			gTermPlus(0);
			setState(322);
			match(T__2);
			setState(323);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_gTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(326);
			gTermWeighted();
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gTermPlus);
					setState(328);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(329);
					gTermWeighted();
					}
					} 
				}
				setState(334);
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
		enterRule(_localctx, 68, RULE_checkSynthCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__0);
			setState(336);
			match(T__21);
			setState(337);
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
		enterRule(_localctx, 70, RULE_constraintCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(T__0);
			setState(340);
			match(T__22);
			setState(341);
			term();
			setState(342);
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
		enterRule(_localctx, 72, RULE_synthFunCmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__0);
			setState(345);
			match(T__23);
			setState(346);
			match(SYMBOL);
			setState(347);
			argList();
			setState(348);
			sortExpr();
			setState(349);
			match(T__0);
			setState(350);
			ntDefPlus(0);
			setState(351);
			match(T__2);
			setState(352);
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
		enterRule(_localctx, 74, RULE_gTermWeighted);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(T__0);
				setState(355);
				gTerm();
				setState(356);
				match(T__24);
				setState(357);
				literalPlus(0);
				setState(358);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_literalPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(364);
			literal();
			}
			_ctx.stop = _input.LT(-1);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LiteralPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_literalPlus);
					setState(366);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(367);
					literal();
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		enterRule(_localctx, 78, RULE_gTerm);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(SYMBOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				match(T__0);
				setState(376);
				match(SYMBOL);
				setState(377);
				gTermStar(0);
				setState(378);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(380);
				match(T__0);
				setState(381);
				match(T__25);
				setState(382);
				sortExpr();
				setState(383);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(385);
				match(T__0);
				setState(386);
				match(T__26);
				setState(387);
				sortExpr();
				setState(388);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(390);
				match(T__0);
				setState(391);
				match(T__27);
				setState(392);
				sortExpr();
				setState(393);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(395);
				match(T__0);
				setState(396);
				match(T__28);
				setState(397);
				sortExpr();
				setState(398);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(400);
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
		enterRule(_localctx, 80, RULE_letGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(T__0);
			setState(404);
			match(T__20);
			setState(405);
			match(T__0);
			setState(406);
			letBindingGTermPlus(0);
			setState(407);
			match(T__2);
			setState(408);
			gTerm();
			setState(409);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_letBindingGTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(412);
			letBindingGTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetBindingGTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letBindingGTermPlus);
					setState(414);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(415);
					letBindingGTerm();
					}
					} 
				}
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		enterRule(_localctx, 84, RULE_letBindingGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__0);
			setState(422);
			match(SYMBOL);
			setState(423);
			sortExpr();
			setState(424);
			gTerm();
			setState(425);
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
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_gTermStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(432);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GTermStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gTermStar);
					setState(428);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(429);
					gTerm();
					}
					} 
				}
				setState(434);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return cmdPlus_sempred((CmdPlusContext)_localctx, predIndex);
		case 14:
			return symbolPlus_sempred((SymbolPlusContext)_localctx, predIndex);
		case 17:
			return symbolPairPlus_sempred((SymbolPairPlusContext)_localctx, predIndex);
		case 21:
			return sortStar_sempred((SortStarContext)_localctx, predIndex);
		case 23:
			return symbolSortPairStar_sempred((SymbolSortPairStarContext)_localctx, predIndex);
		case 27:
			return letBindingTermPlus_sempred((LetBindingTermPlusContext)_localctx, predIndex);
		case 29:
			return termStar_sempred((TermStarContext)_localctx, predIndex);
		case 31:
			return ntDefPlus_sempred((NtDefPlusContext)_localctx, predIndex);
		case 33:
			return gTermPlus_sempred((GTermPlusContext)_localctx, predIndex);
		case 38:
			return literalPlus_sempred((LiteralPlusContext)_localctx, predIndex);
		case 41:
			return letBindingGTermPlus_sempred((LetBindingGTermPlusContext)_localctx, predIndex);
		case 43:
			return gTermStar_sempred((GTermStarContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean cmdPlus_sempred(CmdPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolPlus_sempred(SymbolPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolPairPlus_sempred(SymbolPairPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean sortStar_sempred(SortStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean symbolSortPairStar_sempred(SymbolSortPairStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean letBindingTermPlus_sempred(LetBindingTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termStar_sempred(TermStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean ntDefPlus_sempred(NtDefPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gTermPlus_sempred(GTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean literalPlus_sempred(LiteralPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean letBindingGTermPlus_sempred(LetBindingGTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gTermStar_sempred(GTermStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u01b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\7\6o\n\6\f\6\16\6r\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\177\n\7\3\b\3\b\3\b\5\b\u0084\n\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00ad\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\7\20\u00be\n\20\f\20\16\20\u00c1\13\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7"+
		"\23\u00d1\n\23\f\23\16\23\u00d4\13\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\7\27\u00ef\n\27\f\27\16\27\u00f2\13\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\7\31\u00fb\n\31\f\31\16\31\u00fe\13\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u010d"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u011c\n\35\f\35\16\35\u011f\13\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\7\37\u012a\n\37\f\37\16\37\u012d\13\37\3 \3 \3 \3 \3 "+
		"\5 \u0134\n \3!\3!\3!\3!\3!\7!\u013b\n!\f!\16!\u013e\13!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\7#\u014d\n#\f#\16#\u0150\13#\3$\3$\3"+
		"$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\5\'\u016c\n\'\3(\3(\3(\3(\3(\7(\u0173\n(\f(\16(\u0176\13(\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\5)\u0194\n)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\7+\u01a3"+
		"\n+\f+\16+\u01a6\13+\3,\3,\3,\3,\3,\3,\3-\3-\3-\7-\u01b1\n-\f-\16-\u01b4"+
		"\13-\3-\2\16\n\36$,\608<@DNTX.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\3\3\2\21\22\u01b5\2Z\3\2\2\2"+
		"\4\\\3\2\2\2\6_\3\2\2\2\bd\3\2\2\2\ni\3\2\2\2\f~\3\2\2\2\16\u0080\3\2"+
		"\2\2\20\u0088\3\2\2\2\22\u008d\3\2\2\2\24\u0093\3\2\2\2\26\u00ac\3\2\2"+
		"\2\30\u00ae\3\2\2\2\32\u00b0\3\2\2\2\34\u00b4\3\2\2\2\36\u00b8\3\2\2\2"+
		" \u00c2\3\2\2\2\"\u00c7\3\2\2\2$\u00cb\3\2\2\2&\u00d5\3\2\2\2(\u00da\3"+
		"\2\2\2*\u00e2\3\2\2\2,\u00eb\3\2\2\2.\u00f3\3\2\2\2\60\u00f7\3\2\2\2\62"+
		"\u00ff\3\2\2\2\64\u010c\3\2\2\2\66\u010e\3\2\2\28\u0116\3\2\2\2:\u0120"+
		"\3\2\2\2<\u0126\3\2\2\2>\u0133\3\2\2\2@\u0135\3\2\2\2B\u013f\3\2\2\2D"+
		"\u0147\3\2\2\2F\u0151\3\2\2\2H\u0155\3\2\2\2J\u015a\3\2\2\2L\u016b\3\2"+
		"\2\2N\u016d\3\2\2\2P\u0193\3\2\2\2R\u0195\3\2\2\2T\u019d\3\2\2\2V\u01a7"+
		"\3\2\2\2X\u01ad\3\2\2\2Z[\5\4\3\2[\3\3\2\2\2\\]\5\b\5\2]^\5\n\6\2^\5\3"+
		"\2\2\2_`\7\3\2\2`a\7\4\2\2ab\7$\2\2bc\7\5\2\2c\7\3\2\2\2de\7\3\2\2ef\7"+
		"\6\2\2fg\5\36\20\2gh\7\5\2\2h\t\3\2\2\2ij\b\6\1\2jk\5\f\7\2kp\3\2\2\2"+
		"lm\f\4\2\2mo\5\f\7\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\13\3\2\2"+
		"\2rp\3\2\2\2s\177\5\6\4\2t\177\5(\25\2u\177\5*\26\2v\177\5J&\2w\177\5"+
		"F$\2x\177\5H%\2y\177\5\24\13\2z\177\5 \21\2{\177\5\20\t\2|\177\5\16\b"+
		"\2}\177\5\22\n\2~s\3\2\2\2~t\3\2\2\2~u\3\2\2\2~v\3\2\2\2~w\3\2\2\2~x\3"+
		"\2\2\2~y\3\2\2\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\r\3\2\2\2"+
		"\u0080\u0081\7\3\2\2\u0081\u0083\7\7\2\2\u0082\u0084\7$\2\2\u0083\u0082"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\5\36\20\2"+
		"\u0086\u0087\7\5\2\2\u0087\17\3\2\2\2\u0088\u0089\7\3\2\2\u0089\u008a"+
		"\7\b\2\2\u008a\u008b\5\64\33\2\u008b\u008c\7\5\2\2\u008c\21\3\2\2\2\u008d"+
		"\u008e\7\3\2\2\u008e\u008f\7\t\2\2\u008f\u0090\7$\2\2\u0090\u0091\5\26"+
		"\f\2\u0091\u0092\7\5\2\2\u0092\23\3\2\2\2\u0093\u0094\7\3\2\2\u0094\u0095"+
		"\7\n\2\2\u0095\u0096\7$\2\2\u0096\u0097\5\26\f\2\u0097\u0098\7\5\2\2\u0098"+
		"\25\3\2\2\2\u0099\u009a\7\3\2\2\u009a\u009b\7\13\2\2\u009b\u009c\7!\2"+
		"\2\u009c\u00ad\7\5\2\2\u009d\u00ad\7\f\2\2\u009e\u00ad\7\r\2\2\u009f\u00ad"+
		"\7\16\2\2\u00a0\u00a1\7\3\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00a3\5\34\17"+
		"\2\u00a3\u00a4\7\5\2\2\u00a4\u00ad\3\2\2\2\u00a5\u00a6\7\3\2\2\u00a6\u00a7"+
		"\7\20\2\2\u00a7\u00a8\5\26\f\2\u00a8\u00a9\5\26\f\2\u00a9\u00aa\7\5\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00ad\7$\2\2\u00ac\u0099\3\2\2\2\u00ac\u009d"+
		"\3\2\2\2\u00ac\u009e\3\2\2\2\u00ac\u009f\3\2\2\2\u00ac\u00a0\3\2\2\2\u00ac"+
		"\u00a5\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\27\3\2\2\2\u00ae\u00af\t\2\2"+
		"\2\u00af\31\3\2\2\2\u00b0\u00b1\7$\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3"+
		"\7$\2\2\u00b3\33\3\2\2\2\u00b4\u00b5\7\3\2\2\u00b5\u00b6\5\36\20\2\u00b6"+
		"\u00b7\7\5\2\2\u00b7\35\3\2\2\2\u00b8\u00b9\b\20\1\2\u00b9\u00ba\7$\2"+
		"\2\u00ba\u00bf\3\2\2\2\u00bb\u00bc\f\4\2\2\u00bc\u00be\7$\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\37\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\3\2\2\u00c3\u00c4\7\24\2"+
		"\2\u00c4\u00c5\5\"\22\2\u00c5\u00c6\7\5\2\2\u00c6!\3\2\2\2\u00c7\u00c8"+
		"\7\3\2\2\u00c8\u00c9\5$\23\2\u00c9\u00ca\7\5\2\2\u00ca#\3\2\2\2\u00cb"+
		"\u00cc\b\23\1\2\u00cc\u00cd\5&\24\2\u00cd\u00d2\3\2\2\2\u00ce\u00cf\f"+
		"\4\2\2\u00cf\u00d1\5&\24\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3%\3\2\2\2\u00d4\u00d2\3\2\2\2"+
		"\u00d5\u00d6\7\3\2\2\u00d6\u00d7\7$\2\2\u00d7\u00d8\7%\2\2\u00d8\u00d9"+
		"\7\5\2\2\u00d9\'\3\2\2\2\u00da\u00db\7\3\2\2\u00db\u00dc\7\25\2\2\u00dc"+
		"\u00dd\7$\2\2\u00dd\u00de\5.\30\2\u00de\u00df\5\26\f\2\u00df\u00e0\5\64"+
		"\33\2\u00e0\u00e1\7\5\2\2\u00e1)\3\2\2\2\u00e2\u00e3\7\3\2\2\u00e3\u00e4"+
		"\7\26\2\2\u00e4\u00e5\7$\2\2\u00e5\u00e6\7\3\2\2\u00e6\u00e7\5,\27\2\u00e7"+
		"\u00e8\7\5\2\2\u00e8\u00e9\5\26\f\2\u00e9\u00ea\7\5\2\2\u00ea+\3\2\2\2"+
		"\u00eb\u00f0\b\27\1\2\u00ec\u00ed\f\4\2\2\u00ed\u00ef\5\26\f\2\u00ee\u00ec"+
		"\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"-\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7\3\2\2\u00f4\u00f5\5\60\31"+
		"\2\u00f5\u00f6\7\5\2\2\u00f6/\3\2\2\2\u00f7\u00fc\b\31\1\2\u00f8\u00f9"+
		"\f\4\2\2\u00f9\u00fb\5\62\32\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\61\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00ff\u0100\7\3\2\2\u0100\u0101\7$\2\2\u0101\u0102\5\26\f\2\u0102"+
		"\u0103\7\5\2\2\u0103\63\3\2\2\2\u0104\u0105\7\3\2\2\u0105\u0106\7$\2\2"+
		"\u0106\u0107\5<\37\2\u0107\u0108\7\5\2\2\u0108\u010d\3\2\2\2\u0109\u010d"+
		"\5> \2\u010a\u010d\7$\2\2\u010b\u010d\5\66\34\2\u010c\u0104\3\2\2\2\u010c"+
		"\u0109\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\65\3\2\2"+
		"\2\u010e\u010f\7\3\2\2\u010f\u0110\7\27\2\2\u0110\u0111\7\3\2\2\u0111"+
		"\u0112\58\35\2\u0112\u0113\7\5\2\2\u0113\u0114\5\64\33\2\u0114\u0115\7"+
		"\5\2\2\u0115\67\3\2\2\2\u0116\u0117\b\35\1\2\u0117\u0118\5:\36\2\u0118"+
		"\u011d\3\2\2\2\u0119\u011a\f\4\2\2\u011a\u011c\5:\36\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"9\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7\3\2\2\u0121\u0122\7$\2\2\u0122"+
		"\u0123\5\26\f\2\u0123\u0124\5\64\33\2\u0124\u0125\7\5\2\2\u0125;\3\2\2"+
		"\2\u0126\u012b\b\37\1\2\u0127\u0128\f\4\2\2\u0128\u012a\5\64\33\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c=\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0134\7!\2\2\u012f\u0134"+
		"\5\30\r\2\u0130\u0134\7\"\2\2\u0131\u0134\5\32\16\2\u0132\u0134\7#\2\2"+
		"\u0133\u012e\3\2\2\2\u0133\u012f\3\2\2\2\u0133\u0130\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0132\3\2\2\2\u0134?\3\2\2\2\u0135\u0136\b!\1\2\u0136\u0137"+
		"\5B\"\2\u0137\u013c\3\2\2\2\u0138\u0139\f\4\2\2\u0139\u013b\5B\"\2\u013a"+
		"\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013dA\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7\3\2\2\u0140\u0141"+
		"\7$\2\2\u0141\u0142\5\26\f\2\u0142\u0143\7\3\2\2\u0143\u0144\5D#\2\u0144"+
		"\u0145\7\5\2\2\u0145\u0146\7\5\2\2\u0146C\3\2\2\2\u0147\u0148\b#\1\2\u0148"+
		"\u0149\5L\'\2\u0149\u014e\3\2\2\2\u014a\u014b\f\4\2\2\u014b\u014d\5L\'"+
		"\2\u014c\u014a\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014fE\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7\3\2\2\u0152"+
		"\u0153\7\30\2\2\u0153\u0154\7\5\2\2\u0154G\3\2\2\2\u0155\u0156\7\3\2\2"+
		"\u0156\u0157\7\31\2\2\u0157\u0158\5\64\33\2\u0158\u0159\7\5\2\2\u0159"+
		"I\3\2\2\2\u015a\u015b\7\3\2\2\u015b\u015c\7\32\2\2\u015c\u015d\7$\2\2"+
		"\u015d\u015e\5.\30\2\u015e\u015f\5\26\f\2\u015f\u0160\7\3\2\2\u0160\u0161"+
		"\5@!\2\u0161\u0162\7\5\2\2\u0162\u0163\7\5\2\2\u0163K\3\2\2\2\u0164\u0165"+
		"\7\3\2\2\u0165\u0166\5P)\2\u0166\u0167\7\33\2\2\u0167\u0168\5N(\2\u0168"+
		"\u0169\7\5\2\2\u0169\u016c\3\2\2\2\u016a\u016c\5P)\2\u016b\u0164\3\2\2"+
		"\2\u016b\u016a\3\2\2\2\u016cM\3\2\2\2\u016d\u016e\b(\1\2\u016e\u016f\5"+
		"> \2\u016f\u0174\3\2\2\2\u0170\u0171\f\4\2\2\u0171\u0173\5> \2\u0172\u0170"+
		"\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"O\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0194\7$\2\2\u0178\u0194\5> \2\u0179"+
		"\u017a\7\3\2\2\u017a\u017b\7$\2\2\u017b\u017c\5X-\2\u017c\u017d\7\5\2"+
		"\2\u017d\u0194\3\2\2\2\u017e\u017f\7\3\2\2\u017f\u0180\7\34\2\2\u0180"+
		"\u0181\5\26\f\2\u0181\u0182\7\5\2\2\u0182\u0194\3\2\2\2\u0183\u0184\7"+
		"\3\2\2\u0184\u0185\7\35\2\2\u0185\u0186\5\26\f\2\u0186\u0187\7\5\2\2\u0187"+
		"\u0194\3\2\2\2\u0188\u0189\7\3\2\2\u0189\u018a\7\36\2\2\u018a\u018b\5"+
		"\26\f\2\u018b\u018c\7\5\2\2\u018c\u0194\3\2\2\2\u018d\u018e\7\3\2\2\u018e"+
		"\u018f\7\37\2\2\u018f\u0190\5\26\f\2\u0190\u0191\7\5\2\2\u0191\u0194\3"+
		"\2\2\2\u0192\u0194\5R*\2\u0193\u0177\3\2\2\2\u0193\u0178\3\2\2\2\u0193"+
		"\u0179\3\2\2\2\u0193\u017e\3\2\2\2\u0193\u0183\3\2\2\2\u0193\u0188\3\2"+
		"\2\2\u0193\u018d\3\2\2\2\u0193\u0192\3\2\2\2\u0194Q\3\2\2\2\u0195\u0196"+
		"\7\3\2\2\u0196\u0197\7\27\2\2\u0197\u0198\7\3\2\2\u0198\u0199\5T+\2\u0199"+
		"\u019a\7\5\2\2\u019a\u019b\5P)\2\u019b\u019c\7\5\2\2\u019cS\3\2\2\2\u019d"+
		"\u019e\b+\1\2\u019e\u019f\5V,\2\u019f\u01a4\3\2\2\2\u01a0\u01a1\f\4\2"+
		"\2\u01a1\u01a3\5V,\2\u01a2\u01a0\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5U\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7"+
		"\u01a8\7\3\2\2\u01a8\u01a9\7$\2\2\u01a9\u01aa\5\26\f\2\u01aa\u01ab\5P"+
		")\2\u01ab\u01ac\7\5\2\2\u01acW\3\2\2\2\u01ad\u01b2\b-\1\2\u01ae\u01af"+
		"\f\4\2\2\u01af\u01b1\5P)\2\u01b0\u01ae\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3Y\3\2\2\2\u01b4\u01b2\3\2\2\2"+
		"\25p~\u0083\u00ac\u00bf\u00d2\u00f0\u00fc\u010c\u011d\u012b\u0133\u013c"+
		"\u014e\u016b\u0174\u0193\u01a4\u01b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}