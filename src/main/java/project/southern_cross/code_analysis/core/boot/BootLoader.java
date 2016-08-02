package project.southern_cross.code_analysis.core.boot;


import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import project.southern_cross.code_analysis.core.annotation.*;
import project.southern_cross.code_analysis.core.config.*;

import java.util.*;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/26.
 */
public class BootLoader {
    private static boolean ready;

    private static boolean loading;

    private static HashMap<String, SyntaxParserConfig> parserConfigs = new HashMap<>();

    private static HashMap<String, SyntaxFacts> syntaxFacts = new HashMap<>();

    private static HashMap<String, Map<Integer, Set<SyntaxParseRule>>> parseRules = new HashMap<>();

    private static HashMap<String, Map<Integer, Set<SyntaxErrorRule>>> errorRules = new HashMap<>();

    private static HashMap<String, Set<SyntaxTriviaRule>> triviaRules = new HashMap<>();

    public static Optional<SyntaxParserConfig> getParserConfig(String language) {
        if (ready) {
            if (parserConfigs.keySet().contains(language)) {
                return Optional.ofNullable(parserConfigs.get(language));
            }
        }
        return Optional.empty();
    }

    public static Optional<SyntaxFacts> getSyntaxFacts(String language) {
        if (ready) {
            if (syntaxFacts.keySet().contains(language)) {
                return Optional.ofNullable(syntaxFacts.get(language));
            }
        }
        return Optional.empty();
    }

    public static Optional<Map<Integer, Set<SyntaxParseRule>>> getParseRules(String language) {
        if (ready) {
            if (parseRules.keySet().contains(language)) {
                return Optional.ofNullable(parseRules.get(language));
            }
        }
        return Optional.empty();
    }

    public static Optional<Map<Integer, Set<SyntaxErrorRule>>> getErrorRules(String language) {
        if (ready) {
            if (errorRules.keySet().contains(language)) {

                return Optional.of(errorRules.get(language));
            }
        }
        return Optional.empty();
    }

    public static Optional<Set<SyntaxTriviaRule>> getTriviaRules(String language) {
        if (ready) {
            if (triviaRules.keySet().contains(language)) {
                return Optional.ofNullable(triviaRules.get(language));
            }
        }
        return Optional.empty();
    }

    public static boolean isReady() {
        return ready;
    }

    public static boolean isLoading() {
        return loading;
    }

    public static synchronized void load() {
        if (!loading) {
            loading = true;
            ready = false;
            loadSyntaxFacts();
            loadSyntaxParserConfigs();
            loadSyntaxRules();
            loadErrorRules();
            loadTriviaRules();
            loading = false;
            ready = true;
        }
    }

    private static void loadSyntaxFacts() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxFactsClass.class)).forEach(c -> {
            if (SyntaxFacts.class.isAssignableFrom(c)) {
                try {
                    syntaxFacts.put(c.getAnnotation(SyntaxFactsClass.class).language().toLowerCase(), (SyntaxFacts) (c.newInstance()));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void loadSyntaxParserConfigs() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxParserConfigClass.class)).forEach(c -> {
            if (SyntaxParserConfig.class.isAssignableFrom(c)) {
                try {
                    parserConfigs.put(c.getAnnotation(SyntaxParserConfigClass.class).language().toLowerCase(), (SyntaxParserConfig) (c.newInstance()));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void loadSyntaxRules() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxRuleClass.class)).forEach(c -> {
            if (SyntaxParseRule.class.isAssignableFrom(c)) {
                try {
                    String language = c.getAnnotation(SyntaxRuleClass.class).language().toLowerCase();
                    if (!parseRules.containsKey(language)) {
                        parseRules.put(language, new HashMap<>());
                    }
                    int prerequisiteState = c.getAnnotation(SyntaxRuleClass.class).prerequisiteState();
                    if (!parseRules.get(language).containsKey(prerequisiteState)) {
                        parseRules.get(language).put(prerequisiteState, new HashSet<>());
                    }
                    parseRules.get(language).get(prerequisiteState).add((SyntaxParseRule) (c.newInstance()));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void loadErrorRules() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxErrorRuleClass.class)).forEach(c -> {
            if (SyntaxErrorRule.class.isAssignableFrom(c)) {
                try {
                    String language = c.getAnnotation(SyntaxErrorRuleClass.class).language().toLowerCase();
                    if (!errorRules.containsKey(language)) {
                        errorRules.put(language, new HashMap<>());
                    }
                    int prerequisiteState = c.getAnnotation(SyntaxErrorRuleClass.class).prerequisiteState();
                    if (!errorRules.get(language).containsKey(prerequisiteState)) {
                        errorRules.get(language).put(prerequisiteState, new HashSet<>());
                    }
                    errorRules.get(language).get(prerequisiteState).add((SyntaxErrorRule) (c.newInstance()));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void loadTriviaRules() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(TriviaRuleClass.class)).forEach(c -> {
            if (SyntaxTriviaRule.class.isAssignableFrom(c)) {
                try {
                    String language = c.getAnnotation(TriviaRuleClass.class).language().toLowerCase();
                    if (!triviaRules.containsKey(language)) {
                        triviaRules.put(language, new HashSet<>());
                    }
                    triviaRules.get(language).add((SyntaxTriviaRule) (c.newInstance()));
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
