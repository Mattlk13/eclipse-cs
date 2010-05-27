//============================================================================
//
// Copyright (C) 2009 Lukas Frena
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//============================================================================

package net.sf.eclipsecs.core.transformer.ctransformerclasses;

import java.util.StringTokenizer;

import net.sf.eclipsecs.core.transformer.FormatterConfiguration;
import net.sf.eclipsecs.core.transformer.CTransformationClass;

/**
 * Wrapperclass for converting the checkstyle-rule ParenPad to appropriate
 * eclipse-formatter-rules.
 * 
 * @author Lukas Frena
 */
public class ParenPadTransformer extends CTransformationClass {

    @Override
    public FormatterConfiguration transformRule() {
        String tokenString = getAttribute("tokens");
        if (tokenString == null) {
            tokenString = "CTOR_CALL, LPAREN, METHOD_CALL, RPAREN, SUPER_CTOR_CALL";
        }
        String option = getAttribute("option");
        if (option == null) {
            option = "nospace";
        }
        if (option.equals("nospace")) {
            option = "do not insert";
        }
        else {
            option = "insert";
        }

        final StringTokenizer tokens = new StringTokenizer(tokenString, ", ");
        String token;
        while (tokens.hasMoreTokens()) {
            token = tokens.nextToken();
            if (token.equals("LPAREN")) {
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_parenthesized_expression",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_while",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_for",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_if",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_switch",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_synchronized",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_catch",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_method_invocation",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_annotation",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_constructor_declaration",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_enum_constant",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_method_declaration",
                    option);
            }
            else if (token.equals("RPAREN")) {
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_parenthesized_expression",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_while",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_for",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_if",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_switch",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_synchronized",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_catch",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_method_invocation",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_method_declaration",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_constructor_declaration",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_enum_constant",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_annotation",
                    option);
            }
            else if (token.equals("CTOR_CALL") || token.equals("METHOD_CALL")
                || token.equals("SUPER_CTOR_CALL")) {
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_before_closing_paren_in_method_invocation",
                    option);
                useLocalSetting(
                    "org.eclipse.jdt.core.formatter.insert_space_after_opening_paren_in_method_invocation",
                    option);
            }
        }
        return getFormatterSetting();
    }

}
