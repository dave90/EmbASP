package it.unical.mat.embasp.languages.asp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import it.unical.mat.embasp.languages.Mapper;
import it.unical.mat.embasp.languages.asp.parser.ASPGrammarBaseVisitorImplementation;
import it.unical.mat.embasp.languages.asp.parser.ASPGrammarParser.Predicate_atomContext;

/**
 * Contains methods used to transform Objects into {@link it.unical.mat.embasp.base.InputProgram}
 */

public class ASPMapper extends Mapper {

	private static ASPMapper mapper;

	public static ASPMapper getInstance() {
		if (ASPMapper.mapper == null)
			ASPMapper.mapper = new ASPMapper();
		return ASPMapper.mapper;
	}

	private ASPMapper() {
		super();
	}

	@Override
	protected String getActualString(final String predicate, final HashMap<Integer, Object> parametersMap) throws IllegalTermException {
		if (parametersMap.isEmpty())
			return predicate;

		String atom = predicate + "(";
		for (int i = 0; i < parametersMap.size(); i++) {
			if (i != 0)
				atom += ",";
			final Object objectTerm = parametersMap.get(i);
			if (objectTerm == null)
				throw new IllegalTermException("Wrong term number of predicate " + predicate);
			if (objectTerm instanceof Integer)
				atom += objectTerm + "";
			else
				atom += "\"" + objectTerm.toString() + "\"";
		}
		atom += ")";
		return atom;

	}

	public Set<Object> getObjects(final String atomsList) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		final ASPGrammarBaseVisitorImplementation aspVisitor = new ASPGrammarBaseVisitorImplementation();
		final Set <Object> objects = new HashSet <> ();
		
		for(final Predicate_atomContext predicateAtom : ASPGrammarBaseVisitorImplementation.getPredicateAtoms(atomsList)) {
			aspVisitor.resetParameters();
			
			final String predicate = aspVisitor.visitPredicate_atom(predicateAtom);
			final Class<?> cl = getClass(predicate);

			if (cl == null)
				continue;
			
			final String[] parameters = aspVisitor.getParameters();
			final Object obj = cl.newInstance();

			populateObject(cl, parameters, obj);
			objects.add(obj);
		}

		return objects;
	}
	
	@Override
	protected String[] getParameters(final String string) {
		final int start = string.indexOf("(") + 1;
		final int end = string.lastIndexOf(")");
		// FIXME Not work with "a("asd,"). fix the split
		return start == 0 || end == -1 || end < start ? new String[0] : string.substring(start, end).split(",");
	}

	@Override
	protected String getPredicate(final String string) throws IllegalArgumentException {

		final int indexOf = string.indexOf("(");

		if (indexOf == -1) // Arity 0
			return string;

		return string.substring(0, string.indexOf("("));

	}

}
