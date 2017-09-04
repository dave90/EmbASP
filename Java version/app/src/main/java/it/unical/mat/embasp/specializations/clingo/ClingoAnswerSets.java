package it.unical.mat.embasp.specializations.clingo;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.specializations.clingo.parser.ClingoParserBaseVisitorImplementation;

/** represents Clingo's answersets */

public class ClingoAnswerSets extends AnswerSets {

	public ClingoAnswerSets(final String answersets) {
		super(answersets);
	}

	public ClingoAnswerSets(final String out, final String err) {
		super(out, err);
	}

	@Override
	protected void parse() {
		ClingoParserBaseVisitorImplementation.walk(answersets, output);
	}
}
