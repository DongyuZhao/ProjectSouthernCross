package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.ISyntaxFactory;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.SyntaxTrivia;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.*;
import project.code_analysis.tweet_ql.syntax.trivias.BlockCommentsTrivia;
import project.code_analysis.tweet_ql.syntax.trivias.ChangeLineTrivia;
import project.code_analysis.tweet_ql.syntax.trivias.LineCommentsTrivia;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/27.
 */
public class TweetQlSyntaxFactory implements ISyntaxFactory {
    private Session currentSession = new Session();
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private State currentState = State.IDLE;

    public static TweetQlSyntaxFactory create() {
        return new TweetQlSyntaxFactory();
    }

    @Override
    public SyntaxToken buildToken(String rawString) {
        switch (rawString) {
            case TweetQlTokenString.CREATE_KEYWORD:
                return (new CreateKeywordToken());
            case TweetQlTokenString.SELECT_KEYWORD:
                return (new SelectKeywordToken());
            case TweetQlTokenString.FROM_KEYWORD:
                return (new FromKeywordToken());
            case TweetQlTokenString.WHERE_KEYWORD:
                return (new WhereKeywordToken());
            case TweetQlTokenString.CONTAIN_KEYWORD:
                return (new ContainKeywordToken());
            case TweetQlTokenString.LIKE_KEYWORD:
                return (new LikeKeywordToken());
            case TweetQlTokenString.AND_KEYWORD:
                return (new AndKeywordToken());
            case TweetQlTokenString.OR_KEYWORD:
                return (new OrKeywordToken());
            case TweetQlTokenString.NOT_KEYWORD:
                return (new NotKeywordToken());
            case TweetQlTokenString.SKIP_KEYWORD:
                return (new SkipKeywordToken());
            case TweetQlTokenString.WINDOW_KEYWORD:
                return (new WindowKeywordToken());
            case TweetQlTokenString.AS_KEYWORD:
                return (new AsKeywordToken());
            case TweetQlTokenString.BETWEEN_KEYWORD:
                return (new BetweenKeywordToken());
            case TweetQlTokenString.ORDER_KEYWORD:
                return (new OrderKeywordToken());
            case TweetQlTokenString.BY_KEYWORD:
                return (new ByKeywordToken());
            case TweetQlTokenString.ASCEND_KEYWORD:
                return (new AscendKeywordToken());
            case TweetQlTokenString.DESCEND_KEYWORD:
                return (new DescendKeywordToken());
            case TweetQlTokenString.OPEN_PARENTHESES:
                return (new OpenParenthesesToken());
            case TweetQlTokenString.CLOSE_PARENTHESES:
                return (new CloseParenthesesToken());
            case TweetQlTokenString.OPEN_BRACKET:
                return (new OpenBracketToken());
            case TweetQlTokenString.CLOSE_BRACKET:
                return (new CloseBracketToken());
            case TweetQlTokenString.OPEN_BRACE:
                return (new OpenBraceToken());
            case TweetQlTokenString.CLOSE_BRACE:
                return (new CloseBraceToken());
            case TweetQlTokenString.COMMA:
                return (new CommaToken());
            case TweetQlTokenString.DOT:
                return (new DotToken());
            case TweetQlTokenString.COLON:
                return (new ColonToken());
            case TweetQlTokenString.SEMICOLON:
                return (new SemicolonToken());
            case TweetQlTokenString.EQUAL:
                return (new EqualToken());
            case TweetQlTokenString.BIGGER:
                return (new BiggerToken());
            case TweetQlTokenString.LESS:
                return (new LessToken());
            case TweetQlTokenString.BIGGER_EQUAL:
                return (new BiggerEqualToken());
            case TweetQlTokenString.LESS_EQUAL:
                return (new LessEqualToken());
            case TweetQlTokenString.CRLF:
                return (new CRLFToken());
            case TweetQlTokenString.LF:
                return (new LFToken());
            case TweetQlTokenString.STAR:
                return (new StarToken());
            case TweetQlTokenString.DOUBLE_SLASH:
                return (new DoubleSlashToken());
            case TweetQlTokenString.SLASH_STAR:
                return (new SlashStarToken());
            case TweetQlTokenString.STAR_SLASH:
                return (new StarSlashToken());
            default:
                if (rawString.matches("^\\s+$")) {
                    return new WhiteSpaceToken(rawString);
                } else if (TweetQlSyntaxFacts.getInstance().isLiteralString(rawString)) {
                    return new LiteralStringToken(rawString);
                } else if (TweetQlSyntaxFacts.getInstance().isValidIdentifier(rawString)) {
                    return new IdentifierToken(rawString);
                } else if (TweetQlSyntaxFacts.getInstance().isDigit(rawString)) {
                    return new DigitToken(rawString);
                } else {
                    return new TweetQlSyntaxToken(rawString, TweetQlTokenKind.UNDETERMINED_TOKEN);
                }
        }

    }

    @Override
    public List<SyntaxToken> bindSyntaxTrivia(List<SyntaxToken> rawTokenList) {
        for (int i = 0; i < rawTokenList.size(); i++) {
            SyntaxToken token = rawTokenList.get(i);
            switch (this.currentState) {
                case IDLE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CRLF_TOKEN:
                        case LF_TOKEN:
                            this.currentSession.appendLeadingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING);
                            break;
                        case DOUBLE_SLASH_TOKEN:
                            this.currentSession.appendLeadingTrivia(new LineCommentsTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING_LINE_COMMENTS);
                            break;
                        case SLASH_STAR_TOKEN:
                            this.currentSession.appendLeadingTrivia(new BlockCommentsTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING_BLOCK_COMMENTS);
                            break;
                        case WHITE_SPACE_TOKEN:
                            this.currentSession.appendLeadingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING);
                            break;
                        default:
                            this.currentSession.setToken(token);
                            this.changeState(State.TRIALING);
                            break;
                    }
                    break;
                case LEADING:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CRLF_TOKEN:
                        case LF_TOKEN:
                            this.currentSession.appendLeadingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            break;
                        case DOUBLE_SLASH_TOKEN:
                            this.currentSession.appendLeadingTrivia(new LineCommentsTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING_LINE_COMMENTS);
                            break;
                        case SLASH_STAR_TOKEN:
                            this.currentSession.appendLeadingTrivia(new BlockCommentsTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING_BLOCK_COMMENTS);
                            break;
                        case WHITE_SPACE_TOKEN:
                            this.currentSession.appendLeadingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            break;
                        default:
                            this.currentSession.setToken(token);
                            this.changeState(State.TRIALING);
                            break;
                    }
                    break;
                case TRIALING:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CRLF_TOKEN:
                        case LF_TOKEN:
                            this.currentSession.appendTrialingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            this.tokenList.add(this.currentSession.getToken());
                            this.changeState(State.IDLE);
                            break;
                        case DOUBLE_SLASH_TOKEN:
                            this.currentSession.appendTrialingTrivia(new LineCommentsTrivia());
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            this.changeState(State.TRIALING_LINE_COMMENTS);
                            break;
                        case SLASH_STAR_TOKEN:
                            this.currentSession.appendTrialingTrivia(new BlockCommentsTrivia());
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            this.changeState(State.TRIALING_BLOCK_COMMENTS);
                            break;
                        case WHITE_SPACE_TOKEN:
                            this.currentSession.appendTrialingTrivia(new ChangeLineTrivia());
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            break;
                        default:
                            this.tokenList.add(this.currentSession.getToken());
                            this.currentSession.setToken(token);
                            this.changeState(State.TRIALING);
                            break;
                    }
                    break;
                case LEADING_LINE_COMMENTS:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CRLF_TOKEN:
                        case LF_TOKEN:
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING);
                            break;
                        default:
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            break;
                    }
                    break;
                case TRIALING_LINE_COMMENTS:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CRLF_TOKEN:
                        case LF_TOKEN:
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            this.tokenList.add(this.currentSession.getToken());
                            this.changeState(State.IDLE);
                            break;
                        default:
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            break;
                    }
                    break;
                case LEADING_BLOCK_COMMENTS:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case STAR_SLASH_TOKEN:
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            this.changeState(State.LEADING);
                            break;
                        default:
                            this.currentSession.appendTokenToCurrentLeadingTrivia(token);
                            break;
                    }
                    break;
                case TRIALING_BLOCK_COMMENTS:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case STAR_SLASH_TOKEN:
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            this.changeState(State.TRIALING);
                            break;
                        default:
                            this.currentSession.appendTokenToCurrentTrialingTrivia(token);
                            break;
                    }
                    break;
            }
        }
        if (this.currentSession.peak() != null) {
            this.tokenList.add(this.currentSession.getToken());
        }
        return this.tokenList;
    }

    private void changeState(State state) {
        this.currentState = state;
    }

    private void submitSession() {
        this.tokenList.add(this.currentSession.getToken());
        this.currentState = State.IDLE;
    }

    private enum State {
        IDLE,
        LEADING,
        TRIALING,
        LEADING_LINE_COMMENTS,
        TRIALING_LINE_COMMENTS,
        LEADING_BLOCK_COMMENTS,
        TRIALING_BLOCK_COMMENTS,
    }

    private class Session {
        private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
        private SyntaxToken token;

        public SyntaxToken peak() {
            return this.token;
        }

        public void appendLeadingTrivia(SyntaxTrivia trivia) {
            if (this.leadingTrivia == null) {
                this.leadingTrivia = new ArrayList<>();
            }
            this.leadingTrivia.add(trivia);
        }

        public void appendTrialingTrivia(SyntaxTrivia trivia) {
            if (this.token != null) {
                this.token.addTrialingTrivia(trivia);
            }
        }

        public void appendTokenToCurrentLeadingTrivia(SyntaxToken token) {
            if (this.leadingTrivia.size() != 0) {
                this.leadingTrivia.get(this.leadingTrivia.size() - 1).addChildToken(token);
            }
        }

        public void appendTokenToCurrentTrialingTrivia(SyntaxToken token) {
            if (this.token != null && this.token.getTrialingTrivia().size() != 0) {
                this.token.getTrialingTrivia().get(this.token.getTrialingTrivia().size() - 1).addChildToken(token);
            }
        }

        public SyntaxToken getToken() {
            SyntaxToken result = this.token;
            this.leadingTrivia.clear();
            this.token = null;
            return result;
        }

        public void setToken(SyntaxToken token) {
            this.token = token;
            if (this.token != null) {
                this.leadingTrivia.forEach(this.token::addLeadingTrivia);
            }
        }
    }
}
