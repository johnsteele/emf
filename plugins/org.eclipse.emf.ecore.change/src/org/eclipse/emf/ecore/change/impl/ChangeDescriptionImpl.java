/**
 * <copyright>
 *
 * Copyright (c) 2003-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ChangeDescriptionImpl.java,v 1.2 2004/04/14 15:26:34 emerks Exp $
 */
package org.eclipse.emf.ecore.change.impl;


import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.ResourceChange;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecore.change.impl.ChangeDescriptionImpl#getObjectChanges <em>Object Changes</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.change.impl.ChangeDescriptionImpl#getObjectsToDetach <em>Objects To Detach</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.change.impl.ChangeDescriptionImpl#getObjectsToAttach <em>Objects To Attach</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.change.impl.ChangeDescriptionImpl#getResourceChanges <em>Resource Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeDescriptionImpl extends EObjectImpl implements ChangeDescription
{
  /**
   * The cached value of the '{@link #getObjectChanges() <em>Object Changes</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectChanges()
   * @generated
   * @ordered
   */
  protected EMap objectChanges = null;

  /**
   * The cached value of the '{@link #getObjectsToDetach() <em>Objects To Detach</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectsToDetach()
   * @generated
   * @ordered
   */
  protected EList objectsToDetach = null;

  /**
   * The cached value of the '{@link #getObjectsToAttach() <em>Objects To Attach</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectsToAttach()
   * @generated
   * @ordered
   */
  protected EList objectsToAttach = null;

  /**
   * The cached value of the '{@link #getResourceChanges() <em>Resource Changes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourceChanges()
   * @generated
   * @ordered
   */
  protected EList resourceChanges = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChangeDescriptionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return ChangePackage.eINSTANCE.getChangeDescription();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMap getObjectChanges()
  {
    if (objectChanges == null)
    {
      objectChanges = new EcoreEMap(ChangePackage.eINSTANCE.getEObjectToChangesMapEntry(), EObjectToChangesMapEntryImpl.class, this, ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES);
    }
    return objectChanges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getObjectsToDetach()
  {
    if (objectsToDetach == null)
    {
      objectsToDetach = new EObjectEList(EObject.class, this, ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH);
    }
    return objectsToDetach;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getObjectsToAttach()
  {
    if (objectsToAttach == null)
    {
      objectsToAttach = new EObjectContainmentEList(EObject.class, this, ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH);
    }
    return objectsToAttach;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getResourceChanges()
  {
    if (resourceChanges == null)
    {
      resourceChanges = new EObjectContainmentEList(ResourceChange.class, this, ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES);
    }
    return resourceChanges;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void apply()
  {
    preApply(false);

    // Apply the change.
    //
    for (Iterator iter = getObjectChanges().iterator(); iter.hasNext(); )
    {
      EObjectToChangesMapEntryImpl entry = (EObjectToChangesMapEntryImpl)iter.next();
      EObject objectToChange = entry.getTypedKey();
      for (Iterator fIter = entry.getTypedValue().iterator(); fIter.hasNext(); )
      {
        FeatureChange featureChange = (FeatureChange)fIter.next();
        featureChange.apply(objectToChange);
      }
    }

    for (Iterator iter = getResourceChanges().iterator(); iter.hasNext(); )
    {
      ResourceChange resourceChange = (ResourceChange)iter.next();
      resourceChange.apply();
    }

    // Delete the change information because it is invalid now that the objects have been changed.
    //
    getObjectsToDetach().clear();
    getObjectsToAttach().clear();
    getObjectChanges().clear();
    getResourceChanges().clear();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void applyAndReverse()
  {
    preApply(true);

    // Flatten and remember the objects to attach list.
    //
    EList oldObjectsToAttach = new BasicEList();
    for (Iterator iter = EcoreUtil.getAllContents(getObjectsToAttach()); iter.hasNext(); )
    {
      oldObjectsToAttach.add(iter.next());
    }

    // Apply the change and reverse the change information.
    //
    for (Iterator iter = getObjectChanges().iterator(); iter.hasNext(); )
    {
      EObjectToChangesMapEntryImpl entry = (EObjectToChangesMapEntryImpl)iter.next();
      EObject objectToChange = entry.getTypedKey();
      for (Iterator fIter = entry.getTypedValue().iterator(); fIter.hasNext(); )
      {
        FeatureChange featureChange = (FeatureChange)fIter.next();
        featureChange.applyAndReverse(objectToChange);
      }
    }
    for (Iterator iter = getResourceChanges().iterator(); iter.hasNext(); )
    {
      ResourceChange resourceChange = (ResourceChange)iter.next();
      resourceChange.applyAndReverse();
    }

    // Reverse the objects to attach and detach lists.
    //
    getObjectsToAttach().clear();
    for (Iterator iter = getObjectsToDetach().iterator(); iter.hasNext(); )
    {
      EObject eObject = (EObject)iter.next();
      if (eObject.eContainer() == null && eObject.eResource() == null)
      {
        getObjectsToAttach().add(eObject);
      }
    }
    getObjectsToDetach().clear();
    getObjectsToDetach().addAll(oldObjectsToAttach);
  }

  protected void preApply(boolean reverse)
  {
    // Make sure the changed values of bi-directional reference lists are cached before we
    //  start to apply the change.
    //
    for (Iterator iter = getObjectChanges().iterator(); iter.hasNext(); )
    {
      EObjectToChangesMapEntryImpl entry = (EObjectToChangesMapEntryImpl)iter.next();
      EObject objectToChange = entry.getTypedKey();
      for (Iterator fIter = entry.getTypedValue().iterator(); fIter.hasNext(); )
      {
        FeatureChange featureChange = (FeatureChange)fIter.next();
        if (featureChange.isSet())
        {
          EStructuralFeature feature = featureChange.getFeature();
          if (feature.isMany() &&
              feature instanceof EReference &&
              ((EReference)feature).getEOpposite() != null)
          {
            if (reverse)
            {
              // This case will be handled special during apply
              //
              EList applyToList = new BasicEList((EList)objectToChange.eGet(feature));
              for (Iterator k = featureChange.getListChanges().iterator(); k.hasNext(); )
              {
                ListChange listChange = (ListChange)k.next();
                listChange.applyAndReverse(applyToList);
              }
              ((FeatureChangeImpl)featureChange).setValue(applyToList); // cache the list value.
            }
            else
            {
              featureChange.getValue(); // cache the list value.
            }
          }
        }
      }
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES:
          return ((InternalEList)getObjectChanges()).basicRemove(otherEnd, msgs);
        case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH:
          return ((InternalEList)getObjectsToAttach()).basicRemove(otherEnd, msgs);
        case ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES:
          return ((InternalEList)getResourceChanges()).basicRemove(otherEnd, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES:
        return getObjectChanges();
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH:
        return getObjectsToDetach();
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH:
        return getObjectsToAttach();
      case ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES:
        return getResourceChanges();
    }
    return eDynamicGet(eFeature, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(EStructuralFeature eFeature, Object newValue)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES:
        getObjectChanges().clear();
        getObjectChanges().addAll((Collection)newValue);
        return;
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH:
        getObjectsToDetach().clear();
        getObjectsToDetach().addAll((Collection)newValue);
        return;
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH:
        getObjectsToAttach().clear();
        getObjectsToAttach().addAll((Collection)newValue);
        return;
      case ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES:
        getResourceChanges().clear();
        getResourceChanges().addAll((Collection)newValue);
        return;
    }
    eDynamicSet(eFeature, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES:
        getObjectChanges().clear();
        return;
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH:
        getObjectsToDetach().clear();
        return;
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH:
        getObjectsToAttach().clear();
        return;
      case ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES:
        getResourceChanges().clear();
        return;
    }
    eDynamicUnset(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case ChangePackage.CHANGE_DESCRIPTION__OBJECT_CHANGES:
        return objectChanges != null && !objectChanges.isEmpty();
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_DETACH:
        return objectsToDetach != null && !objectsToDetach.isEmpty();
      case ChangePackage.CHANGE_DESCRIPTION__OBJECTS_TO_ATTACH:
        return objectsToAttach != null && !objectsToAttach.isEmpty();
      case ChangePackage.CHANGE_DESCRIPTION__RESOURCE_CHANGES:
        return resourceChanges != null && !resourceChanges.isEmpty();
    }
    return eDynamicIsSet(eFeature);
  }

} //ChangeDescriptionImpl
