package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.ISyntaxFacts;
import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlSyntaxTriviaKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

import java.util.HashMap;
import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class TweetQlSyntaxFacts implements ISyntaxFacts {
    private static TweetQlSyntaxFacts ourInstance = new TweetQlSyntaxFacts();
    private HashMap<String, ISyntaxKind> keywordKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> specialSymbolKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> unaryOperatorKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> binaryOperatorKindMap = new HashMap<>();
    private HashMap<String, ISyntaxKind> changeLineOperatorKindMap = new HashMap<>();
    private TweetQlSyntaxFacts() {
        this.keywordKindMap.put(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.AND_KEYWORD, TweetQlSyntaxTokenKind.AND_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxTokenKind.AS_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlSyntaxTokenKind.BETWEEN_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN);
        this.keywordKindMap.put(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_PARENTHESES, TweetQlSyntaxTokenKind.OPEN_PARENTHESES_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_BRACKET, TweetQlSyntaxTokenKind.OPEN_BRACKET_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.SEMICOLON, TweetQlSyntaxTokenKind.SEMICOLON_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN);

        this.specialSymbolKindMap.put(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN);
        this.specialSymbolKindMap.put(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN);

        this.binaryOperatorKindMap.put(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.AND_KEYWORD, TweetQlSyntaxTokenKind.AND_KEYWORD_TOKEN);
        this.binaryOperatorKindMap.put(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN);

        this.unaryOperatorKindMap.put(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN);

        this.changeLineOperatorKindMap.put(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN);
        this.changeLineOperatorKindMap.put(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN);

    }

    public static TweetQlSyntaxFacts getInstance() {
        return ourInstance;
    }

    @Override
    public boolean isSyntaxToken(ISyntaxKind rawKind) {
        for (TweetQlSyntaxTokenKind kind : TweetQlSyntaxTokenKind.values()) {
            if (rawKind == kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSyntaxNode(ISyntaxKind rawKind) {
        for (TweetQlSyntaxNodeKind kind : TweetQlSyntaxNodeKind.values()) {
            if (rawKind == kind) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSyntaxTrivia(ISyntaxKind rawKind) {
        for (TweetQlSyntaxTriviaKind kind : TweetQlSyntaxTriviaKind.values()) {
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

    public boolean isUnaryOperator(String rawString) {
        return this.unaryOperatorKindMap.keySet().contains(rawString);
    }

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
        return false;
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
        return false;
    }

    @Override
    public boolean isLineCommentsTrigger(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isBlockCommentsTrigger(String rawString) {
        return false;
    }

    @Override
    public boolean isBlockCommentsTrigger(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isBlockCommentsTerminator(String rawString) {
        return false;
    }

    @Override
    public boolean isBlockCommentsTerminator(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public ISyntaxKind getSyntaxKind(String rawString) {
        if (this.isKeyword(rawString)) {
            return this.keywordKindMap.get(rawString);
        } else if (this.isSpecialSymbol(rawString)) {
            return this.specialSymbolKindMap.get(rawString);
        } if (this.isDigit(rawString)) {
            return TweetQlSyntaxTokenKind.DIGIT_TOKEN;
        }
        return TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN;
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

    public boolean isUnaryOperator(ISyntaxKind rawKind) {
        return this.unaryOperatorKindMap.values().contains(rawKind);
    }

    public boolean isBinaryOperator(ISyntaxKind rawKind) {
        return this.binaryOperatorKindMap.values().contains(rawKind);
    }
}
