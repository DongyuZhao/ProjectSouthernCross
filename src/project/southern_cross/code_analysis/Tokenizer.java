package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class Tokenizer {

    private enum TokenizerStates {
        leadingSpace,
        trialingSpace,
        text,
        specialToken
    }

    private class TokenizerSession {
        private StringBuilder stringBuilder = new StringBuilder();
        private int spanStart = 0;
        private int spanEnd = 0;
        private int fullSpanStart = 0;
        private int fullSpanEnd = 0;

        TokenizerSession(int spanStart, int fullSpanStart) {
            this.spanStart = spanStart;
            this.fullSpanStart = fullSpanStart;
            this.spanEnd = this.spanStart;
            this.fullSpanEnd = this.fullSpanStart;
        }

        void appendCharacter(char c){
            this.stringBuilder.append(c);
            this.spanEnd += 1;
            this.fullSpanEnd += 1;
        }

        void appendSpace(){
            this.fullSpanEnd += 1;
        }

        String getRawString() {
            return this.stringBuilder.toString();
        }

        int getSpanStart() {
            return spanStart;
        }

        int getSpanEnd() {
            return spanEnd;
        }

        int getFullSpanStart() {
            return fullSpanStart;
        }

        int getFullSpanEnd() {
            return fullSpanEnd;
        }
    }

    private String rawInput;

    private ArrayList<String> specialTokenList;

    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();

    private TokenizerSession currentSession;

    private TokenizerStates currentState = TokenizerStates.leadingSpace;

    private int currentPosition = 0;

    public Tokenizer(String rawInput, ArrayList<String> specialTokenList) {
        this.rawInput = rawInput;
        this.specialTokenList = specialTokenList;
        this.createNewSession();
    }

    private void createNewSession() {
        this.currentSession = new TokenizerSession(this.currentPosition, this.currentPosition);
    }

    private void submitSession() {
        this.tokenList.add(
                new SyntaxToken(
                        null,
                        this.currentSession.getRawString(),
                        this.currentSession.getSpanStart(),
                        this.currentSession.getSpanEnd(),
                        this.currentSession.getFullSpanStart(),
                        this.currentSession.getFullSpanEnd(),
                        SyntaxKind.Undetermined,
                        false)
        );
    }

    private void changeState(TokenizerStates newState) {
        this.currentState = newState;
    }

    private boolean isSpecialToken(char c) {
        return this.specialTokenList.contains("" + c);
    }

    private boolean isSpecialToken(String s) {
        return this.specialTokenList.contains(s);
    }

    public ArrayList<SyntaxToken> tokenize() {
        for (char c: this.rawInput.toCharArray()) {
            if (c == '\r' || c == '\n'){
                if (!this.currentSession.getRawString().equals("")){
                    this.submitSession();
                    this.createNewSession();
                    this.changeState(TokenizerStates.leadingSpace);
                    this.currentPosition += 1;
                    continue;
                }
            }
            if (this.currentState == TokenizerStates.leadingSpace && !Character.isWhitespace(c) && !this.isSpecialToken(c)) {
                this.createNewSession();
                this.changeState(TokenizerStates.text);
                this.currentSession.appendCharacter(c);
                this.currentPosition += 1;
                continue;
            }
            if (this.isSpecialToken(c)) {
                if (this.currentState == TokenizerStates.text || this.currentState == TokenizerStates.trialingSpace) {
                    this.submitSession();
                    this.createNewSession();
                    this.changeState(TokenizerStates.specialToken);
                }
                if (this.currentState == TokenizerStates.specialToken) {
                    if (this.isSpecialToken(this.currentSession.getRawString() + c)) {
                        this.currentSession.appendCharacter(c);
                    }
                    else {
                        this.submitSession();
                        this.createNewSession();
                        this.changeState(TokenizerStates.specialToken);
                        this.currentSession.appendCharacter(c);
                    }
                }
                this.currentPosition += 1;
                continue;
            }
            if((this.currentState == TokenizerStates.specialToken || this.currentState == TokenizerStates.trialingSpace) && !Character.isWhitespace(c) && !this.isSpecialToken(c)){
                this.submitSession();
                this.createNewSession();
                this.changeState(TokenizerStates.text);
                this.currentSession.appendCharacter(c);
                this.currentPosition += 1;
                continue;
            }
            if (this.currentState == TokenizerStates.text && !Character.isWhitespace(c) && !this.isSpecialToken(c)) {
                this.currentSession.appendCharacter(c);
                this.currentPosition += 1;
                continue;
            }
            if ((this.currentState == TokenizerStates.text || this.currentState == TokenizerStates.specialToken) && Character.isWhitespace(c)) {
                this.changeState(TokenizerStates.trialingSpace);
                this.currentSession.appendSpace();
                this.currentPosition += 1;
                continue;
            }
            if (this.currentState == TokenizerStates.trialingSpace && Character.isWhitespace(c)) {
                this.currentSession.appendSpace();
                this.currentPosition += 1;
                continue;
            }
        }
        if (!this.currentSession.getRawString().equals("")) {
            this.submitSession();
        }
        return this.tokenList;
    }
}
