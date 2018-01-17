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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, WS=30, LETTER=31, DIGIT=32, 
		HEXDIGIT=33, BIT=34, INTEGER=35, INTCONST=36, BVCONST=37, REALCONST=38, 
		SYMBOLCC=39, SYMBOL=40, QUOTEDLIT=41;
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
		RULE_synthFunCmd = 36, RULE_gTerm = 37, RULE_letGTerm = 38, RULE_letBindingGTermPlus = 39, 
		RULE_letBindingGTerm = 40, RULE_gTermStar = 41;
	public static final String[] ruleNames = {
		"start", "prog", "setLogicCmd", "setWeightCmd", "cmdPlus", "cmd", "weightOptimizationCmd", 
		"weightConstraintCmd", "varDeclCmd", "sortDefCmd", "sortExpr", "boolConst", 
		"enumConst", "ecList", "symbolPlus", "setOptsCmd", "optList", "symbolPairPlus", 
		"symbolPair", "funDefCmd", "funDeclCmd", "sortStar", "argList", "symbolSortPairStar", 
		"symbolSortPair", "term", "letTerm", "letBindingTermPlus", "letBindingTerm", 
		"termStar", "literal", "ntDefPlus", "ntDef", "gTermPlus", "checkSynthCmd", 
		"constraintCmd", "synthFunCmd", "gTerm", "letGTerm", "letBindingGTermPlus", 
		"letBindingGTerm", "gTermStar"
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
		null, null, null, null, null, null, "WS", "LETTER", "DIGIT", "HEXDIGIT", 
		"BIT", "INTEGER", "INTCONST", "BVCONST", "REALCONST", "SYMBOLCC", "SYMBOL", 
		"QUOTEDLIT"
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
			setState(84);
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
			setState(86);
			setWeightCmd();
			setState(87);
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
			setState(89);
			match(T__0);
			setState(90);
			match(T__1);
			setState(91);
			match(SYMBOL);
			setState(92);
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
			setState(94);
			match(T__0);
			setState(95);
			match(T__3);
			setState(96);
			symbolPlus(0);
			setState(97);
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
			setState(100);
			cmd();
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
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
					setState(102);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(103);
					cmd();
					}
					} 
				}
				setState(108);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				setLogicCmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				funDefCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				funDeclCmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				synthFunCmd();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				checkSynthCmd();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				constraintCmd();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				sortDefCmd();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				setOptsCmd();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(117);
				weightConstraintCmd();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(118);
				weightOptimizationCmd();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(119);
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
			setState(122);
			match(T__0);
			setState(123);
			match(T__4);
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(124);
				match(SYMBOL);
				}
				break;
			}
			setState(127);
			symbolPlus(0);
			setState(128);
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
			setState(130);
			match(T__0);
			setState(131);
			match(T__5);
			setState(132);
			term();
			setState(133);
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
			setState(135);
			match(T__0);
			setState(136);
			match(T__6);
			setState(137);
			match(SYMBOL);
			setState(138);
			sortExpr();
			setState(139);
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
			setState(141);
			match(T__0);
			setState(142);
			match(T__7);
			setState(143);
			match(SYMBOL);
			setState(144);
			sortExpr();
			setState(145);
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
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__0);
				setState(148);
				match(T__8);
				setState(149);
				match(INTCONST);
				setState(150);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(T__10);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(T__11);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(T__0);
				setState(155);
				match(T__12);
				setState(156);
				ecList();
				setState(157);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(T__0);
				setState(160);
				match(T__13);
				setState(161);
				sortExpr();
				setState(162);
				sortExpr();
				setState(163);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
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
			setState(168);
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
			setState(170);
			match(SYMBOL);
			setState(171);
			match(T__16);
			setState(172);
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
			setState(174);
			match(T__0);
			setState(175);
			symbolPlus(0);
			setState(176);
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
			setState(179);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
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
					setState(181);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(182);
					match(SYMBOL);
					}
					} 
				}
				setState(187);
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
			setState(188);
			match(T__0);
			setState(189);
			match(T__17);
			setState(190);
			optList();
			setState(191);
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
			setState(193);
			match(T__0);
			setState(194);
			symbolPairPlus(0);
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
			setState(198);
			symbolPair();
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
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
					setState(200);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(201);
					symbolPair();
					}
					} 
				}
				setState(206);
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
			setState(207);
			match(T__0);
			setState(208);
			match(SYMBOL);
			setState(209);
			match(QUOTEDLIT);
			setState(210);
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
			setState(212);
			match(T__0);
			setState(213);
			match(T__18);
			setState(214);
			match(SYMBOL);
			setState(215);
			argList();
			setState(216);
			sortExpr();
			setState(217);
			term();
			setState(218);
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
			setState(220);
			match(T__0);
			setState(221);
			match(T__19);
			setState(222);
			match(SYMBOL);
			setState(223);
			match(T__0);
			setState(224);
			sortStar(0);
			setState(225);
			match(T__2);
			setState(226);
			sortExpr();
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
			setState(234);
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
					setState(230);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(231);
					sortExpr();
					}
					} 
				}
				setState(236);
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
			setState(237);
			match(T__0);
			setState(238);
			symbolSortPairStar(0);
			setState(239);
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
			setState(246);
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
					setState(242);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(243);
					symbolSortPair();
					}
					} 
				}
				setState(248);
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
			setState(249);
			match(T__0);
			setState(250);
			match(SYMBOL);
			setState(251);
			sortExpr();
			setState(252);
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
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__0);
				setState(255);
				match(SYMBOL);
				setState(256);
				termStar(0);
				setState(257);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				match(SYMBOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
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
			setState(264);
			match(T__0);
			setState(265);
			match(T__20);
			setState(266);
			match(T__0);
			setState(267);
			letBindingTermPlus(0);
			setState(268);
			match(T__2);
			setState(269);
			term();
			setState(270);
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
			setState(273);
			letBindingTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
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
					setState(275);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(276);
					letBindingTerm();
					}
					} 
				}
				setState(281);
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
			setState(282);
			match(T__0);
			setState(283);
			match(SYMBOL);
			setState(284);
			sortExpr();
			setState(285);
			term();
			setState(286);
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
			setState(293);
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
					setState(289);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(290);
					term();
					}
					} 
				}
				setState(295);
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
			setState(301);
			switch (_input.LA(1)) {
			case INTCONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(INTCONST);
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				boolConst();
				}
				break;
			case BVCONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(BVCONST);
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				enumConst();
				}
				break;
			case REALCONST:
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
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
			setState(304);
			ntDef();
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
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
					setState(306);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(307);
					ntDef();
					}
					} 
				}
				setState(312);
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
			setState(313);
			match(T__0);
			setState(314);
			match(SYMBOL);
			setState(315);
			sortExpr();
			setState(316);
			match(T__0);
			setState(317);
			gTermPlus(0);
			setState(318);
			match(T__2);
			setState(319);
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
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
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
			setState(322);
			gTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
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
					setState(324);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(325);
					gTerm();
					}
					} 
				}
				setState(330);
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
			setState(331);
			match(T__0);
			setState(332);
			match(T__21);
			setState(333);
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
			setState(335);
			match(T__0);
			setState(336);
			match(T__22);
			setState(337);
			term();
			setState(338);
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
			setState(340);
			match(T__0);
			setState(341);
			match(T__23);
			setState(342);
			match(SYMBOL);
			setState(343);
			argList();
			setState(344);
			sortExpr();
			setState(345);
			match(T__0);
			setState(346);
			ntDefPlus(0);
			setState(347);
			match(T__2);
			setState(348);
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

	public static class GTermContext extends ParserRuleContext {
		public GTermContext gTerm() {
			return getRuleContext(GTermContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(QSygusParserParser.SYMBOL, 0); }
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
		enterRule(_localctx, 74, RULE_gTerm);
		try {
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(T__0);
				setState(351);
				gTerm();
				setState(352);
				match(T__24);
				setState(353);
				literal();
				setState(354);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				match(SYMBOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				match(T__0);
				setState(359);
				match(SYMBOL);
				setState(360);
				gTermStar(0);
				setState(361);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(363);
				match(T__0);
				setState(364);
				match(T__25);
				setState(365);
				sortExpr();
				setState(366);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(368);
				match(T__0);
				setState(369);
				match(T__26);
				setState(370);
				sortExpr();
				setState(371);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(373);
				match(T__0);
				setState(374);
				match(T__27);
				setState(375);
				sortExpr();
				setState(376);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(378);
				match(T__0);
				setState(379);
				match(T__28);
				setState(380);
				sortExpr();
				setState(381);
				match(T__2);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(383);
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
		enterRule(_localctx, 76, RULE_letGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(T__0);
			setState(387);
			match(T__20);
			setState(388);
			match(T__0);
			setState(389);
			letBindingGTermPlus(0);
			setState(390);
			match(T__2);
			setState(391);
			gTerm();
			setState(392);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_letBindingGTermPlus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(395);
			letBindingGTerm();
			}
			_ctx.stop = _input.LT(-1);
			setState(401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetBindingGTermPlusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letBindingGTermPlus);
					setState(397);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(398);
					letBindingGTerm();
					}
					} 
				}
				setState(403);
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
		enterRule(_localctx, 80, RULE_letBindingGTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(T__0);
			setState(405);
			match(SYMBOL);
			setState(406);
			sortExpr();
			setState(407);
			gTerm();
			setState(408);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_gTermStar, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GTermStarContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_gTermStar);
					setState(411);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(412);
					gTerm();
					}
					} 
				}
				setState(417);
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
		case 39:
			return letBindingGTermPlus_sempred((LetBindingGTermPlusContext)_localctx, predIndex);
		case 41:
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
	private boolean letBindingGTermPlus_sempred(LetBindingGTermPlusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gTermStar_sempred(GTermStarContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u01a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7{\n\7\3\b\3\b\3\b\5\b\u0080\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a9"+
		"\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u00ba\n\20\f\20\16\20\u00bd\13\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7\23\u00cd\n\23\f\23"+
		"\16\23\u00d0\13\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\7\27\u00eb\n\27\f\27\16\27\u00ee\13\27\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\7\31\u00f7\n\31\f\31\16\31\u00fa\13\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0109\n\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u0118\n\35"+
		"\f\35\16\35\u011b\13\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\7"+
		"\37\u0126\n\37\f\37\16\37\u0129\13\37\3 \3 \3 \3 \3 \5 \u0130\n \3!\3"+
		"!\3!\3!\3!\7!\u0137\n!\f!\16!\u013a\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\7#\u0149\n#\f#\16#\u014c\13#\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0183\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		")\3)\3)\3)\3)\7)\u0192\n)\f)\16)\u0195\13)\3*\3*\3*\3*\3*\3*\3+\3+\3+"+
		"\7+\u01a0\n+\f+\16+\u01a3\13+\3+\2\r\n\36$,\608<@DPT,\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\3\3\2\21\22"+
		"\u01a5\2V\3\2\2\2\4X\3\2\2\2\6[\3\2\2\2\b`\3\2\2\2\ne\3\2\2\2\fz\3\2\2"+
		"\2\16|\3\2\2\2\20\u0084\3\2\2\2\22\u0089\3\2\2\2\24\u008f\3\2\2\2\26\u00a8"+
		"\3\2\2\2\30\u00aa\3\2\2\2\32\u00ac\3\2\2\2\34\u00b0\3\2\2\2\36\u00b4\3"+
		"\2\2\2 \u00be\3\2\2\2\"\u00c3\3\2\2\2$\u00c7\3\2\2\2&\u00d1\3\2\2\2(\u00d6"+
		"\3\2\2\2*\u00de\3\2\2\2,\u00e7\3\2\2\2.\u00ef\3\2\2\2\60\u00f3\3\2\2\2"+
		"\62\u00fb\3\2\2\2\64\u0108\3\2\2\2\66\u010a\3\2\2\28\u0112\3\2\2\2:\u011c"+
		"\3\2\2\2<\u0122\3\2\2\2>\u012f\3\2\2\2@\u0131\3\2\2\2B\u013b\3\2\2\2D"+
		"\u0143\3\2\2\2F\u014d\3\2\2\2H\u0151\3\2\2\2J\u0156\3\2\2\2L\u0182\3\2"+
		"\2\2N\u0184\3\2\2\2P\u018c\3\2\2\2R\u0196\3\2\2\2T\u019c\3\2\2\2VW\5\4"+
		"\3\2W\3\3\2\2\2XY\5\b\5\2YZ\5\n\6\2Z\5\3\2\2\2[\\\7\3\2\2\\]\7\4\2\2]"+
		"^\7*\2\2^_\7\5\2\2_\7\3\2\2\2`a\7\3\2\2ab\7\6\2\2bc\5\36\20\2cd\7\5\2"+
		"\2d\t\3\2\2\2ef\b\6\1\2fg\5\f\7\2gl\3\2\2\2hi\f\4\2\2ik\5\f\7\2jh\3\2"+
		"\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2nl\3\2\2\2o{\5\6\4\2p{\5"+
		"(\25\2q{\5*\26\2r{\5J&\2s{\5F$\2t{\5H%\2u{\5\24\13\2v{\5 \21\2w{\5\20"+
		"\t\2x{\5\16\b\2y{\5\22\n\2zo\3\2\2\2zp\3\2\2\2zq\3\2\2\2zr\3\2\2\2zs\3"+
		"\2\2\2zt\3\2\2\2zu\3\2\2\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\r"+
		"\3\2\2\2|}\7\3\2\2}\177\7\7\2\2~\u0080\7*\2\2\177~\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\36\20\2\u0082\u0083\7\5\2\2\u0083"+
		"\17\3\2\2\2\u0084\u0085\7\3\2\2\u0085\u0086\7\b\2\2\u0086\u0087\5\64\33"+
		"\2\u0087\u0088\7\5\2\2\u0088\21\3\2\2\2\u0089\u008a\7\3\2\2\u008a\u008b"+
		"\7\t\2\2\u008b\u008c\7*\2\2\u008c\u008d\5\26\f\2\u008d\u008e\7\5\2\2\u008e"+
		"\23\3\2\2\2\u008f\u0090\7\3\2\2\u0090\u0091\7\n\2\2\u0091\u0092\7*\2\2"+
		"\u0092\u0093\5\26\f\2\u0093\u0094\7\5\2\2\u0094\25\3\2\2\2\u0095\u0096"+
		"\7\3\2\2\u0096\u0097\7\13\2\2\u0097\u0098\7&\2\2\u0098\u00a9\7\5\2\2\u0099"+
		"\u00a9\7\f\2\2\u009a\u00a9\7\r\2\2\u009b\u00a9\7\16\2\2\u009c\u009d\7"+
		"\3\2\2\u009d\u009e\7\17\2\2\u009e\u009f\5\34\17\2\u009f\u00a0\7\5\2\2"+
		"\u00a0\u00a9\3\2\2\2\u00a1\u00a2\7\3\2\2\u00a2\u00a3\7\20\2\2\u00a3\u00a4"+
		"\5\26\f\2\u00a4\u00a5\5\26\f\2\u00a5\u00a6\7\5\2\2\u00a6\u00a9\3\2\2\2"+
		"\u00a7\u00a9\7*\2\2\u00a8\u0095\3\2\2\2\u00a8\u0099\3\2\2\2\u00a8\u009a"+
		"\3\2\2\2\u00a8\u009b\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\27\3\2\2\2\u00aa\u00ab\t\2\2\2\u00ab\31\3\2\2\2\u00ac"+
		"\u00ad\7*\2\2\u00ad\u00ae\7\23\2\2\u00ae\u00af\7*\2\2\u00af\33\3\2\2\2"+
		"\u00b0\u00b1\7\3\2\2\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7\5\2\2\u00b3\35"+
		"\3\2\2\2\u00b4\u00b5\b\20\1\2\u00b5\u00b6\7*\2\2\u00b6\u00bb\3\2\2\2\u00b7"+
		"\u00b8\f\4\2\2\u00b8\u00ba\7*\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\37\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be\u00bf\7\3\2\2\u00bf\u00c0\7\24\2\2\u00c0\u00c1\5\"\22\2"+
		"\u00c1\u00c2\7\5\2\2\u00c2!\3\2\2\2\u00c3\u00c4\7\3\2\2\u00c4\u00c5\5"+
		"$\23\2\u00c5\u00c6\7\5\2\2\u00c6#\3\2\2\2\u00c7\u00c8\b\23\1\2\u00c8\u00c9"+
		"\5&\24\2\u00c9\u00ce\3\2\2\2\u00ca\u00cb\f\4\2\2\u00cb\u00cd\5&\24\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf%\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\3\2\2\u00d2\u00d3"+
		"\7*\2\2\u00d3\u00d4\7+\2\2\u00d4\u00d5\7\5\2\2\u00d5\'\3\2\2\2\u00d6\u00d7"+
		"\7\3\2\2\u00d7\u00d8\7\25\2\2\u00d8\u00d9\7*\2\2\u00d9\u00da\5.\30\2\u00da"+
		"\u00db\5\26\f\2\u00db\u00dc\5\64\33\2\u00dc\u00dd\7\5\2\2\u00dd)\3\2\2"+
		"\2\u00de\u00df\7\3\2\2\u00df\u00e0\7\26\2\2\u00e0\u00e1\7*\2\2\u00e1\u00e2"+
		"\7\3\2\2\u00e2\u00e3\5,\27\2\u00e3\u00e4\7\5\2\2\u00e4\u00e5\5\26\f\2"+
		"\u00e5\u00e6\7\5\2\2\u00e6+\3\2\2\2\u00e7\u00ec\b\27\1\2\u00e8\u00e9\f"+
		"\4\2\2\u00e9\u00eb\5\26\f\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed-\3\2\2\2\u00ee\u00ec\3\2\2\2"+
		"\u00ef\u00f0\7\3\2\2\u00f0\u00f1\5\60\31\2\u00f1\u00f2\7\5\2\2\u00f2/"+
		"\3\2\2\2\u00f3\u00f8\b\31\1\2\u00f4\u00f5\f\4\2\2\u00f5\u00f7\5\62\32"+
		"\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\61\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\3\2\2\u00fc"+
		"\u00fd\7*\2\2\u00fd\u00fe\5\26\f\2\u00fe\u00ff\7\5\2\2\u00ff\63\3\2\2"+
		"\2\u0100\u0101\7\3\2\2\u0101\u0102\7*\2\2\u0102\u0103\5<\37\2\u0103\u0104"+
		"\7\5\2\2\u0104\u0109\3\2\2\2\u0105\u0109\5> \2\u0106\u0109\7*\2\2\u0107"+
		"\u0109\5\66\34\2\u0108\u0100\3\2\2\2\u0108\u0105\3\2\2\2\u0108\u0106\3"+
		"\2\2\2\u0108\u0107\3\2\2\2\u0109\65\3\2\2\2\u010a\u010b\7\3\2\2\u010b"+
		"\u010c\7\27\2\2\u010c\u010d\7\3\2\2\u010d\u010e\58\35\2\u010e\u010f\7"+
		"\5\2\2\u010f\u0110\5\64\33\2\u0110\u0111\7\5\2\2\u0111\67\3\2\2\2\u0112"+
		"\u0113\b\35\1\2\u0113\u0114\5:\36\2\u0114\u0119\3\2\2\2\u0115\u0116\f"+
		"\4\2\2\u0116\u0118\5:\36\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a9\3\2\2\2\u011b\u0119\3\2\2\2"+
		"\u011c\u011d\7\3\2\2\u011d\u011e\7*\2\2\u011e\u011f\5\26\f\2\u011f\u0120"+
		"\5\64\33\2\u0120\u0121\7\5\2\2\u0121;\3\2\2\2\u0122\u0127\b\37\1\2\u0123"+
		"\u0124\f\4\2\2\u0124\u0126\5\64\33\2\u0125\u0123\3\2\2\2\u0126\u0129\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128=\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u012a\u0130\7&\2\2\u012b\u0130\5\30\r\2\u012c\u0130\7\'\2\2\u012d"+
		"\u0130\5\32\16\2\u012e\u0130\7(\2\2\u012f\u012a\3\2\2\2\u012f\u012b\3"+
		"\2\2\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130"+
		"?\3\2\2\2\u0131\u0132\b!\1\2\u0132\u0133\5B\"\2\u0133\u0138\3\2\2\2\u0134"+
		"\u0135\f\4\2\2\u0135\u0137\5B\"\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2"+
		"\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139A\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013b\u013c\7\3\2\2\u013c\u013d\7*\2\2\u013d\u013e\5\26\f\2\u013e"+
		"\u013f\7\3\2\2\u013f\u0140\5D#\2\u0140\u0141\7\5\2\2\u0141\u0142\7\5\2"+
		"\2\u0142C\3\2\2\2\u0143\u0144\b#\1\2\u0144\u0145\5L\'\2\u0145\u014a\3"+
		"\2\2\2\u0146\u0147\f\4\2\2\u0147\u0149\5L\'\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014bE\3\2\2\2"+
		"\u014c\u014a\3\2\2\2\u014d\u014e\7\3\2\2\u014e\u014f\7\30\2\2\u014f\u0150"+
		"\7\5\2\2\u0150G\3\2\2\2\u0151\u0152\7\3\2\2\u0152\u0153\7\31\2\2\u0153"+
		"\u0154\5\64\33\2\u0154\u0155\7\5\2\2\u0155I\3\2\2\2\u0156\u0157\7\3\2"+
		"\2\u0157\u0158\7\32\2\2\u0158\u0159\7*\2\2\u0159\u015a\5.\30\2\u015a\u015b"+
		"\5\26\f\2\u015b\u015c\7\3\2\2\u015c\u015d\5@!\2\u015d\u015e\7\5\2\2\u015e"+
		"\u015f\7\5\2\2\u015fK\3\2\2\2\u0160\u0161\7\3\2\2\u0161\u0162\5L\'\2\u0162"+
		"\u0163\7\33\2\2\u0163\u0164\5> \2\u0164\u0165\7\5\2\2\u0165\u0183\3\2"+
		"\2\2\u0166\u0183\7*\2\2\u0167\u0183\5> \2\u0168\u0169\7\3\2\2\u0169\u016a"+
		"\7*\2\2\u016a\u016b\5T+\2\u016b\u016c\7\5\2\2\u016c\u0183\3\2\2\2\u016d"+
		"\u016e\7\3\2\2\u016e\u016f\7\34\2\2\u016f\u0170\5\26\f\2\u0170\u0171\7"+
		"\5\2\2\u0171\u0183\3\2\2\2\u0172\u0173\7\3\2\2\u0173\u0174\7\35\2\2\u0174"+
		"\u0175\5\26\f\2\u0175\u0176\7\5\2\2\u0176\u0183\3\2\2\2\u0177\u0178\7"+
		"\3\2\2\u0178\u0179\7\36\2\2\u0179\u017a\5\26\f\2\u017a\u017b\7\5\2\2\u017b"+
		"\u0183\3\2\2\2\u017c\u017d\7\3\2\2\u017d\u017e\7\37\2\2\u017e\u017f\5"+
		"\26\f\2\u017f\u0180\7\5\2\2\u0180\u0183\3\2\2\2\u0181\u0183\5N(\2\u0182"+
		"\u0160\3\2\2\2\u0182\u0166\3\2\2\2\u0182\u0167\3\2\2\2\u0182\u0168\3\2"+
		"\2\2\u0182\u016d\3\2\2\2\u0182\u0172\3\2\2\2\u0182\u0177\3\2\2\2\u0182"+
		"\u017c\3\2\2\2\u0182\u0181\3\2\2\2\u0183M\3\2\2\2\u0184\u0185\7\3\2\2"+
		"\u0185\u0186\7\27\2\2\u0186\u0187\7\3\2\2\u0187\u0188\5P)\2\u0188\u0189"+
		"\7\5\2\2\u0189\u018a\5L\'\2\u018a\u018b\7\5\2\2\u018bO\3\2\2\2\u018c\u018d"+
		"\b)\1\2\u018d\u018e\5R*\2\u018e\u0193\3\2\2\2\u018f\u0190\f\4\2\2\u0190"+
		"\u0192\5R*\2\u0191\u018f\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2"+
		"\2\u0193\u0194\3\2\2\2\u0194Q\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197"+
		"\7\3\2\2\u0197\u0198\7*\2\2\u0198\u0199\5\26\f\2\u0199\u019a\5L\'\2\u019a"+
		"\u019b\7\5\2\2\u019bS\3\2\2\2\u019c\u01a1\b+\1\2\u019d\u019e\f\4\2\2\u019e"+
		"\u01a0\5L\'\2\u019f\u019d\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2U\3\2\2\2\u01a3\u01a1\3\2\2\2\23lz\177\u00a8"+
		"\u00bb\u00ce\u00ec\u00f8\u0108\u0119\u0127\u012f\u0138\u014a\u0182\u0193"+
		"\u01a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}