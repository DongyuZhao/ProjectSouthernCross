package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.ISyntaxFacts;
import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

import java.util.HashMap;
import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */

/**
 * The implement of ISyntaxFacts for TweetQL
 */
public class TweetQlSyntaxFacts implements ISyntaxFacts {
    private static TweetQlSyntaxFacts ourInstance = new TweetQlSyntaxFacts();
    private HashMap<String, ISyntaxKind> keywordKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> specialSymbolKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> unaryOperatorKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> binaryOperatorKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> changeLineOperatorKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> lineCommentsTriggerKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> blockCommentsTriggerKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> blockCommentsTerminatorKindMap = new HashMap<>();

    /**
     * Get a new instance of TweetQlSyntaxFacts
     */
    private TweetQlSyntaxFacts() {
        this.keywordKindMap.put(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD);
        this.keywordKindMap.put(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD);

        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES);
        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET);
        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE);

        this.specialSymbolKindMap.put(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN);

        this.binaryOperatorKindMap.put(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD);
        this.binaryOperatorKindMap.put(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD);
        this.binaryOperatorKindMap.put(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD);
        this.binaryOperatorKindMap.put(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD);

        this.unaryOperatorKindMap.put(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD);

        this.changeLineOperatorKindMap.put(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN);
        this.changeLineOperatorKindMap.put(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN);

        this.lineCommentsTriggerKindMap.put(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN);

        this.blockCommentsTriggerKindMap.put(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN);
        this.blockCommentsTerminatorKindMap.put(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN);
    }

    /**
     * Get the singleton instance of the TweetQlSyntaxFacts class
     *
     * @return the singleton instance of the TweetQlSyntaxFacts class
     */
    public static TweetQlSyntaxFacts getInstance() {
        return ourInstance;
    }

    @Override
    public boolean isSyntaxToken(ISyntaxKind rawKind) {
        for (TweetQlTokenKind kind : TweetQlTokenKind.values()) {
            if (rawKind == kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSyntaxNode(ISyntaxKind rawKind) {
        for (TweetQlNodeKind kind : TweetQlNodeKind.values()) {
            if (rawKind == kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSyntaxTrivia(ISyntaxKind rawKind) {
        for (TweetQlTriviaKind kind : TweetQlTriviaKind.values()) {
            if (rawKind == kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isKeyword(String rawString) {
        return this.keywordKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isKeyword(ISyntaxKind rawKind) {
        return this.keywordKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isOperator(ISyntaxKind rawKind) {
        return this.isUnaryOperator(rawKind) || this.isBinaryOperator(rawKind);
    }

    @Override
    public boolean isOperator(String rawString) {
        return this.isUnaryOperator(rawString) || this.isBinaryOperator(rawString);
    }

    /**
     * Determine if the given plain text indicates a unary operator in this language
     * @param rawString the given plain text
     * @return if the given ISyntaxKind indicates a unary operator terminator
     */
    public boolean isUnaryOperator(String rawString) {
        return this.unaryOperatorKindMap.keySet().contains(rawString);
    }

    /**
     * Determine if the given plain text indicates a binary operator in this language
     * @param rawString the given plain text
     * @return if the given ISyntaxKind indicates a binary operator terminator
     */
    public boolean isBinaryOperator(String rawString) {
        return this.binaryOperatorKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isPredefinedType(String rawString) {
        return rawString.equals("twitter") || rawString.equals("stream");
    }

    @Override
    public boolean isPredefinedType(ISyntaxKind rawKind) {
        return this.specialSymbolKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isSpecialSymbol(String rawString) {
        return this.specialSymbolKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isSpecialSymbol(ISyntaxKind rawKind) {
        return this.specialSymbolKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isChangeLineSymbol(String rawString) {
        return this.changeLineOperatorKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isChangeLineSymbol(ISyntaxKind rawKind) {
        return this.changeLineOperatorKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isLineCommentsTrigger(String rawString) {
        return this.lineCommentsTriggerKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isLineCommentsTrigger(ISyntaxKind rawKind) {
        return this.lineCommentsTriggerKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isBlockCommentsTrigger(String rawString) {
        return this.blockCommentsTriggerKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isBlockCommentsTrigger(ISyntaxKind rawKind) {
        return this.blockCommentsTriggerKindMap.values().contains(rawKind);
    }

    @Override
    public boolean isBlockCommentsTerminator(String rawString) {
        return this.blockCommentsTerminatorKindMap.keySet().contains(rawString);
    }

    @Override
    public boolean isBlockCommentsTerminator(ISyntaxKind rawKind) {
        return this.blockCommentsTerminatorKindMap.values().contains(rawKind);
    }

    @Override
    public ISyntaxKind getSyntaxKind(String rawString) {
        if (this.isKeyword(rawString)) {
            return this.keywordKindMap.get(rawString);
        } else if (this.isSpecialSymbol(rawString)) {
            return this.specialSymbolKindMap.get(rawString);
        } if (this.isDigit(rawString)) {
            return TweetQlTokenKind.DIGIT_TOKEN;
        }
        return TweetQlTokenKind.IDENTIFIER_TOKEN;
    }

    @Override
    public Set<String> getSpecialSymbolList() {
        return this.specialSymbolKindMap.keySet();
    }

    @Override
    public Set<String> getChangeLineSymbols() {
        return this.changeLineOperatorKindMap.keySet();
    }

    @Override
    public String getLanguage() {
        return "TweetQL";
    }

    /**
     * Determine if the given ISyntaxKind indicates a unary operator in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a unary operator terminator
     */
    public boolean isUnaryOperator(ISyntaxKind rawKind) {
        return this.unaryOperatorKindMap.values().contains(rawKind);
    }

    /**
     * Determine if the given ISyntaxKind indicates a binary operator in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a binary operator terminator
     */
    public boolean isBinaryOperator(ISyntaxKind rawKind) {
        return this.binaryOperatorKindMap.values().contains(rawKind);
    }
}
