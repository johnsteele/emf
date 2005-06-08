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
 *
 * $Id: JavaFactoryImpl.java,v 1.3.2.1 2005/06/08 18:27:42 nickb Exp $
 */
package org.eclipse.emf.java.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.java.*;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory
{
  /**
   * Creates and instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case JavaPackage.JCLASS: return createJClass();
      case JavaPackage.JCOMPILATION_UNIT: return createJCompilationUnit();
      case JavaPackage.JFIELD: return createJField();
      case JavaPackage.JINITIALIZER: return createJInitializer();
      case JavaPackage.JMETHOD: return createJMethod();
      case JavaPackage.JPACKAGE: return createJPackage();
      case JavaPackage.JPARAMETER: return createJParameter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case JavaPackage.JVISIBILITY:
      {
        JVisibility result = JVisibility.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
      }
      case JavaPackage.JAVA_PACKAGE:
        return createJavaPackageFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case JavaPackage.JVISIBILITY:
        return instanceValue == null ? null : instanceValue.toString();
      case JavaPackage.JAVA_PACKAGE:
        return convertJavaPackageToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JClass createJClass()
  {
    JClassImpl jClass = new JClassImpl();
    return jClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JCompilationUnit createJCompilationUnit()
  {
    JCompilationUnitImpl jCompilationUnit = new JCompilationUnitImpl();
    return jCompilationUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JField createJField()
  {
    JFieldImpl jField = new JFieldImpl();
    return jField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JInitializer createJInitializer()
  {
    JInitializerImpl jInitializer = new JInitializerImpl();
    return jInitializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JMethod createJMethod()
  {
    JMethodImpl jMethod = new JMethodImpl();
    return jMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JParameter createJParameter()
  {
    JParameterImpl jParameter = new JParameterImpl();
    return jParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JPackage createJPackage()
  {
    JPackageImpl jPackage = new JPackageImpl();
    return jPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Package createJavaPackageFromString(EDataType eDataType, String initialValue)
  {
    return (Package)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertJavaPackageToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaPackage getJavaPackage()
  {
    return (JavaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static JavaPackage getPackage()
  {
    return JavaPackage.eINSTANCE;
  }

} //JavaFactoryImpl
