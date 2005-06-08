package org.eclipse.emf.codegen.ecore.templates.model;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class EnumClass
{
  protected final String NL = System.getProperties().getProperty("line.separator");
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**" + NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_3 = "Id";
  protected final String TEXT_4 = NL + " */" + NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the literals of the enumeration '<em><b>";
  protected final String TEXT_7 = "</b></em>'," + NL + " * and utility methods for working with them." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_8 = NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_9 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_10 = NL + " * @see ";
  protected final String TEXT_11 = "#get";
  protected final String TEXT_12 = "()" + NL + " * @model" + NL + " * @generated" + NL + " */" + NL + "public final class ";
  protected final String TEXT_13 = " extends AbstractEnumerator" + NL + "{";
  protected final String TEXT_14 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_15 = " copyright = \"";
  protected final String TEXT_16 = "\";";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t/**" + NL + "\t * The '<em><b>";
  protected final String TEXT_19 = "</b></em>' literal value." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_20 = "_LITERAL" + NL + "\t * @model ";
  protected final String TEXT_21 = NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tpublic static final int ";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL;
  protected final String TEXT_24 = NL + "\t/**" + NL + "\t * The '<em><b>";
  protected final String TEXT_25 = "</b></em>' literal object." + NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_26 = NL + "\t * <p>" + NL + "\t * If the meaning of '<em><b>";
  protected final String TEXT_27 = "</b></em>' literal object isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_28 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_29 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_30 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_31 = NL + "\t * @see #";
  protected final String TEXT_32 = NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = "_LITERAL = new ";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ", \"";
  protected final String TEXT_37 = "\");";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + "\t/**" + NL + "\t * An array of all the '<em><b>";
  protected final String TEXT_40 = "</b></em>' enumerators." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final ";
  protected final String TEXT_41 = "[] VALUES_ARRAY =" + NL + "\t\tnew ";
  protected final String TEXT_42 = "[]" + NL + "\t\t{";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = "_LITERAL,";
  protected final String TEXT_45 = NL + "\t\t};" + NL + "" + NL + "\t/**" + NL + "\t * A public read-only list of all the '<em><b>";
  protected final String TEXT_46 = "</b></em>' enumerators." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));" + NL + "" + NL + "\t/**" + NL + "\t * Returns the '<em><b>";
  protected final String TEXT_47 = "</b></em>' literal with the specified name." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_48 = " get(";
  protected final String TEXT_49 = " name)" + NL + "\t{" + NL + "\t\tfor (int i = 0; i < VALUES_ARRAY.length; ++i)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_50 = " result = VALUES_ARRAY[i];" + NL + "\t\t\tif (result.toString().equals(name))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the '<em><b>";
  protected final String TEXT_51 = "</b></em>' literal with the specified value." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_52 = " get(int value)" + NL + "\t{" + NL + "\t\tswitch (value)" + NL + "\t\t{";
  protected final String TEXT_53 = NL + "\t\t\tcase ";
  protected final String TEXT_54 = ": return ";
  protected final String TEXT_55 = "_LITERAL;";
  protected final String TEXT_56 = NL + "\t\t}" + NL + "\t\treturn null;\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Only this class can construct instances." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_57 = "(int value, ";
  protected final String TEXT_58 = " name)" + NL + "\t{" + NL + "\t\tsuper(value, name);" + NL + "\t}" + NL + "" + NL + "} //";
  protected final String TEXT_59 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenEnum genEnum = (GenEnum)argument; GenPackage genPackage = genEnum.getGenPackage(); GenModel genModel=genPackage.getGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_5);
    genModel.addImport("java.util.Arrays");
    genModel.addImport("java.util.List");
    genModel.addImport("java.util.Collections");
    genModel.addImport("org.eclipse.emf.common.util.AbstractEnumerator");
    genModel.markImportLocation(stringBuffer, genPackage);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_7);
    if (genEnum.hasDocumentation()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genEnum.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_13);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_17);
    }
    for (Iterator l=genEnum.getGenEnumLiterals().iterator(); l.hasNext();) { GenEnumLiteral genEnumLiteral = (GenEnumLiteral)l.next();
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genEnumLiteral.getFormattedName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genEnumLiteral.getModelInfo());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genEnumLiteral.getValue());
    stringBuffer.append(TEXT_23);
    }
    for (Iterator l=genEnum.getGenEnumLiterals().iterator(); l.hasNext();) { GenEnumLiteral genEnumLiteral = (GenEnumLiteral)l.next();
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genEnumLiteral.getFormattedName());
    stringBuffer.append(TEXT_25);
    if (!genEnumLiteral.hasDocumentation()) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genEnumLiteral.getFormattedName());
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    if (genEnumLiteral.hasDocumentation()) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genEnumLiteral.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genEnumLiteral.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_42);
    for (Iterator l=genEnum.getGenEnumLiterals().iterator(); l.hasNext();) { GenEnumLiteral genEnumLiteral = (GenEnumLiteral)l.next();
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genEnum.getFormattedName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_52);
    for (Iterator l=genEnum.getUniqueValuedGenEnumLiterals().iterator(); l.hasNext();) { GenEnumLiteral genEnumLiteral = (GenEnumLiteral)l.next();
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genEnumLiteral.getEnumLiteralID());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genEnum.getName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}
