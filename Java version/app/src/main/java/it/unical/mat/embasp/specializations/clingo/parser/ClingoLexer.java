package it.unical.mat.embasp.specializations.clingo.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClingoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START=1, ANY=2, COMMA=3, INTEGER_CONSTANT=4, NEW_LINE=5, IDENTIFIER=6, 
		STRING_CONSTANT=7, TERMS_BEGIN=8, TERMS_END=9, WHITE_SPACE=10;
	public static final int
		SIGNIFICANT=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "SIGNIFICANT"
	};

	public static final String[] ruleNames = {
		"START", "ANY", "COMMA", "INTEGER_CONSTANT", "NEW_LINE", "IDENTIFIER", 
		"STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", "WHITE_SPACE", "INT", "NL", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "','", null, null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "START", "ANY", "COMMA", "INTEGER_CONSTANT", "NEW_LINE", "IDENTIFIER", 
		"STRING_CONSTANT", "TERMS_BEGIN", "TERMS_END", "WHITE_SPACE"
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


	public ClingoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ClingoLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f|\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6M\n\6\f\6\16\6P\13\6\3\6\5\6S\n\6\3\6\3\6\3\7\3\7\7\7"+
		"Y\n\7\f\7\16\7\\\13\7\3\b\3\b\7\b`\n\b\f\b\16\bc\13\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\7\fr\n\f\f\f\16\fu\13\f\5\fw"+
		"\n\f\3\r\3\r\3\16\3\16\3/\2\17\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13"+
		"\26\f\30\2\32\2\34\2\4\2\3\t\4\2C\\c|\6\2\62;C\\aac|\3\2$$\3\2\63;\3\2"+
		"\62;\4\2\f\f\17\17\4\2\13\13\"\"\2~\2\4\3\2\2\2\2\6\3\2\2\2\3\b\3\2\2"+
		"\2\3\n\3\2\2\2\3\f\3\2\2\2\3\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24"+
		"\3\2\2\2\3\26\3\2\2\2\4\36\3\2\2\2\6/\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2"+
		"\f:\3\2\2\2\16V\3\2\2\2\20]\3\2\2\2\22f\3\2\2\2\24h\3\2\2\2\26j\3\2\2"+
		"\2\30v\3\2\2\2\32x\3\2\2\2\34z\3\2\2\2\36\37\7C\2\2\37 \7p\2\2 !\7u\2"+
		"\2!\"\7y\2\2\"#\7g\2\2#$\7t\2\2$%\7<\2\2%&\7\"\2\2&\'\3\2\2\2\'(\5\30"+
		"\f\2()\5\32\r\2)*\3\2\2\2*+\b\2\2\2+\5\3\2\2\2,.\13\2\2\2-,\3\2\2\2.\61"+
		"\3\2\2\2/\60\3\2\2\2/-\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\5\32\r"+
		"\2\63\64\3\2\2\2\64\65\b\3\3\2\65\7\3\2\2\2\66\67\7.\2\2\67\t\3\2\2\2"+
		"89\5\30\f\29\13\3\2\2\2:R\5\32\r\2;<\7Q\2\2<=\7r\2\2=>\7v\2\2>?\7k\2\2"+
		"?@\7o\2\2@A\7k\2\2AB\7|\2\2BC\7c\2\2CD\7v\2\2DE\7k\2\2EF\7q\2\2FG\7p\2"+
		"\2GH\7<\2\2HN\3\2\2\2IJ\5\34\16\2JK\5\30\f\2KM\3\2\2\2LI\3\2\2\2MP\3\2"+
		"\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QS\5\32\r\2R;\3\2\2\2RS\3"+
		"\2\2\2ST\3\2\2\2TU\b\6\4\2U\r\3\2\2\2VZ\t\2\2\2WY\t\3\2\2XW\3\2\2\2Y\\"+
		"\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\Z\3\2\2\2]a\7$\2\2^`\n\4\2\2"+
		"_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7$\2\2"+
		"e\21\3\2\2\2fg\7*\2\2g\23\3\2\2\2hi\7+\2\2i\25\3\2\2\2jk\5\34\16\2kl\3"+
		"\2\2\2lm\b\13\3\2m\27\3\2\2\2nw\7\62\2\2os\t\5\2\2pr\t\6\2\2qp\3\2\2\2"+
		"ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3\2\2\2vn\3\2\2\2vo\3\2\2\2"+
		"w\31\3\2\2\2xy\t\7\2\2y\33\3\2\2\2z{\t\b\2\2{\35\3\2\2\2\13\2\3/NRZas"+
		"v\5\4\3\2\b\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}