package project.southern_cross.undeterminded;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/16.
 */
public class ConfigManager {

    private Class syntaxTokenKindConfiguration;

    private Class syntaxNodeKindConfiguration;

    private Class syntaxFactsClass;

    // private ArrayList<Integer> globalStates = new ArrayList<>();

    private HashMap<Integer, ArrayList<Method>> syntaxRules = new HashMap<>();

    private HashMap<Integer, ArrayList<Method>> triviaRules = new HashMap<>();

    public Class getSyntaxTokenKindConfiguration() {
        return syntaxTokenKindConfiguration;
    }

    public Class getSyntaxNodeKindConfiguration() {
        return syntaxNodeKindConfiguration;
    }

    public Class getSyntaxFactsClass() {
        return syntaxFactsClass;
    }

    public Set<Integer> getGlobalStates() {
        return this.syntaxRules.keySet();
    }

    public HashMap<Integer, ArrayList<Method>> getSyntaxRules() {
        return syntaxRules;
    }

    public HashMap<Integer, ArrayList<Method>> getTriviaRules() {
        return triviaRules;
    }

    public void setSyntaxTokenKindConfiguration(Class syntaxTokenKindConfiguration) {
        this.syntaxTokenKindConfiguration = syntaxTokenKindConfiguration;
    }

    public void setSyntaxNodeKindConfiguration(Class syntaxNodeKindConfiguration) {
        this.syntaxNodeKindConfiguration = syntaxNodeKindConfiguration;
    }

    public void setSyntaxFactsClass(Class syntaxFactsClass) {
        this.syntaxFactsClass = syntaxFactsClass;
    }

    public Set<Method> getSyntaxRule(int prerequisiteState) {
        Set<Method> result = new HashSet<>();
        if (this.syntaxRules.containsKey(prerequisiteState)) {
            this.syntaxRules.get(prerequisiteState).forEach(result::add);
        }
        return result;
    }

    public Set<Method> getTriviaRule(int exceptionState) {
        Set<Method> result = new HashSet<>();
        if (this.triviaRules.containsKey(exceptionState)) {
            this.triviaRules.get(exceptionState).forEach(result::add);
        }
        return result;
    }
}
