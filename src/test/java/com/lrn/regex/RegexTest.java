package com.lrn.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dongxiaohong on 2018/11/1 14:47
 */
public class RegexTest {
    @Test
    public void regexT01(){
        Pattern pattern = Pattern.compile("^\\s*([0-9]*)\\s*[万]?\\s*[元]?\\s*$");
        Matcher matcher = pattern.matcher(" 9580万");
        System.out.println(matcher.group(1));
    }
}
