/**
 * <copyright>
 *
 * Copyright (c) 2003-2004 IBM Corporation and others.
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
 * $Id: XMLNamespacePackageImpl.java,v 1.6.2.1 2005/06/08 18:27:42 nickb Exp $
 */
package org.eclipse.emf.ecore.xml.namespace.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.namespace.SpaceType;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespaceDocumentRoot;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespaceFactory;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.impl.XMLTypePackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMLNamespacePackageImpl extends EPackageImpl implements XMLNamespacePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xmlNamespaceDocumentRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum spaceTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType spaceTypeObjectEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private XMLNamespacePackageImpl()
  {
    super(eNS_URI, XMLNamespaceFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static XMLNamespacePackage init()
  {
    if (isInited) return (XMLNamespacePackage)EPackage.Registry.INSTANCE.getEPackage(XMLNamespacePackage.eNS_URI);

    // Obtain or create and register package
    XMLNamespacePackageImpl theXMLNamespacePackage = (XMLNamespacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof XMLNamespacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new XMLNamespacePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackageImpl.init();

    // Create package meta-data objects
    theXMLNamespacePackage.createPackageContents();

    // Initialize created meta-data
    theXMLNamespacePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theXMLNamespacePackage.freeze();

    return theXMLNamespacePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXMLNamespaceDocumentRoot()
  {
    return xmlNamespaceDocumentRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMLNamespaceDocumentRoot_Mixed()
  {
    return (EAttribute)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMLNamespaceDocumentRoot_XMLNSPrefixMap()
  {
    return (EReference)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXMLNamespaceDocumentRoot_XSISchemaLocation()
  {
    return (EReference)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMLNamespaceDocumentRoot_Base()
  {
    return (EAttribute)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMLNamespaceDocumentRoot_Lang()
  {
    return (EAttribute)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getXMLNamespaceDocumentRoot_Space()
  {
    return (EAttribute)xmlNamespaceDocumentRootEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSpaceType()
  {
    return spaceTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getSpaceTypeObject()
  {
    return spaceTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XMLNamespaceFactory getXMLNamespaceFactory()
  {
    return (XMLNamespaceFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    xmlNamespaceDocumentRootEClass = createEClass(XML_NAMESPACE_DOCUMENT_ROOT);
    createEAttribute(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__MIXED);
    createEReference(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
    createEReference(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
    createEAttribute(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__BASE);
    createEAttribute(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__LANG);
    createEAttribute(xmlNamespaceDocumentRootEClass, XML_NAMESPACE_DOCUMENT_ROOT__SPACE);

    // Create enums
    spaceTypeEEnum = createEEnum(SPACE_TYPE);

    // Create data types
    spaceTypeObjectEDataType = createEDataType(SPACE_TYPE_OBJECT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackageImpl theXMLTypePackage = (XMLTypePackageImpl)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(xmlNamespaceDocumentRootEClass, XMLNamespaceDocumentRoot.class, "XMLNamespaceDocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getXMLNamespaceDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMLNamespaceDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXMLNamespaceDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMLNamespaceDocumentRoot_Base(), theXMLTypePackage.getAnyURI(), "base", null, 0, -2, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMLNamespaceDocumentRoot_Lang(), theXMLTypePackage.getLanguage(), "lang", null, 0, -2, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getXMLNamespaceDocumentRoot_Space(), this.getSpaceType(), "space", "preserve", 0, -2, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(spaceTypeEEnum, SpaceType.class, "SpaceType");
    addEEnumLiteral(spaceTypeEEnum, SpaceType.DEFAULT_LITERAL);
    addEEnumLiteral(spaceTypeEEnum, SpaceType.PRESERVE_LITERAL);

    // Initialize data types
    initEDataType(spaceTypeObjectEDataType, SpaceType.class, "SpaceTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (spaceTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "space_._type"
       });		
    addAnnotation
      (spaceTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "space_._type:Object",
       "baseType", "space_._type"
       });		
    addAnnotation
      (xmlNamespaceDocumentRootEClass, 
       source, 
       new String[] 
       {
       "name", "",
       "kind", "mixed"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_Mixed(), 
       source, 
       new String[] 
       {
       "kind", "elementWildcard",
       "name", ":mixed"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_XMLNSPrefixMap(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xmlns:prefix"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_XSISchemaLocation(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "xsi:schemaLocation"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_Base(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "base",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_Lang(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "lang",
       "namespace", "##targetNamespace"
       });		
    addAnnotation
      (getXMLNamespaceDocumentRoot_Space(), 
       source, 
       new String[] 
       {
       "kind", "attribute",
       "name", "space",
       "namespace", "##targetNamespace"
       });
  }

} //XMLNamespacePackageImpl
