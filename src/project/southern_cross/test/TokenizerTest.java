package project.southern_cross.test;

import org.junit.Before;
import org.junit.Test;
import project.southern_cross.code_analysis.Span;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Junjie on 17/05/2016.
 */
public class TokenizerTest {

    Tokenizer tokenizer;




    @Test
    public void test1(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select from where.";
        tokenizer = new Tokenizer(s, TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("select", token.get(0).rawString());
        assertEquals("from", token.get(1).rawString());
        assertEquals("where", token.get(2).rawString());
        assertEquals(".", token.get(3).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test2(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select+ +from ";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("select", token.get(0).rawString());
        assertEquals("+", token.get(1).rawString());
        assertEquals("+", token.get(2).rawString());
        assertEquals("from", token.get(3).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }

    }

    @Test
    public void test3(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("select", token.get(0).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test4(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="s";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("s", token.get(0).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test5(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="from+where are";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("from", token.get(0).rawString());
        assertEquals("+", token.get(1).rawString());
        assertEquals("where", token.get(2).rawString());
        assertEquals("are", token.get(3).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test6(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s=" are.+";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("are", token.get(0).rawString());
        assertEquals(".", token.get(1).rawString());
        assertEquals("+", token.get(2).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test7(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s=" hello. world.";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        assertEquals("hello", token.get(0).rawString());
        assertEquals(".", token.get(1).rawString());
        assertEquals("world", token.get(2).rawString());
        assertEquals(".", token.get(3).rawString());
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test8(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select from where";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test9(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select+from";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }

    @Test
    public void test10(){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        String s="select&&from";
        tokenizer = new Tokenizer(s,TweetQlSyntaxKind.Operator.keySet());
        ArrayList<SyntaxToken> token=new ArrayList<>();
        token=tokenizer.tokenize();
        for(int i=0;i<token.size()-1;i++) {
            assertEquals(token.get(i+1).span().start(), token.get(i).fullSpan().end());
        }
    }
}