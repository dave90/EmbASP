from .solver_planning_domains.SPDGrammarVisitorImplementation import SPDGrammarVisitorImplementation

class PDDLSolversParser(object):
    @staticmethod
    def parse_solver_planning_domains(actions, spdOutput, two_stageParsing):
        return SPDGrammarVisitorImplementation.parse(actions, spdOutput, two_stageParsing)
